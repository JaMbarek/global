package com.cloud.mvc.example.business.common.config.format;

import com.alibaba.fastjson.serializer.JSONSerializer;
import com.alibaba.fastjson.serializer.ObjectSerializer;
import com.alibaba.fastjson.serializer.SerializeConfig;
import com.alibaba.fastjson.serializer.SerializeWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;
import java.lang.reflect.Type;
import java.math.BigDecimal;

@Configuration
public class FastJsonConfiguration {


    @Bean
    public BigDecimalSerialize bigDecimalSerializeFilter(){
        BigDecimalSerialize bigDecimalSerialize = new BigDecimalSerialize();
        SerializeConfig.getGlobalInstance() //
                .put(BigDecimal.class,bigDecimalSerialize);
        return bigDecimalSerialize;
    }




    public static class  BigDecimalSerialize implements ObjectSerializer {
        @Override
        public void write(JSONSerializer serializer, Object object, Object fieldName, Type fieldType, int features) throws IOException {
            final SerializeWriter out = serializer.out;
            BigDecimal bigDecimal = (BigDecimal) object;
            out.write(bigDecimal.stripTrailingZeros().toPlainString());
        }
    }



}
