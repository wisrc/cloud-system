package com.wisrc.microservice.vo.response;

import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.sql.Timestamp;

@Data
@ApiModel
public class SysDictionaryItemVo {
    private int id;
    private String key;
    private String value;
    private String sort;
    private Integer typeId;
    private Timestamp createTime;
    private String createBy;
    private Timestamp modifyTime;
    private String modifyBy;
    private Integer deleteFlag;
}
