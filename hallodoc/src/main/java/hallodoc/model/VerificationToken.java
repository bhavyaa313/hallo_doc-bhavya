package hallodoc.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "verification_token")
public class VerificationToken {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String token;
	private String email;
	private LocalDateTime created_date;
	private boolean validation;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public LocalDateTime getCreated_date() {
		return created_date;
	}
	public void setCreated_date(LocalDateTime created_date) {
		this.created_date = created_date;
	}
	public boolean isValidation() {
		return validation;
	}
	public void setValidation(boolean validation) {
		this.validation = validation;
	}
	public VerificationToken(int id, String token, String email, LocalDateTime created_date, boolean validation) {
		super();
		this.id = id;
		this.token = token;
		this.email = email;
		this.created_date = created_date;
		this.validation = validation;
	}
	public VerificationToken() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
	

}
