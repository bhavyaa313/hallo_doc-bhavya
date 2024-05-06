package hallodoc.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import javax.management.loading.PrivateClassLoader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import hallodoc.dto.BusinessDto;
import hallodoc.dto.CoincergeDto;
import hallodoc.enums.RegionEnum;
import hallodoc.helper.DateModifier;
import hallodoc.helper.TokenChecker;
import hallodoc.helper.TokenGenerator;
import hallodoc.model.AspNetUsers;
import hallodoc.model.Business;
import hallodoc.model.Region;
import hallodoc.model.Request;
import hallodoc.model.RequestBusiness;
import hallodoc.model.RequestClient;
import hallodoc.model.RequestWiseFile;
import hallodoc.model.User;
import hallodoc.model.VerificationToken;
import hallodoc.repo.AspNetUsersDao;
import hallodoc.repo.BusinessDao;
import hallodoc.repo.BusinessRequestDao;
import hallodoc.repo.RequestClientDao;

import hallodoc.repo.RequestDao;
import hallodoc.repo.RequestWiseFileDao;
import hallodoc.repo.UserDao;
import hallodoc.repo.UsersDao;
import hallodoc.repo.VerificationTokenDao;

@Service
public class BusinessService {

	@Autowired
	private RequestClientDao requestClientDao;

	@Autowired
	private RequestWiseFileDao requestWiseFileDao;

	private RequestBusiness requestBusiness;

	@Autowired
	private RequestDao requestDao;

	@Autowired
	private UsersDao usersDao;

	@Autowired
	private VerificationTokenDao verificationTokenDao;

	@Autowired
	private CreateService createService;

	@Autowired
	private TokenChecker tokenChecker;

	@Autowired
	private TokenGenerator tokenGenerator;

	@Autowired
	private mailService mailService;

	@Autowired
	private BusinessDao businessDao;
	
	@Autowired
	private UsersService usersService;

	@Autowired
	private BusinessRequestDao businessRequestDao;
	
	@Autowired
	private UserDao userDao;
	
	
	private RegionEnum regionEnum;
	
	@Autowired
	private RequestService requestService;
	
	
	
	@Autowired
	private AspNetUsersDao aspNetUsersDao;

	public boolean checkEmail(String mail) {
		// TODO Auto-generated method stub

		List list = usersDao.checkEmail13(mail);

		if (list.size() == 0) {
			return false;
		} else {
			return true;
		}
	}

	public void service(BusinessDto businessDto, boolean test_c, boolean test_p) {

		String businessName = businessDto.getBusinessName();
		String fname = businessDto.getFirstName();
		String lname = businessDto.getLastName();
		String email = businessDto.getEmail();
		String mobile = businessDto.getMobile();
		String pfname = businessDto.getpFirstName();
		String plname = businessDto.getPlastName();
		String pemail = businessDto.getpEmail();
		String pmobile = businessDto.getpMobile();
		String street = businessDto.getStreet();
		String city = businessDto.getCity();
		String state = businessDto.getState();
		String zipcode = businessDto.getZipcode();
		String creString = LocalDateTime.now().toLocalDate().toString();
		LocalDate date = LocalDate.now();
		String forString = date.getDayOfMonth() + "" + date.getMonthValue()+ "" + date.getYear();

		
		  LocalDateTime cdate = businessDto.getCreated_date(); 
		  String dob =
	  businessDto.getDOB();
		  
	 
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
			int regionId = RegionEnum.valueOf(state).getid();
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
			request.setStatus(1);
			request.setEmail(email);
			request.setRequestTypeId(1);
			request.setDeleted(false);
			request.setConfirmationNumber(confirString);
			request.setStatus(1);

			request.setCreatedDate(LocalDateTime.now());
			requestDao.requestSave(request);
			
			RequestClient requestClient = new RequestClient();
			requestClient.setFirstName(pfname);
			requestClient.setLastName(plname);
			requestClient.setPhoneNumber(pmobile);
			requestClient.setEmail(pemail);

			requestClient.setRequestId(request);
			requestClient.setZipcode(zipcode);
			requestClient.setRegionId(regionId);
			requestClient.setNotes(null); //do this
			if (dob == null || dob.isEmpty()) {

			} else {
				LocalDate currentDate = LocalDate.parse(dob);
				requestClient.setIntDate(new DateModifier().getDay(currentDate));
				requestClient.setStrMonth(new DateModifier().getMonth(currentDate));
				requestClient.setIntYear(new DateModifier().getYear(currentDate));
			}
			
			requestClientDao.requestClientSave(requestClient);
			
			if (test_c) {

				Business business = new Business();
				RequestBusiness requestbusiness = new RequestBusiness();
				System.out.println(test_c);
				List<Business> list = usersDao.checkEmail13(email);

				business = list.get(0);
				System.out.println(list.get(0));

				business.setName(businessName);
				business.setModifiedDate(LocalDateTime.now());
				business.setPhoneNumber(mobile);

				business.setModifiedDate(LocalDateTime.now());
				businessDao.businessUpdate(business);
		

				requestbusiness.setRequestId(request);
				requestbusiness.setBusinessId(business);

				
				requestDao.requestSave(request);
				requestClientDao.requestClientSave(requestClient);

				businessRequestDao.businessSave(requestbusiness);

			} 
			
			else {
				Business business = new Business();
				business.setName(businessName);
				business.setModifiedDate(LocalDateTime.now());
				business.setPhoneNumber(mobile);
				business.setEmail(email);
				business.setModifiedDate(LocalDateTime.now());
				
				businessDao.businessSave(business);
				RequestBusiness requestBusiness = new RequestBusiness();
				requestBusiness.setRequestId(request);
				requestBusiness.setBusinessId(business);
				businessRequestDao.businessSave(requestBusiness);

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
			request.setStatus(1);
			request.setRequestTypeId(1);
			request.setEmail(email);
			request.setDeleted(false);
			request.setConfirmationNumber(confirString);
			request.setStatus(1);

			request.setCreatedDate(LocalDateTime.now());
			requestDao.requestSave(request);
			
			
			RequestClient requestClient = new RequestClient();
			requestClient.setFirstName(pfname);
			requestClient.setLastName(plname);
			requestClient.setPhoneNumber(pmobile);
			requestClient.setEmail(pemail);

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
			
			if (test_c) {
				List<Business> list = usersDao.checkEmail13(email);
				Business business = new Business();
				business = list.get(0);
				System.out.println(list.get(0));

				business.setName(businessName);
				business.setModifiedDate(LocalDateTime.now());
				business.setPhoneNumber(mobile);

				business.setModifiedDate(LocalDateTime.now());
				businessDao.businessUpdate(business);
		RequestBusiness requestBusiness = new RequestBusiness();

				requestBusiness.setRequestId(request);
				requestBusiness.setBusinessId(business);

				
				

				businessRequestDao.businessSave(requestBusiness);
				
			}
			
			else {
				Business business = new Business();

				business.setCreatedDate(cdate);
				business.setName(businessName);
				business.setEmail(email);
				business.setPhoneNumber(mobile);
			
				requestDao.requestSave(request);
				requestClientDao.requestClientSave(requestClient);
				businessDao.businessSave(business);
				RequestBusiness requestbusiness = new RequestBusiness();

				requestbusiness.setRequestId(request);
				requestbusiness.setBusinessId(business);
				businessRequestDao.businessSave(requestbusiness);

			}
			
		}

	}

}
