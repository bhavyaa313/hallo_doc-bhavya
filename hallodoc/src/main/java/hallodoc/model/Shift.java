 package hallodoc.model;

import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "shift")
public class Shift {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int shift_id;
	private int physician_id;
	private Date state_date;
	private boolean is_repeat;
	private String week_days;
	private int repeat_upto;
	private int created_by;
	private LocalDateTime date_time;
	public Shift() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Shift(int shift_id, int physician_id, Date state_date, boolean is_repeat, String week_days, int repeat_upto,
			int created_by, LocalDateTime date_time) {
		super();
		this.shift_id = shift_id;
		this.physician_id = physician_id;
		this.state_date = state_date;
		this.is_repeat = is_repeat;
		this.week_days = week_days;
		this.repeat_upto = repeat_upto;
		this.created_by = created_by;
		this.date_time = date_time;
	}
	public int getShift_id() {
		return shift_id;
	}
	public void setShift_id(int shift_id) {
		this.shift_id = shift_id;
	}
	public int getPhysician_id() {
		return physician_id;
	}
	public void setPhysician_id(int physician_id) {
		this.physician_id = physician_id;
	}
	public Date getState_date() {
		return state_date;
	}
	public void setState_date(Date state_date) {
		this.state_date = state_date;
	}
	public boolean isIs_repeat() {
		return is_repeat;
	}
	public void setIs_repeat(boolean is_repeat) {
		this.is_repeat = is_repeat;
	}
	public String getWeek_days() {
		return week_days;
	}
	public void setWeek_days(String week_days) {
		this.week_days = week_days;
	}
	public int getRepeat_upto() {
		return repeat_upto;
	}
	public void setRepeat_upto(int repeat_upto) {
		this.repeat_upto = repeat_upto;
	}
	public int getCreated_by() {
		return created_by;
	}
	public void setCreated_by(int created_by) {
		this.created_by = created_by;
	}
	public LocalDateTime getDate_time() {
		return date_time;
	}
	public void setDate_time(LocalDateTime date_time) {
		this.date_time = date_time;
	}
	@Override
	public String toString() {
		return "Shift [shift_id=" + shift_id + ", physician_id=" + physician_id + ", state_date=" + state_date
				+ ", is_repeat=" + is_repeat + ", week_days=" + week_days + ", repeat_upto=" + repeat_upto
				+ ", created_by=" + created_by + ", date_time=" + date_time + ", getShift_id()=" + getShift_id()
				+ ", getPhysician_id()=" + getPhysician_id() + ", getState_date()=" + getState_date()
				+ ", isIs_repeat()=" + isIs_repeat() + ", getWeek_days()=" + getWeek_days() + ", getRepeat_upto()="
				+ getRepeat_upto() + ", getCreated_by()=" + getCreated_by() + ", getDate_time()=" + getDate_time()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}
	
}
