package fr.fms.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import fr.fms.entities.Customer;
import fr.fms.entities.Training;

public class CustomerDao implements Dao<Customer> {

	@Override
	public boolean create(Customer obj) {
		String str = "INSERT INTO T_Customers (Name, FirstName, Email, Phone, IdUser, IdCategory) VALUES (?,?,?,?,?,?);";	
		try (PreparedStatement ps = connection.prepareStatement(str)){
			ps.setString(1, obj.getName());
			ps.setString(2, obj.getFirstName());
			ps.setString(3, obj.getEmail());	
			ps.setString(4, obj.getPhone());
			ps.setInt(5, obj.getIdUser());
			ps.setInt(6, obj.getIdCategory());
			if( ps.executeUpdate() == 1)	return true;
		} catch (SQLException e) {
			logger.severe("pb sql sur la création d'un client " + e.getMessage());
		} 	
		return false;
	}

	@Override
	public Customer read(int id) {
		try (Statement statement = connection.createStatement()){
			String str = "SELECT * FROM T_Customers where IdCustomer=" + id + ";";									
			ResultSet rs = statement.executeQuery(str);
			if(rs.next()) return new Customer(rs.getString(1) , rs.getString(2) , rs.getString(3) , rs.getString(4), rs.getInt(5), rs.getInt(6));
		} catch (SQLException e) {
			logger.severe("pb sql sur la lecture sur le client " + e.getMessage());
		} 	
		return null;
	}

	@Override
	public boolean update(Customer obj) {
		String str = "UPDATE T_Customers set Name=? , FirstName=?, Email=?, Phone=?, where idCustomer=?;";	
		try (PreparedStatement ps = connection.prepareStatement(str)){				
			ps.setString(1, obj.getName());
			ps.setString(2, obj.getFirstName());
			ps.setString(3, obj.getEmail());
			ps.setString(4, obj.getPhone());
			ps.setInt(5, obj.getIdCustomer());
			if( ps.executeUpdate() == 1)	return true;
			return true;
		} catch (SQLException e) {
			logger.severe("pb sql sur la mise à jour d'un client " + e.getMessage());
		} 	
		return false;
	}

	@Override
	public boolean delete(Customer obj) {
		try (Statement statement = connection.createStatement()){
			String str = "DELETE FROM T_Customers where IdCustomer=" + obj.getIdCustomer() + ";";									
			statement.executeUpdate(str);		
			return true;
		} catch (SQLException e) {
			logger.severe("pb sql sur la suppression d'un client " + e.getMessage());
		} 	
		return false;
	}

	@Override
	public ArrayList<Customer> readAll() {
		ArrayList<Customer> customers = new ArrayList<Customer>();
		String strSql = "SELECT * FROM T_Customers";		
		try(Statement statement = connection.createStatement()){
			try(ResultSet resultSet = statement.executeQuery(strSql)){ 			
				while(resultSet.next()) {
					int rsIdCustomer = resultSet.getInt(1);	
					String rsName = resultSet.getString(2);
					String rsFirstName = resultSet.getString(3);
					String rsEmail = resultSet.getString(4);
					String rsPhone = resultSet.getString(5);
					customers.add((new Customer(rsIdCustomer,rsName,rsFirstName,rsEmail,rsPhone)));						
				}	
			}
		} catch (SQLException e) {
			logger.severe("pb sql sur l'affichage des clients " + e.getMessage());
		}	
		catch (Exception e) {
			logger.severe("pb : " + e.getMessage());
		}
		return customers;
	}

	@Override
	public ArrayList<Training> readAll(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
