package in.being.zero.tests.Prudhvi;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import in.beingzero.framework.POM.Prudhvi.DashBoardPage;
import in.beingzero.framework.POM.Prudhvi.LoginPage;

public class LoginWithPOM {
	
	LoginPage objLoginPage;
	@BeforeMethod
	public void Setup()
	{
		objLoginPage=new LoginPage();
		
	}
   

	@Test
	public void ValidLoginTest()
	{
		DashBoardPage objDashBoardPage=objLoginPage.validLogin("Admin","admin");
		String strWelcomeText=objDashBoardPage.getWelcomeMessage();
		Assert.assertTrue(strWelcomeText.toLowerCase().contains("admin"));
	}
	
	@Test
	public void LogoutTest()
	{
		DashBoardPage objDashBoardPage=objLoginPage.validLogin("Admin","admin");
		objLoginPage=objDashBoardPage.logOutAction();
		Assert.assertTrue(objLoginPage.validatePage());
		
	}
	
	
}
