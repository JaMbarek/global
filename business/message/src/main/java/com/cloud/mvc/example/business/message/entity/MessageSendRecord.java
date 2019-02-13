package com.cloud.mvc.example.business.message.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "message_send_record")
@Data
public class MessageSendRecord {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "ID", unique = true, nullable = false, length = 20)
    private Long id;

    @Column(name = "mobile")
    private String mobile;

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "send_date")
    private LocalDateTime sendDate;

}
