package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import objects.AddEmployee;
import objects.Login;

public class EmployeeAddAndEdit {
	
	//Add new employee, change data and add picture
	
WebDriver wd;
	
	@BeforeClass
	public void startPage() throws Throwable  {
		System.setProperty("webdriver.chrome.driver", "C:\\drajver\\chromedriver.exe");
		wd=new ChromeDriver();
		wd.manage().window().maximize();
		wd.get(Login.HOMEURL);
		Login.closePopUp(wd);
		Login.login(wd);
        Thread.sleep(2000);
		Login.loginEmail(wd, "petrovic88@itbootcamp.rs");
		Login.loginPass(wd, "petrovic88");
		Login.loginButton(wd);
		Thread.sleep(3000);
	}
	
	@Test(priority=1)  //add new employee on list through shift tab, check did we created new employee
	public void addNewEmployee() throws Throwable {
		AddEmployee.openShiftTab(wd);
		AddEmployee.addEmp(wd);
		AddEmployee.inputName(wd, "Marko");
		Thread.sleep(2000);
		AddEmployee.inputLastName(wd, "Markovic");
		Thread.sleep(2000);
		AddEmployee.jobPosition(wd, "HR");
		AddEmployee.pressContinue(wd);
		Thread.sleep(3000);
		AddEmployee.openStaff(wd);
		Thread.sleep(2000);
		String et=wd.getPageSource();
		Thread.sleep(2000);
		
		boolean contain=false;
		if(et.contains("Marko Markovic")) 
			contain=true;
		Assert.assertTrue(contain);
		
		wd.close();
	}
	
	@Test(priority=2)  //change employee name, last name, update info through staff tab, compare results
	public void editName() throws Throwable {
		AddEmployee.openStaff(wd);
		Thread.sleep(2000);
		AddEmployee.clickEmployee(wd);
		Thread.sleep(2000);
		AddEmployee.editDetails(wd);
		Thread.sleep(3000);
		AddEmployee.changeName(wd, "Marko");
		AddEmployee.changeLastName(wd, "Milic");
		Thread.sleep(2000);
		AddEmployee.saveChanges(wd);
		Thread.sleep(3000);
		AddEmployee.openStaff(wd);
		Thread.sleep(2000);
		String et=wd.getPageSource();
		Thread.sleep(2000);
		
		boolean contain=false;
		if(et.contains("Marko Milic")) 
			contain=true;
		Assert.assertTrue(contain);
		
		wd.close();
	}
	
	@Test(priority=3)  //add profile picture
	public void addPicture() throws Throwable {
		AddEmployee.openShiftTab(wd);
		Thread.sleep(5000);
		
		AddEmployee.clickEmployee(wd);
		Thread.sleep(2000);
		
		AddEmployee.editDetails(wd);
		Thread.sleep(3000);
		AddEmployee.pictureUpload(wd);
		Thread.sleep(5000);
		wd.close();
		}
	

}
