package hallodoc.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hallodoc.model.Request;
import hallodoc.model.RequestStatusLog;
import hallodoc.repo.RequestDao;
import hallodoc.repo.RequestStatusLogDao;
import net.bytebuddy.implementation.bytecode.ByteCodeAppender.Size;

@Service
public class ClearCaseService {
	
	@Autowired
	private RequestDao requestDao;
	
	@Autowired
	private RequestStatusLogDao requestStatusLogDao;
	
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

}
