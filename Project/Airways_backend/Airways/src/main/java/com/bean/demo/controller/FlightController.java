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

import com.bean.demo.dao.FlightDao;
import com.bean.demo.entity.Flight;
import com.bean.demo.service.FlightService;
@CrossOrigin(origins = "http://localhost:4200/")
@RestController
@RequestMapping("flight")
public class FlightController {
	@Autowired
	FlightService service;
	@Autowired
	FlightDao dao;
	
	@GetMapping("/viewAllFlight")
	public ResponseEntity<List<Flight>>findAll()
	{
		return new ResponseEntity<List<Flight>>(this.service.findALL(), HttpStatus.OK);
	}
	
	@PostMapping("/addFlight")
	public ResponseEntity<Map<String,String>> register(@RequestBody Flight flight)
	{
		this.service.saveOrUpdate(flight);
		Map<String,String> response=new HashMap<String,String>();
		response.put("status", "success");
		response.put("message", "Flight added!!");
	return new ResponseEntity<Map<String,String>>(response,HttpStatus.CREATED);
	}
	
	 @PutMapping("/updateFlight")
		public ResponseEntity<Map<String,String>> updateFlight(@RequestBody Flight e)
		{
			try
			{
				if(this.dao.findById(e.getFlightId()).isPresent())
				{
				Flight existingFlight=this.dao.findById(e.getFlightId()).get();
				existingFlight.setFlightName(e.getFlightName());
				
				existingFlight.setArrival_time(e.getArrival_time());
				existingFlight.setDepature_time(e.getDepature_time());
				existingFlight.setStart_place(e.getStart_place());
				
				
				this.service.saveOrUpdate(e);
				Map<String,String> response=new HashMap<String,String>();
				response.put("status", "success");
				response.put("message", "Flight data updated!!");
				return new ResponseEntity<Map<String,String>>(response, HttpStatus.CREATED);
				}
				else
				{
					Map<String,String> response=new HashMap<String,String>();
					response.put("status", "failed");
					response.put("message", "Flight data  not found!!");
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
	@GetMapping("/findFlightId/{flightId}")
	public ResponseEntity<?> getFlightByID(@PathVariable int flightId)
	{
		if(this.service.findFlightById(flightId).isPresent())
		{
			return new ResponseEntity<Flight>(this.service.findFlightById(flightId).get(),HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<String>("User Id  not found!",HttpStatus.NOT_FOUND);
		}
	}
	
	
	@GetMapping("/searchFlightName/{flightName}")
	public ResponseEntity<?> findByFlightName(@PathVariable String flightName)
	{
		Optional<Flight> userOptional = Optional.of(this.dao.findByFlightName(flightName));

	    if (userOptional.isPresent()) {
	        return new ResponseEntity<>(userOptional.get(), HttpStatus.OK);
	    } else {
	        return new ResponseEntity<>("Flight not found!", HttpStatus.NOT_FOUND);
	    }
  }
	
	@DeleteMapping("/deleteFlight/{flightId}")
	public ResponseEntity<Map<String,String>> deleteFlight(@PathVariable(name="flightId")int  flightId)
	{
		try
		{
			this.service.deleteById(flightId);
			Map<String,String> response=new HashMap<String,String>();
			response.put("status", "success");
			response.put("message", "Flight  data deleted!!");
			return new ResponseEntity<Map<String,String>>(response, HttpStatus.OK);
		}
		catch(Exception e)
		{
			Map<String,String> response=new HashMap<String,String>();
			response.put("status", "failed");
			response.put("message", "Flight data not deleted!!");
			return new ResponseEntity<Map<String,String>>(response, HttpStatus.NOT_FOUND);
		}
	}
}
