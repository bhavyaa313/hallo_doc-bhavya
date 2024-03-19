package hallodoc.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "request_business")
public class RequestBusiness {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int request_business_id;
	private int request_id;
	private int business_id;
	
	public int getRequest_business_id() {
		return request_business_id;
	}
	public void setRequest_business_id(int request_business_id) {
		this.request_business_id = request_business_id;
	}
	public int getRequest_id() {
		return request_id;
	}
	public void setRequest_id(int request_id) {
		this.request_id = request_id;
	}
	public int getBusiness_id() {
		return business_id;
	}
	public void setBusiness_id(int business_id) {
		this.business_id = business_id;
	}
	
	public RequestBusiness(int request_business_id, int request_id, int business_id) {
		super();
		this.request_business_id = request_business_id;
		this.request_id = request_id;
		this.business_id = business_id;
	}
	
	public RequestBusiness() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String toString() {
		return "RequestBusiness [request_business_id=" + request_business_id + ", request_id=" + request_id
				+ ", business_id=" + business_id + "]";
	}
	
}
