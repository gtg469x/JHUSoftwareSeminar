package registration;

public class Fees {
	
	private static double courseEmployeeFee;
	private static double courseStudentFee;
	private static double courseSpeakerFee;
	private static double courseOtherFee;
	private static double hotelFee;
	private static double parkingFee;
	
	public Fees(){
		courseEmployeeFee=850.00;
		courseStudentFee=1000.00;
		courseSpeakerFee=0.00;
		courseOtherFee=1350.00;
		hotelFee=185.00;
		parkingFee=10.00;
	}

	public static synchronized double getCourseEmployeeFee() {
		return courseEmployeeFee;
	}

	public static synchronized double getCourseStudentFee() {
		return courseStudentFee;
	}

	public static synchronized double getCourseSpeakerFee() {
		return courseSpeakerFee;
	}

	public static synchronized double getCourseOtherFee() {
		return courseOtherFee;
	}

	public synchronized double getHotelFee() {
		return hotelFee;
	}

	public synchronized double getParkingFee() {
		return parkingFee;
	}

	
	
}
