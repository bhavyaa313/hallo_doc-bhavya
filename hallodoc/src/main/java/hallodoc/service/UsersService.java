package hallodoc.service;

import java.util.List;

import org.apache.taglibs.standard.lang.jstl.test.beans.PublicBean1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.password4j.BcryptFunction;
import com.password4j.Password;
import com.password4j.types.Bcrypt;

import hallodoc.helper.PasswordHash;
import hallodoc.repo.UsersDao;

@Component
public class UsersService {

	@Autowired
	private UsersDao dao;

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
	
	public int getId(String mail) {
		List uIdList = dao.checkEmail1(mail);
		int uid = (int)uIdList.get(0);
		return uid;
		
	}
	
	


}
