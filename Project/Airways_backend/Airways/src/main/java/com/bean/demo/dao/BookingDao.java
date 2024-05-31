/*package com.bean.demo.dao;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bean.demo.entity.Booking;
//import com.example.demo.entity.Order;


public interface BookingDao extends JpaRepository<Booking, Integer>
{
	public List<Booking> findByUserairUserid(long userid);

	//public List<Booking> findByUserId(int userId);
	List<Booking> findByUserUserId(long userid);
	//public List<Booking> findByUserairUserId(long userId);

	public List<Booking> findBookingByUserId(int userid);

}*/


package com.bean.demo.dao;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.bean.demo.entity.Booking;

public interface BookingDao extends JpaRepository<Booking, Integer> {
    List<Booking> findBookingsByUserairUserid(int userid);
}
