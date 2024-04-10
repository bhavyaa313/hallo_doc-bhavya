package hallodoc.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import javax.management.loading.PrivateClassLoader;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import hallodoc.dto.CoincergeDto;
import hallodoc.enums.RegionEnum;
import hallodoc.helper.DateModifier;
import hallodoc.helper.TokenChecker;
import hallodoc.helper.TokenGenerator;
import hallodoc.model.AspNetUsers;
import hallodoc.model.Concierge;
import hallodoc.model.Request;
import hallodoc.model.RequestClient;
import hallodoc.model.RequestConcierge;
import hallodoc.model.RequestWiseFile;
import hallodoc.model.User;
import hallodoc.model.VerificationToken;
import hallodoc.repo.AspNetUsersDao;
import hallodoc.repo.CoincergeDao;
import hallodoc.repo.RequestClientDao;
import hallodoc.repo.RequestConciergeDao;
import hallodoc.repo.RequestDao;
import hallodoc.repo.RequestWiseFileDao;
import hallodoc.repo.UserDao;
import hallodoc.repo.UsersDao;
import hallodoc.repo.VerificationTokenDao;

@Service
public class CoincergeService {

	@Autowired
	private CoincergeDao coincergeDao;

	@Autowired
	private RequestClientDao requestClientDao;

	@Autowired
	private RequestWiseFileDao requestWiseFileDao;

	@Autowired
	private RequestConciergeDao requestConciergeDao;

	@Autowired
	private RequestDao requestDao;

	@Autowired
	private UsersDao usersDao;
	
	@Autowired
	private UsersService usersService;

	@Autowired
	private VerificationTokenDao verificationTokenDao;

	@Autowired
	private CreateService createService;

	@Autowired
	private TokenChecker tokenChecker;

	@Autowired
	private TokenGenerator tokenGenerator;
	
	@Autowired
	private RequestService requestService;
	
	
	@Autowired
	private UserDao userDao;

	@Autowired
	private mailService mailService;
	
	@Autowired
	private AspNetUsersDao aspNetUsersDao;
	
	private RegionEnum regionEnum;
	

	public boolean checkEmail(String mail) {
		// TODO Auto-generated method stub

		List list = usersDao.checkEmail12(mail);

		if (list.size() == 0) {
			return false;
		} else {
			return true;
		}
	}

	@Transactional
	public void service(CoincergeDto coincergeInfoDto, boolean test_c, boolean test_p) {

		String fname = coincergeInfoDto.getFirstName();
		String lname = coincergeInfoDto.getLastName();
		String email = coincergeInfoDto.getEmail();
		String mobile = coincergeInfoDto.getMobile();
		String pfname = coincergeInfoDto.getpFirstName();
		String plname = coincergeInfoDto.getPlastName();
		String pemail = coincergeInfoDto.getpEmail();
		String pmobile = coincergeInfoDto.getpMobile();
		String street = coincergeInfoDto.getStreet();
		String city = coincergeInfoDto.getCity();
		String state = coincergeInfoDto.getState();
		String zipcode = coincergeInfoDto.getZipcode();
		CommonsMultipartFile file_name = coincergeInfoDto.getFile_name();
		String creString = LocalDateTime.now().toLocalDate().toString();
		LocalDate date = LocalDate.now();
		String forString = date.getDayOfMonth() + "" + date.getMonthValue()+ "" + date.getYear();

		LocalDateTime cdate = coincergeInfoDto.getCreated_date();
		String dob = coincergeInfoDto.getDOB();

		
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

			String mailUrl = "http://localhost:8080/hallodoc/create" + token;
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
			
			Concierge concierge = new Concierge();
			
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
			userDao.userSave(user);
		
			

			Request request = new Request();
			request.setUserId(user);
			request.setFirstName(fname);
			request.setLastName(lname);
			request.setPhoneNumber(mobile);
			request.setEmail(email);
			request.setCreatedDate(LocalDateTime.now());
			request.setRequestTypeId(4);
			request.setConfirmationNumber(confirString);
			
			requestDao.requestSave(request);
			
RequestClient requestClient = new RequestClient();
			requestClient.setFirstName(pfname);
			requestClient.setLastName(plname);
			requestClient.setPhoneNumber(pmobile);
			requestClient.setEmail(pemail);

			requestClient.setRequestId(request);
			requestClient.setZipcode(zipcode);
			requestClient.setNotes(null); //do this
			requestClient.setRegionId(regionId);
			if (dob == null || dob.isEmpty()) {

			} else {
				LocalDate currentDate = LocalDate.parse(dob);
				requestClient.setIntDate(new DateModifier().getDay(currentDate));
				requestClient.setStrMonth(new DateModifier().getMonth(currentDate));
				requestClient.setIntYear(new DateModifier().getYear(currentDate));
			}
			
			requestClientDao.requestClientSave(requestClient);

			if (test_c) {
				System.out.println(test_c);
				List<Concierge> list = usersDao.checkEmail12(email);
			
				concierge = list.get(0);
				concierge.setEmail(email);
				concierge.setConciergeName(fname + " " + lname);
				concierge.setCreatedDate(cdate);
				concierge.setStreet(street);
				concierge.setCity(city);
			
				concierge.setZipcode(zipcode);


				concierge.setModifiedDate(LocalDateTime.now());

				RequestConcierge requestConcierge = new RequestConcierge();
				requestConcierge.setConciergeId(concierge);
				requestConcierge.setRequestId(request);
			
				coincergeDao.conciergedaoUpdate(concierge);
				requestConciergeDao.requestConciergeSave(requestConcierge);

			}
			
			else {
				
				Concierge concierge2 = new Concierge();
				concierge2.setAddress(street + " "+ city + " "+ state); 
				concierge2.setStreet(street);
				concierge2.setCity(city);
				concierge2.setState(state);
				concierge2.setZipcode(zipcode);
				concierge2.setCreatedDate(cdate);
				concierge2.setEmail(email);
				coincergeDao.conciergedaoSave(concierge2);
				
				RequestConcierge requestConcierge = new RequestConcierge();
				requestConcierge.setRequestId(request);
				requestConcierge.setConciergeId(concierge2);
				requestConciergeDao.requestConciergeSave(requestConcierge);
				
			}
			
		}
		
		else {
			if (usersService.checkPasswordHash(pemail)) {
				
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
				
			}
			
			List<User> uList = usersDao.checkEmail1(pemail) ;
			User user = uList.get(0);
			
			Request request = new Request();
			request.setUserId(user);
			request.setFirstName(fname);
			request.setLastName(lname);
			request.setPhoneNumber(mobile);
			request.setEmail(email);
			request.setCreatedDate(LocalDateTime.now());
			request.setConfirmationNumber(confirString);
			request.setRequestTypeId(4);
			
			requestDao.requestSave(request);
			
			
			RequestClient requestClient = new RequestClient();
			requestClient.setFirstName(pfname);
			requestClient.setLastName(plname);
			requestClient.setPhoneNumber(pmobile);
			requestClient.setEmail(pemail);
			requestClient.setRegionId(regionId);

			requestClient.setRequestId(request);
			requestClient.setZipcode(zipcode);
			requestClient.setNotes(null); //do this
			if (dob == null || dob.isEmpty()) {

			} else {
				LocalDate currentDate = LocalDate.parse(dob);
				requestClient.setIntDate(new DateModifier().getDay(currentDate));
				requestClient.setStrMonth(new DateModifier().getMonth(currentDate));
				requestClient.setIntYear(new DateModifier().getYear(currentDate));
			}
			
			requestClientDao.requestClientSave(requestClient);
			
			if(test_c) {
				
				List<Concierge> Conlist = usersDao.checkEmail12(email);
				Concierge concierge = Conlist.get(0);
				concierge.setAddress(street + " "+ city + " "+ state); 
				concierge.setStreet(street);
				concierge.setCity(city);
				concierge.setState(state);
				concierge.setZipcode(zipcode);
				concierge.setCreatedDate(cdate);
				concierge.setEmail(email);
				coincergeDao.conciergedaoUpdate(concierge);
				
				RequestConcierge requestConcierge = new RequestConcierge();
				requestConcierge.setRequestId(request);
				requestConcierge.setConciergeId(concierge);
				requestConciergeDao.requestConciergeSave(requestConcierge);
				
			}
			
			else {
				
				Concierge concierge = new Concierge();
				concierge.setAddress(street + " "+ city + " "+ state); 
				concierge.setStreet(street);
				concierge.setCity(city);
				concierge.setState(state);
				concierge.setZipcode(zipcode);
				concierge.setCreatedDate(cdate);
				concierge.setEmail(email);
				coincergeDao.conciergedaoSave(concierge);
				
				RequestConcierge requestConcierge = new RequestConcierge();
				requestConcierge.setRequestId(request);
				requestConcierge.setConciergeId(concierge);
				requestConciergeDao.requestConciergeSave(requestConcierge);
				
			}

			
			
			
			
					
			
			
			
			
			
			
			
			
		}

	}

}



