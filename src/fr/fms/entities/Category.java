package fr.fms.entities;

public class Category {

	// Attributs
	private int id;
	private String catname;
	private String description;


	// Constructeurs

	public Category(int id, String catname, String description) {
		super();
		this.id = id;
		this.catname = catname;
		this.description = description;
	}

	public Category(String catname, String description) {
		super();
		this.catname = catname;
		this.description = description;
	}



	// Getters and Setters

	public int getId() {
		return id;
	}

	public void setIdcategory(int id) {
		this.id = id;
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
		return centerString(String.valueOf(id)) + centerString(catname) + centerString(description);
	}

	public static String centerString(String str) {
		if(str.length() >= 20) return str;
		String dest = "                                        ";
		int deb = (20 - str.length())/2 ;
		String data = new StringBuilder(dest).replace( deb, deb + str.length(), str ).toString();
		return data;
	}

	public Object getName() {
		// TODO Auto-generated method stub
		return null;
	}

	
}
