package com.cloud.mvc.example.business.common.config.mybatis.interceptor;

import net.sf.jsqlparser.JSQLParserException;
import net.sf.jsqlparser.expression.JdbcParameter;
import net.sf.jsqlparser.expression.LongValue;
import net.sf.jsqlparser.expression.operators.conditional.AndExpression;
import net.sf.jsqlparser.expression.operators.relational.EqualsTo;
import net.sf.jsqlparser.parser.CCJSqlParserUtil;
import net.sf.jsqlparser.schema.Column;
import net.sf.jsqlparser.statement.update.Update;
import org.apache.ibatis.binding.MapperMethod;
import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.SqlCommandType;
import org.apache.ibatis.mapping.SqlSource;
import org.apache.ibatis.plugin.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Field;
import java.util.Map;
import java.util.Properties;

/**
 * 版本号更新
 * 防止更新丢失
 *
 * 适用update方法，更新的实体类中如果存在int类型的version字段，并且在更新时设置该字段则累加version
 *
 * @author lxl
 */
@Intercepts({@Signature(type = Executor.class, method = "update", args = {MappedStatement.class, Object.class})})
public class VersionInterceptor implements Interceptor{

    private static final String VERSION = "version";

    private final Logger LOGGER = LoggerFactory.getLogger(getClass());

    private final String paramterName = "param1";

    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        Long start = System.currentTimeMillis();
        Object[] args = invocation.getArgs();
        MappedStatement statement = (MappedStatement) args[0];
        if(SqlCommandType.UPDATE != statement.getSqlCommandType()){
            return invocation.proceed();
        }

        Object paramter = args[1];
        if(paramter instanceof MapperMethod.ParamMap){ //多个参数的情况
            paramter = ((MapperMethod.ParamMap) paramter).get(paramterName);
        }
        boolean isHaveNotNullVersion = isHaveVersionField(paramter);
        if(!isHaveNotNullVersion){
            return invocation.proceed();
        }

        changeUpdateStatement(args, statement, paramter);
//        LOGGER.debug("乐观锁的性能消耗：{}" , (System.currentTimeMillis() - start));
        return invocation.proceed();
    }

    /**
     * 更改当前上下文中的MappedStatement
     * @param args
     * @param statement
     * @param paramter
     */
    private void changeUpdateStatement(Object[] args, MappedStatement statement, Object paramter){
        String sql = statement.getBoundSql(args[1]).getSql();
        final Integer oldVersion = getOldVersion(paramter);
        changeParamterObject(oldVersion, paramter);
        MappedStatement newStatement = newStatement(statement, getNewsQL(sql, oldVersion), statement.getBoundSql(args[1]));
        args[0] = newStatement;
    }

    /**
     * 创建一个新的sql
     * @param oldSql
     * @param oldVersion
     * @return
     */
    private String getNewsQL(String oldSql, Integer oldVersion){
        Integer whereIndex= oldSql.indexOf("where");
        whereIndex = (whereIndex == null || whereIndex == -1) ? oldSql.indexOf("WHERE"):whereIndex;
        final String whereSql = oldSql.substring(whereIndex, oldSql.length());
        if(whereSql.contains(VERSION)){
            return oldSql;
        }
        Update update = null;
        try {
            update = (Update) CCJSqlParserUtil.parse(oldSql);
            boolean isVersionInSql = update.getColumns().stream().filter(a -> a.getColumnName().equals(VERSION)).findAny().isPresent();
            if(!isVersionInSql){
                update.getColumns().add(new Column(VERSION));
                update.getExpressions().add(new JdbcParameter());
            }

            if(oldVersion == 0) {
                EqualsTo equalsTo = new EqualsTo();
                equalsTo.setLeftExpression(new Column(VERSION));
                equalsTo.setRightExpression(new LongValue(0));
                update.setWhere(new AndExpression(update.getWhere(), equalsTo));

            }else{
                EqualsTo equalsTo = new EqualsTo();
                equalsTo.setLeftExpression(new Column(VERSION));
                equalsTo.setRightExpression(new LongValue(oldVersion));
                update.setWhere(new AndExpression(update.getWhere(), equalsTo));
            }

        } catch (JSQLParserException e) {
            throw new RuntimeException(e);
        }
//        LOGGER.debug("乐观锁生效，原生的sql：{}", oldSql);
        return update.toString();
    }

    /**
     * 设置boundsql的additionParameters
     * @param boundSql
     * @param old
     */
    private void setAdditionParameters(BoundSql boundSql, BoundSql old){
        Field f = null;
        try {
            f = old.getClass().getDeclaredField("additionalParameters");
            f.setAccessible(true);
            Map<String, Object> map = (Map<String, Object>) f.get(old);
            map.forEach((k, b) -> boundSql.setAdditionalParameter(k, b));
        } catch (NoSuchFieldException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 创建一个新的MappedStatement
     * @param ms
     * @param sql
     * @param old
     * @return
     */
    private MappedStatement newStatement(MappedStatement ms, String sql, BoundSql old) {
        BoundSql boundSql = new BoundSql(ms.getConfiguration(), sql, old.getParameterMappings(), old.getParameterObject());
        setAdditionParameters(boundSql, old);
        SqlSource sqlSource = new CustomSqlSource(boundSql);
        MappedStatement newStatement = new MappedStatement.Builder(
                ms.getConfiguration(), ms.getId(), sqlSource, ms.getSqlCommandType()
        )
                .statementType(ms.getStatementType())
                .cache(ms.getCache())
                .databaseId(ms.getDatabaseId())
                .fetchSize(ms.getFetchSize())
                .flushCacheRequired(ms.isFlushCacheRequired())
                .keyColumn(ms.getKeyColumns() != null ? ms.getKeyColumns()[0] : null)
                .keyGenerator(ms.getKeyGenerator())
                .keyProperty(ms.getKeyProperties() != null ? ms.getKeyProperties()[0] : null)
                .lang(ms.getLang())
                .parameterMap(ms.getParameterMap())
                .resource(ms.getResource())
                .resultMaps(ms.getResultMaps())
                .resultOrdered(ms.isResultOrdered())
                .timeout(ms.getTimeout())
                .resultSets(ms.getResultSets() != null ? ms.getResultSets()[0] : null)
                .useCache(ms.isUseCache())
                .resultSetType(ms.getResultSetType())
                .build();
        return newStatement;
    }

    /**
     * 反射的方式获取旧的版本号
     * @param paramter
     * @return
     */
    private int getOldVersion(Object paramter) {
        try {
            Field f = paramter.getClass().getDeclaredField(VERSION);
            f.setAccessible(true);
            if(f.get(paramter) == null){
                return 0;
            }
            return (int)f.get(paramter);
        } catch (IllegalAccessException | NoSuchFieldException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 反射的方式修改参数中的version字段，并且累加
     * @param oldVersion
     * @param paramter
     */
    private void changeParamterObject(Integer oldVersion, Object paramter) {
        try {
            Field f = paramter.getClass().getDeclaredField(VERSION);
            f.setAccessible(true);
            f.set(paramter, oldVersion + 1);
        } catch (IllegalAccessException | NoSuchFieldException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 判断是否是合法的版本号
     * @param paramter
     * @return
     */
    private boolean isHaveVersionField(Object paramter) {
        Class clazz = paramter.getClass();
        try{
            Field f = clazz.getDeclaredField(VERSION);
            f.setAccessible(true);
            Object value = f.get(paramter);
            return validateVersionType(value);
        }catch (NoSuchFieldException | IllegalAccessException e){
            return false;
        }
    }

    /**
     * 验证version字段的类型
     * @param value
     * @return
     */
    private boolean validateVersionType(Object value){
        if(value == null) return false;
        if(value.getClass().isAssignableFrom(Integer.class)){
            return true;
        }
        if(int.class.equals(value.getClass())){
            return true;
        }
        return false;
    }

    @Override
    public Object plugin(Object target) {
        if(target instanceof Executor){
            return Plugin.wrap(target, this);
        }
        return target;
    }

    @Override
    public void setProperties(Properties properties) {

    }


    static class CustomSqlSource implements SqlSource {

        private BoundSql sql;

        public CustomSqlSource(BoundSql sql) {
            this.sql = sql;
        }

        @Override
        public BoundSql getBoundSql(Object parameterObject) {
            return sql;
        }
    }
}
