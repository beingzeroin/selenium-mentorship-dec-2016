package in.beingzero.priya;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class AlertsHandling extends BeforeAfterTestNG{
	
	String url = "http://beingzero.in/java-quiz/loops-quiz";
	String url1 = "http://beingzero.in/selenium/selenium-java/selenium-alerts-handling";
	
	@Test
	public void alertHandlingExerOne() throws Exception
	{
		driver.get(url);
		
		WebElement bzHme = driver.findElement(By.xpath("//*[@id='main-nav']/li[1]/a/span"));
		bzHme.click();
		
		Alert al = driver.switchTo().alert();
		Thread.sleep(2000);
		al.accept();
		
		System.out.println("Current Page URL: "+ driver.getCurrentUrl());
		System.out.println("Current Page Title: "+ driver.getTitle());
		
	}

	@Test
	public void alertHandlingExerTwo()
	{
		driver.get(url1);
		driver.findElement(By.id("btnMsgAlert")).click();
		Alert al = driver.switchTo().alert();
		System.out.println("Alert Message: "+ al.getText());
		al.accept();
		
	}

	
	@Test
	public void alertHandlingExerThree()
	{
		driver.get(url1);
		driver.findElement(By.id("btnConfirmAlert")).click();
		Alert al = driver.switchTo().alert();
		System.out.println("Alert Message: "+ al.getText());
		al.dismiss();
		System.out.println("Message shown after dismiss: "+driver.findElement(By.id("confim_response")).getText());
		driver.findElement(By.id("btnConfirmAlert")).click();
		al.accept();
		System.out.println("Message shown after alert acception: "+driver.findElement(By.id("confim_response")).getText());
	}

	
	@Test
	public void alertHandlingExerFour()
	{
		driver.get(url1);
		driver.findElement(By.id("btnPromptAlert")).click();
		Alert al = driver.switchTo().alert();
		System.out.println("Text Shown in Alert: "+ al.getText());
		al.sendKeys("Hello BZ");
		al.accept();
		System.out.println("Message shown after dismiss: "+driver.findElement(By.id("prompt_response")).getText());
	}
	
}
