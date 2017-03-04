package in.being.zero.tests.Prudhvi;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import in.beingzero.framework.POM.Prudhvi.AddEmployeePage;
import in.beingzero.framework.POM.Prudhvi.DashBoardPage;
import in.beingzero.framework.POM.Prudhvi.LoginPage;
import in.beingzero.framework.config.Prudhvi.ConfigManager;
import in.beingzero.framework.data.sandeep.DataManager;
import in.beingzero.framework.data.sandeep.ExcelDataManager;

public class AddEmployeeDataDriven {
	
	//@Test
	public void LoginTest()
	{
		LoginPage objLoginPage=new LoginPage();
		ConfigManager objCM=new ConfigManager();
		objLoginPage.validLogin(objCM.getProperty("userName"), objCM.getProperty("password"));

	}
	
	@Test(dataProvider="dp")//dependsOnMethods={"LoginTest"},
	public void loginTest(String firstName, String middleName, String lastName)
	{
		
		LoginPage objLoginPage=new LoginPage();
		ConfigManager objCM=new ConfigManager();
		DashBoardPage objDBPage=objLoginPage.validLogin(objCM.getProperty("userName"), objCM.getProperty("password"));
		AddEmployeePage objAddEmpPage=objDBPage.navigateToAddEmployeePage();
		objAddEmpPage.addEmployee(firstName,middleName,lastName);
	}
	
	@DataProvider
	public Object[][] dp()
	{
		DataManager dm = new ExcelDataManager("testdata/OrangeHRM-TestData.xlsx", "AuthTests", "EmployeeDetails");
		return dm.getData();
	}


}
