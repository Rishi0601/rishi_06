package com.EmployeeMgmtUsingSpringMVCandThymeleaf.CustomExceptions;

public class ErrorResponse {

	private int status;
	private String errorMsg;
	private Long timestamp;

	public ErrorResponse() {};
	
	public ErrorResponse(int status, String errorMsg, Long timestamp) {
		this.status = status;
		this.errorMsg = errorMsg;
		this.timestamp = timestamp;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}

	public Long getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(long timestamp) {
		this.timestamp = timestamp;
	}
}
