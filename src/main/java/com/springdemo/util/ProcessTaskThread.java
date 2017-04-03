package com.springdemo.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ProcessTaskThread implements Runnable {

	private String url;
	private String method;
	private String requestBody;
	private String taskId;
	
	private static final Logger log = LoggerFactory.getLogger(ProcessTaskThread.class);
	
	public ProcessTaskThread(String url, String method, String requestBody, String taskId) {
		this.url = url;
		this.method = method;
		this.requestBody = requestBody;
		this.taskId = taskId;
	}

	@Override
	public void run() {
		
		log.info("Task Id : " + this.taskId);
		
		try {
			if("get".equalsIgnoreCase(method)){
				sendGet();
			} else if ("post".equalsIgnoreCase(method)){
				sendPost();
			}
			
		} catch (IOException e) {
			log.error(e.toString());
			TasksUtil.tasks.get(this.taskId.toString()).setErrors(e.toString());
		}
		
	}
	
	private void sendGet() throws IOException {
		
		URL obj = new URL(this.url);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();
		con.setRequestMethod("GET");
		int responseCode = con.getResponseCode();
		System.out.println("GET Response Code :: " + responseCode);
		if (responseCode == HttpURLConnection.HTTP_OK) { // success
			
			// Updating call status
			TasksUtil.tasks.get(this.taskId.toString()).setCalledStatus(true);
			
			BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
			String inputLine;
			StringBuffer response = new StringBuffer();

			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();

			log.info(response.toString());
		} else {
			log.info("GET request not worked");
		}

	}

	private void sendPost() throws IOException {
		
		URL obj = new URL(this.url);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();
		con.setRequestMethod("POST");
		con.setRequestProperty("Content-Type", "application/json");

		con.setDoOutput(true);
		OutputStream os = con.getOutputStream();
		os.write(this.requestBody.getBytes());
		os.flush();
		os.close();

		int responseCode = con.getResponseCode();
		log.info("POST Response Code :: " + responseCode);

		if (responseCode == HttpURLConnection.HTTP_OK) { //success
			
			// Updating call status
			TasksUtil.tasks.get(this.taskId.toString()).setCalledStatus(true);
			
			BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
			String inputLine;
			StringBuffer response = new StringBuffer();

			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();

			log.info(response.toString());
		} else {
			log.info("POST request not worked");
		}
	}

}
