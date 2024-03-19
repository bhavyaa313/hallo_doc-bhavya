package hallodoc.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "health_professional_type")
public class HealthProfessionalType {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int health_professional_id;
	private String profession_name;
	private LocalDateTime created_date;
	private boolean is_active;
	private boolean is_deleted;
	
	public int getHealth_professional_id() {
		return health_professional_id;
	}
	public void setHealth_professional_id(int health_professional_id) {
		this.health_professional_id = health_professional_id;
	}
	public String getProfession_name() {
		return profession_name;
	}
	public void setProfession_name(String profession_name) {
		this.profession_name = profession_name;
	}
	public LocalDateTime getCreated_date() {
		return created_date;
	}
	public void setCreated_date(LocalDateTime created_date) {
		this.created_date = created_date;
	}
	public boolean isIs_active() {
		return is_active;
	}
	public void setIs_active(boolean is_active) {
		this.is_active = is_active;
	}
	public boolean isIs_deleted() {
		return is_deleted;
	}
	public void setIs_deleted(boolean is_deleted) {
		this.is_deleted = is_deleted;
	}
	
	public HealthProfessionalType(int health_professional_id, String profession_name, LocalDateTime created_date,
			boolean is_active, boolean is_deleted) {
		super();
		this.health_professional_id = health_professional_id;
		this.profession_name = profession_name;
		this.created_date = created_date;
		this.is_active = is_active;
		this.is_deleted = is_deleted;
	}
	
	public HealthProfessionalType() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String toString() {
		return "HealthProfessionalType [health_professional_id=" + health_professional_id + ", profession_name="
				+ profession_name + ", created_date=" + created_date + ", is_active=" + is_active + ", is_deleted="
				+ is_deleted + "]";
	}
	
}
