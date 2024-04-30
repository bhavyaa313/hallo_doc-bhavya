package hallodoc.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import hallodoc.dto.InfoSomeoneDto;
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



@Service
public class InfoSomeoneService {

	@Autowired
	private UserDao userDao;
	
	@Autowired
	private UsersDao usersDao;
	
	@Autowired
	private AspNetUsersDao aspnetUserDao;

	@Autowired
	private RequestDao requestDao;
	
	@Autowired
	private RequestService requestService;

	@Autowired
	private RequestClientDao requestClientDao;

	@Autowired
	private RequestWiseFileDao reqWiseFileDao;
	
	@Autowired
	private UsersService usersService;
	
	@Autowired
	private TokenChecker tokenChecker;
	
	@Autowired
	private VerificationTokenDao verificationTokenDao;
	
	@Autowired
	private mailService mailService;

	
	private RegionEnum regionEnum;
	
	@Transactional
	public void InfoForElseservice(InfoSomeoneDto infoForElseDto, String userID) {

		String symptoms = infoForElseDto.getSymptoms();
		String pFname = infoForElseDto.getpFname();
		String pLname = infoForElseDto.getpLname();
		String pDob = infoForElseDto.getpDob();
		String pEmail = infoForElseDto.getpEmail();
		String pPhoneNo = infoForElseDto.getpPhoneNo();
		String pStreet = infoForElseDto.getpStreet();
		String pCity = infoForElseDto.getpCity();
		String pState = infoForElseDto.getpState();
		String pZipCode = infoForElseDto.getpZipCode();
		String pRoom = infoForElseDto.getpRoom();
		String relation = infoForElseDto.getRelation();
		CommonsMultipartFile file = infoForElseDto.getFile();
		int regionId = RegionEnum.valueOf(pState).getid();

		LocalDate currentDate;
		String creString = LocalDateTime.now().toLocalDate().toString();
		LocalDate date = LocalDate.now();
		String forString = date.getDayOfMonth() + "" + date.getMonthValue()+ "" + date.getYear();
		String abbrString;
		try {
			 abbrString = RegionEnum.valueOf(pState.toUpperCase()).getAbbr();
			  System.out.println("Abbreviation for " + pState + ": " + abbrString);
			} catch (IllegalArgumentException e) {
			  System.out.println("State not found: " + pState);
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
		String confirString = abbrString + pFname.toUpperCase().substring(0, 2) + pLname.toUpperCase().substring(0, 2) + forString.substring(0, 4)+ count; 
				
		boolean test = false;
		if (!pDob.isEmpty()) {
			currentDate = LocalDate.parse(pDob);
			test = true;
		} else {
			currentDate = null;
		}
		
		Integer uId = Integer.parseInt(userID);
		List<User> listOfUser = userDao.getUserIDList(uId);
		User userRequestor = listOfUser.get(0);
		
		Request request = new Request();
		RequestClient requestClient = new RequestClient();
		RequestWiseFile requestWiseFile = new RequestWiseFile();

		// pemail exists in aspnetusers
		if (usersService.checkEmail6(pEmail)) {

			// check for null pswd(mail send)
			System.out.println("emailcheck............///////////////................/////////////..........");
			if (usersService.checkPasswordHash(pEmail)) {
				VerificationToken verificationToken = new VerificationToken();
				verificationToken.setEmail(pEmail);
				verificationToken.setCreated_date(LocalDateTime.now());
				 
					String token = new TokenGenerator().GenerateToken();
					verificationToken.setToken(token);

				String mailUrl = "http://localhost:8080/hallodoc/reset" + token;
				mailService.send(pEmail, "Validation", mailUrl);

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
				
			}
			
			List<User> liusUsers = usersDao.checkEmail1(pEmail);
			User userPatientUser = liusUsers.get(0);
			
			request.setUserId(userPatientUser);
			request.setFirstName(userRequestor.getFirstName());
			request.setLastName(userRequestor.getLastName());
			request.setPhoneNumber(userRequestor.getMobile());
			request.setEmail(userRequestor.getEmail());
			request.setStatus(1);
			request.setConfirmationNumber(confirString);
			request.setCreatedDate(LocalDateTime.now());
			
			requestDao.requestSave(request);

			requestClient.setRequestId(request);
			requestClient.setFirstName(pFname);
			requestClient.setLastName(pLname);
			requestClient.setPhoneNumber(pPhoneNo);
			requestClient.setNotes(symptoms);
			requestClient.setRegionId(regionId);
			requestClient.setEmail(pEmail);
			if (test) {
				requestClient.setStrMonth(new DateModifier().getMonth(currentDate));
				requestClient.setIntYear(new DateModifier().getYear(currentDate));
				requestClient.setIntDate(new DateModifier().getDay(currentDate));
			}
			requestClient.setStreet(pStreet);
			requestClient.setCity(pCity);
			requestClient.setState(pState);
			requestClient.setZipcode(pZipCode);
			requestClientDao.requestClientSave(requestClient);
			if(!file.isEmpty()) {
			requestWiseFile.setRequestId(request);
			requestWiseFile.setFileName(file.getOriginalFilename());
			requestWiseFile.setCreatedDate(LocalDateTime.now());
			requestWiseFile.setUploader(pFname + " " + pLname);
			reqWiseFileDao.requestWiseFileSave(requestWiseFile);
			}
	
		} else {
			
			System.out.println("in else part..........'''''''/////////.........,,,,,,,");

			// mail send
			VerificationToken verificationToken = new VerificationToken();
			verificationToken.setEmail(pEmail);
			verificationToken.setCreated_date(LocalDateTime.now());
			 
				String token = new TokenGenerator().GenerateToken();
				verificationToken.setToken(token);

			String mailUrl = "http://localhost:8080/hallodoc/create" + token;
			mailService.send(pEmail, "Validation", mailUrl);

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
			
			// aspnet user table entry
			AspNetUsers aspNetUsers = new AspNetUsers();
			User userPatient = new User();

			aspNetUsers.setPasswordHash(null);
			aspNetUsers.setEmail(pEmail);
			aspNetUsers.setPhoneNumber(pPhoneNo);
			aspNetUsers.setUserName(pEmail);
			aspNetUsers.setCreatedDate(LocalDateTime.now());
			aspnetUserDao.aspSave(aspNetUsers);

			userPatient.setFirstName(pFname);
			userPatient.setLastName(pLname);
			userPatient.setEmail(pEmail);
			userPatient.setMobile(pPhoneNo);
			if (test) {
				userPatient.setStrMonth(new DateModifier().getMonth(currentDate));
				userPatient.setIntYear(new DateModifier().getYear(currentDate));
				userPatient.setIntDate(new DateModifier().getDay(currentDate));
			}
			userPatient.setCreatedDate(LocalDateTime.now());
			
			userPatient.setAspnetUserId(aspNetUsers);
			userPatient.setRequestWithEmail(true);
			userDao.userSave(userPatient);

			

			
			
			request.setUserId(userPatient);
			request.setFirstName(userRequestor.getFirstName());
			request.setLastName(userRequestor.getLastName());
			request.setPhoneNumber(userRequestor.getMobile());
			request.setEmail(userRequestor.getEmail());
			request.setStatus(1);
			request.setConfirmationNumber(confirString);
			request.setCreatedDate(LocalDateTime.now());
		
			requestDao.requestSave(request);

			requestClient.setRequestId(request);
			requestClient.setFirstName(pFname);
			requestClient.setLastName(pLname);
			requestClient.setPhoneNumber(pPhoneNo);
			requestClient.setNotes(symptoms);
			requestClient.setEmail(pEmail);
			if (test) {
				requestClient.setStrMonth(new DateModifier().getMonth(currentDate));
				requestClient.setIntYear(new DateModifier().getYear(currentDate));
				requestClient.setIntDate(new DateModifier().getDay(currentDate));
			requestClient.setStreet(pStreet);
			requestClient.setCity(pCity);
			requestClient.setState(pState);
			requestClient.setZipcode(pZipCode);
			requestClient.setRegionId(regionId);
//			requestClient.setRegionId(1);
			requestClientDao.requestClientSave(requestClient);
			if(!file.isEmpty()) {
			requestWiseFile.setRequestId(request);
			requestWiseFile.setFileName(file.getOriginalFilename());
			requestWiseFile.setCreatedDate(LocalDateTime.now());
			requestWiseFile.setUploader(userRequestor.getFirstName() + " " + userRequestor.getLastName());
			reqWiseFileDao.requestWiseFileSave(requestWiseFile);
			}
			
		}
		
	}

	}
}
