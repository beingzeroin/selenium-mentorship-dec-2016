package in.beingzero.swetha;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Week3EmployeeTests {

	String url = "http://opensource.demo.orangehrmlive.com";
	String userName = "Admin";
	String passWord = "admin";
	String expectedHomePageText = "Welcome Admin";
	String actualHomePageText = "";
	String ID1 = "txtUsername";
	String ID2 = "txtPassword";
	String ID3 = "btnLogin";
	String verifyEmpId = "";

	public void addEmployeeTest() {

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

			WebElement tabPIM = driver.findElement(By.linkText("PIM"));
			tabPIM.click();

			WebElement subMenuAddEmployee = driver.findElement(By.id("menu_pim_addEmployee"));
			subMenuAddEmployee.click();

			System.out.println("Print PIM -> Add Employee URL : " + driver.getCurrentUrl());

			String newEmpFirstName = "Jeff";
			WebElement firstName = driver.findElement(By.id("firstName"));
			firstName.sendKeys(newEmpFirstName);

			String newEmpMiddleName = "S";
			WebElement middleName = driver.findElement(By.id("middleName"));
			middleName.sendKeys(newEmpMiddleName);

			String newEmpLastName = "Boyle";
			WebElement lastName = driver.findElement(By.id("lastName"));
			lastName.sendKeys(newEmpLastName);

			String newEmpId = driver.findElement(By.id("employeeId")).getAttribute("value");
			System.out.println("Employee ID generated: " + newEmpId);

			WebElement clickLoginDetails = driver.findElement(By.id("chkLogin"));
			clickLoginDetails.click();

			WebElement newEmpUserName = driver.findElement(By.id("user_name"));
			newEmpUserName.sendKeys("JeffBoyle");

			WebElement newEmpPassword = driver.findElement(By.id("user_password"));
			newEmpPassword.sendKeys("HRM65SJ17");

			WebElement newEmpConfirmPassword = driver.findElement(By.id("re_password"));
			newEmpConfirmPassword.sendKeys("HRM65SJ17");

			WebElement statusSelector = driver.findElement(By.id("status"));
			Select statusSelect = new Select(statusSelector);

			String statusSelected = statusSelect.getFirstSelectedOption().getText();

			if (statusSelected.equals("Enabled")) {
				System.out.println("Print the selected Status: " + statusSelected);
			} else {
				statusSelect.selectByVisibleText("Enabled");
			}

			WebElement clickSave = driver.findElement(By.id("btnSave"));
			clickSave.click();

			// Verify Employee Details are correct
			String verifyFirstName = driver.findElement(By.id("personal_txtEmpFirstName")).getAttribute("value");

			if (verifyFirstName.equals(newEmpFirstName)) {
				System.out.println("First Name is verified : " + verifyFirstName);
			}

			String verifyMiddleName = driver.findElement(By.id("personal_txtEmpMiddleName")).getAttribute("value");

			if (verifyMiddleName.equals(newEmpMiddleName)) {
				System.out.println("Middle Name is verified : " + verifyMiddleName);
			}

			String verifyLastName = driver.findElement(By.id("personal_txtEmpLastName")).getAttribute("value");

			if (verifyLastName.equals(newEmpLastName)) {
				System.out.println("Last Name is verified : " + verifyLastName);
			}

			verifyEmpId = driver.findElement(By.id("personal_txtEmployeeId")).getAttribute("value");

			if (verifyEmpId.equals(newEmpId)) {
				System.out.println("Employee ID is verified : " + verifyEmpId);
			}

		} 
		
		else {
			System.out.println("Logon Failed");
		}
	}
	
	public void editEmployeeDOBTest()
	{
		/*
		1.   Launch Browser.
		2.   Open http://opensource.demo.orangehrmlive.com/
		3.   Enter username - Admin
		4.   Enter password - admin
		5.   Click Login Button */
		
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
//		6.   Verify that login succeeds and we then go to the PIM Page.
		
		actualHomePageText = driver.findElement(By.id("welcome")).getText();

		if (actualHomePageText.equals(expectedHomePageText)) {

			System.out.println("Logon Successful");

			WebElement tabPIM = driver.findElement(By.linkText("PIM"));
			tabPIM.click();
			
//			7.   Click on the Employee List SubMenu and Print out the URL
			
			WebElement subMenuEmployeeList = driver.findElement(By.id("menu_pim_viewEmployeeList"));
			subMenuEmployeeList.click();

			System.out.println("Print PIM -> Employee List URL : " + driver.getCurrentUrl());

//			8.   Enter Employee Id in Id Box and Click Search Button
						
			WebElement empId = driver.findElement(By.id("empsearch_id"));
			empId.sendKeys(verifyEmpId);
			
			WebElement clickSearch = driver.findElement(By.id("searchBtn"));
			clickSearch.click();
			
//			9.   Click on Employee Id field in the Result Table to open Emp Details
			
			WebElement resultClick = driver.findElement(By.linkText(verifyEmpId));
			resultClick.click();
			
//			10.  Click Edit Button
			
			WebElement editClick = driver.findElement(By.id("btnSave"));
			editClick.click();
			
//			11.  Enter Date Of Birth as 5th December 1998
//			12.  Click Save Button
			
			//Click calendar icon
			
			WebElement calendarBtn = driver.findElement(By.id("personal_DOB"));
			calendarBtn.click();
			
			//Select Birth Month
			
			Select selectMonth = new Select(driver.findElement(By.xpath(".//div[@id='ui-datepicker-div']//select[@class='ui-datepicker-month']")));
			selectMonth.selectByVisibleText("Dec");
			
			//Select Birth Year
			
			Select selectYear = new Select(driver.findElement(By.xpath(".//div[@id='ui-datepicker-div']//select[@class='ui-datepicker-year']")));
			selectYear.selectByVisibleText("1998");
			
			//Select Birth Date
			
			WebElement selectDate = driver.findElement(By.xpath(".//div[@id='ui-datepicker-div']//a[contains(text(),'5')]"));
			selectDate.click();
			
			WebElement clickSave = driver.findElement(By.id("btnSave"));
			clickSave.click();
			
//			13.  Verify that Confirmation Popup was shown (through automation)
//			14.  Wait for Success popup message to disappear
//			15.  Click Save Button
			
			WebDriverWait wait = new WebDriverWait(driver, 10);
			WebElement locatePopup = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(@class, 'message success fadable')]")));   
			
			System.out.println("Popup Message : "+locatePopup.getText());
			
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[contains(@class, 'message success fadable')]")));
			
			//			16.  Verify DOB is updated, by printing 
			
			WebElement verifyDOB = driver.findElement(By.id("personal_DOB"));
			String actualDOB = verifyDOB.getAttribute("value");
			
			if(actualDOB.equals("1998-12-05")){
				System.out.println("DOB has been verified : "+actualDOB);
			}
			else {
				System.out.println("DOB is incorrectly saved : " +actualDOB);
			}
			
		}	
			
		else {
			System.out.println("Logon Failed");
		}
		
	}

	public static void main(String[] args) throws InterruptedException {

		Week3EmployeeTests empTest = new Week3EmployeeTests();

		empTest.addEmployeeTest();
		
		empTest.editEmployeeDOBTest();

	}
}
