package com.example.demo.repository;

import com.example.demo.entity.StudentOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RazorpayRepository extends JpaRepository<StudentOrder,Integer> {

}
