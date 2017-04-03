package com.springdemo.service;

import org.springframework.stereotype.Service;

import com.springdemo.dto.RequestDto;
import com.springdemo.dto.ResponseDto;
import com.springdemo.util.TasksUtil;

@Service
public class TaskServiceImpl implements TaskService{

	@Override
	public ResponseDto addTask(RequestDto request) {
		
		int taskId = TasksUtil.incrementTaskId();
		
		ResponseDto task = new ResponseDto();
		
		task.setId(taskId);
		task.setUrl(request.getUrl());
		task.setCallbackAt(request.getCallbackAt());
		task.setReferenceId(request.getReferenceId());
		task.setRequestMethod(request.getRequestMethod());
		task.setRequestBody(request.getRequestBody());
		task.setCalledStatus(false);
		task.setCreatedAt(TasksUtil.CurrentTime().toString());
		task.setUpdatedAt(TasksUtil.CurrentTime().toString());
		
		TasksUtil.tasks.put(Integer.toString(taskId), task);
		
		return TasksUtil.tasks.get(Integer.toString(taskId));
	}

	@Override
	public ResponseDto getTask(Integer id) {
		return TasksUtil.tasks.get(Integer.toString(id));
	}

	@Override
	public ResponseDto updateTask(Integer id, RequestDto request) {
		
		ResponseDto task = TasksUtil.tasks.get(Integer.toString(id));
		
		if(task == null) {
			return null;
		}
		
		// check if called status is false
		if(!task.getCalledStatus()) {
			task.setUrl(request.getUrl());
			task.setCallbackAt(request.getCallbackAt());
			task.setReferenceId(request.getReferenceId());
			task.setRequestMethod(request.getRequestMethod());
			task.setRequestBody(request.getRequestBody());
			task.setUpdatedAt(TasksUtil.CurrentTime().toString());
		}
		
		TasksUtil.tasks.put(Integer.toString(id), task);
		
		return TasksUtil.tasks.get(Integer.toString(id));
	}

	@Override
	public String deleteTask(Integer id) {
		
		TasksUtil.tasks.remove(Integer.toString(id));
		
		return "ok";
	}

}
