package in.beingzero.framework.POM.Prudhvi;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import in.beingzero.framework.config.Prudhvi.BrowserManager;

public class LoginPage {
	
	By userNameLocator=By.id("txtUsername");
	By passwordLocator=By.id("txtPassword");
	By LoginButton=By.id("btnLogin");
	WebDriver driver;
	//Test wants to launch browser
	public LoginPage()
	{
		System.out.println("Inside Constructor");
		BrowserManager objBM=new BrowserManager();
		driver=objBM.launchBrowser();
	}
	//This page is being returned by another function
	public LoginPage(WebDriver driver)
	{
		
		System.out.println("Inside Constructor");
		this.driver=driver;
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
