package hallodoc.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hallodoc.dto.EmailLogsDto;
import hallodoc.dto.PatientHistoryDto;
import hallodoc.helper.DateModifier;
import hallodoc.model.EmailLog;
import hallodoc.model.User;
import hallodoc.repo.EmailLogDao;

@Service
public class emailRecordsService {
	
	@Autowired
	private EmailLogDao emailLogDao;

	public List<EmailLogsDto> emailLogs(String role, String name, String email, String createddate, String sentdate) {
		
		String hqlString1 = "from hallodoc.model.EmailLog E where E.email_log_id !=0";
		
		String hqlMain2 = hqlString1;
		
		if(!(role.equals("empty"))) {
			
			String hql2 = " AND E.role_id=" + role;
			hqlMain2 = hqlMain2.concat(hql2);
		}

		if(name != "") {
			String hql2 = " AND E.recipient LIKE CONCAT('%','" + name + "','%')";
			hqlMain2 = hqlMain2.concat(hql2);
		}
		
		
		

		if (email != "") {

			String hql3 = " AND E.email LIKE CONCAT('%','" + email + "','%')";
			hqlMain2 = hqlMain2.concat(hql3);
		}

	
	

	if (sentdate != "") {
		String hql4 = " AND DATE(E.sentDate)=" + "'" + sentdate + "'";
		hqlMain2 = hqlMain2.concat(hql4);
	}
	
	if (createddate != "") {

		String hql3 = " AND DATE(E.createdDate)=" + "'" + createddate + "'";
		hqlMain2 = hqlMain2.concat(hql3);
	}
		

		
		List<EmailLog> list = emailLogDao.getLogs(hqlMain2);
		
		List<EmailLogsDto> listOfEmailLogsDtos = new ArrayList<EmailLogsDto>();
		
		for (int i = 0; i < list.size(); i++) {
			
			EmailLog emailLog = list.get(i);
			
			EmailLogsDto emailLogsDto = new EmailLogsDto();
			emailLogsDto.setRecipientName(emailLog.getRecipient());
			emailLogsDto.setAction(emailLog.getAction());
			
			if (emailLog.getRole_id()==1) {
				emailLogsDto.setRoleId("Admin");
			}else if (emailLog.getRole_id()==2) {
				emailLogsDto.setRoleId("Physician");
			}else if (emailLog.getRole_id()==3) {
				emailLogsDto.setRoleId("Patient");
			}
			
			String month = new DateModifier().getMonth(emailLog.getCreated_date().toLocalDate());
			Integer day = new DateModifier().getDay(emailLog.getCreated_date().toLocalDate());
			Integer year = new DateModifier().getYear(emailLog.getCreated_date().toLocalDate());
			
			String createdDate = new DateModifier().getDate(day, month, year);
			
			String month1 = new DateModifier().getMonth(emailLog.getSent_date().toLocalDate());
			int day1 = new DateModifier().getDay(emailLog.getSent_date().toLocalDate());
			int year1 = new DateModifier().getYear(emailLog.getSent_date().toLocalDate());
			
			String sentDate = new DateModifier().getDate(day1, month1, year1);
			
			emailLogsDto.setEmailId(emailLog.getEmail_id());
			emailLogsDto.setCreatedDate(createdDate);
			emailLogsDto.setSentDate(sentDate);
			
			
			if (emailLog.isIs_email_sent()) {
				emailLogsDto.setSent("Yes");
			}else {
				emailLogsDto.setSent("No");
			}
			
			emailLogsDto.setSentTries(emailLog.getSent_tries());
			
			if (emailLog.getConfirmation_number()==null) {
				emailLogsDto.setConfirmationNumber("-");
			}else {
				emailLogsDto.setConfirmationNumber(emailLog.getConfirmation_number());
			}
			
			listOfEmailLogsDtos.add(emailLogsDto);
			
		}
		
		return listOfEmailLogsDtos;
		
	}
	


}
