package com.cloud.mvc.example.business.common.config.message;


import com.google.common.collect.Lists;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.function.Function;

@Data
@AllArgsConstructor
@SuppressWarnings("all")
public class PageInfo<E> {

    private Long totalSize;
    private Long pageSize;
    private Long currentPage;
    private List<E> data;

    private boolean first;
    private boolean last;

    public static final PageInfo EMPTY = new PageInfo(0L, 0L, 0L, Lists.newArrayList(), true, false);

    public static <A> PageInfo create(Long count, List<A> data) {
        return null;
    }

    public <T> T map(Function<PageInfo, T> function) {
        return function.apply(this);
    }




}
