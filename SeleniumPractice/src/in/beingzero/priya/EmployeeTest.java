package in.beingzero.priya;

import java.io.File;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;


public class EmployeeTest extends BeforeAfterTestNG{

		String ohrmURL = "http://opensource.demo.orangehrmlive.com";
		String userName = "Admin";
		String passWord = "admin";
		String userIDtxt = "txtUsername";
		String passWordtxt = "txtPassword";
		String loginBtn = "btnLogin";
		String empIdValue = "0001";
		String profilePicPath = System.getProperty("user.dir").concat("\\testData\\profilePic.png");
		String downloadDirectory = System.getProperty("user.dir") + "/priya_download";
		
		
		boolean loginCheck(String userNme, String passWd)
		{					
			driver.get(ohrmURL);
			WebElement userId = driver.findElement(By.id(userIDtxt));
			userId.clear();
			userId.sendKeys(userName);
		
			WebElement password = driver.findElement(By.id(passWordtxt));
			password.clear();
			password.sendKeys(passWord);
		
			WebElement Login = driver.findElement(By.id(loginBtn));
			Login.click();
			
			String Actuallogger = driver.findElement(By.id("welcome")).getText();
			String Expectedlogger = "Welcome Admin";
		
			//Verify Welcome is displayed
			if(Actuallogger.equals(Expectedlogger))
			{
				System.out.println("Login succeeded for User : " + userNme);
				return true;
			}
			else
			{
				System.out.println("Login Failed for User : " + userNme);
				return false;
			}
		
			
		}	
		
		//@Test
		public void addEmployeeTest()
		{
			if (loginCheck("admin","admin"))
			{
				WebElement pim = driver.findElement(By.id("menu_pim_viewPimModule"));
				String pimhref = pim.getAttribute("href");
				driver.get(pimhref);
				System.out.println("PIM clicked");
			
				 //7. Click on the Add Employee�SubMenu and Print out the URL
				WebElement pimaddemp = driver.findElement(By.id("menu_pim_addEmployee"));
				String pimaddemphref = pimaddemp.getAttribute("href");
				driver.get(pimaddemphref);
				System.out.println("Add Employee clicked");
			
				String pimaddempurl = driver.getCurrentUrl();
				System.out.println("Add Employee URL : " + pimaddempurl);
			
				String afirstname = "TestFirst3";
				String amiddlename = "TestMid3";
				String alastname = "Testlast3";
				String addEmpUNme = "BZTest3";
				String addEmpPwd = "BZTest3";
				
				//8.�� Click and enter First Name
				//9.�� Click and enter Middle Name
				//10.  Click and enter Last Name
				WebElement firstname = driver.findElement(By.id("firstName"));
				firstname.click();
				firstname.sendKeys(afirstname);
			
				
				WebElement middlename = driver.findElement(By.id("middleName"));
				middlename.click();
				middlename.sendKeys(amiddlename);
		
				
				WebElement lastname = driver.findElement(By.id("lastName"));
				lastname.clear();
				lastname.sendKeys(alastname);
			
				//11.  Print Employee ID (which is auto generated field)
				WebElement empid = driver.findElement(By.id("employeeId"));
				empIdValue = empid.getAttribute("value");
				System.out.println("EMP ID :" + empIdValue);
			
				//12.  Check 'Create Login Details'
				//13.  Enter username, password, confirm password
				WebElement logindetails = driver.findElement(By.id("chkLogin"));
				logindetails.click();
			
				WebElement username = driver.findElement(By.id("user_name"));
				username.clear();
				username.sendKeys(addEmpUNme);
			
				WebElement addPassword = driver.findElement(By.id("user_password"));
				addPassword.clear();
				addPassword.sendKeys(addEmpPwd);
			
				WebElement repassword = driver.findElement(By.id("re_password"));
				repassword.clear();
				repassword.sendKeys(addEmpPwd);

				//14.	Verify that in dropdown Enabled is selected
				WebElement status = driver.findElement(By.id("status"));
				Select statusOption = new Select(status);
				String firstSelStatus = statusOption.getFirstSelectedOption().getText();
				System.out.println("First selected option of status :"+ firstSelStatus);
				
				if (!firstSelStatus.equals("Enabled")) {
					System.out.println("Selected Status MUST have been Enabled");
				}

				//15.  Click Save
				WebElement savebtn = driver.findElement(By.id("btnSave"));
				savebtn.click();
			
				// 16. Verify Employee Details are correct -
				// Validate FirstName, Middle Name, LAst Name and Employee ID
				
				WebElement valfirstname = driver.findElement(By.id("personal_txtEmpFirstName"));
				String valfirstnamevalue = valfirstname.getAttribute("value");
				System.out.println("Val firstame :" + valfirstnamevalue);
				if(valfirstnamevalue.equals(afirstname))
				{
					System.out.println("Firtsname validated");
				}
				else
				{
					System.out.println("Firstname is not validated");
				}
			
				WebElement valmiddlename = driver.findElement(By.id("personal_txtEmpMiddleName"));
				String valmidnamevalue = valmiddlename.getAttribute("value");
				System.out.println("Val middleame :" + valmidnamevalue);
				if(valmidnamevalue.equals(amiddlename))
				{
					System.out.println("Middlename validated");
				}
				else
				{
					System.out.println("Middlename is not validated");
				}

				WebElement vallastname = driver.findElement(By.id("personal_txtEmpLastName"));
				String vallastnamevalue = vallastname.getAttribute("value");
				System.out.println("Val lastname :" + vallastnamevalue);
				if(vallastnamevalue.equals(alastname))
				{
					System.out.println("lastname validated");
				}
				else
				{
					System.out.println("Lastname is not validated");
				}
			
				WebElement valempid = driver.findElement(By.id("personal_txtEmployeeId"));
				String valempidvalue = valempid.getAttribute("value");
				System.out.println("Val EmpID :" + valempidvalue);
				if(valempidvalue.equals(empIdValue))
				{
					System.out.println("EmpID validated");
				}
				else
				{
					System.out.println("EmpID is not validated");
				}

			}
		}
		
		//@Test
		public void editEmployeeDOBTest()
		{
			if(loginCheck("admin","admin"))
			{
							
				//6.�� Verify that login succeeds and we then go to the PIM Page.
				//7.�� Click on the Employee List�SubMenu and Print out the URL
				Actions builder = new Actions(driver);
				WebElement pim = driver.findElement(By.id("menu_pim_viewPimModule"));
				builder.moveToElement(pim).build().perform();
			
				WebElement pimemplist = driver.findElement(By.id("menu_pim_viewEmployeeList"));
				String pimemplisthref = pimemplist.getAttribute("href");
				driver.get(pimemplisthref);
				System.out.println("PIM Emp List Clicked");
				
				String pimaemplisturl = driver.getCurrentUrl();
				System.out.println("Employee List URL : " + pimaemplisturl);
			
				//8.�� Enter Employee Id in Id Box and Click Search Button
				WebElement emplistempid = driver.findElement(By.id("empsearch_id"));
				emplistempid.clear();
				emplistempid.sendKeys(empIdValue);
				
				WebElement searchbtn = driver.findElement(By.id("searchBtn"));
				searchbtn.click();
				
				//9.�� Click on Employee Id field in the Result Table to open Emp Details
				//10.  Click Edit Button
				WebElement searchedempid = driver.findElement(By.xpath("//*[@id='resultTable']/tbody/tr/td[2]/a"));
				String searchedempidurl = searchedempid.getAttribute("href");
				driver.get(searchedempidurl);
				
				WebElement editbtn = driver.findElement(By.id("btnSave"));
				editbtn.click();
				
				//11.  Enter Date Of Birth as 5th December 1998
				WebElement dob = driver.findElement(By.id("personal_DOB"));
				dob.click();
				
				WebElement dobyear = driver.findElement(By.className("ui-datepicker-year"));
				Select seldobyear = new Select(dobyear);
				seldobyear.selectByValue("1998");
				
				WebElement dobmonth = driver.findElement(By.className("ui-datepicker-month"));
				Select seldobmonth = new Select(dobmonth);
				seldobmonth.selectByValue("11");
				
				WebElement dobdate = driver.findElement(By.xpath("//*[@id='ui-datepicker-div']/table/tbody/tr[1]/td[6]/a"));
				dobdate.click();
				
				//12.� Click Save Button
				driver.findElement(By.id("btnSave")).click();
				
				//13.	Wait for "Successfully Saved" popup message appear.
				
				WebDriverWait saveBtnWt = new WebDriverWait(driver,30);
				WebElement sveSuccessMsg = saveBtnWt.until(ExpectedConditions.
						presenceOfElementLocated(By.xpath("//div[@class='message success fadable']")));
				System.out.println("Successfully Saved Message Appeared");
				System.out.println(sveSuccessMsg.getText());
				
				//14.	Wait for "Successfully Saved" popup message disappear.
				saveBtnWt.until(ExpectedConditions.
						invisibilityOfElementLocated(By.xpath("//div[@class='message success fadable']")));
				
				//15.  Verify DOB is updated, by printing
				System.out.println(driver.findElement(By.id("personal_DOB")).getAttribute("value"));
			}
		}
		
		//@Test
		public void uploadEmployeeImage()
		{
			if(loginCheck("admin","admin"))
			{
				
				//6.�� Verify that login succeeds and we then go to the PIM Page.
				//7.�� Click on the Employee List�SubMenu and Print out the URL
				
				driver.findElement(By.id("menu_pim_viewPimModule")).click();
				driver.findElement(By.id("menu_pim_viewEmployeeList")).click();
				
				System.out.println("Employee List URL : " + driver.getCurrentUrl());
			
				//8.�� Enter Employee Id in Id Box and Click Search Button
				driver.findElement(By.id("empsearch_id")).sendKeys(empIdValue);
				
				
				driver.findElement(By.id("searchBtn")).click();
				
				//9.�� Click on Employee Id field in the Result Table to open Emp Details
				//10.  Click Edit Button
				WebElement searchedempid = driver.findElement(By.xpath("//*[@id='resultTable']/tbody/tr/td[3]/a"));
				String searchedempidurl = searchedempid.getAttribute("href");
				driver.get(searchedempidurl);
				
				driver.findElement(By.id("btnSave")).click();;
				WebElement profilePic = driver.findElement(By.id("empPic"));
				Boolean ImagePresent = (Boolean) ((JavascriptExecutor)driver).
						executeScript("return arguments[0].complete && typeof arguments[0]."
								+ "naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0", profilePic);
				if 	(!ImagePresent)
				{
					System.out.println("Profile pic is not present");
					
				}
				else
				{
					System.out.println("Profile pic is already present");
				}
				
				//11.	Click Employee Photo Icon
				System.out.println("Profile Pic Path : "+ profilePicPath) ;
				profilePic.click();
				
				//12.� Upload any image from your pc to site using Choose File and upload
				WebElement profilePicUpload = driver.findElement(By.id("photofile"));
				profilePicUpload.sendKeys(profilePicPath);
				
				driver.findElement(By.id("btnSave")).click();
								
				//13.	Verify that image is uploaded and shown.
				System.out.println("Profile pic uploaded : "+ driver.findElement(By.id("empPic")).isDisplayed());
				
			}
		}
		
		//@Test
		public void deleteEmployeeTest()
		{
			if(loginCheck("admin","admin"))
			{
				//6.�� Verify that login succeeds and we then go to the PIM Page.
				//7.�� Click on the Employee List�SubMenu and Print out the URL
				driver.findElement(By.id("menu_pim_viewPimModule")).click();
				driver.findElement(By.id("menu_pim_viewEmployeeList")).click();
				
				System.out.println("Employee List URL : " + driver.getCurrentUrl());
				
				//8.�� Get count of total employees shown in the table and store in variable originalCount
				
				WebElement tblreslt = driver.findElement(By.id("resultTable"));
				WebElement tblrsltbdy = tblreslt.findElement(By.tagName("tbody"));
				
				List<WebElement> originalCount =  tblrsltbdy.findElements(By.tagName("tr"));
				//9.   Print the Count.
				int countOrg = originalCount.size();
				System.out.println("Total No. of rows : "+ originalCount.size());
				
				//10.  Using an employee ID, click on checkbox in the result table in front of empid row
				//Checkbox is selecteing Dynamically based on the value of emp id by skipping the leading zero's from empid
				String fmtEmpID = empIdValue.replaceAll("^0*", "");
				System.out.println("Formatted EMPID value : "+ fmtEmpID);
				
				//driver.findElement(By.xpath("//*[@id='ohrmList_chkSelectRecord_10']")).click();
				driver.findElement(By.xpath("//*[@id='ohrmList_chkSelectRecord_"+fmtEmpID+"']")).click();
				
				
				//11.  Click Delete button
				driver.findElement(By.id("btnDelete")).click();
				
				//12.  On confirmation dialog (Note:  This isn't an ALERT, you can inspect it) click OK button.
				driver.findElement(By.id("dialogDeleteBtn")).click();
				
				//13.  Verify that Successfully Deleted momentary popup appears.
				WebDriverWait wtdlt = new WebDriverWait(driver,20);
				String dltMsg = wtdlt.until(ExpectedConditions.
						presenceOfElementLocated(By.xpath("//div[@class='message success fadable']"))).getText();
				System.out.println("Message appeared: " + dltMsg);
				
				//14.  Wait for popup to disappear.
				wtdlt.until(ExpectedConditions.
						invisibilityOfElementLocated(By.xpath("//div[@class='message success fadable']")));
				
				//15.  Get count of rows in the results table and store in finalCount variable (int)
				
				WebElement tblrsltaftdeel = driver.findElement(By.id("resultTable"));
				WebElement tblrsltbdyaftdel = tblrsltaftdeel.findElement(By.tagName("tbody"));
				
				List<WebElement> finalCount =  tblrsltbdyaftdel.findElements(By.tagName("tr"));
				System.out.println("Total No. of rows : "+ finalCount.size());
				
				//17. If finalCount+1 is equal to originalCount, print Passed, otherwise print failed. 
				
				int countSame = finalCount.size()+1;
				if(countOrg == countSame)
				{
					System.out.println("Passed");
				}
				else
				{
					System.out.println("Failed");
				}
						
				//18. Also verify that employee id deleted just now isn't shown in the table anymore.
				int glist =1;
				for(int i=0;i<finalCount.size();i++)
				{
					//List<WebElement> tblcols = finalCount.get(i).findElements(By.tagName("td"));
					WebElement empIDV = driver.findElement(By.xpath
							("//*[@id='resultTable']/tbody/tr["+glist+"]/td[2]/a"));
					String empIDVtxt = empIDV.getText();
					if (empIDVtxt.equals(empIdValue))
					{
						System.out.println("Employee is not deleted");
					}
					glist = glist +1;
				}
				System.out.println("Employee is deleted");
			}
			
		}

		@Test
		public void downloadEmpImportFile() throws Exception{
			if(loginCheck("admin","admin"))
			{
				//6.�� Verify that login succeeds and we then go to the PIM Page.
				//7.�� Hover mouse over Configuration SubMenu and Click Data Import
				
				Actions builder = new Actions(driver);
				driver.findElement(By.id("menu_pim_viewPimModule")).click();
				WebElement pimcfg = driver.findElement(By.id("menu_pim_Configuration"));
				builder.moveToElement(pimcfg).build().perform();
				driver.findElement(By.id("menu_admin_pimCsvImport")).click();
				
				//8.�� Click Download Link on CSV Data Import Page
				driver.findElement(By.className("download")).click();
				
				//9.   Verify that file has been downloaded to the computer.
				System.out.println("Download directory path : "+downloadDirectory);
				File dwDir = new File(downloadDirectory);
				File[] dwDirCnt = dwDir.listFiles();

				for (int i = 0; i < dwDirCnt.length; i++) {
					if (dwDirCnt[i].getName().equals("importData.csv"))
						System.out.println("File downloaded successfully");
				}

				//10.  Click upload to upload the same file again.
				//11.  Quit the browser
				
				WebElement browse = driver.findElement(By.id("pimCsvImport_csvFile"));
				browse.sendKeys(downloadDirectory + "importData.csv");
				Thread.sleep(1000);
			
				driver.findElement(By.id("btnSave")).click();
				System.out.println("File Uploaded successfully");
			}
		}
	
}			



