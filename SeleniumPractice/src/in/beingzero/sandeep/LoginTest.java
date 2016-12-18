package in.beingzero.sandeep;

import org.testng.annotations.Test;

public class LoginTest {

	// Test Case 1
	@Test
	public void validUserNameAndPasswordLogin() {
		
		System.out.println("Running test1");
		// Open the browser

		// Go to site - http://opensource.demo.orangehrmlive.com

		// Enter username - admin

		// Enter password - admin

		// Click Login Button

		// Verify login succceed by verifying Welcome Admin should be ther on
		// topright
	}

	// Test Case 2
	@Test
	public void invalidUserNameAndPasswordLogin() {
		// Open the browser

		// Go to site - http://opensource.demo.orangehrmlive.com

		// Enter username - admin123

		// Enter password - admin

		// Click Login Button

		// Verify that we see "Invalid credentials" error message

	}

	// Test Case 3
	public void blankUserNameAndPasswordLogin() {
		// Open the browser

		// Go to site - http://opensource.demo.orangehrmlive.com

		// Leave username blank

		// Enter password - admin

		// Click Login Button

		// Verify that we see "Username can not be empty" error message

	}

	// Test Case 4
	public void userNameAndBlankPasswordLogin() {
		// Open the browser

		// Go to site - http://opensource.demo.orangehrmlive.com

		// Leave username blank

		// Enter password - admin

		// Click Login Button

		// Verify that we see "Username can not be empty" error message

	}

}
