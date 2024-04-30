package hallodoc.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "request_type")
public class RequestType {
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
@Column(name = "request_type_id")
private int requestTypeID;
private String name;
public int getRequestTypeID() {
	return requestTypeID;
}
public void setRequestTypeID(int requestTypeID) {
	this.requestTypeID = requestTypeID;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public RequestType(int requestTypeID, String name) {
	super();
	this.requestTypeID = requestTypeID;
	this.name = name;
}
@Override
public String toString() {
	return "RequestType [requestTypeID=" + requestTypeID + ", name=" + name + "]";
}
public RequestType() {
	super();
	// TODO Auto-generated constructor stub
}






}
