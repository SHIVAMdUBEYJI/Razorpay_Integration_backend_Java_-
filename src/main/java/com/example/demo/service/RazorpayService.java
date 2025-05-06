package com.example.demo.service;

import com.example.demo.entity.StudentOrder;
import com.example.demo.repository.RazorpayRepository;
import com.razorpay.Order;
import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;
import lombok.RequiredArgsConstructor;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RazorpayService {

    private final RazorpayClient client;
    private final RazorpayRepository repository;
    @Value("${razorpay.key.id}")
    private String razorpayKeyId;
    @Value("${razorpay.key.secret}")
    private String razorpayKeySecret;

    public StudentOrder createOrder(StudentOrder studentOrder) throws RazorpayException {

        JSONObject object = new JSONObject();
        object.put("amount", studentOrder.getAmount() * 100);//this makes sure that the rupee can be in paisa
        object.put("currency", "INR");
        object.put("receipt", studentOrder.getRazorpayKeyId());
        Order orderReq = this.client.orders.create(object);

        studentOrder.setOrderId(orderReq.get("id"));
        studentOrder.setOrderStatus("status");

        return repository.save(studentOrder);
    }
}
