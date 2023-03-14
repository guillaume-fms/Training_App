package fr.fms.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import fr.fms.entities.Training;
import fr.fms.entities.User;

public class UserDao implements Dao<User> {

	@Override
	public boolean create(User obj) {
		String str = "INSERT INTO T_Users (Login,Password) VALUES (?,?);";
		try (PreparedStatement ps = connection.prepareStatement(str)){
			ps.setString(1, obj.getLogin());
			ps.setString(2, obj.getPwd());			
			if( ps.executeUpdate() == 1)	return true;				
		} catch (SQLException e) {
			logger.severe("pb sql sur la création d'un utilisateur ");
		} 			
		return false;
	}

	@Override
	public User read(int id) {
		try (Statement statement = connection.createStatement()){
			String str = "SELECT * FROM T_Users where IdUser=" + id + ";";									
			ResultSet rs = statement.executeQuery(str);
			if(rs.next()) 
				return new User(rs.getInt(1) , rs.getString(2) , rs.getString(3));
		} catch (SQLException e) {
			logger.severe("pb sql sur la lecture d'un user " + e.getMessage());
		} 	
		return null;

	}

	@Override
	public boolean update(User obj) {
		try (Statement statement = connection.createStatement()){
			String str = "UPDATE T_Users set Login='" + obj.getLogin() +"' , " +
					"Password='" 		+ obj.getPwd() +"' , " + " where idUser=" + obj.getId() + ";";			
			statement.executeUpdate(str);
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} 	
		return true;

	}

	@Override
	public boolean delete(User obj) {
		try (Statement statement = connection.createStatement()){
			String str = "DELETE FROM T_User where IdUser=" + obj.getId() + ";";									
			statement.executeUpdate(str);		
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;

	}

	@Override
	public ArrayList<User> readAll() {
		ArrayList<User> users = new ArrayList<User>();
		String strSql = "SELECT * FROM T_Users";		
		try(Statement statement = connection.createStatement()){
			try(ResultSet resultSet = statement.executeQuery(strSql)){ 			
				while(resultSet.next()) {
					int rsId = resultSet.getInt(1);	
					String rsLogin = resultSet.getString(2);
					String rsPassword = resultSet.getString(3);							
					users.add((new User(rsId,rsLogin,rsPassword)));						
				}	
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}			
		return users;
	}

	@Override
	public ArrayList<Training> readAll(int id) {
		// TODO Auto-generated method stub
		return null;
	}	

}
