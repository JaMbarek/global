import ch.qos.logback.classic.filter.ThresholdFilter

import java.nio.charset.Charset


def userHome = System.getProperty("user.home")
def appName = "system"

appender("CONSOLE", ConsoleAppender) {
    encoder(PatternLayoutEncoder) {
        pattern = "%red(%date) [%thread] %highlight(%-5level) %boldMagenta(%logger{80}) - %cyan(%msg%n)"
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
logger("com.netflix.discovery", ERROR)
logger("org.springframework.jmx", ERROR)
logger("org.hibernate.validator", ERROR)
logger("io.netty", ERROR)
logger("org.synchronoss.cloud", ERROR)
logger("org.springframework.cloud", ERROR)
logger("org.springframework.context", ERROR)

logger("com.cloud.mvc.example.business", DEBUG)


