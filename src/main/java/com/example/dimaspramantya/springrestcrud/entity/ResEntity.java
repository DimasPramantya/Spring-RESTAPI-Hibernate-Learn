package com.example.dimaspramantya.springrestcrud.entity;

public class ResEntity {
	private String message;
	private String status;
	private long timeStamps;
	public ResEntity() {
	}
	public ResEntity(String message, String status, long timeStamps) {
		this.message = message;
		this.status = status;
		this.timeStamps = timeStamps;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public long getTimeStamps() {
		return timeStamps;
	}
	public void setTimeStamps(long timeStamps) {
		this.timeStamps = timeStamps;
	}
}
