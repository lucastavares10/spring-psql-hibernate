package br.com.integracao.springboot.exception;

import java.util.Date;

public class ErrorData {
	private Date timestamp;
	private String message;
	private String data;
	
	public ErrorData(Date timestamp, String message, String data) {
		super();
		this.timestamp = timestamp;
		this.message = message;
		this.data = data;
	}
	
	public Date getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}	

}
