package hallodoc.service;

import java.time.LocalDateTime;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import hallodoc.model.Request;
import hallodoc.model.RequestWiseFile;
import hallodoc.model.User;
import hallodoc.repo.RequestDao;
import hallodoc.repo.RequestWiseFileDao;

@Service
public class RequestWiseFileService {
	
	@Autowired
	private RequestWiseFileDao requestWiseFileDao;
	
	@Autowired
	private RequestDao requestDao;

	

public List getRequestFiles(String rId) {

		int requestId = Integer.parseInt(rId);
		
		List<Request> list = requestDao.getRequests(requestId);
		
		 Request r =  list.get(0);
		
		List requestsFileList = requestWiseFileDao.getRequestsWiseFileList(r);
	
		return requestsFileList;

	}



}
