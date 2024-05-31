package com.bean.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bean.demo.entity.Admin;

@Repository
public interface AdminDao extends JpaRepository<Admin, Integer>
{
	Admin findByAdminName(String adminName);
}
