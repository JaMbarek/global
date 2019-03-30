package com.example.mvc.example.sharding.sharding.dao;

import com.example.mvc.example.sharding.sharding.Order;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderDao extends CrudRepository<Order, Long> {
}
