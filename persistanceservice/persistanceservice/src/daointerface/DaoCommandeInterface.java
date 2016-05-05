package daointerface;

import entites.CommandeEntite;
import entites.CommandesEntite;

public interface DaoCommandeInterface {
	boolean enregistrerCommande (CommandeEntite commande);
	CommandesEntite afficherCommande ();
	int demanderNumeroPresentation();
}