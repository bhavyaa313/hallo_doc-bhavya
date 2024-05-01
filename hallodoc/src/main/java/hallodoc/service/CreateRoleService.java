package hallodoc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hallodoc.model.Menu;
import hallodoc.repo.CreateRoleDao;
@Service
public class CreateRoleService {
	@Autowired
	private CreateRoleDao createRoleDao;
	
	public List<Menu> createRole(int accountType)
	{
		List<Menu> menus = createRoleDao.getRole(accountType);
		return menus;
	}
	

}
