package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "student_info")
@Data
public class StudentOrder {
    @Id
    private String orderId;
    private String name;
    private String email;
    private Integer amount;
    private String orderStatus;
    private String razorpayKeyId;

}
