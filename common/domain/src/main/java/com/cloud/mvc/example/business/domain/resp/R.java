package com.cloud.mvc.example.business.domain.resp;


import com.cloud.mvc.example.business.domain.exceptions.InternalServerException;
import com.google.common.base.Strings;
import io.swagger.models.auth.In;
import io.vavr.API;
import io.vavr.control.Try;
import lombok.Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Optional;

import static io.vavr.API.$;
import static io.vavr.API.Case;
import static io.vavr.Patterns.$Failure;
import static io.vavr.Patterns.$Success;

/**
 * 内部服务返回对象
 * @param <T>
 */
@Data
@SuppressWarnings("all")
public class R<T> {

    private static final Logger logger = LoggerFactory.getLogger(R.class);

    T data;
    Throwable throwable;//内部服务的接口出现异常都会抛出‘内部服务异常’
    boolean success;
    String errorMessage;


    public static <T> R success(T data){
        R r = new R();
        r.success = true;
        r.throwable = null;
        r.data = data;
        r.errorMessage = null;
        return r;
    }



    public static <T> R fail(Throwable throwable){
//        logger.error("内部接口调用发生异常：", throwable);
        R r = new R();
        r.success = false;
//        r.throwable = throwable;//主动返回异常时，真正的异常对客户端不可见，只能在服务端进行查看日志获取
        r.data = null;
        r.errorMessage = throwable.getMessage();
        return r;
    }

    public static <T> R from(Try tryFunction){

        return API.Match(tryFunction)
                .of(
                        Case($Success($()), a -> R.success(a)),
                        Case($Failure($()), b -> R.fail(b))
                );
    }

    /**
     * 在客户端端调用该方法
     * @return
     */
    public Optional<InternalServerException> getRuntimeException(){
        if(!this.isSuccess()){
            return Optional.of(InternalServerException.instance(this.getErrorMessage()));
        }
        return Optional.empty();
    }



}
