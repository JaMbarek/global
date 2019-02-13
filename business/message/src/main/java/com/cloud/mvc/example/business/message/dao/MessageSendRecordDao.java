package com.cloud.mvc.example.business.message.dao;

import com.cloud.mvc.example.business.message.entity.MessageSendRecord;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MessageSendRecordDao extends CrudRepository<MessageSendRecord, Long> {
}
