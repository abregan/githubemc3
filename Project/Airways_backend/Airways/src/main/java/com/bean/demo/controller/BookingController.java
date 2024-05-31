package com.bean.demo.controller;

import com.bean.demo.entity.Booking;
import com.bean.demo.exception.BookingIdNotFoundException;
import com.bean.demo.service.BookingService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200/")
@RestController
@RequestMapping("booking")
public class BookingController {


    @Autowired
    private BookingService bookingService;

    @PostMapping("/bookflight/{flight_id}/{userid}")
    public ResponseEntity<Booking> createBooking(@RequestBody Booking booking, @PathVariable int userid,
                                               @PathVariable int flight_id) {
        System.out.println("Received a request to create an booking for Booking Id: " + userid + " and : flight_id" + flight_id);

        Booking saveBooking = bookingService.saveBooking(booking, userid, flight_id);
        System.out.println("booking created successfully: " + saveBooking);

        return ResponseEntity.ok(saveBooking);
    }

    @GetMapping("/viewallbookings")
    public ResponseEntity<List<Booking>> getAllBookings() {
        System.out.println("Received a request to fetch all bookings.");

        List<Booking> booking = bookingService.getAllBookings();
        System.out.println("Returning all bookings: " + booking);

        return new ResponseEntity<>(booking, HttpStatus.OK);
    }

    @GetMapping("/{booking_id}")
    public ResponseEntity<Booking> getBookingById(@PathVariable int booking_id) throws BookingIdNotFoundException {
        System.out.println("Received a request to fetch booking by ID: " + booking_id);

        Booking booking = bookingService.getBookingById(booking_id);
        if (booking == null) {
            System.out.println("booking not found for ID: " + booking_id);
            throw new BookingIdNotFoundException("booking with ID " + booking_id + " not found.");
        }

        System.out.println("Returning booking for ID " + booking_id + ": " + booking_id);
        return new ResponseEntity<>(booking, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{booking_id}")
    public ResponseEntity<Void> deleteBooking(@PathVariable int booking_id) {
        System.out.println("Received a request to delete booking by ID: " + booking_id);
        
        bookingService.deleteBooking(booking_id);
        System.out.println("booking deleted successfully for ID: " + booking_id);
        
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/user/{userid}")
    public ResponseEntity<?> getBookingByUserId(@PathVariable int userid) {
        System.out.println("Received a request to fetch booking by user ID: " + userid);

        try {
            List<Booking> bookings = bookingService.findBookingByUserId(userid);
            if (bookings.isEmpty()) {
                System.out.println("No bookings found for user ID: " + userid);
                return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
            }

            System.out.println("Returning bookings for user ID " + userid + ": " + bookings);
            return ResponseEntity.ok(bookings);
        } catch (Exception e) {
            System.out.println("An error occurred while fetching bookings for user ID " + userid + ": " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("An error occurred: " + e.getMessage());
        }
    }
}
