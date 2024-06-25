package com.QA.Pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.QA.Base.Baseclass;

public class Loginpage{
	
	WebDriver driver;
	
	public Loginpage(WebDriver rdriver) {
		driver = rdriver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="username")
	private WebElement user_name;
	
	@FindBy(xpath="//*[@name='password']")
	private WebElement pass_word;

	@FindBy(xpath="//*[@id='sessionLocation']/li")
	private List<WebElement> locations;
	
	@FindBy(id="loginButton")
	private WebElement login_button;
	
	public String username(String name) {
		user_name.sendKeys(name);
		return name;
	}
	
	public String pwdMethod(String password) {
		pass_word.sendKeys(password);
		return password;
	}
	
	public void selectopt(String opt) {
		
		for(WebElement wb : locations) {
			
			if(wb.equals(opt)) {
				wb.click();
			}
		}
	}
	public void loginbttnMethod() {
		login_button.click();
	}
	
	public Homepage navigateToHomepage(String name,String password,String opt) {
		user_name.sendKeys(name);
		pass_word.sendKeys(name);
		
        for(WebElement wb : locations) {
			
			if(wb.equals(opt)) {
				wb.click();
			}
		}
        login_button.click();
        
        return new Homepage();
        
	}
}
