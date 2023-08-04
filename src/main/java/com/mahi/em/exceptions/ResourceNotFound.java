package com.mahi.em.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ResourceNotFound extends RuntimeException{
	
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	public ResourceNotFound(String fieldName, String resourceName, Object value) {
		super(resourceName+" not found with "+fieldName+" : "+value);
		this.fieldName = fieldName;
		this.resourceName = resourceName;
		this.value = value;
	}
	
	public ResourceNotFound( String resourceName) {
		super(resourceName+" not found ");
		
	}
	private String fieldName;
	private String resourceName;
	private Object value;
	
	
	public String getFieldName() {
		return fieldName;
	}
	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}
	public String getResourceName() {
		return resourceName;
	}
	public void setResourceName(String resourceName) {
		this.resourceName = resourceName;
	}
	public Object getValue() {
		return value;
	}
	public void setValue(Object value) {
		this.value = value;
	}
	

}
