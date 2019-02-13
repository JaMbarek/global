package com.cloud.mvc.example.business.message.service;

import com.cloud.mvc.example.business.message.dao.MessageSendRecordDao;
import com.cloud.mvc.example.business.message.entity.MessageSendRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessageSendRecordService {

    @Autowired
    private MessageSendRecordDao messageSendRecordDao;


    public Iterable<MessageSendRecord> all(){
        Iterable<MessageSendRecord> all = messageSendRecordDao.findAll();
        return all;
    }




}
