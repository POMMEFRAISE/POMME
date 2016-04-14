package comportement.metier2presentation;

import comportement.Commande;
import xml.metier2presentation.ReponseDemanderAuthentification;

//PEUT ETRE RAJOUTER UN BOOLEAN DANS LE MESSAGE ET DONC ICI POUR SI OK OU KO POUR EXECUTER LA COMMANDE
// OK : ON AFFICHE CONNEXION.JSP
// KO : ON AFFICHE UNE PAGE ERREUR
public class ReponseDemanderAuthentificationComportement implements Commande{

	private String pageRedirection = "";
	private ReponseDemanderAuthentification reponseDemanderAuthentification;
	
	public ReponseDemanderAuthentificationComportement(ReponseDemanderAuthentification reponseDemanderAuthentification){
		this.reponseDemanderAuthentification = reponseDemanderAuthentification;
	}

	public void envoiMessage() {
		
	}

	public String reçoiMessage() {
		System.out.println("ReponseDemanderAuthentificationComportement");
		pageRedirection = "connexion";
		System.out.println("ReponseDemanderAuthentificationComportement : pageRedirection : "+pageRedirection);

		return pageRedirection;
	}

	public String getPageRedirection() {
		return pageRedirection;
	}

	public void setPageRedirection(String pageRedirection) {
		this.pageRedirection = pageRedirection;
	}

	public ReponseDemanderAuthentification getReponseDemanderAuthentification() {
		return reponseDemanderAuthentification;
	}

	public void setReponseDemanderAuthentification(ReponseDemanderAuthentification reponseDemanderAuthentification) {
		this.reponseDemanderAuthentification = reponseDemanderAuthentification;
	}
}