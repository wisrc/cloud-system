package com.wisrc.batch.dao;


import com.wisrc.batch.entity.BatchJobHistoryEntity;

import java.util.List;

/**
 * Created by hzwy23 on 2017/6/17.
 */
public interface BatchJobHistoryDao {
    List<BatchJobHistoryEntity> findAll(String uuid, String gid);
}
