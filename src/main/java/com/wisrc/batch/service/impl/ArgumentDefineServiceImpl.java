package com.wisrc.batch.service.impl;

import com.wisrc.batch.dao.ArgumentDefineDao;
import com.wisrc.batch.entity.ArgumentDefineEntity;
import com.wisrc.batch.service.ArgumentDefineService;
import com.wisrc.batch.utils.RetMsg;
import com.wisrc.batch.utils.SysStatus;
import com.wisrc.batch.utils.factory.RetMsgFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by hzwy23 on 2017/7/17.
 */
@Service
public class ArgumentDefineServiceImpl implements ArgumentDefineService {

    // 参数定义
    @Autowired
    private ArgumentDefineDao argumentDefineDao;


    @Override
    public List<ArgumentDefineEntity> findAll(String domainID) {
        return argumentDefineDao.findAll(domainID);
    }

    @Override
    public RetMsg addArgument(ArgumentDefineEntity m) {
        try {
            int size = argumentDefineDao.add(m);
            if (1 == size) {
                return RetMsgFactory.getRetMsg(SysStatus.SUCCESS_CODE, "success", null);
            }
            return RetMsgFactory.getRetMsg(SysStatus.ERROR_CODE, "添加参数定义信息失败，请联系管理员", m);
        } catch (Exception e) {
            return RetMsgFactory.getRetMsg(SysStatus.EXCEPTION_ERROR_CODE, e.getMessage(), m);
        }
    }

    @Override
    public RetMsg deleteArgument(List<ArgumentDefineEntity> m) {
        try {
            String msg = argumentDefineDao.delete(m);
            if ("success".equals(msg)) {
                return RetMsgFactory.getRetMsg(SysStatus.SUCCESS_CODE, "success", null);
            }
            return RetMsgFactory.getRetMsg(SysStatus.ERROR_CODE, "删除参数信息失败，请联系管理员", m);
        } catch (Exception e) {
            return RetMsgFactory.getRetMsg(SysStatus.EXCEPTION_ERROR_CODE, e.getMessage(), m);
        }
    }

    @Override
    public RetMsg updateArgument(ArgumentDefineEntity m) {
        try {
            int size = argumentDefineDao.update(m);
            if (1 == size) {
                return RetMsgFactory.getRetMsg(SysStatus.SUCCESS_CODE, "success", m);
            }
            return RetMsgFactory.getRetMsg(SysStatus.ERROR_CODE, "更新参数信息失败，请联系管理员", m);
        } catch (Exception e) {
            return RetMsgFactory.getRetMsg(SysStatus.EXCEPTION_ERROR_CODE, e.getMessage(), m);
        }

    }
}
