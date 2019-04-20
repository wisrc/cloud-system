package com.wisrc.microservice.dao;

import com.wisrc.microservice.entity.SysResourceBaseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface SysResourceBaseDao extends JpaRepository<SysResourceBaseEntity,Integer> {
}
