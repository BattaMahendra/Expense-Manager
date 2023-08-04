package com.mahi.em.exceptions;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.springframework.aop.AopInvocationException;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;

@RestControllerAdvice
public class Advice {
	
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public Map<String,String> validationErrorHandler(MethodArgumentNotValidException ex){
		
		Map<String ,String> errors =new HashMap<>();
		
		ex.getBindingResult().getAllErrors().forEach(
				error->{
					errors.put(((FieldError) error).getField(),((FieldError) error).getDefaultMessage());
				});
		return errors;
		
	}
	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ExceptionHandler(value = {ResourceNotFound.class})
	public Map<String,String> resourceNotFound(ResourceNotFound ex){
		Map<String ,String> errors =new HashMap<>();
		
		errors.put("solution", "give proper parameters");
		errors.put("timeStamp", LocalDateTime.now().toString());
		errors.put("error", ex.getMessage());
		
		return errors;
		
	}
	
	@ExceptionHandler(AopInvocationException.class)
	public Map<String,String> resourceNotFound(AopInvocationException ex){
		Map<String ,String> errors =new HashMap<>();
		
		errors.put("error ", ex.getMessage());
		errors.put("timeStamp", LocalDateTime.now().toString());
		return errors;
		
	}
	
	

}
