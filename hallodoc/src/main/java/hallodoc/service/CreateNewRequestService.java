package hallodoc.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hallodoc.dto.CreateNewRequestDto;
import hallodoc.enums.RegionEnum;
import hallodoc.helper.DateModifier;
import hallodoc.helper.TokenChecker;
import hallodoc.helper.TokenGenerator;
import hallodoc.model.AspNetUsers;
import hallodoc.model.Physician;
import hallodoc.model.Request;
import hallodoc.model.RequestClient;
import hallodoc.model.RequestNotes;
import hallodoc.model.RequestWiseFile;
import hallodoc.model.User;
import hallodoc.model.VerificationToken;
import hallodoc.repo.AspNetUsersDao;
import hallodoc.repo.PhysicianDao;
import hallodoc.repo.RequestClientDao;
import hallodoc.repo.RequestDao;
import hallodoc.repo.RequestNotesDao;
import hallodoc.repo.UserDao;
import hallodoc.repo.VerificationTokenDao;

@Service
public class CreateNewRequestService {

	@Autowired
	private UserDao userDao;

	@Autowired
	private RequestDao requestDao;

	@Autowired
	private RequestService requestService;

	@Autowired
	private TokenGenerator tokenGenerator;

	@Autowired
	private TokenChecker tokenChecker;

	@Autowired
	private mailService mailService;

	@Autowired
	private RequestClientDao requestClientDao;

	@Autowired
	private AspNetUsersDao aspNetUsersDao;

	@Autowired
	private RequestNotesDao requestNotesDao;

	@Autowired
	private VerificationTokenDao verificationTokenDao;

	@Autowired
	private PhysicianDao physicianDao;

	public void service(CreateNewRequestDto createNewRequestDto, int userID, boolean test_p)

	{
		String notString = createNewRequestDto.getNotes();
		String fnameString = createNewRequestDto.getFirstName();
		String lnameString = createNewRequestDto.getLastName();
		String emailString = createNewRequestDto.getEmail();
		String phoneString = createNewRequestDto.getMobile();
		String dobString = createNewRequestDto.getDOB();
		String streetString = createNewRequestDto.getStreet();
		String cityString = createNewRequestDto.getCity();
		String stateString = createNewRequestDto.getState();
		String zipcodeString = createNewRequestDto.getZipcode();
		String adminnoteString = createNewRequestDto.getAdminNotes();
		String phyNoteString = createNewRequestDto.getProviderNotes();
		String creString = LocalDateTime.now().toLocalDate().toString();
		int regionId = RegionEnum.valueOf(stateString).getid();

		LocalDate date = LocalDate.now();
		String forString = date.getDayOfMonth() + "" + date.getMonthValue() + "" + date.getYear();
		System.out.println(forString);
		String abbrString;
		try {
			abbrString = RegionEnum.valueOf(stateString.toUpperCase()).getAbbr();
			System.out.println("Abbreviation for " + stateString + ": " + abbrString);
		} catch (IllegalArgumentException e) {
			System.out.println("State not found: " + stateString);
			abbrString = ""; // Or handle the exception differently if needed
		}

		List<Request> requests = requestService.getRequests();
		int count = 1;
		for (int i = 0; i < requests.size(); i++) {

			Request request = requests.get(i);
			String xString = request.getCreatedDate().toLocalDate().toString();
			if (xString.equals(creString)) {
				count += 1;
			}

		}
		String confirString = abbrString + fnameString.toUpperCase().substring(0, 2)
				+ lnameString.toUpperCase().substring(0, 2) + forString.substring(0, 4) + count;

		if (!test_p) {
			VerificationToken verificationToken = new VerificationToken();
			verificationToken.setEmail(emailString);
			verificationToken.setCreated_date(LocalDateTime.now());

			String token = new TokenGenerator().GenerateToken();
			verificationToken.setToken(token);

			String mailUrl = "http://localhost:8080/hallodoc/create" + token;
			mailService.send(emailString, "Validation", mailUrl);

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
			aspNetUsers.setEmail(emailString);
			aspNetUsers.setPhoneNumber(phoneString);
			;
			aspNetUsers.setCreatedDate(LocalDateTime.now());

			user.setFirstName(fnameString);
			user.setLastName(lnameString);
			user.setEmail(emailString);
			user.setMobile(phoneString);
			user.setRegionId(regionId);
			if (dobString == null || dobString.isEmpty()) {

			} else {
				LocalDate currentDate = LocalDate.parse(dobString);
				user.setIntDate(new DateModifier().getDay(currentDate));
				user.setStrMonth(new DateModifier().getMonth(currentDate));
				user.setIntYear(new DateModifier().getYear(currentDate));
			}
			user.setCreatedDate(LocalDateTime.now());
			user.setAspnetUserId(aspNetUsers);
			user.setRequestWithEmail(true);

			aspNetUsersDao.aspSave(aspNetUsers);
			userDao.userSave(user);

			List<User> users = userDao.getUserIDList(userID);
			User user1 = users.get(0);

			Request request = new Request();
			request.setUserId(user1);
			request.setCreatedDate(LocalDateTime.now());
			request.setEmail(user1.getEmail());
			request.setFirstName(user1.getFirstName());
			request.setLastName(user1.getLastName());
			request.setPhoneNumber(user1.getMobile());
			request.setStatus(1);
			request.setRequestTypeId(3);
			request.setConfirmationNumber(confirString);

			requestDao.requestSave(request);
			RequestClient requestClient = new RequestClient();

			requestClient.setFirstName(fnameString);
			requestClient.setLastName(lnameString);

			requestClient.setPhoneNumber(phoneString);
			requestClient.setEmail(emailString);
			requestClient.setRegionId(regionId);
			requestClient.setStreet(streetString);
			requestClient.setCity(cityString);
			requestClient.setState(stateString);
			requestClient.setRequestId(request);
			requestClient.setZipcode(zipcodeString);
			if (dobString == null || dobString.isEmpty()) {

			} else {
				LocalDate currentDate = LocalDate.parse(dobString);
				requestClient.setIntDate(new DateModifier().getDay(currentDate));
				requestClient.setStrMonth(new DateModifier().getMonth(currentDate));
				requestClient.setIntYear(new DateModifier().getYear(currentDate));
			}

		}

		else {

			List<User> users = userDao.getUserIDList(userID);
			User user = users.get(0);

			Request request = new Request();
			request.setUserId(user);
			request.setCreatedDate(LocalDateTime.now());
			request.setEmail(user.getEmail());
			request.setFirstName(user.getFirstName());
			request.setLastName(user.getLastName());
			request.setPhoneNumber(user.getMobile());
			request.setStatus(1);
			request.setRequestTypeId(3);
			request.setConfirmationNumber(confirString);
			requestDao.requestSave(request);

			RequestClient requestClient = new RequestClient();

			requestClient.setFirstName(fnameString);
			requestClient.setLastName(lnameString);

			requestClient.setPhoneNumber(phoneString);
			requestClient.setEmail(emailString);
			requestClient.setRegionId(regionId);
			requestClient.setStreet(streetString);
			requestClient.setCity(cityString);
			requestClient.setState(stateString);
			requestClient.setRequestId(request);
			requestClient.setZipcode(zipcodeString);
			if (dobString == null || dobString.isEmpty()) {

			} else {
				LocalDate currentDate = LocalDate.parse(dobString);
				requestClient.setIntDate(new DateModifier().getDay(currentDate));
				requestClient.setStrMonth(new DateModifier().getMonth(currentDate));
				requestClient.setIntYear(new DateModifier().getYear(currentDate));
			}

			requestClientDao.requestClientSave(requestClient);

		}

	}

	public void serviceProvider(CreateNewRequestDto createNewRequestDto, int userID, boolean test_p, int phyId)

	{
		String notString = createNewRequestDto.getNotes();
		String fnameString = createNewRequestDto.getFirstName();
		String lnameString = createNewRequestDto.getLastName();
		String emailString = createNewRequestDto.getEmail();
		String phoneString = createNewRequestDto.getMobile();
		String dobString = createNewRequestDto.getDOB();
		String streetString = createNewRequestDto.getStreet();
		String cityString = createNewRequestDto.getCity();
		String stateString = createNewRequestDto.getState();
		String zipcodeString = createNewRequestDto.getZipcode();
		String adminnoteString = createNewRequestDto.getAdminNotes();
		String phyNoteString = createNewRequestDto.getProviderNotes();
		String creString = LocalDateTime.now().toLocalDate().toString();
		int regionId = RegionEnum.valueOf(stateString).getid();

		LocalDate date = LocalDate.now();
		String forString = date.getDayOfMonth() + "" + date.getMonthValue() + "" + date.getYear();
		System.out.println(forString);
		String abbrString;
		try {
			abbrString = RegionEnum.valueOf(stateString.toUpperCase()).getAbbr();
			System.out.println("Abbreviation for " + stateString + ": " + abbrString);
		} catch (IllegalArgumentException e) {
			System.out.println("State not found: " + stateString);
			abbrString = ""; // Or handle the exception differently if needed
		}

		List<User> users1 = userDao.getUserIDList(userID);
		User user7 = users1.get(0);

		List<Request> requests = requestService.getRequests();
		int count = 1;
		for (int i = 0; i < requests.size(); i++) {

			Request request = requests.get(i);
			String xString = request.getCreatedDate().toLocalDate().toString();
			if (xString.equals(creString)) {
				count += 1;
			}

		}
		String confirString = abbrString + fnameString.toUpperCase().substring(0, 2)
				+ lnameString.toUpperCase().substring(0, 2) + forString.substring(0, 4) + count;

		List<Physician> physicians = physicianDao.getPhysiciansAll(phyId);
		Physician physician = physicians.get(0);

		if (!test_p) {
			VerificationToken verificationToken = new VerificationToken();
			verificationToken.setEmail(emailString);
			verificationToken.setCreated_date(LocalDateTime.now());

			String token = new TokenGenerator().GenerateToken();
			verificationToken.setToken(token);

			String mailUrl = "http://localhost:8080/hallodoc/create" + token;
			mailService.send(emailString, "Validation", mailUrl);

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
			aspNetUsers.setEmail(emailString);
			aspNetUsers.setPhoneNumber(phoneString);
			;
			aspNetUsers.setCreatedDate(LocalDateTime.now());

			user.setFirstName(fnameString);
			user.setLastName(lnameString);
			user.setEmail(emailString);
			user.setMobile(phoneString);
			user.setRegionId(regionId);
			if (dobString == null || dobString.isEmpty()) {

			} else {
				LocalDate currentDate = LocalDate.parse(dobString);
				user.setIntDate(new DateModifier().getDay(currentDate));
				user.setStrMonth(new DateModifier().getMonth(currentDate));
				user.setIntYear(new DateModifier().getYear(currentDate));
			}
			user.setCreatedDate(LocalDateTime.now());
			user.setAspnetUserId(aspNetUsers);
			user.setRequestWithEmail(true);
			user.setCreatedBy(user7.getAspnetUserId().getId());

			aspNetUsersDao.aspSave(aspNetUsers);
			userDao.userSave(user);

			List<User> users = userDao.getUserIDList(userID);
			User user1 = users.get(0);

			Request request = new Request();
			request.setUserId(user1);
			request.setCreatedDate(LocalDateTime.now());
			request.setEmail(user1.getEmail());
			request.setFirstName(user1.getFirstName());
			request.setLastName(user1.getLastName());
			request.setPhoneNumber(user1.getMobile());
			request.setStatus(2);
			request.setRequestTypeId(3);
			request.setPhysicianId(physician);
			request.setConfirmationNumber(confirString);
			requestDao.requestSave(request);
			RequestClient requestClient = new RequestClient();

			requestClient.setFirstName(fnameString);
			requestClient.setLastName(lnameString);

			requestClient.setPhoneNumber(phoneString);
			requestClient.setEmail(emailString);
			requestClient.setRegionId(regionId);
			requestClient.setStreet(streetString);
			requestClient.setCity(cityString);
			requestClient.setState(stateString);
			requestClient.setRequestId(request);
			requestClient.setZipcode(zipcodeString);
			if (dobString == null || dobString.isEmpty()) {

			} else {
				LocalDate currentDate = LocalDate.parse(dobString);
				requestClient.setIntDate(new DateModifier().getDay(currentDate));
				requestClient.setStrMonth(new DateModifier().getMonth(currentDate));
				requestClient.setIntYear(new DateModifier().getYear(currentDate));
			}
			requestClientDao.requestClientSave(requestClient);

			
			
	if (createNewRequestDto.getProviderNotes()!=null) {
				
				List<RequestNotes> requestNotes = requestNotesDao.getRequests(request.getRequestId());
				if (requestNotes.size() == 0) {
					RequestNotes requestNotes2 = new RequestNotes();
					requestNotes2.setPhysicianNotes(phyNoteString);
					requestNotes2.setCreatedBy(user7.getAspnetUserId());
					requestNotes2.setCreatedDate(LocalDateTime.now());
					requestNotes2.setRequestId(request);

					requestNotesDao.requestNotesSave(requestNotes2);
				} else {
					RequestNotes requestNotes2 = requestNotes.get(0);
					requestNotes2.setPhysicianNotes(phyNoteString);
					requestNotes2.setModifiedBy(user7.getAspnetUserId());
					requestNotes2.setModifiedDate(LocalDateTime.now());
					requestNotesDao.requestNotesUpdate(requestNotes2);

				}
			}
		}

		else {

			List<User> users = userDao.getUserIDList(userID);
			User user = users.get(0);

			Request request = new Request();
			request.setUserId(user);
			request.setCreatedDate(LocalDateTime.now());
			request.setEmail(user.getEmail());
			request.setFirstName(user.getFirstName());
			request.setLastName(user.getLastName());
			request.setPhoneNumber(user.getMobile());
			request.setStatus(2);
			request.setRequestTypeId(3);
			request.setConfirmationNumber(confirString);
			request.setPhysicianId(physician);
			requestDao.requestSave(request);

			RequestClient requestClient = new RequestClient();

			requestClient.setFirstName(fnameString);
			requestClient.setLastName(lnameString);

			requestClient.setPhoneNumber(phoneString);
			requestClient.setEmail(emailString);
			requestClient.setRegionId(regionId);
			requestClient.setStreet(streetString);
			requestClient.setCity(cityString);
			requestClient.setState(stateString);
			requestClient.setRequestId(request);
			requestClient.setZipcode(zipcodeString);
			if (dobString == null || dobString.isEmpty()) {

			} else {
				LocalDate currentDate = LocalDate.parse(dobString);
				requestClient.setIntDate(new DateModifier().getDay(currentDate));
				requestClient.setStrMonth(new DateModifier().getMonth(currentDate));
				requestClient.setIntYear(new DateModifier().getYear(currentDate));
			}

			requestClientDao.requestClientSave(requestClient);
			
			if (createNewRequestDto.getProviderNotes()!=null) {
				
				List<RequestNotes> requestNotes = requestNotesDao.getRequests(request.getRequestId());
				if (requestNotes.size() == 0) {
					RequestNotes requestNotes2 = new RequestNotes();
					requestNotes2.setPhysicianNotes(phyNoteString);
					requestNotes2.setCreatedBy(user7.getAspnetUserId());
					requestNotes2.setCreatedDate(LocalDateTime.now());
					requestNotes2.setRequestId(request);

					requestNotesDao.requestNotesSave(requestNotes2);
				} else {
					RequestNotes requestNotes2 = requestNotes.get(0);
					requestNotes2.setPhysicianNotes(phyNoteString);
					requestNotes2.setModifiedBy(user7.getAspnetUserId());
					requestNotes2.setModifiedDate(LocalDateTime.now());
					requestNotesDao.requestNotesUpdate(requestNotes2);
					

				}
			}

		

		}

	}

}
