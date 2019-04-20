package com.wisrc.microservice.vo.response;

import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.sql.Timestamp;


@Data
@ApiModel
public class SysRoleDefineVo {
    private int id;
    private String roleName;
    private Timestamp createTime;
    private String createBy;
    private Timestamp modifyTime;
    private String mobileBy;
    private String deleteFlag;
    private String remark;
}
