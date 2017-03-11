package in.beingzero.framework.POM.Prudhvi;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AddEmployeePage extends BasePage{
	
	
	By firstName=By.id("firstName");
	By lastName=By.id("lastName");
	By middleName=By.id("middleName");
	By saveButton=By.id("btnSave");
	By CheckLogin=By.id("chkLogin");
	By userName=By.id("user_name");
	By password=By.id("user_password");
	By confirmPassword=By.id("re_password");
	public AddEmployeePage()
	{
		
	}
	
	
	public AddEmployeePage(WebDriver driver) 
	{
		super(driver);
	}
	
	public EmployeeListPage addEmployee(String strFirstName,String strMiddleName,String strLastName)
	{
		getDriver().findElement(firstName).sendKeys(strFirstName);
		getDriver().findElement(middleName).sendKeys(strMiddleName);
		getDriver().findElement(lastName).sendKeys(strLastName);
		getDriver().findElement(CheckLogin).click();
		getDriver().findElement(userName).sendKeys(strFirstName);
		getDriver().findElement(password).sendKeys(strFirstName);
		getDriver().findElement(confirmPassword).sendKeys(strFirstName);
		getDriver().findElement(saveButton).click();
		return new EmployeeListPage(getDriver());
	}
}
