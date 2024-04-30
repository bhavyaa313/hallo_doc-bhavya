package hallodoc.model;

import java.time.LocalDateTime;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;



@Entity
@Table(name = "user")


public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="user_id")
	
	private int userID;
	
	
	
	@OneToOne 
	@JoinColumn(name = "aspnet_user_id", referencedColumnName = "id")
	private AspNetUsers aspnetUserId;
	
	@Column(name="first_name")
	private String firstName;
	
	@Column(name="last_name")
	private String lastName;
	
	private String email;
	
	private String mobile;
	
	private String street;
	
	private String city;
	
	private String state;
	

@Column(name = "region_id")
	private int regionId;
	
	private String zipcode;
	
	@Column(name="str_month")
	private String strMonth;
	
	@Column(name="int_year")
	private int intYear;
	
	@Column(name="int_date")
	private int intDate;
	
	@Column(name="created_by")
	
	private int createdBy;
	
	@Column(name="created_date")
	private LocalDateTime createdDate=LocalDateTime.now();
	
	@Column(name="modified_by")

	private int modifiedBy;
	
	@Column(name="modified_date")
	private LocalDateTime modifiedDate;
	
	private int status;
	@Column(name="is_deleted")
	private boolean isDeleted;
	
	@Column(name="is_request_with_email")
	private boolean isRequestWithEmail;
	
	
	@Column(name = "role_id")
	private int roleId;
	

	

	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	public AspNetUsers getAspnetUserId() {
		return aspnetUserId;
	}

	public void setAspnetUserId(AspNetUsers aspnetUserId) {
		this.aspnetUserId = aspnetUserId;
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

	public int getRegionId() {
		return regionId;
	}

	public void setRegionId(int regionId) {
		this.regionId = regionId;
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

	public int getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(int createdBy) {
		this.createdBy = createdBy;
	}


	public LocalDateTime getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(LocalDateTime createdDate) {
		this.createdDate = createdDate;
	}

	public int getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(int modifiedBy) {
		this.modifiedBy = modifiedBy;
	}


	public LocalDateTime getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(LocalDateTime modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public boolean isDeleted() {
		return isDeleted;
	}

	public void setDeleted(boolean isDeleted) {
		this.isDeleted = isDeleted;
	}

	public boolean isRequestWithEmail() {
		return isRequestWithEmail;
	}

	public void setRequestWithEmail(boolean isRequestWithEmail) {
		this.isRequestWithEmail = isRequestWithEmail;
	}
	


	


	public User(int userID, AspNetUsers aspnetUserId, String firstName, String lastName, String email, String mobile,
			String street, String city, String state, int regionId, String zipcode, String strMonth, int intYear,
			int intDate, int createdBy, LocalDateTime createdDate, int modifiedBy, LocalDateTime modifiedDate,
			int status, boolean isDeleted, boolean isRequestWithEmail, int roleId) {
		super();
		this.userID = userID;
		this.aspnetUserId = aspnetUserId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.mobile = mobile;
		this.street = street;
		this.city = city;
		this.state = state;
		this.regionId = regionId;
		this.zipcode = zipcode;
		this.strMonth = strMonth;
		this.intYear = intYear;
		this.intDate = intDate;
		this.createdBy = createdBy;
		this.createdDate = createdDate;
		this.modifiedBy = modifiedBy;
		this.modifiedDate = modifiedDate;
		this.status = status;
		this.isDeleted = isDeleted;
		this.isRequestWithEmail = isRequestWithEmail;
		this.roleId = roleId;
	}

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}


		
}
