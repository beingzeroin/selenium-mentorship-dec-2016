package in.beingzero.prudhvi;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class WeekThreeExercisesSetOne {

	String strURL="http://opensource.demo.orangehrmlive.com";
	String strUserName="Admin";
	String strPwd="admin";
	String strWelcomeMsg="Welcome "+strUserName;
	String strActualMsg="";
	
	//WebDriver fd=new ChromeDriver();

	/*public void LoginHRM()
	{
		System.setProperty("webdriver.chrome.driver","E:\\SeleniumProject\\chromedriver.exe");
		fd.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		fd.get(strURL);
		fd.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		fd.findElement(By.id("txtUsername")).sendKeys(strUserName);
		fd.findElement(By.id("txtPassword")).sendKeys(strPwd);
		fd.findElement(By.id("btnLogin")).click();
		
	}*/
	@Test
	public void verifyResetFunctionality() throws InterruptedException

	{
		
		//LoginHRM();
		System.setProperty("webdriver.chrome.driver","E:\\SeleniumProject\\chromedriver.exe");
		WebDriver fd=new ChromeDriver();
		fd.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		fd.get(strURL);
		fd.findElement(By.id("txtUsername")).sendKeys(strUserName);
		fd.findElement(By.id("txtPassword")).sendKeys(strPwd);
		fd.findElement(By.id("btnLogin")).click();
		
		fd.findElement(By.id("menu_directory_viewDirectory")).click();
		//fd.findElement(By.xpath("//*[@id='menu_directory_viewDirectory']/b")).click();
		
		fd.findElement(By.id("searchDirectory_emp_name_empName")).sendKeys("Search Text");
		WebElement cboJobTitle=fd.findElement(By.id("searchDirectory_job_title"));
		WebElement cboLocation=fd.findElement(By.id("searchDirectory_location"));
		
		Select selectCboJobTitle= new Select(cboJobTitle);
		
		selectCboJobTitle.selectByVisibleText("IT Manager");
		Select selectCboLocation= new Select(cboLocation);
		selectCboLocation.selectByValue("3,1,2,-1");
		Thread.sleep(5000);
		fd.findElement(By.id("resetBtn")).click();
		cboJobTitle=fd.findElement(By.id("searchDirectory_job_title"));
		cboLocation=fd.findElement(By.id("searchDirectory_location"));
		selectCboJobTitle= new Select(cboJobTitle);
		selectCboLocation= new Select(cboLocation);
		String strJobTitle=selectCboJobTitle.getFirstSelectedOption().getText();
		String strJobLocation=selectCboLocation.getFirstSelectedOption().getText();
		System.out.println(strJobTitle+"  "+strJobLocation);
		
		if((strJobTitle.equalsIgnoreCase("All")&& strJobLocation.equalsIgnoreCase("All")))
		{
			System.out.println("Reset functionality is working as per expected");
			
		}
		else
		{
			
			System.out.println("Reset functionality is not working as per expected");
		}
		fd.quit();
		
	}
	@Test
	public void verifyTableResultsShownAsPerFilter() throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver","E:\\SeleniumProject\\chromedriver.exe");
		WebDriver fd=new ChromeDriver();
		fd.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		fd.get(strURL);
		fd.findElement(By.id("txtUsername")).sendKeys(strUserName);
		fd.findElement(By.id("txtPassword")).sendKeys(strPwd);
		fd.findElement(By.id("btnLogin")).click();
		
		fd.findElement(By.id("menu_directory_viewDirectory")).click();
		//fd.findElement(By.xpath("//*[@id='menu_directory_viewDirectory']/b")).click();
		
		String strSearchText="IT Manager";
		WebElement cboJobTitle=fd.findElement(By.id("searchDirectory_job_title"));
		Select selectCboJobTitle= new Select(cboJobTitle);
		selectCboJobTitle.selectByVisibleText(strSearchText);
		//Select selectCboLocation=new Select(fd.findElement(By.id("searchDirectory_job_title")));
		//selectCboLocation.selectByVisibleText("searchDirectory_location");
		//selectCboLocation.selectByValue("2");
		fd.findElement(By.id("searchBtn")).click();
		Thread.sleep(2000);
		
		WebElement tblResult=fd.findElement(By.id("resultTable"));
		WebElement tbodyElement=tblResult.findElement(By.tagName("tbody"));
		
		List <WebElement> trList=tbodyElement.findElements(By.tagName(("tr")));
		
		for(int rowIndex=1;rowIndex<trList.size();rowIndex++)
		{
			int rowNumber=rowIndex+1;
			List <WebElement> tdList=trList.get(rowIndex).findElements(By.tagName("td"));
			WebElement jobTitleLabel=fd.findElement(By.xpath("//*[@id='resultTable']/tbody/tr["+rowNumber+"]/td[2]/ul/li[2]"));
			if(jobTitleLabel.getText().equals(strSearchText))
			{
				System.out.println("Selected JobTitle and Result Job title are same");
			}
			else
			{
				System.out.println(jobTitleLabel.getText());
				System.out.println(strSearchText);
				System.out.println("Selected JobTitle and Result Job title are not same");
			}
			
		}
			
	fd.quit();
	
	
	}
}
