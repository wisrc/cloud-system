package com.wisrc.microservice.vo.response;

import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.sql.Timestamp;

@Data
@ApiModel
public class SysUserPositionVo {
    private int id;
    private String userId;
    private Integer positionId;
    private Timestamp createTime;
    private String createBy;
    private Timestamp modifyTime;
    private String modifyBy;
    private String deleteFlag;
}
