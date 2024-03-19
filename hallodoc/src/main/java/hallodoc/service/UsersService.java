package hallodoc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.password4j.Password;

import hallodoc.helper.PasswordHash;
import hallodoc.repo.UsersDao;

@Component
public class UsersService {

	@Autowired
	private UsersDao dao;

	public boolean checkEmail(String mail, String password) {
		// TODO Auto-generated method stub

		List list = dao.checkEmail(mail);

		if (list.size() == 0) {
			return false;
		} else {
			String passhash = (String) list.get(0);
			
			
			 String x = new PasswordHash().encryptPassword(password.trim());
				/*
				 * boolean verified = Password.check(password, x) .with(bcrypt);
				 */
			 System.out.println(passhash);
			 System.out.println(x);
			if (passhash.trim().equals(x.trim())) {
				return true; 
			} else
				return false;
		}

	}

}
