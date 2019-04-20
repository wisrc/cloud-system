package com.wisrc.microservice.dao;

import com.wisrc.microservice.entity.SysUserProfileEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface SysUserProfileDao extends JpaRepository<SysUserProfileEntity, Integer> {
}
