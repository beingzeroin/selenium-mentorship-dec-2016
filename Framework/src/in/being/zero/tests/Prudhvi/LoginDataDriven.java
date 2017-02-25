package in.being.zero.tests.Prudhvi;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import in.beingzero.framework.data.sandeep.DataManager;
import in.beingzero.framework.data.sandeep.ExcelDataManager;
import in.beingzero.framework.POM.Prudhvi.DashBoardPage;
import in.beingzero.framework.POM.Prudhvi.LoginPage;
import in.beingzero.framework.config.Prudhvi.BrowserManager;

public class LoginDataDriven {
	LoginPage objLoginPage;
	@BeforeMethod
	public void Setup()
	{
		objLoginPage=new LoginPage();
		
	}
	@AfterMethod
	public void Cleanup()
	{
		//BrowserManager objBrowseManager=new BrowserManager();
		
		//objBrowseManager.CloseBrowser();
	}

	@Test(dataProvider="dp")
	public void loginTest(String strUserName, String strPassword, boolean exp)
	{
		if (exp)
		{
			DashBoardPage objDashBoardPage=objLoginPage.validLogin(strUserName,strPassword);
			String strWelcomeText=objDashBoardPage.getWelcomeMessage();
			Assert.assertTrue(strWelcomeText.toLowerCase().contains("admin"));
		}
		else
		{
			
			String strWarningMessage=objLoginPage.InvalidLogin(strUserName, strPassword);
			System.out.printf("%s\n", strWarningMessage);
			
		}
		
	}
	
	@DataProvider
	public Object[][] dp()
	{
		DataManager dm = new ExcelDataManager("testdata/OrangeHRM-TestData.xlsx", "AuthTests", "RightLoginTestData");
		return dm.getData();
	}

	
}
