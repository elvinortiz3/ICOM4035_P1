package theSystem;

public class Order {

	private int arrive;
	private int serviceTime;
	private int ID;
	private double cost;
	private int levelOfPatience;

	

	public Order(int arrive, int ID,int serviceTime, double cost, int levelOfPatients) {
		this.arrive = arrive;
		this.serviceTime = serviceTime;
		this.ID = ID;
		this.cost=cost;
		this.levelOfPatience = levelOfPatients;
	}

	public int getArrive() {
		return arrive;
	}

	public void setArrive(int arrive) {
		this.arrive = arrive;
	}

	public int getServiceTime() {
		return serviceTime;
	}

	public void setServiceTime(int serviceTime) {
		this.serviceTime = serviceTime;
	}
	
	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	public int getLevelOfPatience() {
		return levelOfPatience;
	}

	public void setLevelOfPatience(int levelOfPatients) {
		this.levelOfPatience = levelOfPatients;
	}
	


}
