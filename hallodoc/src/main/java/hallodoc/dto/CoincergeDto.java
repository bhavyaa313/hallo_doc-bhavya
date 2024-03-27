package hallodoc.dto;

import java.time.LocalDateTime;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

public class CoincergeDto {

	
	private int id;
	

		
		
		private String firstName;
		
		
		private String lastName;
		
		private String pFirstName;
		private String plastName;
		private String pMobile;
		private String pEmail;
		
		private String address;
	
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
		private CommonsMultipartFile file_name;
		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
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

		
		
		public CommonsMultipartFile getFile_name() {
			return file_name;
		}

		public void setFile_name(CommonsMultipartFile file_name) {
			this.file_name = file_name;
		}

		public LocalDateTime getCreated_date() {
			return created_date;
		}

		public void setCreated_date(LocalDateTime created_date) {
			this.created_date = created_date;
		}

		public String getpEmail() {
			return pEmail;
		}

		public void setpEmail(String pEmail) {
			this.pEmail = pEmail;
		}

		public String getAddress() {
			return address;
		}

		public void setAddress(String address) {
			this.address = address;
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

		
		
	
		
		
		public CoincergeDto(int id, String firstName, String lastName, String pFirstName, String plastName,
				String pMobile, String pEmail, String address, String dOB, String email, String mobile, String zipcode,
				String street, String city, String state, int physicianId, int status, LocalDateTime created_date,
				CommonsMultipartFile file_name) {
			super();
			this.id = id;
			this.firstName = firstName;
			this.lastName = lastName;
			this.pFirstName = pFirstName;
			this.plastName = plastName;
			this.pMobile = pMobile;
			this.pEmail = pEmail;
			this.address = address;
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
			this.file_name = file_name;
		}

		public CoincergeDto() {
			super();
			// TODO Auto-generated constructor stub
		}
		
		
		
	
	
}
