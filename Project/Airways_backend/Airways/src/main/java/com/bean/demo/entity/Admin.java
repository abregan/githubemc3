package com.bean.demo.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Table(name="adminnew")
public class Admin {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	
	@Column(name="adminid")
	private int adminid;
	
	@NotNull(message = "admin name can not be empty")
	@Size(max = 20,message = "admin name can't be more than 20 characters")
	@Size(min=4, message="admin name must be more than 4 characters")	
	@Column(name="adminName")
	private String adminName;
	
	@NotNull(message = "password can not be empty")
	@Size(min = 5, max =20,message = "password must be between 5 to 20 characters long.")	
	@Column(name="adminPassword")
	private String adminPassword;
	
	
	@NotNull(message = "address can not be empty")
	@Size(max = 20,message = "address can't be more than 20 characters")
	@Size(min=4, message="address must be more than 4 characters") 
	@Column(name="address")
	private String address;
	
	 
	@Pattern(regexp = "[0-9]+", message = "Admin phone must contain only digits")
	@NotNull(message = "mobile can not be empty")
	@Size(min = 10, max =10,message = "mobile must be between 10 characters long.")	
	@Column(name="mobile",length=10)
	private String mobile;
	
	/*
	 * @OneToMany(mappedBy="admin") private Set<Flight> flight;
	 */
	
	public Admin() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	public Admin(int adminid,
			 String adminName,
			String adminPassword,
			String address, String mobile) {
		super();
		this.adminid = adminid;
		this.adminName = adminName;
		this.adminPassword = adminPassword;
		this.address = address;
		this.mobile = mobile;
	}



	public int getAdminid() {
		return adminid;
	}

	public void setAdminid(int adminid) {
		this.adminid = adminid;
	}

	public String getAdminName() {
		return adminName;
	}

	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}

	public String getAdminPassword() {
		return adminPassword;
	}

	public void setAdminPassword(String adminPassword) {
		this.adminPassword = adminPassword;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}



	public String getMobile() {
		return mobile;
	}



	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	
	
	
	
	






	
	/*
	 * public Flight getFlight() { return flight; }
	 */

}
