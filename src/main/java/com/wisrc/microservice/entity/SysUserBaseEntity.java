package com.wisrc.microservice.entity;

import lombok.Data;
import org.hibernate.annotations.Where;

import javax.persistence.*;

@Entity
@Table(name = "sys_user_base")
@Where(clause = "delete_flag = 0")
@Data
public class SysUserBaseEntity {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "username")
    private String username;

    @Column(name = "mobile_phone")
    private String mobilePhone;

    @Column(name = "status")
    private Integer status;

    @Column(name = "delete_flag")
    private Integer deleteFlag;

}
