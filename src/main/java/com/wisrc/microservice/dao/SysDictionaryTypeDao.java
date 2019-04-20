package com.wisrc.microservice.dao;

import com.wisrc.microservice.entity.SysDictionaryTypeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface SysDictionaryTypeDao extends JpaRepository<SysDictionaryTypeEntity,Integer> {
}
