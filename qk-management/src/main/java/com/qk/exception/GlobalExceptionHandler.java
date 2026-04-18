package com.qk.exception;

import com.qk.common.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice   //标记异常处理类，拦截所有controller层抛出的异常
public class GlobalExceptionHandler {

    //处理异常
    @ExceptionHandler(Exception.class)  //异常处理器，标记这是异常处理方法，指定要处理的异常类型
    public Result handleEx(Exception e) {   //形参列表指定要处理的异常类型
        log.error("服务器发生异常", e);
        //捕获异常之后，响应一个标准的Result
        return Result.error("操作失败，请联系管理员");
    }
}
