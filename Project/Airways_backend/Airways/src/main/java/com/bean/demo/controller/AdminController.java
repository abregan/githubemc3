package com.bean.demo.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bean.demo.dao.AdminDao;
import com.bean.demo.entity.Admin;
import com.bean.demo.service.AdminService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
@CrossOrigin(origins = "http://localhost:4200/")
@RestController
@RequestMapping("admin")
public class AdminController 
{
	
	@Autowired
	AdminService service;
	@Autowired
	AdminDao dao;
	@GetMapping("/viewAdmin")
	public ResponseEntity<List<Admin>>findAll()
	{
		return new ResponseEntity<List<Admin>>(this.service.findALL(), HttpStatus.OK);
	}
	@GetMapping("/findAdmin/{adminid}")
	public ResponseEntity<?> getAdminByAdminid(@PathVariable int adminid)
	{
		if(this.service.findAdminByAdminid(adminid).isPresent())
		{
			return new ResponseEntity<Admin>(this.service.findAdminByAdminid(adminid).get(),HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<String>("Admin Id  not found!",HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping("/registerAdmin")
	public ResponseEntity<Map<String,String>> AdminRegister(@RequestBody Admin admin)
	{
		this.service.saveOrUpdate(admin);
		Map<String,String> response=new HashMap<String,String>();
		response.put("status", "success");
		response.put("message", "Admin registered!!");
	return new ResponseEntity<Map<String,String>>(response,HttpStatus.CREATED);
	}
	
	@PutMapping("/updateAdmin")
	public ResponseEntity<Map<String,String>> updateAdmin(@RequestBody Admin e)
	{
		try
		{
			if(this.dao.findById(e.getAdminid()).isPresent())
			{
				Admin existingAdmn=this.dao.findById(e.getAdminid()).get();
				existingAdmn.setAdminid(e.getAdminid());
				//existingAdmn.setLast_name(e.getLast_name());
				existingAdmn.setAdminName(e.getAdminName());
			//existingEmp.setAddress2(e.getAddress2());
			//existingEmp.setUsername(e.getUsername());
			existingAdmn.setAdminPassword(e.getAdminPassword());
			
			this.service.saveOrUpdate(e);
			Map<String,String> response=new HashMap<String,String>();
			response.put("status", "success");
			response.put("message", "Admin data updated!!");
			return new ResponseEntity<Map<String,String>>(response, HttpStatus.CREATED);
			}
			else
			{
				Map<String,String> response=new HashMap<String,String>();
				response.put("status", "failed");
				response.put("message", "Admin data  not found!!");
				return new ResponseEntity<Map<String,String>>(response, HttpStatus.NOT_FOUND);
			}
		}
		catch(Exception e1)
		{
			Map<String,String> response=new HashMap<String,String>();
			response.put("status", "failed");
			response.put("message", "Admin data not updated!!");
			return new ResponseEntity<Map<String,String>>(response, HttpStatus.BAD_REQUEST);
		}
	}
	
	@DeleteMapping("/deleteAdmin/{id}")
	public ResponseEntity<Map<String,String>> deleteAdmin(@PathVariable(name="id")int  id)
	{
		try
		{
			this.service.deleteById(id);
			Map<String,String> response=new HashMap<String,String>();
			response.put("status", "success");
			response.put("message", "Admin  data deleted!!");
			return new ResponseEntity<Map<String,String>>(response, HttpStatus.OK);
		}
		catch(Exception e)
		{
			Map<String,String> response=new HashMap<String,String>();
			response.put("status", "failed");
			response.put("message", "Admin data not deleted!!");
			return new ResponseEntity<Map<String,String>>(response, HttpStatus.NOT_FOUND);
		}
	}
	
	
	  @PostMapping("/loginAdmin") public ResponseEntity<?> Adminlogin(@RequestBody Admin adminData)
	  {
		Admin admin = dao.findByAdminName(adminData.getAdminName());
	  
	  if (admin.getAdminPassword().equals(adminData.getAdminPassword()))
	  { 
	  Admin senduser=new Admin();
	  senduser.setAdminid(admin.getAdminid());	  
	  senduser.setAdminName(admin.getAdminName()); 
	  senduser.setAddress(admin.getAddress());
	  senduser.setMobile(admin.getMobile());
	  
	  return ResponseEntity.ok(senduser); 
	  }
	  else {
	  System.out.println("Admin login failed for: " + adminData.getAdminName());
	  return (ResponseEntity<?>) ResponseEntity.internalServerError(); 
	  } 
	  }
	 
	
}
