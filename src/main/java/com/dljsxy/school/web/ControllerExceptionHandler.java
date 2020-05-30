package com.dljsxy.school.web;

import com.dljsxy.school.constant.WebExceptionEnum;
import com.dljsxy.school.exception.WebApiException;
import com.dljsxy.school.web.reqRes.BaseApiResponse;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.exception.GenericJDBCException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@Slf4j
@ControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(WebApiException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public BaseApiResponse<Void> handleCommonException(WebApiException e) {
        return new BaseApiResponse<>(e);
    }

    @ExceptionHandler(GenericJDBCException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public BaseApiResponse<Void> handleJdbcException(GenericJDBCException e) {
        log.warn("web controller GenericJDBCException", e);
        return new BaseApiResponse<>(new WebApiException(WebExceptionEnum.SYSTEM_ERROR));
    }

    @ExceptionHandler(RuntimeException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public BaseApiResponse<Void> handleRuntimeException(RuntimeException e) {
        log.warn("web controller RuntimeException", e);
        return new BaseApiResponse<>(new WebApiException(WebExceptionEnum.SYSTEM_ERROR));
    }
}
