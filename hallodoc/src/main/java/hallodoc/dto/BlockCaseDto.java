package hallodoc.dto;

public class BlockCaseDto {

	private String additionalNoteString2;
	private int reqId2;

	public BlockCaseDto(String additionalNoteString2, int reqId2) {
		super();
		this.additionalNoteString2 = additionalNoteString2;
		this.reqId2 = reqId2;
	}

	public String getAdditionalNoteString2() {
		return additionalNoteString2;
	}

	public void setAdditionalNoteString2(String additionalNoteString2) {
		this.additionalNoteString2 = additionalNoteString2;
	}

	public int getReqId2() {
		return reqId2;
	}

	public void setReqId2(int reqId2) {
		this.reqId2 = reqId2;
	}

	public BlockCaseDto() {
		super();
		// TODO Auto-generated constructor stub
	}

}
