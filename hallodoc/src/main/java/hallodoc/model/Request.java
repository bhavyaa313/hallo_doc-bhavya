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
	
	

	@OneToOne (cascade = CascadeType.ALL)
	@JoinColumn(name = "user_id")

	private User userId;
	
	
	
	@Column(name = "first_name")
	private String firstName;
	
	@Column(name = "last_name")
	private String lastName;
	
	@Column(name = "phone_number")
	private String phoneNumber;

	private String email;
	
	private int status;
	
	@Column(name = "physician_id")
	private int physicianId;
	
	@Column(name = "confirmation_number")
	private int confirmationNumber;
	
	@Column(name = "created_date")
	private LocalDateTime createdDate;
	
	@Column(name = "is_deleted")
	private boolean isDeleted;
	
	@Column(name = "modified_date")
	private Date modifieDate;
	
	
	@OneToOne (cascade = CascadeType.ALL)
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
	private Date acceptedDate;
	
	@Column(name = "relation_name")
	private String relationName;
	
	@Column(name = "case_number")
	private String caseNumber;
	
	@OneToOne(mappedBy = "requestId")
	private RequestClient requestClient;
	
	@OneToOne(mappedBy = "requestId")
	private RequestWiseFile requestWiseFile;
	
	
	@OneToOne(mappedBy = "requestId")
	private RequestConcierge requestConcierge;
	
	

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


	public int getPhysicianId() {
		return physicianId;
	}


	public void setPhysicianId(int physicianId) {
		this.physicianId = physicianId;
	}


	public int getConfirmationNumber() {
		return confirmationNumber;
	}


	public void setConfirmationNumber(int confirmationNumber) {
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


	public Date getModifieDate() {
		return modifieDate;
	}


	public void setModifieDate(Date modifieDate) {
		this.modifieDate = modifieDate;
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


	public Date getAcceptedDate() {
		return acceptedDate;
	}


	public void setAcceptedDate(Date acceptedDate) {
		this.acceptedDate = acceptedDate;
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


	public void setRequestId(int requestId) {
		this.requestId = requestId;
	}


	
	
	public RequestClient getRequestClient() {
		return requestClient;
	}


	public void setRequestClient(RequestClient requestClient) {
		this.requestClient = requestClient;
	}


	public RequestWiseFile getRequestWiseFile() {
		return requestWiseFile;
	}


	public void setRequestWiseFile(RequestWiseFile requestWiseFile) {
		this.requestWiseFile = requestWiseFile;
	}



	public RequestConcierge getRequestConcierge() {
		return requestConcierge;
	}


	public void setRequestConcierge(RequestConcierge requestConcierge) {
		this.requestConcierge = requestConcierge;
	}




	public Request(int requestId, int requestTypeId, User userId, String firstName, String lastName, String phoneNumber,
			String email, int status, int physicianId, int confirmationNumber, LocalDateTime createdDate,
			boolean isDeleted, Date modifieDate, AspNetUsers declinedBy, Date lastWellnessDate, int callType,
			boolean completedByPhysician, Date lastReservationDate, Date acceptedDate, String relationName,
			String caseNumber, RequestClient requestClient, RequestWiseFile requestWiseFile, Concierge concierge,
			RequestConcierge requestConcierge) {
		super();
		this.requestId = requestId;
		this.requestTypeId = requestTypeId;
		this.userId = userId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.status = status;
		this.physicianId = physicianId;
		this.confirmationNumber = confirmationNumber;
		this.createdDate = createdDate;
		this.isDeleted = isDeleted;
		this.modifieDate = modifieDate;
		this.declinedBy = declinedBy;
		this.lastWellnessDate = lastWellnessDate;
		this.callType = callType;
		this.completedByPhysician = completedByPhysician;
		this.lastReservationDate = lastReservationDate;
		this.acceptedDate = acceptedDate;
		this.relationName = relationName;
		this.caseNumber = caseNumber;
		this.requestClient = requestClient;
		this.requestWiseFile = requestWiseFile;
		
		this.requestConcierge = requestConcierge;
	}

	

	@Override
	public String toString() {
		return "Request [requestId=" + requestId + ", requestTypeId=" + requestTypeId + ", userId=" + userId
				+ ", firstName=" + firstName + ", lastName=" + lastName + ", phoneNumber=" + phoneNumber + ", email="
				+ email + ", status=" + status + ", physicianId=" + physicianId + ", confirmationNumber="
				+ confirmationNumber + ", createdDate=" + createdDate + ", isDeleted=" + isDeleted + ", modifieDate="
				+ modifieDate + ", declinedBy=" + declinedBy + ", lastWellnessDate=" + lastWellnessDate + ", callType="
				+ callType + ", completedByPhysician=" + completedByPhysician + ", lastReservationDate="
				+ lastReservationDate + ", acceptedDate=" + acceptedDate + ", relationName=" + relationName
				+ ", caseNumber=" + caseNumber + ", requestClient=" + requestClient + ", requestWiseFile="
				+ requestWiseFile + ", requestConcierge=" + requestConcierge + "]";
	}


	public Request() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	

	
	
}
