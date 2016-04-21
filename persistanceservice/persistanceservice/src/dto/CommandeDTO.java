package dto;

import java.io.Serializable;

public class CommandeDTO implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected int id;
	protected String message;
		
	public CommandeDTO(int id, String message) {
		this.id = id;
		this.message = message;
	}

	public CommandeDTO() {
		this.id = 0;
		this.message = "";
	}
		
	public CommandeDTO(String message) {
		this.message = message;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMessage() {
			return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	

}
