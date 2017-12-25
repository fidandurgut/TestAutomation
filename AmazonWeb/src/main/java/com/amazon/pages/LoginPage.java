package com.amazon.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.amazon.base.page.BasePage;

public class LoginPage extends BasePage{

	public LoginPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	
	 
	 private final By input_Email = By.id("ap_email");
	
	 private final By input_Password = By.id("ap_password");
	 
	 private final By btn_SubmitLogin= By.id("signInSubmit");
	 
	 public void enterEmail(String email){
		 wait.until(ExpectedConditions.visibilityOfElementLocated(input_Email));
		 sendKeys(input_Email, email);
	 }
	 
	 public void enterPass(String password){
		 wait.until(ExpectedConditions.visibilityOfElementLocated(input_Password));
		 sendKeys(input_Password, password);
	 }
	 
	 public void clickSignIn(){
		 wait.until(ExpectedConditions.visibilityOfElementLocated(btn_SubmitLogin));
		 clickElement(btn_SubmitLogin);
		 
	 }
	 
	 public void login(String email, String password){
		 enterEmail(email);
		 enterPass(password);
		 clickSignIn();
	 }
}
