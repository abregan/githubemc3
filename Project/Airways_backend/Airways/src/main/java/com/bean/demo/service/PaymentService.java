
package com.bean.demo.service;

import java.util.List;
import java.util.Optional;

import com.bean.demo.entity.Payment;

public interface PaymentService {
	Payment addPay(Payment payment,int bookingId,int userid);
	public List<Payment>findALL();
	public Optional<Payment> findUserById(int payment_id);
	public void updatePayment(Payment payment);
	public void deleteById(int payment_id);
	public void savepayment(Payment p);
	List<Payment> findPaymentsByuserid(int userid);
	//List<Payment> getPaymentsByBookingId(int booking_id);
	
	
}