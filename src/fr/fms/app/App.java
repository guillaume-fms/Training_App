package fr.fms.app;

import java.util.Scanner;



public class App {
	private static Scanner scan = new Scanner(System.in); 


	public static final String TEXT_BLUE = "\u001B[36m";
	public static final String TEXT_RESET = "\u001B[0m";
	public static final String TEXT_RED = "\033[0;31m";
	public static final String TEXT_GREEN = "\033[0;32m"; ;

	private static final String COLUMN_ID = "IDENTIFIANT";
	private static final String COLUMN_TRAINING_NAME = "NOM FORMATION";
	private static final String COLUMN_DESCRIPTION = "DESCRIPTION";
	private static final String COLUMN_DURATION_TRAINING = "DUREE FORMATION";
	private static final String COLUMN_PRICE = "PRIX";
	private static final String COLUMN_PRESENTIAL_OR_REMOTE = "PRESENTIEL ou DISTANCIEL";  
	public static void main(String[] args) {


		/**
		 * Méthode qui affiche le menu principal
		 */

		System.out.println("Bonjour et bienvenue dans ma boutique de formations, voici la liste des formations.\n");
		System.out.println();
		String input = "-1";
		while (!input.equals("5")) {		
			System.out.println("Faites votre choix dans le menu, saisissez le chiffre correspondant :");
			System.out.println();
			System.out.println(TEXT_GREEN + "1) : Ajouter une formation à votre panier");
			System.out.println(TEXT_GREEN + "2) : Supprimer une formation à votre panier");
			System.out.println(TEXT_GREEN + "3) : Afficher mon panier des formations + total pour passer commande");
			System.out.println(TEXT_GREEN + "4) : Afficher toutes les formations qui sont disponibles");
			System.out.println(TEXT_GREEN + "5) : Afficher toutes les catégories de formations en base");
			System.out.println(TEXT_GREEN + "6) : Afficher toutes les formations d'une catégorie spécifiée");
			System.out.println(TEXT_GREEN + "7) : Connexion ou Deconnexion à votre compte");
			System.out.println(TEXT_RED + "8) : Quitter l'application");	
			input = scan.next();		
			while (!input.equals("1") && !input.equals("2") && !input.equals("3") && !input.equals("4") && !input.equals("5")
					&& !input.equals("6") && !input.equals("7") && !input.equals("8")) {
				System.out.println("Votre saisie ne correspond à aucun des choix disponibles, veuillez réessayer svp !!");
				input = scan.next();
			}
			scan.nextLine();
			System.out.println(" ");
		}
	}		

}

