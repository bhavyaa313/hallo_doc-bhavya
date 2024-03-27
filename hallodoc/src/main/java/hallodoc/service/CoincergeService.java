package hallodoc.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import javax.management.loading.PrivateClassLoader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import hallodoc.dto.CoincergeDto;
import hallodoc.helper.DateModifier;
import hallodoc.helper.TokenChecker;
import hallodoc.helper.TokenGenerator;
import hallodoc.model.AspNetUsers;
import hallodoc.model.Concierge;
import hallodoc.model.Request;
import hallodoc.model.RequestClient;
import hallodoc.model.RequestConcierge;
import hallodoc.model.RequestWiseFile;
import hallodoc.model.VerificationToken;
import hallodoc.repo.CoincergeDao;
import hallodoc.repo.RequestClientDao;
import hallodoc.repo.RequestConciergeDao;
import hallodoc.repo.RequestDao;
import hallodoc.repo.RequestWiseFileDao;
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
	private VerificationTokenDao verificationTokenDao;

	@Autowired
	private CreateService createService;

	@Autowired
	private TokenChecker tokenChecker;

	@Autowired
	private TokenGenerator tokenGenerator;

	@Autowired
	private mailService mailService;

	public boolean checkEmail(String mail) {
		// TODO Auto-generated method stub

		List list = usersDao.checkEmail12(mail);

		if (list.size() == 0) {
			return false;
		} else {
			return true;
		}
	}

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

		LocalDateTime cdate = coincergeInfoDto.getCreated_date();
		String dob = coincergeInfoDto.getDOB();

		Request request = new Request();
		request.setFirstName(fname);
		request.setLastName(lname);
		request.setPhoneNumber(mobile);
		request.setEmail(email);
		request.setCreatedDate(LocalDateTime.now());

		Concierge concierge = new Concierge();

		RequestClient requestClient = new RequestClient();

		requestClient.setFirstName(pfname);
		requestClient.setLastName(plname);
		System.out.println(plname);
		requestClient.setPhoneNumber(pmobile);
		requestClient.setEmail(pemail);

		requestClient.setRequestId(request);
		requestClient.setZipcode(zipcode);
		LocalDate curreDate1 = LocalDate.parse(dob);
		requestClient.setIntDate(new DateModifier().getDay(curreDate1));
		requestClient.setStrMonth(new DateModifier().getMonth(curreDate1));
		requestClient.setIntYear(new DateModifier().getYear(curreDate1));

		RequestWiseFile requestWiseFile = new RequestWiseFile();
		requestWiseFile.setRequestId(request);
		requestWiseFile.setCreatedDate(LocalDateTime.now());

		concierge.setConciergeName(fname + " " + lname);
		concierge.setCreatedDate(cdate);
		concierge.setStreet(street);
		concierge.setCity(city);
		concierge.setState(state);
		concierge.setZipcode(zipcode);

		concierge.setAddress(street + " " + city + " " + state + " " + zipcode);

		RequestConcierge requestConcierge = new RequestConcierge();

		requestConcierge.setRequestId(request);
		requestConcierge.setConciergeId(concierge);

		System.out.println(test_c);
		if (test_c) {
			System.out.println(test_c);
			List<Concierge> list = usersDao.checkEmail12(email);

			concierge = list.get(0);
			concierge.setEmail(email);
			concierge.setConciergeName(fname + " " + lname);
			concierge.setCreatedDate(cdate);
			concierge.setStreet(street);
			concierge.setCity(city);
			concierge.setState(state);
			concierge.setZipcode(zipcode);


			concierge.setModifiedDate(LocalDateTime.now());

			requestConcierge.setConciergeId(concierge);
			requestDao.requestSave(request);
			requestClientDao.requestClientSave(requestClient);
			coincergeDao.conciergedaoUpdate(concierge);
			requestConciergeDao.requestConciergeSave(requestConcierge);

		}

		else {

			
			concierge.setEmail(email);
			requestDao.requestSave(request);
			requestClientDao.requestClientSave(requestClient);
			coincergeDao.conciergedaoSave(concierge);
			requestConciergeDao.requestConciergeSave(requestConcierge);

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



