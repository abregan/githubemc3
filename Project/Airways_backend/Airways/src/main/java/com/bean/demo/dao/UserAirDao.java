package com.bean.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bean.demo.entity.UserAir;


@Repository
public interface UserAirDao extends JpaRepository<UserAir, Integer>
{
	UserAir findByUsername(String username);
}