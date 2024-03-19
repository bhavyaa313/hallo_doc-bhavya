package hallodoc.model;

import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "request_wise_file")
public class RequestWiseFile {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "request_wise_file_id")
	private int requestWiseFileId;
	
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "request_id")

	private Request requestId;
	
	@Column(name = "file_name")
	private String fileName;
	
	@Column(name = "created_date")
	private LocalDateTime createdDate;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "physician_id")
	
	private Physician physicianId;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "admin_id")
	private Admin adminId;
	
	@Column(name = "doc_type")
	private int docType;
	
	@Column(name = "is_finalize")
	private boolean isFinalize;
	
	@Column(name = "is_deleted")
	private boolean isDeleted;
	
	@Column(name = "is_patient_records")
	private boolean isPatientRecords;

	
	

	

	public int getRequestWiseFileId() {
		return requestWiseFileId;
	}






	public void setRequestWiseFileId(int requestWiseFileId) {
		this.requestWiseFileId = requestWiseFileId;
	}






	public Request getRequestId() {
		return requestId;
	}






	public void setRequestId(Request requestId) {
		this.requestId = requestId;
	}






	public String getFileName() {
		return fileName;
	}






	public void setFileName(String fileName) {
		this.fileName = fileName;
	}






	public LocalDateTime getCreatedDate() {
		return createdDate;
	}






	public void setCreatedDate(LocalDateTime createdDate) {
		this.createdDate = createdDate;
	}






	public Physician getPhysicianId() {
		return physicianId;
	}






	public void setPhysicianId(Physician physicianId) {
		this.physicianId = physicianId;
	}






	public Admin getAdminId() {
		return adminId;
	}






	public void setAdminId(Admin adminId) {
		this.adminId = adminId;
	}






	public int getDocType() {
		return docType;
	}






	public void setDocType(int docType) {
		this.docType = docType;
	}






	public boolean isFinalize() {
		return isFinalize;
	}






	public void setFinalize(boolean isFinalize) {
		this.isFinalize = isFinalize;
	}






	public boolean isDeleted() {
		return isDeleted;
	}






	public void setDeleted(boolean isDeleted) {
		this.isDeleted = isDeleted;
	}






	public boolean isPatientRecords() {
		return isPatientRecords;
	}






	public void setPatientRecords(boolean isPatientRecords) {
		this.isPatientRecords = isPatientRecords;
	}






	public RequestWiseFile() {
		super();
		// TODO Auto-generated constructor stub
	}






	public RequestWiseFile(int requestWiseFileId, Request requestId, String fileName, LocalDateTime createdDate,
			Physician physicianId, Admin adminId, int docType, boolean isFinalize, boolean isDeleted,
			boolean isPatientRecords) {
		super();
		this.requestWiseFileId = requestWiseFileId;
		this.requestId = requestId;
		this.fileName = fileName;
		this.createdDate = createdDate;
		this.physicianId = physicianId;
		this.adminId = adminId;
		this.docType = docType;
		this.isFinalize = isFinalize;
		this.isDeleted = isDeleted;
		this.isPatientRecords = isPatientRecords;
	}



	
	
	
}
