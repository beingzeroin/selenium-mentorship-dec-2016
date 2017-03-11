package in.beingzero.framework.POM.Prudhvi;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;




public class EmployeeListPage extends BasePage {
	
	By FirstName=By.id("personal_txtEmpFirstName");
	By MiddleName=By.id("personal_txtEmpMiddleName");
	By LastName=By.id("personal_txtEmpLastName");
	
	By searchId=By.id("empsearch_id");
	By searchBtn=By.id("searchBtn");
	By chkAllBox=By.id("ohrmList_chkSelectAll");
	By deleteButton=By.id("btnDelete");
	By confirmDelete=By.id("dialogDeleteBtn");
	
	
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


	@SuppressWarnings("deprecation")
	public void verifyPersonalDetails(String strFirstName,String strMiddleName,String strLastName)
	{
		
		Assert.assertEquals(strFirstName, getDriver().findElement(FirstName).getAttribute("value"));
		System.out.println("First name is as expected");
		Assert.assertEquals(strMiddleName, getDriver().findElement(MiddleName).getAttribute("value"));
		System.out.println("Middle name is as expected");
		Assert.assertEquals(strLastName, getDriver().findElement(LastName).getAttribute("value"));
		System.out.println("Last name is as expected");
		
	}
	
	
	public void deleteEmployee(String strEmpId)
	{
		getDriver().findElement(searchId).sendKeys(strEmpId);
		getDriver().findElement(searchBtn).click();
		getDriver().findElement(chkAllBox).click();
		getDriver().findElement(deleteButton).click();
		getDriver().findElement(confirmDelete).click();
	}
	
		
	
}
