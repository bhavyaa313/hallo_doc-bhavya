package hallodoc.dto;

public class SearchRecordsDto {
	
	private String pName;
	private String requestor;
	private String dOS;
	private String closeDate;
	private String email;
	private String phone;
	private String address;
	private String zipString;
	private String Rstatus;
	private String phy;
	private String phyNote;
	private String adminNote;
	private String patientNote;
	private int reqId;
	public String getpName() {
		return pName;
	}
	public void setpName(String pName) {
		this.pName = pName;
	}
	public String getRequestor() {
		return requestor;
	}
	public void setRequestor(String requestor) {
		this.requestor = requestor;
	}
	public String getdOS() {
		return dOS;
	}
	public void setdOS(String dOS) {
		this.dOS = dOS;
	}
	public String getCloseDate() {
		return closeDate;
	}
	public void setCloseDate(String closeDate) {
		this.closeDate = closeDate;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
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
	public String getZipString() {
		return zipString;
	}
	public void setZipString(String zipString) {
		this.zipString = zipString;
	}
	public String getRstatus() {
		return Rstatus;
	}
	public void setRstatus(String rstatus) {
		Rstatus = rstatus;
	}
	public String getPhy() {
		return phy;
	}
	public void setPhy(String phy) {
		this.phy = phy;
	}
	public String getPhyNote() {
		return phyNote;
	}
	public void setPhyNote(String phyNote) {
		this.phyNote = phyNote;
	}
	public String getAdminNote() {
		return adminNote;
	}
	public void setAdminNote(String adminNote) {
		this.adminNote = adminNote;
	}
	public String getPatientNote() {
		return patientNote;
	}
	public void setPatientNote(String patientNote) {
		this.patientNote = patientNote;
	}
	public int getReqId() {
		return reqId;
	}
	public void setReqId(int reqId) {
		this.reqId = reqId;
	}
	public SearchRecordsDto(String pName, String requestor, String dOS, String closeDate, String email, String phone,
			String address, String zipString, String rstatus, String phy, String phyNote, String adminNote,
			String patientNote, int reqId) {
		super();
		this.pName = pName;
		this.requestor = requestor;
		this.dOS = dOS;
		this.closeDate = closeDate;
		this.email = email;
		this.phone = phone;
		this.address = address;
		this.zipString = zipString;
		Rstatus = rstatus;
		this.phy = phy;
		this.phyNote = phyNote;
		this.adminNote = adminNote;
		this.patientNote = patientNote;
		this.reqId = reqId;
	}
	public SearchRecordsDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	

}
