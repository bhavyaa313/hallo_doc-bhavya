package hallodoc.dto;

public class PatientRecordsDto {
	
	private int rId;
	private String client;
	private String createdDate;
	private String confirmationNumber;
	private String providerName;
	private String cdate;
	private String status;
	
	
	public int getrId() {
		return rId;
	}
	public void setrId(int rId) {
		this.rId = rId;
	}
	public String getClient() {
		return client;
	}
	public void setClient(String client) {
		this.client = client;
	}
	public String getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}
	public String getConfirmationNumber() {
		return confirmationNumber;
	}
	public void setConfirmationNumber(String confirmationNumber) {
		this.confirmationNumber = confirmationNumber;
	}
	public String getProviderName() {
		return providerName;
	}
	public void setProviderName(String providerName) {
		this.providerName = providerName;
	}
	public String getCdate() {
		return cdate;
	}
	public void setCdate(String cdate) {
		this.cdate = cdate;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
	
	
	public PatientRecordsDto(int rId, String client, String createdDate, String confirmationNumber, String providerName,
			String cdate, String status) {
		super();
		this.rId = rId;
		this.client = client;
		this.createdDate = createdDate;
		this.confirmationNumber = confirmationNumber;
		this.providerName = providerName;
		this.cdate = cdate;
		this.status = status;
	}
	public PatientRecordsDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	

}
