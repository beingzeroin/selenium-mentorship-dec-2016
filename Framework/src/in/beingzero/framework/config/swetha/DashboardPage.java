package in.beingzero.framework.config.swetha;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DashboardPage {
	
	WebDriver wd;
	
	public LoginPage logout() throws InterruptedException{
		
		wd.findElement(By.id("welcome")).click();
		
		WebDriverWait wait = new WebDriverWait(wd,3000);
		
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//div[@id='welcome-menu']//a[contains(text(),'Logout')]")));
		
		Thread.sleep(1000);
		
		wd.findElement(By.xpath(".//div[@id='welcome-menu']//a[contains(text(),'Logout')]")).click();
		return null;
	}

	

	
	
	
	
	
	

	
	

}
