package com.wisrc.microservice.dao;

import com.wisrc.microservice.entity.SysUserPositionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface SysUserPositionDao extends JpaRepository<SysUserPositionEntity, Integer> {
}
