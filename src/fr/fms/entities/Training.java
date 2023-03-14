package fr.fms.entities;

public class Training {

	// Attributs	
	private int idTraining; 
	private String trainingName;
	private String description;
	private int durationTraining;
	private  double price;
	private boolean presentialorremote;


	// Constructor

	public Training(int idTraining, String trainingName, String description, int durationTraining, double price,
			boolean presentialorremote) {
		super();
		this.idTraining = idTraining;
		this.trainingName = trainingName;
		this.description = description;
		this.durationTraining = durationTraining;
		this.price = price;
		this.presentialorremote = presentialorremote;
	}

	public Training(String trainingName, String description, int durationTraining, double price,
			boolean presentialorremote) {
		super();
		this.trainingName = trainingName;
		this.description = description;
		this.durationTraining = durationTraining;
		this.price = price;
		this.presentialorremote = presentialorremote;
	}

	// Getters Setters
	public int getIdTraining() {
		return idTraining;
	}

	public void setIdTraining(int idTraining) {
		this.idTraining = idTraining;
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

	public boolean isPresentialorremote() {
		return presentialorremote;
	}

	public void setPresentialorremote(boolean presentialorremote) {
		this.presentialorremote = presentialorremote;
	}


	// Methode toString()

	@Override
	public String toString() {
		return "Training [idTraining=" + idTraining + ", trainingName=" + trainingName + ", description=" + description
				+ ", durationTraining=" + durationTraining + ", price=" + price + ", presentialorremote="
				+ presentialorremote + "]";
	}


}
