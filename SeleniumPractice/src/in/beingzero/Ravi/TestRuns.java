package in.beingzero.Ravi;

public class TestRuns {

	public static void main(String[] args) {
		
		LogInOhrm login = new LogInOhrm();
		login.VuserAndVpwd();
		System.out.print("Login success");
		login.InuserVpwd();
		System.out.print("Login Fail");
		login.blankUserVpwd();
		System.out.print("Login Fail");
		login.VuserBlankpwd();
		System.out.print("Login Fail");
		
	}

}
