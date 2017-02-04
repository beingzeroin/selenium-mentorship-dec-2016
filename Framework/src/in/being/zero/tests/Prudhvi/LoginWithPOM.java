package in.being.zero.tests.Prudhvi;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import in.beingzero.framework.POM.Prudhvi.DashBoardPage;
import in.beingzero.framework.POM.Prudhvi.LoginPage;
import in.beingzero.framework.config.Prudhvi.ConfigManager;

public class LoginWithPOM {
	ConfigManager objConfig=new ConfigManager();
	WebDriver objDriver;

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

	@Test
	public void LoginTest()
	{
		
		LoginPage objLoginPage=new LoginPage();
		DashBoardPage objDashboardPage;
		String strName=objConfig.getProperty("userName");
		String strPwd=objConfig.getProperty("password");
		objDashboardPage=objLoginPage.loginAction(objDriver, strName, strPwd);
		if(objDashboardPage.isLoginSuccessfull(objDriver))
		{
			System.out.println("Login is success");
		}
		else
		{
			System.out.println("Login Failed");
		}
	}
	
	//@Test
	public void LogoutTest()
	{
		
	}
	
	
}
