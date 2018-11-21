package plugins;

import org.mybatis.generator.api.dom.java.FullyQualifiedJavaType;
import org.mybatis.generator.internal.types.JavaTypeResolverDefaultImpl;

import java.sql.Types;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * 自定义类型转换
 */
public class CustomJavaTypeResolverDefaultImpl extends JavaTypeResolverDefaultImpl {


    public CustomJavaTypeResolverDefaultImpl() {
        super();
        typeMap.put(Types.DATE, new JdbcTypeInformation("DATE", //$NON-NLS-1$
                new FullyQualifiedJavaType(LocalDateTime.class.getName())));
        typeMap.put(Types.TIMESTAMP, new JdbcTypeInformation("TIMESTAMP", //$NON-NLS-1$
                new FullyQualifiedJavaType(LocalDateTime.class.getName())));
        typeMap.put(Types.TIME, new JdbcTypeInformation("TIME", //$NON-NLS-1$
                new FullyQualifiedJavaType(LocalDateTime.class.getName())));
    }
}
