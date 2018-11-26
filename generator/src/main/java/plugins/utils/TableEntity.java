package plugins.utils;

import lombok.Data;
import org.mybatis.generator.api.IntrospectedColumn;
import org.mybatis.generator.api.dom.java.Field;

import java.util.List;

@Data
public class TableEntity {

    private String packageName;
    private String className;
    private List<IntrospectedColumn> columns;
    private List<String> imports;
}
