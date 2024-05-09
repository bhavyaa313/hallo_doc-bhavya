package hallodoc.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hallodoc.model.Physician;
import hallodoc.model.Request;
import hallodoc.model.RequestStatusLog;
import hallodoc.repo.PhysicianDao;
import hallodoc.repo.RequestDao;
import hallodoc.repo.RequestStatusLogDao;
import net.bytebuddy.implementation.bytecode.ByteCodeAppender.Size;

@Service
public class ClearCaseService {
	
	@Autowired
	private RequestDao requestDao;
	
	@Autowired
	private RequestStatusLogDao requestStatusLogDao;
	
	@Autowired
	private PhysicianDao physicianDao;
	
	public void service(int reqId)
	
	{
	  List<Request> requests = requestDao.getRequests(reqId);
	  Request request = requests.get(0);
	  request.setStatus(10);
	  request.setModifiedDate(LocalDateTime.now());
	  requestDao.requestUpdate(request);
	  
	  List<RequestStatusLog> requestStatusLogs = requestStatusLogDao.getRequests(request);
	  RequestStatusLog requestStatusLog = requestStatusLogs.get(requestStatusLogs.size()-1);
	  RequestStatusLog requestStatusLog2 = new RequestStatusLog();
	  requestStatusLog2.setAdminId(requestStatusLog.getAdminId());
	  requestStatusLog2.setCreatedDate(LocalDateTime.now());
	  requestStatusLog2.setNotes("Case is Cleared");
	  requestStatusLog2.setPhysicianId(requestStatusLog.getPhysicianId());
	  requestStatusLog2.setRequestId(request);
	  requestStatusLog2.setStatus(10);
	  requestStatusLogDao.requestStatusLogSave(requestStatusLog2);
	}
	
	
public void acceptCase(int reqId, int phyId)
	
	{
	  List<Request> requests = requestDao.getRequests(reqId);
	  Request request = requests.get(0);
	  request.setStatus(2);
	  request.setModifiedDate(LocalDateTime.now());
	  requestDao.requestUpdate(request);
	  List<Physician> physicians = physicianDao.getPhysiciansAll(phyId);
	  Physician physician = physicians.get(0);
	  List<RequestStatusLog> requestStatusLogs = requestStatusLogDao.getRequests(request);
	 
	  RequestStatusLog requestStatusLog2 = new RequestStatusLog();
	  requestStatusLog2.setAdminId(1);
	  requestStatusLog2.setCreatedDate(LocalDateTime.now());
	  requestStatusLog2.setNotes("Case is Accepted");
	  requestStatusLog2.setPhysicianId(physician);
	  requestStatusLog2.setRequestId(request);
	  requestStatusLog2.setStatus(2);
	  requestStatusLogDao.requestStatusLogSave(requestStatusLog2);
	}

public void consultCase(int reqId, int phyId)

{
  List<Request> requests = requestDao.getRequests(reqId);
  Request request = requests.get(0);
  request.setStatus(6);
  request.setModifiedDate(LocalDateTime.now());
  requestDao.requestUpdate(request);
  List<Physician> physicians = physicianDao.getPhysiciansAll(phyId);
  request.setAcceptedDate(LocalDateTime.now());
  Physician physician = physicians.get(0);
  List<RequestStatusLog> requestStatusLogs = requestStatusLogDao.getRequests(request);
 
  RequestStatusLog requestStatusLog2 = new RequestStatusLog();
  requestStatusLog2.setAdminId(1);
  requestStatusLog2.setCreatedDate(LocalDateTime.now());
  requestStatusLog2.setNotes("Case is Accepted");
  requestStatusLog2.setPhysicianId(physician);
  requestStatusLog2.setRequestId(request);
  requestStatusLog2.setStatus(6);
  requestStatusLogDao.requestStatusLogSave(requestStatusLog2);
}


public void housecall(int reqId, int phyId)

{
  List<Request> requests = requestDao.getRequests(reqId);
  Request request = requests.get(0);
  request.setStatus(5);
  
  request.setModifiedDate(LocalDateTime.now());
  requestDao.requestUpdate(request);
  List<Physician> physicians = physicianDao.getPhysiciansAll(phyId);
  Physician physician = physicians.get(0);
  List<RequestStatusLog> requestStatusLogs = requestStatusLogDao.getRequests(request);
 
  RequestStatusLog requestStatusLog2 = new RequestStatusLog();
  requestStatusLog2.setAdminId(1);
  requestStatusLog2.setCreatedDate(LocalDateTime.now());
  requestStatusLog2.setNotes("Case is Accepted");
  requestStatusLog2.setPhysicianId(physician);
  requestStatusLog2.setRequestId(request);
  requestStatusLog2.setStatus(5);
  requestStatusLogDao.requestStatusLogSave(requestStatusLog2);
}

public void housecall2(int reqId, int phyId)

{
  List<Request> requests = requestDao.getRequests(reqId);
  Request request = requests.get(0);
  request.setStatus(6);
  request.setModifiedDate(LocalDateTime.now());
  request.setAcceptedDate(LocalDateTime.now());
  requestDao.requestUpdate(request);
  List<Physician> physicians = physicianDao.getPhysiciansAll(phyId);
  Physician physician = physicians.get(0);
  List<RequestStatusLog> requestStatusLogs = requestStatusLogDao.getRequests(request);
 
  RequestStatusLog requestStatusLog2 = new RequestStatusLog();
  requestStatusLog2.setAdminId(1);
  requestStatusLog2.setCreatedDate(LocalDateTime.now());
  requestStatusLog2.setNotes("Case is Accepted");
  requestStatusLog2.setPhysicianId(physician);
  requestStatusLog2.setRequestId(request);
  requestStatusLog2.setStatus(6);
  requestStatusLogDao.requestStatusLogSave(requestStatusLog2);
}







}
