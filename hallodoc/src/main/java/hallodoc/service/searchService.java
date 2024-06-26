package hallodoc.service;

import java.io.ObjectInputFilter.Status;
import java.sql.PreparedStatement;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hallodoc.model.Request;
import hallodoc.repo.RequestDao;

@Service
public class searchService {

	@Autowired
	private RequestDao requestDao;

	public void search(String status, String role, String searchText, String region)
	{
		int mainStatus1 = 0;
		int mainStatus2 = 0;
		int mainStatus3 = 0;

		if (status.equals("blue")) {
			mainStatus1 = 1;
		}

		else if (status.equals("sky"))

		{
			mainStatus1 = 1;
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

		else if (!searchText.equals("undefined") && region.equals("0")) {
//			String subString = searchText.substring(0, 4);
			String sqlString1 = " AND (upper(CONCAT(r.firstName,r.lastName)) LIKE CONCAT('%','"+searchText+"','%') OR upper(CONCAT(r.requestClient.firstName,r.requestClient.lastName)) LIKE CONCAT('%','"+searchText+"','%') )";

			sqlfinalString = sqlString + sqlString1;
		}

		else if (searchText.equals("undefined") && !region.equals("0"))

		{

			Integer regionId = Integer.parseInt(region);
			String sqlString2 = " AND r.requestClient.regionId=" + regionId;
			sqlfinalString = sqlString + sqlString2;
		}

		else if (!searchText.equals("undefined") && !region.equals("0"))

		{

			Integer regionId = Integer.parseInt(region);
			String sqlString1 = " AND (upper(CONCAT(r.firstName,r.lastName)) LIKE CONCAT('%','" + searchText
					+ "','%') OR upper(CONCAT(r.requestClient.firstName,r.requestClient.lastName)) LIKE CONCAT('%','"
					+ searchText + "','%') )";
			String sqlString2 = "INNER JOIN RequestClient t2 ON regionId=" + regionId;

			String sqlString3 = sqlString1 + sqlString2;

			sqlfinalString = sqlString2 + sqlString3;
		}
		System.out.println("_____________________________________________________");
		System.out.println(sqlfinalString);
		System.out.println("_____________________________________________________");
		List<Request> requests = requestDao.getRequestsByRequestType(sqlfinalString);
		System.out.println("Request" + " " + requests);

	}

}
