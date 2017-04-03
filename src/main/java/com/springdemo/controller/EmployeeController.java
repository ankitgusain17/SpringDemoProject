package com.springdemo.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.springdemo.dto.EmployeeDto;
import com.springdemo.dto.ErrorDto;
import com.springdemo.service.EmployeeService;

@RestController
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	private static final Logger log = LoggerFactory.getLogger(EmployeeController.class);
	
	@RequestMapping(value="/employeeList", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public List<EmployeeDto> employeeList(){
		
		log.info("hello");
		
		//int a = 1/0;
		
		return this.employeeService.employeeList();
	}
	
	@ExceptionHandler(value = Exception.class)
	public ErrorDto handleError(HttpServletRequest req, Exception exception) {
		
		log.error("In controller : Request: " + req.getRequestURL() + " raised " + exception);
		
		ErrorDto error = new ErrorDto();
		error.setSuccess(false);
		error.setErrorCode(500);
		error.setErrorMessage("Internal Server Error");
		
		return error;
	}
}
