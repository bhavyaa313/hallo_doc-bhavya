package hallodoc.service;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.management.loading.PrivateClassLoader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import hallodoc.dto.FamilyInfoDto;
import hallodoc.dto.PatientInfoDto;
import hallodoc.helper.DateModifier;
import hallodoc.model.Request;
import hallodoc.model.RequestClient;
import hallodoc.repo.FamilyInfoDao;

@Component
public class FamilyInfoService {

	@Autowired
	private FamilyInfoDao familyInfoDao;

	public void service(FamilyInfoDto familyInfoDto) {
		String sympton = familyInfoDto.getSympton();
		String fname = familyInfoDto.getFirstName();
		String lname = familyInfoDto.getLastName();
		String email = familyInfoDto.getEmail();
		String mobile = familyInfoDto.getMobile();
		String pfname = familyInfoDto.getpFirstName();
		String plname = familyInfoDto.getPlastName();
		String pemail = familyInfoDto.getpEmail();
		String pmobile = familyInfoDto.getpMobile();
		String street = familyInfoDto.getStreet();
		String city = familyInfoDto.getCity();
		String state = familyInfoDto.getState();
		String zipcode = familyInfoDto.getZipcode();

		LocalDateTime cdate = familyInfoDto.getCreated_date();
		String dob = familyInfoDto.getDOB();

		Request request = new Request();
		request.setFirstName(fname);
		request.setLastName(lname);
		request.setPhoneNumber(mobile);
		request.setEmail(email);
		request.setCreatedDate(LocalDateTime.now());

		RequestClient requestClient = new RequestClient();

		requestClient.setFirstName(pfname);
		requestClient.setLastName(plname);
		System.out.println(plname);
		requestClient.setPhoneNumber(pmobile);
		requestClient.setEmail(pemail);

		requestClient.setStreet(street);
		requestClient.setCity(city);
		requestClient.setState(state);
		requestClient.setRequestId(request);
		requestClient.setZipcode(zipcode);
		LocalDate curreDate1 = LocalDate.parse(dob);
		requestClient.setIntDate(new DateModifier().getDay(curreDate1));
		requestClient.setStrMonth(new DateModifier().getMonth(curreDate1));
		requestClient.setIntYear(new DateModifier().getYear(curreDate1));

		familyInfoDao.requestdao(request);
		familyInfoDao.requestClientdao(requestClient);

	}

}
