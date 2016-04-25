package model;

import java.io.Serializable;

public class Redirection implements Serializable{
	private static final long serialVersionUID = 1L;
	private String redirection;
	private String message;
	
	public String getRedirection() {
		return redirection;
	}
	public void setRedirection(String redirection) {
		this.redirection = redirection;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
}