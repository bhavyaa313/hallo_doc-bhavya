package hallodoc.controller;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
import hallodoc.dto.CreateNewRequestDto;
import hallodoc.dto.SendLinkDto;
import hallodoc.dto.TransferCaseDto;
import hallodoc.dto.ViewCaseDto;
import hallodoc.dto.ViewDocumentsDTO;
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
import hallodoc.service.ClearCaseService;
import hallodoc.service.CreateNewRequestService;
import hallodoc.service.CreateService;
import hallodoc.service.ExportAllService;
import hallodoc.service.RequestClientService;
import hallodoc.service.RequestService;
import hallodoc.service.SendLinkService;
import hallodoc.service.TransferCaseService;
import hallodoc.service.UsersService;
import hallodoc.service.ViewCaseService;
import hallodoc.service.ViewDocsService;
import hallodoc.service.ViewNotesService;
import hallodoc.service.searchService;

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

			List<AdminDashboardDto> adminDashboardDtos = adminDashboardService.service();
			Integer[] counts = adminDashboardService.count();
			session.setAttribute("adminDashboardDtos", adminDashboardDtos);
			session.setAttribute("counts", counts);
			model.addAttribute("reasonsList", reasonsList);
			System.out.println(adminDashboardDtos);

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
			@PathVariable("valueofInput") String input, @PathVariable("roleWiseId") String roString, @PathVariable("regionWiseSearch")String region ) {
		System.out.println("this is ajax call");
		List<AdminDashboardDto> adminDashboardDtos = adminDashboardService.service();
		searchService.search(class1, input, roString, region);
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

	

}
