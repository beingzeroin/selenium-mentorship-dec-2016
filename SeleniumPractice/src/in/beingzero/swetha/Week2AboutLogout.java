package in.beingzero.swetha;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Week2AboutLogout {

	public static void main(String[] args) throws InterruptedException {
		
		verifyAboutCompanyNameContainsOrangeHRM();
		verifyLogoutWorks();
		
	}
		
	
	public static void verifyAboutCompanyNameContainsOrangeHRM() throws InterruptedException
	{
		WebDriver fd = new ChromeDriver();

		fd.get("http://opensource.demo.orangehrmlive.com");
		
		WebElement Username = fd.findElement(By.id("txtUsername"));
	    Username.sendKeys("Admin");

		WebElement Password = fd.findElement(By.id("txtPassword"));
		Password.sendKeys("admin");

		WebElement Login = fd.findElement(By.id("btnLogin"));
		Login.click();
		
		fd.manage().window().maximize();
		
		Thread.sleep(1000);
		
		WebElement Welcome = fd.findElement(By.id("welcome"));
		Welcome.click(); 
		
		Thread.sleep(1000);
		
		WebElement Aboutlnk = fd.findElement(By.id("aboutDisplayLink"));
		Aboutlnk.click(); 
		
		if (fd.findElement(By.xpath(".//div[@id='displayAbout']//h3[contains(text(),'About')]")).isDisplayed() == true){
	
			WebElement AboutWindow = fd.findElement(By.xpath(".//div[@id='companyInfo']//p[contains(text(),'Company Name: OrangeHRM (Pvt) Ltd')]"));
			Thread.sleep(1000);
			String ActualName = AboutWindow.getText();
			System.out.println(ActualName);
			String ExpectedName = "Company Name: OrangeHRM (Pvt) Ltd";
			if(ActualName.equals (ExpectedName)) {
				System.out.println("Company Name verified");
			}
			WebElement CloseWindow = fd.findElement(By.xpath(".//div[@id='displayAbout']//a[@class='close']"));
			CloseWindow.click();
		}	
	}

		
	public static void verifyLogoutWorks() throws InterruptedException{
		
		WebDriver fd = new ChromeDriver();

		fd.get("http://opensource.demo.orangehrmlive.com");
		
		fd.manage().window().maximize();
		
		WebElement Username = fd.findElement(By.id("txtUsername"));
	    Username.sendKeys("Admin");

		WebElement Password = fd.findElement(By.id("txtPassword"));
		Password.sendKeys("admin");

		WebElement Login = fd.findElement(By.id("btnLogin"));
		Login.click();
		
		Thread.sleep(1000);
		
		WebElement Welcome = fd.findElement(By.id("welcome"));
		Welcome.click(); 
		
		Thread.sleep(1000);

		WebElement Logout = fd.findElement(By.xpath(".//div[@id='welcome-menu']//a[contains(text(),'Logout')]"));	
		Logout.click();
	}
		
	}
		
	