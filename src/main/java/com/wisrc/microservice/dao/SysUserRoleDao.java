package com.wisrc.microservice.dao;

import com.wisrc.microservice.entity.SysUserRoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface SysUserRoleDao extends JpaRepository<SysUserRoleEntity, Integer> {
}
