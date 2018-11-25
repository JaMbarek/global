import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;

import java.util.ArrayList;

public class Starter {


    public static void main(String[] args) throws Exception {

        ConfigurationParser configurationParser = new ConfigurationParser(new ArrayList<>());
        Configuration configuration = configurationParser.parseConfiguration(Starter.class.getResourceAsStream("/generatorConfig.xml"));
        MyBatisGenerator generator = new MyBatisGenerator(configuration, null, new ArrayList<>());
        generator.generate(null);


    }

}
