package hallodoc.dto;

public class CreateNewRequestDto {
	
	private String notes;
	
	private String firstName;
	
	
	private String lastName;
	
	private String DOB;
	
	private String email;
	
	
	
	private String mobile;
	
	private String street;
	
	private String city;
	
	private String state;
	
	private String zipcode;
	
	private String adminNotes;

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
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

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public String getAdminNotes() {
		return adminNotes;
	}

	public void setAdminNotes(String adminNotes) {
		this.adminNotes = adminNotes;
	}

	public CreateNewRequestDto(String notes, String firstName, String lastName, String dOB, String email, String mobile,
			String street, String city, String state, String zipcode, String adminNotes) {
		super();
		this.notes = notes;
		this.firstName = firstName;
		this.lastName = lastName;
		DOB = dOB;
		this.email = email;
		this.mobile = mobile;
		this.street = street;
		this.city = city;
		this.state = state;
		this.zipcode = zipcode;
		this.adminNotes = adminNotes;
	}

	public CreateNewRequestDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
	
}