package modele;

import java.io.Serializable;

public class Message implements Serializable{
	private static final long serialVersionUID = 1L;
	private String identifiantMessage;
	private String message;
	private String statutMessage;
	private String sourceMessage;
	
	public Message (String identifiantMessage, String message, String sourceMessage) {
		this.identifiantMessage = identifiantMessage;
		this.statutMessage = "EnCours";
		this.sourceMessage = sourceMessage;
		this.message = message;
	}

	public Message (String identifiantMessage) {
		this.identifiantMessage = identifiantMessage;
		this.statutMessage = "EnCours";
	}
	
	public String getIdentifiantMessage() {
		return identifiantMessage;
	}

	public void setIdentifiantMessage(String identifiantMessage) {
		this.identifiantMessage = identifiantMessage;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getStatutMessage() {
		return statutMessage;
	}

	public void setStatutMessage(String statutMessage) {
		this.statutMessage = statutMessage;
	}

	public String getSourceMessage() {
		return sourceMessage;
	}

	public void setSourceMessage(String sourceMessage) {
		this.sourceMessage = sourceMessage;
	}
}