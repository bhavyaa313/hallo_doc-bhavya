package hallodoc.helper;

import java.util.Iterator;
import java.util.List;

import javax.management.loading.PrivateClassLoader;

import org.hibernate.dialect.FirebirdDialect;
import org.hibernate.query.criteria.internal.expression.function.AggregationFunction.COUNT;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hallodoc.enums.RegionEnum;
import hallodoc.model.Request;
import hallodoc.model.RequestClient;
import hallodoc.service.RequestClientService;
import hallodoc.service.RequestService;

@Service
public class ConfirmationNumber {
	
	@Autowired
	private RequestService requestService;
	
    private RequestClientService requestClientService;
    
    private RegionEnum regionEnum;
	
	
	private String confirmationNumberString(int rId)
	{
		
		List<Request> requests =  requestService.getRequestByReqId(rId);
		Request request = requests.get(0);
		String confirmString = request.getConfirmationNumber();
		List<RequestClient> requestClients = requestClientService.getRequestClientByReqId(request);
		RequestClient requestClient = requestClients.get(0);
		String createdString =  request.getCreatedDate().toString().substring(0, 4);
		String lnameString = requestClient.getLastName().substring(0, 2);
		String fnameString = requestClient.getFirstName().substring(0, 2);
		String stateString = requestClient.getState();
		String abbrString=  regionEnum.valueOf(stateString).getAbbr();
		
		int count =0;
		for (int i = 0; i < requests.size(); i++) {
			Request request1 = requests.get(i);
			String cdateString = request1.getCreatedDate().toString().substring(0, 4);
			if(cdateString==createdString)
			{
				count+=1;
			}
			
			
		}
		
		String confirmString2 = abbrString + createdString + fnameString + lnameString + count;
		
		return confirmString2;

		
	}
	
	

}
