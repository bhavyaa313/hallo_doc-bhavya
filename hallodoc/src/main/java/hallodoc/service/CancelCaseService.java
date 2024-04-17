package hallodoc.service;

import java.time.LocalDateTime;
import java.util.List;

import org.apache.taglibs.standard.lang.jstl.test.beans.PublicBean1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hallodoc.dto.CancelCaseDto;
import hallodoc.model.CaseTag;
import hallodoc.model.Request;
import hallodoc.model.RequestNotes;
import hallodoc.model.RequestStatusLog;
import hallodoc.model.User;
import hallodoc.repo.CancelCaseDao;
import hallodoc.repo.RequestDao;
import hallodoc.repo.RequestNotesDao;
import hallodoc.repo.RequestStatusLogDao;
import hallodoc.repo.UserDao;

@Service
public class CancelCaseService {
	
	@Autowired
	private CancelCaseDao cancelCaseDao;
	
	@Autowired
	private RequestService requestService;
	
	@Autowired
	private RequestDao requestDao;
	
	@Autowired
	private RequestStatusLogDao requestStatusLogDao;
	
	@Autowired
	private RequestNotesDao requestNotesDao;
	
	@Autowired
	private UserDao userDao;
	
	
	
public List<CaseTag> getReasons() {

		
		List<CaseTag> reasonsList = cancelCaseDao.getReasons();
		System.out.println("===================");
		System.out.println("servic eme aa gaya bhai");
		System.out.println(reasonsList);
		
		return reasonsList;

	}

public void service(CancelCaseDto cancelCaseDto, int userID)
{
	String reasonString = cancelCaseDto.getReasonString();
	int reqid = cancelCaseDto.getReqId();
	String noteString = cancelCaseDto.getAdditionalNoteString();
	
	System.out.println(reqid);
	
	List<User> users = userDao.getUserIDList(userID);
	User user = users.get(0);
	List<Request> requests = requestService.getRequestByReqId(reqid);
	Request request = requests.get(0);
	
	RequestStatusLog requestStatusLog = new RequestStatusLog();
	requestStatusLog.setAdminId(1);
	requestStatusLog.setCreatedDate(LocalDateTime.now());
	requestStatusLog.setNotes(noteString);
	requestStatusLog.setRequestId(request);
	requestStatusLog.setStatus(3);
	requestStatusLogDao.requestStatusLogSave(requestStatusLog);
	
	
	;
	request.setModifiedDate(LocalDateTime.now());
	request.setDeclinedBy(user.getAspnetUserId());
	request.setStatus(3);
	Integer rids = Integer.parseInt(reasonString);
	request.setCaseTagId(rids);
	requestDao.requestUpdate(request);
	
	
	RequestNotes requestNotes = new RequestNotes();
	requestNotes.setCreatedDate(LocalDateTime.now());
	requestNotes.setCreatedBy(user.getAspnetUserId());
	requestNotes.setRequestId(request);
	requestNotes.setNote(noteString);
	requestNotesDao.requestNotesSave(requestNotes);
	
	
	
	
	
}

	
	

}
