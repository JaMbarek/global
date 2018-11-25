package plugins;

import org.mybatis.generator.api.IntrospectedColumn;
import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.PluginAdapter;
import org.mybatis.generator.api.dom.java.*;
import org.mybatis.generator.api.dom.xml.Attribute;
import org.mybatis.generator.api.dom.xml.Document;
import org.mybatis.generator.api.dom.xml.TextElement;
import org.mybatis.generator.api.dom.xml.XmlElement;
import org.mybatis.generator.codegen.mybatis3.ListUtilities;
import org.mybatis.generator.codegen.mybatis3.MyBatis3FormattingUtilities;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * inspire  https://gitee.com/whan0216/mybatis-generator-plugin.git
 */
public class BatchInsertPlugin extends PluginAdapter {

    private static final String BATCH_INSERT_METHOD = "batchInsert";
    private static final String BATCH_INSERT_SELECT_METHOD = "batchInsertSelective";

    private static final Logger logger = LoggerFactory.getLogger(BatchInsertPlugin.class);

    @Override
    public boolean clientGenerated(Interface interfaze, TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {
        // 1. batchInsert
        Method mBatchInsert = new Method(BATCH_INSERT_METHOD);
        mBatchInsert.setReturnType(FullyQualifiedJavaType.getIntInstance());
        // 添加参数
        FullyQualifiedJavaType tList = FullyQualifiedJavaType.getNewListInstance();
        tList.addTypeArgument(introspectedTable.getRules().calculateAllFieldsClass());
        mBatchInsert.addParameter(new Parameter(tList, "list", "@Param(\"list\")"));
        // 添加方法说明
        mBatchInsert.addJavaDocLine("/**"); //$NON-NLS-1$
        mBatchInsert.addJavaDocLine(" * batch insert method generator");
        mBatchInsert.addJavaDocLine(" */"); //$NON-NLS-1$
        // interface 增加方法
        interfaze.addMethod(mBatchInsert);

        // 2. batchInsertSelective
        Method mBatchInsertSelective = new Method(BATCH_INSERT_SELECT_METHOD);
        mBatchInsertSelective.setReturnType(FullyQualifiedJavaType.getIntInstance());
        // 添加参数
        FullyQualifiedJavaType tSelective = new FullyQualifiedJavaType(introspectedTable.getRules().calculateAllFieldsClass().getShortName()+"."+ModelColumnPlugin.ENUM_NAME);
        mBatchInsertSelective.addParameter(new Parameter(tList, "list", "@Param(\"list\")"));
        mBatchInsertSelective.addParameter(new Parameter(tSelective, "selective", "@Param(\"selective\")", true));
        // 添加方法说明
        mBatchInsertSelective.addJavaDocLine("/**"); //$NON-NLS-1$
        mBatchInsertSelective.addJavaDocLine(" * batch insert selective method generator");
        mBatchInsertSelective.addJavaDocLine(" */"); //$NON-NLS-1$
        // interface 增加方法
        interfaze.addMethod(mBatchInsertSelective);

        return true;
    }

    @Override
    public boolean sqlMapDocumentGenerated(Document document, IntrospectedTable introspectedTable) {
        // 1. batchInsert
        XmlElement batchInsertEle = new XmlElement("insert");
        batchInsertEle.addAttribute(new Attribute("id", BATCH_INSERT_METHOD));
        // 参数类型
        batchInsertEle.addAttribute(new Attribute("parameterType", "map"));
        // 添加注释(!!!必须添加注释，overwrite覆盖生成时，@see XmlFileMergerJaxp.isGeneratedNode会去判断注释中是否存在OLD_ELEMENT_TAGS中的一点，例子：@mbg.generated)
        CommentTools.addComment(batchInsertEle);

        // 使用JDBC的getGenereatedKeys方法获取主键并赋值到keyProperty设置的领域模型属性中。所以只支持MYSQL和SQLServer
        CommTools.useGeneratedKeys(batchInsertEle, introspectedTable);

        StringBuilder insertClause = new StringBuilder();
        StringBuilder valuesClause = new StringBuilder();

        insertClause.append("insert into "); //$NON-NLS-1$
        insertClause.append(introspectedTable.getFullyQualifiedTableNameAtRuntime());
        insertClause.append(" ("); //$NON-NLS-1$

        valuesClause.append(" ("); //$NON-NLS-1$

        List<String> valuesClauses = new ArrayList<String>();
        List<IntrospectedColumn> columns = ListUtilities.removeIdentityAndGeneratedAlwaysColumns(introspectedTable.getAllColumns());
        for (int i = 0; i < columns.size(); i++) {
            IntrospectedColumn introspectedColumn = columns.get(i);

            insertClause.append(MyBatis3FormattingUtilities.getEscapedColumnName(introspectedColumn));

            // 生成foreach下插入values
            valuesClause.append(MyBatis3FormattingUtilities.getParameterClause(introspectedColumn, "item."));
            if (i + 1 < columns.size()) {
                insertClause.append(", "); //$NON-NLS-1$
                valuesClause.append(", "); //$NON-NLS-1$
            }
        }

        insertClause.append(')');
        batchInsertEle.addElement(new TextElement(insertClause.toString()));

        valuesClause.append(')');
        valuesClauses.add(valuesClause.toString());


        // 添加foreach节点
        XmlElement foreachElement = new XmlElement("foreach");
        foreachElement.addAttribute(new Attribute("collection", "list"));
        foreachElement.addAttribute(new Attribute("item", "item"));
        foreachElement.addAttribute(new Attribute("separator", ","));

        for (String clause : valuesClauses) {
            foreachElement.addElement(new TextElement(clause));
        }

        // values 构建
        batchInsertEle.addElement(new TextElement("values"));
        batchInsertEle.addElement(foreachElement);
        if (context.getPlugins().sqlMapInsertElementGenerated(batchInsertEle, introspectedTable)) {
            document.getRootElement().addElement(batchInsertEle);
            logger.debug("itfsw(批量插入插件):" + introspectedTable.getMyBatis3XmlMapperFileName() + "增加batchInsert实现方法。");
        }

        // 2. batchInsertSelective
        XmlElement element = new XmlElement("insert");
        element.addAttribute(new Attribute("id", BATCH_INSERT_SELECT_METHOD));
        // 参数类型
        element.addAttribute(new Attribute("parameterType", "map"));
        // 添加注释(!!!必须添加注释，overwrite覆盖生成时，@see XmlFileMergerJaxp.isGeneratedNode会去判断注释中是否存在OLD_ELEMENT_TAGS中的一点，例子：@mbg.generated)
        CommentTools.addComment(element);

        // 使用JDBC的getGenereatedKeys方法获取主键并赋值到keyProperty设置的领域模型属性中。所以只支持MYSQL和SQLServer
        CommTools.useGeneratedKeys(element, introspectedTable);

        element.addElement(new TextElement("insert into "+introspectedTable.getFullyQualifiedTableNameAtRuntime()+" ("));

        XmlElement foreachInsertColumns = new XmlElement("foreach");
        foreachInsertColumns.addAttribute(new Attribute("collection", "selective"));
        foreachInsertColumns.addAttribute(new Attribute("item", "column"));
        foreachInsertColumns.addAttribute(new Attribute("separator", ","));
        foreachInsertColumns.addElement(new TextElement("${column.value}"));

        element.addElement(foreachInsertColumns);

        element.addElement(new TextElement(")"));

        // values
        element.addElement(new TextElement("values"));

        // foreach values
        XmlElement foreachValues = new XmlElement("foreach");
        foreachValues.addAttribute(new Attribute("collection", "list"));
        foreachValues.addAttribute(new Attribute("item", "item"));
        foreachValues.addAttribute(new Attribute("separator", ","));

        foreachValues.addElement(new TextElement("("));

        // foreach 所有插入的列，比较是否存在
        XmlElement foreachInsertColumnsCheck = new XmlElement("foreach");
        foreachInsertColumnsCheck.addAttribute(new Attribute("collection", "selective"));
        foreachInsertColumnsCheck.addAttribute(new Attribute("item", "column"));
        foreachInsertColumnsCheck.addAttribute(new Attribute("separator", ","));

        // 所有表字段
        List<IntrospectedColumn> columns1 = ListUtilities.removeIdentityAndGeneratedAlwaysColumns(introspectedTable.getAllColumns());
        for (int i = 0; i < columns1.size(); i++) {
            IntrospectedColumn introspectedColumn = columns.get(i);
            XmlElement check = new XmlElement("if");
            check.addAttribute(new Attribute("test", "'"+introspectedColumn.getActualColumnName()+"' == column.value"));
            check.addElement(new TextElement(MyBatis3FormattingUtilities.getParameterClause(introspectedColumn, "item.")));

            foreachInsertColumnsCheck.addElement(check);
        }
        foreachValues.addElement(foreachInsertColumnsCheck);

        foreachValues.addElement(new TextElement(")"));

        element.addElement(foreachValues);

        if (context.getPlugins().sqlMapInsertElementGenerated(element, introspectedTable)) {
            document.getRootElement().addElement(element);
            logger.debug("itfsw(批量插入插件):" + introspectedTable.getMyBatis3XmlMapperFileName() + "增加batchInsertSelective实现方法。");
        }

        return true;
    }

    @Override
    public boolean validate(List<String> warnings) {
        return true;
    }
}
