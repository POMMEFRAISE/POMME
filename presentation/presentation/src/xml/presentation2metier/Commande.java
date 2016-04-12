package xml.presentation2metier;

public class Commande {
	public void execute(Commande commande){
		switch(commande.getClass().getName()){
		case "demanderAuthentification":
			
			break;
		case "seConnecter":
			
			break;
		}
	}
}