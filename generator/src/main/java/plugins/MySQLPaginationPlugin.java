package plugins;

import org.mybatis.generator.api.*;
import org.mybatis.generator.api.dom.java.*;
import org.mybatis.generator.api.dom.xml.Attribute;
import org.mybatis.generator.api.dom.xml.TextElement;
import org.mybatis.generator.api.dom.xml.XmlElement;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 生成分页
 * 加入in的数量控制
 */
public class MySQLPaginationPlugin extends PluginAdapter {

    private static final String start = "start";
    private static final String limit = "limit";

    private static final String notNullExpression = "start != null and start >= 0";

    private static final String sql = "limit ${start}, ${limit}";

    @Override
    public boolean modelExampleClassGenerated(TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {
        // add field, getter, setter for limit clause
        addLimit(topLevelClass, introspectedTable, start);
        addLimit(topLevelClass, introspectedTable, limit);
        // add the method that get the only Criteria
        addCriteriaGetter(topLevelClass, introspectedTable);
        return super.modelExampleClassGenerated(topLevelClass, introspectedTable);
    }

    @Override
    public boolean sqlMapSelectByExampleWithoutBLOBsElementGenerated(XmlElement element, IntrospectedTable introspectedTable) {
        XmlElement isNotNullElement = new XmlElement("if"); //$NON-NLS-1$
        isNotNullElement.addAttribute(new Attribute("test", notNullExpression)); //$NON-NLS-1$ //$NON-NLS-2$
        isNotNullElement.addElement(new TextElement(sql));
        element.addElement(isNotNullElement);
        return super.sqlMapUpdateByExampleWithoutBLOBsElementGenerated(element, introspectedTable);
    }

    @Override
    public boolean sqlMapSelectByExampleWithBLOBsElementGenerated(XmlElement element, IntrospectedTable introspectedTable) {
        XmlElement isNotNullElement = new XmlElement("if"); //$NON-NLS-1$
        isNotNullElement.addAttribute(new Attribute("test", notNullExpression)); //$NON-NLS-1$ //$NON-NLS-2$
        isNotNullElement.addElement(new TextElement(sql));
        element.addElement(isNotNullElement);
        return super.sqlMapUpdateByExampleWithoutBLOBsElementGenerated(element, introspectedTable);
    }

    @Override
    public boolean modelGetterMethodGenerated(Method method, TopLevelClass topLevelClass, IntrospectedColumn introspectedColumn,
                                              IntrospectedTable introspectedTable, Plugin.ModelClassType modelClassType) {

        return super.modelGetterMethodGenerated(method, topLevelClass, introspectedColumn, introspectedTable, modelClassType);
    }

    private void addLimit(TopLevelClass topLevelClass, IntrospectedTable introspectedTable, String name) {
        CommentGenerator commentGenerator = context.getCommentGenerator();
        Field field = new Field();
        field.setVisibility(JavaVisibility.PROTECTED);
        field.setType(FullyQualifiedJavaType.getIntInstance());
        field.setName(name);
        field.setInitializationString("-1");
        commentGenerator.addFieldComment(field, introspectedTable);
        topLevelClass.addField(field);
        char c = name.charAt(0);
        String camel = Character.toUpperCase(c) + name.substring(1);
        Method method = new Method();

        method.setVisibility(JavaVisibility.PUBLIC);
        method.setName(name);
        method.setReturnType(topLevelClass.getType());
        method.addParameter(new Parameter(FullyQualifiedJavaType.getIntInstance(), name));
        method.addBodyLine("this." + name + "=" + name + ";");
        method.addBodyLine("return this;");
        commentGenerator.addGeneralMethodComment(method, introspectedTable);

        topLevelClass.addMethod(method);
        method = new Method();
        method.setVisibility(JavaVisibility.PUBLIC);
        method.setReturnType(FullyQualifiedJavaType.getIntInstance());
        method.setName("get" + camel);
        method.addBodyLine("return " + name + ";");
        commentGenerator.addGeneralMethodComment(method, introspectedTable);
        topLevelClass.addMethod(method);
    }

    private void addCriteriaGetter(TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {
        CommentGenerator commentGenerator = context.getCommentGenerator();
        Method method = new Method();
        method.setVisibility(JavaVisibility.PUBLIC);
        method.setName("getCriteria");
        method.setReturnType(new FullyQualifiedJavaType("Criteria"));
        method.addBodyLine("if (oredCriteria.size() != 0) {return oredCriteria.get(0);}");
        method.addBodyLine("Criteria criteria = createCriteriaInternal();");
        method.addBodyLine("oredCriteria.add(criteria);");
        method.addBodyLine("return criteria;");
        commentGenerator.addGeneralMethodComment(method, introspectedTable);
        topLevelClass.addMethod(method);


        Method create = new Method();
        create.setVisibility(JavaVisibility.PUBLIC);
        create.setStatic(true);
        create.setName("create");
        create.setReturnType(topLevelClass.getType());
        create.addBodyLine("return new " + topLevelClass.getType().getShortName() + "();");

        commentGenerator.addGeneralMethodComment(create, introspectedTable);
        topLevelClass.addMethod(create);


        topLevelClass.getMethods()
                .stream()
                .filter(t -> t.getName().equals("clear"))
                .forEach(t -> {
                    t.addBodyLine(3, "this." + start + " = -1;");
                    t.addBodyLine(4, "this." + limit + " = -1;");
                });
        //限制in的查询个数
        topLevelClass.getInnerClasses().stream()
                .filter(t -> t.getType().getShortName().equals("GeneratedCriteria"))
                .findFirst()
                .ifPresent(t -> {
                    t.getMethods().stream()
                            .filter(a -> a.getName().toLowerCase().contains("and") && a.getName().toLowerCase().contains("id") && a.getName().toLowerCase().contains("in"))
                            .forEach(a -> {
                                String parameterName = a.getParameters().get(0).getName();
                                a.addBodyLine(1, "if (" + parameterName + ".size() > 2000){");
                                a.addBodyLine(2, "  throw new RuntimeException(\"" + parameterName + " size to long ,please change batch method\");");
                                a.addBodyLine(3, "}");
                            });
                });
        //添加likeboth方法
        topLevelClass.getInnerClasses().stream()
                .filter(t -> t.getType().getShortName().equals("GeneratedCriteria"))
                .findFirst()
                .ifPresent(t -> {
                    List<Method> likeMethods = t.getMethods().stream().filter(a -> a.getName().toLowerCase().contains("like") && a.getName().toLowerCase().contains("and"))
                            .collect(Collectors.toList());
                    likeMethods.stream().map(a -> {
                        Method method1 = new Method(a);
                        method1.setName(method1.getName() + "Both");
                        String name = method1.getParameters().get(0).getName();
                        method1.addBodyLine(0, "if(" + name + " != null){");
                        method1.addBodyLine(1, name + " = \"%\" + " + name + " + \"%\";");
                        method1.addBodyLine(2, "}");
                        return method1;
                    }).forEach(a -> t.addMethod(a));
                });

    }

    @Override
    public boolean validate(List<String> arg0) {
        // TODO Auto-generated method stub
        return true;
    }


}
