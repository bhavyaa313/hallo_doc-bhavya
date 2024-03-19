package hallodoc.model;

import javax.persistence.Entity;


public class Users {
	
	private String UserEmail;
	private String UserPassword;
	public String getUserEmail() {
		return UserEmail;
	}
	public void setUserEmail(String userEmail) {
		UserEmail = userEmail;
	}
	public String getUserPassword() {
		return UserPassword;
	}
	public void setUserPassword(String userPassword) {
		UserPassword = userPassword;
	}
	@Override
	public String toString() {
		return "User [UserEmail=" + UserEmail + ", UserPassword=" + UserPassword + "]";
	}
	
	

	
	
	
}
