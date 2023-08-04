package com.springbootapplication.utility;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.springbootapplication.common.CommonConstant;

@ControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {
	
	@ExceptionHandler(RecordNotFoundException.class)
	public ResponseEntity<Object> handleException(RecordNotFoundException recException) {
		ExceptionResponse ex= new ExceptionResponse();
		ex.setDateTime(LocalDateTime.now());
		ex.setMsg(CommonConstant.msg);		
		ResponseEntity<Object> entity=new ResponseEntity<Object>(ex, HttpStatus.NOT_FOUND);
		return entity;
		
	}
		
	@ExceptionHandler(RecordFoundException.class)
	public ResponseEntity<Object> handleException(RecordFoundException recException) {
		ExceptionResponse ex= new ExceptionResponse();
		ex.setDateTime(LocalDateTime.now());
		ex.setMsg("Record  Found");		
		ResponseEntity<Object> entity=new ResponseEntity<Object>(ex, HttpStatus.OK);
		return entity;
		
	}
	
	
}
