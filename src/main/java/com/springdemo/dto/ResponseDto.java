package com.springdemo.dto;

public class ResponseDto {

	private String callbackAt;
	private Boolean calledStatus;
	private String createdAt;
	private String requestBody;
	private String errors;
	private String referenceId;
	private String requestMethod;
	private Integer id;
	private String updatedAt;
	private String url;
	
	public String getCallbackAt() {
		return callbackAt;
	}
	public void setCallbackAt(String callbackAt) {
		this.callbackAt = callbackAt;
	}
	public Boolean getCalledStatus() {
		return calledStatus;
	}
	public void setCalledStatus(Boolean calledStatus) {
		this.calledStatus = calledStatus;
	}
	public String getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}
	public String getRequestBody() {
		return requestBody;
	}
	public void setRequestBody(String requestBody) {
		this.requestBody = requestBody;
	}
	public String getErrors() {
		return errors;
	}
	public void setErrors(String errors) {
		this.errors = errors;
	}
	public String getReferenceId() {
		return referenceId;
	}
	public void setReferenceId(String referenceId) {
		this.referenceId = referenceId;
	}
	public String getRequestMethod() {
		return requestMethod;
	}
	public void setRequestMethod(String requestMethod) {
		this.requestMethod = requestMethod;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(String updatedAt) {
		this.updatedAt = updatedAt;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
}
