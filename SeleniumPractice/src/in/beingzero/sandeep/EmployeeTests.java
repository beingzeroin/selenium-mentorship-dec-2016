package in.beingzero.sandeep;

public class EmployeeTests {

	void addEmployeeTest()
	{
		/*
		1.   Launch Browser.
		2.   Open http://opensource.demo.orangehrmlive.com/
		3.   Enter username - Admin
		4.   Enter password - admin
		5.   Click Login Button
		6.   Verify that login succeeds and we then go to the PIM Page.
		7.   Click on the Add Employee SubMenu and Print out the URL
		8.   Click and enter First Name
		9.   Click and enter Middle Name
		10.  Click and enter Last Name
		11.  Print Employee ID (which is auto generated field)
		12.  Check 'Create Login Details'
		13.  Enter username, password, confirm password
		14.  Verify that in dropdown Enabled is selected
		15.  Click Save
		16.  Verify Employee Details are correct - Validate FirstName, Middle Name, LAst Name and Employee ID
		*/
	}
	
	void editEmployeeDOBTest()
	{
		/*
		1.   Launch Browser.
		2.   Open http://opensource.demo.orangehrmlive.com/
		3.   Enter username - Admin
		4.   Enter password - admin
		5.   Click Login Button
		6.   Verify that login succeeds and we then go to the PIM Page.
		7.   Click on the Employee List SubMenu and Print out the URL
		8.   Enter Employee Id in Id Box and Click Search Button
		9.   Click on Employee Id field in the Result Table to open Emp Details
		10.  Click Edit Button
		11.  Enter Date Of Birth as 5th December 1998
		12.  Click Save Button
		13.  Verify that Confirmation Popup was shown (through automation)
		14.  Wait for Success popup message to disappear
		15.  Click Save Button
		16.  Verify DOB is updated, by printing 
		*/
	}
	
	void uploadEmployeeImage()
	{
		/*
		1.   Launch Browser.
		2.   Open http://opensource.demo.orangehrmlive.com/
		3.   Enter username - Admin
		4.   Enter password - admin
		5.   Click Login Button
		6.   Verify that login succeeds and we then go to the PIM Page.
		7.   Click on the Employee List SubMenu and Print out the URL
		8.   Enter Employee Id in Id Box and Click Search Button
		9.   Click on Employee Name field in the Result Table to open Emp Details
		10.  Click Edit Button
		11.  Click Employee Photo Icon
		12.  Upload any image from your pc to site using Choose File and upload
		13.  Verify that image is uploaded and shown. 
		*/
	}
	
	
	void deleteEmployeeTest()
	{
		/*
		1.   Launch Browser.
		2.   Open http://opensource.demo.orangehrmlive.com/
		3.   Enter username - Admin
		4.   Enter password - admin
		5.   Click Login Button
		6.   Verify that login succeeds and we then go to the PIM Page.
		7.   Click on the Employee List SubMenu and Print out the URL
		8.   Get count of total employees shown in the table and store in variable originalCount
		9.   Print the Count.
		10.  Using an employee ID, click on checkbox in the result table in front of empid row
		11.  Click Delete button
		12.  On confirmation dialog (Note:  This isn't an ALERT, you can inspect it) click OK button.
		13.  Verify that Successfully Deleted momentary popup appears.
		14.  Wait for popup to disappear.
		15.  Get count of rows in the results table and store in finalCount variable (int)
		16.  Print finalCount.
		17.  If finalCount+1 is equal to originalCount, print Passed, otherwise print failed.
		18.  Also verify that employee id deleted just now isn't shown in the table anymore.
		*/
	}
	
	void downloadEmpImportFile()
	{
		/*
		1.   Launch Browser.
		2.   Open http://opensource.demo.orangehrmlive.com/
		3.   Enter username - Admin
		4.   Enter password - admin
		5.   Click Login Button
		6.   Verify that login succeeds and we then go to the PIM Page.
		7.   Hover mouse over Configuration SubMenu and Click Data Import
		8.   Click Download Link on CSV Data Import Page
		9.   Verify that file has been downloaded to the computer.
		10.  Click upload to upload the same file again.
		11.  Quit the browser
		*/
	}
	
}
