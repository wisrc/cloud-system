package com.wisrc.microservice.dao;

import com.wisrc.microservice.entity.SysUserProfileEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;


@Repository
public interface SysUserProfileDao extends JpaRepository<SysUserProfileEntity, Integer> {


    SysUserProfileEntity findByUserId(int userId);


    SysUserProfileEntity findById(int id);


    @Transactional
    @Modifying
    @Query(value = "update sys_user_profile set delete_flag = 1, modify_by =  ?1, modify_time = ?2 where user_id = ?3", nativeQuery = true)
    int logiccDelete(String operator, Timestamp modifyTime, Integer userId);

}
