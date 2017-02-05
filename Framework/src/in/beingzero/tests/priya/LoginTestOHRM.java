package in.beingzero.tests.priya;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import in.beingzero.framework.config.priya.DashBoardPageOHRM;
import in.beingzero.framework.config.priya.LoginPageOHRM;

public class LoginTestOHRM {
	
	//WebDriver driver;
	WebDriver driver = new ChromeDriver();
	//driver.manage().window().maximize();
	
	
	/*@BeforeMethod
	public void setUp()
	{
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://opensource.demo.orangehrmlive.com");
	}*/
		
	@Test
	public void verifyLoginPageOHRM()
	{
		
		driver.get("http://opensource.demo.orangehrmlive.com");
		String UName = "admin";
		String Pwd = "admin";
		System.out.println("going in loginpage class");
		LoginPageOHRM lp = new LoginPageOHRM(driver);
		System.out.println("came out of  loginpage class");
		DashBoardPageOHRM dp = lp.loginWithValidUser(UName, Pwd);
		System.out.println("dashboard called");
		dp.validateValidUser(UName,Pwd);
	}
}
