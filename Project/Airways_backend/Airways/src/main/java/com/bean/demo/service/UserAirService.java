package com.bean.demo.service;

import java.util.List;
import java.util.Optional;

import com.bean.demo.entity.UserAir;
public interface UserAirService {
	public List<UserAir>findALL();
	public void saveOrUpdate(UserAir u);
	public Optional<UserAir> findUserById(int userid);//by id
	public void deleteById(int userid);//delete
	UserAir findByUsername(String username);//by name
}
