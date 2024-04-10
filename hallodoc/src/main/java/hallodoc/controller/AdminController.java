package hallodoc.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.support.RequestContextUtils;

import hallodoc.dto.AdminDashboardDto;
import hallodoc.dto.AdminLoginDto;
import hallodoc.helper.DobHelper;
import hallodoc.model.Request;
import hallodoc.model.RequestClient;
import hallodoc.model.User;
import hallodoc.model.Users;
import hallodoc.repo.AdminDashboardDao;
import hallodoc.service.AdminDashboardService;
import hallodoc.service.RequestClientService;
import hallodoc.service.RequestService;
import hallodoc.service.UsersService;


@Controller
public class AdminController {
	
	@Autowired
	private UsersService usersService;
	
	@Autowired
	private AdminDashboardDao adminDashboardDao;

	@Autowired
	private AdminDashboardService adminDashboardService;
	
	@Autowired
	private RequestService requestService;
	
	@Autowired
	private RequestClientService requestClientService;
	
	@Autowired
	private DobHelper dobHelper;
	
	
	@RequestMapping("/admin")
	public String dashboard(Model model, HttpServletRequest request) {
		
		List requestList = adminDashboardDao.getRequests();
		HttpSession session = request.getSession();
		
		String activeString = "active  text-info";
		model.addAttribute("activeString", activeString);
		System.out.println("bhavyaa");
		
		List<AdminDashboardDto> adminDashboardDtos =  adminDashboardService.service();
		Integer[] counts = adminDashboardService.count();
		session.setAttribute("adminDashboardDtos", adminDashboardDtos);
		session.setAttribute("counts", counts);
		System.out.println(adminDashboardDtos);

		return "/admin/AdminDashboard";

	}
	
	@RequestMapping(path = "/viewCase/{requestId}" )
	public String viewCase(@PathVariable("requestId") int requestId , Model model) {
		
		List<Request> requests =  requestService.getRequestByReqId(requestId);
		Request request = requests.get(0);
		String confirmString = request.getConfirmationNumber();
		int status = request.getStatus();
		List<RequestClient> requestClients = requestClientService.getRequestClientByReqId(request);
		RequestClient requestClient = requestClients.get(0);
		int date =   requestClient.getIntDate();
		int year =  requestClient.getIntYear();
		String monthString = requestClient.getStrMonth();
		String fullDate=  dobHelper.getWholeDate(date, monthString, year);
		System.out.println(fullDate);
		model.addAttribute("fullDate", fullDate);
		model.addAttribute("requestClients", requestClients);
		model.addAttribute("confirmString", confirmString);
		model.addAttribute("status", status);
		
		return "/admin/ViewCase";
	}
	
	@RequestMapping(path = "/viewNotes/{requestId}" )
	public String viewNotes(@PathVariable("requestId") int requestId , Model model) {
		
		List<Request> requests =  requestService.getRequestByReqId(requestId);
		Request request = requests.get(0);
		model.addAttribute("requestId", requestId);
		
		return "/admin/ViewNotes";
	}
	
	@RequestMapping(path = "/viewCase/viewNotes/{requestId}" )
	public String viewNotess(@PathVariable("requestId") int requestId , Model model) {
		
		List<Request> requests =  requestService.getRequestByReqId(requestId);
		Request request = requests.get(0);
		model.addAttribute("requestId", requestId);
		
		return "/admin/ViewNotes";
	}
	
	
	
@GetMapping(path="/ajaxcall")
	@ResponseBody
	public List ajaxcalldemo(Model model, HttpServletRequest request)
	{
		System.out.println("this is ajax call");
		List<AdminDashboardDto> adminDashboardDtos =  adminDashboardService.service();
		return adminDashboardDtos;
		
		
	}
	
	


}
