package com.wisrc.batch.dao;

import com.wisrc.batch.dto.JobKeyDepDto;
import com.wisrc.batch.entity.TaskDependencyEntity;

import java.util.List;

/**
 * Created by hzwy23 on 2017/5/27.
 */
public interface TaskDependencyDao {
    List<TaskDependencyEntity> findAll(String domainId);

    List<JobKeyDepDto> findById(String domainId, String batchId);

}
