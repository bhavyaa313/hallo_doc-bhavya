package hallodoc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import hallodoc.model.User;
import hallodoc.model.asp_net_users;
import hallodoc.service.UserService;

@Controller
public class MainController {

	@Autowired
	private UserService login;
		
	
	
	@RequestMapping("/login")
	public String login() {
		
		return "patient_login";
		
	}
	
	
	@RequestMapping("/forgot")
	public String forgot() {
		
		return "forgot_password";
		
	}
	
	@RequestMapping("/reset")
	public String reset() {
		
		return "patient_reset";
		
	}
	
	@RequestMapping("/select")
	public String select() {
		
		return "select_role_patient";
		
	}
	
	
	@RequestMapping("/patient")
	public String patient_info() {
		
		return "patient_info";
		
	}
	
	@RequestMapping("/family")
	public String family() {
		
		return "family_info";
		
	}
	@RequestMapping("/business")
	public String business() {
		
		return "business_info";
		
	}
	@RequestMapping("/coincerge")
	public String coincerge() {
		
		return "coincerge_info";
		
	}

	
	@RequestMapping(path = "/handleform", method = RequestMethod.POST )
	public String formHandler(@ModelAttribute User user, Model model)  {
		
		boolean status = this.login.checkEmail(user.getUserEmail(), user.getUserPassword());
String message;
System.out.println(status);
	    if(status) {
	    	System.out.println(" authenticated");
	        message = "Login Successful";
	    	return "patient_dashboard";
	    }
	    else {
	    	System.out.println(" not authenticated");
	        message = "Login Unsuccessful";
	        return "patient_login";
	        
	    }

		/* model.addAttribute("message", message);*/

		
		
		
	}
	

	
}
