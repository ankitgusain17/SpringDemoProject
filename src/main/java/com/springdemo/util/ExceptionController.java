package com.springdemo.util;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.springdemo.dto.ErrorDto;

@ControllerAdvice
public class ExceptionController {

	private static final Logger log = LoggerFactory.getLogger(ExceptionController.class);

	@ExceptionHandler(value = Exception.class)
	@ResponseBody
	public ErrorDto handleError(HttpServletRequest req, Exception exception) {
		log.error("Request: " + req.getRequestURL() + " raised " + exception);
		ErrorDto error = new ErrorDto();
		error.setSuccess(false);
		error.setErrorCode(500);
		error.setErrorMessage(exception.toString());
		
		return error;
	}
}