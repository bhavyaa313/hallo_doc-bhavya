package hallodoc.model;

public class DummyForgot {

	
	private String password;
	private String confirm_password;
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getConfirm_password() {
		return confirm_password;
	}
	public void setConfirm_password(String confirm_password) {
		this.confirm_password = confirm_password;
	}
	@Override
	public String toString() {
		return "DummyForgot [password=" + password + ", confirm_password=" + confirm_password + "]";
	}
	public DummyForgot(String password, String confirm_password) {
		super();
		this.password = password;
		this.confirm_password = confirm_password;
	}
	public DummyForgot() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
}
