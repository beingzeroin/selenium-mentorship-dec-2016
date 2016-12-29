package in.beingzero.priya;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DropDownandMultipleSelect {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver","C:\\Users\\priya\\Desktop\\Priya\\SeleniumJava\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		//WebDriver driver = new FirefoxDriver();
		
		driver.get("http://beingzero.in/selenium/selenium-java/selenium-dropdowns");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);
		
		List<WebElement> countryoptions = driver.findElements(By.xpath("//*[@id='countrySelect']/option"));
		List<String> actualcountrylist = new ArrayList<>();
		System.out.println("Country drop down values are");
		for(int i = 1; i<countryoptions.size() ; i++)
		{
			actualcountrylist.add(countryoptions.get(i).getText());
			System.out.println(countryoptions.get(i).getText());
		}
		WebElement cselect = driver.findElement(By.xpath("//*[@id='countrySelect']"));
		cselect.click();
		
		//WebDriverWait wait = new WebDriverWait(driver,5);
		//wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='countrySelect']")));
	
		Select selobj = new Select(cselect);
		
		
		selobj.selectByVisibleText("India"); 
		cselect.click();
		
		WebDriverWait wait1 = new WebDriverWait(driver, 50);
		wait1.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='countrySelect']")));

		System.out.println("Country India selected from drop down");
		
		cselect.click();
		selobj.selectByIndex(3); 
		cselect.click();
		
		System.out.println("Country India is  deselected from drop down and UK selected");
		
		
		boolean countrymul = selobj.isMultiple();
		if (countrymul == true)
		{
			System.out.println("Country Select is multiple selection" );
		}
		else
		{
			System.out.println("Country Select is single selection" );
		}
		
		WebElement langselect = driver.findElement(By.xpath("//*[@id='languagesKnown']"));
		System.out.println("multiple language select element is located");
		Select langsmulc = new Select(langselect);
		System.out.println("Mul sel obj is created");
		boolean langmul = langsmulc.isMultiple();
		if (langmul == true)
		{
			System.out.println("Language Select is multiple selection" );
		}
		else
		{
			System.out.println("Language Select is single selection" );
		}
		
		langsmulc.selectByValue("22");
		langsmulc.selectByValue("24");
		
		System.out.println("Hindi and Punjabi Languages are selected");
		
		langsmulc.deselectAll();
		
		langsmulc.selectByIndex(0);
		langsmulc.selectByVisibleText("French");
		
		System.out.println("English and French Languages are selected");
		
		driver.quit();
		

	}

}
