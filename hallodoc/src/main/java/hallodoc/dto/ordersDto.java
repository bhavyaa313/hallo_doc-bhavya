package hallodoc.dto;

public class ordersDto {
	
	private int vendorId1;
	private String profession;
	private String vendor;
	private String businessContact;
	private String email;
	private String faxNumber;
	private String prescription;
	private int numberOfrefill;
	private int reqId;
	public String getProfession() {
		return profession;
	}
	public void setProfession(String profession) {
		this.profession = profession;
	}
	public String getVendor() {
		return vendor;
	}
	public void setVendor(String vendor) {
		this.vendor = vendor;
	}
	public String getBusinessContact() {
		return businessContact;
	}
	public void setBusinessContact(String businessContact) {
		this.businessContact = businessContact;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getFaxNumber() {
		return faxNumber;
	}
	public void setFaxNumber(String faxNumber) {
		this.faxNumber = faxNumber;
	}
	
	
	
	public int getReqId() {
		return reqId;
	}
	public void setReqId(int reqId) {
		this.reqId = reqId;
	}
	public void setNumberOfrefill(int numberOfrefill) {
		this.numberOfrefill = numberOfrefill;
	}
	public int getVendorId1() {
		return vendorId1;
	}
	public void setVendorId1(int vendorId1) {
		this.vendorId1 = vendorId1;
	}
	public String getPrescription() {
		return prescription;
	}
	public void setPrescription(String prescription) {
		this.prescription = prescription;
	}
	public int getNumberOfrefill() {
		return numberOfrefill;
	}
	

	public ordersDto(int vendorId1, String profession, String vendor, String businessContact, String email,
			String faxNumber, String prescription, int numberOfrefill, int reqId) {
		super();
		this.vendorId1 = vendorId1;
		this.profession = profession;
		this.vendor = vendor;
		this.businessContact = businessContact;
		this.email = email;
		this.faxNumber = faxNumber;
		this.prescription = prescription;
		this.numberOfrefill = numberOfrefill;
		this.reqId = reqId;
	}
	public ordersDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
}
