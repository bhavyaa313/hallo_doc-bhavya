package hallodoc.service;

import java.time.LocalDateTime;
import java.util.List;

import javax.management.loading.PrivateClassLoader;
import javax.swing.text.html.FormSubmitEvent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hallodoc.dto.ViewNotesDto;
import hallodoc.model.Request;
import hallodoc.model.RequestNotes;
import hallodoc.model.RequestStatusLog;
import hallodoc.model.User;
import hallodoc.repo.RequestDao;
import hallodoc.repo.RequestNotesDao;
import hallodoc.repo.RequestStatusLogDao;
import hallodoc.repo.UserDao;
import net.bytebuddy.asm.Advice.Return;

@Service
public class ViewNotesService {

	@Autowired
	private RequestNotesDao requestNotesDao;

	@Autowired
	private RequestDao requestDao;
	
	@Autowired
	private UserDao userDao;

	@Autowired
	private RequestStatusLogDao requestStatusLogDao;

	public ViewNotesDto service(int reqId, ViewNotesDto viewNotesDto)

	{
		
		String addAdminNoteString = viewNotesDto.getAdditionalNote();

		List<Request> requests = requestDao.getRequests(reqId);

		Request request = requests.get(0);
		
		List<RequestNotes> requestNotes = requestNotesDao.getRequests(reqId);
		if(requestNotes.size()==0)
		{
			viewNotesDto.setAdminNote("-");
			viewNotesDto.setPhysicianNote("-");
		}
		
		else {
			
		
			
		RequestNotes requestNotes2 = requestNotes.get(0);		

			if (requestNotes2.getAdminNotes()==null)

			{
				viewNotesDto.setAdminNote("-");
			}

			else {
				viewNotesDto.setAdminNote(requestNotes2.getAdminNotes());
			}

			if (requestNotes2.getPhysicianNotes()==null) {

				viewNotesDto.setPhysicianNote("-");
			}

			else {
				viewNotesDto.setPhysicianNote(requestNotes2.getPhysicianNotes());
			}
			
		}
	

		List<RequestStatusLog> requestStatusLogs = requestStatusLogDao.getRequests(request);
		
		if(requestStatusLogs.size()==0) {
			viewNotesDto.setTransferNote("-");
		}
		
		else {
			
			RequestStatusLog requestStatusLog = requestStatusLogs.getLast();

			if (requestStatusLog.getTransToPhysicianId() == null)

			{
				viewNotesDto.setTransferNote("-");
			}

			else {
				viewNotesDto.setTransferNote(requestStatusLog.getNotes());
			}

			
		}
		
		List<RequestStatusLog> requestStatusLogs2 = requestStatusLogDao.getRequestStatusLogsAdmin(request);
		

		if(requestStatusLogs2.size()==0) {
			viewNotesDto.setAdminCancellationNote("-");
		}
		
		else {
			RequestStatusLog requestStatusLog2 = requestStatusLogs.getLast();
			
			if (requestStatusLog2 == null)

			{
				viewNotesDto.setAdminCancellationNote("-");
			}

			else {
				viewNotesDto.setAdminCancellationNote(requestStatusLog2.getNotes());

			}
			
		}
		
		

		List<RequestStatusLog> requestStatusLogs3 = requestStatusLogDao.getRequestStatusLogsPatient(request);
		

		if(requestStatusLogs3.size()==0) {
			viewNotesDto.setPatientCancellationNote("-");
		}
		else {
			RequestStatusLog requestStatusLog3 = requestStatusLogs.getLast();
			
			if (requestStatusLog3 == null)

			{
				viewNotesDto.setPatientCancellationNote(requestStatusLog3.getNotes());
			}

			else {
				viewNotesDto.setPatientCancellationNote(requestStatusLog3.getNotes());

			}
			
			

			
		}
		
		
		
		
		return viewNotesDto;
	}
	
	public void submitProviderNote(int reqId, String notes, int userID)
	{
		List<Request> requests = requestDao.getRequests(reqId);
		Request request = requests.get(0);
		
		List<User> users1 = userDao.getUserIDList(userID);
		User user7 = users1.get(0);
		List<RequestNotes> requestNotes = requestNotesDao.getRequests(reqId);
		if (requestNotes.size()==0) {
			RequestNotes requestNotes2 = new RequestNotes();
			requestNotes2.setPhysicianNotes(notes);
			/* requestNotes2.setCreatedBy(user7.getAspnetUserId()); */
			requestNotes2.setCreatedDate(LocalDateTime.now());
			requestNotes2.setRequestId(request);

			requestNotesDao.requestNotesSave(requestNotes2);
		}
		else {
			RequestNotes requestNotes2 = requestNotes.get(0);
			requestNotes2.setPhysicianNotes(notes);
			/* requestNotes2.setModifiedBy(user7.getAspnetUserId()); */
			requestNotes2.setModifiedDate(LocalDateTime.now());
			requestNotesDao.requestNotesUpdate(requestNotes2);
			
		}
		
		
		
		
	}
	
	public void submitAdminNote(int reqId, String notes, int userID)
	
	{
		List<Request> requests = requestDao.getRequests(reqId);
		Request request = requests.get(0);
		
		List<User> users1 = userDao.getUserIDList(userID);
		User user7 = users1.get(0);

		List<RequestNotes> requestNotes = requestNotesDao.getRequests(reqId);
		if (requestNotes.size()==0) {
			RequestNotes requestNotes2 = new RequestNotes();
			requestNotes2.setAdminNotes(notes);
			requestNotesDao.requestNotesSave(requestNotes2);
			requestNotes2.setCreatedBy(user7.getAspnetUserId());
			requestNotes2.setCreatedDate(LocalDateTime.now());
			requestNotes2.setRequestId(request);

		}
		else {
			RequestNotes requestNotes2 = requestNotes.get(0);
			requestNotes2.setAdminNotes(notes);
			requestNotesDao.requestNotesUpdate(requestNotes2);
			requestNotes2.setModifiedBy(user7.getAspnetUserId());
			requestNotes2.setModifiedDate(LocalDateTime.now());
			
		}
		
		
		
		
	}
	
	

}
