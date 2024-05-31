
package com.bean.demo.service;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bean.demo.dao.BookingDao;
import com.bean.demo.dao.PaymentDao;
import com.bean.demo.dao.UserAirDao;
import com.bean.demo.entity.Booking;
import com.bean.demo.entity.Payment;
import com.bean.demo.entity.UserAir;

@Service
public class PaymentServiceImpl implements PaymentService {
	@Autowired
	 private PaymentDao dao;
	 
	@Autowired
   private BookingDao bookingDao;

	@Autowired
	 private UserAirDao userDao;
	
	@Autowired
	private UserAirService userairservice;

	
	@Override
	public Payment addPay(Payment payment,int booking_id,int userid) {
		Optional<Booking> optionalBooking = bookingDao.findById(booking_id);
		Optional<UserAir> optionalUser = userDao.findById(userid);
		
      if (optionalBooking.isPresent()) {
          Booking booking = optionalBooking.get();
          UserAir user = optionalUser.get();
          payment.setUser(user);
          payment.setBooking(booking);
          payment.setAmount(booking.getAmount());
          Payment addedPayment = dao.save(payment);
          
          if (payment.getAmount() == payment.getPaidAmount()) {
  			booking.setStatus("Paid");
  		} else {

  			booking.setStatus("Not Paid");
  		}
          return addedPayment;
      }
     
		return payment;
	}
/*
	@Override
	public Payment addPay(Payment payment,int booking_id,int userid) {
		Booking booking=bookingDao.getById(booking_id);
		 payment.setBooking(booking);
		 payment.setAmount(booking.getAmount());
		 payment.setPaidDate(LocalDate.now());
		 payment.setPaidAmount(booking.getAmount());
		 if(payment.getAmount()==payment.getPaidAmount()) {
			 booking.setStatus("paid");
		 }
		 else {
			 booking.setStatus("Not Paid");
		 }
		 UserAir user=userairservice.findUserById(userid).orElse(null);
		  payment.setUser(user);
		  return dao.save(payment);
		
	}
	*/
	
	
	@Override
	public List<Payment> findALL() {
		// TODO Auto-generated method stub
		 return dao.findAll();
	}

	@Override
	public Optional<Payment> findUserById(int payment_id) {
		// TODO Auto-generated method stub
		 return dao.findById(payment_id);
	}

	@Override
	public void updatePayment(Payment payment) {
		dao.save(payment);

	}


	public void deleteById(int payment_id) {
		dao.deleteById(payment_id);
	}

	
	@Override
	public void savepayment(Payment p) {
		dao.save(p);
	}

	@Override
	public List<Payment> findPaymentsByuserid(int userid) {
		return dao.findByUserUserid(userid);
	}
	/*

	@Override
	public List<Payment> getPaymentsByBookingId(int booking_id) {
		// TODO Auto-generated method stub
		return dao.getPaymentsByBookingId(booking_id);
	}
*/
}
