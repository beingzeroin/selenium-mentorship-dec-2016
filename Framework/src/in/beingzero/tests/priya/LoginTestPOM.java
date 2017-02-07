package in.beingzero.tests.priya;

import org.testng.annotations.Test;

import in.beingzero.framework.POM.Priya.DashBoardPageOHRM;
import in.beingzero.framework.POM.Priya.LoginPageOHRM;

public class LoginTestPOM {
	
	LoginPageOHRM loginPage;
	
	@Test
	public void setUp()
	{
		loginPage = new LoginPageOHRM();
	}
	
	@Test
	public void verifyLoginPageOHRM()
	{
		String UName = "admin";
		String Pwd = "admin";
		DashBoardPageOHRM dp = loginPage.validLogin(UName, Pwd);
		
		dp.validateValidUser(UName,Pwd);
		System.out.println("valid user logged In");
	}
	
	@Test
	public void verifyLogout()
	{
		DashBoardPageOHRM dp1 = new DashBoardPageOHRM();
		dp1.logout();
		System.out.println("User logged Out");
	
	}
}
