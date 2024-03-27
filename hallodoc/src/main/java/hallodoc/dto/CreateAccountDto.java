package hallodoc.dto;

import java.lang.invoke.StringConcatFactory;

public class CreateAccountDto {
	
	
	private String email;
	private String password;
	private String confirmPassword;
	public CreateAccountDto(String email, String password, String confirmPassword) {
		super();
		this.email = email;
		this.password = password;
		this.confirmPassword = confirmPassword;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getConfirmPassword() {
		return confirmPassword;
	}
	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
	public CreateAccountDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	

}
