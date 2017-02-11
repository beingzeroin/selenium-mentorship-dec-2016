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
	
	public void addEmployee()
	{
		driver.findElement(firstName).sendKeys();
		driver.findElement(middleName).sendKeys();
		driver.findElement(lastName).sendKeys();
		driver.findElement(CheckLogin).click();
		driver.findElement(userName).sendKeys();
		driver.findElement(password).sendKeys();
		driver.findElement(confirmPassword).sendKeys();
		driver.findElement(saveButton).click();
		
	}
}
