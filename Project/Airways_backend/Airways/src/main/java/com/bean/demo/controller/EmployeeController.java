package com.bean.demo.controller;

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

import com.bean.demo.dao.EmployeeAirDao;
import com.bean.demo.entity.Admin;
import com.bean.demo.entity.EmployeeAir;
import com.bean.demo.service.EmployeeAirService;

@CrossOrigin(origins = "http://localhost:4200/")
@RestController
@RequestMapping("employeeair")

public class EmployeeController<employeeair> {
	@Autowired
	EmployeeAirDao dao;
	@Autowired
	EmployeeAirService service;
	
	
	@GetMapping("viewAllEmployee")
	public ResponseEntity<List<EmployeeAir>>findAll(){
		return new ResponseEntity<List<EmployeeAir>>(this.service.findALL() ,HttpStatus.OK);
	}
	
	@PostMapping("/addEmployee")
	public ResponseEntity<Map<String,String>> register(@RequestBody EmployeeAir emp)
	{
		this.service.saveOrUpdate(emp);
		Map<String,String> response=new HashMap<String,String>();
		response.put("status", "success");
		response.put("message", "Employee added!!");
	return new ResponseEntity<Map<String,String>>(response,HttpStatus.CREATED);
	}
	
	
	
	@PutMapping("/updateEmployee")
	public ResponseEntity<Map<String,String>> updateUser(@RequestBody EmployeeAir e)
	{
		try
		{
			if(this.dao.findById(e.getEmpid()).isPresent())
			{
				EmployeeAir existingEmp=this.dao.findById(e.getEmpid()).get();
			existingEmp.setFirst_name(e.getFirst_name());
			existingEmp.setLast_name(e.getLast_name());
			existingEmp.setEmpname(e.getEmpname());
			existingEmp.setPassword(e.getPassword());
			
			this.service.saveOrUpdate(e);
			Map<String,String> response=new HashMap<String,String>();
			response.put("status", "success");
			response.put("message", "Employee data updated!!");
			return new ResponseEntity<Map<String,String>>(response, HttpStatus.CREATED);
			}
			else
			{
				Map<String,String> response=new HashMap<String,String>();
				response.put("status", "failed");
				response.put("message", "Employee data  not found!!");
				return new ResponseEntity<Map<String,String>>(response, HttpStatus.NOT_FOUND);
			}
		}
		catch(Exception e1)
		{
			Map<String,String> response=new HashMap<String,String>();
			response.put("status", "failed");
			response.put("message", "Employee data not updated!!");
			return new ResponseEntity<Map<String,String>>(response, HttpStatus.BAD_REQUEST);
		}
			
	}
	@GetMapping("/searchEmployee/{empname}")
	public ResponseEntity<?> findByEmpname(@PathVariable String empname)
	{
		Optional<EmployeeAir> userOptional = Optional.of(this.dao.findByEmpname(empname));

	    if (userOptional.isPresent()) {
	        return new ResponseEntity<>(userOptional.get(), HttpStatus.OK);
	    } else {
	        return new ResponseEntity<>("Employee not found!", HttpStatus.NOT_FOUND);
	    }
  }
	
	@GetMapping("/findEmployee/{empid}")
	public ResponseEntity<?> getEmployeeByID(@PathVariable int empid)
	{
		if(this.service.findEmployeeById(empid).isPresent())
		{
			return new ResponseEntity<EmployeeAir>(this.service.findEmployeeById(empid).get(),HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<String>("employee Id  not found!",HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping("/deleteEmployee/{empid}")
	public ResponseEntity<Map<String,String>> deleteUser(@PathVariable(name="empid")int  empid)
	{
		try
		{
			this.service.deleteById(empid);
			Map<String,String> response=new HashMap<String,String>();
			response.put("status", "success");
			response.put("message", "Employee  data deleted!!");
			return new ResponseEntity<Map<String,String>>(response, HttpStatus.OK);
		}
		catch(Exception e)
		{
			Map<String,String> response=new HashMap<String,String>();
			response.put("status", "failed");
			response.put("message", "Employee data not deleted!!");
			return new ResponseEntity<Map<String,String>>(response, HttpStatus.NOT_FOUND);
		}
	}
	
	  @PostMapping("/loginEmployee") public ResponseEntity<?> Employeelogin(@RequestBody EmployeeAir emp)
	  {
		  EmployeeAir empair=dao.findByEmpname(emp.getEmpname());
		  if(empair.getPassword().equals(emp.getPassword())) {
			  EmployeeAir sendemp=new EmployeeAir();
			  sendemp.setEmpname(empair.getEmpname());
			  sendemp.setEmpid(empair.getEmpid());
			  sendemp.setEmp_role(empair.getEmp_role());
			  sendemp.setAddress(empair.getAddress());
			  sendemp.setFirst_name(empair.getFirst_name());
			  sendemp.setLast_name(empair.getLast_name());
			  sendemp.setDate_of_birth(empair.getDate_of_birth());
			  
			  
			  return ResponseEntity.ok(sendemp);
		  }
		  else {System.out.println("Employee login failed for: " + emp.getEmpname());
		  return (ResponseEntity<?>) ResponseEntity.internalServerError(); 
		  
			  
			  
			  
		  }
	  }
		  
}

