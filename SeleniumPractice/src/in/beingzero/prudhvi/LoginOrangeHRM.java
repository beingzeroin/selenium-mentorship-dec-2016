package in.beingzero.prudhvi;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class LoginOrangeHRM {
	
	String strURL="http://opensource.demo.orangehrmlive.com";
	String strUserName="Admin";
	String strPwd="admin";
	String strWelcomeMsg="Welcome "+strUserName;
	String strActualMsg="";
	FirefoxDriver fd=new FirefoxDriver();
	
	
	//fd.get(strURL); --What is the reason for error at this statement?
	
	
	@Test
	public void validUservalidPassword()
	{
		System.setProperty("webdriver.gecko.driver","E:\\SeleniumProject\\geckodriver.exe");
		fd.get(strURL);
		fd.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		fd.findElementById("txtUsername").sendKeys(strUserName);
		fd.findElementById("txtPassword").sendKeys(strPwd);
		fd.findElementById("btnLogin").click();
		strActualMsg=fd.findElementById("welcome").getText();
		
		if (strActualMsg.equalsIgnoreCase(strActualMsg))
		{
			System.out.println("Login with valid username and password is successfull");
		}
			
		else
		{
			System.out.println("Login with valid username and password is Failed");
		}
		fd.close();		
	}
	@Test
	public void InvalidUserValidPassword()
	{
		FirefoxDriver fd=new FirefoxDriver();
		fd.get(strURL);
		fd.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		fd.findElementById("txtUsername").sendKeys("adminHello");
		fd.findElementById("txtPassword").sendKeys(strPwd);
		fd.findElementById("btnLogin").click();
		strActualMsg=fd.findElementById("spanMessage").getText();
		
		if (strActualMsg.equalsIgnoreCase("Invalid credentials"))
		{
			System.out.println("Login with invalid username and valid password is Passed");
		}
			
		else
		{
			System.out.println("Login with invalid username and valid password is Failed");
		}
			
		fd.close();
		}
	@Test
	public void blankUservalidPassword()
	{
		FirefoxDriver fd=new FirefoxDriver();
		fd.get(strURL);
		fd.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		fd.findElementById("txtUsername").clear();
		fd.findElementById("txtPassword").sendKeys(strPwd);
		fd.findElementById("btnLogin").click();
		strActualMsg=fd.findElementById("spanMessage").getText();
		
		if (strActualMsg.equalsIgnoreCase("UserName cannot be empty"))
		{
			System.out.println("Login with blank username and valid password is Passed");
		}
			
		else
		{
			System.out.println("Login with blank username and valid password is Failed");
		}
			
		fd.close();
	}
	@Test
	public void validUserblankPassword()
	{
		FirefoxDriver fd=new FirefoxDriver();
		fd.get(strURL);
		fd.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		fd.findElementById("txtUsername").sendKeys(strUserName);
		fd.findElementById("txtPassword").clear();
		fd.findElementById("btnLogin").click();
		strActualMsg=fd.findElementById("spanMessage").getText();
		
		if (strActualMsg.equalsIgnoreCase("Password cannot be empty"))
		{
			System.out.println("Login with valid username and blank password is Passed");
		}
			
		else
		{
			System.out.println("Login with valid username and blank password is Failed");
		}
			
		fd.close();
		}

}
