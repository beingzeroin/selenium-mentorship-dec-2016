package in.beingzero.prudhvi;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Week3EmployeeTests {
	String strURL="http://opensource.demo.orangehrmlive.com";
	String strUserName="Admin";
	String strPwd="admin";
	String strWelcomeMsg="Welcome "+strUserName;
	String strActualMsg="";
	WebDriver fd;
	
	public Boolean isLoginSucceed()
	{
		System.setProperty("webdriver.chrome.driver","E:\\SeleniumProject\\chromedriver.exe");
		fd=new ChromeDriver();
		fd.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		fd.manage().window().maximize();
		fd.get(strURL);
		fd.findElement(By.id("txtUsername")).sendKeys(strUserName);
		fd.findElement(By.id("txtPassword")).sendKeys(strPwd);
		fd.findElement(By.id("btnLogin")).click();
		strActualMsg=fd.findElement(By.id("welcome")).getText();
		if (strActualMsg.equalsIgnoreCase(strActualMsg))
		{
			return true;
		}
		else
		{	
			System.out.println("Login is Failed");
			return false;
			
		}
	}
	public void addEmployeeTest()
	{
		System.setProperty("webdriver.chrome.driver","E:\\SeleniumProject\\chromedriver.exe");
		WebDriver fd=new ChromeDriver();
		fd.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		fd.manage().window().maximize();
		fd.get(strURL);
		fd.findElement(By.id("txtUsername")).sendKeys(strUserName);
		fd.findElement(By.id("txtPassword")).sendKeys(strPwd);
		fd.findElement(By.id("btnLogin")).click();
		strActualMsg=fd.findElement(By.id("welcome")).getText();
		if (strActualMsg.equalsIgnoreCase(strActualMsg))
		{
			System.out.println("Login  is successfull");
			WebElement tabPIMLink=fd.findElement(By.id("menu_pim_viewPimModule"));
			tabPIMLink.click();
			
			WebElement addEmployeeLink=fd.findElement(By.id("menu_pim_addEmployee"));
			addEmployeeLink.click();
			
			System.out.println("Add Employeeweb Page URL: "+fd.getCurrentUrl());
			String strFirstName,strMiddleName,strLastName;
			strFirstName="Atul";
			strMiddleName="D";
			strLastName="Pawar";
			
			WebElement txtBoxFirstName=fd.findElement(By.id("firstName"));
			WebElement txtBoxMiddleName=fd.findElement(By.id("middleName"));
			WebElement txtBoxLastName=fd.findElement(By.id("lastName"));
			
			txtBoxFirstName.sendKeys(strFirstName);
			txtBoxMiddleName.sendKeys(strMiddleName);
			txtBoxLastName.sendKeys(strLastName);
			String strEmployeeId=fd.findElement(By.id("employeeId")).getAttribute("value");
			System.out.println("Employee Id is: "+strEmployeeId);
			fd.findElement(By.id("chkLogin")).click();
			
			WebElement txtBoxUserName=fd.findElement(By.id("user_name"));
			WebElement txtBoxPwd=fd.findElement(By.id("user_password"));
			WebElement txtBoxConfirmPwd=fd.findElement(By.id("re_password"));
			
			txtBoxUserName.sendKeys(strFirstName+strLastName);
			txtBoxPwd.sendKeys("MNS");
			txtBoxConfirmPwd.sendKeys("MNS");
			
			WebElement statusEmployee=fd.findElement(By.id("status"));
			Select statusSelect=new Select(statusEmployee);
			String strSeletedStatus=statusSelect.getFirstSelectedOption().getText();
			
			if (strSeletedStatus.equals("Enabled")) 
			{
				System.out.println("Print the selected Status: " + strSeletedStatus);
			} else {
				statusSelect.selectByVisibleText("Enabled");
			}
			
			fd.findElement(By.id("btnSave")).click();
			
			String strVerifyFirstName,strVerifyMiddleName,strVerifyLastName,strVerifyEmployeeId;
			
			strVerifyFirstName=fd.findElement(By.id("personal_txtEmpFirstName")).getAttribute("value");
			strVerifyMiddleName=fd.findElement(By.id("personal_txtEmpMiddleName")).getAttribute("value");
			strVerifyLastName=fd.findElement(By.id("personal_txtEmpLastName")).getAttribute("value");
			strVerifyEmployeeId=fd.findElement(By.id("personal_txtEmployeeId")).getAttribute("value");
			
			if(strVerifyFirstName.equals(strFirstName))
			{
				System.out.println("FirstName is verified:"+strVerifyFirstName);
			}
			else
			{
				System.out.println("FirstName is not as expected,expected :"+strFirstName+"Actual:"+strVerifyFirstName);
			}
			if(strVerifyMiddleName.equals(strMiddleName))
			{
				System.out.println("MiddleName is verified:"+strVerifyMiddleName);
			}
			else
			{
				System.out.println("MiddleName is not as expected,expected :"+strMiddleName+"Actual:"+strVerifyMiddleName);
			}
			if(strVerifyLastName.equals(strLastName))
			{
				System.out.println("LastName is verified:"+strVerifyLastName);
			}
			else
			{
				System.out.println("LastName is not as expected,expected :"+strLastName+"Actual:"+strVerifyLastName);
			}
			if(strVerifyEmployeeId.equals(strEmployeeId))
			{
				System.out.println("EmployeeId is verified:"+strVerifyEmployeeId);
			}
			else
			{
				System.out.println("Employeeid is not as expected,expected :"+strEmployeeId+"Actual:"+strVerifyEmployeeId);
			}
			
		}
	
		else
		{
			System.out.println("Login is Failed");
		}
	}
	
	public void editEmployeeDOBTest()

	{
		System.setProperty("webdriver.chrome.driver","E:\\SeleniumProject\\chromedriver.exe");
		WebDriver fd=new ChromeDriver();
		fd.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		fd.manage().window().maximize();
		fd.get(strURL);
		fd.findElement(By.id("txtUsername")).sendKeys(strUserName);
		fd.findElement(By.id("txtPassword")).sendKeys(strPwd);
		fd.findElement(By.id("btnLogin")).click();
		strActualMsg=fd.findElement(By.id("welcome")).getText();
		if (strActualMsg.equalsIgnoreCase(strActualMsg))
		{
			System.out.println("Login  is successfull");
			WebElement tabPIMLink=fd.findElement(By.id("menu_pim_viewPimModule"));
			tabPIMLink.click();
			
			WebElement linkEmployeeList=fd.findElement(By.id("menu_pim_viewEmployeeList"));
			linkEmployeeList.click();
			
			System.out.println("Eployee List web Page URL: "+fd.getCurrentUrl());
			
			String strEmployeeId="0004";
			fd.findElement(By.id("empsearch_id")).sendKeys(strEmployeeId);
			fd.findElement(By.id("searchBtn")).click();
			
			WebElement tblSearchResult=fd.findElement(By.id("resultTable"));
			WebElement tbodySearchResult=tblSearchResult.findElement(By.tagName("tbody"));
			List <WebElement> trList=tbodySearchResult.findElements(By.tagName("tr"));
			List <WebElement> tdList=trList.get(0).findElements(By.tagName("td"));
			WebElement employeeIdLink=tdList.get(1).findElement(By.tagName("a"));
			employeeIdLink.click();
			fd.findElement(By.id("btnSave")).click();
			WebElement dateEditBox=fd.findElement(By.id("personal_DOB"));
			dateEditBox.click();
			
			Select selectMonth=new Select(fd.findElement(By.className("ui-datepicker-month")));
			selectMonth.selectByVisibleText("Oct");
			

			Select selectYear=new Select(fd.findElement(By.className("ui-datepicker-year")));
			selectYear.selectByVisibleText("1965");

			WebElement selectDate = fd.findElement(By.xpath(".//div[@id='ui-datepicker-div']//a[contains(text(),'5')]"));
			selectDate.click();
			fd.findElement(By.id("btnSave")).click();
			WebElement popupMessage=fd.findElement(By.xpath("//*[@id='pdMainContainer']/div[2]/div"));
			
			System.out.println("Popup Message : " + popupMessage.getText());
			
			WebElement verifyDOB = fd.findElement(By.id("personal_DOB"));
			String strverifyDOB = verifyDOB.getAttribute("value");

			if (strverifyDOB.equals("1965-10-05")) {
				System.out.println("DOB has been verified : " + strverifyDOB);
			} else {
				System.out.println("DOB is incorrectly saved : " + strverifyDOB);
			}
			
		}
	
		else
		{
			System.out.println("Login is Failed");
		}

		
	}
	
	public void deleteEmployeeTest()

	{
		System.setProperty("webdriver.chrome.driver","E:\\SeleniumProject\\chromedriver.exe");
		fd=new ChromeDriver();
		fd.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		fd.manage().window().maximize();
		fd.get(strURL);
		fd.findElement(By.id("txtUsername")).sendKeys(strUserName);
		fd.findElement(By.id("txtPassword")).sendKeys(strPwd);
		fd.findElement(By.id("btnLogin")).click();
		strActualMsg=fd.findElement(By.id("welcome")).getText();
		
		if (strActualMsg.equalsIgnoreCase(strActualMsg))
		{
			System.out.println("Login  is successfull");
			WebElement tabPIMLink=fd.findElement(By.id("menu_pim_viewPimModule"));
			tabPIMLink.click();
			
			WebElement linkEmployeeList=fd.findElement(By.id("menu_pim_viewEmployeeList"));
			linkEmployeeList.click();
			
			System.out.println("Employee List web Page URL: "+fd.getCurrentUrl());
			
			WebElement tblSearchResult=fd.findElement(By.id("resultTable"));
			WebElement tbody=tblSearchResult.findElement(By.tagName("tbody"));
			List<WebElement> trList=tbody.findElements(By.tagName("tr"));
			int intOriginalCount=trList.size();
			String strEmpoyeeIdToDelete="0012";
			
			System.out.println(intOriginalCount);
			
			for(int rowIndex=0;rowIndex<intOriginalCount;rowIndex++)
			{
				List<WebElement> tdList=trList.get(rowIndex).findElements(By.tagName("td"));
				if(tdList.get(1).findElement(By.tagName("a")).getText().equals(strEmpoyeeIdToDelete))
				{
					tdList.get(0).findElement(By.tagName("input")).click();
					break;
				}			
				
			}
			fd.findElement(By.id("btnDelete")).click();
			
			fd.findElement(By.id("dialogDeleteBtn")).click();
			
			WebDriverWait objWait=new WebDriverWait(fd,30);
			WebElement deleteSuccess=objWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='message success fadable']")));
			System.out.println(deleteSuccess.getText());
			objWait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='message success fadable']")));
			boolean isRecordExist=false;
			 tblSearchResult=fd.findElement(By.id("resultTable"));
			 tbody=tblSearchResult.findElement(By.tagName("tbody"));
			 trList=tbody.findElements(By.tagName("tr"));
			for(int rowIndex=0;rowIndex<trList.size();rowIndex++)
			{	
				List<WebElement> tdList=trList.get(rowIndex).findElements(By.tagName("td"));
				if(tdList.get(1).findElement(By.tagName("a")).getText().equals(strEmpoyeeIdToDelete))
				{
					isRecordExist=true;
					System.out.println("Record with employee id:"+tdList.get(1).findElement(By.tagName("a")).getText() +" is found");
					break;
				}			
				
			}
			
			if(isRecordExist)
			{
				System.out.println("Record with employee Id: "+strEmpoyeeIdToDelete+"is not deleted");
			}
			else
			{
				System.out.println("Record with employee Id: "+strEmpoyeeIdToDelete+"is succeefully deleted");
			}
			
		}
		
		
		else
		{
			System.out.println("Login Failed");
			
		}
		
	}
	public void UploadEmployeeImage()
	{

		/*
		1.   Launch Browser.
		2.   Open http://opensource.demo.orangehrmlive.com/
		3.   Enter username - Admin
		4.   Enter password - admin
		5.   Click Login Button
		6.   Verify that login succeeds and we then go to the PIM Page.
		7.   Click on the Employee List SubMenu and Print out the URL
		8.   Enter Employee Id in Id Box and Click Search Button
		9.   Click on Employee Name field in the Result Table to open Emp Details
		10.  Click Edit Button
		11.  Click Employee Photo Icon
		12.  Upload any image from your pc to site using Choose File and upload
		13.  Verify that image is uploaded and shown. 
		*/
	
		if(isLoginSucceed())
		{
			fd.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			WebElement tabPIMLink=fd.findElement(By.id("menu_pim_viewPimModule"));
			tabPIMLink.click();

			WebElement linkEmployeeList=fd.findElement(By.id("menu_pim_viewEmployeeList"));
			linkEmployeeList.click();
			
			System.out.println("Employee List web Page URL: "+fd.getCurrentUrl());
			String strEmpoyeeIdToDelete="0006";
			fd.findElement(By.id("empsearch_id")).sendKeys(strEmpoyeeIdToDelete);
			fd.findElement(By.id("searchBtn")).click();
			
			WebElement tblSearchResult=fd.findElement(By.id("resultTable"));
			WebElement tbody=tblSearchResult.findElement(By.tagName("tbody"));
			List<WebElement> trList=tbody.findElements(By.tagName("tr"));			
			List<WebElement> tdList=trList.get(0).findElements(By.tagName("td"));
			tdList.get(1).findElement(By.tagName("a")).click();
			fd.findElement(By.id("btnSave")).click();	
			fd.findElement(By.id("empPic")).click();
			String profilePicPath = System.getProperty("user.dir").concat("/testData/profilePic.png");
			fd.findElement(By.id("photofile")).sendKeys(profilePicPath);
			fd.findElement(By.id("btnSave")).click();

			
		}
	}
}
