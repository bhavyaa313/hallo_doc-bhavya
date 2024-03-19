package hallodoc.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "admin_region")
public class AdminRegion {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int admin_region_id;
	private int admin_id;
	private int region_id;
	
	public int getAdmin_region_id() {
		return admin_region_id;
	}
	public void setAdmin_region_id(int admin_region_id) {
		this.admin_region_id = admin_region_id;
	}
	public int getAdmin_id() {
		return admin_id;
	}
	public void setAdmin_id(int admin_id) {
		this.admin_id = admin_id;
	}
	public int getRegion_id() {
		return region_id;
	}
	public void setRegion_id(int region_id) {
		this.region_id = region_id;
	}
	
	public AdminRegion(int admin_region_id, int admin_id, int region_id) {
		super();
		this.admin_region_id = admin_region_id;
		this.admin_id = admin_id;
		this.region_id = region_id;
	}
	
	public AdminRegion() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String toString() {
		return "AdminRegion [admin_region_id=" + admin_region_id + ", admin_id=" + admin_id + ", region_id=" + region_id
				+ "]";
	}
	
}
