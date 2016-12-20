package in.beingzero.swetha;

public class LoginRun {

	public static void main(String[] args) throws InterruptedException {

		LoginVerification lv1 = new LoginVerification("Admin", "admin", "Welcome Admin");

		lv1.Test1();

		LoginVerification lv2 = new LoginVerification("Admin", "", "Password cannot be empty");

		lv2.Test2();

		LoginVerification lv3 = new LoginVerification("", "admin", "Username cannot be empty");

		lv3.Test3();

		LoginVerification lv4 = new LoginVerification(" ", " ", "Invalid credentials");

		lv4.Test4();

	}

}
