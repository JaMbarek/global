package com.example.mvc.example.sharding.sharding;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "t_order")
@Data
public class Order {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "ID", unique = true, nullable = false, length = 20)
    private Long id;


    @Column(name = "name")
    private String name;

    @Column(name = "create_date")
    private LocalDateTime createDate;


}
