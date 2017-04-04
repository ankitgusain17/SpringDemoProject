package com.springdemo.dto;

public class JsonResponseDto {

	private ResponseDto response;
	private Boolean success;

	public ResponseDto getResponse() {
		return response;
	}

	public void setResponse(ResponseDto response) {
		this.response = response;
	}

	public Boolean getSuccess() {
		return success;
	}

	public void setSuccess(Boolean success) {
		this.success = success;
	}
	
}
