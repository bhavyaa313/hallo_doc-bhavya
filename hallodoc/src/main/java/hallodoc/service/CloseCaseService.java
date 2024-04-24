package hallodoc.service;

import java.time.LocalDate;
import java.util.List;

import javax.management.loading.PrivateClassLoader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hallodoc.dto.CloseCaseDto;
import hallodoc.dto.ViewCaseDto;
import hallodoc.helper.DateModifier;
import hallodoc.model.Request;
import hallodoc.model.RequestClient;
import hallodoc.repo.RequestClientDao;

@Service
public class CloseCaseService {
	
	@Autowired
	private RequestClientService requestClientService;
	
	@Autowired
	private RequestService requestService;
	
	@Autowired
	private RequestClientDao requestClientDao;
	
	
	public void service(CloseCaseDto closeCaseDto, Request rId ) {
		
		String fnameString = closeCaseDto.getFirstName();
		System.out.println("-------------------------------------------------------------------------------");
		System.out.println("-------------------------------------------------------------------------------");
		System.out.println("-------------------------------------------------------------------------------");
		System.out.println("-------------------------------------------------------------------------------");
		System.out.println(fnameString);
		String lnameString = closeCaseDto.getLastName();
		String dobString = closeCaseDto.getDob();
		String phoneString = closeCaseDto.getPhone();
		String noteString = closeCaseDto.getNotes();
		
		
		
			
		List<RequestClient> getClients = requestClientService.getRequestClientByReqId(rId);
		RequestClient requestClient = getClients.get(0);
		
		requestClient.setFirstName(fnameString);
		
		System.out.println(requestClient.getFirstName());
		requestClient.setLastName(lnameString);
		requestClient.setPhoneNumber(phoneString);
		requestClient.setNotes(noteString);
		if (dobString == null || dobString.isEmpty()) {

		} else {
			LocalDate currentDate = LocalDate.parse(dobString);
			requestClient.setIntDate(new DateModifier().getDay(currentDate));
			requestClient.setStrMonth(new DateModifier().getMonth(currentDate));
			requestClient.setIntYear(new DateModifier().getYear(currentDate));
		}
		
		System.out.println("-------------------------------------------------------------------------------");
		System.out.println("-------------------------------------------------------------------------------");
		System.out.println("-------------------------------------------------------------------------------");
		requestClientDao.requestClientUpdate(requestClient);
		
			
			
			
		
		
		
	}

}

