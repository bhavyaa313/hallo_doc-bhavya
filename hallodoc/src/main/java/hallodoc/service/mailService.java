package hallodoc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;


@Service
public class mailService {
	  @Autowired
	    private JavaMailSender mailSender;
	     
	

	
	public void send( String tomail, String subject, String message) {
		
		 SimpleMailMessage email = new SimpleMailMessage();
	        email.setFrom("bhavya.shah313@outlook.com");
	        email.setTo(tomail);
	        email.setSubject(subject);
	        email.setText(message);
	         
	        // sends the e-mail
	        mailSender.send(email);
		
	}
}
