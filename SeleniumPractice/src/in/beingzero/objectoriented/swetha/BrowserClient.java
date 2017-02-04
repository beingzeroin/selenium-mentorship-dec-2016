package in.beingzero.objectoriented.swetha;

public class BrowserClient {
	
	static boolean launchMaximized = true;

	public static void main(String[] args) {
		
//		Browser ifaceObj = new ChromeBrowser();
//		ifaceObj.launch();
//		ChromeBrowser clsObj = new ChromeBrowser();
//		clsObj.launch();
//		clsObj.launch(launchMaximized);
//		
//		ChromeBrowser cbObj = (ChromeBrowser)ifaceObj;
//		
//		
//		System.out.println("Browser Name: " + cbObj.getBrowserName());
//		
//		System.out.println("Browser Name: " + clsObj.getBrowserName());
//		
//		System.out.println("Two Browser Windows Launched, Now Closing");
//		
//		ifaceObj.quit();
//		clsObj.quit();
//		
//		System.out.println("========== Using Version 2 =========");
//		
		Browser[] browsers = new Browser[3];
		
		browsers[0] = new IEBrowser();
		
		browsers[1] = new FirefoxBrowser();
		
		browsers[2] = new ChromeBrowser();
		
//		for(Browser b : browsers)
//		{
//			b.launch();
//			b.purpose();
//		}
	
// 		Typecasting interface to specific class object to use class method

		IEBrowser ieb = (IEBrowser)browsers[0];
    	
    	FirefoxBrowser fb = (FirefoxBrowser)browsers[1];
		
    	ChromeBrowser cb = (ChromeBrowser)browsers[2];

		System.out.println("IEBrowserVersion: " + ieb.getBrowserVersion());
		System.out.println("ChromeBrowserName: " + cb.getBrowserName());
		
		fb.launch();
		fb.launch(launchMaximized);
		
		cb.launch();
		cb.launch(launchMaximized);
		
		for(Browser b : browsers)
		{
		b.quit();
		}

	}


}


//1. A non-abstract class implementing an interface must provide body of all functions declared in interface. - True
//2. We can create an object of class and assign it to variable of type interface that is implemented by the class. - True
//3. We can only invoke those functions of class that are declared in interface if we create object of class and assign it to variable of type interface implemented by the class.- True



//1. Interfaces help us designing the extensible systems where clients get benefited with future enhancements easily. - True
//2. Even though we assign object of class to interface – there’s always a way to typecast object back to class type and use specific methods of class that aren’t declared in interface. - True






