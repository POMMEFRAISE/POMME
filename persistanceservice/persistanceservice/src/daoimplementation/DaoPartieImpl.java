package daoimplementation;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import daointerface.DaoPartieInterface;
import daoparam.ConnexionDAO;
import entites.JeuEntite;
import entites.JeuxEntite;
import entites.JoueurEntite;
import entites.JoueursEntite;
import entites.PartieEntite;
import entites.PartiesEntite;

public class DaoPartieImpl implements DaoPartieInterface {
	private ResultSet resultat = null;
	public DaoPartieImpl(){
	}
	
	public synchronized boolean creerPartie(PartieEntite partie) {
		boolean bool = false;

		try {
			if (verifierPartie (partie.getNomPartie()) == false){
				String creerPartieSQL = ConnexionDAO.getProperties().getProperty("creerPartieSQL");
				PreparedStatement preparedStatement = ConnexionDAO.getInstance().prepareCall(creerPartieSQL);
				
				preparedStatement.setString(1, partie.getNomPartie());
				preparedStatement.setInt(2, partie.getNbredejoueur());
				preparedStatement.setString(3, "ouvert");
				
				int resultat = preparedStatement.executeUpdate();
				ConnexionDAO.getInstance().close();				

				if (resultat>=1) {
					System.out.print("Partie créee");
					bool= true;
					return bool;
				}else {
					System.out.print("Imposible de créer une partie");
					bool= false;
					return bool;
				}
			}	
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return bool;
	}

	public synchronized PartieEntite recupererPartie(PartieEntite partie) {
		PartieEntite partieEntite = new PartieEntite();
		
		try {
			if (verifierPartie (partie.getNomPartie()) == true){
				String recupererPartieSQL = ConnexionDAO.getProperties().getProperty("recupererPartieSQL");
				PreparedStatement preparedStatement = ConnexionDAO.getInstance().prepareCall(recupererPartieSQL);
				preparedStatement.setString(1, partie.getNomPartie());
				resultat = preparedStatement.executeQuery();
				
				while (resultat.next()) {								
					partieEntite.setNomPartie(resultat.getString("nomPartie"));
					partieEntite.setStatut(resultat.getString("statut")); 
					partieEntite.setNbredejoueur(resultat.getInt("nbredejoueur"));
					partieEntite.setDatedecreation(resultat.getDate("datecreation"));
				}
				ConnexionDAO.getInstance().close();				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return partieEntite;
	}

	public synchronized PartiesEntite recupererListeParties() {
		PartiesEntite partiesEntite = new PartiesEntite();
		
		try {
			String recupererPartieSQL = ConnexionDAO.getProperties().getProperty("recupererListePartieSQL");
			PreparedStatement preparedStatement = ConnexionDAO.getInstance().prepareCall(recupererPartieSQL);
			resultat = preparedStatement.executeQuery();
				
			while (resultat.next()) {	
				PartieEntite partieEntite = new PartieEntite();
				partieEntite.setNomPartie(resultat.getString("nomPartie"));
				partieEntite.setStatut(resultat.getString("statut")); 
				partieEntite.setNbredejoueur(resultat.getInt("nbredejoueur"));
				partieEntite.setDatedecreation(resultat.getDate("datecreation"));
				partiesEntite.add(partieEntite);
			}
			ConnexionDAO.getInstance().close();				
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return partiesEntite;
	}
	
	public synchronized PartiesEntite recupererListePartiesPourChangerEtat() {
		PartiesEntite partiesEntite = new PartiesEntite();
		
		try {
			String recupererPartiePourChangerEtatSQL = ConnexionDAO.getProperties().getProperty("recupererListePartiePourChangerEtatSQL");
			PreparedStatement preparedStatement = ConnexionDAO.getInstance().prepareCall(recupererPartiePourChangerEtatSQL);
			resultat = preparedStatement.executeQuery();
				
			while (resultat.next()) {	
				PartieEntite partieEntite = new PartieEntite();
				partieEntite.setNomPartie(resultat.getString("nomPartie"));
				partiesEntite.add(partieEntite);
			}
			ConnexionDAO.getInstance().close();				
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return partiesEntite;
	}
	
	public synchronized String afficherEtatPartie(String nompartie) {
			PartieEntite partieEntite = new PartieEntite();

		try {
			if (verifierPartie (nompartie) == true){
				String afficherEtatPartieSQL = ConnexionDAO.getProperties().getProperty("afficherEtatPartieSQL");
				PreparedStatement preparedStatement = ConnexionDAO.getInstance().prepareCall(afficherEtatPartieSQL);
				
				preparedStatement.setString(1,nompartie );
				resultat = preparedStatement.executeQuery();
				while (resultat.next()) {								
					partieEntite.setNomPartie(resultat.getString("nomPartie"));
					partieEntite.setStatut(resultat.getString("statut")); 	
				}
				ConnexionDAO.getInstance().close();				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return "Partie [nomPartie=" + partieEntite.getNomPartie() + ", statut=" + partieEntite.getStatut() + "]";
	}

	
	public synchronized boolean fermerPartie(PartieEntite partie) {
		boolean bool = false;
		
		try {
			String fermerPartieSQL = ConnexionDAO.getProperties().getProperty("fermerPartieSQL");
			PreparedStatement preparedStatement = ConnexionDAO.getInstance().prepareCall(fermerPartieSQL);
				
			preparedStatement.setString(1, "fermer");
			preparedStatement.setString(2, partie.getNomPartie());
			int resultat = preparedStatement.executeUpdate();
			ConnexionDAO.getInstance().close();				

			if (resultat>=1) {
				System.out.print("Partie fermée");
				bool= true;
				return bool;
			}else {
				System.out.print("Imposible de fermer la partie "+partie.getNomPartie());
				bool= false;
				return bool;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return bool;
	}
		
	public synchronized boolean rejoindrePartie(PartieEntite partie, JoueurEntite joueur, Integer numeroPresentation) {
		boolean bool = false;
		int numeroPositionJeu = 0;
		try {
			String recupMaxPositionJeuPartieSQL = ConnexionDAO.getProperties().getProperty("recupMaxPositionJeuPartieSQL");
			PreparedStatement preparedStatement = ConnexionDAO.getInstance().prepareCall(recupMaxPositionJeuPartieSQL);
			preparedStatement.setString(1, partie.getNomPartie());

			resultat = preparedStatement.executeQuery();
			
			while(resultat.next()){
				numeroPositionJeu = resultat.getInt("position");
			}
			ConnexionDAO.getInstance().close();				

			numeroPositionJeu = numeroPositionJeu+1;
			joueur.setPositionJeu(numeroPositionJeu);
			
			String rejoindrePartieSQL = ConnexionDAO.getProperties().getProperty("rejoindrePartieSQL");
			PreparedStatement preparedStatement2 = ConnexionDAO.getInstance().prepareCall(rejoindrePartieSQL);
			
			preparedStatement2.setString(1, joueur.getLogin());
			preparedStatement2.setString(2, partie.getNomPartie());
			preparedStatement2.setInt(3, numeroPresentation);
			preparedStatement2.setInt(4, joueur.getPositionJeu());

			int resultat = preparedStatement2.executeUpdate();
			ConnexionDAO.getInstance().close();				

			if (resultat>=1) {
				System.out.print("Joueur Enregistré");
				bool= true;
				return bool;
			}else {
				System.out.print("Imposible d'enregistrer le joueur");
				bool= false;
				return bool;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return bool;
	}

	@Override
	public synchronized boolean verifierPartie(String nompartie) {
		boolean bool = false;
		try {
			String verifierPartieSQL = ConnexionDAO.getProperties().getProperty("verifierPartieSQL");
			PreparedStatement preparedStatement = ConnexionDAO.getInstance().prepareCall(verifierPartieSQL);
			preparedStatement.setString(1, nompartie);
			resultat = preparedStatement.executeQuery();
			ConnexionDAO.getInstance().close();				

			if (resultat.next()){
				System.out.println("La Partie existe bien.");
				bool= true;
				return bool;
			}
			else{
				System.out.println("La Partie n'existe pas ");
				bool= false;
				return bool;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return bool;
	}

	public synchronized boolean verifierPartieRejoindre(String nompartie) {
		boolean bool = false;
		try {
			String verifierPartieRejoindreSQL = ConnexionDAO.getProperties().getProperty("verifierPartieRejoindreSQL");
			PreparedStatement preparedStatement = ConnexionDAO.getInstance().prepareCall(verifierPartieRejoindreSQL);
			preparedStatement.setString(1, nompartie);
			preparedStatement.setString(2, nompartie);
			resultat = preparedStatement.executeQuery();
			ConnexionDAO.getInstance().close();				

			if (resultat.next()){
				System.out.println("La Partie existe bien.");
				bool= true;
				return bool;
			}
			else{
				System.out.println("La Partie n'existe pas ");
				bool= false;
				return bool;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return bool;
	}
	
	public synchronized PartiesEntite recupererListePartiesAFermer() {
		PartiesEntite partiesEntite = new PartiesEntite();
		
		try {
			String recupererListePartieAFermerSQL = ConnexionDAO.getProperties().getProperty("recupererListePartieAFermerSQL");
			PreparedStatement preparedStatement = ConnexionDAO.getInstance().prepareCall(recupererListePartieAFermerSQL);
			resultat = preparedStatement.executeQuery();
			while (resultat.next()) {	
				PartieEntite partieEntite = new PartieEntite();
				partieEntite.setNomPartie(resultat.getString("nomPartie"));
				partiesEntite.add(partieEntite);
			}
			ConnexionDAO.getInstance().close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return partiesEntite;
	}
	
	public synchronized boolean changerEtatListePartie(PartiesEntite parties) {
		boolean bool = false;
		try {
			for(PartieEntite unePartie : parties.getParties()){				
				String changerEtatPartieSQL = ConnexionDAO.getProperties().getProperty("changerEtatPartieSQL");
				PreparedStatement preparedStatement = ConnexionDAO.getInstance().prepareCall(changerEtatPartieSQL);
				
				preparedStatement.setString(1, "annuler");
				preparedStatement.setString(2, unePartie.getNomPartie());

				int resultat = preparedStatement.executeUpdate();
				ConnexionDAO.getInstance().close();				

				if(resultat >=1){
					bool = true;
				}else{
					bool = false;
				}
			}
				
			if (bool==false) {
				System.out.print("Imposible de changer l'état de la partie");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return bool;
	}
	
	public synchronized JeuxEntite recupererListePartiesPourJeu() {
		JeuxEntite jeuxEntite = new JeuxEntite();
		JeuxEntite jeuxEntite2 = new JeuxEntite();
		
		try {
			String recupererListePartiesPourJeuSQL = ConnexionDAO.getProperties().getProperty("recupererListePartiesPourJeuSQL");
			PreparedStatement preparedStatement = ConnexionDAO.getInstance().prepareCall(recupererListePartiesPourJeuSQL);
			resultat = preparedStatement.executeQuery();
			
			while (resultat.next()) {
				JeuEntite jeuEntite = new JeuEntite();
				PartieEntite partieEntite = new PartieEntite();
				partieEntite.setNomPartie(resultat.getString("nomPartie"));
				partieEntite.setNbredejoueur(resultat.getInt("nbreDeJoueur"));
				jeuEntite.setPartie(partieEntite);
				jeuxEntite.add(jeuEntite);	
			}
			ConnexionDAO.getInstance().close();				

			for(JeuEntite unJeu : jeuxEntite.getJeux()){
				JeuEntite jeuEntite2 = new JeuEntite();
				
				JoueursEntite joeursEntite = new JoueursEntite();

				String recupererJoueursPartieSQL = ConnexionDAO.getProperties().getProperty("recupererJoueursPartieSQL");
				PreparedStatement preparedStatement2 = ConnexionDAO.getInstance().prepareCall(recupererJoueursPartieSQL);
				preparedStatement2.setString(1, unJeu.getPartie().getNomPartie());
				ResultSet resultat2 = preparedStatement2.executeQuery();
				
				while (resultat2.next()) {	
					JoueurEntite joueurEntite = new JoueurEntite();
					joueurEntite.setLogin(resultat2.getString("login"));
					joueurEntite.setNumeroPresentation(resultat2.getInt("numeroPresentation"));
					joueurEntite.setPositionJeu(resultat2.getInt("positionJeu"));
					joeursEntite.add(joueurEntite);
				}

				jeuEntite2.setPartie(unJeu.getPartie());
				jeuEntite2.setJoueurs(joeursEntite);
				if(jeuEntite2.getJoueurs().getJoueurs().size() >0){
					jeuxEntite2.getJeux().add(jeuEntite2);		
				}
			}
			ConnexionDAO.getInstance().close();				

			mettreStatutEnCourJeu();
			supprimerScorePartiesAnnuler();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return jeuxEntite2;
	}
	
	public synchronized boolean mettreStatutEnCourJeu() {
		boolean bool = false;
		PartiesEntite partiesEntite = new PartiesEntite();
		try {
			String recupererListePartiesChangerStatutJeuSQL = ConnexionDAO.getProperties().getProperty("recupererListePartiesChangerStatutJeuSQL");
			PreparedStatement preparedStatement = ConnexionDAO.getInstance().prepareCall(recupererListePartiesChangerStatutJeuSQL);
					
			preparedStatement.setString(1, "fermer");

			resultat = preparedStatement.executeQuery();
			
			while (resultat.next()) {	
				PartieEntite partieEntite = new PartieEntite();
				partieEntite.setNomPartie(resultat.getString("nomPartie"));
					
				partiesEntite.add(partieEntite);
			}
			ConnexionDAO.getInstance().close();				

			if(partiesEntite.getParties().size() == 0){
				bool = true;
			}
			
			for(PartieEntite unePartie : partiesEntite.getParties()){
				String changerEtatPartieSQL = ConnexionDAO.getProperties().getProperty("changerEtatPartieSQL");
				PreparedStatement preparedStatement2 = ConnexionDAO.getInstance().prepareCall(changerEtatPartieSQL);
				
				preparedStatement2.setString(1, "enCours");
				preparedStatement2.setString(2, unePartie.getNomPartie());

				int resultat2 = preparedStatement2.executeUpdate();
				ConnexionDAO.getInstance().close();				

				if(resultat2 >=1){
					bool = true;
				}else{
					bool = false;
				}
			}
	
			if (bool==false) {
				System.out.print("Impossible de supprimer les jeux");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return bool;
	}
	
	public synchronized boolean supprimerScorePartiesAnnuler() {
		boolean bool = false;
		boolean bool2 = false;
		try {
			String recupererListePartieAnnulerASupSQL = ConnexionDAO.getProperties().getProperty("recupererListePartieAnnulerASupSQL");
			PreparedStatement preparedStatement = ConnexionDAO.getInstance().prepareCall(recupererListePartieAnnulerASupSQL);
					
			preparedStatement.setString(1, "annuler");

			resultat = preparedStatement.executeQuery();
			
			while (resultat.next()) {	
				PartieEntite partieEntite = new PartieEntite();
				partieEntite.setId(resultat.getInt("id"));
					
				String supprimerScorePartiesAnnulerSQL = ConnexionDAO.getProperties().getProperty("supprimerScorePartiesAnnulerSQL");
				PreparedStatement preparedStatement2 = ConnexionDAO.getInstance().prepareCall(supprimerScorePartiesAnnulerSQL);
						
				preparedStatement2.setInt(1, partieEntite.getId());

				int resultat2 = preparedStatement2.executeUpdate();

				if(resultat2 >=1){
					bool2 = true;
				}else{
					bool2 = false;
				}
			}
			ConnexionDAO.getInstance().close();				
	
			if (bool2==false) {
				System.out.print("Imposible de supprimer les jeux");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return bool;
	}
}