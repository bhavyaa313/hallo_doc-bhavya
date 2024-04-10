package hallodoc.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Business {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "business_id")
	private int businessId;
	
	private String name;
	
	@Column(name = "address_one")
	private String addressOne;
	
	@Column(name = "address_two")
	private String addressTwo;
	
	private String city;
	
	
	private int regionId;
	
	@Column(name = "zip_code")
	private String zipCode;
	
	@Column(name = "phone_number")
	private String phoneNumber;
	
	@Column(name = "fax_number")
	private String faxNumber;
	
	@ManyToOne
	@JoinColumn(name = "created_by")
	private AspNetUsers createdBy;
	
	@Column(name = "created_date")
	private LocalDateTime createdDate;
	
	@ManyToOne
	@JoinColumn(name = "modified_by")
	private AspNetUsers modifiedBy;
	
	@Column(name = "modified_date")
	private LocalDateTime modifiedDate;
	
	@Column(name = "is_deleted")
	private boolean isDeleted;
	
	private String email;

	public int getBusinessId() {
		return businessId;
	}

	public void setBusinessId(int businessId) {
		this.businessId = businessId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress_one() {
		return addressOne;
	}

	public void setAddress_one(String address_one) {
		this.addressOne = address_one;
	}

	public String getAddressTwo() {
		return addressTwo;
	}

	public void setAddressTwo(String addressTwo) {
		this.addressTwo = addressTwo;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public int getRegionId() {
		return regionId;
	}

	public void setRegionId (int regionId) {
		this.regionId = regionId;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getFaxNumber() {
		return faxNumber;
	}

	public void setFaxNumber(String faxNumber) {
		this.faxNumber = faxNumber;
	}

	public AspNetUsers getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(AspNetUsers createdBy) {
		this.createdBy = createdBy;
	}

	public LocalDateTime getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(LocalDateTime createdDate) {
		this.createdDate = createdDate;
	}

	public AspNetUsers getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(AspNetUsers modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	public LocalDateTime getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(LocalDateTime modifiedDate) {
		this.modifiedDate = modifiedDate;
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

	public Business(int businessId, String name, String addressOne, String addressTwo, String city, int regionId,
			String zipCode, String phoneNumber, String faxNumber, AspNetUsers createdBy, LocalDateTime createdDate,
			AspNetUsers modifiedBy, LocalDateTime modifiedDate, boolean isDeleted, String email) {
		super();
		this.businessId = businessId;
		this.name = name;
		this.addressOne = addressOne;
		this.addressTwo = addressTwo;
		this.city = city;
		this.regionId = regionId;
		this.zipCode = zipCode;
		this.phoneNumber = phoneNumber;
		this.faxNumber = faxNumber;
		this.createdBy = createdBy;
		this.createdDate = createdDate;
		this.modifiedBy = modifiedBy;
		this.modifiedDate = modifiedDate;
		this.isDeleted = isDeleted;
		this.email = email;
	}

	public Business() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
	
	
	
}
