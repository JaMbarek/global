package com.cloud.mvc.example.business.common.config.message;


import com.cloud.mvc.example.business.common.request.PageHolder;
import com.google.common.collect.Lists;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.function.Function;

@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
@SuppressWarnings("all")
public class PageInfo<E> {

    private Long totalSize;
    private Integer pageSize;
    private Integer currentPage;
    private List<E> data;

    private boolean first;
    private boolean last;

    static PageHolder holder;

    @Autowired
    public PageInfo(PageHolder holder){
        PageInfo.holder = holder;
    }

    public static final PageInfo EMPTY = new PageInfo(0L, 0, 0, Lists.newArrayList(), true, false);

    public static <A> PageInfo create(Long count, List<A> data) {

        final Long pageSize = count % holder.getLimit() == 0 ? count / holder.getLimit() : count / holder.getLimit() + 1;

        PageInfo info = new PageInfo();
        info.setCurrentPage(holder.getPage());
        info.setData(data);
        info.setFirst(holder.getPage() == 1L);
        info.setLast(holder.getPage() == pageSize.intValue());
        info.setPageSize(pageSize.intValue());
        info.setTotalSize(count);

        return info;
    }

    public <T> T map(Function<PageInfo, T> function) {
        return function.apply(this);
    }




}
