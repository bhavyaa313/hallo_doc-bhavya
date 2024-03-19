package hallodoc.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "physician_notification")
public class PhysicianNotification {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private int physician_id;
	private boolean is_notification_stopped;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getPhysician_id() {
		return physician_id;
	}
	public void setPhysician_id(int physician_id) {
		this.physician_id = physician_id;
	}
	public boolean isIs_notification_stopped() {
		return is_notification_stopped;
	}
	public void setIs_notification_stopped(boolean is_notification_stopped) {
		this.is_notification_stopped = is_notification_stopped;
	}
	@Override
	public String toString() {
		return "PhysicianNotification [id=" + id + ", physician_id=" + physician_id + ", is_notification_stopped="
				+ is_notification_stopped + "]";
	}
	public PhysicianNotification(int id, int physician_id, boolean is_notification_stopped) {
		super();
		this.id = id;
		this.physician_id = physician_id;
		this.is_notification_stopped = is_notification_stopped;
	}
	public PhysicianNotification() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
}
