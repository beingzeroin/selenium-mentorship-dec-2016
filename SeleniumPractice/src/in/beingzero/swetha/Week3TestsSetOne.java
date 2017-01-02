package in.beingzero.swetha;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class Week3TestsSetOne {

	public static void main(String[] args) {
		
		verifyReset();
		//verifyJobTitleSearchResults();
		// Open OrageHRM
		
		// Click Directory Menu
		
		// Test 1
		// Fill SEarch Term
		// Select any item from dropdown of Job Title
		// Select any item from dropwdown of locaton
		// Click Reset
		// Verify that Textbox is clear and dropdown selection are back to original
		
		
		// Test 2
		// Select a job title from dropdown
		// Verify that all the table resutls are having seleced job title
		

	}

	private static void verifyJobTitleSearchResults() {
		WebDriver fd = new FirefoxDriver();
		fd.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		fd.manage().window().maximize();
		
		
		fd.get("http://opensource.demo.orangehrmlive.com");
		


		WebElement Username = fd.findElement(By.id("txtUsername"));
		Username.sendKeys("Admin");

		WebElement Password = fd.findElement(By.id("txtPassword"));
		Password.sendKeys("admin");

		WebElement Login = fd.findElement(By.id("btnLogin"));
		Login.click();
		
	}

	private static void verifyReset() {
		
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
		
		// Find WebElement "Job Title"
		WebElement jobTitle = fd.findElement(By.id("searchDirectory_job_title"));
				
		//Select for "Job Title"
		Select jobTitleSelect = new Select(jobTitle);

		//jobTitleSelect.selectByVisibleText("IT Executive");
		
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
		
		System.out.println("No of Rows = " + trList.size());
		
		//WebElement firstRow = trList.get(1);
		//List<WebElement> tdList = firstRow.findElements(By.tagName("td"));
		//System.out.println("No of Cols = " +tdList.size());
		
		for(int i=0;i<trList.size();i++){
			
			List<WebElement> tdList = trList.get(i).findElements(By.tagName("td"));
			
			//WebElement secondCol = tdList.get(i);
			 
			//List<WebElement> liList = secondCol.findElements(By.tagName("li"));
			for( int j=1;j<tdList.size();j++){
				
				List<WebElement> liList = tdList.get(j).findElements(By.tagName("li"));
				
				//for (int k=0;k<liList.size();k++){
				
				if(liList.get(j).getText(). equals ("IT Executive"))
				{
				System.out.println(liList.get(j).getText());
				}
				else{
					System.out.println("Print false" + j);
				}
			 }
		 }
	}
	
}	
//if(tdList.get(i).getText(). equals ("IT Executive")){
//System.out.println(tdList.get(i).getText());

		

