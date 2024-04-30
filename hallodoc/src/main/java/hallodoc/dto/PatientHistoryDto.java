package hallodoc.dto;

public class PatientHistoryDto {
	
	private int uId;
	private String fname;
	private String lname;
	private String phoneString;
	private String emailString;
	private String address;
	
	
	
	
	public int getuId() {
		return uId;
	}
	public void setuId(int uId) {
		this.uId = uId;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public String getPhoneString() {
		return phoneString;
	}
	public void setPhoneString(String phoneString) {
		this.phoneString = phoneString;
	}
	public String getEmailString() {
		return emailString;
	}
	public void setEmailString(String emailString) {
		this.emailString = emailString;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}

	
	
	public PatientHistoryDto(int uId, String fname, String lname, String phoneString, String emailString,
			String address) {
		super();
		this.uId = uId;
		this.fname = fname;
		this.lname = lname;
		this.phoneString = phoneString;
		this.emailString = emailString;
		this.address = address;
	}
	public PatientHistoryDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
