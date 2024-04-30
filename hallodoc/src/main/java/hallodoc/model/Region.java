package hallodoc.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import hallodoc.enums.RegionEnum;


@Entity
@Table(name = "region")
public class Region {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "region_id")
	private int regionId;
	private String name;
	private String abbreviation;
	
	

	
	
	
	
	public int getRegionId() {
		return regionId;
	}
	public void setRegionId(int regionId) {
		this.regionId = regionId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAbbreviation() {
		return abbreviation;
	}
	public void setAbbreviation(String abbreviation) {
		this.abbreviation = abbreviation;
	}
	@Override
	public String toString() {
		return "Region [regionId=" + regionId + ", name=" + name + ", abbreviation=" + abbreviation + "]";
	}
	public Region(int regionId, String name, String abbreviation) {
		super();
		this.regionId = regionId;
		this.name = name;
		this.abbreviation = abbreviation;
	}
	public Region() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	
}
