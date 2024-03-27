package hallodoc.dto;

import java.time.LocalDateTime;

public class BusinessDto {
	
	
	

	
	
	private String firstName;
	
	
	private String lastName;
	
	private String businessName;
	
	private String pFirstName;
	private String plastName;
	private String pMobile;
	private String pEmail;
	
	private String address1;
	
	private String address2;

	private String DOB;
	
	private String email;
	

	
	private String mobile;
	
	private String zipcode;
	
	
	
	private String street;
	
	private String city;
	
	private String state;
	
	private int physicianId;
	
	private int status;

	private LocalDateTime created_date = LocalDateTime.now();

	public BusinessDto(String firstName, String lastName, String businessName, String pFirstName, String plastName,
			String pMobile, String pEmail, String address1, String address2, String dOB, String email, String mobile,
			String zipcode, String street, String city, String state, int physicianId, int status,
			LocalDateTime created_date) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.businessName = businessName;
		this.pFirstName = pFirstName;
		this.plastName = plastName;
		this.pMobile = pMobile;
		this.pEmail = pEmail;
		this.address1 = address1;
		this.address2 = address2;
		DOB = dOB;
		this.email = email;
		this.mobile = mobile;
		this.zipcode = zipcode;
		this.street = street;
		this.city = city;
		this.state = state;
		this.physicianId = physicianId;
		this.status = status;
		this.created_date = created_date;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getBusinessName() {
		return businessName;
	}

	public void setBusinessName(String businessName) {
		this.businessName = businessName;
	}

	public String getpFirstName() {
		return pFirstName;
	}

	public void setpFirstName(String pFirstName) {
		this.pFirstName = pFirstName;
	}

	public String getPlastName() {
		return plastName;
	}

	public void setPlastName(String plastName) {
		this.plastName = plastName;
	}

	public String getpMobile() {
		return pMobile;
	}

	public void setpMobile(String pMobile) {
		this.pMobile = pMobile;
	}

	public String getpEmail() {
		return pEmail;
	}

	public void setpEmail(String pEmail) {
		this.pEmail = pEmail;
	}

	public String getAddress1() {
		return address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	public String getAddress2() {
		return address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public String getDOB() {
		return DOB;
	}

	public void setDOB(String dOB) {
		DOB = dOB;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public int getPhysicianId() {
		return physicianId;
	}

	public void setPhysicianId(int physicianId) {
		this.physicianId = physicianId;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public LocalDateTime getCreated_date() {
		return created_date;
	}

	public void setCreated_date(LocalDateTime created_date) {
		this.created_date = created_date;
	}

	public BusinessDto() {
		super();
		// TODO Auto-generated constructor stub
	} 
	
	

}
