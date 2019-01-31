package com.cloud.mvc.example.data.rest.rest.dao;

import com.cloud.mvc.example.data.rest.rest.entity.Domain;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DomainDao extends CrudRepository<Domain, Long> {
}
