package com.cloud.mvc.example.business.common.config.mybatis.interceptor;

import com.google.gson.Gson;
import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.plugin.*;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.SystemMetaObject;
import org.apache.ibatis.session.ResultHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.lang.reflect.Proxy;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.Properties;
import java.util.UUID;

import static com.cloud.mvc.example.business.common.constants.CacheKeyConstants.DEV_SQL_EXECUTE_LOG;


@Component
@Intercepts({
        @Signature(type = StatementHandler.class, method = "query", args = {Statement.class, ResultHandler.class}),
        @Signature(type = StatementHandler.class, method = "batch", args = {Statement.class})
})
public class PerformaceInterceptor implements Interceptor {


    @Resource
    HashOperations hashOperations;

    @Value("${service.name}")
    private String serviceName;

    private static final Logger logger = LoggerFactory.getLogger(PerformaceInterceptor.class);

    private static final Long timeout = 1000L;//ms

    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        Statement statement = getStatementFromInvocation(invocation);

        MetaObject metaObject = SystemMetaObject.forObject(statement);

        String sql = (String) metaObject.getValue("sql");

        Object parameters = metaObject.getValue("stmt.parameters");

        final Long start = System.currentTimeMillis();
        Object res = invocation.proceed();
        Long executeTime = System.currentTimeMillis() - start;

        if (executeTime.compareTo(timeout) > 0) {
            logger.warn("sql：{}，参数：{}，执行时间：{}", sql, new Gson().toJson(parameters), executeTime);
            SqlPerformanceLog log = new SqlPerformanceLog();
            log.setServiceName(serviceName);
            log.setMillSeconds(executeTime);
            log.setSql(sql.replaceAll("\r|\n", " "));
            log.setArgs(new Gson().toJson(parameters));
            log.setCreateDate(LocalDateTime.now());
            hashOperations.put(DEV_SQL_EXECUTE_LOG, UUID.randomUUID().toString().replace("-", ""), log);
        }


        return res;
    }

    @Override
    public Object plugin(Object target) {
        if (target instanceof StatementHandler) {
            return Plugin.wrap(target, this);
        }
        return target;
    }


    private Statement getStatementFromInvocation(Invocation invocation) {
        Statement statement;
        Object firstArg = invocation.getArgs()[0];
        if (Proxy.isProxyClass(firstArg.getClass())) {
            statement = (Statement) SystemMetaObject.forObject(firstArg).getValue("h.statement");
        } else {
            statement = (Statement) firstArg;
        }
        return statement;
    }

    @Override
    public void setProperties(Properties properties) {

    }
}
