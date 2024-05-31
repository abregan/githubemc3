package com.bean.demo.service;

import com.bean.demo.dao.BookingDao;
import com.bean.demo.dao.FlightDao;
import com.bean.demo.entity.Booking;
import com.bean.demo.entity.Flight;
import com.bean.demo.entity.UserAir;
import com.bean.demo.service.UserAirService;
import com.bean.demo.service.FlightService;

//import com.example.demo.dao.OrdersRepository;
//import com.example.demo.entity.Customer;
//import com.example.demo.entity.Menu;
//import com.example.demo.entity.Order;
//import com.example.demo.service.CustomerService;
//import com.example.demo.service.MenuService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class BookingServiceImpl implements BookingService {
 
	private final BookingDao bookingDao;
    //@Autowired
   // private BookingDao bookingDao;
    @Autowired
	public BookingServiceImpl(BookingDao bookingDao) {
		this.bookingDao = bookingDao;
		}
    @Autowired
    UserAirService userservice;
	@Autowired
	FlightService flightservice;
	
	@Override
	public List<Booking> getAllBookings() {
		return bookingDao.findAll();
	}
	@Override
	public Booking getBookingById(int booking_id) {
		return bookingDao.findById(booking_id).orElse(null);
	}
	
	@Override
	public void deleteBooking(int booking_id) {
		bookingDao.deleteById(booking_id);

	}
	@Override
	public Booking saveBooking(Booking booking,int userid,int flightId) {
		// Check if customer exists
		UserAir user = userservice.findUserById(userid).orElse(null);
		if (user == null) {
			throw new IllegalArgumentException("Invalid user ID");
		}

		// Check if menu item exists
		Flight flight = flightservice.findFlightById(flightId).orElse(null);
		if (flight == null) {
			throw new IllegalArgumentException("Invalid flight ID");
		}

		booking.setDate(new Date()); // Set the current date as the order date
		 
		// Calculate total price
		booking.calculateAmount();
		// Set initial order status
		booking.setStatus("Not Paid");

		// Set customer and menu details
		//booking.setUserair(userair);
		booking.setUserair(user);
		booking.setFlight(flight);

		// Set total price in the entity to be saved in the database
		//booking.setAmount(booking.getAmount());

		// Save the order
		return bookingDao.save(booking);
	}
	
	
	@Override
	public List<Booking> findBookingByUserId(int userid) {
		return bookingDao.findBookingsByUserairUserid(userid);
	}

	
   /* @Autowired
    private FlightDao flightDao; 
    
    @Transactional
    @Override
    public void addBooking(Booking booking) {
        	
    	 Flight flight = flightDao.findById(booking.getFlight()).orElse(null);
         booking.setFlight(flight);*/

    	
    	
            // Call bookSeats() method to update seats in associated Flight and calculate amount
          //  booking.bookSeats();

          //  booking.setStatus("pending");

          //  bookingDao.save(booking);
            

    }

    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    /*@Override
    public List<Booking> findAllBookings() {
        return bookingDao.findAll();
    }

    @Override
    public Optional<Booking> findBookingById(int booking_id) {
        return bookingDao.findById(booking_id);
    }

    @Override
    public void updateBooking(Booking booking) {
        // Implement your update logic if needed
        bookingDao.save(booking);
    }

    @Override
    public void deleteBookingById(int booking_id) {
        bookingDao.deleteById(booking_id);
    }*/

