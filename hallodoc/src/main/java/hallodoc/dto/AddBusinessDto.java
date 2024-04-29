package hallodoc.dto;

public class AddBusinessDto {
	
	private String name;
	private String profession;
	private String fax;
	private String phone;
	private String email;
	private  String bcontact;
	private String street;
	private String city;
	private String state;
	private String zip;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getProfession() {
		return profession;
	}
	public void setProfession(String profession) {
		this.profession = profession;
	}
	public String getFax() {
		return fax;
	}
	public void setFax(String fax) {
		this.fax = fax;
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
	public String getBcontact() {
		return bcontact;
	}
	public void setBcontact(String bcontact) {
		this.bcontact = bcontact;
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
	public String getZip() {
		return zip;
	}
	public void setZip(String zip) {
		this.zip = zip;
	}
	public AddBusinessDto(String name, String profession, String fax, String phone, String email, String bcontact,
			String street, String city, String state, String zip) {
		super();
		this.name = name;
		this.profession = profession;
		this.fax = fax;
		this.phone = phone;
		this.email = email;
		this.bcontact = bcontact;
		this.street = street;
		this.city = city;
		this.state = state;
		this.zip = zip;
	}
	
	
	
	
	

}
