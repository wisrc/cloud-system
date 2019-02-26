package com.wisrc.batch.dao;


import com.wisrc.batch.entity.BatchGroupHistoryEntity;

import java.util.List;

/**
 * Created by hzwy23 on 2017/6/17.
 */
public interface BatchGroupHistoryDao {
    List<BatchGroupHistoryEntity> findAll(String uuid);
}
