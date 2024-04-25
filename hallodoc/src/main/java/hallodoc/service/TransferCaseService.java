package hallodoc.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hallodoc.dto.AssignCaseDto;
import hallodoc.dto.TransferCaseDto;
import hallodoc.model.Physician;
import hallodoc.model.Request;
import hallodoc.model.RequestStatusLog;
import hallodoc.model.User;
import hallodoc.repo.PhysicianDao;
import hallodoc.repo.RequestDao;
import hallodoc.repo.RequestStatusLogDao;
import hallodoc.repo.UserDao;
import net.bytebuddy.implementation.bytecode.ByteCodeAppender.Size;

@Service
public class TransferCaseService {
	
	@Autowired
	private PhysicianDao physicianDao;
	
	@Autowired
	private RequestStatusLogDao requestStatusLogDao;
	
	@Autowired
	private RequestDao requestDao;
	
	
	
	
	@Autowired
	private RequestService requestService;
	
	@Autowired
	private UserDao userDao;
	
	public List<TransferCaseDto> servicePhysicians(int region)
	{
		
		List<TransferCaseDto> physicians = physicianDao.getPhysicians(region);
		return physicians;
		}
	
	
public void service(TransferCaseDto transferCaseDto, int userID)
	
	{
	String regionString = transferCaseDto.getRegion();
	
	
	String reqId = transferCaseDto.getReqId4();
	String phyId = transferCaseDto.getPhyId1();
	String noteString = transferCaseDto.getNotes1();
	
	Integer reqIdInteger = Integer.parseInt(reqId);
	Integer phyInteger = Integer.parseInt(phyId);
	
	List<User> users = userDao.getUserIDList(userID);
	User user = users.get(0);
	
	List<Request> requests = requestService.getRequestByReqId(reqIdInteger);
	Request request = requests.get(0);
	
	List<Physician> physicians = physicianDao.getPhysiciansAll(phyInteger);
	Physician physician =  physicians.get(0);
	RequestStatusLog requestStatusLog = new RequestStatusLog();
	List<RequestStatusLog> requestStatusLogs = requestStatusLogDao.getRequests(request);
	RequestStatusLog requestStatusLog2 = requestStatusLogs.get(requestStatusLogs.size()-1);
	requestStatusLog.setAdminId(1);
	requestStatusLog.setCreatedDate(LocalDateTime.now());
	requestStatusLog.setNotes(noteString);
	requestStatusLog.setRequestId(request);
	requestStatusLog.setTransToPhysicianId(physician);
	requestStatusLog.setStatus(1);
	requestStatusLog.setPhysicianId(requestStatusLog2.getPhysicianId());
	requestStatusLogDao.requestStatusLogSave(requestStatusLog);
	
	
	
	request.setModifiedDate(LocalDateTime.now());

	request.setStatus(1);
	request.setPhysicianId(phyInteger);
	
	requestDao.requestUpdate(request);
	
	
	
	}

}
