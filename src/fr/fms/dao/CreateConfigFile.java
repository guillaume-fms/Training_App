package fr.fms.dao;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Properties;

/**
 * programme permettant de regénérer le fichier de configuration
 * @author GuillaumePastor 
 * 
 */

public class CreateConfigFile {

	public static void main(String[] args) {
		try (OutputStream ops = new FileOutputStream("files/config.properties")) {		
			Properties properties = new Properties();	
			properties.setProperty("db.driver", "org.mariadb.jdbc.Driver");
			properties.setProperty("db.url", "jdbc:mariadb://localhost:3306/Training");
			properties.setProperty("db.login", "root");
			properties.setProperty("db.password", "fms2023");
			
		}
		catch (IOException io) {
			io.printStackTrace();
		}
	}
}
