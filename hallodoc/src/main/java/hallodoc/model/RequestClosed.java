package hallodoc.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.boot.model.naming.ImplicitNameSource;

@Entity
@Table(name = "request_closed")
public class RequestClosed {
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private int request_closed_id;
private int request_id;
private int request_status_log_id;
private String phy_notes;
private String client_notes;
public RequestClosed() {
	super();
	// TODO Auto-generated constructor stub
}
public RequestClosed(int request_closed_id, int request_id, int request_status_log_id, String phy_notes,
		String client_notes) {
	super();
	this.request_closed_id = request_closed_id;
	this.request_id = request_id;
	this.request_status_log_id = request_status_log_id;
	this.phy_notes = phy_notes;
	this.client_notes = client_notes;
}
public int getRequest_closed_id() {
	return request_closed_id;
}
public void setRequest_closed_id(int request_closed_id) {
	this.request_closed_id = request_closed_id;
}
public int getRequest_id() {
	return request_id;
}
public void setRequest_id(int request_id) {
	this.request_id = request_id;
}
public int getRequest_status_log_id() {
	return request_status_log_id;
}
public void setRequest_status_log_id(int request_status_log_id) {
	this.request_status_log_id = request_status_log_id;
}
public String getPhy_notes() {
	return phy_notes;
}
public void setPhy_notes(String phy_notes) {
	this.phy_notes = phy_notes;
}
public String getClient_notes() {
	return client_notes;
}
public void setClient_notes(String client_notes) {
	this.client_notes = client_notes;
}
@Override
public String toString() {
	return "RequestClosed [request_closed_id=" + request_closed_id + ", request_id=" + request_id
			+ ", request_status_log_id=" + request_status_log_id + ", phy_notes=" + phy_notes + ", client_notes="
			+ client_notes + "]";
}

}
