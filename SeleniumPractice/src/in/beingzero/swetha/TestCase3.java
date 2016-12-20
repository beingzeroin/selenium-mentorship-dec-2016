package in.beingzero.swetha;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestCase3 {
	public static void main(String[] args) throws InterruptedException {

		FirefoxDriver fd = new FirefoxDriver();

		fd.get("http://opensource.demo.orangehrmlive.com");
		//Incorrect User name
		WebElement Username = fd.findElement(By.id("txtUsername"));
		Username.sendKeys("");

		WebElement Password = fd.findElement(By.id("txtPassword"));
		Password.sendKeys("admin");

		WebElement Login = fd.findElement(By.id("btnLogin"));
		Login.click();
		Thread.sleep(1000);
		
		String VerifyPageTitle = fd.findElement(By.xpath("//span[contains(text(),'Username cannot be empty')]")).getText();
		System.out.println(VerifyPageTitle);
		String ActualPageTitle = "Username cannot be empty";
		
		if(VerifyPageTitle.equals(ActualPageTitle))
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
