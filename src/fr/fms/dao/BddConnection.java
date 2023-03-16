package fr.fms.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class BddConnection {
	
	
	public static final String RED_BOLD = "\033[1;31m"; 
	public static final String GREEN_BOLD = "\033[1;32m"; 
	
	public static void main(String[] args) throws ClassNotFoundException  {
		
				Properties prop = readPropertiesFile("files/config.properties");
	            String url,driver,login,password;  
	            Connection con = null;  
	            try {  
	                Class.forName("org.mariadb.jdbc.Driver"); 
	                driver ="db.driver.class";
	                url="jdbc:mariadb://localhost:3306/Training";
	                login = "root";
	                password = "fms2023" ; 
	                con = DriverManager.getConnection(url, login, password);  
	                System.out.println(GREEN_BOLD + "Connection OK");  
	                con.close();  
	                System.out.println( RED_BOLD + "Connection terminée");  
	                System.out.println(login +"\n" + password +"\n" + url +"\n" + driver);
	                }  
	                catch (Exception e) {  
	                System.out.println(e.toString());  
	            }  
	    }

	private static Properties readPropertiesFile(String string) {
		// TODO Auto-generated method stub
		return null;
	}

	public static Connection getConnection() {
		// TODO Auto-generated method stub
		return null;
	}
}