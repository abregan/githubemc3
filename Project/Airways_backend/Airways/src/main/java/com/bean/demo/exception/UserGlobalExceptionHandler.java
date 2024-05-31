package com.bean.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class UserGlobalExceptionHandler {
	
	@ExceptionHandler(UserIdNotFoundException.class)
	public ResponseEntity<String> exceptionHandler(UserIdNotFoundException e)
	{
		return new ResponseEntity<String>(e.getMessage(),  HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(UserDataAlreadyAvailableFoundException.class)
	public ResponseEntity<String> exceptionHandler(UserDataAlreadyAvailableFoundException e)
	{
		return new ResponseEntity<String>(e.getMessage(),  HttpStatus.NOT_FOUND);
	}
	
	
	
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<String> exceptionHandler(Exception e)
	{
		return new ResponseEntity<String>(e.getMessage(),  HttpStatus.BAD_REQUEST);
	}

}




