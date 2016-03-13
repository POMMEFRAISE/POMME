package modele;

import java.io.Serializable;

public class Message implements Serializable 
{
	private static final long serialVersionUID = 1L;
	
	private String identifiantMessage;
	private String typeMessage;
	private String statutMessage;
	private String sourceMessage;
	
	public Message (String identifiantMessage, String typeMessage) {
		this.identifiantMessage = identifiantMessage;
		this.statutMessage = "EnCours";
		//this.sourceMessage = sourceMessage;
		this.typeMessage = typeMessage;
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

	public String getTypeMessage() {
		return typeMessage;
	}

	public void setTypeMessage(String typeMessage) {
		this.typeMessage = typeMessage;
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