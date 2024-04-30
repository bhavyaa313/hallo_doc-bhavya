package hallodoc.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hallodoc.dto.EditProfileDto;
import hallodoc.dto.PatientInfoDto;
import hallodoc.helper.DateModifier;
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

@Service
public class EditProfileService {
	
	
	

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
	
	public void service(EditProfileDto editProfileDto) {
	
	String fnameString = editProfileDto.getFname();
	String lnamString = editProfileDto.getLname();
	String dobString = editProfileDto.getDob();
	String phoneString = editProfileDto.getPhone();
	String emailString = editProfileDto.getEmail();
	String streetString = editProfileDto.getStreet();
	String cityString = editProfileDto.getCity();
	String stateString = editProfileDto.getState();
	String zipcodeString = editProfileDto.getZipcode();
	
	List<AspNetUsers> list = usersDao.checkEmail(emailString);
	
	AspNetUsers aspNetUsers = list.get(0);
	
	aspNetUsers.setPhoneNumber(phoneString);
	aspNetUsers.setModifiedDate(LocalDateTime.now());
	
	aspNetUsersDao.aspUpdate(aspNetUsers);
	
	List<User> list2  =    usersDao.checkEmail1(emailString);
	
	User user = list2.get(0);
	
	
	user.setFirstName(fnameString);
	user.setLastName(lnamString);
	user.setStreet(streetString);
	user.setCity(cityString);
	user.setState(stateString);
	user.setZipcode(zipcodeString);
	user.setMobile(phoneString);
	if (dobString == null || dobString.isEmpty()) {

	} else {
		LocalDate currentDate = LocalDate.parse(dobString);
		user.setIntDate(new DateModifier().getDay(currentDate));
		user.setStrMonth(new DateModifier().getMonth(currentDate));
		user.setIntYear(new DateModifier().getYear(currentDate));
	}
	user.setModifiedDate(LocalDateTime.now());
	
	
	userDao.userUpdate(user);
	
	 List<Request> list3 =  requestDao.getRequestss(user);
	
	
	for(int i=0 ; i<list3.size(); i++)
		
	{
		
		Request request = list3.get(i);
		request.setFirstName(fnameString);
		request.setLastName(lnamString);
		request.setPhoneNumber(phoneString);
		request.setModifiedDate(LocalDateTime.now());
		requestDao.requestUpdate(request);
		List<RequestClient> list4 =  requestClientDao.getRequests(request);
		RequestClient requestClient = list4.get(0);
		requestClient.setFirstName(fnameString);
		requestClient.setLastName(lnamString);
		requestClient.setPhoneNumber(phoneString);
		requestClient.setStreet(streetString);
		requestClient.setCity(cityString);
		requestClient.setState(stateString);
		requestClient.setZipcode(zipcodeString);
		if (dobString == null || dobString.isEmpty()) {

		} else {
			LocalDate currentDate = LocalDate.parse(dobString);
			requestClient.setIntDate(new DateModifier().getDay(currentDate));
			requestClient.setStrMonth(new DateModifier().getMonth(currentDate));
			requestClient.setIntYear(new DateModifier().getYear(currentDate));
		}
		requestClientDao.requestClientUpdate(requestClient);
		
		List<RequestWiseFile> list5 = requestWiseFileDao.getRequestsWiseFileList(request);
		RequestWiseFile requestWiseFile = list5.get(0);
		requestWiseFile.setUploader(fnameString + " " + lnamString);
		
	}
	
	
	 
	
	
	
	
	
	
	
	
	
	
	

}
	
}
