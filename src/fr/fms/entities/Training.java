package fr.fms.entities;

public class Training {

	// Attributs	
	private int id; 
	private String trainingName;
	private String description;
	private int durationTraining;
	private  double price;
	private String presentialorRemote;
	private int category;
	private int quantity=1;



	public static final int MAX_STRING_LENGTH = 20;

	// Constructor

	public Training(int id, String trainingName, String description, int durationTraining, double price,
			String presentialorRemote, int category) {
		super();
		this.id = id;
		this.trainingName = trainingName;
		this.description = description;
		this.durationTraining = durationTraining;
		this.price = price;
		this.presentialorRemote = presentialorRemote;
		this.category = category;

	}



	public Training(int id, String trainingName, String description, int durationTraining, double price,
			String presentialorRemote) {
		super();
		this.id = id;
		this.trainingName = trainingName;
		this.description = description;
		this.durationTraining = durationTraining;
		this.price = price;
		this.presentialorRemote = presentialorRemote;
	}

	public Training(String trainingName, String description, int durationTraining, double price,
			String presentialorRemote) {
		super();
		this.trainingName = trainingName;
		this.description = description;
		this.durationTraining = durationTraining;
		this.price = price;
		this.presentialorRemote = presentialorRemote;
	}

	// Getters Setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTrainingName() {
		return trainingName;
	}

	public void setTrainingName(String trainingName) {
		this.trainingName = trainingName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getDurationTraining() {
		return durationTraining;
	}

	public void setDurationTraining(int durationTraining) {
		this.durationTraining = durationTraining;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String isPresentialorRemote() {
		return presentialorRemote;
	}

	public void setPresentialorremote(String presentialorRemote) {
		this.presentialorRemote = presentialorRemote;
	}


	// Methode toString()

	@Override
	public String toString() {
		return centerString(String.valueOf(id)) + centerString(trainingName) + centerString(description) + centerString(String.valueOf(durationTraining) + centerString(String.valueOf(price)
				+ centerString(presentialorRemote)));
	}	

	public static String centerString(String str) {
		if(str.length() >= MAX_STRING_LENGTH) return str;
		String dest = "                    ";
		int deb = (MAX_STRING_LENGTH - str.length())/2 ;
		String data = new StringBuilder(dest).replace( deb, deb + str.length(), str ).toString();
		return data;

	}

	public int getQuantity() {

		return 0 ;
	}

	public void setQuantity(int i) {
		// TODO Auto-generated method stub

	}

	public int getCategory() {
		// TODO Auto-generated method stub
		return 0;
	}

	public int getPresentialorRemote() {
		// TODO Auto-generated method stub
		return 0;
	}


}
