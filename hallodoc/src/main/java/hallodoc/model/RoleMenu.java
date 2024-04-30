package hallodoc.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "role_menu")
public class RoleMenu {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int role_menu_id;
	private int role_id;
	private int menu_id;
	public RoleMenu() {
		super();
		// TODO Auto-generated constructor stub
	}
	public RoleMenu(int role_menu_id, int role_id, int menu_id) {
		super();
		this.role_menu_id = role_menu_id;
		this.role_id = role_id;
		this.menu_id = menu_id;
	}
	public int getRole_menu_id() {
		return role_menu_id;
	}
	public void setRole_menu_id(int role_menu_id) {
		this.role_menu_id = role_menu_id;
	}
	public int getRole_id() {
		return role_id;
	}
	public void setRole_id(int role_id) {
		this.role_id = role_id;
	}
	public int getMenu_id() {
		return menu_id;
	}
	public void setMenu_id(int menu_id) {
		this.menu_id = menu_id;
	}
	@Override
	public String toString() {
		return "RoleMenu [role_menu_id=" + role_menu_id + ", role_id=" + role_id + ", menu_id=" + menu_id + "]";
	}
	
	
	
}
