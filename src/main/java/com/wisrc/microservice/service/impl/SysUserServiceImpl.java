package com.wisrc.microservice.service.impl;


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
    public ResultBody register(String email, String password, String phone, int code) {
        return null;
    }


    @Override
    public ResultBody getProfiles(int userId) {

        SysUserProfileEntity item = sysUserProfileDao.findByUserId(userId);

        SysUserVo element = new SysUserVo();

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
            SysUserProfileEntity profileItem = sysUserProfileDao.findByUserId(item.getId());


            SysUserVo element = new SysUserVo();
            BeanUtils.copyProperties(profileItem, element);
            BeanUtils.copyProperties(item, element);

            ret.add(element);
        }

        return ResultBody.success(ret, results);
    }

    @Override
    public ResultBody forbidUser(Integer userId, String operator) {
        int size = sysUserBaseDao.updateStatus(userId, 1);

        if (size == 0) {
            return ResultBody.success(1000001,"账号不存在", userId);
        }

        SysUserProfileEntity item = sysUserProfileDao.findByUserId(userId);
        item.setModifyBy(operator);
        item.setModifyTime(DateTimeUtil.currentTimestamp());
        sysUserProfileDao.save(item);
        return ResultBody.success("Bingo");
    }

    @Override
    public ResultBody saveOrUpdate(SysUserUpdateParamVo paramVo, String operator) {
        return null;
    }
}
