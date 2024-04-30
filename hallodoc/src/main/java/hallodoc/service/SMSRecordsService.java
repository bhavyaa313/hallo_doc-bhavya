package hallodoc.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hallodoc.dto.SMSLogDto;
import hallodoc.helper.DateModifier;
import hallodoc.model.EmailLog;
import hallodoc.model.SMSLog;

import hallodoc.repo.SMSLogDao;

@Service
public class SMSRecordsService {

	@Autowired
	private SMSLogDao SMSLogDao;

	public List<SMSLogDto> SMSLogs(String role, String name, String email, String createddate, String sentdate) {

		String hqlString1 = "from hallodoc.model.SMSLog E where E.sms_log_id !=0";

		String hqlMain2 = hqlString1;

		if(!(role.equals("empty"))) { 

			String hql2 = " AND E.role_id=" + role;
			hqlMain2 = hqlMain2.concat(hql2);
		}

		if (name != "") {
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

		

		List<SMSLog> list = SMSLogDao.getLogs(hqlMain2);

		List<SMSLogDto> listOfSMSLogDtos = new ArrayList<SMSLogDto>();

		for (int i = 0; i < list.size(); i++) {

			SMSLog SMSLog = list.get(i);

			SMSLogDto SMSLogDto = new SMSLogDto();
			SMSLogDto.setRecipientName("-");
			SMSLogDto.setAction(SMSLog.getAction());

			if (SMSLog.getRole_id() == 1) {
				SMSLogDto.setRoleId("Admin");
			} else if (SMSLog.getRole_id() == 2) {
				SMSLogDto.setRoleId("Physician");
			} else if (SMSLog.getRole_id() == 3) {
				SMSLogDto.setRoleId("Patient");
			}

			String month = new DateModifier().getMonth(SMSLog.getCreate_date().toLocalDate());
			Integer day = new DateModifier().getDay(SMSLog.getCreate_date().toLocalDate());
			Integer year = new DateModifier().getYear(SMSLog.getCreate_date().toLocalDate());

			String createdDate = new DateModifier().getDate(day, month, year);

			String month1 = new DateModifier().getMonth(SMSLog.getSent_date().toLocalDate());
			int day1 = new DateModifier().getDay(SMSLog.getSent_date().toLocalDate());
			int year1 = new DateModifier().getYear(SMSLog.getSent_date().toLocalDate());

			String sentDate = new DateModifier().getDate(day1, month1, year1);

			SMSLogDto.setphone(SMSLog.getMobile_number());
			SMSLogDto.setCreatedDate(createdDate);
			SMSLogDto.setSentDate(sentDate);

			if (SMSLog.isIs_sms_sent()) {
				SMSLogDto.setSent("Yes");
			} else {
				SMSLogDto.setSent("No");
			}

			SMSLogDto.setSentTries(SMSLog.getSent_tries());

			if (SMSLog.getConfirmation_number() == null) {
				SMSLogDto.setConfirmationNumber("-");
			} else {
				SMSLogDto.setConfirmationNumber(SMSLog.getConfirmation_number());
			}

			listOfSMSLogDtos.add(SMSLogDto);

		}

		return listOfSMSLogDtos;

	}

}
