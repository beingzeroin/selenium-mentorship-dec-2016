package in.beingzero.objectoriented.swetha;

public class BrowserClient {

	public static void main(String[] args) {
		
		Browser ifaceObj = new ChromeBrowser();
		ifaceObj.launch();
		ChromeBrowser clsObj = new ChromeBrowser();
		clsObj.launch();
		
		System.out.println("Browser Name: " + ifaceObj.getBrowserName());
		
		System.out.println("Browser Name: " + clsObj.getBrowserName());
		
		System.out.println("Two Browser Windows Launched, Now Closing");
		
		ifaceObj.quit();
		clsObj.quit();

	}

}


//1. A non-abstract class implementing an interface must provide body of all functions declared in interface. - False
//2. We can create an object of class and assign it to variable of type interface that is implemented by the class. - True
//3. We can only invoke those functions of class that are declared in interface if we create object of class and assign it to variable of type interface implemented by the class.- True