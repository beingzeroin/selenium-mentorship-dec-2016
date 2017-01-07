package in.beingzero.swetha;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Week3EmployeeTests {

	public static String url = "http://opensource.demo.orangehrmlive.com";
	public static String userName = "Admin";
	public static String passWord = "admin";
	public static String expectedHomePageText = "Welcome Admin";
	public static String actualHomePageText = "";
	public static String ID1 = "txtUsername";
	public static String ID2 = "txtPassword";
	public static String ID3 = "btnLogin";

	public void addEmployeeTest1() {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		driver.get(url);
		WebElement Username = driver.findElement(By.id(ID1));
	    Username.clear();
		Username.sendKeys(userName);
		

		WebElement Password = driver.findElement(By.id(ID2));
		Password.sendKeys(passWord);
		
		WebElement Login = driver.findElement(By.id(ID3));
		Login.click();
		
		actualHomePageText = driver.findElement(By.id("welcome")).getText();

		if (actualHomePageText.equals(expectedHomePageText)) {
			System.out.println("Logon Successful");
		} else {
			System.out.println("Logon Failed");
		}
		
		WebElement tabPIM = driver.findElement(By.linkText("PIM"));
		tabPIM.click();
		
		WebElement subMenuAddEmployee = driver.findElement(By.id("menu_pim_addEmployee"));
		subMenuAddEmployee.click();
		
		System.out.println("Print PIM -> Add Employee URL : " +driver.getCurrentUrl());
		
		String newEmpFirstName = "Swetha";
		WebElement firstName = driver.findElement(By.id("firstName"));
		firstName.sendKeys(newEmpFirstName);
		
		String newEmpMiddleName = "S";
		WebElement middleName = driver.findElement(By.id("middleName"));
		middleName.sendKeys(newEmpMiddleName);
		
		String newEmpLastName = "Jain";
		WebElement lastName = driver.findElement(By.id("lastName"));
		lastName.sendKeys(newEmpLastName);
		
		String newEmpId = driver.findElement(By.id("employeeId")).getAttribute("value");
		System.out.println("Employee ID generated: " +newEmpId);
		
		WebElement clickLoginDetails = driver.findElement(By.id("chkLogin"));
		clickLoginDetails.click();
		
		WebElement newEmpUserName = driver.findElement(By.id("user_name"));
		newEmpUserName.sendKeys("SwethaJain");
		
		WebElement newEmpPassword = driver.findElement(By.id("user_password"));
		newEmpPassword.sendKeys("HRM65SJ17");
		
		WebElement newEmpConfirmPassword = driver.findElement(By.id("re_password"));
		newEmpConfirmPassword.sendKeys("HRM65SJ17");
		
		WebElement statusSelector = driver.findElement(By.id("status"));
		Select statusSelect = new Select(statusSelector);
		
		String statusSelected = statusSelect.getFirstSelectedOption().getText();
		
		if(statusSelected.equals("Enabled")){			
			System.out.println("Print the selected Status: " +statusSelected);
		} else {	
			statusSelect.selectByVisibleText("Enabled");
		}	
		
		WebElement clickSave = driver.findElement(By.id("btnSave"));
		clickSave.click();		
		
		//Verify Employee Details are correct
		String verifyFirstName = driver.findElement(By.id("personal_txtEmpFirstName")).getAttribute("value");
		
		if(verifyFirstName.equals(newEmpFirstName))
		{
			System.out.println("First Name is verified : " +verifyFirstName);
		}
		
		String verifyMiddleName = driver.findElement(By.id("personal_txtEmpMiddleName")).getAttribute("value");
		
		if(verifyMiddleName.equals(newEmpMiddleName))
		{
			System.out.println("Middle Name is verified : " +verifyMiddleName);
		}
		
		String verifyLastName = driver.findElement(By.id("personal_txtEmpLastName")).getAttribute("value");
		
		if(verifyLastName.equals(newEmpLastName))
		{
			System.out.println("Last Name is verified : " +verifyLastName );
		}
		
		String verifyEmpId = driver.findElement(By.id("personal_txtEmployeeId")).getAttribute("value");
		
		if(verifyEmpId.equals(newEmpId))
		{
			System.out.println("Employee ID is verified : " +verifyEmpId);
		}
	}
	
	public static void main(String[] args) throws InterruptedException {

		Week3EmployeeTests empTest = new Week3EmployeeTests();

		empTest.addEmployeeTest1();
		
	}	
}	
