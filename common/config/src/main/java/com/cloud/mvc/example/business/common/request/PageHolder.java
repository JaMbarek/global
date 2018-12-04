package com.cloud.mvc.example.business.common.request;

import lombok.Data;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

@RequestScope
@Data
@Component
public class PageHolder {

    public Integer page;
    public Integer limit;


    public Integer getStart(){
        return (page - 1) * getLimit();
    }

}
