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

import com.bean.demo.dao.UserAirDao;
import com.bean.demo.entity.Flight;
import com.bean.demo.entity.UserAir;
import com.bean.demo.service.UserAirService;
@CrossOrigin(origins = "http://localhost:4200/")
@RestController
@RequestMapping("userair")

public class UserAirController {
	@Autowired
	UserAirService service;
	@Autowired
	UserAirDao dao;
	
	@GetMapping("/viewAllUsers")
	public ResponseEntity<List<UserAir>>findAll()
	{
		return new ResponseEntity<List<UserAir>>(this.service.findALL(), HttpStatus.OK);
	}
	
	
	@PostMapping("/registerUser")
	public ResponseEntity<Map<String,String>> register(@RequestBody UserAir user)
	{
		this.service.saveOrUpdate(user);
		Map<String,String> response=new HashMap<String,String>();
		response.put("status", "success");
		response.put("message", "User registered!!");
	return new ResponseEntity<Map<String,String>>(response,HttpStatus.CREATED);
	}
	@PutMapping("/updateUser")
	public ResponseEntity<Map<String,String>> updateUser(@RequestBody UserAir e)
	{
		try
		{
			if(this.dao.findById(e.getUserid()).isPresent())
			{
			UserAir existingEmp=this.dao.findById(e.getUserid()).get();
			existingEmp.setFirst_name(e.getFirst_name());
			existingEmp.setLast_name(e.getLast_name());
			existingEmp.setUsername(e.getUsername());
			existingEmp.setPassword(e.getPassword());
			
			this.service.saveOrUpdate(e);
			Map<String,String> response=new HashMap<String,String>();
			response.put("status", "success");
			response.put("message", "User data updated!!");
			return new ResponseEntity<Map<String,String>>(response, HttpStatus.CREATED);
			}
			else
			{
				Map<String,String> response=new HashMap<String,String>();
				response.put("status", "failed");
				response.put("message", "User data  not found!!");
				return new ResponseEntity<Map<String,String>>(response, HttpStatus.NOT_FOUND);
			}
		}
		catch(Exception e1)
		{
			Map<String,String> response=new HashMap<String,String>();
			response.put("status", "failed");
			response.put("message", "user data not updated!!");
			return new ResponseEntity<Map<String,String>>(response, HttpStatus.BAD_REQUEST);
		}
	}
	@GetMapping("/findUser/{userid}")
	public ResponseEntity<?> getUserByID(@PathVariable int userid)
	{
		if(this.service.findUserById(userid).isPresent())
		{
			return new ResponseEntity<UserAir>(this.service.findUserById(userid).get(),HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<String>("User Id  not found!",HttpStatus.NOT_FOUND);
		}
	}
	@GetMapping("/search/{username}")
	public ResponseEntity<?> findByUsername(@PathVariable String username)
	{
		/*
		 * if(this.dao.findByUsername(username).isPresent()) { return new
		 * ResponseEntity<UserAir>(this.dao.findByUsername(username).get(),HttpStatus.OK
		 * ); } else { return new
		 * ResponseEntity<String>("User Id  not found!",HttpStatus.NOT_FOUND); }
		 */
		 Optional<UserAir> userOptional = Optional.of(this.dao.findByUsername(username));

		    if (userOptional.isPresent()) {
		        return new ResponseEntity<>(userOptional.get(), HttpStatus.OK);
		    } else {
		        return new ResponseEntity<>("User not found!", HttpStatus.NOT_FOUND);
		    }
	}
	@DeleteMapping("/deleteUser/{userid}")
	public ResponseEntity<Map<String,String>> deleteUser(@PathVariable(name="userid")int  userid)
	{
		try
		{
			this.service.deleteById(userid);
			Map<String,String> response=new HashMap<String,String>();
			response.put("status", "success");
			response.put("message", "user  data deleted!!");
			return new ResponseEntity<Map<String,String>>(response, HttpStatus.OK);
		}
		catch(Exception e)
		{
			Map<String,String> response=new HashMap<String,String>();
			response.put("status", "failed");
			response.put("message", "user data not deleted!!");
			return new ResponseEntity<Map<String,String>>(response, HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping("/loginUser") public ResponseEntity<?> Userlogin(@RequestBody UserAir userdata){
		UserAir user=dao.findByUsername(userdata.getUsername());
		if(user.getPassword().equals(userdata.getPassword())) {
			UserAir senduser=new UserAir();
			senduser.setUserid(user.getUserid());
			senduser.setUsername(user.getUsername());
			senduser.setEmail(user.getEmail());
			senduser.setFirst_name(user.getFirst_name());
			senduser.setLast_name(user.getLast_name());
			senduser.setAddress(user.getAddress());
			senduser.setDate_of_birth(user.getDate_of_birth());
			return ResponseEntity.ok(senduser);
		}
		else {
			 System.out.println("Admin login failed for: " + userdata.getUsername());
			  return (ResponseEntity<?>) ResponseEntity.internalServerError(); 
			 
		}
		
	}
	

}
