package com.springdemo.service;

import com.springdemo.dto.RequestDto;
import com.springdemo.dto.ResponseDto;

public interface TaskService {

	public ResponseDto addTask(RequestDto request);
	public ResponseDto getTask(Integer id);
	public ResponseDto updateTask(Integer id, RequestDto request);
	public String deleteTask(Integer id);
}
