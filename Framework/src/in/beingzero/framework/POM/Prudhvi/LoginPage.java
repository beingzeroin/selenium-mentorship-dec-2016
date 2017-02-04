package in.beingzero.framework.POM.Prudhvi;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import in.beingzero.framework.config.Prudhvi.ConfigManager;

public class LoginPage {
	
	By userNameLocator=By.id("txtUsername");
	By passwordLocator=By.id("txtPassword");
	By LoginButton=By.id("btnLogin");
	
	public LoginPage()
	{
		System.out.println("Inside Constructor");
	}
	
	
	public DashBoardPage loginAction(WebDriver driver,String strUserName ,String strPassword )
	{
		
		driver.findElement(userNameLocator).sendKeys(strUserName);
		driver.findElement(passwordLocator).sendKeys(strPassword);
		driver.findElement(LoginButton).click();
		DashBoardPage objDashBoard = null;
		return objDashBoard;	
	}
	
	public void validatePage()
	{
		
	}
	
}
