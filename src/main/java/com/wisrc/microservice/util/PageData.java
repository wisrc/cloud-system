package com.wisrc.microservice.util;


import lombok.Data;
import org.springframework.data.domain.Page;

@Data
public class PageData {

    private long total;

    private Integer pageNumber;

    private Integer pageSize;

    private Object rows;

    private boolean pageable;



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
