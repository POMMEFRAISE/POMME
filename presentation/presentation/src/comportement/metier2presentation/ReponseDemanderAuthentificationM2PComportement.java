package comportement.metier2presentation;

import comportement.Commande;
import xml.metier2presentation.ReponseDemanderAuthentificationM2P;

//PEUT ETRE RAJOUTER UN BOOLEAN DANS LE MESSAGE ET DONC ICI POUR SI OK OU KO POUR EXECUTER LA COMMANDE
// OK : ON AFFICHE CONNEXION.JSP
// KO : ON AFFICHE UNE PAGE ERREUR
public class ReponseDemanderAuthentificationM2PComportement implements Commande{
	private ReponseDemanderAuthentificationM2P reponseDemanderAuthentification;
	
	public ReponseDemanderAuthentificationM2PComportement(ReponseDemanderAuthentificationM2P reponseDemanderAuthentification){
		this.reponseDemanderAuthentification = reponseDemanderAuthentification;
	}

	public void envoiMessage() {
		
	}

	public String reçoiMessage() {
		System.out.println("ReponseDemanderAuthentificationComportement");
		System.out.println("ReponseDemanderAuthentificationComportement : pageRedirection : connexion");

		return "connexion";
	}

	public ReponseDemanderAuthentificationM2P getReponseDemanderAuthentification() {
		return reponseDemanderAuthentification;
	}

	public void setReponseDemanderAuthentification(ReponseDemanderAuthentificationM2P reponseDemanderAuthentification) {
		this.reponseDemanderAuthentification = reponseDemanderAuthentification;
	}
}