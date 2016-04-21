package entites;


import java.io.Serializable;
import java.util.ArrayList;

public class CommandesEntite implements Serializable   {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ArrayList<CommandeEntite> commandesEntite = new ArrayList<CommandeEntite>();
	private String nomListe;
	private int taille;
	
	public CommandesEntite(){
		this.setNomListe("Liste des commandes");
		this.setTaille(commandesEntite.size());
	}
	
	public void add(CommandeEntite commandeDTO){
		commandesEntite.add(commandeDTO);
		this.setTaille(commandesEntite.size());
	}

	public CommandeEntite getUserByid (int id){
		for (int i = 0; i < commandesEntite.size(); i++) {

		    if(commandesEntite.get(i).getId() == id) {
		       return commandesEntite.get(i);
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

	public ArrayList<CommandeEntite> getCommandesEntite (){
		return commandesEntite;
	}

}
