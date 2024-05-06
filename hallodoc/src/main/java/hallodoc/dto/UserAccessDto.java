package hallodoc.dto;

import org.apache.logging.log4j.util.StringBuilderFormattable;

public class UserAccessDto {
	
	private String accounttype;
	private String name;
	private String phone;
	private String city;
	private String status;
	private Long openRequests;
	private int userId;
	public String getAccounttype() {
		return accounttype;
	}
	public void setAccounttype(String accounttype) {
		this.accounttype = accounttype;
	}
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
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public long getOpenRequests() {
		return openRequests;
	}
	public void setOpenRequests(long openRequests) {
		this.openRequests = openRequests;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public UserAccessDto(String accounttype, String name, String phone, String city, String status, long openRequests,
			int userId) {
		super();
		this.accounttype = accounttype;
		this.name = name;
		this.phone = phone;
		this.city = city;
		this.status = status;
		this.openRequests = openRequests;
		this.userId = userId;
	}
	public UserAccessDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
