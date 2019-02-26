package com.wisrc.batch.service.impl;

import com.wisrc.batch.dao.BatchGroupHistoryDao;
import com.wisrc.batch.entity.BatchGroupHistoryEntity;
import com.wisrc.batch.service.BatchGroupHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by hzwy23 on 2017/6/17.
 */
@Service
public class BatchGroupHistoryServiceImpl implements BatchGroupHistoryService {
    @Autowired
    private BatchGroupHistoryDao batchGroupHistoryDao;

    @Override
    public List<BatchGroupHistoryEntity> findAll(String uuid) {
        return batchGroupHistoryDao.findAll(uuid);
    }
}
