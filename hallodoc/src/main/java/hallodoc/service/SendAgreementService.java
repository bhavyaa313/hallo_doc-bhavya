package hallodoc.service;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.SecondaryTable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hallodoc.model.Request;
import hallodoc.model.RequestStatusLog;
import hallodoc.repo.RequestDao;
import hallodoc.repo.RequestStatusLogDao;

@Service
public class SendAgreementService {
	
	@Autowired
	private RequestDao requestDao;
	
	@Autowired
	private RequestStatusLogDao requestStatusLogDao;
	
	
	public void acceptAgreement(int reqId)
	{
		List<Request> requests = requestDao.getRequests(reqId);
		Request request = requests.get(0);
		request.setModifiedDate(LocalDateTime.now());
		request.setStatus(4);
		requestDao.requestUpdate(request);
		List<RequestStatusLog> requestStatusLogs = requestStatusLogDao.getRequests(request);
		  RequestStatusLog requestStatusLog = requestStatusLogs.get(requestStatusLogs.size()-1);
		  RequestStatusLog requestStatusLog2 = new RequestStatusLog();
		  requestStatusLog2.setAdminId(requestStatusLog.getAdminId());
		  requestStatusLog2.setCreatedDate(LocalDateTime.now());
		  requestStatusLog2.setNotes("Patient agreed");
		  requestStatusLog2.setPhysicianId(requestStatusLog.getPhysicianId());
		  requestStatusLog2.setRequestId(request);
		  requestStatusLog2.setStatus(4);
		  requestStatusLogDao.requestStatusLogSave(requestStatusLog2);
	}
	
	public void declineAgreement(int reqId, String notes)
	{
		List<Request> requests = requestDao.getRequests(reqId);
		Request request = requests.get(0);
		request.setModifiedDate(LocalDateTime.now());
		request.setStatus(7);
		requestDao.requestUpdate(request);
		List<RequestStatusLog> requestStatusLogs = requestStatusLogDao.getRequests(request);
		  RequestStatusLog requestStatusLog = requestStatusLogs.get(requestStatusLogs.size()-1);
		  RequestStatusLog requestStatusLog2 = new RequestStatusLog();
		  requestStatusLog2.setAdminId(requestStatusLog.getAdminId());
		  requestStatusLog2.setCreatedDate(LocalDateTime.now());
		  requestStatusLog2.setNotes(notes);
		  requestStatusLog2.setPhysicianId(requestStatusLog.getPhysicianId());
		  requestStatusLog2.setRequestId(request);
		  requestStatusLog2.setStatus(7);
		  requestStatusLogDao.requestStatusLogSave(requestStatusLog2);
		
		
	}

}
