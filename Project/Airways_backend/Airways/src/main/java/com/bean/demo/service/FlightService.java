package com.bean.demo.service;

import java.util.List;
import java.util.Optional;

import com.bean.demo.entity.Flight;

public interface FlightService {
	public List<Flight>findALL();
	public void saveOrUpdate(Flight f);
	public Optional<Flight> findFlightById(int flightId);
	public void deleteById(int flightId);
	Flight findByFlightName(String flightName);
}
