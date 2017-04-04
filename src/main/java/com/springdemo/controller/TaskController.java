package com.springdemo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.springdemo.dto.DeleteResponseDto;
import com.springdemo.dto.JsonResponseDto;
import com.springdemo.dto.RequestDto;
import com.springdemo.service.TaskService;
import com.springdemo.util.InvalidRequestException;

@RestController
public class TaskController {
	
	@Autowired
	private TaskService taskServiceImpl;
	private static final Logger log = LoggerFactory.getLogger(TaskController.class);

	@RequestMapping(value="/tasks", method=RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public JsonResponseDto addTasks(@RequestBody RequestDto request){
		
		log.info("Add Task Request : " + request.toString());
		
		if(request.getUrl() == null || request.getCallbackAt() == null || request.getRequestMethod() == null)
			throw new InvalidRequestException("Invalid Request");
		
		JsonResponseDto response = new JsonResponseDto();
		response.setResponse(this.taskServiceImpl.addTask(request));
		response.setSuccess(true);
		
		return response;
	}
	
	@RequestMapping(value="/tasks/{id}", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public JsonResponseDto getTask( @PathVariable Integer id ){
		
		log.info("Get Task Request : " + id);
		
		JsonResponseDto response = new JsonResponseDto();
		response.setResponse(this.taskServiceImpl.getTask(id));
		response.setSuccess(true);
		
		return response;
	}
	
	@RequestMapping(value="/tasks/{id}", method=RequestMethod.PUT, consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public JsonResponseDto updateTask( @PathVariable Integer id, @RequestBody RequestDto request ){
		
		log.info("Update Task : id : " + id + " request : " + request.toString());
		
		if(request.getUrl() == null || request.getCallbackAt() == null || request.getRequestMethod() == null)
			throw new InvalidRequestException("Invalid Request");
		
		JsonResponseDto response = new JsonResponseDto();		
		response.setResponse(this.taskServiceImpl.updateTask(id, request));
		response.setSuccess(true);
		
		return response;
	}
	
	@RequestMapping(value="/tasks/{id}", method=RequestMethod.DELETE, produces=MediaType.APPLICATION_JSON_VALUE)
	public DeleteResponseDto deleteTask( @PathVariable Integer id ){
		
		log.info("Delete Task : id : " + id);
		
		DeleteResponseDto response = new DeleteResponseDto();
		
		response.setResponse(this.taskServiceImpl.deleteTask(id));
		response.setSuccess(true);
		
		return response;
	}
}
