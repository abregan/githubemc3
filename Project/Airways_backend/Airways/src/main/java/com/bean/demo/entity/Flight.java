package com.bean.demo.entity;

import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "flight")
public class Flight {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "flight_id")
    private int flightId;

    @NotNull(message = "flightName can not be empty")
    @Size(max = 20, message = "flightName can't be more than 20 characters")
	@Column(name = "flight_name")
    private String flightName;

    @NotNull(message = "arrival_time can not be empty")
    @Column(name = "arrival_time")
	private LocalTime arrival_time;
    
    @NotNull(message = "depature_time can not be empty")
	@Column(name = "depature_time")
	private LocalTime depature_time;

	@NotNull(message = "start_place can not be empty")
	@Size(max = 20, message = "start_place can't be more than 20 characters")
	@Size(min = 4, message = "start_place must be more than 4 characters")
	@Column(name = "start_place")
	private String start_place;

	@NotNull(message = "endPlace can not be empty")
	@Size(max = 20, message = "endPlace can't be more than 20 characters")
    @Column(name = "end_place")
    private String endPlace;

	@NotNull(message = "noOfSeats can not be empty")
    @Column(name = "no_of_seats")
    private int noOfSeats;

	@NotNull(message = "price can not be empty")
    @Column(name = "price")
    private int price;
/*
    @Column(name = "seatsBooked")
    private int seatsBooked;
*/
    public Flight() {
        // Default constructor
    }

	

	public Flight(int flightId, String flightName, LocalTime arrival_time, LocalTime depature_time,
	String start_place,
		String endPlace, int noOfSeats, int price) {
	super();
	this.flightId = flightId;
	this.flightName = flightName;
	this.arrival_time = arrival_time;
	this.depature_time = depature_time;
	this.start_place = start_place;
	this.endPlace = endPlace;
	this.noOfSeats = noOfSeats;
	this.price = price;
}



	public int getFlightId() {
		return flightId;
	}

	public void setFlightId(int flightId) {
		this.flightId = flightId;
	}

	public String getFlightName() {
		return flightName;
	}

	public void setFlightName(String flightName) {
		this.flightName = flightName;
	}

	public LocalTime getArrival_time() {
		return arrival_time;
	}

	public void setArrival_time(LocalTime arrival_time) {
		this.arrival_time = arrival_time;
	}

	public LocalTime getDepature_time() {
		return depature_time;
	}

	public void setDepature_time(LocalTime depature_time) {
		this.depature_time = depature_time;
	}

	public String getStart_place() {
		return start_place;
	}

	public void setStart_place(String start_place) {
		this.start_place = start_place;
	}

	public String getEndPlace() {
		return endPlace;
	}

	public void setEndPlace(String endPlace) {
		this.endPlace = endPlace;
	}

	public int getNoOfSeats() {
		return noOfSeats;
	}

	public void setNoOfSeats(int noOfSeats) {
		this.noOfSeats = noOfSeats;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	

    // Getter and Setter methods...

   
    
  
    
}
