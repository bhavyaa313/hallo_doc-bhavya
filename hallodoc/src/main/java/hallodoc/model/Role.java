package hallodoc.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "role")
public class Role {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int role_id;
	private String name;
	private int account_type;
	private int created_by;
	private LocalDateTime created_date;
	private int modified_by;
	private LocalDateTime modified_date;
	private boolean is_deleted;
	public Role() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Role(int role_id, String name, int account_type, int created_by, LocalDateTime created_date, int modified_by,
			LocalDateTime modified_date, boolean is_deleted) {
		super();
		this.role_id = role_id;
		this.name = name;
		this.account_type = account_type;
		this.created_by = created_by;
		this.created_date = created_date;
		this.modified_by = modified_by;
		this.modified_date = modified_date;
		this.is_deleted = is_deleted;
	}
	public int getRole_id() {
		return role_id;
	}
	public void setRole_id(int role_id) {
		this.role_id = role_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAccount_type() {
		return account_type;
	}
	public void setAccount_type(int account_type) {
		this.account_type = account_type;
	}
	public int getCreated_by() {
		return created_by;
	}
	public void setCreated_by(int created_by) {
		this.created_by = created_by;
	}
	public LocalDateTime getCreated_date() {
		return created_date;
	}
	public void setCreated_date(LocalDateTime created_date) {
		this.created_date = created_date;
	}
	public int getModified_by() {
		return modified_by;
	}
	public void setModified_by(int modified_by) {
		this.modified_by = modified_by;
	}
	public LocalDateTime getModified_date() {
		return modified_date;
	}
	public void setModified_date(LocalDateTime modified_date) {
		this.modified_date = modified_date;
	}
	public boolean isIs_deleted() {
		return is_deleted;
	}
	public void setIs_deleted(boolean is_deleted) {
		this.is_deleted = is_deleted;
	}
	@Override
	public String toString() {
		return "Role [role_id=" + role_id + ", name=" + name + ", account_type=" + account_type + ", created_by="
				+ created_by + ", created_date=" + created_date + ", modified_by=" + modified_by + ", modified_date="
				+ modified_date + ", is_deleted=" + is_deleted + "]";
	}
	
}
