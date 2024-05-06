package hallodoc.model;

import java.time.LocalDateTime;
import java.util.Date;

import javax.management.loading.PrivateClassLoader;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "request")
public class Request {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "request_id")
	private int requestId;

	@Column(name = "request_type_id")
	private int requestTypeId;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "user_id")
	private User userId;

	@Column(name = "first_name")
	private String firstName;

	@Column(name = "last_name")
	private String lastName;
	
	@Column(name = "case_tag_id")
	private int caseTagId;

	@Column(name = "phone_number")
	private String phoneNumber;

	private String email;

	private int status;

	@JoinColumn(name = "physician_id")
	@ManyToOne
	private Physician physicianId;

	@Column(name = "confirmation_number")
	private String confirmationNumber;

	@Column(name = "created_date")
	private LocalDateTime createdDate;

	@Column(name = "is_deleted")
	private boolean isDeleted;

	@Column(name = "modified_date")
	private LocalDateTime modifiedDate;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "declined_by")
	private AspNetUsers declinedBy;

	@Column(name = "last_wellness_date")
	private Date lastWellnessDate;

	@Column(name = "call_type")
	private int callType;

	@Column(name = "completed_by_physician")
	private boolean completedByPhysician;

	@Column(name = "last_reservation_date")
	private Date lastReservationDate;

	@Column(name = "accepted_date")
	private LocalDateTime acceptedDate;

	@Column(name = "relation_name")
	private String relationName;

	@Column(name = "case_number")
	private String caseNumber;

	@OneToOne(mappedBy = "requestId")
	private RequestClient requestClient;

	@OneToOne(mappedBy = "requestId")
	private RequestConcierge requestConcierge;
	
	@OneToOne(mappedBy = "requestId")
	private RequestNotes requestNotes;
	
	
	
	

	public RequestNotes getRequestNotes() {
		return requestNotes;
	}

	public void setRequestNotes(RequestNotes requestNotes) {
		this.requestNotes = requestNotes;
	}

	public int getRequestId() {
		return requestId;
	}

	public int getRequestTypeId() {
		return requestTypeId;
	}

	public void setRequestTypeId(int requestTypeId) {
		this.requestTypeId = requestTypeId;
	}

	public User getUserId() {
		return userId;
	}

	public void setUserId(User userId) {
		this.userId = userId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}



	
	
	public int getCaseTagId() {
		return caseTagId;
	}

	public void setCaseTagId(int caseTagId) {
		this.caseTagId = caseTagId;
	}

	
	public Physician getPhysicianId() {
		return physicianId;
	}

	public void setPhysicianId(Physician physicianId) {
		this.physicianId = physicianId;
	}

	public String getConfirmationNumber() {
		return confirmationNumber;
	}

	public void setConfirmationNumber(String confirmationNumber) {
		this.confirmationNumber = confirmationNumber;
	}

	public LocalDateTime getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(LocalDateTime createdDate) {
		this.createdDate = createdDate;
	}

	public boolean isDeleted() {
		return isDeleted;
	}

	public void setDeleted(boolean isDeleted) {
		this.isDeleted = isDeleted;
	}

	public LocalDateTime getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(LocalDateTime localDateTime) {
		this.modifiedDate = localDateTime;
	}

	public AspNetUsers getDeclinedBy() {
		return declinedBy;
	}

	public void setDeclinedBy(AspNetUsers declinedBy) {
		this.declinedBy = declinedBy;
	}

	public Date getLastWellnessDate() {
		return lastWellnessDate;
	}

	public void setLastWellnessDate(Date lastWellnessDate) {
		this.lastWellnessDate = lastWellnessDate;
	}

	public int getCallType() {
		return callType;
	}

	public void setCallType(int callType) {
		this.callType = callType;
	}

	public boolean isCompletedByPhysician() {
		return completedByPhysician;
	}

	public void setCompletedByPhysician(boolean completedByPhysician) {
		this.completedByPhysician = completedByPhysician;
	}

	public Date getLastReservationDate() {
		return lastReservationDate;
	}

	public void setLastReservationDate(Date lastReservationDate) {
		this.lastReservationDate = lastReservationDate;
	}

	

	public String getRelationName() {
		return relationName;
	}

	public void setRelationName(String relationName) {
		this.relationName = relationName;
	}

	public String getCaseNumber() {
		return caseNumber;
	}

	public void setCaseNumber(String caseNumber) {
		this.caseNumber = caseNumber;
	}
	
	

	public LocalDateTime getAcceptedDate() {
		return acceptedDate;
	}

	public void setAcceptedDate(LocalDateTime acceptedDate) {
		this.acceptedDate = acceptedDate;
	}

	public void setRequestId(int requestId) {
		this.requestId = requestId;
	}

	public RequestClient getRequestClient() {
		return requestClient;
	}

	public void setRequestClient(RequestClient requestClient) {
		this.requestClient = requestClient;
	}

	public RequestConcierge getRequestConcierge() {
		return requestConcierge;
	}

	public void setRequestConcierge(RequestConcierge requestConcierge) {
		this.requestConcierge = requestConcierge;
	}


	
	

	

	public Request(int requestId, int requestTypeId, User userId, String firstName, String lastName, int caseTagId,
			String phoneNumber, String email, int status, Physician physicianId, String confirmationNumber,
			LocalDateTime createdDate, boolean isDeleted, LocalDateTime modifiedDate, AspNetUsers declinedBy,
			Date lastWellnessDate, int callType, boolean completedByPhysician, Date lastReservationDate,
			LocalDateTime acceptedDate, String relationName, String caseNumber, RequestClient requestClient,
			RequestConcierge requestConcierge) {
		super();
		this.requestId = requestId;
		this.requestTypeId = requestTypeId;
		this.userId = userId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.caseTagId = caseTagId;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.status = status;
		this.physicianId = physicianId;
		this.confirmationNumber = confirmationNumber;
		this.createdDate = createdDate;
		this.isDeleted = isDeleted;
		this.modifiedDate = modifiedDate;
		this.declinedBy = declinedBy;
		this.lastWellnessDate = lastWellnessDate;
		this.callType = callType;
		this.completedByPhysician = completedByPhysician;
		this.lastReservationDate = lastReservationDate;
		this.acceptedDate = acceptedDate;
		this.relationName = relationName;
		this.caseNumber = caseNumber;
		this.requestClient = requestClient;
		this.requestConcierge = requestConcierge;
	}

	public Request() {
		super();
		// TODO Auto-generated constructor stub
	}




}
