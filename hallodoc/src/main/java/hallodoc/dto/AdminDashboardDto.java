package hallodoc.dto;

import java.time.LocalDateTime;

import javax.management.loading.PrivateClassLoader;

public class AdminDashboardDto {

	private String name;
	private String dob;
	private String phyNameString;
	private LocalDateTime dateOfService;
	private String region;
	private String requestor;
	private String requestedDate;
	private String phone;
	private String address;
	private String notes;
	private int status;
	private int requestTypeId;
	private int requestId;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	
	
	public int getRequestId() {
		return requestId;
	}

	public void setRequestId(int requestId) {
		this.requestId = requestId;
	}

	public String getPhyNameString() {
		return phyNameString;
	}

	public void setPhyNameString(String phyNameString) {
		this.phyNameString = phyNameString;
	}

	public LocalDateTime getDateOfService() {
		return dateOfService;
	}

	public void setDateOfService(LocalDateTime dateOfService) {
		this.dateOfService = dateOfService;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getRequestor() {
		return requestor;
	}

	public void setRequestor(String requestor) {
		this.requestor = requestor;
	}

	public String getRequestedDate() {
		return requestedDate;
	}

	public void setRequestedDate(String requestedDate) {
		this.requestedDate = requestedDate;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getRequestTypeId() {
		return requestTypeId;
	}

	public void setRequestTypeId(int requestTypeId) {
		this.requestTypeId = requestTypeId;
	}


	public AdminDashboardDto(String name, String dob, String phyNameString, LocalDateTime dateOfService, String region,
			String requestor, String requestedDate, String phone, String address, String notes, int status,
			int requestTypeId, int requestId) {
		super();
		this.name = name;
		this.dob = dob;
		this.phyNameString = phyNameString;
		this.dateOfService = dateOfService;
		this.region = region;
		this.requestor = requestor;
		this.requestedDate = requestedDate;
		this.phone = phone;
		this.address = address;
		this.notes = notes;
		this.status = status;
		this.requestTypeId = requestTypeId;
		this.requestId = requestId;
	}

	public AdminDashboardDto() {
		super();
		// TODO Auto-generated constructor stub
	}

}
