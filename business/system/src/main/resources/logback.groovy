import ch.qos.logback.classic.filter.ThresholdFilter

import java.nio.charset.Charset


def userHome = System.getProperty("user.home")
def appName = "system"

appender("CONSOLE", ConsoleAppender) {
    encoder(PatternLayoutEncoder) {
        pattern = "%date [%thread] %highlight(%-5level) %logger{80} - %cyan(%msg%n)"
        charset = Charset.forName("utf8")
    }
}


appender("dailyRollingFileAppender", RollingFileAppender) {
    file = "${userHome}/logs/${appName}"
    rollingPolicy(TimeBasedRollingPolicy) {
        fileNamePattern = "${appName}.%d{yyyy-MM-dd}.log"
        maxHistory = 30
    }
    filter(ThresholdFilter) {
        level = ERROR
    }
    encoder(PatternLayoutEncoder) {
        pattern = "%d{HH:mm:ss.SSS} [%thread] %-5level %logger{35} - %msg %n"
    }
}

root(DEBUG, ["CONSOLE", "dailyRollingFileAppender"])

logger("org.springframework.web", ERROR)
logger("org.springframework.core", ERROR)
logger("org.springframework.beans", ERROR)
logger("org.springframework.boot.autoconfigure", ERROR)
logger("org.apache.http", ERROR)
logger("com.netflix", ERROR)
logger("org.netflix", ERROR)
logger("org.springframework.jmx", ERROR)
logger("org.hibernate.validator", ERROR)
logger("io.netty", ERROR)
logger("org.synchronoss.cloud", ERROR)
logger("org.springframework.cloud", ERROR)
logger("org.springframework.context", ERROR)
logger("org.springframework.test", ERROR)
logger("com.zaxxer.hikari", ERROR)
logger("org.springframework.data", ERROR)
logger("org.springframework.boot.test", ERROR)
logger("reactor", ERROR)

logger("com.cloud.mvc.example.business", DEBUG)
logger("java.sql.Connection", DEBUG)
logger("java.sql.Statement", DEBUG)
logger("java.sql.PreparedStatement", DEBUG)
logger("io.swagger.models.parameters.AbstractSerializableParameter", ERROR)//在访问swagger-ui时会报错，据说是官方bug，这里先调整日志级别
logger("com.ctrip.framework.apollo.internals", ERROR)


