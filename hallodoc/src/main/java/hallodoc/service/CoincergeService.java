package hallodoc.service;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.management.loading.PrivateClassLoader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import hallodoc.dto.CoincergeDto;
import hallodoc.helper.DateModifier;
import hallodoc.model.Concierge;
import hallodoc.model.Request;
import hallodoc.model.RequestClient;
import hallodoc.repo.CoincergeDao;


@Component
public class CoincergeService {

	@Autowired
	private CoincergeDao coincergeDao;

	public void service(CoincergeDto coincergeInfoDto) {
	
		String fname = coincergeInfoDto.getFirstName();
		String lname = coincergeInfoDto.getLastName();
		String email = coincergeInfoDto.getEmail();
		String mobile = coincergeInfoDto.getMobile();
		String pfname = coincergeInfoDto.getpFirstName();
		String plname = coincergeInfoDto.getPlastName();
		String pemail = coincergeInfoDto.getpEmail();
		String pmobile = coincergeInfoDto.getpMobile();
		String street = coincergeInfoDto.getStreet();
		String city = coincergeInfoDto.getCity();
		String state = coincergeInfoDto.getState();
		String zipcode = coincergeInfoDto.getZipcode();

		LocalDateTime cdate = coincergeInfoDto.getCreated_date();
		String dob = coincergeInfoDto.getDOB();
		
		
		

		Request request = new Request();
		request.setFirstName(fname);
		request.setLastName(lname);
		request.setPhoneNumber(mobile);
		request.setEmail(email);
		request.setCreatedDate(LocalDateTime.now());
		
		

		Concierge concierge = new Concierge();
		
		concierge.setConciergeName(fname+" "+lname);
		concierge.setCreatedDate(cdate);
		concierge.setStreet(street);
		concierge.setCity(city);
		concierge.setState(state);
		concierge.setZipcode(zipcode);
		concierge.setAddress(street + " " + city + " "+ state + " "+ zipcode );
		concierge.setRequestId(request);
		
		

		RequestClient requestClient = new RequestClient();

		requestClient.setFirstName(pfname);
		requestClient.setLastName(plname);
		System.out.println(plname);
		requestClient.setPhoneNumber(pmobile);
		requestClient.setEmail(pemail);

	
		requestClient.setRequestId(request);
		requestClient.setZipcode(zipcode); 
		LocalDate curreDate1 = LocalDate.parse(dob);
		requestClient.setIntDate(new DateModifier().getDay(curreDate1));
		requestClient.setStrMonth(new DateModifier().getMonth(curreDate1));
		requestClient.setIntYear(new DateModifier().getYear(curreDate1));

		coincergeDao.requestdao(request);
		coincergeDao.requestClientdao(requestClient);
		coincergeDao.conciergedao(concierge);

	}

}