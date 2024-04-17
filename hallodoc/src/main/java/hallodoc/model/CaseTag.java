package hallodoc.model;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "case_tag")
public class CaseTag {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String reason;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public CaseTag(int id, String reason) {
		super();
		this.id = id;
		this.reason = reason;
	}
	public CaseTag() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	

}
