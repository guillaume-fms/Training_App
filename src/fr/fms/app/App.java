package fr.fms.app;

import java.util.Scanner;

import fr.fms.business.IBusinessImpl;
import fr.fms.entities.Category;
import fr.fms.entities.Training;

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


	private static final String COLUMN_CATNAME = "CATNAME"; 

	private static int idUser = 0;
	private static String login = null;


	private static Object business; 

	public static void main(String[] args) {
		System.out.println("Bonjour et bienvenue dans ma e-boutique formations, voici la liste des formations disponibles\n");
		System.out.println();
		displayTrainings();
		int choice = 0;
		while(choice != 8) {
			displayMenu();
			choice = scanInt();
			switch(choice) {
			case 1 : addTraining();				
			break;					
			case 2 : removeTraining();
			break;					
			case 3 : displayCart(true);
			break;					
			case 4 : displayTrainings();
			break;						
			case 5 : displayCategories();
			break;
			case 6 : displayTrainingByCategoryId();
			break;
			case 7 : connection();
			break;
			case 8 : System.out.println("A bientôt dans notre boutique de e-formations. :)");
			break;					
			default : System.out.println("Veuillez saisir une valeur entre 1 et 8");
			}
		}
	}

	private static void displayCategories() {
		System.out.println(Category.centerString(COLUMN_ID) + Category.centerString(COLUMN_CATNAME) + Category.centerString(COLUMN_DESCRIPTION));
		//business.readCategories().forEach(System.out::println);		
	}	


	private static void displayCart(boolean b) {
		
		}

	/**
	 * Méthode qui affiche tous les formations par catégorie en utilisant printf
	 */
	private static void displayTrainingByCategoryId() {
		System.out.println("saisissez l'id de la catégorie concerné");
		int id = scanInt();
		Category category = ((IBusinessImpl) business).readOneCategory(id);
		if(category != null) {
			System.out.printf("              AFFICHAGE PAR CATEGORIE    %n");
			System.out.printf("                     %-10s               %n",category.getName());
			System.out.printf("------------------------------------------------------------%n");
			System.out.printf("%-15s | %-15s | %-15s | %-15s %n",COLUMN_ID,COLUMN_TRAINING_NAME,COLUMN_DESCRIPTION,COLUMN_DURATION_TRAINING,COLUMN_PRICE,COLUMN_PRESENTIAL_OR_REMOTE);
			System.out.printf("------------------------------------------------------------%n");
			System.out.println();
			//business.readTrainingByCatId(id).forEach( a -> System.out.printf("%-15s | %-15s | %-15s | %-15s%n",t.getId(),t.getTrainingName(),t.getDescription(),t.getDurationTraining(), t.getPrice(),t.getPresentialorRemote()));
		}
		else System.out.println("cette catégorie n'existe pas !");

	}

	private static void connection() {
		if(login != null) {
			System.out.println("Souhaitez vous déconnecter ? Oui/Non");
			String response = scan.next();
			if(response.equalsIgnoreCase("Oui")) {
				System.out.println("A bientôt " + login + TEXT_RESET);
				login = null;
				idUser = 0;
			}
		}


	}

	private static void nextStep() {
		// TODO Auto-generated method stub

	}

	private static void removeTraining() {
		// TODO Auto-generated method stub

	}

	private static void addTraining() {
		// TODO Auto-generated method stub

	}

	private static int scanInt() {
		while(!scan.hasNextInt()) {
			System.out.println("saisissez une valeur entière svp");
			scan.next();
		}
		return scan.nextInt();
	}

	/**
	 * Méthode qui affiche le menu principal
	 */
	private static void displayMenu() {
		System.out.println("Faites votre choix dans le menu, saisissez le chiffre correspondant :");
		System.out.println();
		System.out.println(TEXT_GREEN + "1) : Ajouter une formation à votre panier");
		System.out.println(TEXT_GREEN + "2) : Supprimer une formation à votre panier");
		System.out.println(TEXT_GREEN + "3) : Afficher mon panier des formations + total pour passer commande");
		System.out.println(TEXT_GREEN + "4) : Afficher toutes les formations qui sont disponibles");
		System.out.println(TEXT_GREEN + "5) : Afficher toutes les catégories de formations en base de données");
		System.out.println(TEXT_GREEN + "6) : Afficher toutes les formations d'une catégorie spécifiée");
		System.out.println(TEXT_GREEN + "7) : Connexion ou Deconnexion à votre compte");
		System.out.println(TEXT_RED   + "8) : Quitter l'application");
		System.out.println();

	}

	/**
	 * Méthode qui affiche toutes les formations en base en centrant le texte 
	 */
	private static void displayTrainings() {
		System.out.println(Training.centerString(COLUMN_ID) + Training.centerString(COLUMN_TRAINING_NAME) + Training.centerString(COLUMN_DESCRIPTION) + Training.centerString(COLUMN_DURATION_TRAINING)
		+ Training.centerString(COLUMN_PRICE) + Training.centerString(COLUMN_PRESENTIAL_OR_REMOTE));	

	}
}