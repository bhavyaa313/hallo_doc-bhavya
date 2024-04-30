package hallodoc.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hallodoc.helper.PasswordHash;
import hallodoc.model.Admin;
import hallodoc.model.AspNetUsers;
import hallodoc.model.Request;
import hallodoc.model.User;
import hallodoc.repo.AdminDao;
import hallodoc.repo.AspNetUsersDao;
import hallodoc.repo.RequestDao;
import hallodoc.repo.UserDao;
import hallodoc.repo.UsersDao;

@Service
public class myProfileService {

	@Autowired
	private AspNetUsersDao aspNetUsersDao;

	@Autowired
	private UsersDao usersDao;

	@Autowired
	private UserDao userDao;

	@Autowired
	private RequestDao requestDao;
	
	@Autowired
	private AdminDao adminDao;

	private PasswordHash passwordHash;

	public void reset(int id, String password) {
		List<AspNetUsers> aspNetUsers = aspNetUsersDao.getAsplist(id);
		AspNetUsers aspNetUsers2 = aspNetUsers.get(0);
		aspNetUsers2.setPasswordHash(new PasswordHash().encryptPassword(password));

		aspNetUsers2.setModifiedDate(LocalDateTime.now());
		aspNetUsersDao.aspUpdate(aspNetUsers2);
	}

	public void editAdmin(int id, String fname, String lname, String email, String phone, String region, String state,
			int userid) {
		int rid = Integer.parseInt(region);
		List<AspNetUsers> aspNetUsers = aspNetUsersDao.getAsplist(id);
		AspNetUsers aspNetUsers2 = aspNetUsers.get(0);
		aspNetUsers2.setEmail(email);
		aspNetUsers2.setModifiedDate(LocalDateTime.now());
		aspNetUsers2.setPhoneNumber(phone);
		
		aspNetUsersDao.aspUpdate(aspNetUsers2);

		List<User> users = userDao.getUserIDList(userid);
		User user = users.get(0);
		user.setEmail(email);
		user.setFirstName(fname);
		user.setFirstName(fname);
		user.setLastName(lname);
		user.setMobile(phone);
		user.setModifiedBy(id);
		user.setModifiedDate(LocalDateTime.now());
		user.setRegionId(rid);
		user.setState(state);
		userDao.userUpdate(user);

		List<Request> requests = requestDao.getRequests(user);

		int i = 0;
		for (i = 0; i < requests.size(); i++) {
			Request request = requests.get(i);
			request.setFirstName(fname);
			request.setLastName(lname);
			request.setEmail(email);
			request.setPhoneNumber(phone);

		}
		
		List<Admin> admins = adminDao.getAdmin(aspNetUsers2);
		Admin admin = admins.get(0);
		admin.setFirsName(fname);
		admin.setLastName(lname);
		admin.setModifiedBy(id);
		admin.setRegionId(rid);
		admin.setModifiedDate(LocalDateTime.now());
		adminDao.adminUpdate(admin);
		
	}
	
	
	public void editBilling(int id, String address1, String address2, String city, String state, String phone, String zip)
	{
		List<AspNetUsers> aspNetUsers = aspNetUsersDao.getAsplist(id);
		AspNetUsers aspNetUsers2 = aspNetUsers.get(0);
		List<Admin> admins = adminDao.getAdmin(aspNetUsers2);
		Admin admin = admins.get(0);
		admin.setAddressOne(address1);
		admin.setAddressTwo(address2);
		admin.setAltPhone(phone);
		admin.setCity(city);
		admin.setModifiedDate(LocalDateTime.now());
		admin.setZip(zip);
		adminDao.adminUpdate(admin);
		
	}

}
