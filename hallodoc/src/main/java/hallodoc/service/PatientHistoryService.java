package hallodoc.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hallodoc.dto.PatientHistoryDto;
import hallodoc.model.User;
import hallodoc.repo.UserDao;

@Service
public class PatientHistoryService {

	@Autowired
	private UserDao userDao;

	public List<PatientHistoryDto> PatientHistory(String fname, String lname, String email, String phone) {

		String hqlString1 = "from hallodoc.model.User U where U.roleId=3";
		String hqlMain2 = hqlString1;

		if (fname != "") {
			String hql2 = " AND U.firstName LIKE CONCAT('%','" + fname + "','%')";
			hqlMain2 = hqlMain2.concat(hql2);
		}

		if (lname != "") {
			String hql2 = " AND U.lastName LIKE CONCAT('%','" + lname + "','%')";
			hqlMain2 = hqlMain2.concat(hql2);
		}

		if (email != "") {

			String hql3 = " AND U.email LIKE CONCAT('%','" + email + "','%')";
			hqlMain2 = hqlMain2.concat(hql3);
		}

		if (phone != "") {
			String hql4 = " AND U.mobile=" + "'" + phone + "'";
			hqlMain2 = hqlMain2.concat(hql4);
		}

		List<User> list = userDao.getUserByReqType(hqlMain2);

		List<PatientHistoryDto> patientHistoryDtos = new ArrayList<>();

		for (int i = 0; i < list.size(); i++) {

			User user = list.get(i);

			PatientHistoryDto patientHistoryDto = new PatientHistoryDto();
			patientHistoryDto.setuId(user.getUserID());
			patientHistoryDto.setFname(user.getFirstName());
			patientHistoryDto.setLname(user.getLastName());
			patientHistoryDto.setEmailString(user.getEmail());
			patientHistoryDto.setPhoneString(user.getMobile());
			patientHistoryDto.setAddress(user.getStreet() + ", " + user.getCity() + ", " + user.getState());

			patientHistoryDtos.add(patientHistoryDto);

		}

		return patientHistoryDtos;

	}

}
