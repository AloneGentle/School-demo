/*
 * Copyright (C) 2019 Baidu, Inc. All Rights Reserved.
 */

package com.dljsxy.school.web.reqRes;

import com.dljsxy.school.exception.WebApiException;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author ningtao
 */
@Getter
@Setter
@ToString
public class BaseApiRes<T> {
    private int status;
    private String msg = "success";
    private T data;

    public BaseApiRes() {
    }

    public BaseApiRes(T data) {
        this.data = data;
    }

    public BaseApiRes(WebApiException e) {
        this.status = e.getCode();
        this.msg = e.getMessage();
    }
}
