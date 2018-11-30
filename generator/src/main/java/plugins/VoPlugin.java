package plugins;

import com.google.common.collect.Lists;
import freemarker.cache.FileTemplateLoader;
import freemarker.template.Configuration;
import freemarker.template.Template;
import org.mybatis.generator.api.IntrospectedColumn;
import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.PluginAdapter;
import org.mybatis.generator.api.dom.java.TopLevelClass;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import plugins.utils.TableEntity;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class VoPlugin extends PluginAdapter {

    private static List<String> defaultColumnNames = Lists.newArrayList("createUserId", "modifyUserId", "version");

    private static final Logger logger = LoggerFactory.getLogger(DtoPlugin.class);

    @Override
    public boolean validate(List<String> warnings) {
        return true;
    }


    @Override
    public boolean modelBaseRecordClassGenerated(TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {
        try {
            generateDto(topLevelClass, introspectedTable);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return super.modelBaseRecordClassGenerated(topLevelClass, introspectedTable);
    }

    private void generateDto(TopLevelClass topLevelClass, IntrospectedTable introspectedTable) throws Exception {
        final String packageName = getProperties().getProperty("packageName");

        List<String> imports = topLevelClass.getImportedTypes().stream()
                .filter(t -> !t.getFullyQualifiedName().startsWith("lombok"))
                .filter(t -> !t.getFullyQualifiedName().equals("com.cloud.mvc.example.general.supers.BaseEntity"))
                .map(t -> t.getFullyQualifiedName())
                .collect(toList());

        List<IntrospectedColumn> columns = introspectedTable.getAllColumns()
                .stream()
                .filter(t -> !defaultColumnNames.contains(t.getJavaProperty()))
                .collect(toList());


        final String className = topLevelClass.getType().getShortName().concat("Vo");
        TableEntity entity = new TableEntity();
        entity.setClassName(className);
        entity.setPackageName(packageName);
        entity.setColumns(columns);
        entity.setImports(imports);

        Configuration configuration = new Configuration(Configuration.DEFAULT_INCOMPATIBLE_IMPROVEMENTS);
        FileTemplateLoader loader = new FileTemplateLoader(new File(getProperties().getProperty("dto.template.path")));
        configuration.setTemplateLoader(loader);
        Template template = configuration.getTemplate(getProperties().getProperty("file.name"), "UTF-8");
        template.process(entity, new OutputStreamWriter(new FileOutputStream(getProperties().getProperty("dto.out.path") + "\\" + className + ".java")));
    }
}
