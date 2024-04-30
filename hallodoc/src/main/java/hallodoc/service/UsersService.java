package hallodoc.service;

import java.util.List;

import javax.security.auth.x500.X500Principal;

import org.apache.taglibs.standard.lang.jstl.test.beans.PublicBean1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.password4j.BcryptFunction;
import com.password4j.Password;
import com.password4j.types.Bcrypt;

import hallodoc.helper.PasswordHash;
import hallodoc.model.AspNetUsers;
import hallodoc.model.User;
import hallodoc.repo.UserDao;
import hallodoc.repo.UsersDao;

@Component
public class UsersService {

	@Autowired
	private UsersDao dao;
	
	@Autowired
	private UserDao userDao;

	public boolean checkEmail5(String mail, String password) {
		// TODO Auto-generated method stub

		List list = dao.checkEmail5(mail);
		BcryptFunction bcrypt = BcryptFunction.getInstance(Bcrypt.B, 12);

		if (list.size() == 0) {
			return false;
		} else {
			String passhash = (String) list.get(0);

			String x = new PasswordHash().encryptPassword(password.trim());

			boolean verified = Password.check(password, passhash).with(bcrypt);

			return verified;
		}

	}

	public boolean checkEmail6(String mail) {
		// TODO Auto-generated method stub

		List list = dao.checkEmail(mail);

		if (list.size() == 0) {
			return false;
		} else {

			return true;
		}

	}

	public String getUser(String mail) {

		
		List name = dao.checkname(mail);
		String uname = (String) name.get(0);
		System.out.println(uname);
		return uname;

	}
	
	public User getId(String mail) {
		List<User> uIdList = dao.checkEmail1(mail);
		User user = uIdList.get(0);
		return user;
		
	}
	
	
	
	
	public boolean checkPasswordHash(String mail) {
		
		List<AspNetUsers> list = dao.checkEmail(mail);
		if (list.size()>0) {
			AspNetUsers aspNetUsers = list.get(0);
			
			String pswd = aspNetUsers.getPasswordHash();
		
			System.out.println(pswd);
			
			return pswd==null;
		}
		
		return false;
		
		
		
	}
	
	

	public List<User> getUserIdUser(String mail) {
		List<User> userList = userDao.getUser(mail);
		
		return userList;
	
		
		
	}
	
	
		
		
		
	}
	
	
	



