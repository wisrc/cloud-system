package com.wisrc.microservice.dao;

import com.wisrc.microservice.entity.SysUserBaseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface SysUserBaseDao extends JpaRepository<SysUserBaseEntity, Integer>, JpaSpecificationExecutor {

    SysUserBaseEntity findById(int id);



    @Query(value = "update sys_user_base set status = ?2 where id = ?1 and delete_flag = 0", nativeQuery = true)
    int updateStatus(int userId, int status);

}
