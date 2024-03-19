package hallodoc.model;

import java.util.Date;

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
		private int vendor_id;
	
		private String vendor_name;
		private int profession;
		private String fax_number;
		
		private String address;
		private String city;
		private String state;
		private String zip;
		private int region_id;
		
		private Date created_date;
	
		private Date modified_date;
		private String phone_number;
	
		private boolean is_deleted;
		private String email;
		
		private String business_contact;

		public int getVendor_id() {
			return vendor_id;
		}

		public void setVendor_id(int vendor_id) {
			this.vendor_id = vendor_id;
		}

		public String getVendor_name() {
			return vendor_name;
		}

		public void setVendor_name(String vendor_name) {
			this.vendor_name = vendor_name;
		}

		public int getProfession() {
			return profession;
		}

		public void setProfession(int profession) {
			this.profession = profession;
		}

		public String getFax_number() {
			return fax_number;
		}

		public void setFax_number(String fax_number) {
			this.fax_number = fax_number;
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

		public int getRegion_id() {
			return region_id;
		}

		public void setRegion_id(int region_id) {
			this.region_id = region_id;
		}

		public Date getCreated_date() {
			return created_date;
		}

		public void setCreated_date(Date created_date) {
			this.created_date = created_date;
		}

		public Date getModified_date() {
			return modified_date;
		}

		public void setModified_date(Date modified_date) {
			this.modified_date = modified_date;
		}

		public String getPhone_number() {
			return phone_number;
		}

		public void setPhone_number(String phone_number) {
			this.phone_number = phone_number;
		}

		public boolean isIs_deleted() {
			return is_deleted;
		}

		public void setIs_deleted(boolean is_deleted) {
			this.is_deleted = is_deleted;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public String getBusiness_contact() {
			return business_contact;
		}

		public void setBusiness_contact(String business_contact) {
			this.business_contact = business_contact;
		}

		@Override
		public String toString() {
			return "HealthProfessionals [vendor_id=" + vendor_id + ", vendor_name=" + vendor_name + ", profession="
					+ profession + ", fax_number=" + fax_number + ", address=" + address + ", city=" + city + ", state="
					+ state + ", zip=" + zip + ", region_id=" + region_id + ", created_date=" + created_date
					+ ", modified_date=" + modified_date + ", phone_number=" + phone_number + ", is_deleted="
					+ is_deleted + ", email=" + email + ", business_contact=" + business_contact + "]";
		}

		public HealthProfessionals(int vendor_id, String vendor_name, int profession, String fax_number, String address,
				String city, String state, String zip, int region_id, Date created_date, Date modified_date,
				String phone_number, boolean is_deleted, String email, String business_contact) {
			super();
			this.vendor_id = vendor_id;
			this.vendor_name = vendor_name;
			this.profession = profession;
			this.fax_number = fax_number;
			this.address = address;
			this.city = city;
			this.state = state;
			this.zip = zip;
			this.region_id = region_id;
			this.created_date = created_date;
			this.modified_date = modified_date;
			this.phone_number = phone_number;
			this.is_deleted = is_deleted;
			this.email = email;
			this.business_contact = business_contact;
		}

		public HealthProfessionals() {
			super();
			// TODO Auto-generated constructor stub
		}
	
		
		
		
}
