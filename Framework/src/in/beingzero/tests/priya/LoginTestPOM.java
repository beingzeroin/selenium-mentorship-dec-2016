package in.beingzero.tests.priya;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import in.beingzero.framework.POM.Priya.AddEmployeePage;
import in.beingzero.framework.POM.Priya.DashBoardPageOHRM;
import in.beingzero.framework.POM.Priya.LoginPageOHRM;
import in.beingzero.framework.POM.Priya.PersonalDetails;
import in.beingzero.framework.data.priya.AddMultEmpExcel;
import in.beingzero.framework.data.priya.IExcelDataManager;

public class LoginTestPOM {
	
	LoginPageOHRM loginPage;
	AddEmployeePage AddEmpObj;
	String UName = "admin";
	String Pwd = "admin";
	String empIdValue ="";
	
	@BeforeClass
	public void setUp()
	{
		loginPage = new LoginPageOHRM();
		
	}
	
	@Test
	public void verifyLoginPageOHRM()
	{
		DashBoardPageOHRM dp = loginPage.validLogin(UName, Pwd);
		
		AddEmpObj = dp.validateValidUser();
	//	loginPage = dp.logout();
		System.out.println("valid user logged In");
	}
	
	//Processing of hard coded emp data 
	/*@Test(dataProvider = "addempdata",dataProviderClass = AddEmpData.class) 
	public void addEmployeeTest(String firstname,String middlename,String lastname)
	{
		PersonalDetails vfemp = AddEmpObj.addEmployeeDt(firstname,middlename,lastname);
		vfemp.verifynewAddedEmp();
		System.out.println("checking how many times this called");
	}*/
	
	
	@Test(dependsOnMethods={"verifyLoginPageOHRM"},dataProvider = "getEmpData") 
	public void addEmployeeTest(String firstname,String middlename,String lastname)
	{
		System.out.println(firstname+middlename+lastname);
		PersonalDetails vfemp = AddEmpObj.addEmployeeDt(firstname,middlename,lastname,empIdValue);
		vfemp.verifynewAddedEmp(firstname,middlename,lastname,empIdValue);
		System.out.println("checking how many times this called");
	}
	
	@DataProvider
	public Object[][] getEmpData()
	{
		IExcelDataManager edm = new AddMultEmpExcel
				("testdata/OHRMTestData-Priya.xlsx", "OHRM-New-Emp-Data", "NewEmpData");
		return edm.getData();
	}

}
