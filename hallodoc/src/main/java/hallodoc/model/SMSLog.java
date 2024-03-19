package hallodoc.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "sms_log")
public class SMSLog {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int sms_log_id;
	private String mobile_number;
	private String confirmation_number;
	private int role_id;
	private int admin_id;
	private int request_id;
	private int physician_id;
	private Date create_date;
	private Date sent_date;
	private boolean is_sms_sent;
	private int sent_tries;
	private String action;
	public int getSms_log_id() {
		return sms_log_id;
	}
	public void setSms_log_id(int sms_log_id) {
		this.sms_log_id = sms_log_id;
	}
	public String getMobile_number() {
		return mobile_number;
	}
	public void setMobile_number(String mobile_number) {
		this.mobile_number = mobile_number;
	}
	public String getConfirmation_number() {
		return confirmation_number;
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
	public int getAdmin_id() {
		return admin_id;
	}
	public void setAdmin_id(int admin_id) {
		this.admin_id = admin_id;
	}
	public int getRequest_id() {
		return request_id;
	}
	public void setRequest_id(int request_id) {
		this.request_id = request_id;
	}
	public int getPhysician_id() {
		return physician_id;
	}
	public void setPhysician_id(int physician_id) {
		this.physician_id = physician_id;
	}
	public Date getCreate_date() {
		return create_date;
	}
	public void setCreate_date(Date create_date) {
		this.create_date = create_date;
	}
	public Date getSent_date() {
		return sent_date;
	}
	public void setSent_date(Date sent_date) {
		this.sent_date = sent_date;
	}
	public boolean isIs_sms_sent() {
		return is_sms_sent;
	}
	public void setIs_sms_sent(boolean is_sms_sent) {
		this.is_sms_sent = is_sms_sent;
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
	public SMSLog(int sms_log_id, String mobile_number, String confirmation_number, int role_id, int admin_id,
			int request_id, int physician_id, Date create_date, Date sent_date, boolean is_sms_sent, int sent_tries,
			String action) {
		super();
		this.sms_log_id = sms_log_id;
		this.mobile_number = mobile_number;
		this.confirmation_number = confirmation_number;
		this.role_id = role_id;
		this.admin_id = admin_id;
		this.request_id = request_id;
		this.physician_id = physician_id;
		this.create_date = create_date;
		this.sent_date = sent_date;
		this.is_sms_sent = is_sms_sent;
		this.sent_tries = sent_tries;
		this.action = action;
	}
	public SMSLog() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "SMSLog [sms_log_id=" + sms_log_id + ", mobile_number=" + mobile_number + ", confirmation_number="
				+ confirmation_number + ", role_id=" + role_id + ", admin_id=" + admin_id + ", request_id=" + request_id
				+ ", physician_id=" + physician_id + ", create_date=" + create_date + ", sent_date=" + sent_date
				+ ", is_sms_sent=" + is_sms_sent + ", sent_tries=" + sent_tries + ", action=" + action
				+ ", getSms_log_id()=" + getSms_log_id() + ", getMobile_number()=" + getMobile_number()
				+ ", getConfirmation_number()=" + getConfirmation_number() + ", getRole_id()=" + getRole_id()
				+ ", getAdmin_id()=" + getAdmin_id() + ", getRequest_id()=" + getRequest_id() + ", getPhysician_id()="
				+ getPhysician_id() + ", getCreate_date()=" + getCreate_date() + ", getSent_date()=" + getSent_date()
				+ ", isIs_sms_sent()=" + isIs_sms_sent() + ", getSent_tries()=" + getSent_tries() + ", getAction()="
				+ getAction() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}
	
	
}
