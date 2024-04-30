package hallodoc.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "email_log")
public class EmailLog {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int email_log_id;
	public String recipient;
	private String subject_name;
	private String email_id;
	private String confirmation_number;
	private int role_id;
	private int request_id;
	private int admin_id;
	private int physician_id;
	private LocalDateTime created_date;
	private LocalDateTime sent_date;
	private boolean is_email_sent;
	private int sent_tries;
	private String action;
	
	public int getEmail_log_id() {
		return email_log_id;
	}
	public void setEmail_log_id(int email_log_id) {
		this.email_log_id = email_log_id;
	}
	public String getSubject_name() {
		return subject_name;
	}
	public void setSubject_name(String subject_name) {
		this.subject_name = subject_name;
	}
	public String getEmail_id() {
		return email_id;
	}
	public void setEmail_id(String email_id) {
		this.email_id = email_id;
	}
	public String getConfirmation_number() {
		return confirmation_number;
	}
	
	
	public String getRecipient() {
		return recipient;
	}
	public void setRecipient(String recipient) {
		this.recipient = recipient;
	}
	public void setConfirmation_number(String confirmation_number) {
		this.confirmation_number = confirmation_number;
	}
	public int getRole_id() {
		return role_id;
	}
	public void setRole_id(int role_id) {
		this.role_id = role_id;
	}
	public int getRequest_id() {
		return request_id;
	}
	public void setRequest_id(int request_id) {
		this.request_id = request_id;
	}
	public int getAdmin_id() {
		return admin_id;
	}
	public void setAdmin_id(int admin_id) {
		this.admin_id = admin_id;
	}
	public int getPhysician_id() {
		return physician_id;
	}
	public void setPhysician_id(int physician_id) {
		this.physician_id = physician_id;
	}
	public LocalDateTime getCreated_date() {
		return created_date;
	}
	public void setCreated_date(LocalDateTime created_date) {
		this.created_date = created_date;
	}
	public LocalDateTime getSent_date() {
		return sent_date;
	}
	public void setSent_date(LocalDateTime sent_date) {
		this.sent_date = sent_date;
	}
	public boolean isIs_email_sent() {
		return is_email_sent;
	}
	public void setIs_email_sent(boolean is_email_sent) {
		this.is_email_sent = is_email_sent;
	}
	public int getSent_tries() {
		return sent_tries;
	}
	public void setSent_tries(int sent_tries) {
		this.sent_tries = sent_tries;
	}
	public String getAction() {
		return action;
	}
	public void setAction(String action) {
		this.action = action;
	}
	
	
	
	public EmailLog() {
		super();
		// TODO Auto-generated constructor stub
	}
	public EmailLog(int email_log_id, String recipient, String subject_name, String email_id,
			String confirmation_number, int role_id, int request_id, int admin_id, int physician_id,
			LocalDateTime created_date, LocalDateTime sent_date, boolean is_email_sent, int sent_tries, String action) {
		super();
		this.email_log_id = email_log_id;
		this.recipient = recipient;
		this.subject_name = subject_name;
		this.email_id = email_id;
		this.confirmation_number = confirmation_number;
		this.role_id = role_id;
		this.request_id = request_id;
		this.admin_id = admin_id;
		this.physician_id = physician_id;
		this.created_date = created_date;
		this.sent_date = sent_date;
		this.is_email_sent = is_email_sent;
		this.sent_tries = sent_tries;
		this.action = action;
	}
	

}
