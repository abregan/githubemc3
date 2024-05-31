package com.bean.demo.service;

import java.util.List;
import java.util.Optional;

import com.bean.demo.entity.Booking;
//import com.example.demo.entity.Order;
//import com.example.demo.entity.Order;

public interface BookingService {
    /*void addBooking(Booking booking);
    List<Booking> findAllBookings();
    Optional<Booking> findBookingById(int bookingId);
    void updateBooking(Booking booking);
    void deleteBookingById(int bookingId);*/
	
	public List<Booking> getAllBookings();
	public Booking getBookingById(int booking_id);
	public Booking saveBooking(Booking booking,int userid,int flightId);
	public void deleteBooking(int booking_id);
	public List<Booking> findBookingByUserId(int userid);
}