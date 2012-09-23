package registration;

public class User {

	private String userName;
	private String userEmail;
	private String userStatus;
	
	public User(String userName, String userEmail, String userStatus){
		setUserName(userName);
		setUserEmail(userEmail);
		setUserStatus(userStatus);
	}
	
	public synchronized String getUserName() {
		return userName;
	}
	public synchronized void setUserName(String userName) {
		this.userName = userName;
	}
	public synchronized String getUserEmail() {
		return userEmail;
	}
	public synchronized void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public synchronized String getUserStatus() {
		return userStatus;
	}
	public synchronized void setUserStatus(String userStatus) {
		this.userStatus = userStatus;
	}
	
	public synchronized boolean isEmployee(){
		if(userStatus=="JHU Employee"){
			return true;
		}else{
			return false;
		}
	}
	
	public synchronized boolean isStudent(){
		if(userStatus=="JHU Student"){
			return true;
		}else{
			return false;
		}
	}
	
	public synchronized boolean isSpeaker(){
		if(userStatus=="Speaker"){
			return true;
		}else{
			return false;
		}
	}
	
	public synchronized boolean isOther(){
		if(userStatus=="Other"){
			return true;
		}else{
			return false;
		}
	}
	
}
