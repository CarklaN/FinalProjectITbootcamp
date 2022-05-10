package objects;

import java.io.File;
import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;

public class Login {
	public static final String HOMEURL="https://www.humanity.com/";
	public static final String FULLNAME_XPATH="//*[@id=\"top-form\"]/div/div[1]/input";
	public static final String WORK_EMAIL="//*[@id=\"top-form\"]/div/div[2]/input";
	public static final String START_XPATH="//*[@id=\"free-trial-link-01\"]";
	public static final String COMP_XPATH="//*[@id=\"root\"]/div/div/form/div[1]/div/div[1]/div/div/input";
	public static final String INDUSTRY_XPATH="/html/body/div/div/div/form/div[1]/div/div[2]/div/div/span";
	public static final String FUNCTIONAL_ROLE="//*[@id=\"root\"]/div/div/form/div[1]/div/div[3]/div/div/span";
	public static final String PHONE_XPATH="//*[@id=\"root\"]/div/div/form/div[1]/div/div[4]/div/input";
	public static final String PASS_XPATH="//*[@id=\"root\"]/div/div/form/div[1]/div/div[5]/div/input";
	public static final String REPEAT_XPATH="//*[@id=\"root\"]/div/div/form/div[1]/div/div[6]/div/input";
	public static final String SUBMIT_XPATH="//*[@id=\"root\"]/div/div/form/div[2]/span/input";
	public static final String LOGIN_BUTTON="//*[@id=\"navbarSupportedContent\"]/div/a[2]/p";
	
	public static final String LOGINEMAIL="//*[@id=\"email\"]";
	public static final String LOGINPASS="//*[@id=\"password\"]";
	public static final String LOGINCONFIRMED="//*[@id=\"LoginForm\"]/div[3]/div/button[1]";
	
	public static final String STARTRIAL_XPATH="//*[@id=\"navbarSupportedContent\"]/div/a[3]";
	public static final String START_XPATH2="//*[@id=\"popup-free-trial-link\"]";
	
	public static final String ABOUT_XPATH="//*[@id=\"navbarSupportedContent\"]/ul/li[6]/a";
	public static final String ABOUTUS_XPATH="//*[@id=\"navbarSupportedContent\"]/ul/li[6]/ul/li[1]/a/p[1]";
	public static final String PROFILEMENU="//*[@id=\"wrap_us_menu\"]/i";
	public static final String SIGNOUT="//*[@id=\"userm\"]/div/div[5]/a";
	
	//close pop up at the beginning
	
	public static void closePopUp(WebDriver wd) {
		wd.findElement(By.xpath("//*[@id=\"tcp-modal\"]/div/div/div[1]/button")).click();
	}
	
	//registration of new account 1
	
	public static void clickName(WebDriver wd, String fullName) {
		WebElement name=wd.findElement(By.xpath(FULLNAME_XPATH));
		name.click();
		name.sendKeys(fullName);
	}
	
	public static void clickEmail(WebDriver wd, String email) {
		WebElement mail=wd.findElement(By.xpath(WORK_EMAIL));
		mail.click();
		mail.sendKeys(email);
	}
	
	public static void startFree(WebDriver wd) {
		wd.findElement(By.xpath(START_XPATH)).click();
	}
	
	public static void clickComp(WebDriver wd, String companyName) {
		WebElement company=wd.findElement(By.xpath(COMP_XPATH));
		company.click();
		company.sendKeys(companyName);
	}
	
	public static void clickInd(WebDriver wd, int positionOnList) {
		WebElement elem = wd.findElement(By.xpath(INDUSTRY_XPATH));
		elem.click();
		for(int i=1;i<=positionOnList; i++) {
		elem.sendKeys(Keys.ARROW_DOWN);
		}
		elem.sendKeys(Keys.ENTER);
	}
	
	public static void clickFunctionalRole(WebDriver wd, int positionOnList) {
		WebElement elem = wd.findElement(By.xpath(FUNCTIONAL_ROLE));
		elem.click();
		for(int i=1;i<=positionOnList; i++) {
		elem.sendKeys(Keys.ARROW_DOWN);
		}
		elem.sendKeys(Keys.ENTER);
	}
	
	public static void submitPhone(WebDriver wd, String phone) {
		WebElement call=wd.findElement(By.xpath(PHONE_XPATH));
		call.click();
		call.sendKeys(phone);
	}
	
	public static void submitPass(WebDriver wd, String password) {
		WebElement pass=wd.findElement(By.xpath(PASS_XPATH));
		pass.click();
		pass.sendKeys(password);
	}
	
	public static void submitRepeatPass(WebDriver wd, String repeatPassword) {
		WebElement repeat=wd.findElement(By.xpath(REPEAT_XPATH));
		repeat.click();
		repeat.sendKeys(repeatPassword);
	}
	
	public static void submit(WebDriver wd) {
		wd.findElement(By.xpath(SUBMIT_XPATH)).click();
	}
	
	//registration of new account 2
	
	public static void startFree2(WebDriver wd) {
		wd.findElement(By.xpath(STARTRIAL_XPATH)).click();
	}
	
	public static void fullName2 (WebDriver wd, String fullName) {
		WebElement name=wd.findElement(By.name("popupname"));
		name.click();
		name.sendKeys(fullName);
	}
	
	public static void email2 (WebDriver wd, String email) {
		WebElement name=wd.findElement(By.name("popupmail"));
		name.click();
		name.sendKeys(email);
	}
	
	public static void start2 (WebDriver wd) {
		wd.findElement(By.xpath(START_XPATH2)).click();
	}
	
	//sign in
	
	public static void login(WebDriver wd) {
		wd.findElement(By.xpath(LOGIN_BUTTON)).click();
	}
	
	public static void loginEmail(WebDriver wd, String email) {
		WebElement em=wd.findElement(By.xpath(LOGINEMAIL));
		em.click();
		em.sendKeys(email);
	}
	
	public static void loginPass(WebDriver wd, String password) {
		WebElement pas=wd.findElement(By.xpath(LOGINPASS));
		pas.click();
		pas.sendKeys(password);
	}
	
	public static void loginButton(WebDriver wd) {
		wd.findElement(By.xpath(LOGINCONFIRMED)).click();
	}
	
	//sign out
	
	public static void signOut(WebDriver wd) {
		WebElement out=wd.findElement(By.xpath(PROFILEMENU));
		out.click();
		out.findElement(By.xpath(SIGNOUT)).click();
	}
	
	//screenshot
	
	public static void screenshot(WebDriver wd, String fileDirection) {
		TakesScreenshot scrShot =((TakesScreenshot)wd);
	    File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
	    File DestFile=new File(fileDirection);
	    try {
			FileHandler.copy(SrcFile, DestFile);
		} catch (IOException e) {
			System.out.println("Screenshot was not taken!");
			e.printStackTrace();
		}
	}
	
	public static void aboutUs(WebDriver wd) {
		WebElement about=wd.findElement(By.xpath(ABOUT_XPATH));
		about.click();
		WebElement about1=wd.findElement(By.xpath(ABOUTUS_XPATH));
		about1.click();
	}
	
}
