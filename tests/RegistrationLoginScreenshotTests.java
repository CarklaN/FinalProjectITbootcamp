package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import objects.Login;

public class RegistrationLoginScreenshotTests {
WebDriver wd;
	
	@BeforeMethod
	public void startPage() throws Throwable  {
		System.setProperty("webdriver.chrome.driver", "C:\\drajver\\chromedriver.exe");
		wd=new ChromeDriver();
		
		wd.manage().window().maximize();
		wd.get(Login.HOMEURL);
		
		Login.closePopUp(wd);
	}
	
	@AfterMethod
	public void sleep() {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	@Test    //registration 1 process
	public void registration1() throws Throwable {
		
		Login.clickName(wd, "Marko Stepanovic");
		Login.clickEmail(wd, "stepanMarko88@gmail.com");
		Login.startFree(wd);
		
		Thread.sleep(3000);
		
		Login.clickComp(wd, "Brom doo");
		
		Thread.sleep(1000);
		
		Login.clickInd(wd, 5);
		Login.clickFunctionalRole(wd, 3);
		Login.submitPhone(wd, "00381651234567");
		Login.submitPass(wd, "marko88");
		Login.submitRepeatPass(wd, "marko88");
		Login.submit(wd);
		
		Thread.sleep(3000);
		
		String actual=wd.getTitle();
		String expected="ShiftPlanning - Humanity";
		
		Assert.assertEquals(actual, expected);
		
		wd.close();	
	}
	
	@Test  //registration 2 process
	public void registration2() throws Throwable {
		
		Login.startFree2(wd);
		
		Thread.sleep(2000);
		
		Login.fullName2(wd, "Vanja Bratic");
		Login.email2(wd, "vanjab88@bootcamp.rs");
		Login.start2(wd);
		
		Thread.sleep(3000);
		
		Login.clickComp(wd, "Klikavac doo");
		
		Thread.sleep(1000);
		
		Login.clickInd(wd, 5);
		Login.clickFunctionalRole(wd, 3);
		Login.submitPhone(wd, "00387654321");
		Login.submitPass(wd, "vanja88");
		Login.submitRepeatPass(wd, "vanja88");
		Login.submit(wd);

		Thread.sleep(3000);
		
		String actual=wd.getTitle();
		String expected="ShiftPlanning - Humanity";
		
		Assert.assertEquals(actual, expected);
		
		wd.close();	
	}
	
	@Test  //login using registered account
	public void login() throws Throwable {
		Login.login(wd);
		Thread.sleep(2000);
		Login.loginEmail(wd, "vanjab88@bootcamp.rs");
		Login.loginPass(wd, "vanja88");
		Login.loginButton(wd);
		Thread.sleep(3000);
		
		String actual=wd.getCurrentUrl();
		String expected="https://klikavacdoo.humanity.com/app/dashboard/";
		
		Assert.assertEquals(actual, expected);
		
		Thread.sleep(5000);
		
		Login.signOut(wd);
		
		wd.close();
	}
	
	@Test  //go to About Us and take screenshot of the page and save it to the folder
	public void screenshot() throws Throwable {
		Login.aboutUs(wd);
		
		Thread.sleep(2000);
		
		Login.screenshot(wd, "C:\\Users\\nikol\\eclipse-workspace\\zavrsniProjekatNikolaKlacar\\nikola.png");
		
		wd.close();
	}

}
