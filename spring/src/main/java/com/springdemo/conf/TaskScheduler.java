package com.springdemo.conf;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import com.springdemo.dto.ResponseDto;
import com.springdemo.util.ProcessTaskThread;
import com.springdemo.util.TasksUtil;

@Configuration
@EnableAsync
@EnableScheduling
public class TaskScheduler {
	
	private static final Logger log = LoggerFactory.getLogger(TaskScheduler.class);

	@Scheduled(fixedDelay=5000)
	public void doTask() {
		
		log.info("In scheduler");
	    
	    for (String key : TasksUtil.tasks.keySet()) {
	    	ResponseDto task = TasksUtil.tasks.get(key);
	        
	        if( TasksUtil.timeDifference(task.getCallbackAt(), TasksUtil.CurrentTime().toString()) == 1 && task.getCalledStatus() == false) {
	        	log.info("Performing task id : " + task.getId());
	        	
	        	ProcessTaskThread taskProcess = new ProcessTaskThread(task.getUrl(), task.getRequestMethod(), task.getRequestBody(), task.getId().toString());
	        	Thread t = new Thread(taskProcess);
	        	t.start();
	        }  
    	}

		
	}
}
