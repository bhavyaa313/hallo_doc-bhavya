package hallodoc.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.xml.crypto.Data;

import org.springframework.lang.NonNull;


@Entity
public class asp_net_users {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(nullable = false)
	private int id;
	private String password_hash;
	private String email;
	private String phone_number;
	private Date modified_date;
	@Column(nullable = false)
	private String user_name;
	@Column(nullable = false)
	private Date created_date;
	public String getPasswrod_hash() {
		return password_hash;
	}
	public void setPasswrod_hash(String passwrod_hash) {
		this.password_hash = passwrod_hash;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone_number() {
		return phone_number;
	}
	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}
	public Date getModified_date() {
		return modified_date;
	}
	public void setModified_date(Date modified_date) {
		this.modified_date = modified_date;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public Date getCreated_date() {
		return created_date;
	}
	public void setCreated_date(Date created_date) {
		this.created_date = created_date;
	}
	
	
	
	
	
	public asp_net_users(int id, String passwrod_hash, String email, String phone_number, Date modified_date,
			String user_name, Date created_date) {
		super();
		this.id = id;
		this.password_hash = passwrod_hash;
		this.email = email;
		this.phone_number = phone_number;
		this.modified_date = modified_date;
		this.user_name = user_name;
		this.created_date = created_date;
	}
	@Override
	public String toString() {
		return "asp_net_users [id=" + id + ", password_hash=" + password_hash + ", email=" + email + ", phone_number="
				+ phone_number + ", modified_date=" + modified_date + ", user_name=" + user_name + ", created_date="
				+ created_date + "]";
	}
	
	

}
