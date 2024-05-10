package hallodoc.dto;

public class ConcludeCareDto {

	private int reqId;
	private String providerNote;
	private boolean isFinalize;
	public int getReqId() {
		return reqId;
	}
	public void setReqId(int reqId) {
		this.reqId = reqId;
	}
	public String getProviderNote() {
		return providerNote;
	}
	public void setProviderNote(String providerNote) {
		this.providerNote = providerNote;
	}
	public boolean isFinalize() {
		return isFinalize;
	}
	public void setFinalize(boolean isFinalize) {
		this.isFinalize = isFinalize;
	}
	public ConcludeCareDto(int reqId, String providerNote, boolean isFinalize) {
		super();
		this.reqId = reqId;
		this.providerNote = providerNote;
		this.isFinalize = isFinalize;
	}
	public ConcludeCareDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
