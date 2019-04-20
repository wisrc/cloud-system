package com.wisrc.microservice.service;


import com.wisrc.microservice.util.ResultBody;
import com.wisrc.microservice.vo.request.SysUserUpdateParamVo;
import org.springframework.data.domain.Pageable;

/**
 * 用户账号管理服务
 * @author hzwy23@163.com
 * @since 0.0.1
 * */
public interface SysUserService {

    /**
     * 用户注册
     * 用户通过手机号注册
     * @param email 邮箱
     * @param password 密码
     * @param phone 手机号
     * @param code 验证码
     * */
    ResultBody register(String email, String password, String phone, int code);



    /**
     * 获取用户个人信息
     * @param userId 用户对应的唯一ID
     * */
    ResultBody getProfiles(int userId);


    /**
     * 获取用户信息列表
     * @param pageable 分页信息
     * */
    ResultBody getUserList(Pageable pageable);


    /**
     * 禁止用户登陆
     * @param userId 被禁止的用户唯一ID
     * @param operator 操作人唯一ID
     * */
    ResultBody forbidUser(Integer userId, String operator);


    /**
     * 保存或更新用户信息
     * @param paramVo
     * */
    ResultBody saveOrUpdate(SysUserUpdateParamVo paramVo, String operator);
}
