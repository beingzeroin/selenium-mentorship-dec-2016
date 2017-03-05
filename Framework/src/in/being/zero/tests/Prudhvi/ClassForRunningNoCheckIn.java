package in.being.zero.tests.Prudhvi;

import in.beingzero.framework.POM.Prudhvi.AddEmployeePage;
import in.beingzero.framework.POM.Prudhvi.BasePage;
import in.beingzero.framework.POM.Prudhvi.DashBoardPage;
import in.beingzero.framework.POM.Prudhvi.EmployeeListPage;
import in.beingzero.framework.POM.Prudhvi.LoginPage;

public class ClassForRunningNoCheckIn {
	
	public static void main(String[] args)
	{
		LoginPage objLoginPage=new LoginPage();
		DashBoardPage objDBPage=objLoginPage.validLogin("admin", "admin");
		
		AddEmployeePage objAddEmpPage=objDBPage.navigateToAddEmployeePage();
		EmployeeListPage obj=objAddEmpPage.addEmployee("Hello","Hello","Hello");
	}

}
