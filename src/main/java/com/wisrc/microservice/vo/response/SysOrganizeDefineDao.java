package com.wisrc.microservice.vo.response;

import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.sql.Timestamp;

@Data
@ApiModel
public class SysOrganizeDefineDao {
    private int id;
    private String name;
    private Integer parentId;
    private Timestamp createTime;
    private String createBy;
    private Timestamp modifyTime;
    private String modifyBy;
    private String deleteFlag;
}
