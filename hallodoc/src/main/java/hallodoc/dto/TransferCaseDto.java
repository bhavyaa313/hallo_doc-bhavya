package hallodoc.dto;

public class TransferCaseDto {
	
	private String region;
	private String physician1;
	private String phyId1;
	private String notes1;
	private String reqId4;
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}
	public String getPhysician1() {
		return physician1;
	}
	public void setPhysician1(String physician1) {
		this.physician1 = physician1;
	}
	public String getPhyId1() {
		return phyId1;
	}
	public void setPhyId1(String phyId1) {
		this.phyId1 = phyId1;
	}
	public String getNotes1() {
		return notes1;
	}
	public void setNotes1(String notes1) {
		this.notes1 = notes1;
	}
	public String getReqId4() {
		return reqId4;
	}
	public void setReqId4(String reqId4) {
		this.reqId4 = reqId4;
	}
	public TransferCaseDto(String region, String physician1, String phyId1, String notes1, String reqId4) {
		super();
		this.region = region;
		this.physician1 = physician1;
		this.phyId1 = phyId1;
		this.notes1 = notes1;
		this.reqId4 = reqId4;
	}
	public TransferCaseDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
