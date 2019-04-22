package com.wisrc.microservice.controller;


import com.wisrc.microservice.exception.PageRequestException;
import com.wisrc.microservice.service.SysUserService;
import com.wisrc.microservice.util.PageRequestValidatorUtil;
import com.wisrc.microservice.util.ResultBody;
import com.wisrc.microservice.vo.request.SysUserUpdateParamVo;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

/**
 * 用户账号管理
 * @author hzwy23@163.com
 * @since 0.0.1
 * */
@RestController
@Api(description = "用户账号管理")
@Slf4j
public class SysUserController {


    @Autowired
    private SysUserService sysUserService;


    @GetMapping(value = "/user")
    public ResultBody getUserList(@RequestParam(value = "pageNumber") Integer pageNumber,
                                  @RequestParam(value = "pageSize") Integer pageSize) throws PageRequestException {

        log.info("参数是：pageNumber: {}, pageSize: {}", pageNumber, pageSize);

        PageRequestValidatorUtil.validator(pageNumber, pageSize);

        PageRequest page =  PageRequest.of(pageNumber-1, pageSize);

        return sysUserService.getUserList(page);
    }


    @PutMapping(value = "/user/forbid")
    public ResultBody forbidUser(@RequestParam(value = "userId") Integer userId,
                                 @RequestParam(value = "remark") String remark,
                                 @RequestHeader(value = "X-user-id") String operator){
        log.info("禁用账号ID为 {}的用户", userId);
        return sysUserService.updateStatus(userId, remark, operator, 1);
    }

    @PutMapping(value = "/user/enable")
    public ResultBody enableUser(@RequestParam(value = "userId") Integer userId,
                                 @RequestParam(value = "remark") String remark,
                                 @RequestHeader(value = "X-user-id") String operator){
        log.info("启动账号ID为 {}的用户", userId);
        return sysUserService.updateStatus(userId, remark, operator, 0);
    }


    @RequestMapping(value = "/user/profile", method = RequestMethod.GET)
    public ResultBody getProfile(@RequestHeader(value = "X-user-id") String userId){
        if (userId == null || userId.isEmpty()) {
            return ResultBody.success(100012,"链接已断开，请先登陆系统", userId);
        }
        return sysUserService.getProfiles(Integer.parseInt(userId));
    }


    @PostMapping(value = "/user")
    public ResultBody saveOrUpdate(@RequestHeader(value = "X-user-id") String operator,
                                   @RequestBody SysUserUpdateParamVo paramVo){
        log.info("操作人：{}. profile 信息是：{}", operator, paramVo);
        return sysUserService.saveOrUpdate(paramVo,operator);
    }


    @DeleteMapping(value = "/user/{userId}")
    public ResultBody delete(@RequestHeader(value = "operator") String operator,
                             @PathVariable(value = "userId") Integer userId){
        log.info("delete username, user id is: {}, operator is: {}", userId, operator);
        return sysUserService.delete(userId, operator);
    }


    @PostMapping(value = "/user/register")
    public ResultBody register(@RequestParam(value = "username") String username,
                               @RequestParam(value = "mobilePhone") String mobilePhone,
                               @RequestParam(value = "code") Integer code){
        log.info("用户注册，账号：{}, 手机号：{}, 验证码：{}", username, mobilePhone, code);
        return sysUserService.register(username,mobilePhone,code);
    }

}
