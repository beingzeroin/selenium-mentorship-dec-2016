
package in.beingzero.framework.POM.Prudhvi;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {
	
	By userNameLocator=By.id("txtUsername");
	By passwordLocator=By.id("txtPassword");
	By LoginButton=By.id("btnLogin");
	By warningMessageSpan=By.id("spanMessage");
	
	//Test wants to launch browser
	public LoginPage()
	{
		
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
		return getDriver().findElement(LoginButton).isDisplayed();
	}
	
	

	public  DashBoardPage validLogin(String strUserName, String strPassword) {
		
		getDriver().findElement(userNameLocator).sendKeys(strUserName);
		getDriver().findElement(passwordLocator).sendKeys(strPassword);
		getDriver().findElement(LoginButton).click();
		return new DashBoardPage(getDriver());
	}
	
	public  String InvalidLogin(String strUserName, String strPassword) {
		
		getDriver().findElement(userNameLocator).sendKeys(strUserName);
		getDriver().findElement(passwordLocator).sendKeys(strPassword);
		getDriver().findElement(LoginButton).click();
		String strWarning =getDriver().findElement(warningMessageSpan).getText();
		getDriver().close();
		return strWarning;
	}
	
	
	
}

