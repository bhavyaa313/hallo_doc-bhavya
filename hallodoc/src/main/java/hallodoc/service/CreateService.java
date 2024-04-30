package hallodoc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hallodoc.repo.UsersDao;


@Service
public class CreateService {
	
	
	@Autowired
	private UsersDao checkMail;
	
	public boolean ajaxCheck(String mail) {
		
		List list=checkMail.checkEmail(mail);

		
		if(list.size()==0) {
			return false;
		}
		else {
			return true;
		}
	}

}
