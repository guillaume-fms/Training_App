package fr.fms.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import fr.fms.entities.Training;

public class TrainingDao implements Dao<Training> {

	@Override
	public boolean create(Training obj) {
		String str = "INSERT INTO T_Trainings (TrainingName, Description, DurationTraining, Price, PresentialorRemote, IdCategory) VALUES (?,?,?,?);";	
		try (PreparedStatement ps = connection.prepareStatement(str)){
			ps.setString(1, obj.getTrainingName());
			ps.setString(2, obj.getDescription());
			ps.setInt(3, obj.getDurationTraining());
			ps.setDouble(4, obj.getPrice());
			ps.setInt(5, obj.getPresentialorRemote());
			ps.setInt(6, obj.getCategory());
			if( ps.executeUpdate() == 1)	return true;
		} catch (SQLException e) {
			logger.severe("pb sql sur la création d'une formation " + e.getMessage());
		} 	
		return false;
	}

//	@Override
//	public Training read(int id) {
//		try (Statement statement = connection.createStatement()){
//			String str = "SELECT * FROM T_Training where IdTraining=" + id + ";";									
//			ResultSet rs = statement.executeQuery(str);
//			if(rs.next()) return new Training(rs.getInt(1) , rs.getString(2) , rs.getString(3) , rs.getInt(4), rs.getDouble(5),rs.getString(6));
//		} catch (SQLException e) {
//			logger.severe("pb sql sur la lecture d'une formation " + e.getMessage());
//		} 	
//		return null;
//	}

	@Override
	public boolean update(Training obj) {
		String str = "UPDATE T_Trainings set Description=? , TrainingName=? where idTraining=?;";	
		try (PreparedStatement ps = connection.prepareStatement(str)){
			ps.setString(1, obj.getTrainingName());
			ps.setString(2, obj.getDescription());
			ps.setInt(3, obj.getDurationTraining());
			ps.setDouble(4, obj.getPrice());	
			ps.setInt(5, obj.getPresentialorRemote());
			if( ps.executeUpdate() == 1)	return true;
			return true;
		} catch (SQLException e) {
			logger.severe("pb sql sur la mise à jour d'une formation " + e.getMessage());
		} 	
		return false;
	}

	@Override
	public boolean delete(Training obj) {
		try (Statement statement = connection.createStatement()){
			String str = "DELETE FROM T_Trainings where IdTraining=" + obj.getId() + ";";									
			statement.executeUpdate(str);		
			return true;
		} catch (SQLException e) {
			logger.severe("pb sql sur la suppression d'une formation " + e.getMessage());
		} 	
		return false;
	}

	@Override
	public ArrayList<Training> readAll() {
		ArrayList<Training> trainings = new ArrayList<Training>();
		String strSql = "SELECT * FROM T_Trainings";		
		try(Statement statement = connection.createStatement()){
			try(ResultSet resultSet = statement.executeQuery(strSql)){ 			
				while(resultSet.next()) {
					int rsId = resultSet.getInt(1);	
					String rsTrainingName = resultSet.getString(2);
					String rsDescription = resultSet.getString(3);
					int rsDurationTraining = resultSet.getInt(4);
					double rsPrice = resultSet.getDouble(5);
					String rsPresentialorRemote = resultSet.getString(6);
					trainings.add((new Training(rsId,rsTrainingName,rsDescription,rsDurationTraining,rsPrice,rsPresentialorRemote)));						
				}	
			}
		} catch (SQLException e) {
			logger.severe("pb sql sur l'affichage des formations  " + e.getMessage());
		}	
		catch (Exception e) {
			logger.severe("pb : " + e.getMessage());
		}
		return trainings;
	}



	public ArrayList<Training> readAllByCat(int id) {
		ArrayList<Training> trainings = new ArrayList<Training>();
		String strSql = "SELECT * FROM T_Trainings where idCategory=" + id;		
		try(Statement statement = connection.createStatement()){
			try(ResultSet resultSet = statement.executeQuery(strSql)){ 			
				while(resultSet.next()) {
					int rsId = resultSet.getInt(1);
					String rsTrainingName = resultSet.getString(2);
					String rsDescription = resultSet.getString(3);
					int rsDurationTraining = resultSet.getInt(4);
					double rsPrice = resultSet.getDouble(5);
					String rsPresentialorRemote = resultSet.getString(6);
					trainings.add((new Training(rsId,rsTrainingName,rsDescription,rsDurationTraining,rsPrice,rsPresentialorRemote)));						
				}	
			}
		} catch (SQLException e) {
			logger.severe("pb sql sur l'affichage des formations par catégories " + e.getMessage());
		}			
		return trainings;
	}

	@Override
	public ArrayList<Training> readAll(int id) {
		ArrayList<Training> trainings = new ArrayList<Training>();
		String strSql = "SELECT * FROM T_Trainings where idCategory=" + id;		
		try(Statement statement = connection.createStatement()){
			try(ResultSet resultSet = statement.executeQuery(strSql)){ 			
				while(resultSet.next()) {
					int rsId = resultSet.getInt(1);
					String rsTrainingName = resultSet.getString(2);
					String rsDescription = resultSet.getString(3);
					int rsDurationTraining = resultSet.getInt(4);
					double rsPrice = resultSet.getDouble(5);
					String rsPresentialorRemote = resultSet.getString(6);
					trainings.add((new Training(rsId,rsTrainingName,rsDescription,rsDurationTraining,rsPrice,rsPresentialorRemote)));						
				}	
			}
		} catch (SQLException e) {
			logger.severe("pb sql sur l'affichage des formations par catégories " + e.getMessage());
		}			
		return trainings;
	}

	@Override
	public Training read(int id) {
		// TODO Auto-generated method stub
		return null;
	}
}