package hallodoc.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import javax.management.loading.PrivateClassLoader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hallodoc.dto.CloseCaseDto;
import hallodoc.dto.ViewCaseDto;
import hallodoc.helper.DateModifier;
import hallodoc.model.Request;
import hallodoc.model.RequestClient;
import hallodoc.model.RequestStatusLog;
import hallodoc.repo.RequestClientDao;
import hallodoc.repo.RequestDao;
import hallodoc.repo.RequestStatusLogDao;

@Service
public class CloseCaseService {
	
	@Autowired
	private RequestClientService requestClientService;
	
	@Autowired
	private RequestService requestService;
	
	@Autowired
	private RequestClientDao requestClientDao;
	
	@Autowired
	private RequestDao requestDao;
	
	@Autowired
	private RequestStatusLogDao requestStatusLogDao;
	
	
	public void service(CloseCaseDto closeCaseDto, Request rId ) {
		
		String fnameString = closeCaseDto.getFirstName();
		System.out.println("-------------------------------------------------------------------------------");
		System.out.println("-------------------------------------------------------------------------------");
		System.out.println("-------------------------------------------------------------------------------");
		System.out.println("-------------------------------------------------------------------------------");
		System.out.println(fnameString);
		String lnameString = closeCaseDto.getLastName();
		String dobString = closeCaseDto.getDob();
		String phoneString = closeCaseDto.getPhone();
		String noteString = closeCaseDto.getNotes();
		
		
		
			
		List<RequestClient> getClients = requestClientService.getRequestClientByReqId(rId);
		RequestClient requestClient = getClients.get(0);
		
		requestClient.setFirstName(fnameString);
		
		System.out.println(requestClient.getFirstName());
		requestClient.setLastName(lnameString);
		requestClient.setPhoneNumber(phoneString);
		requestClient.setNotes(noteString);
		if (dobString == null || dobString.isEmpty()) {

		} else {
			LocalDate currentDate = LocalDate.parse(dobString);
			requestClient.setIntDate(new DateModifier().getDay(currentDate));
			requestClient.setStrMonth(new DateModifier().getMonth(currentDate));
			requestClient.setIntYear(new DateModifier().getYear(currentDate));
		}
		
		System.out.println("-------------------------------------------------------------------------------");
		System.out.println("-------------------------------------------------------------------------------");
		System.out.println("-------------------------------------------------------------------------------");
		requestClientDao.requestClientUpdate(requestClient);
		
			
			
			
		
		
		
	}
	
	public void caseClosed(int reqId)
	{
		
		  List<Request> requests = requestDao.getRequests(reqId);
		  Request request = requests.get(0);
		  request.setStatus(9);
		  request.setModifiedDate(LocalDateTime.now());
		  requestDao.requestUpdate(request);
		  
		  List<RequestStatusLog> requestStatusLogs = requestStatusLogDao.getRequests(request);
		  RequestStatusLog requestStatusLog = requestStatusLogs.get(requestStatusLogs.size()-1);
		  RequestStatusLog requestStatusLog2 = new RequestStatusLog();
		  requestStatusLog2.setAdminId(requestStatusLog.getAdminId());
		  requestStatusLog2.setCreatedDate(LocalDateTime.now());
		  requestStatusLog2.setNotes("Case is Closed");
		  requestStatusLog2.setPhysicianId(requestStatusLog.getPhysicianId());
		  requestStatusLog2.setRequestId(request);
		  requestStatusLog2.setStatus(9);
		  requestStatusLogDao.requestStatusLogSave(requestStatusLog2);
		
	}

}

