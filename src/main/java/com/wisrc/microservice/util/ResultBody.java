package com.wisrc.microservice.util;


import com.wisrc.microservice.constant.RestCodeEnum;
import lombok.Data;
import org.springframework.data.domain.Page;

@Data
public class ResultBody {

    private int code;

    private String message;

    private Object data;


    public static ResultBody success() {
        ResultBody result = new ResultBody();
        result.setCode(RestCodeEnum.SUCCESS.getCode());
        result.setMessage(RestCodeEnum.SUCCESS.getMessage());
        result.setData("Bingo");
        return result;
    }


    public static ResultBody success(Object data) {
        ResultBody result = new ResultBody();
        result.setCode(RestCodeEnum.SUCCESS.getCode());
        result.setMessage(RestCodeEnum.SUCCESS.getMessage());
        result.setData(data);
        return result;
    }


    public static ResultBody success(RestCodeEnum code, Object data) {
        ResultBody result = new ResultBody();
        result.setCode(code.getCode());
        result.setMessage(code.getMessage());
        result.setData(data);
        return result;
    }

    public static ResultBody success(int code, String message, Object data) {
        ResultBody result = new ResultBody();
        result.setCode(code);
        result.setMessage(message);
        result.setData(data);
        return result;
    }

    public static ResultBody success(Object data, Page page){
        ResultBody result = new ResultBody();
        result.setCode(RestCodeEnum.SUCCESS.getCode());
        result.setMessage(RestCodeEnum.SUCCESS.getMessage());
        PageData pageData = new PageData(data, page);
        result.setData(pageData);
        return result;
    }
}
