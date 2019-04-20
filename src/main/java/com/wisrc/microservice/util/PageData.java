package com.wisrc.microservice.util;


import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.data.domain.Page;

@Data
public class PageData {

    @ApiModelProperty(position = 0)
    private long total;

    @ApiModelProperty(position = 1)
    private Integer pageNumber;

    @ApiModelProperty(position = 2)
    private Integer pageSize;

    @ApiModelProperty(position = 3)
    private boolean pageable;

    @ApiModelProperty(position = 4)
    private Object rows;

    public PageData(Object data, Page page) {
        if (page == null) {
            this.total = 0;
            this.pageNumber = 0;
            this.pageSize = 0;
            this.rows = data;
            this.pageable = false;
            return;
        }

        this.total = page.getTotalElements();
        this.pageNumber = page.getNumber();
        this.pageSize = page.getSize();
        this.rows = data;
        this.pageable = true;
    }
}
