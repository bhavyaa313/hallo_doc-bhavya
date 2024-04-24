package hallodoc.dto;

public class CloseCaseDto {
	
	private String notes;
	private String firstName;
	private String lastName;
	private String dob;
	private String phone;
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
	public CloseCaseDto(String notes, String firstName, String lastName, String dob, String phone) {
		super();
		this.notes = notes;
		this.firstName = firstName;
		this.lastName = lastName;
		this.dob = dob;
		this.phone = phone;
	}
	public CloseCaseDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	

}
