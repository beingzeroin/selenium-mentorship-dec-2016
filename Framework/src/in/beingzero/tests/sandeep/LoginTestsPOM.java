package in.beingzero.tests.sandeep;

import org.testng.Assert;
import org.testng.annotations.Test;

import in.beingzero.framework.POM.sandeep.DashboardPage;
import in.beingzero.framework.POM.sandeep.LoginPage;

public class LoginTestsPOM {

	LoginPage loginPage;	
	
	@Test
	public void setup()
	{
		loginPage = new LoginPage();
	}
	
	@Test
	public void loginAdminTest()
	{
		//DashboardPage dp = loginPage.validLogin("admin", "admin");
		//dp.refresh();
		
		//dp.navigate().goToDirectoryPage();
		
		
		// Verification
		//String welcomeText = dp.getWelcomeText();
		//Assert.assertTrue(welcomeText.toLowerCase().contains("admin"));
	}
	
	@Test
	public void cleanup()
	{
		//WebDriver driver = null;
		//EmployeePage ep = new EmployeePage(driver);
		//BrowerManager bm = new BrowserManager();
		//bm.closeAllBrowsers();
	}
	
}
