package com.wisrc.microservice.dao;

import com.wisrc.microservice.entity.SysUserBaseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository
public interface SysUserBaseDao extends JpaRepository<SysUserBaseEntity, Integer>, JpaSpecificationExecutor {

    SysUserBaseEntity findById(int id);



    @Modifying
    @Transactional
    @Query(value = "update sys_user_base set status = ?2 where id = ?1 and delete_flag = 0", nativeQuery = true)
    int updateStatus(int userId, int status);


    @Query(value = "update sys_user_base set delete_flag = 1 where id = ?1", nativeQuery = true)
    @Modifying
    @Transactional
    int logicDelete(Integer id);

}
