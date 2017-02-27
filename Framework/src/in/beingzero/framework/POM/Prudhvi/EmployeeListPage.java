package in.beingzero.framework.POM.Prudhvi;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class EmployeeListPage extends BasePage {
	public EmployeeListPage()
	{
		//BrowserManager objBM=new BrowserManager();
		//driver=objBM.launchBrowser();
	}
	
	
	public EmployeeListPage(WebDriver driver) 
	{
		
		//this.driver=driver;
		super(driver);
	}

	
	public void getPersonalDetails()
	{
		By FirstName=By.id("personal_txtEmpFirstName");
		By MiddleName=By.id("personal_txtEmpMiddleName");
		By LastName=By.id("personal_txtEmpLastName");
		
		driver.findElement(FirstName).getAttribute("value");
		driver.findElement(MiddleName).getAttribute("value");
		driver.findElement(LastName).getAttribute("value");
	}
}
