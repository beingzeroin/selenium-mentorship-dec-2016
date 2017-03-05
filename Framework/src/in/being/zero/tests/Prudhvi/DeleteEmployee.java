package in.being.zero.tests.Prudhvi;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import in.beingzero.framework.POM.Prudhvi.DashBoardPage;
import in.beingzero.framework.POM.Prudhvi.EmployeeListPage;
import in.beingzero.framework.POM.Prudhvi.LoginPage;
import in.beingzero.framework.config.Prudhvi.ConfigManager;
import in.beingzero.framework.data.sandeep.DataManager;
import in.beingzero.framework.data.sandeep.ExcelDataManager;

public class DeleteEmployee {
	
		
	DashBoardPage objDBPage;
	@BeforeMethod
	public void LoginTest()
	{
		LoginPage objLoginPage=new LoginPage();
		ConfigManager objCM=new ConfigManager();
		objDBPage=objLoginPage.validLogin(objCM.getProperty("userName"), objCM.getProperty("password"));

	}
	
	@Test(dataProvider="dataProviderForDelete")
	public void deleteEmployee(String strEmp_id)
	{
		EmployeeListPage objEmpList=objDBPage.navigateToEmployeeListPage();
		objEmpList.deleteEmployee(strEmp_id);
		
	}
	

	
	@DataProvider
	public Object[][] dataProviderForDelete()
	{
		DataManager dm = new ExcelDataManager("testdata/OrangeHRM-TestData.xlsx", "AuthTests", "DeleteEmployeeTable");
		return dm.getData();
	}


	
	

}
