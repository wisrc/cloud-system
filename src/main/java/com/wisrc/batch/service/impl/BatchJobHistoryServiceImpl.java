package com.wisrc.batch.service.impl;

import com.wisrc.batch.dao.BatchJobHistoryDao;
import com.wisrc.batch.entity.BatchJobHistoryEntity;
import com.wisrc.batch.service.BatchJobHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by hzwy23 on 2017/6/17.
 *
 * @author hzwy23
 */
@Service
public class BatchJobHistoryServiceImpl implements BatchJobHistoryService {
    @Autowired
    private BatchJobHistoryDao batchJobHistoryDao;

    @Override
    public List<BatchJobHistoryEntity> findAll(String id, String gid) {
        return batchJobHistoryDao.findAll(id, gid);
    }
}
