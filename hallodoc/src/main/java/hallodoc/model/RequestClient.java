package hallodoc.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.ManyToAny;

@Entity
@Table(name = "request_client")
public class RequestClient {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "request_client_id")
	private int requestClientId;
	
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "request_id")

	private Request requestId;
	
	@Column(name = "first_name")
	private String firstName;
	
	@Column(name = "last_name")
	private String lastName;
	
	@Column(name = "phone_number")
	private String phoneNumber;
	
	private String location;
	
	private String address;
	
	
	private int regionId;
	
	@Column(name = "noti_mobile")
	private String notiMobile;
	
	@Column(name = "noti_email")
	private String notiEmail;
	
	private String notes;
	
	private String email;
	
	@Column(name = "str_month")
	private String strMonth;
	
	@Column(name = "int_year")
	private int intYear;
	
	@Column(name = "int_date")
	private int intDate;
	
	private String street;
	
	private String city;
	
	private String state;
	
	private String zipcode;
	
	private float latitude;
	
	private float longitude;

	

	public int getRequestClientId() {
		return requestClientId;
	}



	public void setRequestClientId(int requestClientId) {
		this.requestClientId = requestClientId;
	}



	public Request getRequestId() {
		return requestId;
	}



	public void setRequestId(Request requestId) {
		this.requestId = requestId;
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



	public String getPhoneNumber() {
		return phoneNumber;
	}



	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}



	public String getLocation() {
		return location;
	}



	public void setLocation(String location) {
		this.location = location;
	}



	public String getAddress() {
		return address;
	}



	public void setAddress(String address) {
		this.address = address;
	}



	public int getRegionId() {
		return regionId;
	}



	public void setRegionId(int regionId) {
		this.regionId = regionId;
	}



	public String getNotiMobile() {
		return notiMobile;
	}



	public void setNotiMobile(String notiMobile) {
		this.notiMobile = notiMobile;
	}



	public String getNotiEmail() {
		return notiEmail;
	}



	public void setNotiEmail(String notiEmail) {
		this.notiEmail = notiEmail;
	}



	public String getNotes() {
		return notes;
	}



	public void setNotes(String notes) {
		this.notes = notes;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public String getStrMonth() {
		return strMonth;
	}



	public void setStrMonth(String strMonth) {
		this.strMonth = strMonth;
	}



	public int getIntYear() {
		return intYear;
	}



	public void setIntYear(int intYear) {
		this.intYear = intYear;
	}



	public int getIntDate() {
		return intDate;
	}



	public void setIntDate(int intDate) {
		this.intDate = intDate;
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



	public float getLatitude() {
		return latitude;
	}



	public void setLatitude(float latitude) {
		this.latitude = latitude;
	}



	public float getLongitude() {
		return longitude;
	}



	public void setLongitude(float longitude) {
		this.longitude = longitude;
	}



	public RequestClient(int requestClientId, Request requestId, String firstName, String lastName, String phoneNumber,
			String location, String address, int regionId, String notiMobile, String notiEmail, String notes,
			String email, String strMonth, int intYear, int intDate, String street, String city, String state,
			String zipcode, float latitude, float longitude) {
		super();
		this.requestClientId = requestClientId;
		this.requestId = requestId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNumber = phoneNumber;
		this.location = location;
		this.address = address;
		this.regionId = regionId;
		this.notiMobile = notiMobile;
		this.notiEmail = notiEmail;
		this.notes = notes;
		this.email = email;
		this.strMonth = strMonth;
		this.intYear = intYear;
		this.intDate = intDate;
		this.street = street;
		this.city = city;
		this.state = state;
		this.zipcode = zipcode;
		this.latitude = latitude;
		this.longitude = longitude;
	}



	public RequestClient() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
