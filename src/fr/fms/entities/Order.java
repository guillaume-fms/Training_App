package fr.fms.entities;

import java.util.Date;

public class Order {

	// Attributs
	private int idOrder;
	private double amount;
	private Date date;
	private int idCustomer;


	// Constructeur
	public Order(int idOrder, double amount, Date date, int idCustomer) {
		this.idOrder = idOrder;
		this.amount = amount;
		this.date = date;
		this.idCustomer = idCustomer;
	}

	public Order(double amount, Date date, int idCustomer) {
		this.amount = amount;
		this.date = date;
		this.idCustomer = idCustomer;
	}

	// Getters Setters
	public int getIdOrder() {
		return idOrder;
	}

	public void setIdOrder(int idOrder) {
		this.idOrder = idOrder;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public int getIdCustomer() {
		return idCustomer;
	}

	public void setIdCustomer(int idCustomer) {
		this.idCustomer = idCustomer;
	}



	// Methode toString()

	@Override
	public String toString() {
		return "Order [idOrder=" + idOrder + ", amount=" + amount + ", date=" + date + ", idCustomer=" + idCustomer
				+ "]";
	}
}


