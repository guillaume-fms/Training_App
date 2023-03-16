
package fr.fms.business;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import fr.fms.dao.Dao;
import fr.fms.dao.DaoFactory;
import fr.fms.entities.Category;
import fr.fms.entities.Customer;
import fr.fms.entities.Order;
import fr.fms.entities.OrderTraining;
import fr.fms.entities.Training;
import fr.fms.entities.User;

public class IBusinessImpl implements Business {	
	private HashMap<Integer,Training> cart;
	private Dao<Training> articleDao = DaoFactory.getTrainingDao();
	private Dao<User> userDao = DaoFactory.getUserDao();
	private Dao<Category> categoryDao = DaoFactory.getCategoryDao();
	private Dao<Order> orderDao = DaoFactory.getOrderDao();
	private Dao<OrderTraining> orderTrainingDao = DaoFactory.getOrderTrainingDao();
	private Dao<Customer> customerDao = DaoFactory.getCustomerDao();

	public IBusinessImpl() {
		this.cart = new HashMap<Integer,Training>();
	}

	@Override
	public void addToCart(Training training) {
		Training t = cart.get(training.getId());
		if(t != null) {
			t.setQuantity(t.getQuantity() + 1);
		}
		else cart.put(training.getId(), training);
	}

	@Override
	public void rmFromCart(int id) {
		Training training = cart.get(id);
		if(training != null) {
			if(training.getQuantity() == 1)	cart.remove(id);
			else training.setQuantity(training.getQuantity() - 1);
		}				
	}

	@Override
	public ArrayList<Training> getCart() {
		return new ArrayList<Training> (cart.values());
	}

	@Override
	public int order(int idCustomer) {	
		if(customerDao.read(idCustomer) != null) {
			double total = getTotal(); 
			Order order = new Order(total, new Date(), idCustomer);
			if(orderDao.create(order)) {	
				for(Training training : cart.values()) {	
					orderTrainingDao.create(new OrderTraining(0, training.getId(), training.getQuantity(), training.getPrice(), order.getIdOrder()));
				}
				return order.getIdOrder();
			}
		}
		return 0;
	}

	public ArrayList<Training> readTraining() {
		return articleDao.readAll();
	}

	@Override
	public ArrayList<Category> readCategories() {
		return categoryDao.readAll();
	}


	/**
	 * renvoi le total de la commande en cours
	 * @return total
	 */
	public double getTotal() {
		double [] total = {0};
		cart.values().forEach((a) -> total[0] += a.getPrice() * a.getQuantity()); 	
		return total[0];
	}

	public boolean isCartEmpty() {
		return cart.isEmpty();
	}

	public void clearCart() {
		cart.clear();		
	}

	public Category readOneCategory(int id) {
		return categoryDao.read(id);
	}



	@Override
	public ArrayList<Training> readTrainings() {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public ArrayList<Training> readTrainingByCatId(int idCat) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Training readOneTraining(int id) {
		// TODO Auto-generated method stub
		return null;
	}
}
