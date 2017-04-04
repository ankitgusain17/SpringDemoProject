package com.springdemo.util;

@SuppressWarnings("serial")
public class InvalidRequestException extends RuntimeException {

	public InvalidRequestException(String s) {
		super(s);
	}
}
