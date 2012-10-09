package registration;

import java.io.Serializable;

public class RegCostBean implements Serializable {
	
	double totalCost;
	double individualCost;
	double hotelFee;
	double parkingFee;
	String welcomeName;
	String email;
	String [] courses;
	String registrationType;
	
	public RegCostBean(){
		//no argument constructor for java bean
	}

	public synchronized double getTotalCost() {
		return totalCost;
	}

	public synchronized void setTotalCost(double totalCost) {
		this.totalCost = totalCost;
	}

	public synchronized double getIndividualCost() {
		return individualCost;
	}

	public synchronized void setIndividualCost(double individualCost) {
		this.individualCost = individualCost;
	}

	public synchronized double getHotelFee() {
		return hotelFee;
	}

	public synchronized void setHotelFee(double hotelFee) {
		this.hotelFee = hotelFee;
	}

	public synchronized double getParkingFee() {
		return parkingFee;
	}

	public synchronized void setParkingFee(double parkingFee) {
		this.parkingFee = parkingFee;
	}

	public synchronized String getWelcomeName() {
		return welcomeName;
	}

	public synchronized void setWelcomeName(String welcomeName) {
		this.welcomeName = welcomeName;
	}

	public synchronized String getEmail() {
		return email;
	}

	public synchronized void setEmail(String email) {
		this.email = email;
	}

	public synchronized String[] getCourses() {
		return courses;
	}

	public synchronized void setCourses(String[] courses) {
		this.courses = courses;
	}

	public synchronized String getRegistrationType() {
		return registrationType;
	}

	public synchronized void setRegistrationType(String registrationType) {
		this.registrationType = registrationType;
	}

	
	
}
