package in.beingzero.sandeep;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SwitchingCommands {
	
	public void switchAlerts()
	{
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		driver.get("http://beingzero.in/selenium/selenium-java/selenium-alerts-handling");
		
		driver.findElement(By.id("btnMsgAlert")).click();
		
		Alert al = driver.switchTo().alert();
		
		String txt = al.getText();
		
		System.out.println("Alert says "+txt);
		
		al.accept();
		
		driver.quit();
	}
	
	public void switchWindows()
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
				
				driver.findElement(By.linkText("Terms and Conditions")).click();
				
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
		
		WebElement frameElement = driver.findElement(By.xpath("//*[@id='content']/iframe"));
		
		//driver.switchTo().frame(0);
		//driver.switchTo().frame(); // id or name
		driver.switchTo().frame(frameElement);
		
		WebElement tagsTextBox =  driver.findElement(By.id("tags"));
		
		tagsTextBox.sendKeys("test");
		
		System.out.println(tagsTextBox.getAttribute("value"));
		
		driver.switchTo().defaultContent();// Bring Context of driver back to main page code
		
		//driver.quit();
	}
	
	public static void main(String[] args) {
		
		SwitchingCommands sc = new SwitchingCommands();
		//sc.switchAlerts();
		sc.switchWindows();
		//sc.switchFrames();
		
		
		// Switch Commands
		// 1.  Switching to Alerts
		// 2.  Switching to Window (Tab)
		// 3.  Switching to Frames		
	}

}
