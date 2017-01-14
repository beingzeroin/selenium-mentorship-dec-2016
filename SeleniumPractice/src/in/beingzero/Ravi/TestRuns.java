package in.beingzero.Ravi;

public class TestRuns {

	public static void main(String[] args) {
		//TODO:  RAVI.  This is a Compilation error, Class has been removed.  FIX IT.
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
