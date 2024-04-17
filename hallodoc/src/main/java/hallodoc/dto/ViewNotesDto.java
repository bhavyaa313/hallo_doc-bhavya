package hallodoc.dto;

public class ViewNotesDto {
	
	private String adminNote;
	private String physicianNote;
	private String transferNote;
	private String adminCancellationNote;
	private String patientCancellationNote;
	private String additionalNote;

	
	public ViewNotesDto(String adminNote, String physicianNote, String transferNote, String adminCancellationNote,
			String patientCancellationNote, String additionalNote) {
		super();
		this.adminNote = adminNote;
		this.physicianNote = physicianNote;
		this.transferNote = transferNote;
		this.adminCancellationNote = adminCancellationNote;
		this.patientCancellationNote = patientCancellationNote;
		this.additionalNote = additionalNote;
	}
	public String getAdminNote() {
		return adminNote;
	}
	public void setAdminNote(String adminNote) {
		this.adminNote = adminNote;
	}
	public String getPhysicianNote() {
		return physicianNote;
	}
	public void setPhysicianNote(String physicianNote) {
		this.physicianNote = physicianNote;
	}

	public String getTransferNote() {
		return transferNote;
	}
	public void setTransferNote(String transferNote) {
		this.transferNote = transferNote;
	}
	public String getAdminCancellationNote() {
		return adminCancellationNote;
	}
	public void setAdminCancellationNote(String adminCancellationNote) {
		this.adminCancellationNote = adminCancellationNote;
	}
	public String getPatientCancellationNote() {
		return patientCancellationNote;
	}
	public void setPatientCancellationNote(String patientCancellationNote) {
		this.patientCancellationNote = patientCancellationNote;
	}
	public String getAdditionalNote() {
		return additionalNote;
	}
	public void setAdditionalNote(String additionalNote) {
		this.additionalNote = additionalNote;
	}
	public ViewNotesDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	

}
