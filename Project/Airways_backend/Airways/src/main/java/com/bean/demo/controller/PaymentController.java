package com.bean.demo.controller;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bean.demo.dao.PaymentDao;
import com.bean.demo.entity.Booking;
import com.bean.demo.entity.Flight;
import com.bean.demo.entity.Payment;
import com.bean.demo.exception.PaymentIdNotFoundException;
import com.bean.demo.service.PaymentService;
@CrossOrigin(origins = "http://localhost:4200/")
@RestController
@RequestMapping("/Payment")
public class PaymentController {
	 @Autowired
	    PaymentService service;
	   
	    @Autowired
	    PaymentDao dao;

	    
	    @PostMapping("/addPay/{booking_id}/{userid}")
	    public ResponseEntity<Payment> addPay(@RequestBody Payment payment,@PathVariable int booking_id, @PathVariable int userid) {

	    	        
	    	        Payment addedPayment = service.addPay(payment,booking_id,userid);
	    	        
	    	        System.out.println("Payment added: " + addedPayment);
	    	        return new ResponseEntity<>(addedPayment, HttpStatus.CREATED);
	        
	    } 

	    
	    
	    
	    
	    @GetMapping("/viewPay")
	    public ResponseEntity<List<Payment>> findAll()
	    {
	        return new ResponseEntity<List<Payment>>(this.service.findALL(), HttpStatus.OK);
	    }
	    
	    
	   
	    
	    @GetMapping("/findPay/{payment_id}")
	    public ResponseEntity<?> getUserByID1(@PathVariable int payment_id)
	    {
	        if(this.service.findUserById(payment_id).isPresent())
	        {
	            return new ResponseEntity<Payment>(this.service.findUserById(payment_id).get(),HttpStatus.OK);
	        }
	        else
	        {
	            return new ResponseEntity<String>("Payment not found!",HttpStatus.NOT_FOUND);
	        }
	    }
	    
	    
	   
	    
	    @PutMapping("/updatePay")
	    public ResponseEntity<Map<String,String>> updatePayment(@RequestBody Payment p)
	    {
	        try
	        {
	            if(this.dao.findById(p.getPayment_id()).isPresent())
	            {
	            Payment existing=this.dao.findById(p.getPayment_id()).get();
	            existing.setBooking(p.getBooking());
	            existing.setAmount(p.getAmount());
	            existing.setNameOnCard(p.getNameOnCard());
	            existing.setCardNumber(p.getCardNumber());
	            existing.setCvv(p.getCvv());
	            existing.setExpYear(p.getExpYear());
	            existing.setMethod(p.getMethod());
	            existing.setPaidDate(p.getPaidDate());
	            existing.setPayment_id(p.getPayment_id());

	            this.service.addPay(p,0,0);
	            Map<String,String> response=new HashMap<String,String>();
	            response.put("status", "success");
	            response.put("message", "Pay data updated!!");
	            return new ResponseEntity<Map<String,String>>(response, HttpStatus.CREATED);
	            }
	            else
	            {
	                Map<String,String> response=new HashMap<String,String>();
	                response.put("status", "failed");
	                response.put("message", "pay data  not found!!");
	                return new ResponseEntity<Map<String,String>>(response, HttpStatus.NOT_FOUND);
	            }
	        }
	        catch(Exception e1)
	        {
	            Map<String,String> response=new HashMap<String,String>();
	            response.put("status", "failed");
	            response.put("message", "Comment not updated!!");
	            return new ResponseEntity<Map<String,String>>(response, HttpStatus.BAD_REQUEST);
	        }
	    	    }
	    
	    
	    
	    @DeleteMapping("/deletePay/{payment_id}")
	    public ResponseEntity<Map<String,String>> deleteById(@PathVariable("payment_id")int  payment_id)
	    {
	        try
	        {
	            this.service.deleteById(payment_id);
	            Map<String,String> response=new HashMap<String,String>();
	            response.put("status", "success");
	            response.put("message", "Pay data deleted!!");
	            return new ResponseEntity<Map<String,String>>(response, HttpStatus.OK);
	        }
	        catch(Exception e)
	        {
	            Map<String,String> response=new HashMap<String,String>();
	            response.put("status", "failed");
	            response.put("message", "Pay data not deleted!!");
	            return new ResponseEntity<Map<String,String>>(response, HttpStatus.NOT_FOUND);
	        }
	    }

	    
	    
	    
	    @GetMapping("/userAir/{userid}")
	    public ResponseEntity<List<Payment>> getPaymentsByCustomerId(@PathVariable int userid) {
	        //System.out.println("Received a request to fetch payments for customer ID: " + customerId);
	        
	        
			List<Payment> payments = service.findPaymentsByuserid(userid);
	        if (payments.isEmpty()) {
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	        }
	        
	        System.out.println("Returning payments for user id " + userid + ": " + payments);
	        return new ResponseEntity<>(payments, HttpStatus.OK);
	    }
	    
	    /*
	    @GetMapping("/bookingId/{booking_id}")
	    public ResponseEntity<List<Payment>> getPaymentsByBookingId(@PathVariable int booking_id) throws PaymentIdNotFoundException {
	        System.out.println("Received a request to fetch payments for booking ID: " + booking_id);
	        
	        List<Payment> payments = service.getPaymentsByBookingId(booking_id);
	        if (payments.isEmpty()) {
	            System.out.println("No payments found for order ID: " + booking_id);
	            throw new PaymentIdNotFoundException("Payments with order ID " + booking_id + " not found.");
	        }
	        
	        System.out.println("Returning payments for order ID " + booking_id + ": " + payments);
	        return ResponseEntity.ok(payments);
	    }
 
	    */
	    
	    
}