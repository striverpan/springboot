package com.pan.panspringboot.common.exception;


import com.pan.panspringboot.common.result.ResultEnum;

/*
  @author pan
  程序通用异常
 */
public class GeneralException extends RuntimeException {

    private ResultEnum resultEnum;

    public ResultEnum getresultEnum() {
        return resultEnum;
    }

    public GeneralException(Throwable cause, ResultEnum resultEnum) {
        super(cause);
        this.resultEnum = resultEnum;
    }


    public GeneralException(String message, Throwable cause, ResultEnum resultEnum) {
        super(message, cause);
        this.resultEnum = resultEnum;
    }

}
