//package controller;
//
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.Scanner;
//
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import model.De;
//import model.Joueur;
//
///**
// * Servlet implementation class Jouer
// */
//public class Jouer extends HttpServlet {
//	private static final long serialVersionUID = 1L;
//       
//    /**
//     * @see HttpServlet#HttpServlet()
//     */
//    public Jouer() {
//        super();
//        // TODO Auto-generated constructor stub
//    }
//
//	/**
//	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
//	 */
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		
//		int maxS = 0;
//		String premierJoueur = null;
//		ArrayList<De> lesDes = new ArrayList<>();
//		//nombre minimum et maximum de joueurs
//		int minJ = 3;
//		int maxJ = 7;
//		int sommeDes;
//		ArrayList<Joueur> lesJoueurs = new ArrayList<>();
//		
//		// Création des 5 dés et ajoutés dans la liste
//		for (int d = 1; d <= 5; d++) {
//			De de = new De();
//			lesDes.add(de);
//		}
//
//		// Nombre de joueurs sélectionnés
//		Scanner sc1 = new Scanner(System.in);
//		System.out.println(
//				"\n\n \t\t Saisie du nombre des joueurs :  \n ****************************************************");
//		String nb1 = sc1.nextLine();
//		int nb = Integer.parseInt(nb1);
//		//Respecter : entre 3 et 7 joueurs
//		if (nb >= minJ && nb <= maxJ) {
//			System.out.println("Vous avez saisi " +nb+" joueurs");
//			
//			//Création des joueurs
//			for (int i = 1; i <= nb; i++) {
//				sommeDes=0;
//				Joueur j = new Joueur();
//				lesJoueurs.add(j);
//				System.out.println("Le nom du joueur n° "+i+" : ");
//				Scanner scj1 = new Scanner(System.in);
//				String nomJ = scj1.nextLine();
//				System.out.println("Nom joueur : " + nomJ);
//				j.setLogin(nomJ);
//				
//				// Pour chaque dé, on le lance au hasard et on affiche sa valeur
//				for (De unDe : lesDes) {
//					unDe.lancer();
//					System.out.println(unDe.getValeur());
//					sommeDes = sommeDes + unDe.getValeur();
//					request.getRequestDispatcher("AfficherDes.jsp").forward(request, response);
//				}
//				
//				System.out.println("La somme des dés est : "+sommeDes);
//
//				if(sommeDes > maxS){
//					maxS = sommeDes;
//					premierJoueur = j.getLogin();
//				}
//				System.out.println("Le plus grand nombre de points "+maxS);
//
//			}
//			request.getRequestDispatcher("PremierJoueur.jsp").forward(request, response);
//			System.out.println("\n\n \t\t Le premier joueur est : "+premierJoueur+"\n ****************************************************");
//			// Pour chaque dé, on le lance au hasard et on affiche sa valeur
//			/*for (De unDe : lesDes) {
//				unDe.lancer();
//				System.out.println(unDe.getValeur());
//				if(unDe.getValeur()==2){
//					System.out.println("Joueur de gauche");
//				}else if(unDe.getValeur()==5){
//					System.out.println("Joueur de droite");
//				}else if(unDe.getValeur()==1){
//					System.out.println("Au milieu de la table");
//				}else{
//					System.out.println("Rejouez les dés restants");
//				}
//			}*/
//
//			
//			
//		} else {
//			System.out.println("Le nombre de joueurs doit être en 3 et 7 joueurs");
//		}
//		
//		
//	}
//
//	/**
//	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
//	 */
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		doGet(request, response);
//	}
//
//}
