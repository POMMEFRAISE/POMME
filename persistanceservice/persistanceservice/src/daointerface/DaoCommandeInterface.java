package daointerface;

import entites.CommandesEntite;

public interface DaoCommandeInterface {
	boolean enregistrerCommande (String message);
	CommandesEntite afficherCommande ();



}
