package model;

public class PartiePresentation {

    private String nom;
    private int nbJoueurs;
    private boolean statut;
    
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

    public PartiePresentation(String nom, int nbJoueurs){
        this.nom=nom;
        this.nbJoueurs=nbJoueurs;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/*Partie p1 = new Partie("partie1", 3);
		Partie p2 = new Partie("partie2", 4);
		Partie p3 = new Partie("partie3", 5);*/
	}

}
