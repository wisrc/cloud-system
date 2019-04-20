package com.wisrc.microservice.vo.request;


import lombok.Data;

@Data
public class SysUserUpdateParamVo {

    private String avatar;
    private String weixin;
    private String qq;
    private String email;
    private String liveCity;
    private String enrollmentYear;
    private String realname;
    private String nickname;
    private String remark;
}
