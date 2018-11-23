package com.cloud.mvc.example.general.response;


import com.cloud.mvc.example.general.supers.BaseEntity;
import com.google.common.collect.Lists;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class PageInfo<E> {

    private Long totalSize;
    private Long pageSize;
    private Long currentPage;
    private List<E> data;

    private boolean first;
    private boolean last;

    public static final PageInfo EMPTY = new PageInfo(0L, 0L, 0L, Lists.newArrayList(), true, false);

    public static <A extends BaseEntity> PageInfo create(Long count, List<A> data) {
        return null;
    }
}
