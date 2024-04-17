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
		emailLogDao.emailLogSave(emailLog);
	}
	

}
