package hallodoc.model;

import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.ManyToAny;

@Entity
@Table(name = "request_status_log")
public class RequestStatusLog {
	
	@Id
	@Column(name = "request_status_log_id")
	private int request_status_log_id;
	
	
	@ManyToOne
	@JoinColumn(name = "request_id")
	private Request requestId;
	
	private int status;
	
	@ManyToOne
	@JoinColumn(name = "physician_id")
	private Physician physicianId;
	
	@Column(name = "admin_id")
	private int adminId;
	
	@ManyToOne
	@JoinColumn(name = "trans_to_physician_id")
	private Physician transToPhysicianId;
	
	private String notes;
	
	@Column(name = "created_date")
	private LocalDateTime createdDate;
	
	
	private boolean transToAdmin;

	public int getRequest_status_log_id() {
		return request_status_log_id;
	}

	public void setRequest_status_log_id(int request_status_log_id) {
		this.request_status_log_id = request_status_log_id;
	}

	
	public Request getRequestId() {
		return requestId;
	}

	public void setRequestId(Request requestId) {
		this.requestId = requestId;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}
	
	
	
	public Physician getPhysicianId() {
		return physicianId;
	}

	public void setPhysicianId(Physician physicianId) {
		this.physicianId = physicianId;
	}

	public int getAdminId() {
		return adminId;
	}

	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}



	public Physician getTransToPhysicianId() {
		return transToPhysicianId;
	}

	public void setTransToPhysicianId(Physician transToPhysicianId) {
		this.transToPhysicianId = transToPhysicianId;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public LocalDateTime getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(LocalDateTime localDateTime) {
		this.createdDate = localDateTime;
	}

	public boolean isTransToAdmin() {
		return transToAdmin;
	}

	public void setTransToAdmin(boolean transToAdmin) {
		this.transToAdmin = transToAdmin;
	}

	

	public RequestStatusLog(int request_status_log_id, Request requestId, int status, Physician physicianId, int adminId,
			Physician transToPhysicianId, String notes, LocalDateTime createdDate, boolean transToAdmin) {
		super();
		this.request_status_log_id = request_status_log_id;
		this.requestId = requestId;
		this.status = status;
		this.physicianId = physicianId;
		this.adminId = adminId;
		this.transToPhysicianId = transToPhysicianId;
		this.notes = notes;
		this.createdDate = createdDate;
		this.transToAdmin = transToAdmin;
	}

	public RequestStatusLog() {
		super();
		// TODO Auto-generated constructor stub
	}	
	
	

}
