package hallodoc.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "block_requests")
public class BlockRequests {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "block_request_id")
	private int  blockRequestId;
	private String phone_number;
	private String email;
	private boolean is_active;
	private String reason;
	@OneToOne
	@JoinColumn(name = "request_id")
	private Request request_id;
	private LocalDateTime created_date;
	private LocalDateTime modified_date;
	
	
	public int getBlockRequestId() {
		return blockRequestId;
	}
	public void setBlockRequestId(int blockRequestId) {
		this.blockRequestId = blockRequestId;
	}
	public String getPhone_number() {
		return phone_number;
	}
	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public boolean isIs_active() {
		return is_active;
	}
	public void setIs_active(boolean is_active) {
		this.is_active = is_active;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	
	public Request getRequest_id() {
		return request_id;
	}
	public void setRequest_id(Request request_id) {
		this.request_id = request_id;
	}
	public LocalDateTime getCreated_date() {
		return created_date;
	}
	public void setCreated_date(LocalDateTime created_date) {
		this.created_date = created_date;
	}
	public LocalDateTime getModified_date() {
		return modified_date;
	}
	public void setModified_date(LocalDateTime modified_date) {
		this.modified_date = modified_date;
	}
	
	
	
	
	public BlockRequests(int blockRequestId, String phone_number, String email, boolean is_active, String reason,
			Request request_id, LocalDateTime created_date, LocalDateTime modified_date) {
		super();
		this.blockRequestId = blockRequestId;
		this.phone_number = phone_number;
		this.email = email;
		this.is_active = is_active;
		this.reason = reason;
		this.request_id = request_id;
		this.created_date = created_date;
		this.modified_date = modified_date;
	}
	public BlockRequests() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
