package hallodoc.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hallodoc.dto.EmailLogsDto;
import hallodoc.dto.UserAccessDto;
import hallodoc.model.Request;
import hallodoc.model.User;
import hallodoc.repo.RequestDao;
import hallodoc.repo.UserDao;

@Service
public class UserAccessService {
	
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private RequestDao requestDao;
	
	public List<UserAccessDto> getUserData()
	{
		List<User> users = userDao.getUserstwithRoleid();
		
		
		List<UserAccessDto> userAccessDtos = new ArrayList<UserAccessDto>();
		
		for(int i = 0; i < users.size(); i++)
		{
			User user = users.get(i);
			
			UserAccessDto userAccessDto = new UserAccessDto();
			userAccessDto.setName(user.getFirstName() + " " + user.getLastName());
			if(user.getRoleId()==1)
			{
			userAccessDto.setAccounttype("Admin");
			}
			else if(user.getRoleId()==2)
			{
			userAccessDto.setAccounttype("Physician");
			}
			else if(user.getRoleId()==3)
			{
			userAccessDto.setAccounttype("Patient");
			}
			
			userAccessDto.setCity(user.getCity());
			userAccessDto.setPhone(user.getMobile());
			userAccessDto.setStatus("active");
			userAccessDto.setUserId(user.getUserID());
			
			List<Request> requests = requestDao.getRequests(user);
			if(requests.size()==0)
			{
			userAccessDto.setOpenRequests(0);
			}
			else {
				{
					 Long count =  requestDao.countRequests(user); 
					userAccessDto.setOpenRequests(count);
				}
			}
			userAccessDtos.add(userAccessDto);
		}
		
		return userAccessDtos;
	}
	

}
