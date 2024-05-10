package hallodoc.dto;



public class EncounterDto {

	private String fname;
	private String lname;
	private String location;
	private String dob;
	private String date;
	private String email;
	private String phone;
	private String history1;
	private String history2;
	private String temp;
	private String abd;
	private String bloodPressurePlus;
	private String bloodPressureNeg;
	private String chest;
	private String cv;
	private String diagnosis;
	private String extr;
	private String followUp;
	private String heent;
	private String hr;
	private String medicationsDespensed;
	private String neuro;
	private String o2;
	private String other;
	private String pain;
	private String procedures;
	private String rr;
	private String skin;
	private String treatmentPlan;
	private boolean isFinalize;
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
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
	public String getHistory1() {
		return history1;
	}
	public void setHistory1(String history1) {
		this.history1 = history1;
	}
	public String getHistory2() {
		return history2;
	}
	public void setHistory2(String history2) {
		this.history2 = history2;
	}
	public String getTemp() {
		return temp;
	}
	public void setTemp(String temp) {
		this.temp = temp;
	}
	public String getAbd() {
		return abd;
	}
	public void setAbd(String abd) {
		this.abd = abd;
	}
	public String getBloodPressurePlus() {
		return bloodPressurePlus;
	}
	public void setBloodPressurePlus(String bloodPressurePlus) {
		this.bloodPressurePlus = bloodPressurePlus;
	}
	public String getBloodPressureNeg() {
		return bloodPressureNeg;
	}
	public void setBloodPressureNeg(String bloodPressureNeg) {
		this.bloodPressureNeg = bloodPressureNeg;
	}
	public String getChest() {
		return chest;
	}
	public void setChest(String chest) {
		this.chest = chest;
	}
	public String getCv() {
		return cv;
	}
	public void setCv(String cv) {
		this.cv = cv;
	}
	public String getDiagnosis() {
		return diagnosis;
	}
	public void setDiagnosis(String diagnosis) {
		this.diagnosis = diagnosis;
	}
	public String getExtr() {
		return extr;
	}
	public void setExtr(String extr) {
		this.extr = extr;
	}
	public String getFollowUp() {
		return followUp;
	}
	public void setFollowUp(String followUp) {
		this.followUp = followUp;
	}
	public String getHeent() {
		return heent;
	}
	public void setHeent(String heent) {
		this.heent = heent;
	}
	public String getHr() {
		return hr;
	}
	public void setHr(String hr) {
		this.hr = hr;
	}
	public String getMedicationsDespensed() {
		return medicationsDespensed;
	}
	public void setMedicationsDespensed(String medicationsDespensed) {
		this.medicationsDespensed = medicationsDespensed;
	}
	public String getNeuro() {
		return neuro;
	}
	public void setNeuro(String neuro) {
		this.neuro = neuro;
	}
	public String getO2() {
		return o2;
	}
	public void setO2(String o2) {
		this.o2 = o2;
	}
	public String getOther() {
		return other;
	}
	public void setOther(String other) {
		this.other = other;
	}
	public String getPain() {
		return pain;
	}
	public void setPain(String pain) {
		this.pain = pain;
	}
	public String getProcedures() {
		return procedures;
	}
	public void setProcedures(String procedures) {
		this.procedures = procedures;
	}
	public String getRr() {
		return rr;
	}
	public void setRr(String rr) {
		this.rr = rr;
	}
	public String getSkin() {
		return skin;
	}
	public void setSkin(String skin) {
		this.skin = skin;
	}
	public String getTreatmentPlan() {
		return treatmentPlan;
	}
	public void setTreatmentPlan(String treatmentPlan) {
		this.treatmentPlan = treatmentPlan;
	}
	
	
	public boolean isFinalize() {
		return isFinalize;
	}
	public void setFinalize(boolean isFinalize) {
		this.isFinalize = isFinalize;
	}
	
	

	
	
	
	public EncounterDto(String fname, String lname, String location, String dob, String date, String email,
			String phone, String history1, String history2, String temp, String abd, String bloodPressurePlus,
			String bloodPressureNeg, String chest, String cv, String diagnosis, String extr, String followUp,
			String heent, String hr, String medicationsDespensed, String neuro, String o2, String other, String pain,
			String procedures, String rr, String skin, String treatmentPlan, boolean isFinalize) {
		super();
		this.fname = fname;
		this.lname = lname;
		this.location = location;
		this.dob = dob;
		this.date = date;
		this.email = email;
		this.phone = phone;
		this.history1 = history1;
		this.history2 = history2;
		this.temp = temp;
		this.abd = abd;
		this.bloodPressurePlus = bloodPressurePlus;
		this.bloodPressureNeg = bloodPressureNeg;
		this.chest = chest;
		this.cv = cv;
		this.diagnosis = diagnosis;
		this.extr = extr;
		this.followUp = followUp;
		this.heent = heent;
		this.hr = hr;
		this.medicationsDespensed = medicationsDespensed;
		this.neuro = neuro;
		this.o2 = o2;
		this.other = other;
		this.pain = pain;
		this.procedures = procedures;
		this.rr = rr;
		this.skin = skin;
		this.treatmentPlan = treatmentPlan;
		this.isFinalize = isFinalize;
	}
	public EncounterDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
