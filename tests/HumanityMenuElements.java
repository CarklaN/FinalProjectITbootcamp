package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import objects.Login;
import objects.MenuElements;

public class HumanityMenuElements {
	
	WebDriver wd;
	
	@BeforeClass  //login on www.humanity.com
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
	
	@AfterMethod  //necessary time for system respond from one to another test
	public void time() throws Throwable{
		Thread.sleep(4000);
	}
	
	//testing upper menu elements, are they properly responding on our call
	
	@Test(priority=1)  //dashboard tab test
	public void dashBoardTest() {
		MenuElements.dashboard(wd);
		String actual=wd.getTitle();
		String expected="Dashboard - Dashboard - Humanity";
		Assert.assertEquals(actual, expected);
	}
	
	@Test(priority=2)  //shift tab test
	public void ShiftPlaningTest() {
		MenuElements.shiftPlanning(wd);
		String actual=wd.getTitle();
		String expected="ShiftPlanning - Humanity";
		Assert.assertEquals(actual, expected);
	}
	
	@Test(priority=3)  //time clock tab test
	public void timeClockTest() {
		MenuElements.timeClock(wd);;
		String actual=wd.getTitle();
		String expected="Timeclock - Overview - Humanity";
		Assert.assertEquals(actual, expected);	
	}
	
	@Test(priority=4)  //leave tab test
	public void leaveTest() {	
		MenuElements.leave(wd);
		String actual=wd.getTitle();
		String expected="Leave - Vacation - Humanity";
		Assert.assertEquals(actual, expected);
	}
	
	@Test(priority=5)  //training tab test
	public void trainingTest() {
		MenuElements.training(wd);
		String actual=wd.getTitle();
		String expected="Training - Overview - Humanity";
		Assert.assertEquals(actual, expected);
	}
	
	@Test(priority=6)  //staff tab test
	public void staffTest() throws Throwable {
		MenuElements.staff(wd);
		Thread.sleep(2000);
		String actual=wd.getTitle();
		String expected="Staff - List - Humanity";
		Assert.assertEquals(actual, expected);
	}
	
	@Test(priority=7)  //payroll tab test
	public void payrollTest() throws Throwable {
		MenuElements.payroll(wd);
		Thread.sleep(5000);
		String actual=wd.getTitle();
		String expected="Payroll - Scheduled-hours - Humanity";
		Assert.assertEquals(actual, expected);
	}
	
	@Test(priority=8)  //reports tab test
	public void reportsTest() throws Throwable {
		MenuElements.reports(wd);
		Thread.sleep(5000);
		String actual=wd.getTitle();
		String expected="Reports - Reports Home - Humanity";
		Assert.assertEquals(actual, expected);
	}
	
	@Test(priority=9)  //availability tab test
	public void availabilityTest() throws Throwable {
		MenuElements.availability(wd);
		Thread.sleep(10000); 
		
		String actual=wd.getTitle();
		String expected="Humanity";
		Assert.assertEquals(actual, expected);
		wd.close();
	}
	
}
