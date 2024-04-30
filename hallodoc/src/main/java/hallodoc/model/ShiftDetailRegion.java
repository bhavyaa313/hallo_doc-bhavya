package hallodoc.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "shift_fetail_region")
public class ShiftDetailRegion {
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private int shift_detail_region_id;
private int shift_detail_id;
private int region_id;
private boolean is_deleted;
public int getShift_detail_region_id() {
	return shift_detail_region_id;
}
public void setShift_detail_region_id(int shift_detail_region_id) {
	this.shift_detail_region_id = shift_detail_region_id;
}
public int getShift_detail_id() {
	return shift_detail_id;
}
public void setShift_detail_id(int shift_detail_id) {
	this.shift_detail_id = shift_detail_id;
}
public int getRegion_id() {
	return region_id;
}
public void setRegion_id(int region_id) {
	this.region_id = region_id;
}
public boolean isIs_deleted() {
	return is_deleted;
}
public void setIs_deleted(boolean is_deleted) {
	this.is_deleted = is_deleted;
}
public ShiftDetailRegion(int shift_detail_region_id, int shift_detail_id, int region_id, boolean is_deleted) {
	super();
	this.shift_detail_region_id = shift_detail_region_id;
	this.shift_detail_id = shift_detail_id;
	this.region_id = region_id;
	this.is_deleted = is_deleted;
}
public ShiftDetailRegion() {
	super();
	// TODO Auto-generated constructor stub
}
@Override
public String toString() {
	return "ShiftDetailRegion [shift_detail_region_id=" + shift_detail_region_id + ", shift_detail_id="
			+ shift_detail_id + ", region_id=" + region_id + ", is_deleted=" + is_deleted
			+ ", getShift_detail_region_id()=" + getShift_detail_region_id() + ", getShift_detail_id()="
			+ getShift_detail_id() + ", getRegion_id()=" + getRegion_id() + ", isIs_deleted()=" + isIs_deleted()
			+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
}

}
