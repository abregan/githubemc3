package com.bean.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bean.demo.entity.Flight;

@Repository
public interface FlightDao extends JpaRepository<Flight, Integer> {
	Flight findByFlightName(String flightName);
}
