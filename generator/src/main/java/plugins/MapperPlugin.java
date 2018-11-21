package plugins;

import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.PluginAdapter;
import org.mybatis.generator.api.dom.java.FullyQualifiedJavaType;
import org.mybatis.generator.api.dom.java.Interface;
import org.mybatis.generator.api.dom.java.TopLevelClass;

import java.util.List;

/**
 * 添加mapper接口的继承，和泛型支持
 */
public class MapperPlugin extends PluginAdapter {



    public boolean validate(List<String> warnings) {
        return true;
    }


    @Override
    public boolean modelBaseRecordClassGenerated(TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {
        String baseInterfaceName = getProperties().getProperty("baseEntityName");
        FullyQualifiedJavaType fqjt = new FullyQualifiedJavaType(baseInterfaceName);
        FullyQualifiedJavaType imp = new FullyQualifiedJavaType(
                baseInterfaceName);
        topLevelClass.setSuperClass(fqjt);
        topLevelClass.addImportedType(imp);
        return true;
    }

    /**
     * 生成dao
     */
    @Override
    public boolean clientGenerated(Interface interfaze,
                                   TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {
        String baseInterfaceName = getProperties().getProperty("baseInterfaceName");
        FullyQualifiedJavaType fqjt = new FullyQualifiedJavaType(baseInterfaceName + "<"
                + introspectedTable.getBaseRecordType() + ","
                + introspectedTable.getExampleType() + ">");
        FullyQualifiedJavaType imp = new FullyQualifiedJavaType(
                baseInterfaceName);
        /**
         * 添加 extends MybatisBaseMapper
         */
        interfaze.addSuperInterface(fqjt);

        /**
         * 添加import
         */
        interfaze.addImportedType(imp);

        /**
         * 方法不需要
         */
        interfaze.getMethods().clear();
        interfaze.getAnnotations().clear();
        return true;
    }

}
