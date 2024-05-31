package com.bean.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

public class PaymentGlobalExceptionHandler {
	@ExceptionHandler(PaymentIdNotFoundException.class)
	public ResponseEntity<String> exceptionHandler(PaymentIdNotFoundException e)
	{
		return new ResponseEntity<String>(e.getMessage(),  HttpStatus.NOT_FOUND);
	}
	
	
	
	@ExceptionHandler(PaymentAlreadyAvailableFoundException.class)
	public ResponseEntity<String> exceptionHandler(PaymentAlreadyAvailableFoundException e)
	{
		return new ResponseEntity<String>(e.getMessage(),  HttpStatus.NOT_FOUND);
	}
	
	
	
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<String> exceptionHandler(Exception e)
	{
		return new ResponseEntity<String>(e.getMessage(),  HttpStatus.BAD_REQUEST);
	}

}
