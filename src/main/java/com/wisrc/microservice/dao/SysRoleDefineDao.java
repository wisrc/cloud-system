package com.wisrc.microservice.dao;

import com.wisrc.microservice.entity.SysRoleDefineEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SysRoleDefineDao extends JpaRepository<SysRoleDefineEntity,Integer> {
}
