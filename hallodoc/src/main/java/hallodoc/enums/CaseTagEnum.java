package hallodoc.enums;

public enum CaseTagEnum {

	ONE(1, "No Response to call or text, left message"), TWO(2, "Cost Issue"), THREE(3, "Insurance Issue"),
	FOUR(4, "Out of service area"), FIVE(5, "Not appropriate for service"), SIX(6, "Referral to clinic or hospital");

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

	private CaseTagEnum(int id, String reason) {
		this.id = id;
		this.reason = reason;
	}

}
