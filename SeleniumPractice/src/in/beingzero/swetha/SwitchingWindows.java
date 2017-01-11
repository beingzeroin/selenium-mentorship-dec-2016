package in.beingzero.swetha;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
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
	
	@Test
	public void switchingWindowsExercise2()
	{	
		driver.get("http://beingzero.in/selenium/selenium-java/selenium-switching-windows");
		
		String originalWindowHandle = driver.getWindowHandle();
		
		System.out.println("Original Window Title " + driver.getTitle());
		System.out.println("Original Window URL " + driver.getCurrentUrl());
		
		Set<String> handles = driver.getWindowHandles();
		
		
		System.out.println("Total Windows Before Clicking Link: "+handles.size());
		driver.findElement(By.linkText("Selenium New Tab Page")).click();
	
		handles = driver.getWindowHandles();
		
		System.out.println("Total Windows After Clicking Link(Selenium New Tab Page): "+handles.size());
		System.out.println("New Window Title " + driver.getTitle());
		System.out.println("New Window URL " + driver.getCurrentUrl());
		
		
		System.out.println("Switching to new window");
		for(String h : handles){
			
			if(!h.equals(originalWindowHandle))
			{
				String seleniumtab = (driver.switchTo().window(h)).toString();
				
				System.out.println("New Window Title(within if) " + driver.getTitle());
				System.out.println("New Window URL(within if) " + driver.getCurrentUrl());
				
//				driver.close();
							
				Set<String> tabhandles = driver.getWindowHandles();
				
				driver.findElement(By.linkText("Terms and Conditions")).click();
				
				tabhandles = driver.getWindowHandles();
				for(String hT : tabhandles){
					
					if(!hT.equals(originalWindowHandle)&&(!hT.equals(seleniumtab))){
						
						driver.switchTo().window(hT);
						System.out.println("Total Windows After Clicking Link(Terms and Conditions): "+tabhandles.size());
						System.out.println("New Window Title " + driver.getTitle());
						System.out.println("New Window URL " + driver.getCurrentUrl());
						
					}			
				}
				driver.switchTo().window(originalWindowHandle);
				
				System.out.println("Original Window Title " + driver.getTitle());
				System.out.println("Original Window URL " + driver.getCurrentUrl());
			}
			
			
		}
		
		//driver.quit();
		
	}

}
