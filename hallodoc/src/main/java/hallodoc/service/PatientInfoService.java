package hallodoc.service;

import java.time.LocalDate;
import java.time.LocalDateTime;


import java.util.List;

import javax.servlet.ServletRequestListener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import hallodoc.dto.PatientInfoDto;
import hallodoc.enums.RegionEnum;
import hallodoc.helper.ConfirmationNumber;
import hallodoc.helper.DateModifier;
import hallodoc.helper.PasswordHash;

import hallodoc.model.AspNetUsers;

import hallodoc.model.Request;
import hallodoc.model.RequestClient;
import hallodoc.model.RequestWiseFile;
import hallodoc.model.User;
import hallodoc.repo.AspNetUsersDao;

import hallodoc.repo.RequestClientDao;
import hallodoc.repo.RequestDao;
import hallodoc.repo.RequestWiseFileDao;
import hallodoc.repo.UserDao;
import hallodoc.repo.UsersDao;

@Component
public class PatientInfoService {

	@Autowired
	private AspNetUsersDao aspNetUsersDao;

	@Autowired
	private UserDao userDao;

	@Autowired
	private UsersDao usersDao;

	@Autowired
	private RequestDao requestDao;

	@Autowired
	private RequestClientDao requestClientDao;

	@Autowired
	private RequestWiseFileDao requestWiseFileDao;
	
	@Autowired
	private RequestService requestService;
	
	@Autowired
	private ConfirmationNumber confirmationNumber;
	
	
	
	public boolean checkEmail(String mail) {
		// TODO Auto-generated method stub

		List list = usersDao.checkEmail(mail);

		if (list.size() == 0) {
			return false;
		}
		else {
			return true;
		}
	}
		

	public void service(PatientInfoDto patientInfoDto, boolean test) {

		String fname = patientInfoDto.getFirstName();
		String lname = patientInfoDto.getLastName();
		String email = patientInfoDto.getEmail();
		String mobile = patientInfoDto.getMobile();
		String street = patientInfoDto.getStreet();
		String city = patientInfoDto.getCity();
		String state = patientInfoDto.getState();
		String zipcode = patientInfoDto.getZipcode();
		String room = patientInfoDto.getRoom();
		
		
		LocalDateTime cdate = patientInfoDto.getCreated_date();
		String dob = patientInfoDto.getDOB();
		int id = patientInfoDto.getId();
		int status = patientInfoDto.getStatus();
		int phyid = patientInfoDto.getPhysicianId();
		int admin_id = patientInfoDto.getAdmin_id();
		
		CommonsMultipartFile file_name = patientInfoDto.getFile_name();
		String creString = LocalDateTime.now().toLocalDate().toString();
		LocalDate date = LocalDate.now();
		String forString = date.getDayOfMonth() + "" + date.getMonthValue()+ "" + date.getYear();
		System.out.println(forString);
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
		String confirString = abbrString + fname.toUpperCase().substring(0, 2) + lname.toUpperCase().substring(0, 2) + forString.substring(0, 4)+ count; 
				
				
				
		String password = patientInfoDto.getPassword();
		
		int regionId = RegionEnum.valueOf(state.toUpperCase()).getid();
		System.out.println("------------------------------------------------------------------");
		System.out.println(regionId);
		System.out.println("------------------------------------------------------------------");

		if (test) {
			AspNetUsers aspNetUsers = new AspNetUsers();
			List<AspNetUsers> list = usersDao.checkEmail(email);

			aspNetUsers = list.get(0);

			aspNetUsers.setModifiedDate(LocalDateTime.now());
			aspNetUsers.setPhoneNumber(mobile);

			aspNetUsersDao.aspUpdate(aspNetUsers);

			User user = new User();
			List<User> list2 = usersDao.checkEmail1(email);
			user = list2.get(0);
			user.setMobile(mobile);
			user.setStreet(street);
			user.setCity(city);
			user.setState(state);
			user.setZipcode(zipcode);
			user.setRegionId(regionId);
			user.setModifiedDate(LocalDateTime.now());
			

			userDao.userUpdate(user);

			Request request = new Request();
			request.setFirstName(fname);
			request.setLastName(lname);
			request.setPhoneNumber(mobile);
			request.setEmail(email);
			request.setStatus(status);
			request.setPhysicianId(phyid);
			request.setCreatedDate(cdate);
			request.setConfirmationNumber(confirString);
			request.setRequestTypeId(2);
			request.setDeclinedBy(aspNetUsers);
			request.setUserId(user);

			RequestClient requestClient = new RequestClient();
			requestClient.setFirstName(fname);
			requestClient.setLastName(lname);
			requestClient.setPhoneNumber(mobile);
			requestClient.setEmail(email);
			requestClient.setStreet(street);
			requestClient.setCity(city);
			requestClient.setState(state);
			requestClient.setRequestId(request);
			requestClient.setZipcode(zipcode);
			requestClient.setRegionId(regionId);
			System.out.println("------------------------------------------------------------------");
			System.out.println(requestClient.getRegionId());
			System.out.println("------------------------------------------------------------------");

			LocalDate curreDate1 = LocalDate.parse(dob);
			requestClient.setIntDate(new DateModifier().getDay(curreDate1));
			requestClient.setStrMonth(new DateModifier().getMonth(curreDate1));
			requestClient.setIntYear(new DateModifier().getYear(curreDate1));

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
			requestWiseFile.setUploader(fname + lname);

			requestWiseFile.setFileName(file_name.getOriginalFilename());

			
			requestWiseFileDao.requestWiseFileSave(requestWiseFile);
			
			}
			

		}

		else {
			AspNetUsers aspNetUsers = new AspNetUsers();

			aspNetUsers.setEmail(email);
			aspNetUsers.setUserName(email);
			aspNetUsers.setPasswordHash(new PasswordHash().encryptPassword(password));
			aspNetUsers.setPhoneNumber(mobile);
			aspNetUsers.setCreatedDate(cdate);
			aspNetUsersDao.aspSave(aspNetUsers);

		

			User user = new User();
			user.setFirstName(fname);
			user.setLastName(lname);
			user.setEmail(email);
			user.setMobile(mobile);
			user.setStreet(street);
			user.setCity(city);
			user.setState(state);
			user.setZipcode(zipcode);
			user.setRegionId(regionId);
			user.setAspnetUserId(aspNetUsers);
			user.setCreatedBy(aspNetUsers.getId());
			
			

			if (dob == null || dob.isEmpty()) {

			} else {
				LocalDate currentDate = LocalDate.parse(dob);
				user.setIntDate(new DateModifier().getDay(currentDate));
				user.setStrMonth(new DateModifier().getMonth(currentDate));
				user.setIntYear(new DateModifier().getYear(currentDate));
			}
			userDao.userSave(user);
 
			Request request = new Request();
			request.setFirstName(fname);
			request.setLastName(lname);
			request.setPhoneNumber(mobile);
			request.setEmail(email);
			request.setStatus(status);
			request.setPhysicianId(phyid);
			request.setCreatedDate(cdate);
			request.setDeclinedBy(aspNetUsers);
			request.setUserId(user);
			request.setRequestTypeId(2);
			request.setConfirmationNumber(confirString);

			
			
			RequestClient requestClient = new RequestClient();
			requestClient.setFirstName(fname);
			requestClient.setLastName(lname);
			requestClient.setPhoneNumber(mobile);
			requestClient.setEmail(email);
			requestClient.setStreet(street);
			requestClient.setCity(city);
			requestClient.setState(state);
			requestClient.setRequestId(request);
			requestClient.setZipcode(zipcode);
			requestClient.setRegionId(regionId);
			System.out.println("------------------------------------------------------------------");
			System.out.println(requestClient.getRegionId());
			System.out.println("------------------------------------------------------------------");
			

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
			requestWiseFile.setUploader(fname + lname);
			
			requestWiseFile.setCreatedDate(LocalDateTime.now());

			requestWiseFile.setFileName(file_name.getOriginalFilename());
		
			requestWiseFileDao.requestWiseFileSave(requestWiseFile);
			}
			

			
		}

	}

}
