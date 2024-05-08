package hallodoc.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hallodoc.dto.SendLinkDto;
import hallodoc.model.EmailLog;
import hallodoc.repo.EmailLogDao;

@Service
public class SendLinkService {
	
	
	@Autowired
	private mailService mailService;
	
	@Autowired
	private EmailLogDao emailLogDao;
	
	public void service(SendLinkDto sendLinkDto)
	
	{
		String emailString = sendLinkDto.getEmailsend();
		String mailUrl = "http://localhost:8080/hallodoc/select";
		mailService.send(emailString, "Submit request", mailUrl);
		EmailLog emailLog = new EmailLog();
		emailLog.setCreated_date(LocalDateTime.now());
		emailLog.setAdmin_id(1);
		emailLog.setEmail_id(emailString);
		emailLog.setSubject_name("Submit Request");
		emailLog.setSent_tries(1);
		emailLog.setIs_email_sent(true);
		emailLog.setSent_date(LocalDateTime.now()
				);
		emailLogDao.emailLogSave(emailLog);
	}
	
public void sendAgreementService(String email, int reqId)
	
	{
	
		String mailUrl = "http://localhost:8080/hallodoc/agreement/"+reqId;
		mailService.send(email, "Please read the following agreement properly", mailUrl);
		EmailLog emailLog = new EmailLog();
		emailLog.setCreated_date(LocalDateTime.now());
		emailLog.setAdmin_id(1);
		emailLog.setEmail_id(email);
		emailLog.setSent_tries(1);
		emailLog.setSent_date(LocalDateTime.now());
		emailLog.setIs_email_sent(true);
		emailLog.setSubject_name("Submit Request");
		emailLogDao.emailLogSave(emailLog);
	}

public void contctProvider(SendLinkDto sendLinkDto)

{
	String emailString = sendLinkDto.getEmailsend();
	String mailUrl = "http://localhost:8080/hallodoc/select";
	mailService.send(emailString, "Contact Provider", mailUrl);
	EmailLog emailLog = new EmailLog();
	emailLog.setCreated_date(LocalDateTime.now());
	emailLog.setAdmin_id(1);
	emailLog.setRecipient("admin");
	emailLog.setEmail_id(emailString);
	emailLog.setSubject_name("Contact Provider");
	emailLog.setSent_tries(1);
	emailLog.setIs_email_sent(true);
	emailLog.setSent_date(LocalDateTime.now()
			);
	emailLogDao.emailLogSave(emailLog);
}

	
	

}
