package action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import modele.Messages;

public class ActionTechnique{
	public static Messages lireFichier(String cheminCompletFichier){
		Messages messages = new Messages();
		File fichier = new File(cheminCompletFichier);
		if(fichier.length() != 0){
			try {
				FileInputStream file = new FileInputStream(fichier);
				ObjectInputStream object = new ObjectInputStream(file);
				messages = (Messages) object.readObject();
				object.close();
				file.close();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
		return messages;
	}
	
	public static void ecrireFichier(Messages messages, String cheminCompletFichier){
		
		File fichier = new File(cheminCompletFichier);		
		try{
			FileOutputStream file = new FileOutputStream(fichier);
			ObjectOutputStream object = new ObjectOutputStream(file);
			object.writeObject(messages);
			object.close();
			file.close();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			
		}
	}
}