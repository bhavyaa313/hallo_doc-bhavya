package hallodoc.enums;

public enum RegionEnum {

	GUJARAT(1, "GJ"), MAHARASHTRA(2, "MH"), MADHYAPRADESH(3, "MP"), RAJASTHAN(4, "RJ");

	private int id;
	private String abbr;

	private RegionEnum(int id, String abbr) {
		this.id = id;
		this.abbr = abbr;
	}
	
	public int getid() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAbbr() {
		return abbr;
	}

	public void setAbbr(String abbr) {
		this.abbr = abbr;
	}
	


}