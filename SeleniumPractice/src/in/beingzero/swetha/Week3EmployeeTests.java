package in.beingzero.swetha;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.interactions.Actions;
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

			String newEmpFirstName = "Java";
			WebElement firstName = driver.findElement(By.id("firstName"));
			firstName.sendKeys(newEmpFirstName);

			String newEmpMiddleName = "S";
			WebElement middleName = driver.findElement(By.id("middleName"));
			middleName.sendKeys(newEmpMiddleName);

			String newEmpLastName = "Ruby";
			WebElement lastName = driver.findElement(By.id("lastName"));
			lastName.sendKeys(newEmpLastName);

			String newEmpId = driver.findElement(By.id("employeeId")).getAttribute("value");
			System.out.println("Employee ID generated: " + newEmpId);

			WebElement clickLoginDetails = driver.findElement(By.id("chkLogin"));
			clickLoginDetails.click();

			WebElement newEmpUserName = driver.findElement(By.id("user_name"));
			newEmpUserName.sendKeys("JavaRuby");

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

	public void editEmployeeDOBTest() {
		/*
		 * 1.   Launch Browser. 2.   Open
		 * http://opensource.demo.orangehrmlive.com/ 3.   Enter username - Admin
		 * 4.   Enter password - admin 5.   Click Login Button
		 */

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
		// 6.   Verify that login succeeds and we then go to the PIM Page.

		actualHomePageText = driver.findElement(By.id("welcome")).getText();

		if (actualHomePageText.equals(expectedHomePageText)) {

			System.out.println("Logon Successful");

			WebElement tabPIM = driver.findElement(By.linkText("PIM"));
			tabPIM.click();

			// 7.   Click on the Employee List SubMenu and Print out the URL

			WebElement subMenuEmployeeList = driver.findElement(By.id("menu_pim_viewEmployeeList"));
			subMenuEmployeeList.click();

			System.out.println("Print PIM -> Employee List URL : " + driver.getCurrentUrl());

			// 8.   Enter Employee Id in Id Box and Click Search Button

			WebElement empId = driver.findElement(By.id("empsearch_id"));
			empId.sendKeys(verifyEmpId);

			WebElement clickSearch = driver.findElement(By.id("searchBtn"));
			clickSearch.click();

			// 9.   Click on Employee Id field in the Result Table to open Emp
			// Details

			WebElement resultClick = driver.findElement(By.linkText(verifyEmpId));
			resultClick.click();

			// 10. Click Edit Button

			WebElement editClick = driver.findElement(By.id("btnSave"));
			editClick.click();

			// 11. Enter Date Of Birth as 5th December 1998
			// 12.  Click Save Button

			// Click calendar icon

			WebElement calendarBtn = driver.findElement(By.id("personal_DOB"));
			calendarBtn.click();

			// Select Birth Month

			Select selectMonth = new Select(driver
					.findElement(By.xpath(".//div[@id='ui-datepicker-div']//select[@class='ui-datepicker-month']")));
			selectMonth.selectByVisibleText("Dec");

			// Select Birth Year

			Select selectYear = new Select(driver
					.findElement(By.xpath(".//div[@id='ui-datepicker-div']//select[@class='ui-datepicker-year']")));
			selectYear.selectByVisibleText("1998");

			// Select Birth Date

			WebElement selectDate = driver
					.findElement(By.xpath(".//div[@id='ui-datepicker-div']//a[contains(text(),'5')]"));
			selectDate.click();

			WebElement clickSave = driver.findElement(By.id("btnSave"));
			clickSave.click();

			// 13. Verify that Confirmation Popup was shown (through automation)
			// 14. Wait for Success popup message to disappear
			// 15. Click Save Button

			WebDriverWait wait = new WebDriverWait(driver, 10);
			WebElement locatePopup = wait.until(ExpectedConditions
					.presenceOfElementLocated(By.xpath("//div[contains(@class, 'message success fadable')]")));

			System.out.println("Popup Message : " + locatePopup.getText());

			wait.until(ExpectedConditions
					.invisibilityOfElementLocated(By.xpath("//div[contains(@class, 'message success fadable')]")));

			// 16. Verify DOB is updated, by printing

			WebElement verifyDOB = driver.findElement(By.id("personal_DOB"));
			String actualDOB = verifyDOB.getAttribute("value");

			if (actualDOB.equals("1998-12-05")) {
				System.out.println("DOB has been verified : " + actualDOB);
			} else {
				System.out.println("DOB is incorrectly saved : " + actualDOB);
			}

		}

		else {
			System.out.println("Logon Failed");
		}

	}

	public void uploadEmployeeImage() {

		// 1.   Launch Browser.
		// 2.   Open http://opensource.demo.orangehrmlive.com/
		// 3.   Enter username - Admin
		// 4.   Enter password - admin
		// 5.   Click Login Button

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

		// 6.   Verify that login succeeds and we then go to the PIM Page.

		actualHomePageText = driver.findElement(By.id("welcome")).getText();

		if (actualHomePageText.equals(expectedHomePageText)) {

			System.out.println("Logon Successful");

			WebElement tabPIM = driver.findElement(By.linkText("PIM"));
			tabPIM.click();

			// 7.   Click on the Employee List SubMenu and Print out the URL

			WebElement subMenuEmployeeList = driver.findElement(By.id("menu_pim_viewEmployeeList"));
			subMenuEmployeeList.click();

			System.out.println("Print PIM -> Employee List URL : " + driver.getCurrentUrl());

			// 8.   Enter Employee Id in Id Box and Click Search Button

			WebElement empId = driver.findElement(By.id("empsearch_id"));
			empId.sendKeys(verifyEmpId);

			WebElement clickSearch = driver.findElement(By.id("searchBtn"));
			clickSearch.click();

			// 9.   Click on Employee Name field in the Result Table to open Emp
			// Details

			WebElement resultClick = driver.findElement(By.linkText("Ruby S"));
			resultClick.click();

			// 10. Click Edit Button

			WebElement editClick = driver.findElement(By.id("btnSave"));
			editClick.click();

			// 11. Click Employee Photo Icon

			WebElement clickPhotoIcon = driver.findElement(By.id("empPic"));

			Boolean imagePresent = (Boolean) ((JavascriptExecutor) driver).executeScript(
					"return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0",
					clickPhotoIcon);

			if (imagePresent) {
				System.out.println("Before upload - if" + clickPhotoIcon.getSize());
			} else {
				System.out.println("Before upload - else" + clickPhotoIcon.getSize());
			}

			clickPhotoIcon = driver.findElement(By.id("empPic"));

			clickPhotoIcon.click();

			// 12.  Upload any image from your pc to site using Choose File and
			// upload

			WebElement browseFile = driver.findElement(By.id("photofile"));
			browseFile.sendKeys("C:\\Users\\Abishek\\Desktop\\Employee Pic\\jeffrosejpg.jpg");

			WebElement uploadClick = driver.findElement(By.id("btnSave"));
			uploadClick.click();

			// 13. Verify that image is uploaded and shown - to verify this with
			// Sandeep??.
			clickPhotoIcon = driver.findElement(By.id("empPic"));

			imagePresent = (Boolean) ((JavascriptExecutor) driver).executeScript(
					"return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0",
					clickPhotoIcon);

			if (imagePresent) {
				System.out.println("The image is uploaded and shown" + clickPhotoIcon.getSize());
			} else {
				System.out.println("The image is uploaded but not shown");
			}

		} else {
			System.out.println("Logon Failed");
		}

	}

	public void deleteEmployeeTest() {

//1.   Launch Browser.
//2.   Open http://opensource.demo.orangehrmlive.com/
//3.   Enter username - Admin
//4.   Enter password - admin
//5.   Click Login Button
		
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

// 6.   Verify that login succeeds and we then go to the PIM Page.

		actualHomePageText = driver.findElement(By.id("welcome")).getText();

		if (actualHomePageText.equals(expectedHomePageText)) {

			System.out.println("Logon Successful");

			WebElement tabPIM = driver.findElement(By.linkText("PIM"));
			tabPIM.click();

// 7.   Click on the Employee List SubMenu and Print out the URL

			WebElement subMenuEmployeeList = driver.findElement(By.id("menu_pim_viewEmployeeList"));
			subMenuEmployeeList.click();

			System.out.println("Print PIM -> Employee List URL : " + driver.getCurrentUrl());

			
//	8.   Get count of total employees shown in the table and store in variable originalCount
			
			WebElement clickSearch = driver.findElement(By.id("searchBtn"));
			clickSearch.click();
			
			//Verify search results
			
			WebElement tblElement = driver.findElement(By.id("resultTable"));
					
			WebElement tbodyElement = tblElement.findElement(By.tagName("tbody"));
					
			List<WebElement> trList = tbodyElement.findElements(By.tagName("tr"));
					
			int originalCount = trList.size();

//	9.   Print the Count.
			
			System.out.println("Total original search Results: " + originalCount);		
			
//	10.  Using an employee ID, click on checkbox in the result table in front of empid row
//	11.  Click Delete button	
			
			WebElement clickCheckBox = driver.findElement(By.id("ohrmList_chkSelectRecord_11"));
			clickCheckBox.click();
			
			WebElement deleteBtn = driver.findElement(By.id("btnDelete"));
			deleteBtn.click();

//	12.  On confirmation dialog (Note:  This isn't an ALERT, you can inspect it) click OK button.
//	13.  Verify that Successfully Deleted momentary popup appears.
//	14.  Wait for popup to disappear.
			
			WebElement dialogDeleteBtn = driver.findElement(By.id("dialogDeleteBtn"));
			dialogDeleteBtn.click();

			WebDriverWait wait = new WebDriverWait(driver, 10);
			WebElement locatePopup = wait.until(ExpectedConditions
					.presenceOfElementLocated(By.xpath("//div[contains(@class, 'message success fadable')]")));

			System.out.println("Popup Message : " + locatePopup.getText());

			wait.until(ExpectedConditions
					.invisibilityOfElementLocated(By.xpath("//div[contains(@class, 'message success fadable')]")));
			
//	15.  Get count of rows in the results table and store in finalCount variable (int)
			
			//Verify search results
			
			tblElement = driver.findElement(By.id("resultTable"));
					
			tbodyElement = tblElement.findElement(By.tagName("tbody"));
					
			trList = tbodyElement.findElements(By.tagName("tr"));
					
			int finalCount = trList.size();

//16.   Print finalCount.
			
			System.out.println("Total final search Results: " + finalCount);	
			
//17.  If finalCount+1 is equal to originalCount, print Passed, otherwise print failed.	
			
			if((finalCount+1)== originalCount){
				
				System.out.println("Delete Employee Test Passed");
				
			} else {
				
				System.out.println("Delete Employee Test Failed");
				
			}

//18.  Also verify that employee id deleted just now isn't shown in the table anymore.	
			
			for(int i=0;i<trList.size();i++){
				
				List<WebElement> tdList = trList.get(i).findElements(By.tagName("td"));
				
				for( int j=1;j<tdList.size();j++){
					
										
					if(tdList.get(j).getText(). equals ("0011"))
					{
						System.out.println("The Employee deletion failed");
						
					}
					else{
						System.out.println("The Employee is deleted successfully");
						break;
					}
				 }
			 }
	
		} else {
			
			System.out.println("Logon Failed");
			
		}
	}

	public void downloadEmpImportFile() {
		

//		10.  Click upload to upload the same file again.
//		11.  Quit the browser
	    //Create FireFox Profile object
		FirefoxProfile profile = new FirefoxProfile();
        
        //Set Location to store files after downloading.
		profile.setPreference("browser.download.dir", "C:\\Users\\Abishek\\Documents");
		profile.setPreference("browser.download.folderList", 2);
        
		profile.setPreference("browser.helperApps.neverAsk.saveToDisk", 
			    " text/csv;"); 
		
		profile.setPreference( "browser.download.manager.showWhenStarting", false );
		profile.setPreference( "pdfjs.disabled", true );

//1.   	Launch Browser.
//2.   	Open http://opensource.demo.orangehrmlive.com/
//3.   	Enter username - Admin
//4.   	Enter password - admin
//5.   	Click Login Button
				
			WebDriver driver = new FirefoxDriver(profile);
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
	
// 6.   Verify that login succeeds and we then go to the PIM Page.
	
			actualHomePageText = driver.findElement(By.id("welcome")).getText();
	
			if (actualHomePageText.equals(expectedHomePageText)) {
	
				System.out.println("Logon Successful");
	
				WebElement tabPIM = driver.findElement(By.linkText("PIM"));
				tabPIM.click();
				
//7.   Hover mouse over Configuration SubMenu and Click Data Import		
				
				WebElement subMenuConfiguration = driver.findElement(By.id("menu_pim_Configuration"));
				
				Actions action = new Actions(driver);
				 
			    action.moveToElement(subMenuConfiguration).build().perform();
			 
		        driver.findElement(By.linkText("Data Import")).click();
			 
//8.   Click Download Link on CSV Data Import Page
//9.   Verify that file has been downloaded to the computer.
		 		 
				// Click to download 
				
		        driver.findElement(By.linkText("Download")).click();				
				
			} else {
				
				System.out.println("Logon Failed");
				
			}
		
	}
	
	public static void main(String[] args) throws InterruptedException {

		Week3EmployeeTests empTest = new Week3EmployeeTests();

		//empTest.addEmployeeTest();

		//empTest.editEmployeeDOBTest();

		//empTest.uploadEmployeeImage();

		//empTest.deleteEmployeeTest();
		
		empTest.downloadEmpImportFile();

	}



}
