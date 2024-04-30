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
import hallodoc.model.Request;
import hallodoc.model.RequestClient;
import hallodoc.repo.AdminDashboardDao;
import hallodoc.repo.RequestClientDao;
import hallodoc.repo.RequestDao;
import net.bytebuddy.dynamic.DynamicType.Builder.InnerTypeDefinition;
import net.bytebuddy.dynamic.scaffold.MethodRegistry.Handler.ForAbstractMethod;

@Service
public class AdminDashboardService {
	
	@Autowired
	private RequestDao requestDao;

	@Autowired
	private RequestClientDao requestClientDao;
	
	
	@Autowired
	private AdminDashboardDao adminDashboardDao;
	

	
	public List<AdminDashboardDto> service(String status, String role, String searchText, String region) {
		
		List<AdminDashboardDto> listAdminDashboardDtos = new ArrayList<AdminDashboardDto>();
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

		String sqlString = "from hallodoc.model.Request r where (r.status="+mainStatus1+" OR r.status="+mainStatus2+" OR r.status="+mainStatus3+")";
		String sqlfinalString = sqlString;
		if (!role.equals("undefined")) {
			String sqlString2 = "AND requestTypeId=" + roleid;
			sqlfinalString = sqlString + sqlString2;
		}

		if (!searchText.equals("undefined") && region.equals("0")) {
//			String subString = searchText.substring(0, 4);
			String sqlString1 = " AND (upper(CONCAT(r.firstName,r.lastName)) LIKE CONCAT('%','"+searchText+"','%') OR upper(CONCAT(r.requestClient.firstName,r.requestClient.lastName)) LIKE CONCAT('%','"+searchText+"','%') )";

			sqlfinalString = sqlString + sqlString1;
		}

		if (searchText.equals("undefined") && !region.equals("0"))

		{

			Integer regionId = Integer.parseInt(region);
			String sqlString2 = " AND r.requestClient.regionId=" + regionId;
			sqlfinalString = sqlString + sqlString2;
		}

		 if (!searchText.equals("undefined") && !region.equals("0"))

		{

			Integer regionId = Integer.parseInt(region);
			String sqlString1 = " AND (upper(CONCAT(r.firstName,r.lastName)) LIKE CONCAT('%','" + searchText
					+ "','%') OR upper(CONCAT(r.requestClient.firstName,r.requestClient.lastName)) LIKE CONCAT('%','"
					+ searchText + "','%') )";
			String sqlString2 = "INNER JOIN RequestClient t2 ON regionId=" + regionId;

			String sqlString3 = sqlString1 + sqlString2;

			sqlfinalString = sqlString2 + sqlString3;
		}
		
		System.out.println(sqlfinalString);
		
		List<Request> requests = requestDao.getRequestsByRequestType(sqlfinalString);
		System.out.println("Request" + " " + requests);

	

		
		
		for(int i=0; i<requests.size(); i++)
			{
			
			AdminDashboardDto adminDashboardDto = new AdminDashboardDto();
			
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
			
			
			
			adminDashboardDto.setRequestId(request.getRequestId());
			adminDashboardDto.setName(requestClient.getFirstName()+ " " + requestClient.getLastName()); 
			adminDashboardDto.setPhone(requestClient.getPhoneNumber());
			adminDashboardDto.setRegion(requestClient.getState());
			adminDashboardDto.setRequestor(request.getFirstName() + " " + request.getLastName());
			adminDashboardDto.setAddress(requestClient.getAddress());
			adminDashboardDto.setNotes(requestClient.getNotes());
			adminDashboardDto.setRequestedDate(request.getCreatedDate().toString());
			adminDashboardDto.setDob(dobString);
			adminDashboardDto.setStatus(request.getStatus());
			adminDashboardDto.setRequestTypeId(request.getRequestTypeId());
			adminDashboardDto.setEmail(requestClient.getEmail());
			
			listAdminDashboardDtos.add(adminDashboardDto);
			
			
		}
		
		
		
		
		
		return listAdminDashboardDtos;
		
		
		
		
	}
	
	public Integer[] count()
	
	{
		
		List<Request> requestList = adminDashboardDao.getRequests();
		
		int newCount = 0;
		int pendingCount = 0;
		int activeCount = 0;
		int concludeCount = 0;
		int tocloseCount = 0;
		int unpaidCount = 0;
		
		
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
			
			else if (xInteger==3 || xInteger==7 || xInteger==8) {
				tocloseCount+=1;
			}
			else if (xInteger==9) {
				unpaidCount+=1;
				
			}
		}
		
		Integer[] countInteger = {newCount , pendingCount , activeCount, concludeCount, tocloseCount, unpaidCount};
		System.out.println("new" + countInteger[0]);
		System.out.println("pending" +countInteger[1]);
		System.out.println("Active" +countInteger[2]);
		System.out.println("conclude" +countInteger[3]);
		System.out.println("toclose" +countInteger[4]);
		System.out.println("unpaid" +countInteger[5]);
		
		return countInteger;
		
	}
	

}
