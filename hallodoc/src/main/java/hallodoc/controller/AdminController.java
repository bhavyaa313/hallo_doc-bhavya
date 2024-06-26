package hallodoc.controller;

import java.io.ByteArrayInputStream;
import java.io.Console;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.ProcessBuilder.Redirect;
import java.util.List;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.util.StringBuilderFormattable;
import org.hibernate.annotations.common.util.StringHelper;
import org.hibernate.sql.Template;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.mysql.cj.Session;

import hallodoc.dto.AddBusinessDto;
import hallodoc.dto.AdminDashboardDto;
import hallodoc.dto.AdminLoginDto;
import hallodoc.dto.AssignCaseDto;
import hallodoc.dto.BlockCaseDto;
import hallodoc.dto.BlockRecordsDto;
import hallodoc.dto.CancelCaseDto;
import hallodoc.dto.CloseCaseDto;
import hallodoc.dto.CreateNewRequestDto;
import hallodoc.dto.CreateProviderDto;
import hallodoc.dto.EditRoleDto;
import hallodoc.dto.EmailLogsDto;
import hallodoc.dto.EncounterDto;
import hallodoc.dto.PatientHistoryDto;
import hallodoc.dto.PatientRecordsDto;
import hallodoc.dto.ProviderDashboardDto;
import hallodoc.dto.SMSLogDto;
import hallodoc.dto.SearchRecordsDto;
import hallodoc.dto.SendLinkDto;
import hallodoc.dto.TransferCaseDto;
import hallodoc.dto.UserAccessDto;
import hallodoc.dto.ViewCaseDto;
import hallodoc.dto.ViewDocumentsDTO;
import hallodoc.dto.ViewNotesDto;
import hallodoc.dto.ordersDto;
import hallodoc.helper.DobHelper;
import hallodoc.model.Admin;
import hallodoc.model.AspNetUsers;
import hallodoc.model.BlockRequests;
import hallodoc.model.CaseTag;
import hallodoc.model.EncounterForm;
import hallodoc.model.HealthProfessionalType;
import hallodoc.model.HealthProfessionals;
import hallodoc.model.Menu;
import hallodoc.model.Physician;
import hallodoc.model.Request;
import hallodoc.model.RequestClient;
import hallodoc.model.Role;
import hallodoc.model.User;
import hallodoc.model.Users;
import hallodoc.repo.AdminDao;
import hallodoc.repo.AdminDashboardDao;
import hallodoc.repo.EncounterDao;
import hallodoc.repo.PhysicianDao;
import hallodoc.repo.UserDao;
import hallodoc.service.AdminDashboardService;
import hallodoc.service.AssignCaseService;
import hallodoc.service.BlockCaseService;
import hallodoc.service.BlockRecordsService;
import hallodoc.service.CancelCaseService;
import hallodoc.service.ClearCaseService;
import hallodoc.service.CloseCaseService;
import hallodoc.service.CreateNewRequestService;
import hallodoc.service.CreateRoleService;
import hallodoc.service.CreateService;
import hallodoc.service.EncounterService;
import hallodoc.service.ExportAllService;
import hallodoc.service.PartnerService;
import hallodoc.service.PatientHistoryService;
import hallodoc.service.PatientRecordsService;
import hallodoc.service.ProviderDashboardService;
import hallodoc.service.ProviderService;
import hallodoc.service.RequestClientService;
import hallodoc.service.RequestService;
import hallodoc.service.SMSRecordsService;
import hallodoc.service.SearchHistoryService;
import hallodoc.service.SendAgreementService;
import hallodoc.service.SendLinkService;
import hallodoc.service.TransferCaseService;
import hallodoc.service.UserAccessService;
import hallodoc.service.UsersService;
import hallodoc.service.ViewCaseService;
import hallodoc.service.ViewDocsService;
import hallodoc.service.ViewNotesService;
import hallodoc.service.emailRecordsService;
import hallodoc.service.myProfileService;
import hallodoc.service.ordersService;
import hallodoc.service.searchService;

@Controller
public class AdminController {

	@Autowired
	private UsersService usersService;

	@Autowired
	private AdminDashboardDao adminDashboardDao;

	@Autowired
	private emailRecordsService emailRecordsService;

	@Autowired
	private ProviderService providerService;

	@Autowired
	private myProfileService myProfileService;

	@Autowired
	private PartnerService partnerService;

	@Autowired
	private ordersService ordersService;

	@Autowired
	private PatientHistoryService patientHistoryService;

	@Autowired
	private EncounterService encounterService;

	@Autowired
	private AdminDashboardService adminDashboardService;

	@Autowired
	private AdminDao adminDao;

	@Autowired
	private BlockRecordsService blockRecordsService;

	@Autowired
	private PhysicianDao physicianDao;

	@Autowired
	private CloseCaseService closeCaseService;
	
	@Autowired
	private UserAccessService userAccessService;

	@Autowired
	private SearchHistoryService searchHistoryService;

	@Autowired
	private RequestService requestService;
	
	@Autowired
	private ProviderDashboardService providerDashboardService;

	@Autowired
	private EncounterDao encounterDao;

	@Autowired
	private SMSRecordsService smsRecordsService;

	@Autowired
	private ViewNotesService viewNotesService;

	@Autowired
	private RequestClientService requestClientService;

	@Autowired
	private DobHelper dobHelper;

	@Autowired
	private SendAgreementService sendAgreementService;

	@Autowired
	private CreateService create;

	@Autowired
	private ViewCaseService viewCaseService;

	@Autowired
	private UserDao userDao;

	@Autowired
	private SendLinkService sendLinkService;

	@Autowired
	private PatientRecordsService patientRecordsService;

	@Autowired
	private CreateNewRequestService createNewRequestService;

	@Autowired
	private CancelCaseService cancelCaseService;

	@Autowired
	private BlockCaseService blockCaseService;

	@Autowired
	private searchService searchService;

	@Autowired
	private AssignCaseService assignCaseService;

	@Autowired
	private TransferCaseService transferCaseService;

	@Autowired
	private ExportAllService exportAllService;

	@Autowired
	private ClearCaseService clearCaseService;

	@Autowired
	private ViewDocsService viewDocsService;
	@Autowired
	private CreateRoleService createRoleService;

	@GetMapping("GetFilteredMenus/{accountType}")
	@ResponseBody
	public List<Menu> GetFilteredMenus(@PathVariable("accountType") int accountType) {

		List<Menu> dataList = createRoleService.createRole(accountType);
		return dataList;
	}

	@PostMapping("/saveRole")
	public String saveRole(@RequestParam("name") String name, @RequestParam("role") int role,
			@RequestParam("list") List<Integer> list, HttpServletRequest request) {
		HttpSession session = request.getSession();
		List<User> list2 = (List<User>) session.getAttribute("userList");
		AspNetUsers user = list2.get(0).getAspnetUserId();
		createRoleService.saveRole(name, role, list, user);
		return "redirect:/accountAccess";

	}

	@PostMapping("/updateRole/{roleId}")
	public String updateRole(@RequestParam("name") String name, @RequestParam("role") int role,
			@RequestParam("list") List<Integer> list, HttpServletRequest request, @PathVariable("roleId") int roleId) {
		HttpSession session = request.getSession();
		List<User> list2 = (List<User>) session.getAttribute("userList");
		AspNetUsers user = list2.get(0).getAspnetUserId();
		createRoleService.updateRole(name, role, list, user, roleId);
		return "redirect:/accountAccess";

	}
	
	@RequestMapping("/admin")
	public String dashboard(Model model, HttpServletRequest request,
			@CookieValue(value = "emailId", defaultValue = "error") String emailId) {

		List requestList = adminDashboardDao.getRequests();

		List<CaseTag> reasonsList = cancelCaseService.getReasons();
		HttpSession session = request.getSession();
		String sessionIdString = session.getId();

		String emailString = (String) session.getAttribute("email");

		if (emailId.equals(emailString)) {

			session.getAttribute("userList");

			System.out.println("00000000000000000000000000000000");

			System.out.println(reasonsList);

			String activeString = "active  text-info";
			model.addAttribute("activeString", activeString);
			model.addAttribute("reasonsList", reasonsList);
			System.out.println("bhavyaa");

			/*
			 * List<AdminDashboardDto> adminDashboardDtos =
			 * adminDashboardService.service(class1, roString, input, region);
			 */
			Integer[] counts = adminDashboardService.count();
			/* session.setAttribute("adminDashboardDtos", adminDashboardDtos); */
			session.setAttribute("counts", counts);
			model.addAttribute("reasonsList", reasonsList);
			/* System.out.println(adminDashboardDtos); */

			return "/admin/AdminDashboard";
		}
		/*
		 * else if(cookies==null) { return "/admin/error"; }
		 */
		else {
			return "/admin/error";
		}

	}

	@RequestMapping("/provider/{id}")
	public String dashboard(Model model, HttpServletRequest request,@PathVariable("id")int id,
			@CookieValue(value = "emailId", defaultValue = "error") String emailId) {

		List requestList = adminDashboardDao.getRequests();


		HttpSession session = request.getSession();
		String sessionIdString = session.getId();

		String emailString = (String) session.getAttribute("email");

		if (emailId.equals(emailString)) {

			session.getAttribute("userList");

			String activeString = "active  text-info";
			model.addAttribute("activeString", activeString);
			model.addAttribute("id", id);
			
			

		
			Integer[] counts = providerDashboardService.count(id);
			
			session.setAttribute("counts", counts);
	

			return "/provider/providerDashboard";
		}
		/*
		 * else if(cookies==null) { return "/admin/error"; }
		 */
		else {
			return "/admin/error";
		}

	}
	
	

	@RequestMapping(path = "/viewCase/{requestId}")
	public String viewCase(@PathVariable("requestId") int requestId, Model model, HttpServletRequest request1) {

		List<Request> requests = requestService.getRequestByReqId(requestId);
		Request request = requests.get(0);
		String confirmString = request.getConfirmationNumber();
		int status = request.getStatus();
		List<RequestClient> requestClients = requestClientService.getRequestClientByReqId(request);
		RequestClient requestClient = requestClients.get(0);
		int date = requestClient.getIntDate();
		int year = requestClient.getIntYear();
		String monthString = requestClient.getStrMonth();
		String fullDate = dobHelper.getWholeDate(date, monthString, year);
		System.out.println(fullDate);
		model.addAttribute("fullDate", fullDate);
		model.addAttribute("requestClients", requestClients);
		model.addAttribute("confirmString", confirmString);
		model.addAttribute("status", status);
		HttpSession session = request1.getSession();
		String activeString = "active  text-info";
		model.addAttribute("activeString", activeString);
		session.getAttribute("userList");

		return "/admin/ViewCase";
	}
	
	@RequestMapping(path = "/provider/viewCase/{requestId}")
	public String viewCaseprovider(@PathVariable("requestId") int requestId, Model model, HttpServletRequest request1) {

		List<Request> requests = requestService.getRequestByReqId(requestId);
		Request request = requests.get(0);
		String confirmString = request.getConfirmationNumber();
		int status = request.getStatus();
		List<RequestClient> requestClients = requestClientService.getRequestClientByReqId(request);
		RequestClient requestClient = requestClients.get(0);
		int date = requestClient.getIntDate();
		int year = requestClient.getIntYear();
		String monthString = requestClient.getStrMonth();
		String fullDate = dobHelper.getWholeDate(date, monthString, year);
		System.out.println(fullDate);
		model.addAttribute("fullDate", fullDate);
		model.addAttribute("requestClients", requestClients);
		model.addAttribute("confirmString", confirmString);
		model.addAttribute("status", status);
		HttpSession session = request1.getSession();
		String activeString = "active  text-info";
		model.addAttribute("activeString", activeString);
		session.getAttribute("userList");

		return "/provider/viewCase";
	}

	@RequestMapping(path = "/viewNotes/{requestId}")
	public String viewNotes(@PathVariable("requestId") int requestId, Model model,
			@ModelAttribute ViewNotesDto viewNotesDto) {

		List<Request> requests = requestService.getRequestByReqId(requestId);
		Request request = requests.get(0);
		String activeString = "active  text-info";
		model.addAttribute("activeString", activeString);
		model.addAttribute("requestId", requestId);
		ViewNotesDto viewNotesDtos = viewNotesService.service(requestId, viewNotesDto);
		System.out.println(viewNotesDtos);
		System.out.println("9999999999999999999999999999999999999999999999999999999999999999999999999999");
		model.addAttribute("viewNotesDtos", viewNotesDtos);

		return "/admin/ViewNotes";
	}
	
	@RequestMapping(path = "/provider/viewNotes/{userID}/{requestId}")
	public String viewNotesProvider(@PathVariable("requestId") int requestId,@PathVariable("userID") int userID, Model model,
			@ModelAttribute ViewNotesDto viewNotesDto) {

		List<Request> requests = requestService.getRequestByReqId(requestId);
		Request request = requests.get(0);
		String activeString = "active  text-info";
		model.addAttribute("activeString", activeString);
		model.addAttribute("requestId", requestId);
		model.addAttribute("userID", userID);
		ViewNotesDto viewNotesDtos = viewNotesService.service(requestId, viewNotesDto);
		System.out.println(viewNotesDtos);
		System.out.println("9999999999999999999999999999999999999999999999999999999999999999999999999999");
		model.addAttribute("viewNotesDtos", viewNotesDtos);

		return "/provider/viewNotes";
	}
	
	@PostMapping("/submitNoteAdmin/{requestId}/{userID}")
	public String submitNoteAdmin(@PathVariable("requestId") int requestId,@PathVariable("userID") int userID, @RequestParam("adminNote") String Note)
	{
		viewNotesService.submitAdminNote(requestId, Note, userID);
		return "redirect:/viewNotes/" +userID +"/"+ + requestId;
	}

	
	@PostMapping("/submitNote/{requestId}/{userID}")
	public String submitNote(@PathVariable("requestId") int requestId,@PathVariable("userID") int userID, @RequestParam("providerNote") String Note)
	{
		viewNotesService.submitProviderNote(requestId, Note, userID);
		return "redirect:/provider/viewNotes/" +userID +"/"+ + requestId;
	}

	@RequestMapping("/createReq/{userID}")
	public String creteRequest(@PathVariable("userID") int userID, Model model) {
		String activeString = "active  text-info";
		model.addAttribute("activeString", activeString);
		return "/admin/CreateRequest";
	}
	
	@RequestMapping("/provider/createReq/{userID}/{id}")
	public String creteRequestProvider(@PathVariable("userID") int userID, Model model, @PathVariable("id") int id) {
		String activeString = "active  text-info";
		model.addAttribute("activeString", activeString);
		model.addAttribute("id", id);
		return "/provider/createNewRequest";
	}


	@RequestMapping(path = "/viewCase/viewNotes/{requestId}")
	public String viewNotess(@PathVariable("requestId") int requestId, Model model,
			@ModelAttribute ViewNotesDto viewNotesDto) {
		String activeString = "active  text-info";
		model.addAttribute("activeString", activeString);
		List<Request> requests = requestService.getRequestByReqId(requestId);
		Request request = requests.get(0);
		model.addAttribute("requestId", requestId);
		ViewNotesDto viewNotesDtos = viewNotesService.service(requestId, viewNotesDto);
		model.addAttribute("viewNotesDtos", viewNotesDtos);
		return "/admin/ViewNotes";
	}

	@RequestMapping(path = "/viewCase/update/{requestId}", method = RequestMethod.POST)
	public String UpdateViewCase(@PathVariable("requestId") int requestId, @ModelAttribute ViewCaseDto viewCaseDto) {

		List<Request> requests = requestService.getRequestByReqId(requestId);
		Request request = requests.get(0);

		viewCaseService.service(viewCaseDto, request);
		return "redirect:/viewCase/{requestId}";
	}

	@GetMapping(path = "/ajaxcall/{class1}/{roleWiseId}/{valueofInput}/{regionWiseSearch}")
	@ResponseBody
	public List ajaxcalldemo(Model model, HttpServletRequest request, @PathVariable("class1") String class1,
			@PathVariable("roleWiseId") String roString, @PathVariable("valueofInput") String input,
			@PathVariable("regionWiseSearch") String region) {
		System.out.println("this is ajax call");
		List<AdminDashboardDto> adminDashboardDtos = adminDashboardService.service(class1, roString, input, region);

		return adminDashboardDtos;

	}
	

	@GetMapping(path = "/provider/ajaxcallForProvider/{class1}/{roleWiseId}/{valueofInput}/{phyID}")
	@ResponseBody
	public List ajaxcallProvider(Model model, HttpServletRequest request, @PathVariable("class1") String class1,
			@PathVariable("roleWiseId") String roString, @PathVariable("valueofInput") String input,
			@PathVariable("phyID") int phyID) {
		System.out.println("this is ajax call");
		List<ProviderDashboardDto> providerDashboardDtos = providerDashboardService.service(class1, roString,input, phyID);
		
		return providerDashboardDtos;

	}

	@RequestMapping(path = "/createReq/new/{userID}", method = RequestMethod.POST)
	public String CreateNewRequest(@PathVariable("userID") int userID,
			@ModelAttribute CreateNewRequestDto createNewRequestDto) {
		List<User> users = userDao.getUserIDList(userID);
		User user = users.get(0);
		createNewRequestService.service(createNewRequestDto, userID, create.ajaxCheck(createNewRequestDto.getEmail()));
		return "redirect:/createReq/{userID}";

	}
	
	@RequestMapping(path = "/new/{userID}/{id}", method = RequestMethod.POST)
	public String CreateNewRequestProvider(@PathVariable("userID") int userID, @PathVariable("id") int id,
			@ModelAttribute CreateNewRequestDto createNewRequestDto) {
		List<User> users = userDao.getUserIDList(userID);
		User user = users.get(0);
	createNewRequestService.serviceProvider(createNewRequestDto, userID, create.ajaxCheck(createNewRequestDto.getEmail()), id);
	return "redirect:/provider/" + id;
	

	}

	@RequestMapping(path = "/send", method = RequestMethod.POST)
	public String SendMail(@ModelAttribute SendLinkDto sendLinkDto) {
		sendLinkService.service(sendLinkDto);
		return "redirect:/admin";

	}
	
	@RequestMapping(path = "/provider/send/{phyId}", method = RequestMethod.POST)
	public String SendMailProvider(@ModelAttribute SendLinkDto sendLinkDto, @PathVariable("phyId") int phyId) {
		sendLinkService.service(sendLinkDto);
		return "redirect:/provider/" + phyId;

	}
	
	@RequestMapping(path = "/contact", method = RequestMethod.POST)
	public String SendMailContact(@ModelAttribute SendLinkDto sendLinkDto) {
		sendLinkService.contctProvider(sendLinkDto);
		return "redirect:/providerMenu";

	}

	@RequestMapping(path = "/sendAgreementAction", method = RequestMethod.POST)
	public String sendAgreementAction(@RequestParam("email23") String email, @RequestParam("reqId6") int reqId) {
		sendLinkService.sendAgreementService(email, reqId);
		return "redirect:/admin";

	}
	
	@RequestMapping(path = "/provider/sendAgreementAction", method = RequestMethod.POST)
	public String sendAgreementActionProvider(@RequestParam("email23") String email, @RequestParam("reqId6") int reqId, @RequestParam("phyId") int phyId) {
		sendLinkService.sendAgreementService(email, reqId);
		return "redirect:/provider/" + phyId;

	}

	@RequestMapping(path = "/cancelCaseAction/{userID}", method = RequestMethod.POST)
	public String cancelCaseAction(@ModelAttribute CancelCaseDto cancelCaseDto, @PathVariable("userID") int userID) {

		System.out.println();
		cancelCaseService.service(cancelCaseDto, userID);
		return "redirect:/admin";

	}
	
	


	@RequestMapping(path = "/blockCaseAction/{userID}", method = RequestMethod.POST)
	public String blockCaseAction(@ModelAttribute BlockCaseDto blockCaseDto, @PathVariable("userID") int userID) {

		System.out.println();
		blockCaseService.service(blockCaseDto, userID);
		return "redirect:/admin";

	}

	@GetMapping(path = "/ajaxForAssignCase")
	@ResponseBody
	public List<AssignCaseDto> ajaxForAssignCase(@RequestParam("region") int region) {

		List<AssignCaseDto> physicians = assignCaseService.servicePhysicians(region);
		return physicians;
	}

	@GetMapping(path = "/orders/ajaxForOrders")
	@ResponseBody
	public List<ordersDto> ajaxForOrders(@RequestParam("profession") int professionals) {

		List<ordersDto> ordersDtos = ordersService.serviceOrder(professionals);
		return ordersDtos;
	}
	
	@GetMapping(path = "/provider/orders/{requestId}/ajaxForOrdersProvider")
	@ResponseBody
	public List<ordersDto> ajaxForOrdersProvider(@RequestParam("profession") int professionals) {

		List<ordersDto> ordersDtos = ordersService.serviceOrder(professionals);
		return ordersDtos;
	}

	@GetMapping(path = "/ajaxForTransferCase")
	@ResponseBody
	public List<TransferCaseDto> ajaxForTransferCase(@RequestParam("region") int region) {

		List<TransferCaseDto> physicians = transferCaseService.servicePhysicians(region);
		return physicians;
	}

	@RequestMapping(path = "/assignCaseAction/{userID}", method = RequestMethod.POST)
	public String assignCaseAction(@ModelAttribute AssignCaseDto assignCaseDto, @PathVariable("userID") int userID) {

		assignCaseService.service(assignCaseDto, userID);
		return "redirect:/admin";

	}

	@RequestMapping(path = "/transferCaseAction/{userID}", method = RequestMethod.POST)
	public String transferCaseAction(@ModelAttribute TransferCaseDto transferCaseDto,
			@PathVariable("userID") int userID) {

		transferCaseService.service(transferCaseDto, userID);
		return "redirect:/admin";

	}
	
	@RequestMapping(path = "/transferCaseActionProvider/{userID}/{id}", method = RequestMethod.POST)
	public String transferCaseActionProvider(@ModelAttribute TransferCaseDto transferCaseDto,
			@PathVariable("userID") int userID, @PathVariable("id") int id) {

		transferCaseService.transferProvider(transferCaseDto, userID);
		return "redirect:/provider/" + id;

	}

	@RequestMapping(path = "exportAll", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<Resource> exportAll(HttpServletResponse response) {

		ByteArrayInputStream actualData = exportAllService.allRequests();
		InputStreamResource file = new InputStreamResource(actualData);
		ResponseEntity<Resource> body = ResponseEntity.ok()
				.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=allrequest.xlsx")
				.contentType(MediaType.parseMediaType("application/vnd.ms-excel")).body(file);
		return body;

	}

	@RequestMapping(path = "logout")
	public String logout(HttpServletRequest request) {

		request.getSession(false).invalidate();
		return "/patient/patient_login";

	}

	@PostMapping("clearCaseAction")
	public String clearCaseAction(@RequestParam("reqId5") int reqId) {
		clearCaseService.service(reqId);
		return "redirect:/admin";

	}
	
	@PostMapping("/provider/acceptCaseAction")
	public String AcceptCaseAction(@RequestParam("reqId5") int reqId, @RequestParam("phyId") int phyId) {
		clearCaseService.acceptCase(reqId, phyId);
		return "redirect:/provider/" + phyId;
		

	}

	@RequestMapping("/viewDocs/{requestId}")
	public String viewDocs(@PathVariable("requestId") int requestId, Model model, HttpServletRequest request1,
			HttpSession session) {
		String activeString = "active  text-info";
		model.addAttribute("activeString", activeString);
		List<Request> requests = requestService.getRequestByReqId(requestId);
		Request request = requests.get(0);
		String confirmString = request.getConfirmationNumber();
		int status = request.getStatus();
		List<RequestClient> requestClients = requestClientService.getRequestClientByReqId(request);
		RequestClient requestClient = requestClients.get(0);

		model.addAttribute("requestClients", requestClients);
		model.addAttribute("confirmString", confirmString);
		model.addAttribute("status", status);
		List<ViewDocumentsDTO> viewDocumentsDTO = viewDocsService.getRequestWiseFiles(requestId, request1);
		model.addAttribute("requestWiseFiles", viewDocumentsDTO);
		session.getAttribute("userList");
		return "/admin/ViewDocs";
	}
	
	
	
	
	@RequestMapping("/provider/viewDocs/{requestId}")
	public String viewDocsProvider(@PathVariable("requestId") int requestId, Model model, HttpServletRequest request1,
			HttpSession session) {
		String activeString = "active  text-info";
		model.addAttribute("activeString", activeString);
		List<Request> requests = requestService.getRequestByReqId(requestId);
		Request request = requests.get(0);
		String confirmString = request.getConfirmationNumber();
		int status = request.getStatus();
		List<RequestClient> requestClients = requestClientService.getRequestClientByReqId(request);
		RequestClient requestClient = requestClients.get(0);

		model.addAttribute("requestClients", requestClients);
		model.addAttribute("confirmString", confirmString);
		model.addAttribute("status", status);
		List<ViewDocumentsDTO> viewDocumentsDTO = viewDocsService.getRequestWiseFiles(requestId, request1);
		model.addAttribute("requestWiseFiles", viewDocumentsDTO);
		session.getAttribute("userList");
		return "/admin/ViewDocs";
	}
	
	
	@RequestMapping("/provider/concludeCare/{requestId}")
	public String concludeCare(@PathVariable("requestId") int requestId, Model model, HttpServletRequest request1,
			HttpSession session) {
		String activeString = "active  text-info";
		model.addAttribute("activeString", activeString);
		List<Request> requests = requestService.getRequestByReqId(requestId);
		Request request = requests.get(0);
		String confirmString = request.getConfirmationNumber();
		int status = request.getStatus();
		List<RequestClient> requestClients = requestClientService.getRequestClientByReqId(request);
		RequestClient requestClient = requestClients.get(0);

		model.addAttribute("requestClients", requestClients);
		model.addAttribute("confirmString", confirmString);
		model.addAttribute("status", status);
		List<ViewDocumentsDTO> viewDocumentsDTO = viewDocsService.getRequestWiseFiles(requestId, request1);
		model.addAttribute("requestWiseFiles", viewDocumentsDTO);
		session.getAttribute("userList");
		return "/provider/concludeCare";
	}


	@RequestMapping(path = "/viewDocs/{requestId}/{userID}/uploadFile", method = RequestMethod.POST)
	public String uploadFile(@RequestParam("file_name") CommonsMultipartFile filename, HttpSession s,
			@PathVariable("requestId") String rId, @PathVariable("userID") int userID) {

		if (!(filename.getOriginalFilename().equals(""))) {
			viewDocsService.reqWiseFileforsaveadmin(rId, filename, userID);
			byte[] data = filename.getBytes();
			String p = s.getServletContext().getRealPath("/") + "WEB-INF" + File.separator + "resources"
					+ File.separator + "docs" + File.separator + filename.getOriginalFilename();
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
		}
		return "redirect:/viewDocs/{requestId}";
	}
	
	
	@RequestMapping(path = "/uploadConclude/{requestId}/{userID}/uploadFile", method = RequestMethod.POST)
	public String uploadFileConcludeCare(@RequestParam("file_name") CommonsMultipartFile filename, HttpSession s,
			@PathVariable("requestId") String rId, @PathVariable("userID") int userID) {

		if (!(filename.getOriginalFilename().equals(""))) {
			viewDocsService.reqWiseFileforsaveadmin(rId, filename, userID);
			byte[] data = filename.getBytes();
			String p = s.getServletContext().getRealPath("/") + "WEB-INF" + File.separator + "resources"
					+ File.separator + "docs" + File.separator + filename.getOriginalFilename();
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
		}
		return "redirect:/provider/concludeCare/{requestId}";
	}

	@RequestMapping("/viewDocs/{requestId}/{id}/delete")
	public String deleteFile(@PathVariable("id") int id, @PathVariable("requestId") String rId) {
		viewDocsService.delete(id);
		return "redirect:/viewDocs/{requestId}";

	}
	
	@RequestMapping("/concludeCare/{requestId}/{id}/delete")
	public String deleteConcludeCare(@PathVariable("id") int id, @PathVariable("requestId") String rId) {
		viewDocsService.delete(id);
		return "redirect:/provider/concludeCare/{requestId}";

	}

	@RequestMapping(path = "/agreement/{requestId}")
	public String sendAgreement(@PathVariable("requestId") int requestId, Model model) {

		System.out.println();
		model.addAttribute("requestId", requestId);
		List<Request> requests = requestService.getRequestByReqId(requestId);
		Request request = requests.get(0);
		String name = request.getRequestClient().getFirstName() + request.getRequestClient().getLastName();
		model.addAttribute("name", name);
		return "/admin/agreement";

	}

	@RequestMapping(path = "/agreement/reviewAgreementAction/{requestId}", method = RequestMethod.POST)

	public String reviewAgreementAction(@PathVariable("requestId") int requestId)

	{

		sendAgreementService.acceptAgreement(requestId);
		return ("/admin/thankyou");

	}

	@RequestMapping(path = "/agreement/cancelAgreementAction/{requestId}", method = RequestMethod.POST)
	public String rejectAgreementAction(@PathVariable("requestId") int requestId, @RequestParam("notes") String notes)

	{

		sendAgreementService.declineAgreement(requestId, notes);
		return ("/admin/thankyou");

	}

	@RequestMapping(path = "thankyou")
	public String thankyou()

	{

		return ("/admin/thankyou");

	}

	@RequestMapping(path = "/orders/{requestId}")
	public String orders(@PathVariable("requestId") int reqId, Model model)

	{
		String activeString = "active  text-info";
		model.addAttribute("activeString", activeString);
		model.addAttribute("reqId", reqId);
		return ("/admin/orders");

	}
	
	
	@RequestMapping(path = "/provider/orders/{requestId}/{phyId}")
	public String ordersForProviders(@PathVariable("requestId") int reqId, Model model, @PathVariable("phyId") int phyId)

	{
		String activeString = "active  text-info";
		model.addAttribute("activeString", activeString);
		model.addAttribute("reqId", reqId);
		model.addAttribute("phyId", phyId);
		return ("/provider/orders");

	}

	@RequestMapping(path = "/orders/sendOrders/{requestId}", method = RequestMethod.POST)
	public String sendOrders(@ModelAttribute ordersDto ordersDto)

	{
		ordersService.sendOrders(ordersDto);
		return "redirect:/admin";

	}
	
	@RequestMapping(path = "/sendOrders/{requestId}", method = RequestMethod.POST)
	public String sendOrdersProvider(@ModelAttribute ordersDto ordersDto, @RequestParam("phyId")int phyId)

	{
		ordersService.sendOrders(ordersDto);
		return "redirect:/provider/" + phyId;

	}

	@RequestMapping(path = "/closeCase/{requestId}")
	public String closecase(@PathVariable("requestId") int requestId, Model model, HttpServletRequest request1)

	{

		String activeString = "active  text-info";
		model.addAttribute("activeString", activeString);
		List<Request> requests = requestService.getRequestByReqId(requestId);
		Request request = requests.get(0);
		String confirmString = request.getConfirmationNumber();
		int status = request.getStatus();
		List<RequestClient> requestClients = requestClientService.getRequestClientByReqId(request);
		RequestClient requestClient = requestClients.get(0);
		int date = requestClient.getIntDate();
		int year = requestClient.getIntYear();
		String monthString = requestClient.getStrMonth();
		String fullDate = dobHelper.getWholeDate(date, monthString, year);
		System.out.println(fullDate);
		model.addAttribute("fullDate", fullDate);
		model.addAttribute("requestClients", requestClients);
		model.addAttribute("confirmString", confirmString);
		model.addAttribute("status", status);
		model.addAttribute("requestId", requestId);
		List<ViewDocumentsDTO> viewDocumentsDTO = viewDocsService.getRequestWiseFiles(requestId, request1);
		model.addAttribute("requestWiseFiles", viewDocumentsDTO);
		/*
		 * HttpSession session = request1.getSession();
		 * session.getAttribute("userList");
		 */

		return ("/admin/CLoseCase");

	}

	@RequestMapping(path = "/closeCase/update/{requestId}", method = RequestMethod.POST)
	public String UpdateCase(@PathVariable("requestId") int requestId, @ModelAttribute CloseCaseDto closeCaseDto) {

		List<Request> requests = requestService.getRequestByReqId(requestId);
		Request request = requests.get(0);

		closeCaseService.service(closeCaseDto, request);
		return "redirect:/closeCase/{requestId}";
	}

	@RequestMapping("/closeCase/closed/{requestId}")
	public String caseClosed(@PathVariable("requestId") int reqId) {
		closeCaseService.caseClosed(reqId);
		return "redirect:/admin";

	}

	@RequestMapping("/encounter/{requestId}")
	public String encounter(@PathVariable("requestId") int reqId, Model model) {
		List<Request> requests = requestService.getRequestByReqId(reqId);
		Request request = requests.get(0);
		String DOS = request.getAcceptedDate().toLocalDate().toString();
		String activeString = "active  text-info";
		model.addAttribute("activeString", activeString);
		List<RequestClient> requestClients = requestClientService.getRequestClientByReqId(request);
		RequestClient requestClient = requestClients.get(0);
		int date = requestClient.getIntDate();
		int year = requestClient.getIntYear();
		model.addAttribute("DOS", DOS);
		String monthString = requestClient.getStrMonth();
		String fullDate = dobHelper.getWholeDate(date, monthString, year);
		System.out.println(fullDate);
		model.addAttribute("fullDate", fullDate);
		model.addAttribute("requestClients", requestClients);
		model.addAttribute("reqId", reqId);
		List<EncounterForm> encounterList = encounterDao.getformList(request);
		if (encounterList.size() > 0) {

			model.addAttribute("encounterList", encounterList);
		}
		return "/admin/encounterForm";
	}
	
	
	@RequestMapping("/provider/encounter/{requestId}/{phyID}")
	public String encounterFormProvider(@PathVariable("requestId") int reqId, Model model, @PathVariable("phyID") int phyID) {
		List<Request> requests = requestService.getRequestByReqId(reqId);
		Request request = requests.get(0);
		String DOS = request.getAcceptedDate().toLocalDate().toString();
		String activeString = "active  text-info";
		model.addAttribute("activeString", activeString);
		List<RequestClient> requestClients = requestClientService.getRequestClientByReqId(request);
		RequestClient requestClient = requestClients.get(0);
		int date = requestClient.getIntDate();
		int year = requestClient.getIntYear();
		String monthString = requestClient.getStrMonth();
		String fullDate = dobHelper.getWholeDate(date, monthString, year);
		System.out.println(fullDate);
		model.addAttribute("fullDate", fullDate);
		model.addAttribute("requestClients", requestClients);
		model.addAttribute("reqId", reqId);
		model.addAttribute("phyID", phyID);
		model.addAttribute("DOS", DOS);
		List<EncounterForm> encounterList = encounterDao.getformList(request);
		if (encounterList.size() > 0) {

			model.addAttribute("encounterList", encounterList);
		}
		return "/provider/encounterForm";
	}

	@PostMapping("/encounter/submitEncounter/{reqId}")
	public String submitEncounter(@PathVariable("reqId") int reqId, @ModelAttribute EncounterDto encounterDto) {
		encounterService.service(reqId, encounterDto);
		return "redirect:/encounter/{reqId}";
	}
	
	@PostMapping("/submitEncounterProvider/{reqId}")
	public String submitEncounterProvider(@PathVariable("reqId") int reqId, @ModelAttribute EncounterDto encounterDto, @RequestParam("phyID") int phyID) {
		encounterService.service(reqId, encounterDto);
		return "redirect:/provider/encounter/" + reqId + "/" + phyID;
	}
	
	@GetMapping("/finalize/{reqId}/{phyID}")
	public String finalize(@PathVariable("reqId") int reqId, @PathVariable("phyID") int phyId)
	{
		encounterService.finalize(reqId);
		return "redirect:/provider/" + phyId;
		
	}


	@RequestMapping("/myProfile/{userID}")
	public String myProfile(@PathVariable("userID") int userID, Model model) {
		String activeString = "active  text-info";
		model.addAttribute("activeString1", activeString);

		List<User> users = userDao.getUserIDList(userID);
		User user = users.get(0);
		List<Admin> admins = adminDao.getAdmin(user.getAspnetUserId());
		model.addAttribute("admins", admins);
		model.addAttribute("users", users);

		return "/admin/MyProfile";
	}

	@PostMapping("/resetPassword/{aspnetUserId}/{userID}")
	public String resetPassword(@PathVariable("aspnetUserId") int Id, @PathVariable("userID") int userID,
			@RequestParam("password") String password) {
		myProfileService.reset(Id, password);
		return "redirect:/myProfile/{userID}";
	}

	@PostMapping("/adminEdit/{aspnetUserId}/{userID}")
	public String adminEdit(@PathVariable("aspnetUserId") int Id, @PathVariable("userID") int userID,
			@RequestParam("firstName") String fname, @RequestParam("lastName") String lname,
			@RequestParam("email") String email, @RequestParam("phone") String phone,
			@RequestParam("state") String state, @RequestParam("region") String region) {
		myProfileService.editAdmin(Id, fname, lname, email, phone, region, state, userID);
		return "redirect:/myProfile/{userID}";
	}

	@PostMapping("/editBilling/{aspnetUserId}/{userID}")
	public String editBilling(@PathVariable("aspnetUserId") int Id, @PathVariable("userID") int userID,
			@RequestParam("address1") String address1, @RequestParam("address2") String address2,
			@RequestParam("city") String city, @RequestParam("phone") String phone, @RequestParam("state") String state,
			@RequestParam("zip") String zip) {
		myProfileService.editBilling(Id, address1, address2, city, state, phone, zip);
		return "redirect:/myProfile/{userID}";
	}

	@RequestMapping("/providerMenu")
	public String providerMenu(Model model) {
		String activeString = "active  text-info";
		model.addAttribute("active", activeString);
		List<Physician> physicians = physicianDao.getPhysiciansAll();
		model.addAttribute("phy", physicians);
		return "/admin/providerMenu";
	}

	@RequestMapping("/addProvider")
	public String addProvider(Model model) {
		String activeString = "active  text-info";
		model.addAttribute("active", activeString);
		return "/admin/addProvider";
	}

	@PostMapping("/addProvider")
	public String createProvider(@ModelAttribute CreateProviderDto createProviderDto) {
		providerService.createProvider(createProviderDto);
		return "redirect:/providerMenu";
	}

	@RequestMapping("/editProvider/{physicianId}")
	public String editProvider(Model model, @PathVariable("physicianId") int physicianId) {
		String activeString = "active  text-info";
		model.addAttribute("active", activeString);

		List<Physician> physicians = physicianDao.getPhysiciansAll(physicianId);
		model.addAttribute("p", physicians);
		return "/admin/editProvider";
	}
	
	@RequestMapping("/provider/myProfile/{physicianId}")
	public String myProfileProvider(Model model, @PathVariable("physicianId") int physicianId) {
		String activeString = "active  text-info";
		model.addAttribute("active", activeString);

		List<Physician> physicians = physicianDao.getPhysiciansAll(physicianId);
		model.addAttribute("p", physicians);
		return "/provider/myProfile";
	}
	
	@PostMapping("/resetPhys/{physicianId}/{id}")
	public String resetStringProvider(@ModelAttribute CreateProviderDto createProviderDto,
			@PathVariable("physicianId") int physicianId, @PathVariable("id") int id) {
		providerService.reset(createProviderDto, id, physicianId);
		return "redirect:/provider/myProfile/{physicianId}";

	}
	
	@PostMapping("reqAdmin/{phyId}/{aspId}")
	public String reqAdmin(@PathVariable("phyId") int phyId, @PathVariable("aspId")int id, @RequestParam("textEdit") String notes)
	{
		sendLinkService.SendRequestToAdmin(id, notes, phyId);
		return "/provider/myProfile";
	}


	@PostMapping("/resetPhy/{physicianId}/{id}")
	public String resetString(@ModelAttribute CreateProviderDto createProviderDto,
			@PathVariable("physicianId") int physicianId, @PathVariable("id") int id) {
		providerService.reset(createProviderDto, id, physicianId);
		return "redirect:/editProvider/{physicianId}";

	}

	@PostMapping("/resetPhy1/{physicianId}/{id}")
	public String resetString1(@ModelAttribute CreateProviderDto createProviderDto,
			@PathVariable("physicianId") int physicianId, @PathVariable("id") int id) {
		providerService.reset1(createProviderDto, id, physicianId);
		return "redirect:/editProvider/{physicianId}";

	}

	@PostMapping("/resetPhy2/{physicianId}/{id}")
	public String resetString2(@ModelAttribute CreateProviderDto createProviderDto,
			@PathVariable("physicianId") int physicianId, @PathVariable("id") int id) {
		providerService.reset2(createProviderDto, id, physicianId);
		return "redirect:/editProvider/{physicianId}";

	}

	@PostMapping("/resetPhy3/{physicianId}/{id}")
	public String resetString3(@ModelAttribute CreateProviderDto createProviderDto,
			@PathVariable("physicianId") int physicianId, @PathVariable("id") int id) {
		providerService.reset3(createProviderDto, id, physicianId);
		return "redirect:/editProvider/{physicianId}";

	}

	@RequestMapping("/partners")
	public String partners(Model model) {
		String activeString = "active  text-info";
		model.addAttribute("active2", activeString);
		List<HealthProfessionals> healthProfessionals = partnerService.Service();
		model.addAttribute("partners", healthProfessionals);

		return "/admin/partners";
	}

	@PostMapping("/addBusiness")
	public String addBusiness(Model model, @ModelAttribute AddBusinessDto addBusinessDto) {
		partnerService.addBusiness(addBusinessDto);

		return "redirect:/partners";
	}

	@RequestMapping("/addBusiness")
	public String addBusiness(Model model) {
		String activeString = "active  text-info";
		model.addAttribute("active2", activeString);
		return "/admin/addBusiness";
	}

	@RequestMapping("/editBusiness/{vendorId}")
	public String editBusiness(Model model, @PathVariable("vendorId") int Id) {
		String activeString = "active  text-info";
		model.addAttribute("active2", activeString);
		List<HealthProfessionals> healthProfessionals = partnerService.Service1(Id);
		HealthProfessionals healthProfessionals2 = healthProfessionals.get(0);
		model.addAttribute("health", healthProfessionals2);
		model.addAttribute("vendorId", Id);
		return "/admin/editBusiness";
	}

	@RequestMapping("/deletePartner/{vendorId}")
	public String deletePartner(@PathVariable("vendorId") int id) {
		partnerService.delete(id);
		return "redirect:/partners";
	}

	@PostMapping("/editBusiness/updateBusiness/{vendorId}")
	public String updateBusiness(@ModelAttribute AddBusinessDto addBusinessDto, @PathVariable("vendorId") int vendorId,
			Model model) {
		partnerService.updateBusiness(addBusinessDto, vendorId);
		model.addAttribute("vendorId", vendorId);
		return "redirect:/editBusiness/{vendorId}";
	}

	@RequestMapping("/accountAccess")
	public String accountAccess(Model model) {
		String activeString = "active  text-info";
		List<Role> roles = createRoleService.getRoles();
		model.addAttribute("roles", roles);
		model.addAttribute("active3", activeString);
		return "/admin/accountAccess";
	}

	@RequestMapping("/createRole")
	public String createRole(Model model) {
		String activeString = "active  text-info";
		int accountType = 0;
		List<Menu> dataList = createRoleService.createRole(accountType);
		model.addAttribute("role", dataList);
		model.addAttribute("active3", activeString);
		return "/admin/createRole";
	}

	@RequestMapping("/editRole/{roleId}")
	public String editRole(Model model, @PathVariable("roleId") int id) {
		String activeString = "active  text-info";
		EditRoleDto editRoleDto = createRoleService.getExistingRoles(id);

		model.addAttribute("roles", editRoleDto);
		model.addAttribute("roleId", id);
		model.addAttribute("active3", activeString);
		return "/admin/editRole";
	}

	@RequestMapping("/userAccess")
	public String userAccess(Model model) {
		String activeString = "active  text-info";
		List<UserAccessDto> userAccessDtos = userAccessService.getUserData();
		model.addAttribute("userData", userAccessDtos);
		model.addAttribute("active3", activeString);
		return "/admin/userAccess";
	}

	@RequestMapping("/searchRecords")
	public String searchRecords(Model model) {
		String activeString = "active  text-info";
		model.addAttribute("active4", activeString);
		return "/admin/searchRecords";
	}

	@RequestMapping("/patientRecords")
	public String patientRecords(Model model) {
		String activeString = "active  text-info";
		model.addAttribute("active4", activeString);

		return "/admin/patientHistory1";
	}

	@RequestMapping("/patientRecords1/{uId}")
	public String patientRecords1(Model model, @PathVariable("uId") int uId) {
		String activeString = "active  text-info";
		model.addAttribute("active4", activeString);
		List<PatientRecordsDto> patientRecordsDtos = patientRecordsService.pRecords(uId);
		model.addAttribute("patientRecords", patientRecordsDtos);

		return "/admin/patientRecords";
	}

	@PostMapping(path = "/ajaxforPatientHistory")
	@ResponseBody
	public List<PatientHistoryDto> ajaxforPatientHistory(Model model, HttpServletRequest request,
			@RequestParam("fName") String fName, @RequestParam("lName") String lName,
			@RequestParam("email") String email, @RequestParam("phone") String phone) {
		List<PatientHistoryDto> patientHistoryDtos = patientHistoryService.PatientHistory(fName, lName, email, phone);

		return patientHistoryDtos;

	}

	@PostMapping(path = "/ajaxforEmailLogs")
	@ResponseBody
	public List<EmailLogsDto> ajaxforEmailLogs(Model model, HttpServletRequest request,
			@RequestParam("role") String role, @RequestParam("name") String name, @RequestParam("email") String email,
			@RequestParam("createdDate") String createdDate, @RequestParam("sentDate") String sentDate) {
		List<EmailLogsDto> emailLogsDtos = emailRecordsService.emailLogs(role, name, email, createdDate, sentDate);

		return emailLogsDtos;

	}

	@RequestMapping("/emailLogs")
	public String emailLogs(Model model) {
		String activeString = "active  text-info";
		model.addAttribute("active4", activeString);

		return "/admin/emailLogs";
	}

	@RequestMapping("/smsLogs")
	public String smsLogs(Model model) {
		String activeString = "active  text-info";
		model.addAttribute("active4", activeString);

		return "/admin/smsLogs";
	}

	@PostMapping(path = "/ajaxforSMSLogs")
	@ResponseBody
	public List<SMSLogDto> ajaxforSMSLogs(Model model, HttpServletRequest request, @RequestParam("role") String role,
			@RequestParam("name") String name, @RequestParam("email") String email,
			@RequestParam("createdDate") String createdDate, @RequestParam("sentDate") String sentDate) {
		List<SMSLogDto> smsLogDtos = smsRecordsService.SMSLogs(role, name, email, createdDate, sentDate);

		return smsLogDtos;

	}

	@RequestMapping("/blockHistory")
	public String blockHistory(Model model) {
		String activeString = "active  text-info";

		model.addAttribute("active4", activeString);
		return "/admin/blockHistory";
	}

	@PostMapping(path = "/ajaxforBlock")
	@ResponseBody
	public List<BlockRecordsDto> ajaxforBlock(Model model, HttpServletRequest request,
			@RequestParam("name") String name, @RequestParam("date") String createdDate,
			@RequestParam("email") String email, @RequestParam("phone") String phone) {
		List<BlockRecordsDto> blockRequests = blockRecordsService.showReq(name, createdDate, email, phone);

		return blockRequests;

	}

	@PostMapping(path = "/ajaxforSearchHistory")
	@ResponseBody
	public List<SearchRecordsDto> ajaxforSearchHIstory(Model model, HttpServletRequest request,
			@RequestParam("status") String status, @RequestParam("name") String name,
			@RequestParam("reqType") String reqType, @RequestParam("DOS") String DOS, @RequestParam("TDOS") String TDOS,
			@RequestParam("phy") String phy, @RequestParam("email") String email, @RequestParam("phone") String phone) {
		List<SearchRecordsDto> searchRecordsDtos = searchHistoryService.showReq(status, name, reqType, DOS, TDOS, phy,
				email, phone);

		return searchRecordsDtos;

	}

	@RequestMapping("unblock/{request_id}/{block_request_id}")
	public String unblock(@PathVariable("request_id") int id, @PathVariable("block_request_id") int bId) {
		blockRecordsService.unblock(id, bId);
		return "redirect:/blockHistory";
	}

	@GetMapping("/deleteRecord/{reqId}")
	public String deleteRecord(@PathVariable("reqId") int rId) {
		searchHistoryService.deleteRecord(rId);
		return "redirect:/searchRecords";
	}

	@GetMapping("/deleteRole/{roleId}")
	public String deleteRole(@PathVariable("roleId") int roleId) {
		createRoleService.deleteRole(roleId);
		return "redirect:/accountAccess";
	}
	
	@GetMapping("/provider/consult/{id}/{x}")
	public String consultCase(@PathVariable("id") int phyId, @PathVariable("x") int reqId)
	{
		clearCaseService.consultCase(reqId, phyId);
		return "redirect:/provider/" + phyId;
	}
	
	@GetMapping("/provider/housecall/{id}/{x}")
	public String houseCallCase(@PathVariable("id") int phyId, @PathVariable("x") int reqId)
	{
		clearCaseService.housecall(reqId, phyId);
		return "redirect:/provider/" + phyId;
	}
	
	@GetMapping("/provider/housecalls/{phyID}/{id}")
	public String houseCall(@PathVariable("phyID") int phyId, @PathVariable("id") int reqId)
	{
		clearCaseService.housecall2(reqId, phyId);
		return "redirect:/provider/" + phyId;
	}



}
