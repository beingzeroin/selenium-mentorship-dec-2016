package in.beingzero.swetha;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class WebElementCommands {

	public static void main(String[] args) throws InterruptedException {
		
	//Exercise 1
	FacebookSignUp();
	
	//Exercise 3
	BeingZeroLogo();
	
	//Exercise 2
	GoogleBeingZero();
	
	}

	public static void FacebookSignUp() throws InterruptedException{
		
		FirefoxDriver fd = new FirefoxDriver();
		
		//Open Facebook home page
		fd.get("https://www.facebook.com/");
		
		//Enter Username
		WebElement Username = fd.findElement(By.id("u_0_1"));
	    Username.clear();
		Username.sendKeys("Swetha");
		Thread.sleep(1000);
		
		//Enter Surname
		WebElement Surname = fd.findElement(By.id("u_0_3"));
	    Surname.clear();
		Surname.sendKeys("Jain");
		Thread.sleep(1000);
		
		//Enter Email Address
		WebElement EmailAdd = fd.findElement(By.id("u_0_5"));
	    EmailAdd.clear();
		EmailAdd.sendKeys("sswethajainSJ@gmail.com");
		Thread.sleep(1000);
		
		//Reenter Email Address
		WebElement ReEmailAdd = fd.findElement(By.id("u_0_8"));
	    ReEmailAdd.clear();
		ReEmailAdd.sendKeys("sswethajainSJ@gmail.com");
		Thread.sleep(1000);
		
		//Enter Password
		WebElement NewPassword = fd.findElement(By.id("u_0_a"));
	    NewPassword.clear();
		NewPassword.sendKeys("signupsj17");
		Thread.sleep(1000);
		
		//Select Birth day
		Select SelDay = new Select(fd.findElement(By.id("day")));
		SelDay.selectByVisibleText("1");
		
		//Select Birth month
		Select SelMon = new Select(fd.findElement(By.id("month")));
		SelMon.selectByVisibleText("Jan");
		
		//Select Birth year
		Select SelYr = new Select(fd.findElement(By.id("year")));
		SelYr.selectByVisibleText("2000");
		
		//Select the gender
		WebElement RadioBtn = fd.findElement(By.xpath(".//span[@class='_5k_2 _5dba']/label[contains(text(),'Female')]"));
		RadioBtn.click();
		
	}
	private static void GoogleBeingZero() throws InterruptedException {
		
		FirefoxDriver fd = new FirefoxDriver();

		// Open Google home page
		fd.get("https://www.google.co.uk");

		// Enter Search Keyword
		WebElement SearchKey = fd.findElement(By.id("lst-ib"));
		SearchKey.sendKeys("Being Zero");
		Thread.sleep(1000);
		
		//Hit Submit button
		WebElement SubmitBtn = fd.findElementByName("btnK");
		SubmitBtn.click();
		fd.quit();
		
	}
	private static void BeingZeroLogo() throws InterruptedException {
		
		FirefoxDriver fd = new FirefoxDriver();
		
		//Open Being Zero
		
		fd.get("http://beingzero.in/");
		Thread.sleep(1000);
		
		WebElement ImageFile = fd.findElement(By.xpath("//div[@id='branding']//img[@class='preload-me']"));
		
		if (ImageFile.isDisplayed() == true)
        {
             System.out.println("Image displayed.");
             System.out.println("Image Location: " +ImageFile.getLocation());
             System.out.println("Image Size: " +ImageFile.getSize());
        }
        else
        {
            System.out.println("Image not displayed.");
        }
	}
}

