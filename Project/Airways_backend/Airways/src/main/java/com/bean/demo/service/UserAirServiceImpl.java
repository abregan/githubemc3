package com.bean.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bean.demo.dao.UserAirDao;
import com.bean.demo.entity.Flight;
import com.bean.demo.entity.UserAir;

@Service
public class UserAirServiceImpl implements  UserAirService{
	@Autowired
	UserAirDao dao;
	
	@Override
	public List<UserAir> findALL() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}

	@Override
	public void saveOrUpdate(UserAir u) {
		// TODO Auto-generated method stub
		dao.save(u);
		
	}

	@Override
	public Optional<UserAir> findUserById(int userid) {
		// TODO Auto-generated method stub
		return dao.findById(userid);
	}

	@Override
	public void deleteById(int userid) {
		// TODO Auto-generated method stub
		dao.deleteById(userid);
	}

	@Override
	public UserAir findByUsername(String username) {
		// TODO Auto-generated method stub
		return dao.findByUsername(username);
	}

	
	
	

}
