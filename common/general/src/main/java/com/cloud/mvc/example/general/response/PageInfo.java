package com.cloud.mvc.example.general.response;


import lombok.Data;

import java.util.List;

@Data
public class PageInfo<E> {

    private Long totalSize;
    private Long pageSize;
    private Long currentPage;
    private List<E> data;

    private boolean first;
    private boolean last;

}
