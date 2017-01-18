package in.beingzero.priya;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class BzSwitchingWindows extends BeforeAfterTestNG{

	String url = "http://www.popuptest.com/";
	String url1 = "http://beingzero.in/selenium-new-tab";
	String url2 = "https://jqueryui.com/autocomplete/";
	
	//@Test
	public void switchingWindowsExerone() throws Exception
	{
		
		driver.get(url);
		String mainWindowHandle = driver.getWindowHandle();
		(new WebDriverWait(driver, 5)).until
			(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/table/tbody/tr[2]/td[2]/table/tbody/tr[2]/td[1]/font[1]/b/a"))).click();
		
		System.out.println("Main Window Handle: "+ mainWindowHandle);
		System.out.println("URL of Main Page : "+ driver.getCurrentUrl());
		System.out.println("Title of Main Page : "+ driver.getTitle());
		
		Set<String> windowHandles = driver.getWindowHandles();
		System.out.println("Print WindowHandles: " + windowHandles );
		int count =  windowHandles.size();
		count = count - 1;
		System.out.println("No of popup windows open are : "+ count);
		
		if (count>1)
		{
			for(String window : windowHandles)
			{
				if (!window.equals(mainWindowHandle))
				{
					driver.switchTo().window(window);
					System.out.println("URL of Page : "+ driver.getCurrentUrl());
					System.out.println("Title of Page : "+ driver.getTitle());
					driver.close();
				}
				driver.switchTo().window(mainWindowHandle);
			}
		}
	}
	
	//@Test
	public void switchingWindowsExerTwo()
	{
		driver.get(url1);
		String mainWindowHandle = driver.getWindowHandle();
		
		driver.findElement(By.xpath("//*[@id='login']/p[2]/a")).click();
		Set<String> windowHandles = driver.getWindowHandles();
		int count = windowHandles.size();
		if (count>1)
		{
			System.out.println("New Window is opened");
		}
		for(String window : windowHandles)
		{
			if(!window.equals(mainWindowHandle))
			{
				driver.switchTo().window(window);
				System.out.println("URL of Page : "+ driver.getCurrentUrl());
				System.out.println("Title of Page : "+ driver.getTitle());
				driver.findElement(By.id("acceptBtn")).click();
				driver.close();
			}
		}
		driver.switchTo().window(mainWindowHandle);
		System.out.println("URL of Main Page : "+ driver.getCurrentUrl());
		System.out.println("Title of Main Page : "+ driver.getTitle());
		driver.close();
		
	}
	
	@Test
	public void switchingWindowsExerThree()
	{
		driver.get(url2);
		WebElement iframeElement = driver.findElement(By.xpath("//*[@id='content']/iframe"));
		driver.switchTo().frame(iframeElement);
		//this locate the iframe on the basis of index value driver.switchTo().frame(0);
		WebElement txtbx = driver.findElement(By.id("tags"));
		txtbx.sendKeys("test");
		System.out.println("Text typed in textbox : "+txtbx.getAttribute("value"));
		//driver.switchTo().parentFrame();
		//this brings the context of driver back to main page code
		driver.switchTo().defaultContent();
	}
}
