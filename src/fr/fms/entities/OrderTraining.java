package fr.fms.entities;

public class OrderTraining {


	// Attributs
	private int idOrderItem;
	private int idTraining;
	private int quantity;
	private double unitaryPrice;
	private int idOrder;


	// Constructeur
	public OrderTraining(int idOrderItem, int idTraining, int quantity, double unitaryPrice, int idOrder) {
		this.idOrderItem = idOrderItem;
		this.idTraining = idTraining;
		this.quantity = quantity;
		this.unitaryPrice = unitaryPrice;
		this.idOrder = idOrder;
	}


	// Getters Setters
	public int getIdOrderItem() {
		return idOrderItem;
	}

	public void setIdOrderItem(int idOrderItem) {
		this.idOrderItem = idOrderItem;
	}

	public int getIdTraining() {
		return idTraining;
	}

	public void setIdTraining(int idTraining) {
		this.idTraining = idTraining;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getUnitaryPrice() {
		return unitaryPrice;
	}

	public void setUnitaryPrice(double unitaryPrice) {
		this.unitaryPrice = unitaryPrice;
	}

	public int getIdOrder() {
		return idOrder;
	}

	public void setIdOrder(int idOrder) {
		this.idOrder = idOrder;
	}


	// Methode toString()
	@Override
	public String toString() {
		return "OrderTraining [idOrderItem=" + idOrderItem + ", idTraining=" + idTraining + ", quantity=" + quantity
				+ ", unitaryPrice=" + unitaryPrice + ", idOrder=" + idOrder + "]";
	}


}

