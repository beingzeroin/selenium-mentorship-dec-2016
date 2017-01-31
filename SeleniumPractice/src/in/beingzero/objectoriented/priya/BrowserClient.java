package in.beingzero.objectoriented.priya;

import org.openqa.selenium.WebDriver;

public class BrowserClient {

	public static void main(String[] args) {
		//    Mark These Statements True/False Based on your Findings 
		//1.  A non-abstract class implementing an interface must provide body 
		//    of all functions declared in interface. - True
		//2.  We can create an object of class and assign it to variable of type 
		//    interface that is implemented by the class. - True
		//3.  We can only invoke those functions of class that are declared in interface 
		//    if we create object of class and assign it to variable of type interface 
		//    implemented by the class. - True
		//4.  Interfaces help us designing the extensible systems where clients get
		//    benefitted with future enhancements easily. - True
		//5.  Even though we assign object of class to interface – there’s always 
		//    a way to typecast object back to class type and use specific methods 
		//    of class that aren’t declared in interface. - True
		//6.  Inheriting from abstract class saves us from Code Duplication. - True
		//7.  Any new browser we’ll add in future (e.g. Safari) isn’t enforced 
		//    to implement purpose() function.  Code is cleaner and less duplication. - True
		//8.  Client Code isn’t broken at all by our changes to class Design. - True
		//9.  Our design makes it easy to add new browsers – SafariBrowser, AndroidBrowser in future. - True 
		//10. OOPS Concepts, if applied properly we can design really extensible systems 
		//    that foster code re-use and implicitly support backward compatibility. -True
		 
		 
		boolean launchBrMaximied = false;		
		
		IBrowser ifaceObj = new ChromeBrowser(); 
		ifaceObj.launch(); 
		
		ChromeBrowser clsObj = new ChromeBrowser(); 
		clsObj.launch(); 
		clsObj.maximized(launchBrMaximied);
		
		//System.out.println("Browser Name: " + ifaceObj.getBrowserName()); 
		System.out.println("Browser Name: " + clsObj.getBrowserName()); 
		 
		System.out.println("Two Browser Windows Launched, Now Closing"); 
		
		System.out.println("========== Using Version 2 ========="); 
		
		launchBrMaximied = true;
		IBrowser[] browsers = new IBrowser[3]; 
		browsers[0] = new IEBrowser();
		IEBrowser iebr = (IEBrowser)browsers[0];
		browsers[1] = new FirefoxBrowser();
		FirefoxBrowser ffbr = (FirefoxBrowser)browsers[1];
		browsers[2] = new ChromeBrowser(); 
		ChromeBrowser cbr = (ChromeBrowser)browsers[2];
		for(IBrowser b : browsers) 
		{  
			b.launch(); 
			
			b.purpose(); 
		} 
		 
		// Typecasting interface to specific class object to use class method 
		IEBrowser ieb = (IEBrowser)browsers[0]; 
		ChromeBrowser cb = (ChromeBrowser)browsers[2]; 
		System.out.println("IEBrowserVersion: " + ieb.getBrowserVersion());
		ieb.purpose();
		System.out.println("ChromeBrowserName: " + cb.getBrowserName()); 
		 
		for(IBrowser b : browsers) 
		{  
			b.quit();
			
		}   
		 
		ifaceObj.quit();
		clsObj.quit();
		
	}

}
