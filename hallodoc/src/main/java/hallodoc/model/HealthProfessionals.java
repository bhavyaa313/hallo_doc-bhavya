package hallodoc.model;

import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "health_professionals")
public class HealthProfessionals {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)

	@Column(name = "vendor_id")
	private int vendorId;
	@Column(name = "vendor_name")
	private String vendorName;
	private int profession;
	@Column(name = "fax_number")
	private String faxNumber;

	private String address;
	private String city;
	private String state;
	private String zip;

	@Column(name = "region_id")
	private int regionId;

	@Column(name = "created_date")
	private LocalDateTime createdDate;

	@Column(name = "modified_date")
	private LocalDateTime modifiedDate;

	@Column(name = "phone_number")
	private String phoneNumber;

	@Column(name = "is_deleted")
	private boolean isDeleted;
	private String email;

	@Column(name = "business_contact")
	private String businessContact;

	public int getVendorId() {
		return vendorId;
	}

	public void setVendorId(int vendorId) {
		this.vendorId = vendorId;
	}

	public String getVendorName() {
		return vendorName;
	}

	public void setVendorName(String vendorName) {
		this.vendorName = vendorName;
	}

	public int getProfession() {
		return profession;
	}

	public void setProfession(int profession) {
		this.profession = profession;
	}

	public String getFaxNumber() {
		return faxNumber;
	}

	public void setFaxNumber(String faxNumber) {
		this.faxNumber = faxNumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
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

	public int getRegionId() {
		return regionId;
	}

	public void setRegionId(int regionId) {
		this.regionId = regionId;
	}

	public LocalDateTime getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(LocalDateTime createdDate) {
		this.createdDate = createdDate;
	}

	public LocalDateTime getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(LocalDateTime modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public boolean isDeleted() {
		return isDeleted;
	}

	public void setDeleted(boolean isDeleted) {
		this.isDeleted = isDeleted;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getBusinessContact() {
		return businessContact;
	}

	public void setBusinessContact(String businessContact) {
		this.businessContact = businessContact;
	}
	
	

	public HealthProfessionals(int vendorId, String vendorName, int profession, String faxNumber, String address,
			String city, String state, String zip, int regionId, LocalDateTime createdDate, LocalDateTime modifiedDate,
			String phoneNumber, boolean isDeleted, String email, String businessContact) {
		super();
		this.vendorId = vendorId;
		this.vendorName = vendorName;
		this.profession = profession;
		this.faxNumber = faxNumber;
		this.address = address;
		this.city = city;
		this.state = state;
		this.zip = zip;
		this.regionId = regionId;
		this.createdDate = createdDate;
		this.modifiedDate = modifiedDate;
		this.phoneNumber = phoneNumber;
		this.isDeleted = isDeleted;
		this.email = email;
		this.businessContact = businessContact;
	}

	public HealthProfessionals() {
		super();
		// TODO Auto-generated constructor stub
	}

}
