package in.beingzero.swetha;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

//TODO:  SWETHA  Make it TestNG Compliant.  Separate Setup and Cleanup as well.
public class Week3TestsSetOne {

	public static void main(String[] args) throws InterruptedException {
		
		verifyReset();
		verifyJobTitleSearchResults();

	}

	private static void verifyReset() throws InterruptedException {
		WebDriver fd = new ChromeDriver();
		fd.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		fd.manage().window().maximize();
		
		
		fd.get("http://opensource.demo.orangehrmlive.com");
		
		WebElement Username = fd.findElement(By.id("txtUsername"));
		Username.sendKeys("Admin");

		WebElement Password = fd.findElement(By.id("txtPassword"));
		Password.sendKeys("admin");

		WebElement Login = fd.findElement(By.id("btnLogin"));
		Login.click();
		
		WebElement directoryTab = fd.findElement(By.id("menu_directory_viewDirectory"));
		directoryTab.click();
		
		// Fill Search textbox
		WebElement empName = fd.findElement(By.id("searchDirectory_emp_name_empName"));
		empName.sendKeys("Hannah");
				
		//Select a value from "Job Title" dropdown
		
		WebElement jobTitle = fd.findElement(By.id("searchDirectory_job_title"));
				
		Select jobTitleSelect = new Select(jobTitle);

		jobTitleSelect.selectByVisibleText("IT Executive");
		
		System.out.println( "The Job Title dropdown '" + jobTitleSelect.getFirstSelectedOption().getText() + "' is selected");
		
		
		// Select a value from "Location" dropdown
		
		WebElement location = fd.findElement(By.id("searchDirectory_location"));
				
		Select locationSelect = new Select(location);

		locationSelect.selectByVisibleText("    Canadian Development Center");
		
		System.out.println( "The Location dropdown '" + locationSelect.getFirstSelectedOption().getText() + "' is selected" );
		
		//Click on Search Button
		
		WebElement searchBtn = fd.findElement(By.id("searchBtn"));
		searchBtn.click();
				
		//Verify search results
		
		WebElement tblElement = fd.findElement(By.id("resultTable"));
				
		WebElement tbodyElement = tblElement.findElement(By.tagName("tbody"));
				
		List<WebElement> trList = tbodyElement.findElements(By.tagName("tr"));
				
		System.out.println("Total Search Results: " + (trList.size()-1));		
		
		//Verify Reset functionality
		
		WebElement resetBtn = fd.findElement(By.id("resetBtn"));
		resetBtn.click();
		
		//Verify the default value of "Job Title" dropdown
		
		jobTitle = fd.findElement(By.id("searchDirectory_job_title"));
		Select jobTitleResetSelect = new Select(jobTitle);
		String jobTitleDefault = jobTitleResetSelect.getFirstSelectedOption().getText(); 
		
		if(jobTitleDefault.equals("All")){
			System.out.println("The 'Job Title dropdown' is resetted to default value: " + jobTitleDefault);
		}
		
		//Verify the default value of "Location" dropdown
		
		location = fd.findElement(By.id("searchDirectory_job_title"));
		Select locationResetSelect = new Select(location);
		String locationDefault = locationResetSelect.getFirstSelectedOption().getText(); 
		
		if(locationDefault.equals("All")){
			System.out.println("The 'Location dropdown' is resetted to default value: " + locationDefault);
		}
				
		// Check whether input field is blank
		
		empName = fd.findElement(By.id("searchDirectory_emp_name_empName"));
		empName.click();
		String textInsideEmpName = empName.getAttribute("value");
		if(textInsideEmpName.isEmpty())
		{
		  System.out.println("The 'Name' input field is empty");
		}
		
	}

	private static void verifyJobTitleSearchResults() {
		
		WebDriver fd = new ChromeDriver();
		fd.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		fd.manage().window().maximize();
				
		fd.get("http://opensource.demo.orangehrmlive.com");
		
		WebElement Username = fd.findElement(By.id("txtUsername"));
		Username.sendKeys("Admin");

		WebElement Password = fd.findElement(By.id("txtPassword"));
		Password.sendKeys("admin");

		WebElement Login = fd.findElement(By.id("btnLogin"));
		Login.click();
		
		WebElement directoryTab = fd.findElement(By.id("menu_directory_viewDirectory"));
		directoryTab.click();
		
		WebElement empName = fd.findElement(By.id("searchDirectory_emp_name_empName"));
		//empName.sendKeys("Hannah");
		empName.sendKeys("dina");
		
		// Find WebElement "Job Title"
		WebElement jobTitle = fd.findElement(By.id("searchDirectory_job_title"));
				
		//Select for "Job Title"
		Select jobTitleSelect = new Select(jobTitle);

		jobTitleSelect.selectByVisibleText("IT Executive");
				
		String selectedJobTitle = jobTitleSelect.getFirstSelectedOption().getText();
		
		// Find WebElement "Location"
		WebElement location = fd.findElement(By.id("searchDirectory_location"));
				
		//Select for "Job Title"
		Select locationSelect = new Select(location);

		locationSelect.selectByVisibleText("    Canadian Development Center");
		
		WebElement searchBtn = fd.findElement(By.id("searchBtn"));
		searchBtn.click();
		
		//Verify search results
		
		WebElement tblElement = fd.findElement(By.id("resultTable"));
		
		WebElement tbodyElement = tblElement.findElement(By.tagName("tbody"));
		
		List<WebElement> trList = tbodyElement.findElements(By.tagName("tr"));
		
		System.out.println("No of Rows = " + (trList.size()-1));
				
		for(int i=0;i<trList.size();i++){
			
			List<WebElement> tdList = trList.get(i).findElements(By.tagName("td"));
			
			for( int j=1;j<tdList.size();j++){
				
				List<WebElement> liList = tdList.get(j).findElements(By.tagName("li"));
				
				if(liList.get(j).getText(). equals (selectedJobTitle))
				{
					System.out.println("The job title is validated");
				}
				else{
					System.out.println("The search results contains incorrect data");
				}
			 }
		 }
	}
}	


		

