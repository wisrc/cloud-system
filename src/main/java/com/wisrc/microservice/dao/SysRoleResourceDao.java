package com.wisrc.microservice.dao;

import com.wisrc.microservice.entity.SysRoleResourceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface SysRoleResourceDao extends JpaRepository<SysRoleResourceEntity,Integer> {
}
