package hallodoc.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "request_notes")
public class RequestNotes {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int request_notes_id;
	private int request_id;
	private String str_month;
	private int int_year;
	private int int_date;
	private String physican_notes;
	private String admin_notes;
	private int created_by;
	private LocalDateTime created_date;
	private int modified_by;
	private LocalDateTime modified_date;
	private String administrative_notes;
	private String note;
	public RequestNotes() {
		super();
		// TODO Auto-generated constructor stub
	}
	public RequestNotes(int request_notes_id, int request_id, String str_month, int int_year, int int_date,
			String physican_notes, String admin_notes, int created_by, LocalDateTime created_date, int modified_by,
			LocalDateTime modified_date, String administrative_notes, String note) {
		super();
		this.request_notes_id = request_notes_id;
		this.request_id = request_id;
		this.str_month = str_month;
		this.int_year = int_year;
		this.int_date = int_date;
		this.physican_notes = physican_notes;
		this.admin_notes = admin_notes;
		this.created_by = created_by;
		this.created_date = created_date;
		this.modified_by = modified_by;
		this.modified_date = modified_date;
		this.administrative_notes = administrative_notes;
		this.note = note;
	}
	@Override
	public String toString() {
		return "RequestNotes [request_notes_id=" + request_notes_id + ", request_id=" + request_id + ", str_month="
				+ str_month + ", int_year=" + int_year + ", int_date=" + int_date + ", physican_notes=" + physican_notes
				+ ", admin_notes=" + admin_notes + ", created_by=" + created_by + ", created_date=" + created_date
				+ ", modified_by=" + modified_by + ", modified_date=" + modified_date + ", administrative_notes="
				+ administrative_notes + ", note=" + note + "]";
	}
	public int getRequest_notes_id() {
		return request_notes_id;
	}
	public void setRequest_notes_id(int request_notes_id) {
		this.request_notes_id = request_notes_id;
	}
	public int getRequest_id() {
		return request_id;
	}
	public void setRequest_id(int request_id) {
		this.request_id = request_id;
	}
	public String getStr_month() {
		return str_month;
	}
	public void setStr_month(String str_month) {
		this.str_month = str_month;
	}
	public int getInt_year() {
		return int_year;
	}
	public void setInt_year(int int_year) {
		this.int_year = int_year;
	}
	public int getInt_date() {
		return int_date;
	}
	public void setInt_date(int int_date) {
		this.int_date = int_date;
	}
	public String getPhysican_notes() {
		return physican_notes;
	}
	public void setPhysican_notes(String physican_notes) {
		this.physican_notes = physican_notes;
	}
	public String getAdmin_notes() {
		return admin_notes;
	}
	public void setAdmin_notes(String admin_notes) {
		this.admin_notes = admin_notes;
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
	public String getAdministrative_notes() {
		return administrative_notes;
	}
	public void setAdministrative_notes(String administrative_notes) {
		this.administrative_notes = administrative_notes;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	
}
