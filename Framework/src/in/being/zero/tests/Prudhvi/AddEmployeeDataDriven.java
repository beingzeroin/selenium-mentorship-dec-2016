package in.being.zero.tests.Prudhvi;


import org.testng.annotations.BeforeMethod;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import in.beingzero.framework.POM.Prudhvi.AddEmployeePage;
import in.beingzero.framework.POM.Prudhvi.BasePage;
import in.beingzero.framework.POM.Prudhvi.DashBoardPage;
import in.beingzero.framework.POM.Prudhvi.EmployeeListPage;
import in.beingzero.framework.POM.Prudhvi.LoginPage;
import in.beingzero.framework.config.Prudhvi.ConfigManager;
import in.beingzero.framework.data.sandeep.DataManager;
import in.beingzero.framework.data.sandeep.ExcelDataManager;

public class AddEmployeeDataDriven {
	 DashBoardPage objDBPage;
	 BasePage objBasePage;
	@BeforeMethod
	public void LoginTest()
	{
		LoginPage objLoginPage=new LoginPage();
		ConfigManager objCM=new ConfigManager();

		objDBPage=objLoginPage.validLogin(objCM.getProperty("userName"), objCM.getProperty("password"));

		objLoginPage.validLogin(objCM.getProperty("userName"), objCM.getProperty("password"));


	}
	
	@Test(dataProvider="dp"/*,dependsOnMethods={"LoginTest"}*/)
	public void AddEmployee(String firstName, String middleName, String lastName)
	{
		
		//LoginPage objLoginPage=new LoginPage();
		//ConfigManager objCM=new ConfigManager();
		//DashBoardPage objDBPage=objLoginPage.validLogin(objCM.getProperty("userName"), objCM.getProperty("password"));
		//DashBoardPage objDBPage =new DashBoardPage();
		AddEmployeePage objAddEmpPage=objBasePage.NavigateToAddEmployee1();
		EmployeeListPage objEmployeeList=objAddEmpPage.addEmployee(firstName,middleName,lastName);
		objEmployeeList.verifyPersonalDetails(firstName, middleName, lastName);

		LoginPage objLoginPage=new LoginPage();
		ConfigManager objCM=new ConfigManager();
		DashBoardPage objDBPage=objLoginPage.validLogin(objCM.getProperty("userName"), objCM.getProperty("password"));
		AddEmployeePage objAddEmpPage1=objDBPage.navigateToAddEmployeePage();
		objAddEmpPage1.addEmployee(firstName,middleName,lastName);

	}
	//@Test
	public void AddMultipleEmployees()
	{
		Object[][] Employees=dp();
		int iEmployeeNo=Employees.length;
		
		for(int i=0;i<iEmployeeNo;i++)
		{			
			AddEmployeePage objAddEmpPage2=objDBPage.navigateToAddEmployeePage();
			EmployeeListPage obj=objAddEmpPage2.addEmployee(Employees[i][0].toString(),Employees[i][1].toString(),Employees[i][2].toString());
		}
		
	}
	
	
	
	
	@DataProvider
	public Object[][] dp()
	{
		DataManager dm = new ExcelDataManager("testdata/OrangeHRM-TestData.xlsx", "AuthTests", "EmployeeDetails");
		return dm.getData();
	}


}
