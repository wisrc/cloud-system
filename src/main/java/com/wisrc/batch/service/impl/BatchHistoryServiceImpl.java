package com.wisrc.batch.service.impl;

import com.wisrc.batch.dao.BatchHistoryDao;
import com.wisrc.batch.dto.BatchHistoryDto;
import com.wisrc.batch.entity.BatchHistoryEntity;
import com.wisrc.batch.service.BatchHistoryService;
import com.wisrc.batch.utils.RetMsg;
import com.wisrc.batch.utils.SysStatus;
import com.wisrc.batch.utils.factory.RetMsgFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hzwy23 on 2017/6/16.
 */
@Service
public class BatchHistoryServiceImpl implements BatchHistoryService {
    @Autowired
    private BatchHistoryDao batchHistoryDao;

    @Override
    public List<BatchHistoryEntity> findAll(String domainId) {
        return batchHistoryDao.findAll(domainId);
    }

    @Override
    public RetMsg delete(List<BatchHistoryDto> list) {
        List<BatchHistoryEntity> args = new ArrayList<>();
        for (BatchHistoryDto m : list) {
            BatchHistoryEntity entity = new BatchHistoryEntity();
            entity.setSid(m.getSid());
            args.add(entity);
        }
        try {
            int size = batchHistoryDao.delete(args);
            if (1 == size) {
                return RetMsgFactory.getRetMsg(SysStatus.SUCCESS_CODE, "success", null);
            }
            return RetMsgFactory.getRetMsg(SysStatus.ERROR_CODE, "删除批次历史信息失败，请联系管理员", null);
        } catch (Exception e) {
            return RetMsgFactory.getRetMsg(SysStatus.EXCEPTION_ERROR_CODE, e.getMessage(), null);
        }
    }
}
