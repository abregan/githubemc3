package com.bean.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bean.demo.dao.FlightDao;
import com.bean.demo.entity.Flight;

@Service
public class FlightServiceImpl implements FlightService{

	@Autowired 
	FlightDao dao;
	@Override
	public List<Flight> findALL() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}
	@Override
	public void saveOrUpdate(Flight f) {
		// TODO Auto-generated method stub
		dao.save(f);
	}

	@Override
	public Optional<Flight> findFlightById(int flightId) {
		// TODO Auto-generated method stub
		return dao.findById(flightId);
	}

	@Override
	public void deleteById(int flightId) {
		// TODO Auto-generated method stub
		dao.deleteById(flightId);
	}

	@Override
	public Flight findByFlightName(String flightName) {
		// TODO Auto-generated method stub
		return dao.findByFlightName(flightName);
	}

}
