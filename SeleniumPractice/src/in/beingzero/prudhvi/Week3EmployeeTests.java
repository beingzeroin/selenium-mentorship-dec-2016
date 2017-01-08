package in.beingzero.prudhvi;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Week3EmployeeTests {
	String strURL="http://opensource.demo.orangehrmlive.com";
	String strUserName="Admin";
	String strPwd="admin";
	String strWelcomeMsg="Welcome "+strUserName;
	String strActualMsg="";
	
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

}
