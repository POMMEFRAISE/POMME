package clientRMI;

import java.lang.reflect.InvocationTargetException;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class Client {
	public static void main(String[] argv) throws Exception {
		if (System.getSecurityManager() == null) {
			System.setProperty("java.security.policy", "file:/C:/Users/Cyrielle/git/PDS/persistanceclient/persistanceclient/bin/clientRMI/client.policy");
			System.setProperty("java.rmi.server.codebase", "file:/C:/Users/Cyrielle/git/PDS/persistanceservice/persistanceservice/bin/");
			System.setSecurityManager(new SecurityManager());
		}
			try {
				Naming.lookup("//127.0.0.1/ServiceJoueur");
				Naming.lookup("//127.0.0.1/ServicePartie");
				Naming.lookup("//127.0.0.1/ServiceCommande");
				//Appelle de la classe JoueurDTO
				Object objectJoueur = ChargerService.chargerDTO("JoueurDTO");
				Object objectPartie = ChargerService.chargerDTO("PartieDTO");
				//Charger interface 
				Object objectService = ChargerService.chargerInterface();

				//Appeler les methodes joueur
				/*objectJoueur.getClass().getDeclaredMethod("setLogin", String.class).invoke(objectJoueur, "jean");
				objectJoueur.getClass().getDeclaredMethod("setMotDePasse", String.class).invoke(objectJoueur, "jean1");
				System.out.println(objectJoueur);
				*/
				//Appeler les methodes verificationJoueur
				//boolean trouveJoueur = (boolean) objectService.getClass().getDeclaredMethod("verifierJoueur",Object.class).invoke(objectService,objectJoueur);	
				//System.out.println("SeConnecter : "+trouveJoueur);
				
				//Appeler les methodes recupererJoueur
				/*Object recupereJoueur = objectService.getClass().getDeclaredMethod("recupererJoueur",Object.class).invoke(objectService,objectJoueur);
				System.out.println("Recuperation du joueur "+recupereJoueur);*/
				
				//Creation de compte
					//Remplir Joueur
				/*objectJoueur.getClass().getDeclaredMethod("setNom", String.class).invoke(objectJoueur, "MAUILIS");
				objectJoueur.getClass().getDeclaredMethod("setPrenom", String.class).invoke(objectJoueur, "Cyrielle");
				objectJoueur.getClass().getDeclaredMethod("setEmail", String.class).invoke(objectJoueur, "cyrielle@yahoo.com");
				objectJoueur.getClass().getDeclaredMethod("setLogin", String.class).invoke(objectJoueur, "cyrielle");
				objectJoueur.getClass().getDeclaredMethod("setMotDePasse", String.class).invoke(objectJoueur, "cyrielle1");
				System.out.println("Joueur "+objectJoueur);

				Object creationcompte = objectService.getClass().getDeclaredMethod("creerCompte", Object.class).invoke(objectService,objectJoueur );
				System.out.println("enregistrement "+creationcompte);
				
				//Appeler les methodes partie
				objectPartie.getClass().getDeclaredMethod("setNomPartie", String.class).invoke(objectPartie, "Poll");
				System.out.println(objectPartie);
				
				//CreationPartie
				Object creerPartie = objectService.getClass().getDeclaredMethod("creerPartie", Object.class).invoke(objectService,objectPartie );
				System.out.println("enregistrement "+creerPartie);
				
				//Appeler les methodes verificationPartie
				boolean trouvePartie = (boolean) objectService.getClass().getDeclaredMethod("verifierPartie",Object.class).invoke(objectService,objectPartie);	
				System.out.println("trouverla Partie : "+trouvePartie);
				
					//AfficherEtatPArtie
					String afficherEtatPartie = (String) objectService.getClass().getDeclaredMethod("afficherEtatPartie",Object.class).invoke(objectService,objectPartie);	
					System.out.println("afficherEtatPartie : "+afficherEtatPartie);
			
				
				boolean fermerPartie =false;
				while (fermerPartie != true){
					//Appeler les methodes recupererJoueur
					Object recuperePartie = objectService.getClass().getDeclaredMethod("recupererPartie",Object.class).invoke(objectService,objectPartie);
					System.out.println("Recuperation du joueur "+recuperePartie);
					
					//Appeler les methodes rejoindrePartie
					boolean rejoindrePartie = (boolean) objectService.getClass().getDeclaredMethod("rejoindrePartie",Object.class).invoke(objectService,objectPartie);	
					System.out.println("rejoindrePartie : "+rejoindrePartie);
					//FermerPartie
					 fermerPartie = (boolean) objectService.getClass().getDeclaredMethod("fermerPartie",Object.class).invoke(objectService,objectPartie);	
					System.out.println("fermerPartie : "+fermerPartie);
						
				}
					
					*/
					
				//Appeller commande
				//boolean enregisrerDemanderAuthentification = (boolean) objectService.getClass().getDeclaredMethod("demanderAuthentification",Object.class).invoke(objectService,"DemandeAuthentification");	
				//System.out.println("enregisrerDemanderAuthentification "+enregisrerDemanderAuthentification);

			} catch (MalformedURLException e) {
				e.printStackTrace();
			} catch (RemoteException e) {
				e.printStackTrace();
			} catch (NotBoundException e) {
				e.printStackTrace();
			} catch (SecurityException e) {
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			}
	}

}