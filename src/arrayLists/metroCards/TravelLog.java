package arrayLists.metroCards;

public class TravelLog {
	
	private String inStation;
	private String outStation;
	private double fare;
	private double balanceafterTravel;
	
	public double getBalanceafterTravel() {
		return balanceafterTravel;
	}
	public void setBalanceafterTravel(double balanceafterTravel) {
		this.balanceafterTravel = balanceafterTravel;
	}
	
	public TravelLog(String inStation, String outStation, double fare, double balanceafterTravel) {
		super();
		this.inStation = inStation;
		this.outStation = outStation;
		this.fare = fare;
		this.balanceafterTravel = balanceafterTravel;
	}
	public String getInStation() {
		return inStation;
	}
	public void setInStation(String inStation) {
		this.inStation = inStation;
	}
	public String getOutStation() {
		return outStation;
	}
	public void setOutStation(String outStation) {
		this.outStation = outStation;
	}
	public double getFare() {
		return fare;
	}
	public void setFare(double fare) {
		this.fare = fare;
	}

}
