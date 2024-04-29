package hallodoc.dto;

public class CreateProviderDto {

	private String uName;
	private String pswd;
	private String fName;
	private String lName;
	private String mail;
	private String phone;
	private String medicalLi;
	private String npiNum;
	private String syncMail;
	private String addrOne;
	private String addrTwo;
	private String city;
	private String state;
	private String zip;
	private String bName;
	private String bWebsite;
	private String adminNotes;
	private String sign;
	private String photo;

	public String getuName() {
		return uName;
	}

	public void setuName(String uName) {
		this.uName = uName;
	}

	public String getPswd() {
		return pswd;
	}

	public void setPswd(String pswd) {
		this.pswd = pswd;
	}

	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public String getlName() {
		return lName;
	}

	public void setlName(String lName) {
		this.lName = lName;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getMedicalLi() {
		return medicalLi;
	}

	public void setMedicalLi(String medicalLi) {
		this.medicalLi = medicalLi;
	}

	public String getNpiNum() {
		return npiNum;
	}

	public void setNpiNum(String npiNum) {
		this.npiNum = npiNum;
	}

	public String getSyncMail() {
		return syncMail;
	}

	public void setSyncMail(String syncMail) {
		this.syncMail = syncMail;
	}

	public String getAddrOne() {
		return addrOne;
	}

	public void setAddrOne(String addrOne) {
		this.addrOne = addrOne;
	}

	public String getAddrTwo() {
		return addrTwo;
	}

	public void setAddrTwo(String addrTwo) {
		this.addrTwo = addrTwo;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public String getbName() {
		return bName;
	}

	public void setbName(String bName) {
		this.bName = bName;
	}

	public String getbWebsite() {
		return bWebsite;
	}

	public void setbWebsite(String bWebsite) {
		this.bWebsite = bWebsite;
	}

	public String getAdminNotes() {
		return adminNotes;
	}

	public void setAdminNotes(String adminNotes) {
		this.adminNotes = adminNotes;
	}

	public String getSign() {
		return sign;
	}

	public void setSign(String sign) {
		this.sign = sign;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public CreateProviderDto() {
		super();
	}

	public CreateProviderDto(String uName, String pswd, String fName, String lName, String mail, String phone,
			String medicalLi, String npiNum, String syncMail, String addrOne, String addrTwo, String city, String state,
			String zip, String bName, String bWebsite, String adminNotes, String sign, String photo) {
		super();
		this.uName = uName;
		this.pswd = pswd;
		this.fName = fName;
		this.lName = lName;
		this.mail = mail;
		this.phone = phone;
		this.medicalLi = medicalLi;
		this.npiNum = npiNum;
		this.syncMail = syncMail;
		this.addrOne = addrOne;
		this.addrTwo = addrTwo;
		this.city = city;
		this.state = state;
		this.zip = zip;
		this.bName = bName;
		this.bWebsite = bWebsite;
		this.adminNotes = adminNotes;
		this.sign = sign;
		this.photo = photo;
	}

	@Override
	public String toString() {
		return "SubmitCreateProviderDto [uName=" + uName + ", pswd=" + pswd + ", fName=" + fName + ", lName=" + lName
				+ ", mail=" + mail + ", phone=" + phone + ", medicalLi=" + medicalLi + ", npiNum=" + npiNum
				+ ", syncMail=" + syncMail + ", addrOne=" + addrOne + ", addrTwo=" + addrTwo + ", city=" + city
				+ ", state=" + state + ", zip=" + zip + ", bName=" + bName + ", bWebsite=" + bWebsite + ", adminNotes="
				+ adminNotes + ", sign=" + sign + ", photo=" + photo + "]";
	}

}
