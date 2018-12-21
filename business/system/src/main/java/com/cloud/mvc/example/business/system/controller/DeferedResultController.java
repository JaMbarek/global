package com.cloud.mvc.example.business.system.controller;

import com.cloud.mvc.example.business.common.config.message.Resp;
import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;

@RestController
@RequestMapping("/open/user")
public class DeferedResultController {

    public static final Multimap<Integer, DeferredResult<Resp>> map = ArrayListMultimap.create();

    @GetMapping("/{id}")
    public DeferredResult<Resp> async(@PathVariable Integer id){

        DeferredResult<Resp> result = new DeferredResult<>();
        map.put(id, result);
        return result;

    }




}
