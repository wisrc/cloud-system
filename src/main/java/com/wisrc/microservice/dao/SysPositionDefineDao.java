package com.wisrc.microservice.dao;

import com.wisrc.microservice.entity.SysPositionDefineEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface SysPositionDefineDao extends JpaRepository<SysPositionDefineEntity,Integer> {
}
