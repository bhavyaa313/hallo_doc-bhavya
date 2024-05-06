package hallodoc.controller;
import java.util.Properties;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

@Configuration
public class EmailConfig {
	
	@Bean
	public JavaMailSender getJavaMailSender() {
	    JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
		mailSender.setHost("smtp.office365.com"); 
		/* mailSender.setHost("smtp.gmail.com"); */
	    mailSender.setPort(587);
	    
	    mailSender.setUsername("bhavya.shah313@outlook.com");
	    mailSender.setPassword("dontopen313");
	    
	    Properties props = mailSender.getJavaMailProperties();
	    props.put("mail.transport.protocol", "smtp");
	    props.put("mail.smtp.auth", "true");
	    props.put("mail.smtp.starttls.enable", "true");
	    props.put("mail.debug", "true");
	    props.setProperty("mail.smtp.ssl.protocols", "TLSv1.2");
	    props.put("mail.smtp.ssl.trust", "smtp.office365.com");
	    props.put("mail.smtp.starttls.required", "true");
	    return mailSender;
	}

}
