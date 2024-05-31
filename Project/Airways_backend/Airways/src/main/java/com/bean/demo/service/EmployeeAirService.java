package com.bean.demo.service;

import java.util.List;
import java.util.Optional;

import com.bean.demo.entity.EmployeeAir;


public interface EmployeeAirService {
	public List<EmployeeAir>findALL();
	public void saveOrUpdate(EmployeeAir e);
	public Optional<EmployeeAir> findEmployeeById(int empid);//by id
	public void deleteById(int empid);//delete
	EmployeeAir findByEmpname(String empname);//by name

}
