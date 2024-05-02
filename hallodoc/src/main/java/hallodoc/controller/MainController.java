package hallodoc.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.objenesis.instantiator.basic.NewInstanceInstantiator;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.support.RequestContextUtils;

import hallodoc.dto.AdminDashboardDto;
import hallodoc.dto.BusinessDto;
import hallodoc.dto.CoincergeDto;
import hallodoc.dto.CreateAccountDto;
import hallodoc.dto.EditProfileDto;
import hallodoc.dto.FamilyInfoDto;
import hallodoc.dto.InfoSomeoneDto;
import hallodoc.dto.PatientInfoDto;
import hallodoc.dto.ViewDocumentsDTO;
import hallodoc.helper.DobHelper;
import hallodoc.helper.emailHelper;
import hallodoc.model.AspNetRoles;
import hallodoc.model.DummyForgot;
import hallodoc.model.Request;
import hallodoc.model.Role;
import hallodoc.model.User;
import hallodoc.model.Users;
import hallodoc.repo.AdminDashboardDao;
import hallodoc.repo.UserDao;
import hallodoc.repo.UsersDao;
import hallodoc.service.BusinessService;
import hallodoc.service.CoincergeService;
import hallodoc.service.CreateAccountService;
import hallodoc.service.CreateService;
import hallodoc.service.EditProfileService;
import hallodoc.service.FamilyInfoService;
import hallodoc.service.InfoForMeService;

import hallodoc.service.InfoSomeoneService;
import hallodoc.service.PatientInfoService;
import hallodoc.service.RequestService;
import hallodoc.service.RequestWiseFileService;
import hallodoc.service.UsersService;
import hallodoc.service.ViewDocsService;
import hallodoc.service.mailService;

@Controller
public class MainController {

	@Autowired
	private RequestService requestService;

	@Autowired
	private ViewDocsService viewDocsService;
	

	
	@Autowired
	private AdminDashboardDao adminDashboardDao;

	@Autowired
	private PatientInfoService patientInfoService;
	@Autowired
	private FamilyInfoService familyInfoService;
	@Autowired
	private CoincergeService coincergeService;

	@Autowired
	private BusinessService businessService;
	
	@Autowired
	private EditProfileService editProfileService;

	@Autowired
	private mailService mailService;

	@Autowired
	private UsersService login;
	
	@Autowired
	private DobHelper dobHelper;

	@Autowired
	private InfoSomeoneService infoSomeoneService;

	@Autowired
	private CreateService create;

	@Autowired
	private emailHelper emailHelpers;

	@Autowired
	private UsersDao usersDao;

	@Autowired
	private RequestWiseFileService requestWiseFileService;

	@Autowired
	private InfoForMeService infoForMeService;

	@Autowired
	private CreateAccountService createAccountService;
	
	@Autowired
	private UserDao userDao;

	@RequestMapping("/login")
	public String login(HttpServletRequest request, Model model) {

		Map<String, ?> inputFlashMap = RequestContextUtils.getInputFlashMap(request);
		if (inputFlashMap != null) {
			String value = (String) inputFlashMap.get("msg");
			model.addAttribute("msg", value);
			System.out.println(value);
		}

		return "/patient/patient_login";

	}

	@RequestMapping("/forgot")
	public String forgot(HttpServletRequest request, Model model) {

		Map<String, ?> inputFlashMap = RequestContextUtils.getInputFlashMap(request);
		if (inputFlashMap != null) {
			String value = (String) inputFlashMap.get("message");
			model.addAttribute("message", value);
			System.out.println(value);
		}

		return "/patient/forgot_password";

	}

	@RequestMapping("/create")
	public String create(HttpServletRequest request, Model model) {
		Map<String, ?> inputFlashMap = RequestContextUtils.getInputFlashMap(request);
		if (inputFlashMap != null) {
			String value = (String) inputFlashMap.get("invalid");
			model.addAttribute("invalid", value);
			System.out.println(value);
		}

		return "/patient/CreateAccount";

	}

	@RequestMapping(path = "/forgothandle", method = RequestMethod.POST)
	public String forgot(@ModelAttribute Users users, RedirectAttributes ra, Model model) {

		boolean status = login.checkEmail6(users.getUserEmail());

		String mailSendString = users.getUserEmail();

		System.out.println(status);
		if (status) {
			System.out.println(" authenticated");
			emailHelpers.sendMailString(mailSendString);

			return "/patient/forgot_password";
		} else {
			System.out.println(" not authenticated");
			ra.addFlashAttribute("message", "***wrong credentials");
			return "redirect:/forgot";

		}

	}

	@RequestMapping("/reset")
	public String reset() {

		return "/patient/patient_reset";

	}

	

	@RequestMapping("/select")
	public String select() {

		return "/patient/select_role_patient";

	}

	@RequestMapping("/patient")
	public String patient_info() {

		return "/patient/patient_info";

	}

	@RequestMapping("/family")
	public String family() {

		return "/patient/family_info";

	}

	@RequestMapping("/business")
	public String business() {

		return "/patient/business_info";

	}

	@RequestMapping("/coincerge")
	public String coincerge() {

		return "/patient/coincerge_info";

	}

	@RequestMapping("/mail")
	public String mail() {

		return "/patient/SendMail";

	}

	@RequestMapping(path = "/handleform", method = RequestMethod.POST)
	public String formHandler(@ModelAttribute Users users, RedirectAttributes ra, Model model,
			HttpServletRequest request, HttpServletResponse respons) {

		boolean status = login.checkEmail5(users.getUserEmail(), users.getUserPassword());
		String xString = users.getUserEmail();
		String passwordString =  users.getUserPassword();
		User uId = login.getId(xString);
		int userID =   uId.getUserID();
		int roleId =   uId.getRoleId();
		
		
		List requestsList = requestService.getRequest(uId);
		List userList = login.getUserIdUser(xString);
		
		
		String emailIdString = xString.replace("@", "a");
		
		
		
	
		
		
//		System.out.println(requestsList);

		HttpSession session = request.getSession();

		String uname = login.getUser(xString);
		
		Cookie cookie = new Cookie("emailId",emailIdString );
		cookie.setMaxAge(60*60);
		respons.addCookie(cookie);
		System.out.println(cookie.getName());

		String message;
		System.out.println(status);
		
		if (status) {
			
			if (roleId==1) {
				
				session.setAttribute("userList", userList);
				session.setAttribute("email", emailIdString);
				
				
				
				
				return "redirect:admin";
				
				
				
			} else {
				System.out.println(" authenticated");
				session.setAttribute("userList", userList);
				session.setAttribute("email", emailIdString);
				System.out.println(userList);
				model.addAttribute("userList", userList);
				System.out.println(model.getAttribute("userList") + "userlist");
				model.addAttribute("uname", uname);

				model.addAttribute("requestsList", requestsList);
				model.addAttribute("xString", xString);
				model.addAttribute("userID", userID);
				return "redirect:/pdash/"+ userID;

			}
			
		
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

			return "/patient/patient_reset";

		} else {
			model.addAttribute("invalid", "passwords are not matching ");

			return "/patient/patient_reset";
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
		return "/patient/patient_login";
	}

	@RequestMapping(path = "/familyInfo", method = RequestMethod.POST)
	public String PatientDataFamily(@ModelAttribute FamilyInfoDto familyInfoDto, HttpSession s) {
		System.out.println("done");
		familyInfoService.service(familyInfoDto, create.ajaxCheck(familyInfoDto.getpEmail()));
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
		return "/patient/patient_login";
	}

	@RequestMapping(path = "/conciergeInfo", method = RequestMethod.POST)
	public String PatientDataConcierge(@ModelAttribute CoincergeDto coincergeDto, HttpSession s) {
		System.out.println("done");
		coincergeService.service(coincergeDto, coincergeService.checkEmail(coincergeDto.getEmail()),
				patientInfoService.checkEmail(coincergeDto.getpEmail()));

		System.out.println(coincergeDto.getEmail());
		return "/patient/patient_login";
	}

	@RequestMapping(path = "/business", method = RequestMethod.POST)
	public String PatientDataBusiness(@ModelAttribute BusinessDto businessDto, HttpSession s) {
		System.out.println("done");
		businessService.service(businessDto, businessService.checkEmail(businessDto.getEmail()),
				patientInfoService.checkEmail(businessDto.getpEmail()));

		System.out.println(businessDto.getEmail());
		return "/patient/patient_login";
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

	@RequestMapping("/showDocs/{rId}/{firstName}/{lastName}")
	public String handleeAction(@PathVariable("firstName") String firstName, @PathVariable("lastName") String lastName,
			@PathVariable("rId") String rId, Model model, Users users, HttpServletRequest request) {

		int rid1 = Integer.parseInt(rId);

		List<ViewDocumentsDTO> viewDocumentsDTO = viewDocsService.getRequestWiseFiles(rid1, request);
		model.addAttribute("requestWiseFiles", viewDocumentsDTO);
		return "/patient/document_view";
	}
	
	
	@RequestMapping("pdash/showDocs/{rId}/{firstName}/{lastName}")
	public String handleeAction1(@PathVariable("firstName") String firstName, @PathVariable("lastName") String lastName,
			@PathVariable("rId") String rId, Model model, Users users, HttpServletRequest request) {

		int rid1 = Integer.parseInt(rId);

		List<ViewDocumentsDTO> viewDocumentsDTO = viewDocsService.getRequestWiseFiles(rid1, request);
		model.addAttribute("requestWiseFiles", viewDocumentsDTO);
		return "/patient/document_view";
	}


	@RequestMapping(path = "/showDocs/{rId}/{firstName}/{lastName}/uploadFile", method = RequestMethod.POST)
	public String uploadFile(@RequestParam("file_name") CommonsMultipartFile filename, HttpSession s,
			@PathVariable("rId") String rId) {

		viewDocsService.reqWiseFileforsave(rId, filename);
		byte[] data = filename.getBytes();
		String p = s.getServletContext().getRealPath("/") + "WEB-INF" + File.separator + "resources" + File.separator
				+ "docs" + File.separator + filename.getOriginalFilename();
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
		return "redirect:/showDocs/{rId}/{firstName}/{lastName}";
	}

	@RequestMapping(path = "/requestForMe/{userID}", method = RequestMethod.POST)
	public String PatientRequest(@ModelAttribute PatientInfoDto patientInfoDto, HttpSession s) {
		infoForMeService.service(patientInfoDto);
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

		return "redirect:/pdash/{userID}";
	}
	
	
	
	@RequestMapping("/me/{userID}")
	public String InfoForMe(@PathVariable("userID") String userID) {

		return "/patient/InfoForMe";

	}


	@RequestMapping("/someone/{userID}")
	public String InfoForSomeone(@PathVariable("userID") String userID, Model model) {
		model.addAttribute("userID", userID);
		return "/patient/InfoForSomeone";

	}

	@RequestMapping(path = "/submitInfo/{userID}", method = RequestMethod.POST)
	public String submitInfo(@PathVariable("userID") String userID, Model model,
			@ModelAttribute InfoSomeoneDto infoSomeoneDto, HttpSession s) {
		infoSomeoneService.InfoForElseservice(infoSomeoneDto, userID);

		System.out.println(infoSomeoneDto.getFile().getOriginalFilename());
		byte[] data = infoSomeoneDto.getFile().getBytes();
		String p = s.getServletContext().getRealPath("/") + "WEB-INF" + File.separator + "resources" + File.separator
				+ "docs" + File.separator + infoSomeoneDto.getFile().getOriginalFilename();
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

		return "redirect:/pdash/{userID}";

	}

	@RequestMapping(path = "/pdash/{userID}")
	public String patientDash(@PathVariable("userID") String userID, @ModelAttribute Users users, RedirectAttributes ra, Model model,
			HttpServletRequest request, HttpServletResponse respons, 	@CookieValue(value = "emailId", defaultValue = "error") String emailId) {

//		String xString = users.getUserEmail();
//		User uId = login.getId(xString);
		HttpSession session = request.getSession();
		String emailString = (String) session.getAttribute("email");
		System.out.println(emailId);
		System.out.println(emailString);
		
		if (emailId.equals(emailString))
		{
		int uID = Integer.parseInt(userID);
		List<User> listOFuser =   userDao.getUserIDList(uID);
		User user = listOFuser.get(0);

		List requestsList = requestService.getRequest(user);
		
//	

//		


		model.addAttribute("requestsList", requestsList);

		return "/patient/patient_dashboard";
		}
		else {
			return "/admin/error";
		}

	}
	
	@RequestMapping(path = "/edit/{userID}")
	public String editProfile(@PathVariable("userID") String userID, Model model)
	{
		int uID = Integer.parseInt(userID);
		List<User> userList =   userDao.getUserIDList(uID);
		User user = userList.get(0);
		int date =   user.getIntDate();
		int year =  user.getIntYear();
		String monthString = user.getStrMonth();
		String fullDate=  dobHelper.getWholeDate(date, monthString, year);
		model.addAttribute("userList", userList);
		model.addAttribute("fullDate", fullDate);
		return "/patient/editProfile";
	}
	
	@RequestMapping(path = "/edit/editProfile", method = RequestMethod.POST)
	public String submitInfo(@ModelAttribute EditProfileDto editProfileDto) {
		
		editProfileService.service(editProfileDto);
		return "/patient/editProfile";

	}
	
	

}
