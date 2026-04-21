package com.qk.exception;

/**
 * 自定义异常
 */
public class BusinessException extends RuntimeException{
    public BusinessException(){
    }

    public BusinessException(String msg) {
        super(msg);
    }
}
