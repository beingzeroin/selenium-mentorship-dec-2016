package in.beingzero.framework.POM.Priya;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PersonalDetails extends BasePage{

	String afirstname;
	String amiddlename;
	String alastname;
	String empIdValue;

	public PersonalDetails()
	{
		super();
	}
	
	public PersonalDetails(WebDriver driver)
	{
		super(driver);
	}
	
	public PersonalDetails(String afirstname, String amiddlename, String alastname,String empIdValue) {
		this.afirstname = afirstname;
		this.amiddlename = amiddlename;
		this.alastname = alastname;
		this.empIdValue = empIdValue;
	}

	public void verifynewAddedEmp()
	{
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
