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
		
		//TODO:  PRIYA It won't run on other's machine.  How to Solve this problem?
		//Done: Added the chromedriver.exe in windows//system32 folder
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

		//TODO:  PRIYA Get the selected value from selobject and print
		// Currently it is hard coded that India is selected
		//Done
		System.out.println("Selected Country value from drop down: "+ selobj.getFirstSelectedOption().getText());
		//System.out.println("Country India selected from drop down");
		
		cselect.click();
		selobj.selectByIndex(3); 
		cselect.click();
		
		// TODO:  PRIYA Selection should be obtained from selobj and printed (Same as above)
		//Done
		System.out.println("Selected Country value from drop down: "+ selobj.getFirstSelectedOption().getText());
		//System.out.println("Country India is  deselected from drop down and UK selected");
		
		
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
		
		// TODO:  PRIYA There is a way to get all selected values from multiselect and print
		//Done
		System.out.println("Languages selected are: ");
		List<WebElement> mulLang = langsmulc.getAllSelectedOptions();
		for(int i = 0;i<mulLang.size();i++)
		{
			System.out.println(mulLang.get(i).getText());
		}
		
		
		langsmulc.deselectAll();
		
		langsmulc.selectByIndex(4);
		langsmulc.selectByVisibleText("Spanish");
		
		// TODO:  PRIYA Print selected values by calling function on langsmulc (Same as above)
		//Done
		System.out.println("Languages selected are after reselection: ");
		List<WebElement> remulLang = langsmulc.getAllSelectedOptions();
		for(int i = 0;i<remulLang.size();i++)
		{
			System.out.println(remulLang.get(i).getText());
		}
		
		//driver.quit();
		

	}

}
