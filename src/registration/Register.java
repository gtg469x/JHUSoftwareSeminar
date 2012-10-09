package registration;

import java.io.Serializable;

public class Register implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private User registerUser;
	private Fees charges;
	private double totalCost;
	private double individualCourseCost;
	private String welcomeName;
	private String registrationType;
	private String email;
	RegCostBean rcb;
	
	
	public Register(String userName, String userEmail, String userStatus){
		registerUser = new User(userName, userEmail, userStatus);
		rcb = new RegCostBean();
		charges = new Fees();
		totalCost=0;
		
		setRegType();
		setWelcomeName();
		setFees();
		confirmationEmail();
		setIndividualCourseCost();
		
	}
	
	public double calculateCourseFees(String [] courses){
		int numCourses = courses.length;
		double courseCost=0;
		if(registerUser.isEmployee()){
			individualCourseCost = charges.getCourseEmployeeFee();
			courseCost=numCourses*individualCourseCost;
		}else if(registerUser.isStudent()){
			individualCourseCost=charges.getCourseStudentFee();
			courseCost=numCourses*individualCourseCost;
		}else if(registerUser.isSpeaker()){
			individualCourseCost=charges.getCourseSpeakerFee();
			courseCost=numCourses*individualCourseCost;
		}else{
			individualCourseCost=charges.getCourseOtherFee();
			courseCost=numCourses*individualCourseCost;
		}
		return courseCost;
	}
	
	public double calculateParkingFee(){
		return charges.getParkingFee();
	}
	

	public double calculateHotelFee(){
		return charges.getHotelFee();
	}
	
	public void setFees(){
		rcb.setHotelFee(charges.getHotelFee());
		rcb.setParkingFee(charges.getParkingFee());
	}
	
	public void calculateTotalFees(String [] courses, boolean hotel, boolean parking){
		if(hotel&&parking){
			totalCost = calculateHotelFee()+calculateCourseFees(courses)+calculateParkingFee();
		}else if(hotel&&!parking){
			totalCost = calculateHotelFee()+calculateCourseFees(courses);
		}else if(!hotel&&parking){
			totalCost = calculateCourseFees(courses)+calculateParkingFee();
		}else{
			totalCost=calculateCourseFees(courses);
		}
			rcb.setTotalCost(totalCost);
	}
	
	private void setRegType(){
		rcb.setRegistrationType(registerUser.getUserStatus());
	}
		
	private void confirmationEmail(){
		rcb.setEmail(registerUser.getUserEmail());
	}
	
	private void setWelcomeName(){
		rcb.setWelcomeName(registerUser.getUserName());
	}

	private void setIndividualCourseCost(){
		if(registerUser.isEmployee()){
			individualCourseCost = charges.getCourseEmployeeFee();
		}else if(registerUser.isStudent()){
			individualCourseCost=charges.getCourseStudentFee();
		}else if(registerUser.isSpeaker()){
			individualCourseCost=charges.getCourseSpeakerFee();
		}else{
			individualCourseCost=charges.getCourseOtherFee();
		}
		rcb.setIndividualCost(individualCourseCost);
	}	
	
}
