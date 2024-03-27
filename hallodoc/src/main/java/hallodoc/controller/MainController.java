package hallodoc.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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


import hallodoc.dto.BusinessDto;
import hallodoc.dto.CoincergeDto;
import hallodoc.dto.CreateAccountDto;
import hallodoc.dto.FamilyInfoDto;
import hallodoc.dto.PatientInfoDto;
import hallodoc.helper.emailHelper;
import hallodoc.model.DummyForgot;
import hallodoc.model.Users;

import hallodoc.service.BusinessService;
import hallodoc.service.CoincergeService;
import hallodoc.service.CreateAccountService;
import hallodoc.service.CreateService;
import hallodoc.service.FamilyInfoService;
import hallodoc.service.PatientInfoService;
import hallodoc.service.RequestService;
import hallodoc.service.UsersService;
import hallodoc.service.mailService;

@Controller
public class MainController {

	@Autowired
	private RequestService requestService;
	
	@Autowired
	private PatientInfoService patientInfoService;
	@Autowired
	private FamilyInfoService familyInfoService;
	@Autowired
	private CoincergeService coincergeService;

	@Autowired
	private BusinessService businessService;

	@Autowired
	private mailService mailService;

	@Autowired
	private UsersService login;

	@Autowired
	private CreateService create;

	@Autowired
	private emailHelper emailHelpers;
	
	@Autowired
	private CreateAccountService createAccountService;

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
	public String forgot(HttpServletRequest request, Model model) {

		Map<String, ?> inputFlashMap = RequestContextUtils.getInputFlashMap(request);
		if (inputFlashMap != null) {
			String value = (String) inputFlashMap.get("message");
			model.addAttribute("message", value);
			System.out.println(value);
		}

		return "forgot_password";

	}
	@RequestMapping("/create")
	public String create(HttpServletRequest request, Model model) {
		Map<String, ?> inputFlashMap = RequestContextUtils.getInputFlashMap(request);
		if (inputFlashMap != null) {
			String value = (String) inputFlashMap.get("invalid");
			model.addAttribute("invalid", value);
			System.out.println(value);
		}


		return "CreateAccount";

	}

	@RequestMapping(path = "/forgothandle", method = RequestMethod.POST)
	public String forgot(@ModelAttribute Users users, RedirectAttributes ra, Model model) {

		boolean status = login.checkEmail6(users.getUserEmail());
		

		String mailSendString = users.getUserEmail();

		System.out.println(status);
		if (status) {
			System.out.println(" authenticated");
			emailHelpers.sendMailString(mailSendString);

			return "forgot_password";
		} else {
			System.out.println(" not authenticated");
			ra.addFlashAttribute("message", "***wrong credentials");
			return "redirect:/forgot";

		}

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
	public String formHandler(@ModelAttribute Users users, RedirectAttributes ra, Model model, HttpServletRequest request, HttpServletResponse respons) {

		boolean status = login.checkEmail5(users.getUserEmail(), users.getUserPassword());
		String xString = users.getUserEmail();
		int uId = login.getId(xString);
		List requestsList = requestService.getRequest(uId);
		System.out.println(requestsList);
		
		HttpSession session = request.getSession(); 
	
		String uname = login.getUser(xString);
		
		String message;
		System.out.println(status);
		if (status) {
			System.out.println(" authenticated");
			
			model.addAttribute("uname",uname);
			model.addAttribute("requestsList", requestsList);
		

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

	public boolean test = false;

	@PostMapping(path = "/ajax")
	@ResponseBody
	public String checkAJAX(@RequestParam("name") String mail) {

		boolean ans = create.ajaxCheck(mail);

		if (ans) {
			test = true;
			return "success";
		} else {
			test = false;
			return "unsuccess";
		}
	}

	@RequestMapping(path = "/insert", method = RequestMethod.POST)
	public String PatientData(@ModelAttribute PatientInfoDto patientInfoDto, HttpSession s) {
		patientInfoService.service(patientInfoDto, test);
		System.out.println(patientInfoDto.getFile_name().getOriginalFilename());
		byte[] data = patientInfoDto.getFile_name().getBytes();
		String p = s.getServletContext().getRealPath("/") + "WEB-INF" + File.separator + "resources" + File.separator
				+ "docs" + File.separator + patientInfoDto.getFile_name().getOriginalFilename();
		System.out.println(p);
		FileOutputStream fileOutputStream;
		try {
			fileOutputStream = new FileOutputStream(p);
			fileOutputStream.write(data);
			fileOutputStream.close();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("error");

		}
		return "patient_login";
	}

	@RequestMapping(path = "/familyInfo", method = RequestMethod.POST)
	public String PatientDataFamily(@ModelAttribute FamilyInfoDto familyInfoDto, HttpSession s) {
		System.out.println("done");
		familyInfoService.service(familyInfoDto);
		byte[] data = familyInfoDto.getFile_name().getBytes();
		String p = s.getServletContext().getRealPath("/") + "WEB-INF" + File.separator + "resources" + File.separator
				+ "docs" + File.separator + familyInfoDto.getFile_name().getOriginalFilename();
		System.out.println(p);
		FileOutputStream fileOutputStream;
		try {
			fileOutputStream = new FileOutputStream(p);
			fileOutputStream.write(data);
			fileOutputStream.close();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("error");

		}
		return "patient_login";
	}

	@RequestMapping(path = "/conciergeInfo", method = RequestMethod.POST)
	public String PatientDataConcierge(@ModelAttribute CoincergeDto coincergeDto, HttpSession s) {
		System.out.println("done");
		coincergeService.service(coincergeDto, coincergeService.checkEmail(coincergeDto.getEmail()),
				patientInfoService.checkEmail(coincergeDto.getpEmail()));

		System.out.println(coincergeDto.getEmail());
		return "patient_login";
	}

	@RequestMapping(path = "/business", method = RequestMethod.POST)
	public String PatientDataBusiness(@ModelAttribute BusinessDto businessDto, HttpSession s) {
		System.out.println("done");
		businessService.service(businessDto, businessService.checkEmail(businessDto.getEmail()),
				patientInfoService.checkEmail(businessDto.getpEmail()));

		System.out.println(businessDto.getEmail());
		return "patient_login";
	}
	
	
	@RequestMapping(path = "/createAccount", method = RequestMethod.POST)
	public String CreateAcount(@ModelAttribute CreateAccountDto createAccountDto, Model model, RedirectAttributes ra) {

		String x = createAccountDto.getPassword();
		String y = createAccountDto.getConfirmPassword();
		System.out.println(x);
		System.out.println(y);
		createAccountService.Service(createAccountDto);
		

		if (x == y) {
			System.out.println(" authenticated");
			return "redirect:/create";

			

		} else {
			ra.addFlashAttribute("invalid", "***password not matching");
			return "redirect:/create";
		}

	}
	
	/*
	 * public String patientDashboard() {
	 * 
	 * 
	 * 
	 * 
	 * }
	 */

}
