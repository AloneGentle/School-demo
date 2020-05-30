/*
 * Copyright (C) 2019 Baidu, Inc. All Rights Reserved.
 */

package com.dljsxy.school.exception;

import com.dljsxy.school.constant.WebExceptionEnum;
import lombok.Getter;
import lombok.ToString;

/**
 *
 * @author ningtao
 */
@ToString
@Getter
public class WebApiException extends RuntimeException {
    private int code;

    public WebApiException(WebExceptionEnum e) {
        super(e.getMsg());
        this.code = e.getCode();
    }

}
