package hallodoc.model;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "shift_detail")
public class ShiftDetail {
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private int shift_detail_id;
private int shift_id;
private Date shift_date;
private int region_id;
private LocalTime start_time;
private LocalTime end_time;
private int status;
private boolean is_deleted;
private int modified_by;
private LocalDateTime last_running_date;
private String event_id;
public int getShift_detail_id() {
	return shift_detail_id;
}
public void setShift_detail_id(int shift_detail_id) {
	this.shift_detail_id = shift_detail_id;
}
public int getShift_id() {
	return shift_id;
}
public void setShift_id(int shift_id) {
	this.shift_id = shift_id;
}
public Date getShift_date() {
	return shift_date;
}
public void setShift_date(Date shift_date) {
	this.shift_date = shift_date;
}
public int getRegion_id() {
	return region_id;
}
public void setRegion_id(int region_id) {
	this.region_id = region_id;
}
public LocalTime getStart_time() {
	return start_time;
}
public void setStart_time(LocalTime start_time) {
	this.start_time = start_time;
}
public LocalTime getEnd_time() {
	return end_time;
}
public void setEnd_time(LocalTime end_time) {
	this.end_time = end_time;
}
public int getStatus() {
	return status;
}
public void setStatus(int status) {
	this.status = status;
}
public boolean isIs_deleted() {
	return is_deleted;
}
public void setIs_deleted(boolean is_deleted) {
	this.is_deleted = is_deleted;
}
public int getModified_by() {
	return modified_by;
}
public void setModified_by(int modified_by) {
	this.modified_by = modified_by;
}
public LocalDateTime getLast_running_date() {
	return last_running_date;
}
public void setLast_running_date(LocalDateTime last_running_date) {
	this.last_running_date = last_running_date;
}
public String getEvent_id() {
	return event_id;
}
public void setEvent_id(String event_id) {
	this.event_id = event_id;
}
public ShiftDetail(int shift_detail_id, int shift_id, Date shift_date, int region_id, LocalTime start_time,
		LocalTime end_time, int status, boolean is_deleted, int modified_by, LocalDateTime last_running_date,
		String event_id) {
	super();
	this.shift_detail_id = shift_detail_id;
	this.shift_id = shift_id;
	this.shift_date = shift_date;
	this.region_id = region_id;
	this.start_time = start_time;
	this.end_time = end_time;
	this.status = status;
	this.is_deleted = is_deleted;
	this.modified_by = modified_by;
	this.last_running_date = last_running_date;
	this.event_id = event_id;
}
public ShiftDetail() {
	super();
	// TODO Auto-generated constructor stub
}
@Override
public String toString() {
	return "ShiftDetail [shift_detail_id=" + shift_detail_id + ", shift_id=" + shift_id + ", shift_date=" + shift_date
			+ ", region_id=" + region_id + ", start_time=" + start_time + ", end_time=" + end_time + ", status="
			+ status + ", is_deleted=" + is_deleted + ", modified_by=" + modified_by + ", last_running_date="
			+ last_running_date + ", event_id=" + event_id + "]";
}
}
