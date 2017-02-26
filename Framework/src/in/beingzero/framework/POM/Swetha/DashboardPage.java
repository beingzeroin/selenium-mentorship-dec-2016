package in.beingzero.framework.POM.Swetha;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DashboardPage extends BasePage{
	
	
	public DashboardPage() {
		super();
	}

	public DashboardPage(WebDriver driver) {
		super(driver);
	}
	
	public LoginPage logOut() throws InterruptedException{
		
		driver.findElement(By.id("welcome")).click();
		
		WebDriverWait wait = new WebDriverWait(driver,3000);
		
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//div[@id='welcome-menu']//a[contains(text(),'Logout')]")));
		
		Thread.sleep(1000);
		
		driver.findElement(By.xpath(".//div[@id='welcome-menu']//a[contains(text(),'Logout')]")).click();
		
		return new LoginPage(driver);
		
	}
	public String getWelcomeText() {
		
		String actualLogonText = driver.findElement(By.id("welcome")).getText();
		return actualLogonText;
	}

}
