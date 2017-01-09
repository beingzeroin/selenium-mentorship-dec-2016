package in.beingzero.Ravi.OHRMTests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class EmployeeTests {
	WebDriver browser;

	@BeforeMethod
	public void logInSetUp() {
		browser = new ChromeDriver();
		browser.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		browser.manage().window().maximize();
		browser.get("http://opensource.demo.orangehrmlive.com");
	}

	@AfterMethod
	public void cleanUp() {
		browser.quit();
	}

	@Test
	void addEmployeeTest() {
		browser.findElement(By.id("txtUsername")).sendKeys("Admin");
		browser.findElement(By.id("txtPassword")).sendKeys("admin");
		browser.findElement(By.id("btnLogin")).click();
		String wlcmsg = browser.findElement(By.id("welcome")).getText();
		System.out.println(wlcmsg);
		Assert.assertTrue(wlcmsg.contains("Welcome Admin"));
		browser.findElement(By.id("menu_pim_viewPimModule")).click();
		browser.findElement(By.name("btnAdd")).click();
		System.out.println("Currently on URL: " + browser.getCurrentUrl());
		browser.findElement(By.id("firstName")).sendKeys("RDTest1");
		browser.findElement(By.id("middleName")).sendKeys("RDTest2");
		browser.findElement(By.id("lastName")).sendKeys("RDTest3");
		System.out.println(browser.findElement(By.id("employeeId")).getText());
		browser.findElement(By.id("chkLogin")).click();
		browser.findElement(By.id("user_name")).sendKeys("RDTest1");
		browser.findElement(By.id("user_password")).sendKeys("test");
		browser.findElement(By.id("re_password")).sendKeys("test");
		WebElement st = browser.findElement(By.id("status"));
		Select stts = new Select(st);
		String sttselect = stts.getFirstSelectedOption().getText();
		if (!sttselect.equals("Enabled")) {
			System.out.println("Enable status");
		}
		browser.findElement(By.id("btnSave")).click();
		Assert.assertTrue(
				browser.findElement(By.id("personal_txtEmpFirstName")).getAttribute("Value").equals("RDTest1"));
		Assert.assertTrue(
				browser.findElement(By.id("personal_txtEmpMiddleName")).getAttribute("Value").equals("RDTest2"));
		Assert.assertTrue(
				browser.findElement(By.id("personal_txtEmpLastName")).getAttribute("Value").equals("RDTest3"));
	}

	void editEmployeeDOBTest() {
		/*
		 * 1.   Launch Browser. 2.   Open
		 * http://opensource.demo.orangehrmlive.com/ 3.   Enter username - Admin
		 * 4.   Enter password - admin 5.   Click Login Button 6.   Verify that
		 * login succeeds and we then go to the PIM Page. 7.   Click on the
		 * Employee List SubMenu and Print out the URL 8.   Enter Employee Id in
		 * Id Box and Click Search Button 9.   Click on Employee Id field in the
		 * Result Table to open Emp Details 10. Click Edit Button 11. Enter Date
		 * Of Birth as 5th December 1998 12.  Click Save Button 13. Verify that
		 * Confirmation Popup was shown (through automation) 14. Wait for
		 * Success popup message to disappear 15. Click Save Button 16. Verify
		 * DOB is updated, by printing
		 */
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
