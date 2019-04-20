package com.wisrc.microservice.vo.response;

import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.sql.Timestamp;


@Data
@ApiModel
public class SysDictionaryTypeVo {
    private int id;
    private String code;
    private String name;
    private String status;
    private Integer parentId;
    private Timestamp createTime;
    private String createBy;
    private Timestamp modifyTime;
    private String modifyBy;
    private String deleteFlag;
}
