package in.beingzero.objectoriented.prudhvi;



public class BrowserClient 
{
	
	public static void main(String[] args)
	{
		IBrowser obj=new ChromeBrowser();
		obj.launch();
		
		ChromeBrowser objCB=new ChromeBrowser();
		//System.out.println("BrowserName:"+obj.getBrowserName());
		System.out.println("BrowserName:"+objCB.getBrowserName());
		
		System.out.println("Two Browser Windows Launched, Now Closing");
		
		obj.quit();
		objCB.quit();
		System.out.println("========== Using Version 2 =========");
		boolean isMaximize=true;
		
		IBrowser[] browsers=new IBrowser[3];  
		
		browsers[0] = new IEBrowser();

		browsers[1] = new FirefoxBrowser();

		browsers[2] = new ChromeBrowser();

		for(IBrowser b : browsers)

		{

		b.launch();

		b.purpose();

		}
		
		
		IEBrowser objIE=(IEBrowser) browsers[0];
		
		FirefoxBrowser objFF=(FirefoxBrowser) browsers[1];
		
		ChromeBrowser objChrome=(ChromeBrowser) browsers[2];
		
		objIE.launch(isMaximize);
		objFF.launch(isMaximize);
		objChrome.launch(isMaximize);
		
		System.out.println("IEBrowserVersion: " + objIE.getBrowserVersion());
		
		System.out.println("ChromeBrowserName: " + objChrome.getBrowserName());

		for(IBrowser b : browsers)

		{

		b.quit();

		}
		
		

		
		
		
	}
	
	

	
	
	
	
	
	
}


/*
1. A non-abstract class implementing an interface must provide body of all functions declared in

interface.

True,If we do not implement in class then below compilation error  shows.
Compilaion Error: The type ChromeBrowser must implement the inherited abstract method IBrowser.quit()

2. We can create an object of class and assign it to variable of type interface that is

implemented by the class.
True


3. We can only invoke those functions of class that are declared in interface if we create object

of class and assign it to variable of type interface implemented by the class.

True,but can not invoke function of class which is not declared in Interface.



4.Interfaces help us designing the extensible systems where clients get benefited with future

enhancements easily.

True.


5.Even though we assign object of class to interface – there’s always a way to typecast object

back to class type and use specific methods of class that aren’t declared in interface.

True.



6.Inheriting from abstract class saves us from Code Duplication.
True

7. Any new browser we’ll add in future (e.g. Safari) isn’t enforced to implement purpose()

function. Code is cleaner and less duplication.

True

8. Client Code isn’t broken at all by our changes to class Design.

True

9. Our design makes it easy to add new browsers – SafariBrowser, AndroidBrowser in future.

True

10. **************************OOPS Concepts, if applied properly we can design really extensible systems that foster code

re-use and implicitly support backward compatibility.*******************8

How it supports backward compatibility.	


*/