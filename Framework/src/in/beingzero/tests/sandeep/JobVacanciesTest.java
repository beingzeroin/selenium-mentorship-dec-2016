package in.beingzero.tests.sandeep;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class JobVacanciesTest extends BaseTest {

	@BeforeSuite
	public void setup()
	{
		System.out.println("Before Suite");
	}
	

	
	@Test(dependsOnMethods = {"login"})
	public void postVacancy()
	{
		System.out.println("postVacancy");
	}
	
	@Test(dependsOnMethods = {"postVacancy"})
	public void verifyResumeApplicationForJob()
	{
		System.out.println("verifyResumeApplicationForJob");
	}
	
	@AfterSuite
	public void cleanup()
	{
		System.out.println("After Suite");
	}
	
}
