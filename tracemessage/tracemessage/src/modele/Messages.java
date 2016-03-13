package modele;

import java.util.*;
import java.io.Serializable;

public class Messages implements Serializable 
{
	private static final long serialVersionUID = 1L;

	private ArrayList<Message> messages = new ArrayList<Message>();
	
	public Messages(){

	}
	
	public void add(Message message){
		messages.add(message);
	}

	public ArrayList<Message> getMessages (){
		return messages;
	}
}