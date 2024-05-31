package com.bean.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bean.demo.entity.EmployeeAir;

@Repository
public interface EmployeeAirDao extends JpaRepository<EmployeeAir, Integer>
{
	EmployeeAir findByEmpname(String empname);
	//EmployeeAir findByEmpRole(String empname);
}
