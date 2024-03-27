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
@Table(name = "request_concierge")
public class RequestConcierge {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "request_concierge_id")
	private int requestConciergeId;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "request_id")
	private Request requestId;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "coincerge_id")
	private Concierge conciergeId;
	public int getRequestConciergeId() {
		return requestConciergeId;
	}
	public void setRequestConciergeId(int requestConciergeId) {
		this.requestConciergeId = requestConciergeId;
	}
	public Request getRequestId() {
		return requestId;
	}
	public void setRequestId(Request requestId) {
		this.requestId = requestId;
	}
	public Concierge getConciergeId() {
		return conciergeId;
	}
	public void setConciergeId(Concierge conciergeId) {
		this.conciergeId = conciergeId;
	}
	public RequestConcierge(int requestConciergeId, Request requestId, Concierge conciergeId) {
		super();
		this.requestConciergeId = requestConciergeId;
		this.requestId = requestId;
		this.conciergeId = conciergeId;
	}
	public RequestConcierge() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	

}
