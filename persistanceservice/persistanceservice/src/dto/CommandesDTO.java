package dto;

import java.io.Serializable;
import java.util.ArrayList;

public class CommandesDTO implements Serializable   {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ArrayList<CommandeDTO> commandesDTO = new ArrayList<CommandeDTO>();
	private String nomListe;
	private int taille;
	
	public CommandesDTO(){
		this.setNomListe("Liste des commandes");
		this.setTaille(commandesDTO.size());
	}
	
	public void add(CommandeDTO commandeDTO){
		commandesDTO.add(commandeDTO);
		this.setTaille(commandesDTO.size());
	}

	public CommandeDTO getUserByid (int id){
		for (int i = 0; i < commandesDTO.size(); i++) {

		    if(commandesDTO.get(i).getId() == id) {
		       return commandesDTO.get(i);
		    }
		}
		return null;
	}

	public String getNomListe() {
		return nomListe;
	}

	public void setNomListe(String nomListe) {
		this.nomListe = nomListe;
	}

	public int getTaille() {
		return taille;
	}

	public void setTaille(int taille) {
		this.taille = taille;
	}

	public ArrayList<CommandeDTO> getCommandesDTO (){
		return commandesDTO;
	}

	

	public void setCommandesDTO(ArrayList<CommandeDTO> commandesDTO) {
		this.commandesDTO = commandesDTO;
	}

}
