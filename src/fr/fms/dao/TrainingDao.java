package fr.fms.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import fr.fms.entities.Training;

public class TrainingDao implements Dao<Training> {

	@Override
	public boolean create(Training obj) {
		
		return false;
	}

	@Override
	public Training read(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean update(Training obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Training obj) {
		// TODO Auto-generated method stub
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
			logger.severe("pb sql sur l'affichage des articles " + e.getMessage());
		}	
		catch (Exception e) {
			logger.severe("pb : " + e.getMessage());
		}
		return trainings;
	}

	@Override
	public ArrayList<Training> readAll(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
