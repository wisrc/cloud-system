package com.wisrc.microservice.dao;

import com.wisrc.microservice.entity.SysResourceDetailsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SysResourceDetailsDao extends JpaRepository<SysResourceDetailsEntity,Integer> {
}
