package hallodoc.service;

import java.security.KeyStore.PrivateKeyEntry;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hallodoc.model.Request;
import hallodoc.model.User;
import hallodoc.repo.RequestDao;

@Service
public class RequestService {
	
	@Autowired
	private RequestDao requestDao;
	
public List getRequest(User uId) {

		
		List requestsList = requestDao.getRequests(uId);
		System.out.println(requestsList);
		return requestsList;

	}

public List<Request> getRequestByReqId(int rId) {
	
	List<Request> rList = requestDao.getRequests(rId);
	return  rList;
}

public List<Request> getRequests() {
	
	List<Request> rList = requestDao.getRequests();
	return  rList;
}




}
