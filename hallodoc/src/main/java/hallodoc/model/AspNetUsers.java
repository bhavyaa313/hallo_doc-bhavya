package hallodoc.model;

import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="asp_net_users")
public class AspNetUsers {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column(name = "user_name")
	private String userName;
	
	@Column(name = "password_hash")
	private String passwordHash;

	private String email;
	
	@Column(name = "phone_number")
	private String phoneNumber;
	
	@Column(name = "modified_date")
	private LocalDateTime modifiedDate;
	
	/*
	 * @OneToOne(mappedBy = "aspnetUserId", cascade = CascadeType.ALL, orphanRemoval
	 * = true)
	 * 
	 * private Admin admin;
	 */
	
	@Column(name = "created_date")
	private LocalDateTime createdDate=LocalDateTime.now();

	
	public AspNetUsers() {
		super();
		// TODO Auto-generated constructor stub
	}







	public AspNetUsers(int id, String userName, String passwordHash, String email, String phoneNumber,
			LocalDateTime modifiedDate,  LocalDateTime createdDate) {
		super();
		this.id = id;
		this.userName = userName;
		this.passwordHash = passwordHash;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.modifiedDate = modifiedDate;
	
		this.createdDate = createdDate;
	}







	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPasswordHash() {
		return passwordHash;
	}

	public void setPasswordHash(String passwordHash) {
		this.passwordHash = passwordHash;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	

	public LocalDateTime getModifiedDate() {
		return modifiedDate;
	}
	
	





	public LocalDateTime getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(LocalDateTime cdate) {
		this.createdDate = cdate;
	}


	public void setModifiedDate(LocalDateTime now) {
		// TODO Auto-generated method stub
		
	}
	
}
