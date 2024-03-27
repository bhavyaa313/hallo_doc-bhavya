package hallodoc.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.Date;

import javax.management.loading.PrivateClassLoader;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.web.multipart.commons.CommonsMultipartFile;



public class PatientInfoDto {

	public CommonsMultipartFile file2;
	
private int id;
	
private String sympton;
	
	
	private String firstName;
	
	
	private String lastName;
	
	private String DOB;
	
	private String email;
	
	private String password;
	
	private String mobile;
	
	private String street;
	
	private String city;
	
	private String state;
	
	private int physicianId;
	
	private int status;
	
private LocalDateTime created_date = LocalDateTime.now();   
private String username;
	    
	
/*
 * LocalDate currentDate = LocalDate.parse(DOB); private Month month =
 * currentDate.getMonth(); private int year = currentDate.getYear(); private int
 * date = currentDate.getDayOfMonth();
 */
	
	private String zipcode;
	
	private String room;
	
	private String file;
	
	private int admin_id;
	private int physician_id;
	private CommonsMultipartFile file_name;
	private int created_by;

	private int declined_by;
	public String getSympton() {
		return sympton;
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
	
	
	
	
	public int getAdmin_id() {
		return admin_id;
	}

	public void setAdmin_id(int admin_id) {
		this.admin_id = admin_id;
	}

	public int getPhysician_id() {
		return physician_id;
	}

	public void setPhysician_id(int physician_id) {
		this.physician_id = physician_id;
	}

	
	public CommonsMultipartFile getFile_name() {
		return file_name;
	}

	public void setFile_name(CommonsMultipartFile file_name) {
		this.file_name = file_name;
	}

	public int getDeclined_by() {
		return declined_by;
	}

	public void setDeclined_by(int declined_by) {
		this.declined_by = declined_by;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	
	
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public String getRoom() {
		return room;
	}

	public void setRoom(String room) {
		this.room = room;
	}

	public String getFile() {
		return file;
	}

	public void setFile(String file) {
		this.file = file;
	}

	public int getCreated_by() {
		return created_by;
	}

	public void setCreated_by(int created_by) {
		this.created_by = created_by;
	}


	
	



	
	public PatientInfoDto(int id, String sympton, String firstName, String lastName, String dOB, String email,
			String password, String mobile, String street, String city, String state, int physicianId, int status,
			LocalDateTime created_date, String username, String zipcode, String room, String file, int admin_id,
			int physician_id, CommonsMultipartFile file_name, int created_by, int declined_by) {
		super();
		this.id = id;
		this.sympton = sympton;
		this.firstName = firstName;
		this.lastName = lastName;
		DOB = dOB;
		this.email = email;
		this.password = password;
		this.mobile = mobile;
		this.street = street;
		this.city = city;
		this.state = state;
		this.physicianId = physicianId;
		this.status = status;
		this.created_date = created_date;
		this.username = username;
		this.zipcode = zipcode;
		this.room = room;
		this.file = file;
		this.admin_id = admin_id;
		this.physician_id = physician_id;
		this.file_name = file_name;
		this.created_by = created_by;
		this.declined_by = declined_by;
	}

	public PatientInfoDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	
}

	


	
	
	

	
	
	

