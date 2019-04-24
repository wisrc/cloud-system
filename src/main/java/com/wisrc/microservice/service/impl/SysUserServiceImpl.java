package com.wisrc.microservice.service.impl;


import com.wisrc.microservice.constant.RestCodeEnum;
import com.wisrc.microservice.dao.SysUserBaseDao;
import com.wisrc.microservice.dao.SysUserProfileDao;
import com.wisrc.microservice.entity.SysUserBaseEntity;
import com.wisrc.microservice.entity.SysUserProfileEntity;
import com.wisrc.microservice.service.SysUserService;
import com.wisrc.microservice.util.DateTimeUtil;
import com.wisrc.microservice.util.ResultBody;
import com.wisrc.microservice.vo.request.SysUserUpdateParamVo;
import com.wisrc.microservice.vo.response.SysUserVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * 用户账号管理服务
 * @author hzwy23@163.com
 * @since 0.0.1
 * */
@Service
@Slf4j
public class SysUserServiceImpl implements SysUserService {

    @Autowired
    private SysUserBaseDao sysUserBaseDao;

    @Autowired
    private SysUserProfileDao sysUserProfileDao;


    @Override
    public ResultBody register(String username, String phone) {
        SysUserBaseEntity baseEntity = new SysUserBaseEntity();
        baseEntity.setMobilePhone(phone);
        baseEntity.setDeleteFlag(0);
        baseEntity.setStatus(0);
        baseEntity.setUsername(username);
        sysUserBaseDao.save(baseEntity);
        return ResultBody.success("Bingo");
    }


    @Override
    public ResultBody getProfiles(int userId) {

        SysUserVo element = new SysUserVo();

        SysUserProfileEntity item = sysUserProfileDao.findByUserId(userId);

        if (item == null) {
            return ResultBody.success(10001,"未查询到相关数据", element);
        }

        BeanUtils.copyProperties(item, element);

        SysUserBaseEntity baseItem = sysUserBaseDao.findById(userId);

        BeanUtils.copyProperties(baseItem, element);

        log.info("userId is:{}, result is: {}", userId, element);

        return ResultBody.success(element);
    }

    @Override
    public ResultBody getUserList(Pageable pageable) {

        List<SysUserVo> ret = new LinkedList<>();
        Page<SysUserBaseEntity> results = sysUserBaseDao.findAll(pageable);
        List<SysUserBaseEntity> contents = results.getContent();
        Iterator<SysUserBaseEntity> iterator = contents.iterator();

        while (iterator.hasNext()) {

            SysUserBaseEntity item = iterator.next();
            SysUserVo element = new SysUserVo();

            SysUserProfileEntity profileItem = sysUserProfileDao.findByUserId(item.getId());
            if (profileItem != null) {
                BeanUtils.copyProperties(profileItem, element);
            }

            BeanUtils.copyProperties(item, element);

            ret.add(element);

        }

        return ResultBody.success(ret, results);
    }

    @Override
    public ResultBody updateStatus(Integer userId, String remark, String operator, int status) {

        int size = sysUserBaseDao.updateStatus(userId, status);

        if (size == 0) {
            return ResultBody.success(1000001,"账号不存在", userId);
        }

        SysUserProfileEntity item = sysUserProfileDao.findByUserId(userId);
        item.setModifyBy(operator);
        item.setModifyTime(DateTimeUtil.currentTimestamp());
        item.setRemark(remark);

        sysUserProfileDao.save(item);
        return ResultBody.success("Bingo");
    }




    @Override
    public ResultBody saveOrUpdate(SysUserUpdateParamVo paramVo, String operator) {

        SysUserBaseEntity ch = sysUserBaseDao.findById(Integer.parseInt(operator));
        if (ch  == null) {
            return ResultBody.success(10001,"用户不存在，请先注册用户",operator);
        }


        SysUserProfileEntity item = new SysUserProfileEntity();
        BeanUtils.copyProperties(paramVo, item);

        SysUserProfileEntity element = sysUserProfileDao.findByUserId(Integer.parseInt(operator));
        if (element == null) {
            // 新增用户个人信息
            item.setCreateBy(operator);
            item.setCreateTime(DateTimeUtil.currentTimestamp());
        } else {
            if (!element.getUserId().equals(Integer.parseInt(operator))) {
                log.warn("无权修改其他人个人信息");
                return ResultBody.success(RestCodeEnum.ACCESS_DENIED,operator);
            }
            item.setId(element.getId());
            item.setCreateTime(element.getCreateTime());
            item.setCreateBy(element.getCreateBy());
        }

        item.setModifyBy(operator);
        item.setModifyTime(DateTimeUtil.currentTimestamp());
        item.setUserId(Integer.parseInt(operator));
        item.setDeleteFlag(0);
        sysUserProfileDao.save(item);
        return ResultBody.success("Bingo");
    }

    @Override
    @Transactional
    public ResultBody delete(Integer userId, String operator) {

        if (userId.equals(Integer.parseInt(operator))) {
            return ResultBody.success(10041,"当前用户不能删除自身", operator);
        }

        int size = sysUserBaseDao.logicDelete(userId);
        if (size == 0) {
            return ResultBody.success(10089,"用户账号不存在", userId);
        }

        // TODO 调用zuul网关服务，删除用户密码信息，禁止用户登陆

        sysUserProfileDao.logiccDelete(operator,DateTimeUtil.currentTimestamp(),userId);

        return ResultBody.success();
    }
}
