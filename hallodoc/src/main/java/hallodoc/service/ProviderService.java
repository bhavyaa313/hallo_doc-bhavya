package hallodoc.service;

import java.time.LocalDateTime;

import hallodoc.dto.CreateProviderDto;
import hallodoc.model.Physician;



import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hallodoc.enums.RegionEnum;

import hallodoc.helper.PasswordHash;
import hallodoc.helper.TokenGenerator;
import hallodoc.model.AspNetUsers;
import hallodoc.model.EmailLog;
import hallodoc.model.Physician;
import hallodoc.model.User;
import hallodoc.model.VerificationToken;
import hallodoc.repo.AspNetUsersDao;
import hallodoc.repo.EmailLogDao;
import hallodoc.repo.PhysicianDao;
import hallodoc.repo.UserDao;
import hallodoc.repo.VerificationTokenDao;


@Service
public class ProviderService {

	@Autowired
	private mailService mailService;

	@Autowired
	private EmailLogDao emailLogDao;

	@Autowired
	private AspNetUsersDao aspNetUsersDao;

	@Autowired
	private UserDao userDao;

	@Autowired
	private PhysicianDao physicianDao;

	public void emailSendForPswd(String mail, String pswd) {

		String content2 = "Hello! Welocme To HalloDoc! Here is your password " + pswd + ".";
		mailService.send(mail, "Welocme To HalloDoc Platform", content2);

		EmailLog emailLog = new EmailLog();

		emailLog.setSubject_name("Created New Provider");
		emailLog.setEmail_id(mail);
		emailLog.setRole_id(2);
		emailLog.setCreated_date(LocalDateTime.now());

		emailLogDao.emailLogSave(emailLog);

	}

	public void createProvider(CreateProviderDto CreateProviderDto) {

		emailSendForPswd(CreateProviderDto.getMail(), CreateProviderDto.getPswd());

		int regionId = RegionEnum.valueOf(CreateProviderDto.getState()).getid();

		AspNetUsers aspNetUsers = new AspNetUsers();
		aspNetUsers.setEmail(CreateProviderDto.getMail());
		aspNetUsers.setPhoneNumber(CreateProviderDto.getPhone());
		aspNetUsers.setUserName(CreateProviderDto.getfName());
		aspNetUsers.setCreatedDate(LocalDateTime.now());
		aspNetUsers.setPasswordHash(new PasswordHash().encryptPassword(CreateProviderDto.getPswd()));
		aspNetUsersDao.aspSave(aspNetUsers);
		User user = new User();
		user.setFirstName(CreateProviderDto.getfName());
		user.setLastName(CreateProviderDto.getlName());
		user.setEmail(CreateProviderDto.getMail());
		user.setMobile(CreateProviderDto.getPhone());
		user.setStreet(CreateProviderDto.getCity());
		user.setCity(CreateProviderDto.getCity());
		user.setState(CreateProviderDto.getState());
		user.setZipcode(CreateProviderDto.getZip());
		user.setCreatedDate(LocalDateTime.now());
		user.setCreatedBy(751);
		user.setRegionId(regionId);
		user.setRoleId(2);
		user.setAspnetUserId(aspNetUsers);
		userDao.userSave(user);

	

		Physician physician = new Physician();
		physician.setAspnetUserId(aspNetUsers);
		physician.setFirstName(CreateProviderDto.getfName());
		physician.setLastName(CreateProviderDto.getlName());
		physician.setMedicalLiscense(CreateProviderDto.getMedicalLi());
		physician.setEmail(CreateProviderDto.getMail());
		physician.setMobile(CreateProviderDto.getPhone());
		
		physician.setPhoto(CreateProviderDto.getPhoto());
		physician.setAdminNotes(CreateProviderDto.getAdminNotes());
		physician.setAddressOne(CreateProviderDto.getAddrOne());
		physician.setAddressTwo(CreateProviderDto.getAddrTwo());
		physician.setCity(CreateProviderDto.getCity());
		physician.setRegionId(regionId);
		physician.setZip(CreateProviderDto.getZip());
		physician.setAltPhone(CreateProviderDto.getPhone());
		physician.setCreatedBy(751);
		physician.setCreatedDate(LocalDateTime.now());
		physician.setStatus(0);
		physician.setBusinessName(CreateProviderDto.getbName());
		physician.setBusinessWebsite(CreateProviderDto.getbWebsite());
		physician.setRoleId(0);
		physician.setNpiNumber(CreateProviderDto.getNpiNum());
		physician.setSignature(CreateProviderDto.getSign());
		physician.setSyncEmailAddress(CreateProviderDto.getSyncMail());
		

		physicianDao.physicianSave(physician);

	}
	
	public  void reset(CreateProviderDto CreateProviderDto, int id, int pId)
	{
		List<AspNetUsers> aspNetUsers = aspNetUsersDao.getAsplist(id);
		AspNetUsers aspNetUsers2 = aspNetUsers.get(0);
		
		aspNetUsers2.setPasswordHash(new PasswordHash().encryptPassword(CreateProviderDto.getPswd()));
		aspNetUsers2.setModifiedDate(LocalDateTime.now());
		aspNetUsersDao.aspUpdate(aspNetUsers2);
		
		
		
	}

	public  void reset1(CreateProviderDto CreateProviderDto, int id, int pId)
	{
		
		List<Physician> physicians = physicianDao.getPhysiciansAll(pId);
		Physician physician = physicians.get(0);
		physician.setNpiNumber(CreateProviderDto.getNpiNum());
		physician.setFirstName(CreateProviderDto.getfName());
		physician.setLastName(CreateProviderDto.getlName());
		physician.setMedicalLiscense(CreateProviderDto.getMedicalLi());
		physician.setEmail(CreateProviderDto.getMail());
		physician.setMobile(CreateProviderDto.getPhone());
		int regionId = Integer.parseInt(CreateProviderDto.getState());
		physician.setRegionId(regionId);
		physicianDao.physicianUpdate(physician);
		
		
		
		
	}
	
	public  void reset2(CreateProviderDto CreateProviderDto, int id, int pId)
	{
		
		List<Physician> physicians = physicianDao.getPhysiciansAll(pId);
	
		Physician physician = physicians.get(0);
		physician.setAddressOne(CreateProviderDto.getAddrOne());
		physician.setAddressTwo(CreateProviderDto.getAddrTwo());
		physician.setCity(CreateProviderDto.getCity());
		
		physician.setZip(CreateProviderDto.getZip());
		physicianDao.physicianUpdate(physician);
		
		
		
		
	}
	
	public  void reset3(CreateProviderDto CreateProviderDto, int id, int pId)
	{
		
		List<Physician> physicians = physicianDao.getPhysiciansAll(pId);
		Physician physician = physicians.get(0);
		physician.setBusinessName(CreateProviderDto.getbName());
		physician.setBusinessWebsite(CreateProviderDto.getbWebsite());
		physician.setPhoto(CreateProviderDto.getPhoto());
		physician.setSignature(CreateProviderDto.getSign());
		physician.setAdminNotes(CreateProviderDto.getAdminNotes());
		physicianDao.physicianUpdate(physician);
		
		
	}
	
	
	
	
	

}
