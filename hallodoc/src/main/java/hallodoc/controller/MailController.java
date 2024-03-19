package hallodoc.controller;


import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import hallodoc.service.UsersService;
import hallodoc.service.mailService;
 
@Controller
@RequestMapping("/sendEmail")
public class MailController {
 

     
	
	@Autowired
	private mailService itMailService;
		
    @RequestMapping( method = RequestMethod.POST)
    public String doSendEmail(HttpServletRequest request) {
        // takes input from e-mail form
        String recipientAddress = request.getParameter("recipient");
        String subject = "email reset";
        String message = "http://localhost:8080/hallodoc/reset";
         
        // prints debug info
        System.out.println("To: " + recipientAddress);
        System.out.println("Subject: " + subject);
        System.out.println("Message: " + message);
         
        // creates a simple e-mail object
		
        
        this.itMailService.send(recipientAddress, subject, message);
         
        // forwards to the view named "Result"
        return "patient_login";
    }
}