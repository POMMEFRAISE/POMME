package modele;

import java.util.*;
import java.io.Serializable;

public class Messages implements Serializable {
	private static final long serialVersionUID = 1L;
	private ArrayList<Message> messages = new ArrayList<Message>();
	private int taille;
	
	public Messages(){
		this.taille = messages.size();
	}
	
	public void add(Message message){
		messages.add(message);
		this.taille = messages.size();
	}

	public ArrayList<Message> getMessages (){
		return messages;
	}

	public int getTaille() {
		return taille;
	}

	public void setTaille(int taille) {
		this.taille = taille;
	}
}