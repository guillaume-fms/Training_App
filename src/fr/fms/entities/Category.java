package fr.fms.entities;

public class Category {

	// Attributs
	private int idcategory;
	private String catname;
	private String description;


	// Constructeurs

	public Category(int idcategory, String catname, String description) {
		super();
		this.idcategory = idcategory;
		this.catname = catname;
		this.description = description;
	}

	public Category(String catname, String description) {
		super();
		this.catname = catname;
		this.description = description;
	}



	// Getters and Setters

	public int getIdcategory() {
		return idcategory;
	}

	public void setIdcategory(int idcategory) {
		this.idcategory = idcategory;
	}

	public String getCatname() {
		return catname;
	}

	public void setCatname(String catname) {
		this.catname = catname;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}



	// Methode toString()

	@Override
	public String toString() {
		return "Categorie [idcategory=" + idcategory + ", catname=" + catname + ", description=" + description + "]";
	}

}
