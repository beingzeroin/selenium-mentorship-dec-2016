package in.beingzero.tests.priya;

import org.testng.annotations.Test;

import in.beingzero.framework.POM.Priya.AddEmployeePage;
import in.beingzero.framework.POM.Priya.DashBoardPageOHRM;
import in.beingzero.framework.POM.Priya.LoginPageOHRM;
import in.beingzero.framework.POM.Priya.PersonalDetails;
import in.beingzero.framework.data.priya.AddEmpData;

public class LoginTestPOM {
	
	LoginPageOHRM loginPage;
	AddEmployeePage AddEmpObj;
	
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
		
		AddEmpObj = dp.validateValidUser(UName,Pwd);
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
	
	
	
}
