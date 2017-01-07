package in.beingzero.swetha;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
//import org.testng.annotations.Test;

public class AlertHandlingExercises {
	
	//WebDriver driver = new FirefoxDriver();
	

	public void alertHandlingExercise1() {

		WebDriver driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				
		driver.manage().window().maximize();
		
		driver.get("http://beingzero.in/java-quiz/loops-quiz");
		
		WebElement beingZeroTab = driver.findElement(By.xpath(".//ul[@id='main-nav']//span[contains(text(),'Being Zero')]"));
		
		beingZeroTab.click();
		
		// Switch to Alert
		Alert al = driver.switchTo().alert();
		
		al.accept();
		
		//Print title and URL of the current page
				
		System.out.println("Page Title : " +driver.getTitle()); 
		
		System.out.println("Current URL : " +driver.getCurrentUrl());
		
	}
	

	public void alertHandlingExercise2() {
		
		WebDriver driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				
		driver.manage().window().maximize();
		
		driver.get("http://beingzero.in/selenium/selenium-java/selenium-alerts-handling");
		
		WebElement messageAlertButton = driver.findElement(By.id("btnMsgAlert"));
		
		messageAlertButton.click();
		
		// Switch to Alert
		Alert al = driver.switchTo().alert();
		
		System.out.println("Message Alert text is: "+al.getText());
		
		al.accept();
		
		
	}


	public void alertHandlingExercise3() {

		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				
		driver.manage().window().maximize();
		
		driver.get("http://beingzero.in/selenium/selenium-java/selenium-alerts-handling");
		
		WebElement confirmAlertButton = driver.findElement(By.id("btnConfirmAlert"));
		
		confirmAlertButton.click();
		
		// Switch to Alert
		Alert al = driver.switchTo().alert();
		
		// SANDEEP:
		System.out.println("MESSAGE TEXT BOX: "+ al.getText());
				
		al.dismiss();
		
		//String dismissMessage = driver.findElement(By.id("confim_response")).getAttribute("value");
		
		String dismissMessage = driver.findElement(By.id("confim_response")).getText();
		
		System.out.println("Confirm Alert Dismiss message is: "+dismissMessage);
		
		confirmAlertButton = driver.findElement(By.id("btnConfirmAlert"));
		
		confirmAlertButton.click();
		
		driver.switchTo().alert();
		
		al.accept();
		
		dismissMessage = driver.findElement(By.id("confim_response")).getText();
		
		System.out.println("Confirm Alert Accept message is: "+dismissMessage);
		
	}
	

	public void alertHandlingExercise4() throws InterruptedException {
		
		WebDriver driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				
		driver.manage().window().maximize();
		
		driver.get("http://beingzero.in/selenium/selenium-java/selenium-alerts-handling");
		
		WebElement promptAlertButton = driver.findElement(By.id("btnPromptAlert"));
		
		promptAlertButton.click();
		
		// Switch to Alert
		Alert al = driver.switchTo().alert();
				
		System.out.println("Prompt Alert text is: "+al.getText());
		
		al.sendKeys("Swetha");
		
		driver.switchTo().alert().accept();
		
		Thread.sleep(1000);
		String promptMessage = driver.findElement(By.id("prompt_response")).getText();
		
		System.out.println("Prompt Alert Accept message is: "+promptMessage);
		
	}

	public static void main(String[] args) throws InterruptedException {

		AlertHandlingExercises alObj = new AlertHandlingExercises();
		
		//alObj.alertHandlingExercise1();
		
		//alObj.alertHandlingExercise2();
		
		alObj.alertHandlingExercise3();
		
		//alObj.alertHandlingExercise4();
	}
}