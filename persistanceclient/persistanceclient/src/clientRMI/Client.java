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
				
				//Appelle de la classe JoueurDTO
				Object objectJoueur = ChargerService.chargerDTO("JoueurDTO");
				
				//Charger interface 
				Object objectServiceJoueur = ChargerService.chargerInterface();

				//Appeler les methodes joueur
				objectJoueur.getClass().getDeclaredMethod("setLogin", String.class).invoke(objectJoueur, "cyrielle1");
				objectJoueur.getClass().getDeclaredMethod("setMotDePasse", String.class).invoke(objectJoueur, "jeux1");
				//System.out.println(objectJoueur);
				
				//Appeler les methodes verificationJoueur
				boolean trouveJoueur = (boolean) objectServiceJoueur.getClass().getDeclaredMethod("verificationJoueur",Object.class).invoke(objectServiceJoueur, objectJoueur);
				//System.out.println("SeConnecter : "+trouveJoueur);
				
				//Appeler les methodes recupererJoueur
				if(trouveJoueur == true){
					
					objectJoueur = objectServiceJoueur.getClass().getDeclaredMethod("recupererJoueur",Object.class).invoke(objectServiceJoueur, objectJoueur);
					System.out.println("Nom joueur : "+objectJoueur.getClass().getMethod("getNom").invoke(objectJoueur));
					System.out.println("Prenom joueur : "+objectJoueur.getClass().getMethod("getPrenom").invoke(objectJoueur));
					System.out.println("Login joueur : "+objectJoueur.getClass().getMethod("getLogin").invoke(objectJoueur));
				}else{
					//Retourner un message d'erreur
				}
					
			} catch (MalformedURLException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (RemoteException e) {
				e.printStackTrace();
			} catch (NotBoundException e) {
				e.printStackTrace();
			} catch (NoSuchMethodException e) {
				e.printStackTrace();
			} catch (SecurityException e) {
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				e.printStackTrace();
			}
	}

}