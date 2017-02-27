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
		driver.findElement(firstName).sendKeys(strFirstName);
		driver.findElement(middleName).sendKeys(strMiddleName);
		driver.findElement(lastName).sendKeys(strLastName);
		driver.findElement(CheckLogin).click();
		driver.findElement(userName).sendKeys(strFirstName);
		driver.findElement(password).sendKeys(strFirstName);
		driver.findElement(confirmPassword).sendKeys(strFirstName);
		driver.findElement(saveButton).click();
		return new EmployeeListPage(driver);
	}
}
