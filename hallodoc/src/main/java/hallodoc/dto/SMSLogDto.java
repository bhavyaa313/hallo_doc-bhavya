package hallodoc.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

import hallodoc.model.Admin;
import hallodoc.model.Physician;
import hallodoc.model.Request;

public class SMSLogDto {

	private int smsLogId;

	private String subjectName;

	private String phone;

	private String confirmationNumber;

	private String role;

	private Request requestId;

	private Admin adminId;

	private Physician physicianId;

	private String createdDate;

	private String sentDate;

	private String sent;

	private int sentTries;

	private String action;

	private String recipientName;

	public String getSent() {
		return sent;
	}

	public void setSent(String sent) {
		this.sent = sent;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Admin getAdminId() {
		return adminId;
	}

	public void setAdminId(Admin adminId) {
		this.adminId = adminId;
	}

	public String getRecipientName() {
		return recipientName;
	}

	public void setRecipientName(String recipientName) {
		this.recipientName = recipientName;
	}

	public int getsmsLogId() {
		return smsLogId;
	}

	public void setsmsLogId(int smsLogId) {
		this.smsLogId = smsLogId;
	}

	public String getSubjectName() {
		return subjectName;
	}

	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}

	public String getphone() {
		return phone;
	}

	public void setphone(String phone) {
		this.phone = phone;
	}

	public String getConfirmationNumber() {
		return confirmationNumber;
	}

	public void setConfirmationNumber(String confirmationNumber) {
		this.confirmationNumber = confirmationNumber;
	}

	public String getRole() {
		return role;
	}

	public void setRoleId(String role) {
		this.role = role;
	}

	public Request getRequestId() {
		return requestId;
	}

	public void setRequestId(Request requestId) {
		this.requestId = requestId;
	}

	public Admin getAdmin_id() {
		return adminId;
	}

	public void setAdmin_id(Admin admin_id) {
		this.adminId = admin_id;
	}

	public Physician getPhysicianId() {
		return physicianId;
	}

	public void setPhysicianId(Physician physicianId) {
		this.physicianId = physicianId;
	}

	public String getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}

	public String getSentDate() {
		return sentDate;
	}

	public void setSentDate(String sentDate) {
		this.sentDate = sentDate;
	}

	public int getSentTries() {
		return sentTries;
	}

	public void setSentTries(int sentTries) {
		this.sentTries = sentTries;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public SMSLogDto() {
		super();
	}

	public SMSLogDto(int smsLogId, String subjectName, String phone, String confirmationNumber, String role,
			Request requestId, Admin adminId, Physician physicianId, String createdDate, String sentDate,
			String sent, int sentTries, String action, String recipientName) {
		super();
		this.smsLogId = smsLogId;
		this.subjectName = subjectName;
		this.phone = phone;
		this.confirmationNumber = confirmationNumber;
		this.role = role;
		this.requestId = requestId;
		this.adminId = adminId;
		this.physicianId = physicianId;
		this.createdDate = createdDate;
		this.sentDate = sentDate;
		this.sent = sent;
		this.sentTries = sentTries;
		this.action = action;
		this.recipientName = recipientName;
	}

	@Override
	public String toString() {
		return "SMSLogDto [smsLogId=" + smsLogId + ", subjectName=" + subjectName + ", phone=" + phone
				+ ", confirmationNumber=" + confirmationNumber + ", role=" + role + ", requestId=" + requestId
				+ ", adminId=" + adminId + ", physicianId=" + physicianId + ", createdDate=" + createdDate
				+ ", sentDate=" + sentDate + ", sent=" + sent + ", sentTries=" + sentTries + ", action=" + action
				+ ", recipientName=" + recipientName + "]";
	}

}
