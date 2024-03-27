package hallodoc.dto;

import java.time.LocalDateTime;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

public class FamilyInfoDto {

	
	private int id;
	
	private String sympton;
		
		
		private String firstName;
		
		
		private String lastName;
		
		private String pFirstName;
		private String plastName;
		private String pMobile;
		private String pEmail;
		
	
		private String DOB;
		
		private String email;
		
		private String password;
		
		private String mobile;
		
		private String zipcode;
		
		
		private String street;
		
		private String city;
		
		private String state;
		
		private int physicianId;
		
		private int status;
		private CommonsMultipartFile file_name;
		private int created_by;
		
		
	private LocalDateTime created_date = LocalDateTime.now();   
	private String username;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getSympton() {
		return sympton;
	}
	
	public CommonsMultipartFile getFile_name() {
		return file_name;
	}
	public void setFile_name(CommonsMultipartFile file_name) {
		this.file_name = file_name;
	}
	public int getCreated_by() {
		return created_by;
	}
	public void setCreated_by(int created_by) {
		this.created_by = created_by;
	}
	public void setSympton(String sympton) {
		this.sympton = sympton;
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
	public String getDOB() {
		return DOB;
	}
	public void setDOB(String dOB) {
		DOB = dOB;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	
	
	public String getZipcode() {
		return zipcode;
	}
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
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
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}


	
	
	
	
	
	
	
	
	public FamilyInfoDto(int id, String sympton, String firstName, String lastName, String pFirstName, String plastName,
			String pMobile, String pEmail, String dOB, String email, String password, String mobile, String zipcode,
			String street, String city, String state, int physicianId, int status, CommonsMultipartFile file_name,
			int created_by, LocalDateTime created_date, String username) {
		super();
		this.id = id;
		this.sympton = sympton;
		this.firstName = firstName;
		this.lastName = lastName;
		this.pFirstName = pFirstName;
		this.plastName = plastName;
		this.pMobile = pMobile;
		this.pEmail = pEmail;
		DOB = dOB;
		this.email = email;
		this.password = password;
		this.mobile = mobile;
		this.zipcode = zipcode;
		this.street = street;
		this.city = city;
		this.state = state;
		this.physicianId = physicianId;
		this.status = status;
		this.file_name = file_name;
		this.created_by = created_by;
		this.created_date = created_date;
		this.username = username;
	}
	public FamilyInfoDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
		    
}
