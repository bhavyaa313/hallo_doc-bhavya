package hallodoc.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "encounter_form")
public class EncounterForm {
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	@Column(name = "encounter_form_id")
	private int encounterFormId;
	private String abd;
	@Column(name = "admin_id")
	private int adminId;
	private String alergie;
	@Column(name = "blood_pressure_plus")
	private String bloodPressurePlus;
	@Column(name = "blood_pressure_neg")
	private String bloodPressureNeg;
	private String chest;
	private String cv;
	private String diagnosis;
	private String extr;
	@Column(name = "follow_up")
	private String followUp;

	private String heent;
	@Column(name = "history_of_illness")
	private String historyOfIllness;
	private String hr;
	@Column(name = "medical_history")
	private String medicalHistory;
	private String medications;
	@Column(name = "medications_despensed")
	private String medicationsDespensed;
	private String neuro;
	private String o2;
	private String other;
	private String pain;
	@JoinColumn(name = "physician_id")
	@ManyToOne
	private Physician physicianId;
	private String procedures;
	private String rr;
	private String skin;
	private String temp;
	@Column(name = "treatment_plan")
	private String treatmentPlan;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "request_id")

	private Request requestId;
	
	@Column(name = "is_finalized")
	private boolean isFinalized;

	public int getEncounterFormId() {
		return encounterFormId;
	}

	public void setEncounterFormId(int encounterFormId) {
		this.encounterFormId = encounterFormId;
	}

	public String getAbd() {
		return abd;
	}

	public void setAbd(String abd) {
		this.abd = abd;
	}

	public int getAdminId() {
		return adminId;
	}

	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}

	public String getAlergie() {
		return alergie;
	}

	public void setAlergie(String alergie) {
		this.alergie = alergie;
	}

	
	public boolean isFinalized() {
		return isFinalized;
	}

	public void setFinalized(boolean isFinalized) {
		this.isFinalized = isFinalized;
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

	public String getHistoryOfIllness() {
		return historyOfIllness;
	}

	public void setHistoryOfIllness(String historyOfIllness) {
		this.historyOfIllness = historyOfIllness;
	}

	public String getHr() {
		return hr;
	}

	public void setHr(String hr) {
		this.hr = hr;
	}

	public String getMedicalHistory() {
		return medicalHistory;
	}

	public void setMedicalHistory(String medicalHistory) {
		this.medicalHistory = medicalHistory;
	}

	public String getMedications() {
		return medications;
	}

	public void setMedications(String medications) {
		this.medications = medications;
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

	

	public Physician getPhysicianId() {
		return physicianId;
	}

	public void setPhysicianId(Physician physicianId) {
		this.physicianId = physicianId;
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

	public String getTemp() {
		return temp;
	}

	public void setTemp(String temp) {
		this.temp = temp;
	}

	public String getTreatmentPlan() {
		return treatmentPlan;
	}

	public void setTreatmentPlan(String treatmentPlan) {
		this.treatmentPlan = treatmentPlan;
	}

	public Request getRequestId() {
		return requestId;
	}

	public void setRequestId(Request requestId) {
		this.requestId = requestId;
	}

	

	public EncounterForm(int encounterFormId, String abd, int adminId, String alergie, String bloodPressurePlus,
			String bloodPressureNeg, String chest, String cv, String diagnosis, String extr, String followUp,
			String heent, String historyOfIllness, String hr, String medicalHistory, String medications,
			String medicationsDespensed, String neuro, String o2, String other, String pain, Physician physicianId,
			String procedures, String rr, String skin, String temp, String treatmentPlan, Request requestId,
			boolean isFinalized) {
		super();
		this.encounterFormId = encounterFormId;
		this.abd = abd;
		this.adminId = adminId;
		this.alergie = alergie;
		this.bloodPressurePlus = bloodPressurePlus;
		this.bloodPressureNeg = bloodPressureNeg;
		this.chest = chest;
		this.cv = cv;
		this.diagnosis = diagnosis;
		this.extr = extr;
		this.followUp = followUp;
		this.heent = heent;
		this.historyOfIllness = historyOfIllness;
		this.hr = hr;
		this.medicalHistory = medicalHistory;
		this.medications = medications;
		this.medicationsDespensed = medicationsDespensed;
		this.neuro = neuro;
		this.o2 = o2;
		this.other = other;
		this.pain = pain;
		this.physicianId = physicianId;
		this.procedures = procedures;
		this.rr = rr;
		this.skin = skin;
		this.temp = temp;
		this.treatmentPlan = treatmentPlan;
		this.requestId = requestId;
		this.isFinalized = isFinalized;
	}

	public EncounterForm() {
		super();
		// TODO Auto-generated constructor stub
	}

}
