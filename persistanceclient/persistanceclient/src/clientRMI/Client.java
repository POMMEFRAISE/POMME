package clientRMI;

import java.lang.reflect.InvocationTargetException;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.server.RMIClassLoader;

public class Client {
	public static void main(String[] argv) throws Exception {
		if (System.getSecurityManager() == null) {
			System.setProperty("java.security.policy", "file:/C:/Users/Cyrielle/git/PDS/persistanceclient/persistanceclient/bin/clientRMI/client.policy");
			System.setProperty("java.rmi.server.codebase", "file:/C:/Users/Cyrielle/git/PDS/persistanceservice/persistanceservice/bin/");
			System.setSecurityManager(new SecurityManager());
		}
			try {
				Naming.lookup("//127.0.0.1/ServiceJoueur");
				
				//url
				String url="file:/C:/Users/Cyrielle/git/PDS/persistanceservice/persistanceservice/bin/";
				
				//Appelle de la classe JoueurDTO
				Class<?> joueurDTO = RMIClassLoader.loadClass(url,"dto.JoueurDTO");
				Object objectJoueur = joueurDTO.newInstance();
				Object objectJoueurCreationCompte = joueurDTO.newInstance();
				Object objectJoueurMiseaJour = joueurDTO.newInstance();


				
				//Charger interface 
				Class<?> serviceJoueur = RMIClassLoader.loadClass(url,"serviceFacade.ServiceFacade");
				Object objectServiceJoueur = serviceJoueur.newInstance();

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
				}
					//Appeler les methodes joueur
				objectJoueurCreationCompte.getClass().getDeclaredMethod("setNom", String.class).invoke(objectJoueurCreationCompte, "TOMATE");
				objectJoueurCreationCompte.getClass().getDeclaredMethod("setPrenom", String.class).invoke(objectJoueurCreationCompte, "Paul");
				objectJoueurCreationCompte.getClass().getDeclaredMethod("setEmail", String.class).invoke(objectJoueurCreationCompte, "Paul@yahoo.com");
				objectJoueurCreationCompte.getClass().getDeclaredMethod("setLogin", String.class).invoke(objectJoueurCreationCompte, "Paulp");
				objectJoueurCreationCompte.getClass().getDeclaredMethod("setMotDePasse", String.class).invoke(objectJoueurCreationCompte, "Paul1");
					
				//Appeler les methodes CreationCompte
					
				boolean creationJoueur = (boolean) objectServiceJoueur.getClass().getDeclaredMethod("creationCompte",Object.class).invoke(objectServiceJoueur, objectJoueurCreationCompte);

				if(trouveJoueur == true){
					if (creationJoueur == true){
						System.out.println("Nom joueur : "+objectJoueur.getClass().getMethod("getNom").invoke(objectJoueurCreationCompte));
						System.out.println("Prenom joueur : "+objectJoueur.getClass().getMethod("getPrenom").invoke(objectJoueurCreationCompte));
						System.out.println("Email joueur : "+objectJoueur.getClass().getMethod("getEmail").invoke(objectJoueurCreationCompte));
						System.out.println("Login joueur : "+objectJoueur.getClass().getMethod("getLogin").invoke(objectJoueurCreationCompte));	
					}
				}
					
				
					
				
					
				
				
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InstantiationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (NotBoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (NoSuchMethodException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SecurityException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}

}