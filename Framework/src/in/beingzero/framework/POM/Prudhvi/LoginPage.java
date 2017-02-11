package in.beingzero.framework.POM.Prudhvi;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import in.beingzero.framework.config.Prudhvi.BrowserManager;
import in.beingzero.framework.config.Prudhvi.ConfigManager;

public class LoginPage extends BasePage {
	
	By userNameLocator=By.id("txtUsername");
	By passwordLocator=By.id("txtPassword");
	By LoginButton=By.id("btnLogin");
	
	//Test wants to launch browser
	public LoginPage()
	{
		//System.out.println("Inside Constructor");
		// Inheritance by default calls constructor of superclass so if we comment it out then also it will work. 
		super();
		
	}
	//This page is being returned by another function
	public LoginPage(WebDriver WD)
	{
		super(WD);
		System.out.println("Inside Constructor");
		//driver=WD;
		
	}
	
	
	public boolean validatePage()
	{
		//boolean isPageValidOne=false;
		//isPageValidOne=driver.findElement(LoginButton).isDisplayed();
		return driver.findElement(LoginButton).isDisplayed();
	}
	
	

	public  DashBoardPage validLogin(String strUserName, String strPassword) {
		
		driver.findElement(userNameLocator).sendKeys(strUserName);
		driver.findElement(passwordLocator).sendKeys(strPassword);
		driver.findElement(LoginButton).click();
		return new DashBoardPage(driver);
	}
	
}
