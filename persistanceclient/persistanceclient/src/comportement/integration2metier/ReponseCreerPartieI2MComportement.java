package comportement.integration2metier;

import java.lang.reflect.InvocationTargetException;

import activeMQ.Producteur;
import xml.integration2metier.CreationPartieI2M;
import xml.integration2metier.ObjectFactory;
import xml.integration2metier.PartieI2M;
import xml.integration2metier.ReponseCreerPartieI2M;

public class ReponseCreerPartieI2MComportement {
	private String messageErreur;
	private Object partieDTO;
	private int numeroPresentation;
	
	public ReponseCreerPartieI2MComportement(String messageErreur, Object partieDTO, int numeroPresentation){
		this.messageErreur = messageErreur;	
		this.partieDTO = partieDTO;
		this.numeroPresentation = numeroPresentation;
	}
	
	public void envoiMessage(){
		ObjectFactory objFactory = new ObjectFactory();
		PartieI2M partie = objFactory.createPartieI2M();

		try {
			partie.setNomPartie(partieDTO.getClass().getMethod("getNomPartie").invoke(partieDTO).toString());
			partie.setNbJoueurPartie((Integer) partieDTO.getClass().getMethod("getNbredejoueur").invoke(partieDTO));
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException | NoSuchMethodException
				| SecurityException e) {
			e.printStackTrace();
		}
		CreationPartieI2M creationPartie = objFactory.createCreationPartieI2M();
		creationPartie.setPartie(partie);
		creationPartie.setMessageErreur(messageErreur);
		ReponseCreerPartieI2M reponseCreerPartie = objFactory.createReponseCreerPartieI2M();
		reponseCreerPartie.setCreationPartie(creationPartie);
		reponseCreerPartie.setNumeroPresentation(numeroPresentation);
		
		Thread thread = new Thread(new Producteur(reponseCreerPartie));
		thread.start();
	}

	public String getMessageErreur() {
		return messageErreur;
	}

	public void setMessageErreur(String messageErreur) {
		this.messageErreur = messageErreur;
	}

	public int getNumeroPresentation() {
		return numeroPresentation;
	}

	public void setNumeroPresentation(int numeroPresentation) {
		this.numeroPresentation = numeroPresentation;
	}

	public Object getPartieDTO() {
		return partieDTO;
	}

	public void setPartieDTO(Object partieDTO) {
		this.partieDTO = partieDTO;
	}
}