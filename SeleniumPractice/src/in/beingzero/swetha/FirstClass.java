package in.beingzero.swetha;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FirstClass {

	public static void main(String[] args) throws InterruptedException {

		FirefoxDriver fd = new FirefoxDriver();

		fd.get("http://opensource.demo.orangehrmlive.com");
		WebElement Username = fd.findElement(By.id("txtUsername"));
		Username.sendKeys("Admin");

		WebElement Password = fd.findElement(By.id("txtPassword"));
		Password.sendKeys("admin");

		WebElement Login = fd.findElement(By.id("btnLogin"));
		Login.click();
		Thread.sleep(1000);
		
		String VerifyPageTitle = fd.findElement(By.xpath("//*[@id='welcome']")).getText();
		System.out.println(VerifyPageTitle);
		String ActualPageTitle = "Welcome Admin";
		
		if(VerifyPageTitle == ActualPageTitle)
		{
			System.out.println("Verification successful, test case PASS");
		}
		else
		{
			System.out.println("Verification failed, test case FAIL");
		}	
		//fd.quit();

	}
}