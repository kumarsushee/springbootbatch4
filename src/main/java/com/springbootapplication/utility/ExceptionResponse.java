package com.springbootapplication.utility;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;

import lombok.Data;
@Data
public class ExceptionResponse {
	
	String msg;
	LocalDateTime dateTime ;
	HttpStatus statusCode;

}
