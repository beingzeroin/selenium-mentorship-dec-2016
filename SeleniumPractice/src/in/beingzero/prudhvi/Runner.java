package in.beingzero.prudhvi;

import java.io.File;

public class Runner {

	public static void main(String[] args) throws InterruptedException {
		WeekThreeExercisesSetOne obj=new WeekThreeExercisesSetOne();
		
			//obj.verifyResetFunctionality();
		
		Week3EmployeeTests objTests=new Week3EmployeeTests();
		//objTests.addEmployeeTest();
		//objTests.editEmployeeDOBTest();
		//objTests.deleteEmployeeTest();
		//objTests.UploadEmployeeImage();
		objTests.downloadEmpImportFile();
		
		 
	}

}
