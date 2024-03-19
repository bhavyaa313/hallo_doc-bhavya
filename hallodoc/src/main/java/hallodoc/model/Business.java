package hallodoc.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Business {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int business_id;
	private String name;
	private String address_one;
	private String address_two;
	private String city;
	private int region_id;
	private String zip_code;
	private String phone_number;
	private String fax_number;
	private int created_by;
	private LocalDateTime created_date;
	private int modified_by;
	private LocalDateTime modified_date;
	private boolean is_deleted;
	
	public int getBusiness_id() {
		return business_id;
	}
	public void setBusiness_id(int business_id) {
		this.business_id = business_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress_one() {
		return address_one;
	}
	public void setAddress_one(String address_one) {
		this.address_one = address_one;
	}
	public String getAddress_two() {
		return address_two;
	}
	public void setAddress_two(String address_two) {
		this.address_two = address_two;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public int getRegion_id() {
		return region_id;
	}
	public void setRegion_id(int region_id) {
		this.region_id = region_id;
	}
	public String getZip_code() {
		return zip_code;
	}
	public void setZip_code(String zip_code) {
		this.zip_code = zip_code;
	}
	public String getPhone_number() {
		return phone_number;
	}
	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}
	public String getFax_number() {
		return fax_number;
	}
	public void setFax_number(String fax_number) {
		this.fax_number = fax_number;
	}
	public int getCreated_by() {
		return created_by;
	}
	public void setCreated_by(int created_by) {
		this.created_by = created_by;
	}
	public LocalDateTime getCreated_date() {
		return created_date;
	}
	public void setCreated_date(LocalDateTime created_date) {
		this.created_date = created_date;
	}
	public int getModified_by() {
		return modified_by;
	}
	public void setModified_by(int modified_by) {
		this.modified_by = modified_by;
	}
	public LocalDateTime getModified_date() {
		return modified_date;
	}
	public void setModified_date(LocalDateTime modified_date) {
		this.modified_date = modified_date;
	}
	public boolean isIs_deleted() {
		return is_deleted;
	}
	public void setIs_deleted(boolean is_deleted) {
		this.is_deleted = is_deleted;
	}
	
	public Business(int business_id, String name, String address_one, String address_two, String city, int region_id,
			String zip_code, String phone_number, String fax_number, int created_by, LocalDateTime created_date,
			int modified_by, LocalDateTime modified_date, boolean is_deleted) {
		super();
		this.business_id = business_id;
		this.name = name;
		this.address_one = address_one;
		this.address_two = address_two;
		this.city = city;
		this.region_id = region_id;
		this.zip_code = zip_code;
		this.phone_number = phone_number;
		this.fax_number = fax_number;
		this.created_by = created_by;
		this.created_date = created_date;
		this.modified_by = modified_by;
		this.modified_date = modified_date;
		this.is_deleted = is_deleted;
	}
	
	public Business() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String toString() {
		return "Business [business_id=" + business_id + ", name=" + name + ", address_one=" + address_one
				+ ", address_two=" + address_two + ", city=" + city + ", region_id=" + region_id + ", zip_code="
				+ zip_code + ", phone_number=" + phone_number + ", fax_number=" + fax_number + ", created_by="
				+ created_by + ", created_date=" + created_date + ", modified_by=" + modified_by + ", modified_date="
				+ modified_date + ", is_deleted=" + is_deleted + "]";
	}
	
}
