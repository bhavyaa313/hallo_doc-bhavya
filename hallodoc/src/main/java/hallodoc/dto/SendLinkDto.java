package hallodoc.dto;

public class SendLinkDto {
	
	private String emailsend;

	public String getEmailsend() {
		return emailsend;
	}

	public void setEmailsend(String emailsend) {
		this.emailsend = emailsend;
	}

	public SendLinkDto(String emailsend) {
		super();
		this.emailsend = emailsend;
	}

	public SendLinkDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
