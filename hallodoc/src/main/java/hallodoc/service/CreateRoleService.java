package hallodoc.service;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hallodoc.model.AspNetUsers;
import hallodoc.model.Menu;
import hallodoc.model.Role;
import hallodoc.repo.CreateRoleDao;
import hallodoc.repo.RoleDao;
@Service
public class CreateRoleService {
	@Autowired
	private CreateRoleDao createRoleDao;
	
	@Autowired
	private RoleDao roleDao;
	
	public List<Menu> createRole(int accountType)
	{
		List<Menu> menus = createRoleDao.getRole(accountType);
		return menus;
	}
	
	public void saveRole(String name, int accountType, String menu, AspNetUsers id)
	{
		Role role = new Role();
		role.setName(name);
		role.setAccountType(accountType);
		role.setCreatedBy(id);
		role.setCreatedDate(LocalDateTime.now());
		String[] MenuIdString = menu.split(",");
		Integer[] numbers = new Integer[MenuIdString.length];
		List<Integer> MenuId = Arrays.asList(numbers);
		role.set(MenuId);
		roleDao.roleSave(role);
		
		
		
	}
	

}
