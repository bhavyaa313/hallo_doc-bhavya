package hallodoc.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hallodoc.dto.AssignCaseDto;
import hallodoc.model.Physician;
import hallodoc.model.Request;
import hallodoc.model.RequestNotes;
import hallodoc.model.RequestStatusLog;
import hallodoc.model.User;
import hallodoc.repo.PhysicianDao;
import hallodoc.repo.RequestDao;
import hallodoc.repo.RequestStatusLogDao;
import hallodoc.repo.UserDao;

@Service
public class AssignCaseService {
	
	@Autowired
	private RequestStatusLogDao requestStatusLogDao;
	
	@Autowired
	private RequestDao requestDao;
	
	
	@Autowired
	private PhysicianDao physicianDao;
	
	@Autowired
	private RequestService requestService;
	
	@Autowired
	private UserDao userDao;
	

	
	public List<AssignCaseDto> servicePhysicians(int region)
	{
		
		List<AssignCaseDto> physicians = physicianDao.getPhysicians(region);
		return physicians;
		}
	
	
	public void service(AssignCaseDto assignCaseDto, int userID)
	
	{
	String regionString = assignCaseDto.getRegion();
	
	String reqId = assignCaseDto.getReqId3();
	String phyId = assignCaseDto.getPhyId();
	String noteString = assignCaseDto.getNotes();
	
	Integer reqIdInteger = Integer.parseInt(reqId);
	Integer phyInteger = Integer.parseInt(phyId);
	
	List<User> users = userDao.getUserIDList(userID);
	User user = users.get(0);
	
	List<Request> requests = requestService.getRequestByReqId(reqIdInteger);
	Request request = requests.get(0);
	
	List<Physician> physicians = physicianDao.getPhysiciansAll(phyInteger);
	Physician physician =  physicians.get(0);
	RequestStatusLog requestStatusLog = new RequestStatusLog();
	requestStatusLog.setAdminId(1);
	requestStatusLog.setCreatedDate(LocalDateTime.now());
	requestStatusLog.setNotes(noteString);
	requestStatusLog.setRequestId(request);
	requestStatusLog.setStatus(2);
	requestStatusLog.setPhysicianId(physician);
	requestStatusLogDao.requestStatusLogSave(requestStatusLog);
	
	
	
	request.setModifiedDate(LocalDateTime.now());
	request.setDeclinedBy(user.getAspnetUserId());
	request.setPhysicianId(phyInteger);
	request.setStatus(2);
	
	requestDao.requestUpdate(request);
	
	
	
	}
	
}
	

