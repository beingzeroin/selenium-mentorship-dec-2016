package in.beingzero.objectoriented.swetha;

public class BrowserClient {

	public static void main(String[] args) {
		
		Browser ifaceObj = new ChromeBrowser();
		ifaceObj.launch();
		ChromeBrowser clsObj = new ChromeBrowser();
		clsObj.launch();

	}

}
