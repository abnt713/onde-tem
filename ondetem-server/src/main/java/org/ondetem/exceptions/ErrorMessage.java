package org.ondetem.exceptions;

public class ErrorMessage {
	private String userMessage;
	private String type;
	
	public ErrorMessage(){
		this("", "");
	}
	public ErrorMessage(Throwable err){
		this(err.getClass().getSimpleName(), err.getMessage());
	}
	public ErrorMessage(String type, String userMessage) {
		this.type = type;
		this.userMessage = userMessage;
	}
	
	public String getUserMessage() {
		return userMessage;
	}
	public void setUserMessage(String userMessage) {
		this.userMessage = userMessage;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
}
