package in.beingzero.sandeep;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class ETSol {

	public static void main(String[] args) {
		ETSol sol = new ETSol();
		// Looks like someone else deleted this emp
		// Id that addEmployee Creates should be used by editEmp
		//sol.addEmployeeTest();
		sol.editEmployeeDOBTest();
	}

	WebDriver driver;
	String empId = "0016";
	String ohrmURL = "http://opensource.demo.orangehrmlive.com";
	String userNameId = "txtUsername";
	String passwdId = "txtPassword";
	String loginButtonId = "btnLogin";

	// SINCE EVERY TEST NEEDS LOGIN, LET;s MAKE THAT A SEPARATE FUNCTION

	// This will tell if login was successful or not.
	boolean doLogin(String userName, String password) {

		if (driver == null) {
			driver = new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.manage().window().maximize();

			driver.get(ohrmURL);
			WebElement Username = driver.findElement(By.id(userNameId));
			Username.clear();
			Username.sendKeys(userName);

			WebElement Password = driver.findElement(By.id(passwdId));
			Password.sendKeys(password);

			WebElement Login = driver.findElement(By.id(loginButtonId));
			Login.click();

			String actualHomePageText = driver.findElement(By.id("welcome")).getText();

			// Verify Welcome User is displayed
			// Convert to lowercase before comparing
			if (actualHomePageText.contains("Welcome")
					&& actualHomePageText.toLowerCase().contains(userName.toLowerCase())) {
				System.out.println("Login Succeeded for user " + userName);
				return true;
			} else {
				System.out.println("Login Failed for user " + userName);
				return false;
			}
		}
		return true;

	}

	void addEmployeeTest() {
		if (doLogin("admin", "admin")) {

			// 7.   Click on the Add Employee SubMenu and Print out the URL
			driver.findElement(By.linkText("PIM")).click();
			driver.findElement(By.id("menu_pim_addEmployee")).click();
			System.out.println("Current URL is : " + driver.getCurrentUrl());

			/*
			 * 8.   Click and enter First Name 9.   Click and enter Middle Name
			 * 10. Click and enter Last Name 11. Print Employee ID (which is
			 * auto generated field)
			 */
			String firstName = "Being";
			String middleName = "Zero";
			String lastName = "Selenium";
			String userName = "beingzero", password = "beingzero";

			driver.findElement(By.id("firstName")).sendKeys(firstName);

			driver.findElement(By.id("middleName")).sendKeys(middleName);

			driver.findElement(By.id("lastName")).sendKeys(lastName);

			empId = driver.findElement(By.id("employeeId")).getAttribute("value");
			System.out.println("Employee ID: " + empId);

			/*
			 * 12.  Check 'Create Login Details' 13. Enter username, password,
			 * confirm password
			 */
			driver.findElement(By.id("chkLogin")).click();

			driver.findElement(By.id("user_name")).sendKeys(userName);

			driver.findElement(By.id("user_password")).sendKeys(password);

			driver.findElement(By.id("re_password")).sendKeys(password);

			// 14. Verify that in dropdown Enabled is selected
			WebElement statusSelector = driver.findElement(By.id("status"));
			Select statusSelect = new Select(statusSelector);

			String statusSelected = statusSelect.getFirstSelectedOption().getText();
			System.out.println("Selected Status is " + statusSelected);
			if (!statusSelected.equals("Enabled")) {
				System.out.println("Selected Status MUST have been Enabled");
			}

			// 15. Click Save
			driver.findElement(By.id("btnSave")).click();

			// 16. Verify Employee Details are correct -
			// Validate FirstName, Middle Name, LAst Name and Employee ID
			if (!driver.findElement(By.id("personal_txtEmpFirstName")).getAttribute("value").equals(firstName)) {
				System.out.println("FirstName doesn't match");
			}
			if (!driver.findElement(By.id("personal_txtEmpMiddleName")).getAttribute("value").equals(middleName)) {
				System.out.println("MiddleName doesn't match");
			}
			if (!driver.findElement(By.id("personal_txtEmpLastName")).getAttribute("value").equals(lastName)) {
				System.out.println("LastName doesn't match");
			}
			if (!driver.findElement(By.id("personal_txtEmployeeId")).getAttribute("value").equals(empId)) {
				System.out.println("EmpID doesn't match");
			}

		}

	}

	void editEmployeeDOBTest() {
		if (doLogin("admin", "admin")) {
			driver.findElement(By.linkText("PIM")).click();
			driver.findElement(By.id("menu_pim_viewEmployeeList")).click();

			driver.findElement(By.id("empsearch_id")).sendKeys(empId);

			driver.findElement(By.id("searchBtn")).click();

			WebElement tblElement = driver.findElement(By.id("resultTable"));
			WebElement tbodyElement = tblElement.findElement(By.tagName("tbody"));

			List<WebElement> rows = tbodyElement.findElements(By.tagName("tr"));
			System.out.println("Total Rows " + rows.size());

			// There would be only one row, We need to click on second column of
			// this row

			// Or shortcut would have been to click the hyperlink with text
			// empId
			tbodyElement.findElement(By.linkText(empId)).click();

			driver.findElement(By.id("btnSave")).click();

			driver.findElement(By.id("personal_DOB")).click();

			WebElement monthdropWE = driver.findElement(By.className("ui-datepicker-month"));
			Select monthDropDown = new Select(monthdropWE);
			monthDropDown.selectByVisibleText("Dec");

			Select yearDD = new Select(driver.findElement(By.className("ui-datepicker-year")));
			yearDD.selectByVisibleText("1998");

			WebElement calTable = driver.findElement(By.className("ui-datepicker-calendar"));
			calTable.findElement(By.linkText("5")).click();

			driver.findElement(By.id("btnSave")).click();

			// "Successfully Saved "

			WebDriverWait wdv = new WebDriverWait(driver, 30);
			WebElement savedSuccessMsgWE = wdv.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='message success fadable']")));
			System.out.println("Found Success Message");
			System.out.println(savedSuccessMsgWE.getText());
			wdv.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='message success fadable']")));
		}

		System.out.println(driver.findElement(By.id("personal_DOB")).getAttribute("value"));

		driver.quit();

	}

	void uploadEmployeeImage() {
		/*
		 * 1.   Launch Browser. 2.   Open
		 * http://opensource.demo.orangehrmlive.com/ 3.   Enter username - Admin
		 * 4.   Enter password - admin 5.   Click Login Button 6.   Verify that
		 * login succeeds and we then go to the PIM Page. 7.   Click on the
		 * Employee List SubMenu and Print out the URL 8.   Enter Employee Id in
		 * Id Box and Click Search Button 9.   Click on Employee Name field in
		 * the Result Table to open Emp Details 10. Click Edit Button 11. Click
		 * Employee Photo Icon 12.  Upload any image from your pc to site using
		 * Choose File and upload 13. Verify that image is uploaded and shown.
		 */
	}

	void deleteEmployeeTest() {
		/*
		 * 1.   Launch Browser. 2.   Open
		 * http://opensource.demo.orangehrmlive.com/ 3.   Enter username - Admin
		 * 4.   Enter password - admin 5.   Click Login Button 6.   Verify that
		 * login succeeds and we then go to the PIM Page. 7.   Click on the
		 * Employee List SubMenu and Print out the URL 8.   Get count of total
		 * employees shown in the table and store in variable originalCount 9.
		 * Print the Count. 10. Using an employee ID, click on checkbox in the
		 * result table in front of empid row 11. Click Delete button 12. On
		 * confirmation dialog (Note: This isn't an ALERT, you can inspect it)
		 * click OK button. 13. Verify that Successfully Deleted momentary popup
		 * appears. 14. Wait for popup to disappear. 15. Get count of rows in
		 * the results table and store in finalCount variable (int) 16. Print
		 * finalCount. 17. If finalCount+1 is equal to originalCount, print
		 * Passed, otherwise print failed. 18. Also verify that employee id
		 * deleted just now isn't shown in the table anymore.
		 */
	}

	void downloadEmpImportFile() {
		/*
		 * 1.   Launch Browser. 2.   Open
		 * http://opensource.demo.orangehrmlive.com/ 3.   Enter username - Admin
		 * 4.   Enter password - admin 5.   Click Login Button 6.   Verify that
		 * login succeeds and we then go to the PIM Page. 7.   Hover mouse over
		 * Configuration SubMenu and Click Data Import 8.   Click Download Link
		 * on CSV Data Import Page 9. Verify that file has been downloaded to
		 * the computer. 10. Click upload to upload the same file again. 11.
		 * Quit the browser
		 */
	}

}
