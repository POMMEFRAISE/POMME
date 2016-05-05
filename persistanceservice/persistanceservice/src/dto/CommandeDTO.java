package dto;

import java.io.Serializable;

public class CommandeDTO implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected int id;
	protected String message;
	protected Integer numeroPresentation;
	
	public CommandeDTO(int id, String message, Integer numeroPresentation) {
		this.id = id;
		this.message = message;
		this.numeroPresentation = numeroPresentation;
	}

	public CommandeDTO() {
		this.id = 0;
		this.message = "";
		this.numeroPresentation = 0;
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
	
	public Integer getNumeroPresentation() {
		return numeroPresentation;
	}

	public void setNumeroPresentation(Integer numeroPresentation) {
		this.numeroPresentation = numeroPresentation;
	}
}