package hallodoc.model;

import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.ManyToAny;

@Entity
@Table(name = "request_notes")
public class RequestNotes {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "request_notes_id")
	private int reqeustNotesId;

	@OneToOne
	@JoinColumn(name = "request_id")
	private Request requestId;

	@Column(name = "str_month")
	private String strMonth;

	@Column(name = "int_year")
	private int intYear;

	@Column(name = "int_date")
	private int intDate;

	@Column(name = "physician_notes")
	private String physicianNotes;

	@Column(name = "admin_notes")
	private String adminNotes;

	@OneToOne
	@JoinColumn(name = "created_by")
	private AspNetUsers createdBy;

	@Column(name = "created_date")
	private LocalDateTime createdDate;

	@OneToOne
	@JoinColumn(name = "modified_by")
	private AspNetUsers modifiedBy;

	@Column(name = "modified_date")
	private LocalDateTime modifiedDate;

	@Column(name = "administrative_notes")
	private String administrativeNotes;

	private String note;

	public RequestNotes() {
		super();
	}

	public int getReqeustNotesId() {
		return reqeustNotesId;
	}

	public void setReqeustNotesId(int reqeustNotesId) {
		this.reqeustNotesId = reqeustNotesId;
	}

	public Request getRequestId() {
		return requestId;
	}

	public void setRequestId(Request requestId) {
		this.requestId = requestId;
	}

	public String getStrMonth() {
		return strMonth;
	}

	public void setStrMonth(String strMonth) {
		this.strMonth = strMonth;
	}

	public int getIntYear() {
		return intYear;
	}

	public void setIntYear(int intYear) {
		this.intYear = intYear;
	}

	public int getIntDate() {
		return intDate;
	}

	public void setIntDate(int intDate) {
		this.intDate = intDate;
	}

	public String getPhysicianNotes() {
		return physicianNotes;
	}

	public void setPhysicianNotes(String physicianNotes) {
		this.physicianNotes = physicianNotes;
	}

	public String getAdminNotes() {
		return adminNotes;
	}

	public void setAdminNotes(String adminNotes) {
		this.adminNotes = adminNotes;
	}

	public AspNetUsers getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(AspNetUsers createdBy) {
		this.createdBy = createdBy;
	}

	public LocalDateTime getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(LocalDateTime createdDate) {
		this.createdDate = createdDate;
	}

	public AspNetUsers getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(AspNetUsers modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	public LocalDateTime getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(LocalDateTime modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	public String getAdministrativeNotes() {
		return administrativeNotes;
	}

	public void setAdministrativeNotes(String administrativeNotes) {
		this.administrativeNotes = administrativeNotes;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public RequestNotes(int reqeustNotesId, Request requestId, String strMonth, int intYear, int intDate,
			String physicianNotes, String adminNotes, AspNetUsers createdBy, LocalDateTime createdDate,
			AspNetUsers modifiedBy, LocalDateTime modifiedDate, String administrativeNotes, String note) {
		super();
		this.reqeustNotesId = reqeustNotesId;
		this.requestId = requestId;
		this.strMonth = strMonth;
		this.intYear = intYear;
		this.intDate = intDate;
		this.physicianNotes = physicianNotes;
		this.adminNotes = adminNotes;
		this.createdBy = createdBy;
		this.createdDate = createdDate;
		this.modifiedBy = modifiedBy;
		this.modifiedDate = modifiedDate;
		this.administrativeNotes = administrativeNotes;
		this.note = note;
	}


}
