package com.wisrc.microservice.dao;

import com.wisrc.microservice.entity.SysUserBaseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface SysUserBaseDao extends JpaRepository<SysUserBaseEntity, Integer> {
}
