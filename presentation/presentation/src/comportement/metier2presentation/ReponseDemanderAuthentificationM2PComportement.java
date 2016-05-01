package comportement.metier2presentation;

import comportement.Commande;
import model.Redirection;
import xml.metier2presentation.ReponseDemanderAuthentificationM2P;

//PEUT ETRE RAJOUTER UN BOOLEAN DANS LE MESSAGE ET DONC ICI POUR SI OK OU KO POUR EXECUTER LA COMMANDE
// OK : ON AFFICHE CONNEXION.JSP
// KO : ON AFFICHE UNE PAGE ERREUR
public class ReponseDemanderAuthentificationM2PComportement implements Commande{
	private ReponseDemanderAuthentificationM2P reponseDemanderAuthentificationM2P;
	
	public ReponseDemanderAuthentificationM2PComportement(ReponseDemanderAuthentificationM2P reponseDemanderAuthentificationM2P){
		this.reponseDemanderAuthentificationM2P = reponseDemanderAuthentificationM2P;
	}

	public Redirection re�oiMessage() {
		Redirection redirection = new Redirection();
		if(reponseDemanderAuthentificationM2P.getCommande().isEnregistrer() == true){
			redirection.setRedirection("connexion");			
		}else{
			redirection.setRedirection("erreur");
		}
		return redirection;
	}

	public ReponseDemanderAuthentificationM2P getReponseDemanderAuthentificationM2P() {
		return reponseDemanderAuthentificationM2P;
	}

	public void setReponseDemanderAuthentificationM2P(ReponseDemanderAuthentificationM2P reponseDemanderAuthentificationM2P) {
		this.reponseDemanderAuthentificationM2P = reponseDemanderAuthentificationM2P;
	}
}