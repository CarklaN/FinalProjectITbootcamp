package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import objects.Login;
import objects.Settings;

public class AdditionalSettingsProfile {

	public static void main(String[] args) throws Throwable {
		
		System.setProperty("webdriver.chrome.driver", "C:\\drajver\\chromedriver.exe");
	    WebDriver wd=new ChromeDriver();
	    
		wd.manage().window().maximize();
		wd.get(Login.HOMEURL);
		
		Login.closePopUp(wd);
		
		Login.login(wd);
        Thread.sleep(2000);
        
		Login.loginEmail(wd, "petrovic88@itbootcamp.rs");
		Login.loginPass(wd, "petrovic88");
		Login.loginButton(wd);
		Thread.sleep(3000);
		
		Settings.openSettings(wd);  //open settings
		Thread.sleep(2000);
		
		Settings.editDetailsTab(wd);
		Thread.sleep(1500);
	
		Settings.nickName(wd, "Pero");  //adding informations in brackets
		Settings.address(wd, "Vukova 55");
		Settings.city(wd, "Belgrade");
		Settings.state(wd, "Serbia");
		Settings.postalCode(wd, "11000");
		Settings.jobTitle(wd, "Design menager");
		Settings.gender(wd, "M");
		Settings.birthMonth(wd, "January");
		Settings.birthDay(wd, "25");
		Thread.sleep(1000);
		
		Settings.saveChanges(wd);  //save changes
		Thread.sleep(2000);
		
		Settings.overviewTab(wd);  //look at overview tab added informations
		Thread.sleep(10000);
		
		wd.close();
	}

}
