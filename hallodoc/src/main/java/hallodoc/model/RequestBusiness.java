package hallodoc.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "request_business")
public class RequestBusiness {

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "request_concierge_id")
	private int requestBusinessId;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "request_id")
	private Request requestId;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "business_id")
	private Business businessId;
	public RequestBusiness(int requestBusinessId, Request requestId, Business businessId) {
		super();
		this.requestBusinessId = requestBusinessId;
		this.requestId = requestId;
		this.businessId = businessId;
	}
	public int getRequestBusinessId() {
		return requestBusinessId;
	}
	public void setRequestBusinessId(int requestBusinessId) {
		this.requestBusinessId = requestBusinessId;
	}
	public Request getRequestId() {
		return requestId;
	}
	public void setRequestId(Request requestId) {
		this.requestId = requestId;
	}
	public Business getBusinessId() {
		return businessId;
	}
	public void setBusinessId(Business businessId) {
		this.businessId = businessId;
	}
	public RequestBusiness() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
