package hallodoc.model;

import java.time.LocalDateTime;
import java.util.jar.Attributes.Name;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Concierge {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "concierge_id")
	private int conciergeId;

	@Column(name = "concierge_name")
	private String conciergeName;
	private String address;
	private String street;
	private String city;
	private String state;
	private String email;

	private String zipcode;
	@Column(name = "created_date")
	private LocalDateTime createdDate;
	@Column(name = "modified_date")
	private LocalDateTime modifiedDate;
	@Column(name = "region_id")
	private int regionId;

	private int role_id;
//




	public Concierge(int conciergeId, String conciergeName, String address, String street, String city, String state,
			String email, String zipcode, LocalDateTime createdDate, LocalDateTime modifiedDate, int regionId,
			int role_id) {
		super();
		this.conciergeId = conciergeId;
		this.conciergeName = conciergeName;
		this.address = address;
		this.street = street;
		this.city = city;
		this.state = state;
		this.email = email;
		this.zipcode = zipcode;
		this.createdDate = createdDate;
		this.modifiedDate = modifiedDate;
		this.regionId = regionId;
		this.role_id = role_id;
		
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getConciergeId() {
		return conciergeId;
	}

	public void setConciergeId(int conciergeId) {
		this.conciergeId = conciergeId;
	}



	public String getConciergeName() {
		return conciergeName;
	}

	public void setConciergeName(String conciergeName) {
		this.conciergeName = conciergeName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
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

	public LocalDateTime getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(LocalDateTime createdDate) {
		this.createdDate = createdDate;
	}

	public int getRegionId() {
		return regionId;
	}

	public void setRegionId(int regionId) {
		this.regionId = regionId;
	}

	

	public int getRole_id() {
		return role_id;
	}

	public void setRole_id(int role_id) {
		this.role_id = role_id;
	}
	
	

	public LocalDateTime getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(LocalDateTime modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	public Concierge() {
		super();
		// TODO Auto-generated constructor stub
	}

}
