package com.wisrc.microservice.util;

import com.wisrc.microservice.exception.PageRequestException;

public class PageRequestValidatorUtil {


    public static boolean validator(Integer pageNumber, Integer pageSize) throws PageRequestException {

        if (pageNumber == null) {
            throw new PageRequestException("pageNumber 页码不能为空");
        } else if (pageSize == null) {
            throw new PageRequestException("pageSize 每页条数不能为空");
        } else if (pageNumber <= 0) {
            throw new PageRequestException("pageNumber 页码最小从1开始");
        } else if (pageSize <= 0) {
            throw new PageRequestException("pageSize 每页条数不能小于等于0");
        } else if (pageSize > 100) {
            throw new PageRequestException("pageSize 每次查询条数不能超过100条");
        }

        return true;
    }
}
