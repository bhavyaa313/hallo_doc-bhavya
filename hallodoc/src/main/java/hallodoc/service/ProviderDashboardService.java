package hallodoc.service;

import java.util.ArrayList;
import java.util.List;

import javax.management.loading.PrivateClassLoader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.ZeroCopyHttpOutputMessage;
import org.springframework.stereotype.Service;

import hallodoc.dto.AdminDashboardDto;
import hallodoc.dto.PatientInfoDto;
import hallodoc.dto.ProviderDashboardDto;
import hallodoc.model.Request;
import hallodoc.model.RequestClient;
import hallodoc.repo.AdminDashboardDao;
import hallodoc.repo.RequestClientDao;
import hallodoc.repo.RequestDao;
import net.bytebuddy.dynamic.DynamicType.Builder.InnerTypeDefinition;
import net.bytebuddy.dynamic.scaffold.MethodRegistry.Handler.ForAbstractMethod;

@Service
public class ProviderDashboardService {
	
	@Autowired
	private RequestDao requestDao;

	@Autowired
	private RequestClientDao requestClientDao;
	
	
	@Autowired
	private AdminDashboardDao adminDashboardDao;
	

	
	public List<ProviderDashboardDto> service(String status, String role,String searchText, int phyID) {
		
		List<ProviderDashboardDto> lisProviderDashboardDtos = new ArrayList<ProviderDashboardDto>();
		int mainStatus1 = 0;
		int mainStatus2 = 0;
		int mainStatus3 = 0;

		if (status.equals("blue")) {
			mainStatus1 = 1;
		}

		else if (status.equals("sky"))

		{
			mainStatus1 = 2;
		}

		else if (status.equals("green"))

		{
			mainStatus1 = 4;
			mainStatus2 = 5;
		} else if (status.equals("pink"))

		{
			mainStatus1 = 6;

		} else if (status.equals("light-blue"))

		{
			mainStatus1 = 3;
			mainStatus2 = 7;
			mainStatus3 = 8;
		} else if (status.equals("purple"))

		{
			mainStatus1 = 9;

		}

		int roleid = 0;
		switch (role) {
		case "Patient":
			roleid = 2;

			break;
		case "Business":
			roleid = 1;

			break;

		case "Family":
			roleid = 3;

			break;

		case "Concierge":
			roleid = 4;

			break;

		default:
			break;
		}

		String sqlString = "from hallodoc.model.Request r where (r.status="+mainStatus1+" OR r.status="+mainStatus2+" OR r.status="+mainStatus3+") AND r.isDeleted=0 AND r.physicianId.physicianId="+phyID;
		String sqlfinalString = sqlString;
		if (!role.equals("undefined")) {
			String sqlString2 = "AND requestTypeId=" + roleid;
			sqlfinalString = sqlString + sqlString2;
		}

		if (!searchText.equals("undefined")) {

			String sqlString1 = " AND (upper(CONCAT(r.firstName,r.lastName)) LIKE CONCAT('%','"+searchText+"','%') OR upper(CONCAT(r.requestClient.firstName,r.requestClient.lastName)) LIKE CONCAT('%','"+searchText+"','%') )";

			sqlfinalString = sqlString + sqlString1;
		}

		

			
		
		
		List<Request> requests = requestDao.getRequestsByRequestType(sqlfinalString);
		System.out.println("Request" + " " + requests);

	

		
		
		for(int i=0; i<requests.size(); i++)
			{
			
			ProviderDashboardDto providerDashboardDto = new ProviderDashboardDto();
			
			Request request = requests.get(i);
			
//			Integer idInteger =  request.getRequestId();
			
			List<RequestClient> requestClients = adminDashboardDao.getRequestClients(request);
			
			RequestClient requestClient = request.getRequestClient();
			
			System.out.println("helooo" + i);
			
			
			int d = requestClient.getIntDate();
			String date = String.valueOf(d);
			int y = requestClient.getIntYear();
			String year = String.valueOf(y);
			
			String dobString = date + requestClient.getStrMonth() +year;
			
			if (request.getStatus()==5) {
				providerDashboardDto.setHousecall("Housecall");
				
			}
			
		providerDashboardDto.setRequestId(request.getRequestId());
		providerDashboardDto.setName(requestClient.getFirstName()+ " " + requestClient.getLastName()); 
		providerDashboardDto.setPhone(requestClient.getPhoneNumber());
		providerDashboardDto.setRegion(requestClient.getState());
		providerDashboardDto.setRequestor(request.getFirstName() + " " + request.getLastName());
		providerDashboardDto.setAddress(requestClient.getStreet()+ " " + requestClient.getCity() + " " + requestClient.getState());
		providerDashboardDto.setNotes(requestClient.getNotes());
		providerDashboardDto.setRequestedDate(request.getCreatedDate().toString());
		providerDashboardDto.setDob(dobString);
		providerDashboardDto.setStatus(request.getStatus());
		providerDashboardDto.setRequestTypeId(request.getRequestTypeId());
		providerDashboardDto.setEmail(requestClient.getEmail());
			
			lisProviderDashboardDtos.add(providerDashboardDto);
			
			
		}
		
		
		
		
		
		return lisProviderDashboardDtos;
		
		
		
		
	}
	
	public Integer[] count(int phyID)
	
	{
		
		List<Request> requestList = adminDashboardDao.getRequestsByphyID(phyID);
		
		int newCount = 0;
		int pendingCount = 0;
		int activeCount = 0;
		int concludeCount = 0;
	
		
		for(int i=0; i<requestList.size(); i++)
		{
			
			
			Request request1 = requestList.get(i);
			Integer xInteger = request1.getStatus();
			if(xInteger==1)
			{
				newCount+=1;
			}
			else if (xInteger==2) {
				pendingCount+=1;
				
			}
			else if (xInteger==4 || xInteger==5) {
				activeCount+=1;
			} 
			
			else if (xInteger==6) {
				concludeCount+=1;
			}
			
		
		}
		
		Integer[] countInteger = {newCount , pendingCount , activeCount, concludeCount};
		System.out.println("new" + countInteger[0]);
		System.out.println("pending" +countInteger[1]);
		System.out.println("Active" +countInteger[2]);
		System.out.println("conclude" +countInteger[3]);
		
		return countInteger;
		
	}
	

}
