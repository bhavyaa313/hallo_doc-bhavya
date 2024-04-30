package hallodoc.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "menu")
public class Menu {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int menu_id;
	private String name;
	private int account_type;
	private int sort_order;
	public int getMenu_id() {
		return menu_id;
	}
	public void setMenu_id(int menu_id) {
		this.menu_id = menu_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAccount_type() {
		return account_type;
	}
	public void setAccount_type(int account_type) {
		this.account_type = account_type;
	}
	public int getSort_order() {
		return sort_order;
	}
	public void setSort_order(int sort_order) {
		this.sort_order = sort_order;
	}
	@Override
	public String toString() {
		return "Menu [menu_id=" + menu_id + ", name=" + name + ", account_type=" + account_type + ", sort_order="
				+ sort_order + "]";
	}
	public Menu(int menu_id, String name, int account_type, int sort_order) {
		super();
		this.menu_id = menu_id;
		this.name = name;
		this.account_type = account_type;
		this.sort_order = sort_order;
	}
	public Menu() {
		super();
		// TODO Auto-generated constructor stub
	}
	

	
}
