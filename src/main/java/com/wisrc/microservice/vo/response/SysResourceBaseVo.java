package com.wisrc.microservice.vo.response;

import io.swagger.annotations.ApiModel;
import lombok.Data;


@Data
@ApiModel
public class SysResourceBaseVo {
    private int id;
    private String name;
    private Integer parentId;
    private Integer authorityControl;
    private String deleteFlag;
    private Integer level;
}
