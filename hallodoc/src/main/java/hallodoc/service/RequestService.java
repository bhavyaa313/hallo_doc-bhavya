package hallodoc.service;

import java.security.KeyStore.PrivateKeyEntry;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hallodoc.repo.RequestDao;

@Service
public class RequestService {
	
	@Autowired
	private RequestDao requestDao;
	
public List getRequest(int uId) {

		
		List requestsList = requestDao.getRequests(uId);
		System.out.println(requestsList);
		return requestsList;

	}

}
