package registration;

import java.io.Serializable;
import java.util.*;

public class RegCostBean implements Serializable {
	
	double totalCost;
	double individualCost;
	double hotelFee;
	double parkingFee;
	String welcomeName;
	String email;
	List<String> courses;
	String registrationType;
	
	public RegCostBean(){
		//no argument constructor for java bean


	}

	public synchronized double getTotalCost() {
		return totalCost;
	}
	
	public synchronized void adjustCourseList(String removeCourse, List courseList){
		int index = Integer.parseInt(removeCourse);
		courses = courseList;
		System.out.println(courses.size());
/*		for(String course:courses){
			System.out.println(course);
		}
*/
		courses.remove(index);
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

	public synchronized List getCourses() {
		return courses;
	}

	public synchronized void setCourses(String[] coursesArray) {
		courses = new ArrayList();
		for(int i = 0; i< coursesArray.length; i++){
			courses.add(coursesArray[i]);
		}
	}

	public synchronized String getRegistrationType() {
		return registrationType;
	}

	public synchronized void setRegistrationType(String registrationType) {
		this.registrationType = registrationType;
	}

	
	
}
