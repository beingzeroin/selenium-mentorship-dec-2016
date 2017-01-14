package in.beingzero.Ravi;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DropDownAndMultiSelect {

	public static void main(String[] args) throws Exception {
		WebDriver ch = new ChromeDriver();
		ch.get("http://beingzero.in/selenium/selenium-java/selenium-dropdowns");
		Thread.sleep(2000);
		WebElement countrydd = ch.findElement(By.id("countrySelect"));
		Thread.sleep(1000);
		Select s = new Select(countrydd);
		List<WebElement> countries = s.getOptions();
		for(WebElement cL : countries){
		System.out.println("Countries List:"+cL.getText());
		}
		s.selectByValue("60");
		Thread.sleep(2000);
		s.selectByValue("40");
		Thread.sleep(2000);
		System.out.println("Country dropdown multiple selection is: "+s.isMultiple());
		WebElement langknwn = ch.findElement(By.id("languagesKnown"));
		Select l = new Select(langknwn);
		l.selectByValue("22");
		l.selectByValue("24");
		Thread.sleep(2000);
		l.deselectAll();
		l.selectByValue("21");
		l.selectByValue("23");
		Thread.sleep(2000);
		List<WebElement> selopt = l.getAllSelectedOptions();
		for(WebElement so : selopt){
			System.out.println("Selected Langauages"+so.getText());
			}
		ch.quit();
	}

}
