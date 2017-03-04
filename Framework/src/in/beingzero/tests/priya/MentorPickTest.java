package in.beingzero.tests.priya;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import in.beingzero.framework.POM.Priya.MentorPickDashBoardPage;
import in.beingzero.framework.POM.Priya.MentorPickLogin;

public class MentorPickTest {

	MentorPickLogin loginObj;
	
	@BeforeClass
	public void setUp()
	{
		loginObj = new MentorPickLogin();
	}
	
	@Test
	public void MentorPickMulTest()
	{
		MentorPickDashBoardPage dp = loginObj.validLogin();
		dp.VerifyLockUnlockCourse();
	}
}
