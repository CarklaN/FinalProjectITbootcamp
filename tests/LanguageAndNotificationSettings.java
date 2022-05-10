package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import objects.Login;
import objects.Settings;

public class LanguageAndNotificationSettings {
	
	WebDriver wd;
	
	@BeforeMethod
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
	
	@Test //choose language and toggle off notification settings
	public void changeLanguageAndNotifications() throws Throwable {
		Settings.openSettings(wd);  //open settings
		Thread.sleep(2000);
		//change language
		Settings.clickLanguage(wd, "Serbin");
		Thread.sleep(2000);
                //turn off notifications
	        Settings.turnOffNotifications(wd);
	        Thread.sleep(2000);
	        //save all changes that were made
	        Settings.clickSaveChang(wd);
	        Thread.sleep(1500);
	        //looking for pop up that inform as that changes are saved
	        WebElement em=wd.findElement(By.xpath("//*[@id=\"_status\"]"));
	        
	        boolean popUp=false;
	        
	        if(em.isDisplayed()) //if pop up is displayed than changes were made and saved
	    	     popUp=true;
	        Assert.assertTrue(popUp);
		wd.close();
	}
	
}
