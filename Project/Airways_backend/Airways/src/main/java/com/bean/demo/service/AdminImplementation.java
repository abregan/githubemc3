package com.bean.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bean.demo.dao.AdminDao;
import com.bean.demo.entity.Admin;
@Service
public class AdminImplementation implements AdminService
{
@Autowired
AdminDao dao;
	@Override
	public List<Admin> findALL() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}
	@Override
	public void saveOrUpdate(Admin a) {
		dao.save(a);
		
	}
	@Override
	public Optional<Admin> findAdminByAdminid(int adminid) {
		// TODO Auto-generated method stub
		return dao.findById(adminid);
	}
	@Override
	public void deleteById(int id) {
		dao.deleteById(id);
		
	}
	@Override
	public Admin findByAdminName(String adminName) {
		// TODO Auto-generated method stub
		return dao.findByAdminName(adminName);
	}
	
}
