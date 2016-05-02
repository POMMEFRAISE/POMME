package model;

import java.io.Serializable;

public class MessageErreur implements Serializable{
	private static final long serialVersionUID = 1292074547285504356L;
	private String message;
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
}