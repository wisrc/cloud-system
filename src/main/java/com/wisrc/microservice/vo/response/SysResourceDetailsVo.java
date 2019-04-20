package com.wisrc.microservice.vo.response;

import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.sql.Timestamp;

@Data
@ApiModel
public class SysResourceDetailsVo {
    private int id;
    private Integer resourceId;
    private Timestamp createTime;
    private String createBy;
    private Timestamp modifyTime;
    private String modifyBy;
    private String deleteFlag;
}
