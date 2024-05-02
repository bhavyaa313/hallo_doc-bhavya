package hallodoc.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hallodoc.dto.BlockRecordsDto;
import hallodoc.dto.SearchRecordsDto;
import hallodoc.helper.DateModifier;
import hallodoc.model.BlockRequests;
import hallodoc.model.Request;
import hallodoc.repo.RequestDao;

@Service
public class SearchHistoryService {

	@Autowired
	private RequestDao requestDao;

	public List<SearchRecordsDto> showReq(String status, String name, String reqType, String DOS, String TDOS,
			String phy, String email, String phone) {

		String hqlString1 = "from hallodoc.model.Request r where r.requestId!=0 and r.isDeleted=0";

		

		String hqlMain2 = hqlString1;

		if (!(status.equals("99"))) {
			String hql2 = " AND r.status=" + status;
			hqlMain2 = hqlMain2.concat(hql2);
		}

		if (name != "") {
			String hql2 = " AND r.requestId.requestClient.firstName LIKE CONCAT('%','" + name + "','%')";
			hqlMain2 = hqlMain2.concat(hql2);
		}

		if (!(reqType.equals("99"))) {
			String hql2 = " AND r.requestTypeId=" + reqType;
			hqlMain2 = hqlMain2.concat(hql2);
		}

		if (DOS != "") {
			String hql4 = " AND DATE(r.acceptedDate)=" + "'" + DOS + "'";
			hqlMain2 = hqlMain2.concat(hql4);
		}

		if (TDOS != "") {
			String hql4 = " AND DATE(r.acceptedDate)=" + "'" + TDOS + "'";
			hqlMain2 = hqlMain2.concat(hql4);
		}

		if (phy != "") {

			String hql3 = " AND r.physicianId.firstName LIKE CONCAT('%','" + phy + "','%')";
			hqlMain2 = hqlMain2.concat(hql3);
		}

		if (email != "") {

			String hql3 = " AND r.requestClient.email LIKE CONCAT('%','" + email + "','%')";
			hqlMain2 = hqlMain2.concat(hql3);
		}

		if (phone != "") {

			String hql3 = " AND r.requestClient.phoneNumber LIKE CONCAT('%','" + phone + "','%')";
			hqlMain2 = hqlMain2.concat(hql3);
		}

		List<Request> list = requestDao.getRequestsByRequestType(hqlMain2);
		List<SearchRecordsDto> searchRecordsDtos = new ArrayList<SearchRecordsDto>();
		for (int i = 0; i < list.size(); i++) {

			Request request = list.get(i);
			

			SearchRecordsDto searchRecordsDto = new SearchRecordsDto();
			
			searchRecordsDto.setReqId(request.getRequestId());

			if (!(request.getRequestClient().getAddress() == null)) {
				searchRecordsDto.setAddress(request.getRequestClient().getAddress());
			} else {
				searchRecordsDto.setAddress("-");
			}

			if (request.getRequestNotes() != null) {
				if (request.getRequestNotes().getAdminNotes() != null) {

					searchRecordsDto.setAdminNote(request.getRequestNotes().getAdminNotes());
				} else {
					searchRecordsDto.setAdminNote("-");
				}

					if (!(request.getRequestNotes().getNote() == null)) {
						searchRecordsDto.setPatientNote(request.getRequestNotes().getNote());
					} else {
						searchRecordsDto.setPatientNote("-");
					}

					if (!(request.getRequestNotes().getPhysicianNotes() == null)) {
						searchRecordsDto.setPhyNote(request.getRequestNotes().getPhysicianNotes());
					} else {
						searchRecordsDto.setPhyNote("-");
					}

				
			}
			
			else {
				
				searchRecordsDto.setAdminNote("-");
				searchRecordsDto.setPatientNote("-");
				searchRecordsDto.setPhyNote("-");
				
				
				
			}
			if (!(request.getAcceptedDate() == null)) {
				String month = new DateModifier().getMonth(request.getAcceptedDate().toLocalDate());
				Integer day = new DateModifier().getDay(request.getAcceptedDate().toLocalDate());
				Integer year = new DateModifier().getYear(request.getAcceptedDate().toLocalDate());

				String acceptedDate = new DateModifier().getDate(day, month, year);
				searchRecordsDto.setCloseDate(acceptedDate);
				searchRecordsDto.setdOS(acceptedDate);
			} else {
				searchRecordsDto.setCloseDate("-");
				searchRecordsDto.setdOS("-");

			}

			searchRecordsDto.setEmail(request.getRequestClient().getEmail());

			if (!(request.getRequestClient().getPhoneNumber() == null)) {
				searchRecordsDto.setPhone(request.getRequestClient().getPhoneNumber());
			}

			if (!(request.getPhysicianId().getFirstName() == null)) {
				searchRecordsDto.setPhy(request.getPhysicianId().getFirstName());
			} else {
				searchRecordsDto.setPhy("-");
			}

			searchRecordsDto.setpName(request.getRequestClient().getFirstName());
			searchRecordsDto.setReqId(request.getRequestId());
			searchRecordsDto.setRequestor(request.getFirstName());
			searchRecordsDto.setRstatus(status);
			if (!(request.getRequestClient().getZipcode() == null)) {
				searchRecordsDto.setZipString(request.getRequestClient().getZipcode());
			} else {
				searchRecordsDto.setZipString("-");
			}
			
			searchRecordsDtos.add(searchRecordsDto);

		}

		return searchRecordsDtos;
	}
	
	public void deleteRecord(int rId)
	{
		List<Request> requests = requestDao.getRequests(rId);
		Request request = requests.get(0);
		request.setDeleted(true);
		requestDao.requestUpdate(request);
	}

}
