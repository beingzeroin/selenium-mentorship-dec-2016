package in.beingzero.priya;

import org.openqa.selenium.WebElement;

public class EmployeeTestRunner {

	public static void main(String[] args) {
		//Question to ask -
		//1. WebElement firstseloptionstatus = statusoption.getFirstSelectedOption();
		//it is not giving the selected option of dropdown. how to get it.
		EmployeeTest empobj = new EmployeeTest();
		empobj.addEmployeeTest();

	}

}
