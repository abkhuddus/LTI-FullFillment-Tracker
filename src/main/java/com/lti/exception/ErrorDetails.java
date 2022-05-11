package com.lti.exception;

import java.util.Date;

public class ErrorDetails {

	
	private Date timestamp;
	private String mesg;
	private String details;
	public ErrorDetails(Date timestamp, String mesg, String details) {
		super();
		this.timestamp = timestamp;
		this.mesg = mesg;
		this.details = details;
	}
	public Date getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}
	public String getMesg() {
		return mesg;
	}
	public void setMesg(String mesg) {
		this.mesg = mesg;
	}
	public String getDetails() {
		return details;
	}
	public void setDetails(String details) {
		this.details = details;
	}
	
	
	
}
