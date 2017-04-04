package com.springdemo.dto;

public class RequestDto {

	private String url;
	private String callbackAt;
	private String referenceId;
	private String requestMethod;
	private String requestBody;
	
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getCallbackAt() {
		return callbackAt;
	}
	public void setCallbackAt(String callbackAt) {
		this.callbackAt = callbackAt;
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
	public String getRequestBody() {
		return requestBody;
	}
	public void setRequestBody(String requestBody) {
		this.requestBody = requestBody;
	}
	@Override
	public String toString() {
		return "RequestDto [url=" + url + ", callbackAt=" + callbackAt
				+ ", referenceId=" + referenceId + ", requestMethod="
				+ requestMethod + ", requestBody=" + requestBody + "]";
	}
}
