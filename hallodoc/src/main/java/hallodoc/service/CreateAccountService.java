package hallodoc.service;

import java.security.KeyStore.PrivateKeyEntry;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hallodoc.dto.CreateAccountDto;
import hallodoc.helper.PasswordHash;
import hallodoc.helper.emailHelper;
import hallodoc.model.AspNetUsers;
import hallodoc.model.User;
import hallodoc.repo.AspNetUsersDao;
import hallodoc.repo.UserDao;

@Service
public class CreateAccountService {
	

	

	@Autowired
	private AspNetUsersDao aspNetUsersDao;
	
	@Autowired
	private UserDao userDao;
	
public void Service(CreateAccountDto createAccountDto) {
	
	
	String emailString = createAccountDto.getEmail();
	String passwordString = createAccountDto.getPassword();
	AspNetUsers aspNetUsers = new AspNetUsers();
	User user = new User();
	aspNetUsers.setCreatedDate(LocalDateTime.now());
	aspNetUsers.setEmail(emailString);

	aspNetUsers.setPasswordHash(passwordString);
	
	aspNetUsersDao.aspSave(aspNetUsers);
	
	
	
	user.setCreatedDate(LocalDateTime.now());
	user.setEmail(emailString);
	user.setCreatedBy(aspNetUsers.getId());
	user.setRequestWithEmail(true);
	userDao.userSave(user);
}
}
