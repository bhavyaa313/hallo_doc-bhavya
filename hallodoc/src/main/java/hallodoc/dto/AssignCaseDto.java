package hallodoc.dto;

import javax.management.loading.PrivateClassLoader;

public class AssignCaseDto {

	private String region;
	private String physician;
	private String phyId;
	private String notes;
	private String reqId3;

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getPhysician() {
		return physician;
	}

	public void setPhysician(String physician) {
		this.physician = physician;
	}

	public String getPhyId() {
		return phyId;
	}

	public void setPhyId(String phyId) {
		this.phyId = phyId;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public String getReqId3() {
		return reqId3;
	}

	public void setReqId3(String reqId3) {
		this.reqId3 = reqId3;
	}

	
	
	public AssignCaseDto(String region, String physician, String phyId, String notes, String reqId3) {
		super();
		this.region = region;
		this.physician = physician;
		this.phyId = phyId;
		this.notes = notes;
		this.reqId3 = reqId3;
	}

	public AssignCaseDto() {
		super();
		// TODO Auto-generated constructor stub
	}

}
