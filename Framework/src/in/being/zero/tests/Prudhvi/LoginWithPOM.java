package in.being.zero.tests.Prudhvi;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import in.beingzero.framework.POM.Prudhvi.DashBoardPage;
import in.beingzero.framework.POM.Prudhvi.LoginPage;
import in.beingzero.framework.config.Prudhvi.BrowserManager;
import in.beingzero.framework.config.Prudhvi.ConfigManager;

public class LoginWithPOM {
	
	LoginPage objLoginPPage;
	@BeforeMethod
	public void Setup()
	{
		objLoginPPage=new LoginPage();
		
	}
   

	//@Test
	public void ValidLoginTest()
	{
		DashBoardPage objDashBoardPage=objLoginPPage.validLogin("Admin","admin");
		String strWelcomeText=objDashBoardPage.getWelcomeMessage();
		Assert.assertTrue(strWelcomeText.toLowerCase().contains("admin"));
	}
	
	@Test
	public void LogoutTest()
	{
		DashBoardPage objDashBoardPage=objLoginPPage.validLogin("Admin","admin");
		objLoginPPage=objDashBoardPage.logOutAction();
		Assert.assertTrue(objLoginPPage.validatePage());
		
	}
	
	
}
