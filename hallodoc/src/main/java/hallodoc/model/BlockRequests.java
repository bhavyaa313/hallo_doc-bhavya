package hallodoc.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "block_requests")
public class BlockRequests {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int block_request_id;
	private String phone_number;
	private String email;
	private boolean is_active;
	private String reason;
	private int request_id;
	private LocalDateTime created_date;
	private LocalDateTime modified_date;
	
	public int getBlock_request_id() {
		return block_request_id;
	}
	public void setBlock_request_id(int block_request_id) {
		this.block_request_id = block_request_id;
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
	public int getRequest_id() {
		return request_id;
	}
	public void setRequest_id(int request_id) {
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
	
	public BlockRequests(int block_request_id, String phone_number, String email, boolean is_active, String reason,
			int request_id, LocalDateTime created_date, LocalDateTime modified_date) {
		super();
		this.block_request_id = block_request_id;
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
	
	@Override
	public String toString() {
		return "BlockRequests [block_request_id=" + block_request_id + ", phone_number=" + phone_number + ", email="
				+ email + ", is_active=" + is_active + ", reason=" + reason + ", request_id=" + request_id
				+ ", created_date=" + created_date + ", modified_date=" + modified_date + "]";
	}
	
}
