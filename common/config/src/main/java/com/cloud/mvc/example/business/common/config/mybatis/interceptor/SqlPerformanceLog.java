package com.cloud.mvc.example.business.common.config.mybatis.interceptor;

import java.time.LocalDateTime;

public class SqlPerformanceLog {

    private String serviceName;
    private String sql;
    private Long millSeconds;
    private Object args;
    private LocalDateTime createDate;

    public LocalDateTime getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDateTime createDate) {
        this.createDate = createDate;
    }

    public Object getArgs() {
        return args;
    }

    public void setArgs(Object args) {
        this.args = args;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getSql() {
        return sql;
    }

    public void setSql(String sql) {
        this.sql = sql;
    }

    public Long getMillSeconds() {
        return millSeconds;
    }

    public void setMillSeconds(Long millSeconds) {
        this.millSeconds = millSeconds;
    }
}
