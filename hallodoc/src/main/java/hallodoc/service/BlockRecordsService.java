package hallodoc.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hallodoc.dto.BlockRecordsDto;
import hallodoc.dto.EmailLogsDto;
import hallodoc.helper.DateModifier;
import hallodoc.model.BlockRequests;
import hallodoc.model.EmailLog;
import hallodoc.model.Request;
import hallodoc.repo.BlockRequestDao;
import hallodoc.repo.RequestDao;

@Service
public class BlockRecordsService {

	@Autowired
	private BlockRequestDao blockRequestDao;

	@Autowired
	private RequestDao requestDao;

	public List<BlockRecordsDto> showReq(String name, String date, String email, String phone) {

		String hqlString1 = "from hallodoc.model.BlockRequests b where b.blockRequestId!=0";

		String hqlMain2 = hqlString1;

		if (name != "") {
			String hql2 = " AND b.request_id.requestClient.firstName LIKE CONCAT('%','" + name + "','%')";
			hqlMain2 = hqlMain2.concat(hql2);
		}

		if (date != "") {
			String hql4 = " AND DATE(b.created_date)=" + "'" + date + "'";
			hqlMain2 = hqlMain2.concat(hql4);
		}

		if (email != "") {

			String hql3 = " AND b.email LIKE CONCAT('%','" + email + "','%')";
			hqlMain2 = hqlMain2.concat(hql3);
		}

		if (phone != "") {

			String hql3 = " AND b.phone_number LIKE CONCAT('%','" + phone + "','%')";
			hqlMain2 = hqlMain2.concat(hql3);
		}

		List<BlockRequests> list = blockRequestDao.getBlockList(hqlMain2);
		List<BlockRecordsDto> blockRecordsDtos = new ArrayList<BlockRecordsDto>();
		for (int i = 0; i < list.size(); i++) {

			BlockRequests blockRequests = list.get(i);

			BlockRecordsDto blockRecordsDto = new BlockRecordsDto();
			

		

			String month = new DateModifier().getMonth(blockRequests.getCreated_date().toLocalDate());
			Integer day = new DateModifier().getDay(blockRequests.getCreated_date().toLocalDate());
			Integer year = new DateModifier().getYear(blockRequests.getCreated_date().toLocalDate());

			String createdDate = new DateModifier().getDate(day, month, year);

			blockRecordsDto.setEmail(blockRequests.getEmail());
			blockRecordsDto.setDate(createdDate);
			blockRecordsDto.setIsActive(blockRequests.isIs_active());
			
			blockRecordsDto.setNote(blockRequests.getReason());
			blockRecordsDto.setPhone(blockRequests.getPhone_number());
			blockRecordsDto.setReqId(blockRequests.getRequest_id().getRequestId());
			blockRecordsDto.setName(blockRequests.getRequest_id().getRequestClient().getFirstName() + " " + blockRequests.getRequest_id().getRequestClient().getLastName());
			blockRecordsDto.setbId(blockRequests.getBlockRequestId());
		
			
			blockRecordsDtos.add(blockRecordsDto);

		}

		return blockRecordsDtos;
	}

	public void unblock(int id, int bid) {
		List<Request> requests = requestDao.getRequests(id);
		Request request = requests.get(0);
		request.setStatus(1);
		request.setModifiedDate(LocalDateTime.now());
		requestDao.requestUpdate(request);
		List<BlockRequests> blockRequests = blockRequestDao.getBlockList(bid);
		BlockRequests blockRequests2 = blockRequests.get(0);
		blockRequests2.setIs_active(true);
		blockRequests2.setModified_date(LocalDateTime.now());
		blockRequestDao.blockRequestUpdate(blockRequests2);

	}

}
