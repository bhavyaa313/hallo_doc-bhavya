package hallodoc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hallodoc.model.Request;
import hallodoc.model.RequestClient;
import hallodoc.repo.RequestClientDao;

@Service
public class RequestClientService {
	
	@Autowired
	private RequestClientDao requestClientDao;
	

public List<RequestClient> getRequestClientByReqId(Request rId) {
	
	List<RequestClient> rList = requestClientDao.getRequests(rId);
	return  rList;
}

}
