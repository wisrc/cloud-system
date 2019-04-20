package com.wisrc.microservice.vo.response;

import io.swagger.annotations.ApiModel;
import lombok.Data;


@Data
@ApiModel
public class SysUserBaseVo {
    private int id;
    private String username;
    private String mobilePhone;
    private Integer status;
    private Integer deleteFlag;
}
