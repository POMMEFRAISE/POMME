package model;

import java.io.Serializable;

public class Partie extends MessageErreur implements Serializable{

	private static final long serialVersionUID = 1514138537369034322L;
	private String nom;
    private int nbJoueurs;
    private boolean statutPartie;
    
    public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public int getNbJoueurs() {
		return nbJoueurs;
	}
	public void setNbJoueurs(int nbJoueurs) {
		this.nbJoueurs = nbJoueurs;
	}

    public Partie(String nom, int nbJoueurs){
        this.nom=nom;
        this.nbJoueurs=nbJoueurs;
    }
	
	public Partie() {

	}

	public Partie(String nom) {
		this.nom = nom;
	}
	
	public boolean isStatutPartie() {
		return statutPartie;
	}
	
	public void setStatutPartie(boolean statutPartie) {
		this.statutPartie = statutPartie;
	}
}