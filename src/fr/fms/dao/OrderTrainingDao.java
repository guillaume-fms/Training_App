package fr.fms.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import fr.fms.entities.Training;

public class OrderTrainingDao implements Dao<OrderTrainingDao> {

	@Override
	public boolean create(OrderTrainingDao obj) {
		String str = "INSERT INTO T_Order_Trainings (IdTraining, Quantity, UnitaryPrice, IdOrder) VALUES (?,?,?,?);";	
		try (PreparedStatement ps = connection.prepareStatement(str)){	
			ps.setInt(1, obj.getIdTraining());
			ps.setInt(2, obj.getQuantity());
			ps.setDouble(3, obj.getUnitaryPrice());
			ps.setInt(4, obj.getIdOrder());

			ps.executeUpdate();			
			return true;
		} catch (SQLException e) {
			logger.severe("pb sql sur la création d'une orderTraining : " + e.getMessage());
		}
		return false;
	}

	private int getIdOrder() {
		// TODO Auto-generated method stub
		return 0;
	}

	private double getUnitaryPrice() {
		// TODO Auto-generated method stub
		return 0;
	}

	private int getQuantity() {
		// TODO Auto-generated method stub
		return 0;
	}

	private int getIdTraining() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public OrderTrainingDao read(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean update(OrderTrainingDao obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(OrderTrainingDao obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ArrayList<OrderTrainingDao> readAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Training> readAll(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
