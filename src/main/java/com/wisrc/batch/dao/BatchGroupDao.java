package com.wisrc.batch.dao;

import com.wisrc.batch.entity.BatchGroupEntity;
import com.wisrc.batch.entity.GroupDependencyEntity;

import java.util.List;

/**
 * Created by hzwy23 on 2017/5/24.
 */
public interface BatchGroupDao {
    List findAll(String domainId, String batchId);

    List<BatchGroupEntity> getGroup(String batchId);

    int addGroup(List<BatchGroupEntity> list);

    int deleteGroup(List<BatchGroupEntity> list);

    List<BatchGroupEntity> getDependency(String batchid, String id);

    List<BatchGroupEntity> getGroupDependency(String id);

    int deleteGroupDependency(String uuid);

    int addGroupDependency(List<GroupDependencyEntity> list);
}
