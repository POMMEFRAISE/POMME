package model;

public class De {

	private int valeur;
	private String image = "";
	private int identifiant;
	public int getValeur() {
		return valeur;
	}

	public void setValeur(int valeur) {
		this.valeur = valeur;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}
	
	public void associerImage(){
		switch(valeur){
		case 1 :
			image = "de_1.png";
			break;
		case 2 :
			image = "de_2.png";
			break;
		case 3 :
			image = "de_3.png";
			break;
		case 4 :
			image = "de_4.png";
			break;
		case 5 :
			image = "de_5.png";
			break;
		case 6 :
			image = "de_6.png";
			break;
		}
	}

	public int getIdentifiant() {
		return identifiant;
	}

	public void setIdentifiant(int identifiant) {
		this.identifiant = identifiant;
	}
}