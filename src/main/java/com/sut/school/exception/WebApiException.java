/*
 * Copyright (C) 2019 Baidu, Inc. All Rights Reserved.
 */

package com.sut.school.exception;

import com.sut.school.constant.WebExceptionEnum;
import lombok.Getter;
import lombok.ToString;

/**
 *
 * @author ningtao
 */
@ToString
@Getter
public class WebApiException extends RuntimeException {
    private final int  code;

    public WebApiException(WebExceptionEnum e) {
        super(e.getMsg());
        this.code = e.getCode();
    }

}
