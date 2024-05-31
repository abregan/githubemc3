package com.bean.demo.service;

import java.util.List;
import java.util.Optional;

import com.bean.demo.entity.Admin;

public interface AdminService {
	public List<Admin>findALL();
	public void saveOrUpdate(Admin a);
	public Optional<Admin> findAdminByAdminid(int Adminid);
	public void deleteById(int Adminid);
	Admin findByAdminName(String adminName);


}