package in.beingzero.tests.swetha;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import in.beingzero.framework.POM.Swetha.DashboardPage;
import in.beingzero.framework.POM.Swetha.LoginPage;


public class LoginTestsPOM {

LoginPage loginPage;	
	
	@BeforeMethod
	public void setup()
	{
		loginPage = new LoginPage();
	}
	
	@Test
	public void loginAdminTest() throws InterruptedException
	{
		DashboardPage dp = loginPage.validLogin("admin", "admin");
		
		String welcomeText = dp.getWelcomeText();
		Assert.assertTrue(welcomeText.toLowerCase().contains("Welcome admin"));
		
		loginPage = dp.logOut();
		
	}
	
	@Test
	public void cleanup()
	{

	}
}
