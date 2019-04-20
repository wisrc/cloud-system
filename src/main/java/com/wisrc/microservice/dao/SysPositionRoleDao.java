package com.wisrc.microservice.dao;

import com.wisrc.microservice.entity.SysPositionRoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface SysPositionRoleDao extends JpaRepository<SysPositionRoleEntity,Integer> {
}
