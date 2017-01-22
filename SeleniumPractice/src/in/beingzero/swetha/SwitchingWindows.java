package in.beingzero.swetha;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.firefox.FirefoxDriver;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class SwitchingWindows {
	
	WebDriver driver;
	
	@BeforeMethod
	public void setup()
	{
		// Launch browser
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();

	}
	
	@AfterMethod
	public void cleanup()
	{
		// Quit browser
		driver.quit();
	}
	

	public void switchingWindowsExercise1()
	{	
		driver.get("http://www.popuptest.com/");
		//driver.findElement(By.linkText("Multi-PopUp Test")).click();
		
		String originalWindowHandle = driver.getWindowHandle();
		
		System.out.println("Original Window Title " + driver.getTitle());
		System.out.println("Original Window URL " + driver.getCurrentUrl());
		
		Set<String> handles = driver.getWindowHandles();
		
		
		System.out.println("Total Windows Before Clicking Link: "+handles.size());
		driver.findElement(By.linkText("Multi-PopUp Test")).click();
		
		// Make Sure two windows are there
		handles = driver.getWindowHandles();
		System.out.println("Total Windows After Clicking Link: "+handles.size());
		
		
		System.out.println("Switching to new window");
		for(String h : handles){
			
			if(!h.equals(originalWindowHandle))
			{
				// Switch to this winodw
				driver.switchTo().window(h);
				
				System.out.println("New Window Title " + driver.getTitle());
				System.out.println("New Window URL " + driver.getCurrentUrl());
				
				driver.close();
							
				driver.switchTo().window(originalWindowHandle);
				
				System.out.println("Original Window Title " + driver.getTitle());
				System.out.println("Original Window URL " + driver.getCurrentUrl());
			}
			
		}
		
		
		//driver.quit();
		
	}
	
	
	public void switchingWindowsExercise2()
	{	

//	    Using Selenium Launch Browser		
		
		driver.get("http://beingzero.in/selenium-new-tab");
		
		String originalWindowHandle = driver.getWindowHandle();
		
		System.out.println("Original Window Title " + driver.getTitle());
		System.out.println("Original Window URL " + driver.getCurrentUrl());
		
		Set<String> handles = driver.getWindowHandles();
				
		System.out.println("Total Windows Before Clicking Link: "+handles.size());
		
//	    Click Terms and Conditions link on the page.
		driver.findElement(By.linkText("Terms and Conditions")).click();

		handles = driver.getWindowHandles();
		
//	    Verify that a new browser window or tab is launched.

		System.out.println("Total Windows After Clicking Link(Terms and Conditions): "+handles.size());		
		
//	    Switch to newly opened window.
		
		System.out.println("Switching to new tab");
		
		for(String h : handles){
			
			if(!h.equals(originalWindowHandle))
			{
				
				driver.switchTo().window(h);			

//			    Print the Current URL and Title after switching.
				
				System.out.println("New tab Title " + driver.getTitle());
				System.out.println("New tab URL " + driver.getCurrentUrl());
							
//			    Click Agree button.
				
				driver.findElement(By.id("acceptBtn")).click();
				
				driver.switchTo().window(originalWindowHandle);
//			    Switch back to main window.
//			    Print Current URL and Title.
				
				System.out.println("Original Window Title " + driver.getTitle());
				System.out.println("Original Window URL " + driver.getCurrentUrl());
				
			}
				
		}	
							
}	
	@Test
	public void switchingWindowsExercise2Tabs3()
	{	
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		driver.get("http://beingzero.in/selenium/selenium-java/selenium-switching-windows");
		
		String mainWindowHandle = driver.getWindowHandle();
		
		System.out.println("Original Window Title " + driver.getTitle());
		System.out.println("Original Window URL " + driver.getCurrentUrl());
		
		
		Set<String> handles = driver.getWindowHandles();
		
		
		System.out.println("Total Windows Before Clicking Link: "+handles.size());
		driver.findElement(By.linkText("Selenium New Tab Page")).click();
		
		// Make Sure two windows are there
		handles = driver.getWindowHandles();
		System.out.println("Total Windows After Clicking Link: "+handles.size());
		
		
		System.out.println("Switching to new window");
		for(String h : handles){
			
			if(!h.equals(mainWindowHandle))
			{
				// Switch to this winodw
				driver.switchTo().window(h);
				
				System.out.println("New Window Title " + driver.getTitle());
				System.out.println("New Window URL " + driver.getCurrentUrl());
				
				WebElement tab3= driver.findElement(By.linkText("Terms and Conditions"));
				tab3.click();
				
				String tabHandle = driver.getWindowHandle();
				
				driver.switchTo().window(tabHandle);
				
				System.out.println("New Window Title (Terms and Conditions) " + driver.getTitle());
				System.out.println("New Window URL (Terms and Conditions) " + driver.getCurrentUrl());
				
				driver.switchTo().window(mainWindowHandle);
				
				System.out.println("Original Window Title " + driver.getTitle());
				System.out.println("Original Window URL " + driver.getCurrentUrl());
			}
			
		}
		
		
		driver.quit();
	}
	

	public void switchFrames()
	{
		WebDriver driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		driver.get("https://jqueryui.com/autocomplete");
		
		WebElement frameElement = driver.findElement(By.xpath("//div[@id='content']/iframe[@class='demo-frame']"));

		driver.switchTo().frame(frameElement);
		
		WebElement tagsTextBox =  driver.findElement(By.id("tags"));
		
		tagsTextBox.sendKeys("test");
		
		System.out.println(tagsTextBox.getAttribute("value"));
		
		driver.switchTo().defaultContent();// Bring Context of driver back to main page code
		
		//driver.quit();
	}
	
}

		



