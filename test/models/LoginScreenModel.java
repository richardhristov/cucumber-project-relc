package models;

import services.LoginService;

public class LoginScreenModel {
	private LoginService loginService;
	
	public LoginScreenModel() {
		
	}
	
	public LoginScreenModel(LoginService loginService) {
		this.loginService = loginService;
	}

	private String email;
	private String password;
	private String message;

	public void navigateToMe() {
		System.out.println("The login page has been navigated to!");
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setPassword(String password) {
		this.password = password;		
	}

	public void clickLoginButton() {
		message = loginService.login(email, password);
	}

	public String getLoginMessage() {
		return message;
	}

}
