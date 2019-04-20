package com.wisrc.microservice.vo.response;

import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.sql.Timestamp;


@Data
@ApiModel
public class SysUserRoleVo {
    private int id;
    private Integer userId;
    private Integer roleId;
    private Timestamp createTime;
    private String createBy;
    private String modifyBy;
    private Timestamp modifyTime;
    private String deleteFlag;
}
