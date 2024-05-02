package hallodoc.service;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import javax.transaction.Transactional;

import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hallodoc.dto.EditRoleDto;
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
	
	@Transactional
	public void saveRole(String name, int accountType, List<Integer> menu, AspNetUsers id)
	{
		System.out.println(menu+"/////////////////////////////////////////////////////");
		Role role = new Role();
		role.setName(name);
		role.setAccountType(accountType);
		role.setCreatedBy(id);
		role.setCreatedDate(LocalDateTime.now());
		List<Menu> menus = createRoleDao.getMenu(menu);
		role.setMenus(menus);
		
		roleDao.roleSave(role);
		
		
		
	}
	
	public void updateRole(String name, int accountType, List<Integer> menu, AspNetUsers id, int roleId)
	{
	
		List<Role> roles = createRoleDao.getRoleByRoleId(roleId);
		Role role = roles.get(0);
		role.setName(name);
		role.setAccountType(accountType);
		role.setModifiedBy(id);
		role.setModifiedDate(LocalDateTime.now());
		List<Menu> menus = createRoleDao.getMenu(menu);
		role.setMenus(menus);
		
		roleDao.roleUpdate(role);
		
		
		
	}
	
	public List<Role> getRoles()
	{
		List<Role> roles = createRoleDao.getRole();
		return roles;
	}
	
	
	public EditRoleDto getExistingRoles(int roleId)
	{
		List<Role> roles = createRoleDao.getRoleByRoleId(roleId);
		Role role = roles.get(0);
		EditRoleDto editRoleDto = new EditRoleDto();
		int x = role.getAccountType();
		if(x==1)
		{
			editRoleDto.setAccountType("Admin");
		}
		else {
			editRoleDto.setAccountType("Physician");
		}
	
		editRoleDto.setName(role.getName());
		editRoleDto.setSelectedMenuList(role.getMenus());
		System.out.println(role.getMenus() + "5553444");
		
		List<Menu> menus = createRoleDao.getRole(role.getAccountType());
		System.out.println(menus);
		
		editRoleDto.setAllMenuList(menus);
		return editRoleDto;
		
		
		
	}
	
	public void deleteRole(int roleId)

	{
		List<Role> roles = createRoleDao.getRoleByRoleId(roleId);
		Role role = roles.get(0);
		role.setDeleted(true);
		roleDao.roleUpdate(role);
	}
	

}
