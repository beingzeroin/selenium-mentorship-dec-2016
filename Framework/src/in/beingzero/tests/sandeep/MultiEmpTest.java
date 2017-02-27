package in.beingzero.tests.sandeep;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class MultiEmpTest  extends BaseTest {

	@BeforeTest
	public void bt()
	{
		System.out.println("Before Test Group");
	}
	@BeforeClass
	public void setup()
	{
		System.out.println("Setup");
	}
	
	@Test(dependsOnMethods = {"login"})
	public void addEmpTest()
	{
		//LoginPage lp = new Login();
		//lp.doLogin();
		System.out.println("AddEmpTest");
	}
	
	@Test(dependsOnMethods = {"login", "addEmpTest"})
	public void searchEmpTest()
	{
		System.out.println("SearchEmpTest");
	}
	
	@AfterClass
	public void cleanup()
	{
		System.out.println("Cleanup");
	}
	
}
