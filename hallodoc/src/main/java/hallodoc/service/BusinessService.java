package hallodoc.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import hallodoc.dto.BusinessDto;
import hallodoc.dto.CoincergeDto;
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
import hallodoc.model.VerificationToken;
import hallodoc.repo.BusinessDao;
import hallodoc.repo.BusinessRequestDao;
import hallodoc.repo.RequestClientDao;

import hallodoc.repo.RequestDao;
import hallodoc.repo.RequestWiseFileDao;
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
	private BusinessRequestDao businessRequestDao;

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

		
		  LocalDateTime cdate = businessDto.getCreated_date(); String dob =
		  businessDto.getDOB();
		  
		  Request request = new Request(); request.setFirstName(fname);
		  request.setLastName(lname); request.setPhoneNumber(mobile);
		  request.setEmail(email); request.setCreatedDate(LocalDateTime.now());
		 
		  RequestClient requestClient = new RequestClient();
		  
		  requestClient.setFirstName(pfname); requestClient.setLastName(plname);
		  System.out.println(plname); requestClient.setPhoneNumber(pmobile);
		  requestClient.setEmail(pemail);
		  
		  requestClient.setRequestId(request); requestClient.setZipcode(zipcode); if
		  (dob == null || dob.isEmpty()) {
		  
		  } else { LocalDate currentDate = LocalDate.parse(dob);
		  requestClient.setIntDate(new DateModifier().getDay(currentDate));
		  requestClient.setStrMonth(new DateModifier().getMonth(currentDate));
		  requestClient.setIntYear(new DateModifier().getYear(currentDate)); }
		  
		  
		  
		  // business.setRegionId(region);
		
		 // business.setCreatedBy(aspNetUsers); //
		 
		  
		  System.out.println(test_c);
		  System.out.println("bhavyaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
		 
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

			requestbusiness.setBusinessId(business);

			requestDao.requestSave(request);
			requestClientDao.requestClientSave(requestClient);

			businessRequestDao.businessSave(requestbusiness);

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
		}

	}

}
