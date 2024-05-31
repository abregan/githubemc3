package com.bean.demo.entity;

import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;


@Entity
@Table(name = "booking")

public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "booking_id",unique=true)
    private int booking_id;
    
    @ManyToOne(targetEntity = UserAir.class, cascade = { CascadeType.MERGE}, fetch = FetchType.EAGER)
    @JoinColumn(name = "userid", referencedColumnName = "userid")
    private UserAir userair;

    @Column(name = "booking_date")
    @Temporal(TemporalType.DATE)
    private Date date;
    
    @ManyToOne(targetEntity = Flight.class, cascade = { CascadeType.MERGE }, fetch = FetchType.EAGER)
    @JoinColumn(name = "flightId", referencedColumnName = "flight_id")
    private Flight flight;
   

  
    @NotNull(message = "seatstobook should not be zero")
    @Column(name = "seatstobook")
    private int seatstobook;

    @NotNull(message = "amount can not be empty")
    @Column(name = "amount")
    private double amount;
    
    
    @Column(name = "status")
    private String status;
    
   
    //@Column(name="flight_id")
    //private int flightId;
    

    /*@ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.MERGE)
    @JoinColumn(name="flight_id",insertable=false,updatable=false)
    private Flight flight;*/
    
	
    @PrePersist
    public void updateDateAndTime() {
        this.date = new Date();
    }

	

    public Booking() {
        // Default constructor
    }   

  



	

	public Booking(int booking_id, UserAir userair, Date date, Flight flight,
			int seatstobook, double amount, String status) {
		super();
		this.booking_id = booking_id;
		this.userair = userair;
		this.date = date;
		this.flight = flight;
		
		this.seatstobook = seatstobook;
		this.amount = amount;
		this.status = status;
		calculateAmount();
		 System.out.println("Amount after calculation: " + this.amount);
	}





	public int getBooking_id() {
		return booking_id;
	}



	public void setBooking_id(int booking_id) {
		this.booking_id = booking_id;
	}



	public UserAir getUserair() {
		return userair;
	}



	public void setUserair(UserAir userair) {
		this.userair = userair;
	}



	public Date getDate() {
		return date;
	}



	public void setDate(Date date) {
		this.date = date;
	}



	public Flight getFlight() {
		return flight;
	}



	public void setFlight(Flight flight) {
		this.flight = flight;
		calculateAmount();
	}



	




	public int getSeatstobook() {
		return seatstobook;
	}



	public void setSeatstobook(int seatstobook) {
		this.seatstobook = seatstobook;
	}



	public double getAmount() {
		return amount;
	}



	public void setAmount(double amount) {
		this.amount = amount;
	}



	public String getStatus() {
		return status;
	}



	public void setStatus(String status) {
		this.status = status;
	}



	public void calculateAmount() {
	    if (flight != null && seatstobook != 0 && seatstobook > 0) {
	        double seatPrice = flight.getPrice();
	        System.out.println(seatPrice);
	        amount = seatstobook * seatPrice;
	        System.out.println(amount);
	    }
	}



	



}
