package hallodoc.dto;

public class BlockRecordsDto {
	
	private String name;
	private String phone;
	private String email;
	private String date;
	private String note;
	private Boolean isActive;
	private int reqId;
	private int bId;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public Boolean getIsActive() {
		return isActive;
	}
	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}
	public int getReqId() {
		return reqId;
	}
	public void setReqId(int reqId) {
		this.reqId = reqId;
	}
	
	
	public int getbId() {
		return bId;
	}
	public void setbId(int bId) {
		this.bId = bId;
	}
	
	public BlockRecordsDto(String name, String phone, String email, String date, String note, Boolean isActive,
			int reqId, int bId) {
		super();
		this.name = name;
		this.phone = phone;
		this.email = email;
		this.date = date;
		this.note = note;
		this.isActive = isActive;
		this.reqId = reqId;
		this.bId = bId;
	}
	public BlockRecordsDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
