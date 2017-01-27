package in.being.zero.tests.Prudhvi;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import in.beingzero.framework.config.Prudhvi.ConfigManager;

public class LoginTest 
{
	WebDriver objDriver;
	ConfigManager objConfig=new ConfigManager();
	
	@BeforeMethod
	public void Setup()
	{
		//To select the browser 
		String strBrowserName=objConfig.getProperty("browser");
		if(strBrowserName.equalsIgnoreCase("CHROME"))
		{
			objDriver=new ChromeDriver();
		}
		else if(strBrowserName.equalsIgnoreCase("FIREFOX"))
		{
			objDriver=new FirefoxDriver();
		}
		else
		{
			objDriver=new InternetExplorerDriver();
		}
		
		//To open the URL
		
		objDriver.get(objConfig.getProperty("url"));
		
		//To maximize the browser window.
		if(objConfig.getBooleanProperty("runFullScreen"))
			objDriver.manage().window().maximize();

		//To set the implicit wait time
		objDriver.manage().timeouts().implicitlyWait(objConfig.getLongProperty("implicitTimeoutInSeconds"), TimeUnit.SECONDS);
		
		
	}
	@AfterMethod
	public void Cleanup()
	{
		objDriver.quit();
	}
	@Test
	public void Login()
	{
	
		if(IsLoginSucceed())
			System.out.println("Login is success");
		else
			System.out.println("Login is Failed");	
	}
	
	
	public boolean IsLoginSucceed()
	{
		boolean boolIsLoginDone=false;
		String strUserName=objConfig.getProperty("userName");
		objDriver.findElement(By.id("txtUsername")).sendKeys(strUserName);
		objDriver.findElement(By.id("txtPassword")).sendKeys(objConfig.getProperty("password"));
		objDriver.findElement(By.id("btnLogin")).click();
		
		if(objDriver.findElement(By.id("welcome")).isDisplayed())
		{
			
			boolIsLoginDone=true;
		}
		
			return boolIsLoginDone;
	}
	
	
	//@Test(dependsOnMethods = {"Login"})
	@Test
	public void Logout()
	{
		if(IsLoginSucceed())
		{
			objDriver.findElement(By.id("welcome")).click();
			objDriver.findElement(By.xpath(".//*[@id='welcome-menu']/ul/li[2]/a")).click();
	
			if(objDriver.findElement(By.id("btnLogin")).isDisplayed())
				System.out.println("Logout action is success");
			else
				System.out.println("Logout action is success");
		}
		else
		{
			System.out.println("Login is Failed so logout can not be performed,");
		}
		
	}
	
	
}
