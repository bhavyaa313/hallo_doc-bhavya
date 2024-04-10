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
	

	
	public List<AdminDashboardDto> service() {
		
		List<AdminDashboardDto> listAdminDashboardDtos = new ArrayList<AdminDashboardDto>();
		
		List<Request> requestList = adminDashboardDao.getRequests();
		for(int i=0; i<requestList.size(); i++)
			{
			
			AdminDashboardDto adminDashboardDto = new AdminDashboardDto();
			
			Request request = requestList.get(i);
			
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
