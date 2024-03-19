package hallodoc.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.concurrent.locks.ReentrantLock;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import hallodoc.dto.PatientInfoDto;
import hallodoc.helper.DateModifier;
import hallodoc.helper.PasswordHash;
import hallodoc.model.Admin;
import hallodoc.model.AspNetUsers;
import hallodoc.model.Physician;
import hallodoc.model.Region;
import hallodoc.model.Request;
import hallodoc.model.RequestClient;
import hallodoc.model.RequestWiseFile;
import hallodoc.model.User;
import hallodoc.repo.PatientInfoDao;

@Component
public class PatientInfoService {

	@Autowired
	private PatientInfoDao patientInfoDao;


	public boolean test=false;

	public void service(PatientInfoDto patientInfoDto) {

		String sympton = patientInfoDto.getSympton();
		String fname = patientInfoDto.getFirstName();
		String lname = patientInfoDto.getLastName();
		String email = patientInfoDto.getEmail();
		String mobile = patientInfoDto.getMobile();
		String street = patientInfoDto.getStreet();
		String city = patientInfoDto.getCity();
		String state = patientInfoDto.getState();
		String zipcode = patientInfoDto.getZipcode();
		String room = patientInfoDto.getRoom();
		String file = patientInfoDto.getFile();
		LocalDateTime cdate = patientInfoDto.getCreated_date();
		String dob = patientInfoDto.getDOB();
		int id = patientInfoDto.getId();
		int status = patientInfoDto.getStatus();
		int phyid = patientInfoDto.getPhysicianId();
		int admin_id = patientInfoDto.getAdmin_id();
		String file_name = patientInfoDto.getFile_name();

		String password = patientInfoDto.getPassword();

		if (!test) {
			
		}
		
		AspNetUsers aspNetUsers = new AspNetUsers();
		aspNetUsers.setEmail(email);
		aspNetUsers.setUserName(email);
		aspNetUsers.setPasswordHash(new PasswordHash().encryptPassword(password));
		aspNetUsers.setPhoneNumber(mobile);
		aspNetUsers.setCreatedDate(cdate);

		User user = new User();
		user.setFirstName(fname);
		user.setLastName(lname);
		user.setEmail(email);
		user.setMobile(mobile);
		user.setStreet(street);
		user.setCity(city);
		user.setState(state);
		user.setZipcode(zipcode);
		user.setAspnetUserId(aspNetUsers);
		user.setCreatedBy(aspNetUsers.getId());

		LocalDate curreDate = LocalDate.parse(dob);
		user.setIntDate(new DateModifier().getDay(curreDate));
		user.setStrMonth(new DateModifier().getMonth(curreDate));
		user.setIntYear(new DateModifier().getYear(curreDate));

		Request request = new Request();
		request.setFirstName(fname);
		request.setLastName(lname);
		request.setPhoneNumber(mobile);
		request.setEmail(email);
		request.setStatus(status);
		request.setPhysicianId(phyid);
		request.setCreatedDate(cdate);
		request.setDeclinedBy(aspNetUsers);

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
		LocalDate curreDate1 = LocalDate.parse(dob);
		requestClient.setIntDate(new DateModifier().getDay(curreDate1));
		requestClient.setStrMonth(new DateModifier().getMonth(curreDate1));
		requestClient.setIntYear(new DateModifier().getYear(curreDate1));

		RequestWiseFile requestWiseFile = new RequestWiseFile();
		requestWiseFile.setRequestId(request);
		requestWiseFile.setCreatedDate(LocalDateTime.now());
		
		requestWiseFile.setFileName("bhavyaaaaaaaaaaaaaa");

		patientInfoDao.savedao(aspNetUsers);

		patientInfoDao.savingdao(user);
		patientInfoDao.requestdao(request);
		patientInfoDao.requestClientdao(requestClient);
		patientInfoDao.requestWiseFiledao(requestWiseFile);

	}

}
