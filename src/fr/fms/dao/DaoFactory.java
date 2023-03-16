package fr.fms.dao;

import fr.fms.entities.Category;
import fr.fms.entities.Customer;
import fr.fms.entities.Order;
import fr.fms.entities.OrderTraining;
import fr.fms.entities.Training;
import fr.fms.entities.User;

public class DaoFactory {

	public static Dao<Training> getTrainingDao() {
		return new TrainingDao();		
	}

	public static Dao<User> getUserDao() {
		return new UserDao();
	}

	public static CategoryDao getCategoryDao() {
		return  new CategoryDao();
	}


	public static Dao<Customer> getCustomerDao() {
		return new CustomerDao();
	}

	public static Dao<Order> getOrderDao() {
		return new OrderDao();

	}

	public static Dao<OrderTraining> getOrderTrainingDao() {
		// TODO Auto-generated method stub
		return null;
	}
}

