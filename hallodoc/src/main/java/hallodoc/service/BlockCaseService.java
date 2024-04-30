package hallodoc.service;

import java.lang.invoke.StringConcatFactory;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hallodoc.dto.BlockCaseDto;
import hallodoc.model.BlockRequests;
import hallodoc.model.Request;
import hallodoc.model.RequestClient;
import hallodoc.model.RequestStatusLog;
import hallodoc.model.User;
import hallodoc.repo.BlockRequestDao;
import hallodoc.repo.RequestDao;
import hallodoc.repo.RequestStatusLogDao;
import hallodoc.repo.UserDao;

@Service
public class BlockCaseService {

	@Autowired
	private RequestService requestService;

	@Autowired
	private RequestDao requestDao;

	@Autowired
	private RequestStatusLogDao requestStatusLogDao;

	@Autowired
	private BlockRequestDao blockRequestDao;
	
	@Autowired
	private RequestClientService requestClientService;
	
	@Autowired
	private UserDao userDao;
	
	public void service(BlockCaseDto blockCaseDto, int userID)
	
	{
		
		String reasonString = blockCaseDto.getAdditionalNoteString2();
		int reqid = blockCaseDto.getReqId2();
		List<User> users = userDao.getUserIDList(userID);
		User user = users.get(0);
		
		List<Request> requests = requestService.getRequestByReqId(reqid);
		Request request = requests.get(0);
		
		RequestStatusLog requestStatusLog = new RequestStatusLog();
		requestStatusLog.setAdminId(1);
		requestStatusLog.setCreatedDate(LocalDateTime.now());
		requestStatusLog.setNotes(reasonString);
		requestStatusLog.setRequestId(request);
		requestStatusLog.setStatus(11);
		requestStatusLogDao.requestStatusLogSave(requestStatusLog);
		
		
		
		request.setModifiedDate(LocalDateTime.now());
		request.setDeclinedBy(user.getAspnetUserId());
		request.setStatus(11);
		
		requestDao.requestUpdate(request);
		
		List<RequestClient> requestClients = requestClientService.getRequestClientByReqId(request);
		RequestClient requestClient = requestClients.get(0);
		BlockRequests blockRequests = new BlockRequests();
		blockRequests.setCreated_date(LocalDateTime.now());
		blockRequests.setEmail(requestClient.getEmail());
		blockRequests.setIs_active(false);
		blockRequests.setPhone_number(requestClient.getPhoneNumber());
		blockRequests.setReason(reasonString);
		blockRequests.setRequest_id(request);
		blockRequestDao.blockRequestSave(blockRequests);
		
		
		
	}

}
