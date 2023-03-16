package fr.fms.dao;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;


import fr.fms.entities.Category;
import fr.fms.entities.Training;
import fr.fms.entities.User;

/**
 * programme permettant de regénérer le fichier de configuration
 *  
 * 
 */

public class CreateConfigFile {
	
	public static final String YELLOW = "\033[0;33m";
	public static final String BLUE = "\033[0;34m";
	public static final String PURPLE_BRIGHT = "\033[0;95m";

	public static void main(String[] args) throws IOException {
		ArrayList<Training> trainings = new ArrayList<Training>();
		
		Properties prop = readPropertiesFile("files/config.properties");
		String login = prop.getProperty("db.login");
		String password = prop.getProperty("db.password");
		String url = prop.getProperty("db.url");
		String driver = prop.getProperty("db.driver.class");
		System.out.println(login +"\n" + password +"\n" + url +"\n" + driver);
		System.out.println();
		try {
			// Sert à charger le pilote
			Class.forName(driver);
		}
		catch(ClassNotFoundException e) {

		}

		// Connection de java.sql
		try(Connection connection = DriverManager.getConnection(url, login, password)){			

			String strSql = "SELECT * FROM T_Trainings";
		
			try(Statement statement = connection.createStatement()){
				// ResultSet de java.sql
				try(ResultSet resultSet = statement.executeQuery(strSql)){
					while(resultSet.next()) {
						// Index (de 1 à n) de la colonne, soit le nom de la colonne
						int rsId = resultSet.getInt(1);	
						String rsTrainingName = resultSet.getString(2);
						String rsDescription = resultSet.getString(3);
						int rsDurationTraining = resultSet.getInt(4);
						double rsPrice = resultSet.getDouble(5);
						String rsPresentialorRemote = resultSet.getString(6);
						trainings.add((new Training(rsId,rsTrainingName,rsDescription,rsDurationTraining,rsPrice,rsPresentialorRemote)));						
					}
				}	
			}
				// Affichage de toutes les formations
			for(Training t : trainings) 
				System.out.println(t.getId() + " - " + t.getTrainingName() + " - " + t.getDescription() + " - " + t.getDurationTraining() + " - " +
						+ t.getPrice() + t.getId() + " - " + t.getPresentialorRemote());
			
		}
		catch(SQLException e) {
			e.printStackTrace();
		} 
	}

	public static Properties readPropertiesFile(String fileName) throws IOException {
		FileInputStream fis = null;
		Properties prop = null;
		try {

			fis = new FileInputStream(fileName);
			prop = new Properties();
			prop.load(fis);
		} catch(FileNotFoundException fnfe) {
			fnfe.printStackTrace();
		} catch(IOException ioe) {
			ioe.printStackTrace();
		} finally {
			fis.close();
		}
		return prop;
	}
}	