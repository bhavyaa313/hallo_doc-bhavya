package hallodoc.dto;

public class CancelCaseDto {
	
	private String reasonString;
	private String additionalNoteString;
	private int reqId;
	
	public String getReasonString() {
		return reasonString;
	}
	public void setReasonString(String reasonString) {
		this.reasonString = reasonString;
	}
	public String getAdditionalNoteString() {
		return additionalNoteString;
	}
	public void setAdditionalNoteString(String additionalNoteString) {
		this.additionalNoteString = additionalNoteString;
	}
	
	
	
	public int getReqId() {
		return reqId;
	}
	public void setReqId(int reqId) {
		this.reqId = reqId;
	}
	
	
	public CancelCaseDto(String reasonString, String additionalNoteString, int reqId) {
		super();
		this.reasonString = reasonString;
		this.additionalNoteString = additionalNoteString;
		this.reqId = reqId;
		
	}
	public CancelCaseDto() {
		super();
		// TODO Auto-generated constructor stub
	}
			
		
	
			

}
