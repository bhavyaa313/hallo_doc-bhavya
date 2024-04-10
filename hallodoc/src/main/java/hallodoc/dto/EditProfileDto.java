package hallodoc.dto;

public class EditProfileDto {

	private String fname;
	private String lname;
	private String dob;
	private String phone;
	private String email;
	private String street;
	private String city;
	private String state;
	private String zipcode;

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

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	public EditProfileDto(String fname, String lname, String dob, String phone, String email, String street,
			String city, String state, String zipcode) {
		super();
		this.fname = fname;
		this.lname = lname;
		this.dob = dob;
		this.phone = phone;
		this.email = email;
		this.street = street;
		this.city = city;
		this.state = state;
		this.zipcode = zipcode;
	}

	public EditProfileDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	

}
