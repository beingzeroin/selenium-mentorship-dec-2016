package in.beingzero.prudhvi;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class AboutLogOutOrangeHRM {
	@Test
	public void AboutCompanyName()
	{
		System.setProperty("webdriver.chrome.driver","E:\\SeleniumProject\\chromedriver.exe");
		WebDriver FFdriver=new ChromeDriver();
		FFdriver.get("http://opensource.demo.orangehrmlive.com");
		FFdriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		WebElement edtBoxUserName=FFdriver.findElement(By.id("txtUsername"));
		edtBoxUserName.clear();
		edtBoxUserName.sendKeys("Admin");
		
		WebElement edtBoxPassword=FFdriver.findElement(By.id("txtPassword"));
		edtBoxPassword.clear();
		edtBoxPassword.sendKeys("admin");
		
		WebElement btnLogin =FFdriver.findElement(By.id("btnLogin"));
		btnLogin.click();
		
		FFdriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebElement btnWelcome=FFdriver.findElement(By.id("welcome"));
		btnWelcome.click();
		
		
		
		WebElement linkAbout=FFdriver.findElement(By.xpath("//*[@id='aboutDisplayLink']"));
		linkAbout.click();
		
		
		
		WebElement wndAbout = FFdriver.findElement(By.xpath("//div[@id='companyInfo']//p"));
		
		
		String AboutHRMtxt = wndAbout.getText();
		String ExpectedHRMtxt = "Company Name: OrangeHRM (Pvt) Ltd";

		if(AboutHRMtxt.equalsIgnoreCase(ExpectedHRMtxt))
		{
			System.out.println("About information is as expected");
		}
		else
		{
			System.out.println("Not expected");
		}
		
		FFdriver.close();
	
	
	}
	
	
	@Test
	public void LogutVerification()
	{
		System.setProperty("webdriver.chrome.driver","E:\\SeleniumProject\\chromedriver.exe");
		WebDriver FFdriver=new ChromeDriver();
		FFdriver.get("http://opensource.demo.orangehrmlive.com");
		FFdriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		WebElement edtBoxUserName=FFdriver.findElement(By.id("txtUsername"));
		edtBoxUserName.clear();
		edtBoxUserName.sendKeys("Admin");
		
		WebElement edtBoxPassword=FFdriver.findElement(By.id("txtPassword"));
		edtBoxPassword.clear();
		edtBoxPassword.sendKeys("admin");
		
		WebElement btnLogin =FFdriver.findElement(By.id("btnLogin"));
		btnLogin.click();
		
		FFdriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebElement btnWelcome=FFdriver.findElement(By.id("welcome"));
		btnWelcome.click();
		
		
		
		WebElement linkLogout=FFdriver.findElement(By.xpath("//*[@id='welcome-menu']/ul/li[2]/a"));
		System.out.println(linkLogout.getText());
		linkLogout.click();
		
		//Thread.sleep(3000);
		
		WebElement edtBoxUserName1=FFdriver.findElement(By.id("txtUsername"));
		//System.out.println(edtBoxUserName1.isDisplayed());
		
		if(edtBoxUserName1.isDisplayed())
		{
			System.out.println("Logout is succeeded");
		}
		else
		{
			System.out.println("Logout is Failed");
		}
		
		FFdriver.close();
		
	}

}
