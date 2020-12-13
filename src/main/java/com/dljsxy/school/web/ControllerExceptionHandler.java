package com.dljsxy.school.web;

import com.dljsxy.school.constant.WebExceptionEnum;
import com.dljsxy.school.exception.WebApiException;
import com.dljsxy.school.web.reqRes.BaseApiRes;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.JDBCException;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;

@Slf4j
@ControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(WebApiException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public BaseApiRes<Void> handleCommonException(WebApiException e) {
        return new BaseApiRes<>(e);
    }

    @ExceptionHandler
    @ResponseBody
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public BaseApiRes<Void> handleJdbcException(JDBCException e) {
        log.warn("web controller GenericJDBCException", e);
        return new BaseApiRes<>(new WebApiException(WebExceptionEnum.SYSTEM_ERROR));
    }

    @ExceptionHandler
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public BaseApiRes<Void> handleRuntimeException(RuntimeException e) {
        log.warn("web controller RuntimeException", e);
        return new BaseApiRes<>(new WebApiException(WebExceptionEnum.SYSTEM_ERROR));
    }

    @ExceptionHandler
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public BaseApiRes<List<FieldError>> handleBindException(BindException e) {
        log.warn("BindException", e);
        BaseApiRes<List<FieldError>> res = new BaseApiRes<>(new WebApiException(WebExceptionEnum.PARAM_ERROR));
        res.setData(e.getFieldErrors());
        return res;
    }

    @ExceptionHandler
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public BaseApiRes<Void> handleException(Exception e) {
        log.warn("web controller Exception", e);
        return new BaseApiRes<>(new WebApiException(WebExceptionEnum.SYSTEM_ERROR));
    }

}
