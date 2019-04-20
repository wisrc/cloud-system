package com.wisrc.microservice.configurer;


import com.wisrc.microservice.constant.RestCodeEnum;
import com.wisrc.microservice.util.ResultBody;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public ResultBody globalException(Exception e) {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        log.error("请求地址是：{},未处理异常, 异常信息时：{}",request.getRequestURI(), e.getMessage());
        e.printStackTrace();
        return ResultBody.success(RestCodeEnum.UNHANDLED_EXCEPTION.getCode(), e.getMessage(), e.getStackTrace());
    }
}
