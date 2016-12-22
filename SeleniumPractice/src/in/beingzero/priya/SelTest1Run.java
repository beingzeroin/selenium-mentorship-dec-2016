package in.beingzero.priya;

public class SelTest1Run {

	public static void main(String[] args) {
		
		SelTest1 tri = new SelTest1();
		
		tri.validUserNameandPassword();
		tri.invalidUserNameandcorrectPassword();
		tri.correctUserNameandInvalidPassword();
		tri.blankUserNameandPassword();
		tri.validUserNameandBlankPassword();
	}
}
