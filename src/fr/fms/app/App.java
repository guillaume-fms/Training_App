package fr.fms.app;

import java.util.Scanner;



public class App {
	private static Scanner scan = new Scanner(System.in); 
	
	
	public static final String TEXT_BLUE = "\u001B[36m";
	public static final String TEXT_RESET = "\u001B[0m";
	public static final String TEXT_RED = "\033[0;31m"; ;
	private static final String COLUMN_ID = "IDENTIFIANT";
	private static final String COLUMN_TRAINING_NAME = "NOM FORMATION";
	private static final String COLUMN_DESCRIPTION = "DESCRIPTION";
	private static final String COLUMN_DURATION_TRAINING = "DUREE FORMATION";
	private static final String COLUMN_PRICE = "PRIX";
	private static final String COLUMN_PRESENTIAL_OR_REMOTE = "PRESENTIEL ou DISTANCIEL";  
	public static void main(String[] args) {
		
		System.out.println("Bonjour et bienvenue dans ma boutique de formations, voici la liste des formations.\n");
	}		

	
	/**
	 * Méthode qui affiche le menu principal
	 */
	public static void displayMenu() {	
		Object login = null;
		if(login != null)	System.out.print(TEXT_BLUE + "Compte : " + login);
		System.out.println("\n" + "Pour réaliser une action, tapez le code correspondant");
		System.out.println("1 : Ajouter une formation au panier");
		System.out.println("2 : Retirer une formation du panier");
		System.out.println("3 : Afficher mon panier + total pour passer commande");
		System.out.println("4 : Afficher tous les formations disponibles");
		System.out.println("5 : Afficher toutes les catégories en base");
		System.out.println("6 : Afficher toutes les formations d'une catégorie");
		System.out.println("7 : Connexion(Deconnexion) à votre compte");
		System.out.println("8 : Sortir de l'application");
	}
	
	}


