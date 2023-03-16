package fr.fms.entities;

public class Role {

	// Attributs
	private String login;
	private String password;
	private boolean admin;


	// Constructeur

	public Role(String login, String password, boolean admin) {
		super();
		this.login = login;
		this.password = password;
		this.admin = admin;
	}



	// Getters Setters

	public String getLogin() {
		return login;
	}


	public void setLogin(String login) {
		this.login = login;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public boolean isAdmin() {
		return admin;
	}


	public void setAdmin(boolean admin) {
		this.admin = admin;
	}



	// Methode toString()

	@Override
	public String toString() {
		return "Role [login=" + login + ", password=" + password + ", admin=" + admin + "]";
	}


}
