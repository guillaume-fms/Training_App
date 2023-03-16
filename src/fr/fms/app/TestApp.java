package fr.fms.app;

import fr.fms.dao.CustomerDao;
import fr.fms.dao.TrainingDao;
import fr.fms.dao.UserDao;
import fr.fms.entities.Training;
import fr.fms.entities.User;

public class TestApp extends Thread {
	public TestApp(String name){
		super(name);
	}
	public void run(){
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(this.getName() + " : " + new TrainingDao().read(1));
		//System.out.println(this.getName() + " : " + new UserDao().read(1));
		//System.out.println(this.getName() + " : " + new CustomerDao().read(1));
	}      

	public static void main(String[] args) {	
		testThreads();

	}
	private static void testThreads() {
		TestApp t1 = new TestApp(" 1-");
		TestApp t2 = new TestApp(" 2-");
		TestApp t3 = new TestApp(" 3-");
		TestApp t4 = new TestApp(" 4-");
		TestApp t5 = new TestApp(" 5-");

		t1.start();
		t2.start();
		t3.start();
		t4.start();
		t5.start();
	}
	//afficher tous les utilisateurs en base
	private static void testUserDao() {
		UserDao userDao = new UserDao();

		for(User user : userDao.readAll())
			System.out.println(user);
	}
	//----------------test les méthodes Crud du composant d'accès aux données : TrainingDao
	private static void testTrainingDao() {
		TrainingDao trainingDao = new TrainingDao();

		//Afficher toutes les formations
		for(Training training : trainingDao.readAll()) {
			System.out.println(training);
		}	
		System.out.println();
		//Afficher une formation à partir de son id
		Training training = trainingDao.read(5);
		System.out.println(training);

		//Mise à jour de la formation
		training.setDescription("Langage C");
		trainingDao.update(training);

		//Supprimer une formation
		if(training != null)		
			trainingDao.delete(training);

		//Insertion d'une formation en base
		if(training != null)		
			trainingDao.create(training);

		System.out.println();
		//Afficher toutes les formations
		for(Training t : trainingDao.readAll()) {
			System.out.println(t);
		}			
	}	
}

