package hallodoc.controller;


import java.util.Map;


import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.support.RequestContextUtils;

import hallodoc.dto.CoincergeDto;
import hallodoc.dto.FamilyInfoDto;
import hallodoc.dto.PatientInfoDto;
import hallodoc.model.DummyForgot;
import hallodoc.model.Users;
import hallodoc.service.CoincergeService;
import hallodoc.service.CreateService;
import hallodoc.service.FamilyInfoService;
import hallodoc.service.PatientInfoService;
import hallodoc.service.UsersService;



@Controller
public class MainController {
	

	public boolean test=false;
	
	@Autowired
	private PatientInfoService patientInfoService;
	@Autowired
	private FamilyInfoService familyInfoService;
	@Autowired
	private CoincergeService coincergeService;
	

	@Autowired
	private UsersService login;

	@Autowired
	private CreateService create;

	@RequestMapping("/login")
	public String login(HttpServletRequest request, Model model) {

		Map<String, ?> inputFlashMap = RequestContextUtils.getInputFlashMap(request);
		if (inputFlashMap != null) {
			String value = (String) inputFlashMap.get("msg");
			model.addAttribute("msg", value);
			System.out.println(value);
		}

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

	@RequestMapping("/mail")
	public String mail() {

		return "SendMail";

	}
	


	@RequestMapping(path = "/handleform", method = RequestMethod.POST)
	public String formHandler(@ModelAttribute Users users, RedirectAttributes ra, Model model) {

		boolean status = login.checkEmail(users.getUserEmail(), users.getUserPassword());
		String message;
		System.out.println(status);
		if (status) {
			System.out.println(" authenticated");

			return "patient_dashboard";
		} else {
			System.out.println(" not authenticated");

			/* model.addAttribute("message", "***wrong credentials"); */
			ra.addFlashAttribute("message", "***wrong credentials");
			return "redirect://login";

		}

	}

	@RequestMapping(path = "/passwordHandler", method = RequestMethod.POST)
	public String passwordHandler(@ModelAttribute DummyForgot forgot, Model model) {

		String x = forgot.getPassword();
		String y = forgot.getConfirm_password();
		System.out.println(x);
		System.out.println(y);

		if (x == y) {
			model.addAttribute("success", "password changed");

			return "patient_reset";

		} else {
			model.addAttribute("invalid", "passwords are not matching ");

			return "patient_reset";
		}

	}

	@PostMapping(path = "/ajax")
	@ResponseBody
	public String checkAJAX(@RequestParam("name") String mail) {

		boolean ans = create.ajaxCheck(mail);

		if (ans) {
			test = true;
			return "success";
		} else {
			return "unsuccess";
		}
	}
	
	
	@RequestMapping(path="/insert", method = RequestMethod.POST)
	public String PatientData(@ModelAttribute PatientInfoDto patientInfoDto)
	{
		patientInfoService.service(patientInfoDto);
		return "patient_login";
	}
	
	@RequestMapping(path="/familyInfo", method = RequestMethod.POST)
	public String PatientDataFamily(@ModelAttribute FamilyInfoDto familyInfoDto)
	{
		System.out.println("done");
		familyInfoService.service(familyInfoDto);
		return "patient_login";
	}
	
	@RequestMapping(path="/conciergeInfo", method = RequestMethod.POST)
	public String PatientDataConcierge(@ModelAttribute CoincergeDto coincergeDto)
	{
		System.out.println("done");
		coincergeService.service(coincergeDto);
		System.out.println(coincergeDto.getZipcode());
		System.out.println(coincergeDto.getPlastName());
		return "patient_login";
	}
	
	

}
