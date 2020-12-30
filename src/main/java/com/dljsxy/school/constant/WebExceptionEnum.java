/*
 * Copyright (C) 2019 Baidu, Inc. All Rights Reserved.
 */

package com.dljsxy.school.constant;

/**
 * for web api
 *
 * @author ningtao
 */
public enum WebExceptionEnum {
    /**
     * 内部系统错误
     */
    SYSTEM_ERROR(1, "系统错误"),
    /**
     * 参数错误
     */
    PARAM_ERROR(2, "参数错误"),

    PASSWORD_ERROR(3, "密码错误"),

    ;

    private int code;
    private String msg;

    WebExceptionEnum(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
