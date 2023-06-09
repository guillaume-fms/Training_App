package fr.fms.entities;

public class Customer {


	// Attributs
	private int idCustomer;
	private String name;
	private String firstName;
	private String email;
	private String phone;
	private int idUser;
	private int idCategory;


	// Constructor
	public Customer(int idCustomer, String name, String firstName, String email, String phone, int idUser, int idCategory) {
		super();
		this.idCustomer = idCustomer;
		this.name = name;
		this.firstName = firstName;
		this.email = email;
		this.phone = phone;
		this.idUser = idUser;
		this.idCategory = idCategory;
	}



	public Customer(String name, String firstName, String email, String phone, int idUser, int idCategory) {
		super();
		this.name = name;
		this.firstName = firstName;
		this.email = email;
		this.phone = phone;
		this.idUser = idUser;
		this.idCategory = idCategory;
	}

	public Customer(int idCustomer, String name, String firstName, String email, String phone) {
		super();
		this.idCustomer = idCustomer;
		this.name = name;
		this.firstName = firstName;
		this.email = email;
		this.phone = phone;
	}



	// Getters Setters
	public int getIdCustomer() {
		return idCustomer;
	}



	public void setIdCustomer(int idCustomer) {
		this.idCustomer = idCustomer;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getFirstName() {
		return firstName;
	}



	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public String getPhone() {
		return phone;
	}



	public void setPhone(String phone) {
		this.phone = phone;
	}



	public int getIdUser() {
		return idUser;
	}



	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}


	public int getIdCategory() {
		return idCategory;
	}



	public void setIdCategory(int idCategory) {
		this.idCategory = idCategory;
	}





	// Methode toString()
	@Override
	public String toString() {
		return "Customer [idCustomer=" + idCustomer + ", name=" + name + ", firstName=" + firstName + ", email=" + email
				+ ", phone=" + phone + ", idUser=" + idUser + ", idCategory=" + idCategory + "]";
	}
}
