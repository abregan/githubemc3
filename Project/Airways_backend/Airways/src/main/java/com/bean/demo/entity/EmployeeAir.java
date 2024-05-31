package com.bean.demo.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="employeeair")

public class EmployeeAir {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="empid")
	private int empid;
	
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
	
	@Size(max = 20,message = "Employee name can't be more than 20 characters")
	@Size(min=4, message="Employee name must be more than 4 characters")	
	@Column(name="empname")
	private String empname;
	
	@NotNull(message = "password can not be empty")
	@Size(min = 5, max =20,message = "password must be between 8 to 20 characters long.")
	 @Column(name="password")
	private String password;
	 
	@NotNull(message = "emp_role can not be empty")
	@Size(max = 20,message = "emp_role can't be more than 20 characters")
	@Size(min=4, message="emp_role must be more than 4 characters")
	@Column(name="emp_role")
	private String emp_role;
	 
	 @Column(name="date_of_birth")
	private LocalDate date_of_birth;
	 
	 @NotNull(message = "address can not be empty")
	@Size(max = 20,message = "address can't be more than 20 characters")
	@Size(min=7, message="address must be more than 7 characters")
	 @Column(name="Address")
		private String Address;

	public EmployeeAir() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	public EmployeeAir(int empid, String first_name,String last_name, String empname,
	 String password, String emp_role,
			LocalDate date_of_birth,  String address) {
		super();
		this.empid = empid;
		this.first_name = first_name;
		this.last_name = last_name;
		this.empname = empname;
		this.password = password;
		this.emp_role = emp_role;
		this.date_of_birth = date_of_birth;
		Address = address;
	}



	public int getEmpid() {
		return empid;
	}

	public void setEmpid(int empid) {
		this.empid = empid;
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

	public String getEmpname() {
		return empname;
	}

	public void setEmpname(String empname) {
		this.empname = empname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	

	public String getEmp_role() {
		return emp_role;
	}



	public void setEmp_role(String emp_role) {
		this.emp_role = emp_role;
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

	
	 
	 

}
