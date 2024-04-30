package hallodoc.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hallodoc.dto.AdminDashboardDto;
import hallodoc.dto.PatientRecordsDto;
import hallodoc.model.Request;
import hallodoc.model.User;
import hallodoc.repo.RequestDao;
import hallodoc.repo.UserDao;

@Service
public class PatientRecordsService {
	
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private RequestDao requestDao;
	
	public List<PatientRecordsDto> pRecords(int uId)
	{
		List<PatientRecordsDto> patientRecordsDtos = new ArrayList<PatientRecordsDto>();
		List<User> users = userDao.getUserIDList(uId);
		User user = users.get(0);
		List<Request> requests = requestDao.getRequests(user);
		for (int i = 0; i < users.size(); i++) {
			Request request = requests.get(i);
			PatientRecordsDto patientRecordsDto = new PatientRecordsDto();
			patientRecordsDto.setClient(request.getRequestClient().getFirstName() + " " + request.getRequestClient().getLastName());
			patientRecordsDto.setrId(request.getRequestId());
			patientRecordsDto.setCreatedDate(request.getCreatedDate().toString());
			patientRecordsDto.setConfirmationNumber(request.getConfirmationNumber());
			patientRecordsDto.setProviderName(request.getPhysicianId().getFirstName()+ request.getPhysicianId().getLastName());
			if (request.getStatus() == 1) {
				patientRecordsDto.setStatus("New");
			} else if (request.getStatus() == 2) {
				patientRecordsDto.setStatus("Pending");
			} else if (request.getStatus() == 4 || request.getStatus() == 5) {
				patientRecordsDto.setStatus("Active");
			} else if (request.getStatus() == 6) {
				patientRecordsDto.setStatus("Concluded");
			} else if (request.getStatus() == 3) {
				patientRecordsDto.setStatus("Cancelled By Provider");
			} else if (request.getStatus() == 7) {
				patientRecordsDto.setStatus("Cancelled By Patient");
			} else if (request.getStatus() == 8) {
				patientRecordsDto.setStatus("Cancelled By Admin");
			} else if (request.getStatus() == 9) {
				patientRecordsDto.setStatus("UnPaid");
			} else if (request.getStatus() == 10) {
				patientRecordsDto.setStatus("Cleared");
			} else if (request.getStatus() == 11) {
				patientRecordsDto.setStatus("Blocked");
			}
			patientRecordsDtos.add(patientRecordsDto);
			
			
			
		}
		return patientRecordsDtos;
	}

}
