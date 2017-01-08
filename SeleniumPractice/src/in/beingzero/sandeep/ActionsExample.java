package in.beingzero.sandeep;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ActionsExample {

	WebDriver driver;
	
	@BeforeMethod
	public void setup(){
		driver = new ChromeDriver();
		driver.get("http://beingzero.in");
	}
	
	@AfterMethod
	public void cleanup(){
		driver.quit();
	}
	
	@Test
	public void beingZeroNavigationCommandsTest(){
		WebElement lnk = driver.findElement(By.linkText("Selenium Java"));
		
		Actions act = new Actions(driver);
		act.moveToElement(lnk).perform();
		act.dragAndDrop(driver.findElement(By.id("")), driver.findElement(By.id(""))).perform();
		driver.findElement(By.linkText("Selenium – Navigation Commands")).click();
		
		Assert.assertTrue(driver.getTitle().contains("Navigation Commands"));
		
	}
	
	@Test
	public void dynamicElements()
	{
		// Dynamic Elements
		WebDriverWait wdv = new WebDriverWait(driver, 30);
		
		WebElement msg = wdv.until(ExpectedConditions.presenceOfElementLocated(By.className("message success fadable")));
		
		wdv.until(ExpectedConditions.textToBePresentInElement(By.id(""), "Processing"));
		
		wdv.until(ExpectedConditions.textToBePresentInElement(By.id(""), "Save"));
		
		wdv.until(ExpectedConditions.invisibilityOfElementLocated(By.className("")));
	}
	
}
