package hallodoc.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "admin")
public class Admin {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="admin_id")
	private int adminId;
	
	@Column(name="aspnet_userid")
	private int aspnetUserId;
	
	@Column(name="first_name")
	private String firsName;
	
	@Column(name="last_name")
	private String lastName;
	
	@Column(name="address_one")
	private String addressOne;
	
	@Column(name="address_two")
	private String addressTwo;
	
	@Column(name="city")
	private String city;
	
	@Column(name="region_id")
	private int regionId;
	
	@Column(name="zip")
	private String zip;
	
	@Column(name="alt_phone")
	private String altPhone;
	
	@Column(name="created_by")
	private int createdBy;
	
	@Column(name="created_date")
	private Date createdDate;
	
	@Column(name="modified_by")
	private int modifiedBy;
	
	@Column(name="modified_date")
	private Date modifiedDate;
	
	@Column(name="is_deleted")
	private boolean isDeleted;
	
	@Column(name="role_id")
	private int roleId;

	public int getAdminId() {
		return adminId;
	}

	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}

	public int getAspnetUserId() {
		return aspnetUserId;
	}

	public void setAspnetUserId(int aspnetUserId) {
		this.aspnetUserId = aspnetUserId;
	}

	public String getFirsName() {
		return firsName;
	}

	public void setFirsName(String firsName) {
		this.firsName = firsName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getAddressOne() {
		return addressOne;
	}

	public void setAddressOne(String addressOne) {
		this.addressOne = addressOne;
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

	public void setRegionId(int regionId) {
		this.regionId = regionId;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public String getAltPhone() {
		return altPhone;
	}

	public void setAltPhone(String altPhone) {
		this.altPhone = altPhone;
	}

	public int getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(int createdBy) {
		this.createdBy = createdBy;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public int getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(int modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	public Date getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	public boolean isDeleted() {
		return isDeleted;
	}

	public void setDeleted(boolean isDeleted) {
		this.isDeleted = isDeleted;
	}

	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	public Admin(int adminId, int aspnetUserId, String firsName, String lastName, String addressOne, String addressTwo,
			String city, int regionId, String zip, String altPhone, int createdBy, Date createdDate, int modifiedBy,
			Date modifiedDate, boolean isDeleted, int roleId) {
		super();
		this.adminId = adminId;
		this.aspnetUserId = aspnetUserId;
		this.firsName = firsName;
		this.lastName = lastName;
		this.addressOne = addressOne;
		this.addressTwo = addressTwo;
		this.city = city;
		this.regionId = regionId;
		this.zip = zip;
		this.altPhone = altPhone;
		this.createdBy = createdBy;
		this.createdDate = createdDate;
		this.modifiedBy = modifiedBy;
		this.modifiedDate = modifiedDate;
		this.isDeleted = isDeleted;
		this.roleId = roleId;
	}

	public Admin() {
		super();
		// TODO Auto-generated constructor stub
	}	
	
	
	
	
}
