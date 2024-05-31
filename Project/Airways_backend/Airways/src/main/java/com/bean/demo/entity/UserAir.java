package com.bean.demo.entity;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="userair")
public class UserAir {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="userid")
	private int userid;
	
	@NotNull(message = "first name can not be empty")
	@Size(max = 20,message = "first name can't be more than 20 characters")
	@Size(min=4, message="first name must be more than 4 characters")	
	@Column(name="first_name")
	private String first_name;
	
	@NotNull(message = "last name can not be empty")
	@Size(max = 20,message = "last name can't be more than 20 characters")
	@Size(min=4, message="last name must be more than 4 characters")	
	@Column(name="last_name")
	private String last_name;
	
	@NotNull(message = "username can not be empty")
	@Size(min = 5, max =20,message = "username must be between 5 to 20 characters long.")	
	@Column(name="username")
	private String username;
	
	@NotNull(message = "password can not be empty")
	@Size(min = 5, max =20,message = "password must be between 8 to 20 characters long.")	
	 @Column(name="password")
	private String password;
	 
	@Column(name="date_of_birth")
	private LocalDate date_of_birth;
	 
	@NotNull(message = "address can not be empty")
	@Size(max = 20,message = "address can't be more than 20 characters")
	@Size(min=4, message="address must be more than 4 characters")
	@Column(name="Address")
	private String Address;
	
	private String email;
	 
	/*
	private int booking_id;
	@OneToOne(cascade = CascadeType.PERSIST) 
	 @JoinColumn(name = "booking_id",insertable=false,updatable=false)
    private Booking booking;
	//private List<Booking> bookings;
	
	public Booking getBooking() {
		return booking;
	}


	public void setBooking(Booking booking) {
		this.booking = booking;
	}
	public int getBooking_id() {
		return booking_id;
	}


	public void setBooking_id(int booking_id) {
		this.booking_id = booking_id;
	}

	
*/

	public UserAir() {
		super();
		// TODO Auto-generated constructor stub
	}


	public UserAir(int userid,
	String first_name, String last_name, String username,
	String password,LocalDate date_of_birth,
	String Address,String email) {
		super();
		this.userid = userid;
		this.first_name = first_name;
		this.last_name = last_name;
		this.username = username;
		this.password = password;
		this.date_of_birth=date_of_birth;
		this.Address=Address;
		this.email=email;
	}


	public int getUserid() {
		return userid;
	}


	public void setUserid(int userid) {
		this.userid = userid;
	}


	public String getFirst_name() {
		return first_name;
	}


	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}


	public String getLast_name() {
		return last_name;
	}


	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public LocalDate getDate_of_birth() {
		return date_of_birth;
	}


	public void setDate_of_birth(LocalDate date_of_birth) {
		this.date_of_birth = date_of_birth;
	}


	public String getAddress() {
		return Address;
	}


	public void setAddress(String address) {
		Address = address;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	
	

	
	 
	 
}