package com.bean.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bean.demo.entity.Payment;



public interface PaymentDao extends JpaRepository<Payment,Integer>{
	//public List<Payment> findByuserid(int userid); //Admin
	List<Payment> findByUserUserid(int userid);
	//List<Payment> getPaymentsByBookingId(int booking_id);
}