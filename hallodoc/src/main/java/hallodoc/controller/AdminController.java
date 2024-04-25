package hallodoc.controller;

import java.io.ByteArrayInputStream;
import java.io.Console;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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

import hallodoc.dto.AdminDashboardDto;
import hallodoc.dto.AdminLoginDto;
import hallodoc.dto.AssignCaseDto;
import hallodoc.dto.BlockCaseDto;
import hallodoc.dto.CancelCaseDto;
import hallodoc.dto.CloseCaseDto;
import hallodoc.dto.CreateNewRequestDto;
import hallodoc.dto.EncounterDto;
import hallodoc.dto.SendLinkDto;
import hallodoc.dto.TransferCaseDto;
import hallodoc.dto.ViewCaseDto;
import hallodoc.dto.ViewDocumentsDTO;
import hallodoc.dto.ViewNotesDto;
import hallodoc.dto.ordersDto;
import hallodoc.helper.DobHelper;
import hallodoc.model.CaseTag;
import hallodoc.model.EncounterForm;
import hallodoc.model.Physician;
import hallodoc.model.Request;
import hallodoc.model.RequestClient;
import hallodoc.model.User;
import hallodoc.model.Users;
import hallodoc.repo.AdminDashboardDao;
import hallodoc.repo.EncounterDao;
import hallodoc.repo.UserDao;
import hallodoc.service.AdminDashboardService;
import hallodoc.service.AssignCaseService;
import hallodoc.service.BlockCaseService;
import hallodoc.service.CancelCaseService;
import hallodoc.service.ClearCaseService;
import hallodoc.service.CloseCaseService;
import hallodoc.service.CreateNewRequestService;
import hallodoc.service.CreateService;
import hallodoc.service.EncounterService;
import hallodoc.service.ExportAllService;
import hallodoc.service.RequestClientService;
import hallodoc.service.RequestService;
import hallodoc.service.SendAgreementService;
import hallodoc.service.SendLinkService;
import hallodoc.service.TransferCaseService;
import hallodoc.service.UsersService;
import hallodoc.service.ViewCaseService;
import hallodoc.service.ViewDocsService;
import hallodoc.service.ViewNotesService;
import hallodoc.service.ordersService;
import hallodoc.service.searchService;

@Controller
public class AdminController {

	@Autowired
	private UsersService usersService;

	@Autowired
	private AdminDashboardDao adminDashboardDao;
	
	@Autowired
	private ordersService ordersService;
	
	@Autowired
	private EncounterService encounterService;

	@Autowired
	private AdminDashboardService adminDashboardService;
	
	@Autowired
	private CloseCaseService closeCaseService;

	@Autowired
	private RequestService requestService;
	
	@Autowired
	private EncounterDao encounterDao;

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

	@RequestMapping("/admin")
	public String dashboard(Model model, HttpServletRequest request,
			@CookieValue(value = "emailId", defaultValue = "error") String emailId) {

		List requestList = adminDashboardDao.getRequests();

		List<CaseTag> reasonsList = cancelCaseService.getReasons();
		HttpSession session = request.getSession();
		String sessionIdString = session.getId();

		String emailString = (String) session.getAttribute("email");
		/*
		 * Cookie[] cookies = request.getCookies();
		 * 
		 * Cookie cookie = cookies[cookies.length-1]; System.out.println(
		 * "00000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000"
		 * ); System.out.println(sessionIdString); System.out.println(cookie.getName());
		 * System.out.println(cookie.getValue());
		 */
		System.out.println(emailId);

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
		session.getAttribute("userList");

		return "/admin/ViewCase";
	}

	@RequestMapping(path = "/viewNotes/{requestId}")
	public String viewNotes(@PathVariable("requestId") int requestId, Model model,
			@ModelAttribute ViewNotesDto viewNotesDto) {

		List<Request> requests = requestService.getRequestByReqId(requestId);
		Request request = requests.get(0);
		model.addAttribute("requestId", requestId);
		ViewNotesDto viewNotesDtos = viewNotesService.service(requestId, viewNotesDto);
		System.out.println(viewNotesDtos);
		System.out.println("9999999999999999999999999999999999999999999999999999999999999999999999999999");
		model.addAttribute("viewNotesDtos", viewNotesDtos);

		return "/admin/ViewNotes";
	}

	@RequestMapping("/createReq/{userID}")
	public String creteRequest(@PathVariable("userID") int userID) {

		return "/admin/CreateRequest";
	}

	@RequestMapping(path = "/viewCase/viewNotes/{requestId}")
	public String viewNotess(@PathVariable("requestId") int requestId, Model model,
			@ModelAttribute ViewNotesDto viewNotesDto) {

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

	@RequestMapping(path = "/createReq/new/{userID}", method = RequestMethod.POST)
	public String CreateNewRequest(@PathVariable("userID") int userID,
			@ModelAttribute CreateNewRequestDto createNewRequestDto) {
		List<User> users = userDao.getUserIDList(userID);
		User user = users.get(0);
		createNewRequestService.service(createNewRequestDto, userID, create.ajaxCheck(createNewRequestDto.getEmail()));
		return "redirect:/createReq/{userID}";

	}

	@RequestMapping(path = "/send", method = RequestMethod.POST)
	public String SendMail(@ModelAttribute SendLinkDto sendLinkDto) {
		sendLinkService.service(sendLinkDto);
		return "redirect:/admin";

	}

	@RequestMapping(path = "/sendAgreementAction", method = RequestMethod.POST)
	public String sendAgreementAction(@RequestParam("email23") String email, @RequestParam("reqId6") int reqId) {
		sendLinkService.sendAgreementService(email, reqId);
		return "redirect:/admin";

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

	@RequestMapping("/viewDocs/{requestId}")
	public String viewDocs(@PathVariable("requestId") int requestId, Model model, HttpServletRequest request1,
			HttpSession session) {

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

	@RequestMapping("/viewDocs/{requestId}/{id}/delete")
	public String deleteFile(@PathVariable("id") int id, @PathVariable("requestId") String rId) {
		viewDocsService.delete(id);
		return "redirect:/viewDocs/{requestId}";

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
	
	@RequestMapping(path = "orders/{requestId}")
	public String orders(@PathVariable("requestId") int reqId, Model model)

	{
		model.addAttribute("reqId", reqId);
		return ("/admin/orders");

	}
	
	@RequestMapping(path = "/orders/sendOrders/{requestId}", method = RequestMethod.POST)
	public String sendOrders(@ModelAttribute ordersDto ordersDto)

	{
		ordersService.sendOrders(ordersDto);
		return "redirect:/admin";

	}
	
	@RequestMapping(path = "/closeCase/{requestId}")
	public String closecase(@PathVariable("requestId") int requestId, Model model, HttpServletRequest request1)

	{
		
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
	public String caseClosed(@PathVariable("requestId")int reqId)
	{
		closeCaseService.caseClosed(reqId);
		return "redirect:/admin";
		
	}
	
	@RequestMapping("/encounter/{requestId}")
	public String encounter(@PathVariable("requestId") int reqId, Model model)
	{
	List<Request> requests = requestService.getRequestByReqId(reqId);
	Request request = requests.get(0);
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
	List<EncounterForm> encounterList = encounterDao.getformList(request);
	if(encounterList.size()>0) {
	
	model.addAttribute("encounterList", encounterList);
	}
	return "/admin/encounterForm";
	}
	
	@PostMapping("/encounter/submitEncounter/{reqId}")
	public String submitEncounter(@PathVariable("reqId")int reqId, @ModelAttribute EncounterDto encounterDto) {
		encounterService.service(reqId, encounterDto);
		return "redirect:/encounter/{reqId}";
	}
	
	@RequestMapping("/myProfile/{userID}")
	public String myProfile(@PathVariable("userID") int userID, Model model)
	{
		String activeString = "active  text-info";
		model.addAttribute("activeString1", activeString);
		return "/admin/MyProfile";
	}
	
	@RequestMapping("/providerMenu")
	public String providerMenu( Model model)
	{
		String activeString = "active  text-info";
		model.addAttribute("active", activeString);
		return "/admin/providerMenu";
	}

	@RequestMapping("/providerMenu/addProvider")
	public String addProvider( Model model)
	{
		String activeString = "active  text-info";
		model.addAttribute("active", activeString);
		return "/admin/addProvider";
	}
	
	@RequestMapping("/editProvider")
	public String editProvider( Model model)
	{
		String activeString = "active  text-info";
		model.addAttribute("active", activeString);
		return "/admin/editProvider";
	}
	
	@RequestMapping("/partners")
	public String partners( Model model)
	{
		String activeString = "active  text-info";
		model.addAttribute("active2", activeString);
		return "/admin/partners";
	}
	
	@RequestMapping("/addBusiness")
	public String addBusiness( Model model)
	{
		String activeString = "active  text-info";
		model.addAttribute("active2", activeString);
		return "/admin/addBusiness";
	}
	
	@RequestMapping("/editBusiness")
	public String editBusiness( Model model)
	{
		String activeString = "active  text-info";
		model.addAttribute("active2", activeString);
		return "/admin/editBusiness";
	}
	
	@RequestMapping("/accountAccess")
	public String accountAccess( Model model)
	{
		String activeString = "active  text-info";
		model.addAttribute("active3", activeString);
		return "/admin/accountAccess";
	}
	
	@RequestMapping("/createRole")
	public String createRole( Model model)
	{
		String activeString = "active  text-info";
		model.addAttribute("active3", activeString);
		return "/admin/createRole";
	}
	
	@RequestMapping("/editRole")
	public String editRole( Model model)
	{
		String activeString = "active  text-info";
		model.addAttribute("active3", activeString);
		return "/admin/editRole";
	}
	
	@RequestMapping("/userAccess")
	public String userAccess( Model model)
	{
		String activeString = "active  text-info";
		model.addAttribute("active3", activeString);
		return "/admin/userAccess";
	}
	
	@RequestMapping("/searchRecords")
	public String searchRecords( Model model)
	{
		String activeString = "active  text-info";
		model.addAttribute("active4", activeString);
		return "/admin/searchRecords";
	}
	
	@RequestMapping("/patientRecords")
	public String patientRecords( Model model)
	{
		String activeString = "active  text-info";
		model.addAttribute("active4", activeString);
		return "/admin/patientRecords";
	}
	
	@RequestMapping("/emailLogs")
	public String emailLogs( Model model)
	{
		String activeString = "active  text-info";
		model.addAttribute("active4", activeString);
		return "/admin/emailLogs";
	}
	
	@RequestMapping("/smsLogs")
	public String smsLogs( Model model)
	{
		String activeString = "active  text-info";
		model.addAttribute("active4", activeString);
		return "/admin/smsLogs";
	}
	
	@RequestMapping("/blockHistory")
	public String blockHistory( Model model)
	{
		String activeString = "active  text-info";
		model.addAttribute("active4", activeString);
		return "/admin/blockHistory";
	}
	
	


}
