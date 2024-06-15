/*
 * Copyright (C) 2019 Baidu, Inc. All Rights Reserved.
 */

package com.sut.school.constant;

import lombok.Getter;

/**
 * for web api
 *
 * @author ningtao
 */
@Getter
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

    private final int code;
    private final String msg;

    WebExceptionEnum(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

}
