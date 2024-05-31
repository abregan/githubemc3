package com.bean.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bean.demo.dao.EmployeeAirDao;
import com.bean.demo.entity.EmployeeAir;

@Service
public class EmployeeAirServiceImpl implements EmployeeAirService {
	@Autowired
	EmployeeAirDao dao;

	@Override
	public List<EmployeeAir> findALL() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}

	@Override
	public void saveOrUpdate(EmployeeAir e) {
		dao.save(e);
		
	}

	@Override
	public Optional<EmployeeAir> findEmployeeById(int empid) {
		// TODO Auto-generated method stub
		return dao.findById(empid);
	}

	@Override
	public void deleteById(int empid) {
		// TODO Auto-generated method stub
		dao.deleteById(empid);
	}

	public EmployeeAir findByEmpname(String empname) {
		// TODO Auto-generated method stub
		return dao.findByEmpname(empname);
	}
	

	
	
}
