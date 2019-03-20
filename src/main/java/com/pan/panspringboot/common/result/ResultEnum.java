package com.pan.panspringboot.common.result;

public enum ResultEnum {


    SUCCESS(200,"操作成功"),
    OPERATION_FAILED(-1,"操作失败");


    private Integer code;
    private String message;

    ResultEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public Integer getCode() {
        return code;
    }


}
