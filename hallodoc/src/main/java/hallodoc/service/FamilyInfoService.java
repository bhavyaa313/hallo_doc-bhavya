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
import hallodoc.helper.DateModifier;
import hallodoc.helper.TokenChecker;
import hallodoc.helper.TokenGenerator;
import hallodoc.model.Request;
import hallodoc.model.RequestClient;
import hallodoc.model.RequestWiseFile;
import hallodoc.model.VerificationToken;
import hallodoc.repo.RequestClientDao;
import hallodoc.repo.RequestDao;
import hallodoc.repo.RequestWiseFileDao;
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
	


	public void service(FamilyInfoDto familyInfoDto) {
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

		LocalDateTime cdate = familyInfoDto.getCreated_date();
		String dob = familyInfoDto.getDOB();

		Request request = new Request();
		request.setFirstName(fname);
		request.setLastName(lname);
		request.setPhoneNumber(mobile);
		request.setEmail(email);
		request.setCreatedDate(LocalDateTime.now());

		RequestClient requestClient = new RequestClient();

		requestClient.setFirstName(pfname);
		requestClient.setLastName(plname);
		System.out.println(plname);
		requestClient.setPhoneNumber(pmobile);
		requestClient.setEmail(pemail);

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
		RequestWiseFile requestWiseFile = new RequestWiseFile();
		requestWiseFile.setRequestId(request);
		requestWiseFile.setCreatedDate(LocalDateTime.now());
		requestWiseFile.setFileName(file_name.getOriginalFilename());
		
		if(!createService.ajaxCheck(pemail))
		{
			VerificationToken verificationToken = new VerificationToken();
			verificationToken.setToken(tokenGenerator.GenerateToken());
			verificationToken.setCreated_date(cdate);
			verificationToken.setEmail(pemail);
			List<VerificationToken> tokenList = tokenChecker.checkMailStatusList(verificationToken.getEmail());
			mailService.send(pemail, "ssubjecttt", "hellllloooooo");
			if(tokenList.size()==0)
			{
				verificationToken.setValidation(true);
				verificationTokenDao.verificationTokenSave(verificationToken);
				
			}
			else {
				VerificationToken lasToken = tokenList.get(tokenList.size()-1);
				lasToken.setValidation(false);
				verificationToken.setValidation(true);
				verificationTokenDao.verificationTokenSave(verificationToken);
				verificationTokenDao.verificationTokenUpdate(verificationToken);
				
			}
			
		}

		requestDao.requestSave(request);
		requestClientDao.requestClientSave(requestClient);
		requestWiseFileDao.requestWiseFileSave(requestWiseFile);

	}

}
