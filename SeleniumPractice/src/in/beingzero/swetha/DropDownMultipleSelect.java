package in.beingzero.swetha;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class DropDownMultipleSelect {

	public static void main(String[] args) throws InterruptedException {

		WebDriver fd = new FirefoxDriver();

		fd.get("http://beingzero.in/selenium/selenium-java/selenium-dropdowns");

		// Put an Implicit wait, 
		fd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		fd.manage().window().maximize();
		// Find Select WebElement
		WebElement countrySelector = fd.findElement(By.id("countrySelect"));
		
		//Select for country
		Select countrySelect = new Select(countrySelector);

		countrySelect.selectByVisibleText("India");

		// From Country dropdown list all the options it shows

		List<WebElement> countryList = countrySelect.getOptions();

		for (WebElement cL : countryList) {
			System.out.println(cL.getText());
		}

		// Select "India" from dropdown

		countrySelect.selectByVisibleText("India");
		Thread.sleep(1000);
		System.out.println( countrySelect.getFirstSelectedOption().getText() +" is selected");

		// Select "UK" from dropdown

		countrySelect.selectByVisibleText("UK");
		Thread.sleep(1000);
		System.out.println(countrySelect.getFirstSelectedOption().getText() +" is selected");

		if (countrySelect.isMultiple()) {
			System.out.println("Country select is multiple selection");
		} else {
			System.out.println("Country select is single selection");
		}
		Thread.sleep(1000);
		
		// Find WebElement - multi select
		WebElement languageSelector = fd.findElement(By.id("languagesKnown"));
				
		//Select for country
		Select languageSelect = new Select(languageSelector);
		
		//Select 'Hindi' and 'Punjabi'
		languageSelect.selectByVisibleText("Hindi");
		languageSelect.selectByVisibleText("Punjabi");
		
		// Clear all selected entries
		languageSelect.deselectAll(); 
		
		//Select 'English' and 'French'
		languageSelect.selectByVisibleText("English");
		languageSelect.selectByVisibleText("French");
		
		List<WebElement> languageList = languageSelect.getAllSelectedOptions();
		
		//Print currently selected languages
		for (WebElement lL : languageList) {
			System.out.println(lL.getText());
		}
		
		fd.quit();
		
	}

}
