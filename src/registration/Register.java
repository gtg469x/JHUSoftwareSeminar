package registration;

public class Register {

	private User registerUser;
	private Fees charges;
	private double totalCost;
	private double individualCourseCost;
	
	public Register(String userName, String userEmail, String userStatus){
		registerUser = new User(userName, userEmail, userStatus);
		charges = new Fees();
		totalCost=0;
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
	
	public double calculateTotalFees(String [] courses, boolean hotel, boolean parking){
		if(hotel&&parking){
			totalCost = calculateHotelFee()+calculateCourseFees(courses)+calculateParkingFee();
		}else if(hotel&&!parking){
			totalCost = calculateHotelFee()+calculateCourseFees(courses);
		}else if(!hotel&&parking){
			totalCost = calculateCourseFees(courses)+calculateParkingFee();
		}
			return totalCost;
	}
	
	public String registrationType(){
		return registerUser.getUserStatus();
	}
	
	public String confirmationEmail(){
		return registerUser.getUserEmail();
	}
	
	public String welcomeName(){
		return registerUser.getUserName();
	}
	
	public double getIndividualCourseCost(){
		return this.individualCourseCost;
	}
	
	
}
