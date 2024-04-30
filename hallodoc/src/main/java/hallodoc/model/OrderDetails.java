package hallodoc.model;

import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "order_details")
public class OrderDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@Column(name = "vendor_id")
	private int vendorId;
	@Column(name = "request_id")
	private int requestId;
	@Column(name = "fax_number")
	private String faxNumber;
	@Column(name = "email")
	private String email;
	@Column(name = "business_contact")
	private String businessContact;
	@Column(name = "prescription")
	private String prescription;
	@Column(name = "no_of_refill")
	private int noOfRefill;
	@Column(name = "created_date")
	private LocalDateTime createdDate;
	@Column(name = "created_by")
	private int createdBy;
	@Column(name = "order_details")
	private String orderDetails;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getVendorId() {
		return vendorId;
	}
	public void setVendorId(int vendorId) {
		this.vendorId = vendorId;
	}
	public int getRequestId() {
		return requestId;
	}
	public void setRequestId(int requestId) {
		this.requestId = requestId;
	}
	public String getFaxNumber() {
		return faxNumber;
	}
	public void setFaxNumber(String faxNumber) {
		this.faxNumber = faxNumber;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getBusinessContact() {
		return businessContact;
	}
	public void setBusinessContact(String businessContact) {
		this.businessContact = businessContact;
	}
	public String getPrescription() {
		return prescription;
	}
	public void setPrescription(String prescription) {
		this.prescription = prescription;
	}
	public int getNoOfRefill() {
		return noOfRefill;
	}
	public void setNoOfRefill(int noOfRefill) {
		this.noOfRefill = noOfRefill;
	}
	public LocalDateTime getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(LocalDateTime localDateTime) {
		this.createdDate = localDateTime;
	}
	public int getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(int createdBy) {
		this.createdBy = createdBy;
	}
	public String getOrderDetails() {
		return orderDetails;
	}
	public void setOrderDetails(String orderDetails) {
		this.orderDetails = orderDetails;
	}
	public OrderDetails(int id, int vendorId, int requestId, String faxNumber, String email, String businessContact,
			String prescription, int noOfRefill, LocalDateTime createdDate, int createdBy, String orderDetails) {
		super();
		this.id = id;
		this.vendorId = vendorId;
		this.requestId = requestId;
		this.faxNumber = faxNumber;
		this.email = email;
		this.businessContact = businessContact;
		this.prescription = prescription;
		this.noOfRefill = noOfRefill;
		this.createdDate = createdDate;
		this.createdBy = createdBy;
		this.orderDetails = orderDetails;
	}
	@Override
	public String toString() {
		return "OrderDetails [id=" + id + ", vendorId=" + vendorId + ", requestId=" + requestId + ", faxNumber="
				+ faxNumber + ", email=" + email + ", businessContact=" + businessContact + ", prescription="
				+ prescription + ", noOfRefill=" + noOfRefill + ", createdDate=" + createdDate + ", createdBy="
				+ createdBy + ", orderDetails=" + orderDetails + ", getId()=" + getId() + ", getVendorId()="
				+ getVendorId() + ", getRequestId()=" + getRequestId() + ", getFaxNumber()=" + getFaxNumber()
				+ ", getEmail()=" + getEmail() + ", getBusinessContact()=" + getBusinessContact()
				+ ", getPrescription()=" + getPrescription() + ", getNoOfRefill()=" + getNoOfRefill()
				+ ", getCreatedDate()=" + getCreatedDate() + ", getCreatedBy()=" + getCreatedBy()
				+ ", getOrderDetails()=" + getOrderDetails() + ", getClass()=" + getClass() + ", hashCode()="
				+ hashCode() + ", toString()=" + super.toString() + "]";
	}
	public OrderDetails() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
