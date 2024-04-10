package hallodoc.dto;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

public class InfoSomeoneDto {

	private String symptoms;
	private String pFname;
	private String pLname;
	private String pDob;
	private String pEmail;
	private String pPhoneNo;
	private String pStreet;
	private String pCity;
	private String pState;
	private String pZipCode;
	private String pRoom;
	private String relation;
	private CommonsMultipartFile file;
	
	public String getSymptoms() {
		return symptoms;
	}
	public void setSymptoms(String symptoms) {
		this.symptoms = symptoms;
	}
	public String getpFname() {
		return pFname;
	}
	public void setpFname(String pFname) {
		this.pFname = pFname;
	}
	public String getpLname() {
		return pLname;
	}
	public void setpLname(String pLname) {
		this.pLname = pLname;
	}
	public String getpDob() {
		return pDob;
	}
	public void setpDob(String pDob) {
		this.pDob = pDob;
	}
	public String getpEmail() {
		return pEmail;
	}
	public void setpEmail(String pEmail) {
		this.pEmail = pEmail;
	}
	public String getpPhoneNo() {
		return pPhoneNo;
	}
	public void setpPhoneNo(String pPhoneNo) {
		this.pPhoneNo = pPhoneNo;
	}
	public String getpStreet() {
		return pStreet;
	}
	public void setpStreet(String pStreet) {
		this.pStreet = pStreet;
	}
	public String getpCity() {
		return pCity;
	}
	public void setpCity(String pCity) {
		this.pCity = pCity;
	}
	public String getpState() {
		return pState;
	}
	public void setpState(String pState) {
		this.pState = pState;
	}
	public String getpZipCode() {
		return pZipCode;
	}
	public void setpZipCode(String pZipCode) {
		this.pZipCode = pZipCode;
	}
	public String getpRoom() {
		return pRoom;
	}
	public void setpRoom(String pRoom) {
		this.pRoom = pRoom;
	}
	public String getRelation() {
		return relation;
	}
	public void setRelation(String relation) {
		this.relation = relation;
	}
	public CommonsMultipartFile getFile() {
		return file;
	}
	public void setFile(CommonsMultipartFile file) {
		this.file = file;
	}
	public InfoSomeoneDto(String symptoms, String pFname, String pLname, String pDob, String pEmail, String pPhoneNo,
			String pStreet, String pCity, String pState, String pZipCode, String pRoom, String relation,
			CommonsMultipartFile file) {
		super();
		this.symptoms = symptoms;
		this.pFname = pFname;
		this.pLname = pLname;
		this.pDob = pDob;
		this.pEmail = pEmail;
		this.pPhoneNo = pPhoneNo;
		this.pStreet = pStreet;
		this.pCity = pCity;
		this.pState = pState;
		this.pZipCode = pZipCode;
		this.pRoom = pRoom;
		this.relation = relation;
		this.file = file;
	}
	public InfoSomeoneDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
