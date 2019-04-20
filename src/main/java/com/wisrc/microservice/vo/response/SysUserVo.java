package com.wisrc.microservice.vo.response;

import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.sql.Timestamp;


@Data
@ApiModel
public class SysUserVo {
    private int id;
    private String avatar;
    private Integer userId;
    private String weixin;
    private String qq;
    private String email;
    private String liveCity;
    private String enrollmentYear;
    private Timestamp createTime;
    private String createBy;
    private Timestamp modifyTime;
    private String modifyBy;
    private String realname;
    private String nickname;
    private String remark;
    private String username;
    private String mobilePhone;
    private Integer status;
}
