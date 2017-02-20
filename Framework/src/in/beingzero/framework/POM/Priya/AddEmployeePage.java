package in.beingzero.framework.POM.Priya;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AddEmployeePage extends BasePage{

	String afirstname;
	String amiddlename;
	String alastname; 
	String aempIdValue ;

	public AddEmployeePage()
	{
		super();
	}
	
	public AddEmployeePage(WebDriver driver)
	{
		super(driver);
	}
	/*public AddEmployeePage(String afirstname,String amiddlename,String alastname)
	{
		this.afirstname = afirstname;
		this.amiddlename = amiddlename;
		this.alastname = alastname;
	}*/
	 
	public PersonalDetails addEmployeeDt(String afirstname,String amiddlename,String alastname, String aempIdValue)
	{
			System.out.println(afirstname+amiddlename+alastname);
			WebElement pim = driver.findElement(By.id("menu_pim_viewPimModule"));
			String pimhref = pim.getAttribute("href");
			driver.get(pimhref);
			System.out.println("PIM clicked");
		
			 //7. Click on the Add Employee subMenu and Print out the URL
			WebElement pimaddemp = driver.findElement(By.id("menu_pim_addEmployee"));
			String pimaddemphref = pimaddemp.getAttribute("href");
			driver.get(pimaddemphref);
			System.out.println("Add Employee clicked");
		
			String pimaddempurl = driver.getCurrentUrl();
			System.out.println("Add Employee URL : " + pimaddempurl);
		
			
			//8.Click and enter First Name
			//9.Click and enter Middle Name
			//10.Click and enter Last Name
			
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
			aempIdValue = empid.getAttribute("value");
			System.out.println("EMP ID :" + aempIdValue);
		
			//15.  Click Save
			WebElement savebtn = driver.findElement(By.id("btnSave"));
			savebtn.click();
			
			return new PersonalDetails(driver);
			
		}

}

