package in.beingzero.Ravi;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebTables {

	public static void main(String[] args) {
		// row and column count
		WebDriver ch = new ChromeDriver();
		ch.get("http://www.w3schools.com/html/html_tables.asp");
		WebElement table = ch.findElement(By.id("customers"));
		WebElement talbody = table.findElement(By.tagName("tbody"));
		List<WebElement> trvals = talbody.findElements(By.tagName("tr"));
		int rows = trvals.size()-1;
		System.out.println("# of Rows: "+rows);
		WebElement firstrow = trvals.get(0);
		List<WebElement> thvals = firstrow.findElements(By.tagName("th"));
		System.out.println("# of columns: "+thvals.size());	
		
		//Print table data
		for(int i=1;i<trvals.size();i++){
			List<WebElement> tdlist = trvals.get(i).findElements(By.tagName("td"));
			for(int j=0;j<tdlist.size();j++){
				System.out.print(tdlist.get(j).getText()+" ");
			}
			System.out.println();
		}
		ch.quit();
	}

}
