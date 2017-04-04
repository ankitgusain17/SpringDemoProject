package com.springdemo.util;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.springdemo.dto.ResponseDto;

public class TasksUtil {

	private static final Logger log = LoggerFactory.getLogger(TasksUtil.class);
	public static Map<String, ResponseDto> tasks = new ConcurrentHashMap<String, ResponseDto>();
	private static int taskId = 0;
	
	public static Timestamp CurrentTime(){
		
		Date today = new Date();
	    return (new Timestamp(today.getTime()));

	}
	
	public static int timeDifference(String dateA, String dateB) {
		try {
			SimpleDateFormat format = new SimpleDateFormat("yyyy-mm-dd HH:mm:ss");
			
			Date date1 = format.parse(dateA);
			Date date2 = format.parse(dateB);
			
			long difference = date2.getTime() - date1.getTime(); 
			
			if(difference >= 0)
				return 1;
			
		} catch (ParseException e) {
			log.error(e.toString());
		}
		
		return 0;
	}
	
	public static int incrementTaskId() {
		synchronized (TasksUtil.class) {
			taskId ++;
		}
		
		return taskId;
	}

}
