package com.example.demo.controller;

import com.example.demo.entity.StudentOrder;
import com.example.demo.service.RazorpayService;
import com.razorpay.RazorpayException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200/")
public class RazorpayController {

    @Autowired
    private final RazorpayService razorpayService;

    @PostMapping("/createOrder")
    public ResponseEntity<?> orderCreation(@RequestBody StudentOrder studentOrder) {
        try {
            StudentOrder order = razorpayService.createOrder(studentOrder);
            return new ResponseEntity<>(order, HttpStatus.CREATED);
        } catch (RazorpayException e) {
            throw new RuntimeException(e);
        }
    }

}
