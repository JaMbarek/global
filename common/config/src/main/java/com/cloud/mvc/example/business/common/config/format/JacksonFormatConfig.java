package com.cloud.mvc.example.business.common.config.format;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalTimeSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.TimeZone;

@Configuration
public class JacksonFormatConfig {

    @Bean
    public ObjectMapper getObjectMapper() {
        ObjectMapper om = new ObjectMapper();
        JavaTimeModule javaTimeModule = new JavaTimeModule();

        javaTimeModule.addSerializer(LocalDateTime.class, new LocalDateTimeSerializer(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        javaTimeModule.addSerializer(LocalDate.class, new LocalDateSerializer(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
        javaTimeModule.addSerializer(LocalTime.class, new LocalTimeSerializer(DateTimeFormatter.ofPattern("HH:mm:ss")));
        om.registerModule(javaTimeModule);
        om.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
        om.setTimeZone(TimeZone.getDefault());
        om.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);

        om.configure(JsonGenerator.Feature.WRITE_NUMBERS_AS_STRINGS, false);
        om.configure(JsonGenerator.Feature.QUOTE_NON_NUMERIC_NUMBERS, false);
        om.configure(JsonGenerator.Feature.WRITE_BIGDECIMAL_AS_PLAIN, true);


        //转换BigDecimal 科学计算法展示
        final SimpleModule bigDecimalModule = new SimpleModule();
        bigDecimalModule.addSerializer(BigDecimal.class, new BigDecimalSerializer());
        om.registerModule(bigDecimalModule);


        //忽略掉不存在的字段
        om.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        return om;
    }


    public static class BigDecimalSerializer extends JsonSerializer<BigDecimal> {

        @Override
        public void serialize(BigDecimal value, JsonGenerator gen, SerializerProvider serializers) throws IOException, JsonProcessingException {
            gen.writeString(value.stripTrailingZeros().toPlainString());
        }
    }


}
