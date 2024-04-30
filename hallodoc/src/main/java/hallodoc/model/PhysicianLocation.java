package hallodoc.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "physician_location")
public class PhysicianLocation {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private String location_id;
	private int physician_id;
	private float latitude;
	private float longitude;
	private Date created_date;
	private String physician_name;
	private String address;
	public String getLocation_id() {
		return location_id;
	}
	public void setLocation_id(String location_id) {
		this.location_id = location_id;
	}
	public int getPhysician_id() {
		return physician_id;
	}
	public void setPhysician_id(int physician_id) {
		this.physician_id = physician_id;
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
	public Date getCreated_date() {
		return created_date;
	}
	public void setCreated_date(Date created_date) {
		this.created_date = created_date;
	}
	public String getPhysician_name() {
		return physician_name;
	}
	public void setPhysician_name(String physician_name) {
		this.physician_name = physician_name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "PhysicianLocation [location_id=" + location_id + ", physician_id=" + physician_id + ", latitude="
				+ latitude + ", longitude=" + longitude + ", created_date=" + created_date + ", physician_name="
				+ physician_name + ", address=" + address + "]";
	}
	public PhysicianLocation(String location_id, int physician_id, float latitude, float longitude, Date created_date,
			String physician_name, String address) {
		super();
		this.location_id = location_id;
		this.physician_id = physician_id;
		this.latitude = latitude;
		this.longitude = longitude;
		this.created_date = created_date;
		this.physician_name = physician_name;
		this.address = address;
	}
	public PhysicianLocation() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	

	
}
