package hallodoc.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "physician_region")
public class PhysicianRegion {

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int physician_region_id;
	private int physician_id;
	private int region_id;
	public int getPhysician_region_id() {
		return physician_region_id;
	}
	public void setPhysician_region_id(int physician_region_id) {
		this.physician_region_id = physician_region_id;
	}
	public int getPhysician_id() {
		return physician_id;
	}
	public void setPhysician_id(int physician_id) {
		this.physician_id = physician_id;
	}
	public int getRegion_id() {
		return region_id;
	}
	public void setRegion_id(int region_id) {
		this.region_id = region_id;
	}
	@Override
	public String toString() {
		return "PhysicianRegion [physician_region_id=" + physician_region_id + ", physician_id=" + physician_id
				+ ", region_id=" + region_id + "]";
	}
	public PhysicianRegion(int physician_region_id, int physician_id, int region_id) {
		super();
		this.physician_region_id = physician_region_id;
		this.physician_id = physician_id;
		this.region_id = region_id;
	}
	public PhysicianRegion() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
}
