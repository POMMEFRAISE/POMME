package comportement.integration2metier;

import java.lang.reflect.InvocationTargetException;

import activeMQ.Producteur;
import xml.integration2metier.JeuI2M;
import xml.integration2metier.ObjectFactory;
import xml.integration2metier.PartieI2M;
import xml.integration2metier.ReponseRejoindrePartieI2M;

public class ReponseRejoindrePartieI2MComportement{
	private Object partieDTO;
	private String messageErreur;
	private int numeroPresentation;

	public ReponseRejoindrePartieI2MComportement(Object partieDTO, String messageErreur, int numeroPresentation){
		this.partieDTO = partieDTO;
		this.messageErreur = messageErreur;
		this.numeroPresentation = numeroPresentation;
	}

	public void envoiMessage() {
		ObjectFactory objFactory = new ObjectFactory();
		JeuI2M jeu = objFactory.createJeuI2M();
		PartieI2M partie = objFactory.createPartieI2M();
		try {
			partie.setNomPartie(partieDTO.getClass().getMethod("getNomPartie").invoke(partieDTO).toString());
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException | NoSuchMethodException
				| SecurityException e) {
			e.printStackTrace();
		}
		jeu.setPartie(partie);
		jeu.setMessageErreur(messageErreur);
		ReponseRejoindrePartieI2M reponseRejoindrePartie = objFactory.createReponseRejoindrePartieI2M();
		reponseRejoindrePartie.setJeu(jeu);
		reponseRejoindrePartie.setNumeroPresentation(numeroPresentation);
		
		new Producteur(reponseRejoindrePartie);

	}
}