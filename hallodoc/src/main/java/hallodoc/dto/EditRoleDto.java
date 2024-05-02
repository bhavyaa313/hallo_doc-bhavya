package hallodoc.dto;

import java.util.List;

import hallodoc.model.Menu;

public class EditRoleDto {
	private int roleId;
	private String name;
	private String accountType;
	private List<Menu> allMenuList;
	private List<Menu> selectedMenuList;
	public int getRoleId() {
		return roleId;
	}
	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAccountType() {
		return accountType;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	public List<Menu> getAllMenuList() {
		return allMenuList;
	}
	public void setAllMenuList(List<Menu> allMenuList) {
		this.allMenuList = allMenuList;
	}
	public List<Menu> getSelectedMenuList() {
		return selectedMenuList;
	}
	public void setSelectedMenuList(List<Menu> selectedMenuList) {
		this.selectedMenuList = selectedMenuList;
	}
	public EditRoleDto(int roleId, String name, String accountType, List<Menu> allMenuList,
			List<Menu> selectedMenuList) {
		super();
		this.roleId = roleId;
		this.name = name;
		this.accountType = accountType;
		this.allMenuList = allMenuList;
		this.selectedMenuList = selectedMenuList;
	}
	public EditRoleDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	
	
	

}
