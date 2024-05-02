package hallodoc.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "role_menu")
public class RoleMenu {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "role_menu_id")
	private int roleMenuId;

	@ManyToOne
	@JoinColumn(name = "role_id")
	private Role roleId;

	@ManyToOne
	@JoinColumn(name = "menu_id")
	private Menu menuId;

	public int getRoleMenuId() {
		return roleMenuId;
	}

	public void setRoleMenuId(int roleMenuId) {
		this.roleMenuId = roleMenuId;
	}

	public Role getRoleId() {
		return roleId;
	}

	public void setRoleId(Role roleId) {
		this.roleId = roleId;
	}

	public Menu getMenuId() {
		return menuId;
	}

	public void setMenuId(Menu menuId) {
		this.menuId = menuId;
	}

	public RoleMenu() {
		super();
	}

	public RoleMenu(int roleMenuId, Role roleId, Menu menuId) {
		super();
		this.roleMenuId = roleMenuId;
		this.roleId = roleId;
		this.menuId = menuId;
	}

	@Override
	public String toString() {
		return "RoleMenu [roleMenuId=" + roleMenuId + ", roleId=" + roleId + ", menuId=" + menuId + "]";
	}

}
