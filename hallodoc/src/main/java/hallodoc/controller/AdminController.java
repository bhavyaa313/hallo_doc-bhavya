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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.support.RequestContextUtils;

import hallodoc.dto.AdminDashboardDto;
import hallodoc.dto.AdminLoginDto;
import hallodoc.dto.AssignCaseDto;
import hallodoc.dto.BlockCaseDto;
import hallodoc.dto.CancelCaseDto;
import hallodoc.dto.CreateNewRequestDto;
import hallodoc.dto.SendLinkDto;
import hallodoc.dto.ViewCaseDto;
import hallodoc.dto.ViewNotesDto;
import hallodoc.helper.DobHelper;
import hallodoc.model.CaseTag;
import hallodoc.model.Physician;
import hallodoc.model.Request;
import hallodoc.model.RequestClient;
import hallodoc.model.User;
import hallodoc.model.Users;
import hallodoc.repo.AdminDashboardDao;
import hallodoc.repo.UserDao;
import hallodoc.service.AdminDashboardService;
import hallodoc.service.AssignCaseService;
import hallodoc.service.BlockCaseService;
import hallodoc.service.CancelCaseService;
import hallodoc.service.CreateNewRequestService;
import hallodoc.service.CreateService;
import hallodoc.service.RequestClientService;
import hallodoc.service.RequestService;
import hallodoc.service.SendLinkService;
import hallodoc.service.UsersService;
import hallodoc.service.ViewCaseService;
import hallodoc.service.ViewNotesService;


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
	private ViewNotesService viewNotesService;
	
	@Autowired
	private RequestClientService requestClientService;
	
	@Autowired
	private DobHelper dobHelper;
	
	@Autowired
	private CreateService create;
	
	@Autowired
	private ViewCaseService viewCaseService;
	
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private SendLinkService sendLinkService;
	
	@Autowired
	private CreateNewRequestService createNewRequestService;
	
	@Autowired
	private CancelCaseService cancelCaseService;
	
	@Autowired
	private BlockCaseService blockCaseService;
	
	@Autowired
	private AssignCaseService assignCaseService;
	
	
	@RequestMapping("/admin")
	public String dashboard(Model model, HttpServletRequest request) {
		
		List requestList = adminDashboardDao.getRequests();
		System.out.println("00000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000");
		List<CaseTag> reasonsList = cancelCaseService.getReasons();
		HttpSession session = request.getSession();
		session.getAttribute("userList");
		System.out.println("00000000000000000000000000000000");
	
		System.out.println(reasonsList);
		
		String activeString = "active  text-info";
		model.addAttribute("activeString", activeString);
		model.addAttribute("reasonsList",reasonsList);
		System.out.println("bhavyaa");
		
		List<AdminDashboardDto> adminDashboardDtos =  adminDashboardService.service();
		Integer[] counts = adminDashboardService.count();
		session.setAttribute("adminDashboardDtos", adminDashboardDtos);
		session.setAttribute("counts", counts);
		model.addAttribute("reasonsList",reasonsList);
		System.out.println(adminDashboardDtos);

		return "/admin/AdminDashboard";

	}
	
	@RequestMapping(path = "/viewCase/{requestId}" )
	public String viewCase(@PathVariable("requestId") int requestId , Model model, HttpServletRequest request1) {
		
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
		HttpSession session = request1.getSession();
		session.getAttribute("userList");
		
		return "/admin/ViewCase";
	}
	
	@RequestMapping(path = "/viewNotes/{requestId}" )
	public String viewNotes(@PathVariable("requestId") int requestId , Model model, @ModelAttribute ViewNotesDto viewNotesDto) {
		
		List<Request> requests =  requestService.getRequestByReqId(requestId);
		Request request = requests.get(0);
		model.addAttribute("requestId", requestId);
		ViewNotesDto viewNotesDtos =  viewNotesService.service(requestId, viewNotesDto);
		System.out.println(viewNotesDtos);
		System.out.println("9999999999999999999999999999999999999999999999999999999999999999999999999999");
		model.addAttribute("viewNotesDtos", viewNotesDtos);
		
		return "/admin/ViewNotes";
	}
	
	
	@RequestMapping("/createReq/{userID}")
	public String creteRequest(@PathVariable("userID") int userID) {
		
		
		
		return "/admin/CreateRequest";
	}
	
	@RequestMapping(path = "/viewCase/viewNotes/{requestId}" )
	public String viewNotess(@PathVariable("requestId") int requestId , Model model, @ModelAttribute ViewNotesDto viewNotesDto) {
		
		List<Request> requests =  requestService.getRequestByReqId(requestId);
		Request request = requests.get(0);
		model.addAttribute("requestId", requestId);
		ViewNotesDto viewNotesDtos =  viewNotesService.service(requestId, viewNotesDto);
		model.addAttribute("viewNotesDtos", viewNotesDtos);
		return "/admin/ViewNotes";
	}
	
	
	@RequestMapping(path = "/viewCase/update/{requestId}" , method = RequestMethod.POST)
	public String UpdateViewCase(@PathVariable("requestId") int requestId, @ModelAttribute ViewCaseDto viewCaseDto  )
	{
		
		List<Request> requests =  requestService.getRequestByReqId(requestId);
		Request request = requests.get(0);

		viewCaseService.service(viewCaseDto, request);
		return "redirect:/viewCase/{requestId}";
	}
	
	
	
@GetMapping(path="/ajaxcall")
	@ResponseBody
	public List ajaxcalldemo(Model model, HttpServletRequest request)
	{
		System.out.println("this is ajax call");
		List<AdminDashboardDto> adminDashboardDtos =  adminDashboardService.service();
		return adminDashboardDtos;
		
		
	}

	@RequestMapping(path = "/createReq/new/{userID}", method = RequestMethod.POST)
	public String CreateNewRequest(@PathVariable("userID")int userID, @ModelAttribute CreateNewRequestDto createNewRequestDto)
	{
		List<User> users = userDao.getUserIDList(userID);
		User user = users.get(0);
		createNewRequestService.service(createNewRequestDto, userID, create.ajaxCheck(createNewRequestDto.getEmail()));
		return "redirect:/createReq/{userID}";
		
	}
	
	@RequestMapping(path = "/send", method = RequestMethod.POST)
	public String SendMail(@ModelAttribute SendLinkDto sendLinkDto)
	{
		sendLinkService.service(sendLinkDto);
		return "redirect:/admin";
		
	}
	
	@RequestMapping(path="/cancelCaseAction/{userID}", method = RequestMethod.POST)
	public String cancelCaseAction(@ModelAttribute CancelCaseDto cancelCaseDto, @PathVariable("userID") int userID )
	{
		
		System.out.println();
		cancelCaseService.service(cancelCaseDto , userID);
		return "redirect:/admin";
		
	}
	
	@RequestMapping(path="/blockCaseAction/{userID}", method = RequestMethod.POST)
	public String blockCaseAction(@ModelAttribute BlockCaseDto blockCaseDto, @PathVariable("userID") int userID)
	{
		
		System.out.println();
		blockCaseService.service(blockCaseDto, userID);
		return "redirect:/admin";
		
	}
	

	@GetMapping(path = "/ajaxForAssignCase")
	@ResponseBody
	public List<AssignCaseDto> ajaxForAssignCase(@RequestParam("region")int region) {

		List<AssignCaseDto> physicians = assignCaseService.servicePhysicians(region);
		return physicians;
	}	
	
	
	@RequestMapping(path="/assignCaseAction/{userID}", method = RequestMethod.POST)
	public String assignCaseAction(@ModelAttribute AssignCaseDto assignCaseDto, @PathVariable("userID") int userID)
	{
	
		System.out.println("h8***********************************************************************");
	
		assignCaseService.service(assignCaseDto, userID);
		return "redirect:/admin";
		
	}
	
	
	
	


}
