package hallodoc.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import javax.management.loading.PrivateClassLoader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import hallodoc.dto.FamilyInfoDto;
import hallodoc.dto.PatientInfoDto;
import hallodoc.enums.RegionEnum;
import hallodoc.helper.DateModifier;
import hallodoc.helper.TokenChecker;
import hallodoc.helper.TokenGenerator;
import hallodoc.model.AspNetUsers;
import hallodoc.model.Request;
import hallodoc.model.RequestClient;
import hallodoc.model.RequestWiseFile;
import hallodoc.model.User;
import hallodoc.model.VerificationToken;
import hallodoc.repo.AspNetUsersDao;
import hallodoc.repo.RequestClientDao;
import hallodoc.repo.RequestDao;
import hallodoc.repo.RequestWiseFileDao;
import hallodoc.repo.UserDao;
import hallodoc.repo.UsersDao;
import hallodoc.repo.VerificationTokenDao;

@Component
public class FamilyInfoService {

	@Autowired
	private RequestDao requestDao;
	@Autowired
	private RequestClientDao requestClientDao;
	@Autowired
	private RequestWiseFileDao requestWiseFileDao;
	
	@Autowired
	private VerificationTokenDao verificationTokenDao;
	
	
	@Autowired
	private UsersDao usersDao;
	
	@Autowired
	private CreateService createService;
	
	@Autowired
	private TokenChecker tokenChecker;
	
	@Autowired
	private TokenGenerator tokenGenerator;
	
	@Autowired
	private mailService mailService;
	
	@Autowired
	private AspNetUsersDao aspNetUsersDao;
	
	@Autowired
	private RequestService requestService;
	
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private UsersService usersService;
	
	
	private RegionEnum regionEnum;


	public void service(FamilyInfoDto familyInfoDto , boolean test_p) {
		String sympton = familyInfoDto.getSympton();
		String fname = familyInfoDto.getFirstName();
		String lname = familyInfoDto.getLastName();
		String email = familyInfoDto.getEmail();
		String mobile = familyInfoDto.getMobile();
		String pfname = familyInfoDto.getpFirstName();
		String plname = familyInfoDto.getPlastName();
		String pemail = familyInfoDto.getpEmail();
		String pmobile = familyInfoDto.getpMobile();
		String street = familyInfoDto.getStreet();
		String city = familyInfoDto.getCity();
		String state = familyInfoDto.getState();
		String zipcode = familyInfoDto.getZipcode();
		CommonsMultipartFile file_name = familyInfoDto.getFile_name();
		String creString = LocalDateTime.now().toLocalDate().toString();
		LocalDate date = LocalDate.now();
		String forString = date.getDayOfMonth() + "" + date.getMonthValue()+ "" + date.getYear();

		LocalDateTime cdate = familyInfoDto.getCreated_date();
		String dob = familyInfoDto.getDOB();
		int regionId = RegionEnum.valueOf(state).getid();
		String abbrString;
		try {
			 abbrString = RegionEnum.valueOf(state.toUpperCase()).getAbbr();
			  System.out.println("Abbreviation for " + state + ": " + abbrString);
			} catch (IllegalArgumentException e) {
			  System.out.println("State not found: " + state);
			   abbrString = ""; // Or handle the exception differently if needed
			}
		
	
		
		
		List<Request> requests = requestService.getRequests();
		int count =1;
		for (int i = 0; i < requests.size(); i++) {
			
			Request request =  requests.get(i);
			 String xString =  request.getCreatedDate().toLocalDate().toString();
			 if (xString.equals(creString)) {
				count+=1;
			}
			 
			
		}
		String confirString = abbrString + pfname.toUpperCase().substring(0, 2) + plname.toUpperCase().substring(0, 2) + forString.substring(0, 4)+ count; 
				
				

		
		if (!test_p) {
			VerificationToken verificationToken = new VerificationToken();
			verificationToken.setEmail(pemail);
			verificationToken.setCreated_date(cdate);
			 
				String token = new TokenGenerator().GenerateToken();
				verificationToken.setToken(token);

			String mailUrl = "http://localhost:8080/hallodoc/reset" + token;
			mailService.send(pemail, "Validation", mailUrl);

			List<VerificationToken> tokenList = tokenChecker.checkMailStatusList(verificationToken.getEmail());

			if (tokenList.size() != 0) {
				VerificationToken lasVerificationToken = tokenList.get(tokenList.size() - 1);
				lasVerificationToken.setValidation(false);
				verificationToken.setValidation(true);
				verificationTokenDao.verificationTokenSave(verificationToken);
				verificationTokenDao.verificationTokenUpdate(lasVerificationToken);
			} else {
				verificationToken.setValidation(true);
				verificationTokenDao.verificationTokenSave(verificationToken);
			}
			
			AspNetUsers aspNetUsers = new AspNetUsers();
			User user = new User();
			aspNetUsers.setPasswordHash(null);
			aspNetUsers.setEmail(pemail);
			aspNetUsers.setPhoneNumber(pmobile);
			aspNetUsers.setEmail(pemail);
			aspNetUsers.setCreatedDate(cdate);
			
			user.setFirstName(pfname);
			user.setLastName(plname);
			user.setEmail(pemail);
			user.setMobile(pmobile);
			user.setRegionId(regionId);
			if (dob == null || dob.isEmpty()) {

			} else {
				LocalDate currentDate = LocalDate.parse(dob);
				user.setIntDate(new DateModifier().getDay(currentDate));
				user.setStrMonth(new DateModifier().getMonth(currentDate));
				user.setIntYear(new DateModifier().getYear(currentDate));
			}
			user.setCreatedDate(cdate);
			user.setAspnetUserId(aspNetUsers);
			user.setRequestWithEmail(true);
	
			
			aspNetUsersDao.aspSave(aspNetUsers);
			
			Request request = new Request();
			request.setUserId(user);
			request.setFirstName(fname);
			request.setLastName(lname);
			request.setPhoneNumber(mobile);
			request.setEmail(email);
			request.setCreatedDate(LocalDateTime.now());
			request.setConfirmationNumber(confirString);
			request.setRequestTypeId(3);

			RequestClient requestClient = new RequestClient();

			requestClient.setFirstName(pfname);
			requestClient.setLastName(plname);
			System.out.println(plname);
			requestClient.setPhoneNumber(pmobile);
			requestClient.setEmail(pemail);
			requestClient.setRegionId(regionId);
			requestClient.setStreet(street);
			requestClient.setCity(city);
			requestClient.setState(state);
			requestClient.setRequestId(request);
			requestClient.setZipcode(zipcode);
			if (dob == null || dob.isEmpty()) {

			} else {
				LocalDate currentDate = LocalDate.parse(dob);
				requestClient.setIntDate(new DateModifier().getDay(currentDate));
				requestClient.setStrMonth(new DateModifier().getMonth(currentDate));
				requestClient.setIntYear(new DateModifier().getYear(currentDate));
			}
			
			requestDao.requestSave(request);
			requestClientDao.requestClientSave(requestClient);
			
			if(!file_name.isEmpty()) {
			RequestWiseFile requestWiseFile = new RequestWiseFile();
			requestWiseFile.setRequestId(request);
			requestWiseFile.setCreatedDate(LocalDateTime.now());
			requestWiseFile.setFileName(file_name.getOriginalFilename());
			requestWiseFile.setUploader(fname + lname);
			requestWiseFileDao.requestWiseFileSave(requestWiseFile);
			}

			
			

			
		}
		
		else {
			User user = new User();

			Request request = new Request();
			request.setUserId(user);
			request.setFirstName(fname);
			request.setLastName(lname);
			request.setPhoneNumber(mobile);
			request.setEmail(email);
			request.setRequestTypeId(3);
			request.setConfirmationNumber(confirString);
			request.setCreatedDate(LocalDateTime.now());

			RequestClient requestClient = new RequestClient();

			requestClient.setFirstName(pfname);
			requestClient.setLastName(plname);
			System.out.println(plname);
			requestClient.setPhoneNumber(pmobile);
			requestClient.setEmail(pemail);
			requestClient.setRegionId(regionId);

			requestClient.setStreet(street);
			requestClient.setCity(city);
			requestClient.setState(state);
			requestClient.setRequestId(request);
			requestClient.setZipcode(zipcode);
			if (dob == null || dob.isEmpty()) {

			} else {
				LocalDate currentDate = LocalDate.parse(dob);
				requestClient.setIntDate(new DateModifier().getDay(currentDate));
				requestClient.setStrMonth(new DateModifier().getMonth(currentDate));
				requestClient.setIntYear(new DateModifier().getYear(currentDate));
			}

			requestDao.requestSave(request);
			requestClientDao.requestClientSave(requestClient);
			
			if(!file_name.isEmpty()) {
			RequestWiseFile requestWiseFile = new RequestWiseFile();
			requestWiseFile.setRequestId(request);
			requestWiseFile.setCreatedDate(LocalDateTime.now());
			requestWiseFile.setFileName(file_name.getOriginalFilename());
			requestWiseFileDao.requestWiseFileSave(requestWiseFile);
			}

		

			
		}
		
	}

}
