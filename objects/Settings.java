package objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class Settings {
	public static final String PROFILEMENU="//*[@id=\"wrap_us_menu\"]/i";
	public static final String SETTINGS="//*[@id=\"userm\"]/div/a[2]";
	public static final String LANGUAGE="/html/body/table/tbody/tr/td/div[9]/div[5]/div[2]/div[2]/div[2]/table/tbody/tr/td[2]/form/table/tbody/tr[4]/td[2]/select";
	public static final String NOTIFICATIONS="//*[@id=\"_cd_staff\"]/div[2]/div[2]/div[1]/a[6]";
	public static final String SAVEBUTTONEMP="//*[@id=\"notif-settings\"]";
	public static final String EDITTAB="//*[@id=\"_cd_staff\"]/div[2]/div[2]/div[1]/a[2]";
	public static final String OVERVIEWTAB="//*[@id=\"_cd_staff\"]/div[2]/div[2]/div[1]/a[1]";
	public static final String NICKNAME="//*[@id=\"nick_name\"]";
	public static final String ADDRESS="//*[@id=\"address\"]";
	public static final String CITY="//*[@id=\"city\"]";
	public static final String STATE="//*[@id=\"state\"]";
	public static final String POSTALCODE="//*[@id=\"zip\"]";
	public static final String JOBTITLE="//*[@id=\"job_title\"]";
	public static final String GENDER="//*[@id=\"gender\"]";
	public static final String BIRTH_MONTH="//*[@id=\"birth_month\"]";
	public static final String BIRTH_DAY="//*[@id=\"birth_day\"]";
	public static final String SAVECHANGES="/html/body/table/tbody/tr/td/div[9]/div[5]/div[2]/div[2]/div[2]/table/tbody/tr/td[2]/form/table/tbody/tr[42]/td/input";
	
	//notifications and language setup 
	
	public static void turnOffNotifications(WebDriver wd) throws Throwable {
		wd.findElement(By.xpath(NOTIFICATIONS)).click();
		Thread.sleep(2000);
		WebElement email=wd.findElement(By.id("email[pref]"));
		email.click();
		WebElement sms=wd.findElement(By.id("sms[pref]"));
		sms.click();
		WebElement mobile=wd.findElement(By.id("mobile_push[pref]"));
		mobile.click();
	}
	
	public static void openSettings(WebDriver wd) {
		WebElement prof=wd.findElement(By.xpath(PROFILEMENU));
		prof.click();
		WebElement set=wd.findElement(By.xpath(SETTINGS));
		set.click();
	}
	
	public static void clickLanguage(WebDriver wd, String language)  {
		Select se = new Select(wd.findElement(By.xpath(LANGUAGE)));
		se.selectByValue("sr_RS");
		
	}
	
	public static void clickSaveChang(WebDriver wd) {
		wd.findElement(By.xpath(SAVEBUTTONEMP)).click();
	}

	//for AdditionalProfileSettings
	
	public static void editDetailsTab(WebDriver wd) {
		wd.findElement(By.xpath(EDITTAB)).click();
	}
	
	public static void overviewTab(WebDriver wd) {
		wd.findElement(By.xpath(OVERVIEWTAB)).click();;
	}
	
	public static void nickName(WebDriver wd, String nickName) {
		WebElement n=wd.findElement(By.xpath(NICKNAME));
		n.click();
		n.sendKeys(nickName);
	}
	
	public static void address(WebDriver wd, String address) {
		WebElement n=wd.findElement(By.xpath(ADDRESS));
		n.click();
		n.sendKeys(address);
	}
	
	public static void city(WebDriver wd, String city) {
		WebElement n=wd.findElement(By.xpath(CITY));
		n.click();
		n.sendKeys(city);
	}
	
	public static void state(WebDriver wd, String state) {
		WebElement n=wd.findElement(By.xpath(STATE));
		n.click();
		n.sendKeys(state);
	}
	
	public static void postalCode(WebDriver wd, String postalCode) {
		WebElement n=wd.findElement(By.xpath(POSTALCODE));
		n.click();
		n.sendKeys(postalCode);
	}
	
	public static void jobTitle(WebDriver wd, String jobTitle) {
		WebElement n=wd.findElement(By.xpath(JOBTITLE));
		n.click();
		n.sendKeys(jobTitle);
	}
	
	public static void gender(WebDriver wd, String writeMorF) {
		Select n=new Select(wd.findElement(By.xpath(GENDER)));
		n.selectByValue(writeMorF);
	}
	
	public static void birthMonth(WebDriver wd, String birthMonthText) {
		Select n=new Select(wd.findElement(By.xpath(BIRTH_MONTH)));
		n.selectByVisibleText(birthMonthText);
	}
	
	public static void birthDay(WebDriver wd, String birthDay) {
		Select n=new Select(wd.findElement(By.xpath(BIRTH_DAY)));
		n.selectByVisibleText(birthDay);
	}
	
	public static void saveChanges(WebDriver wd) {
		wd.findElement(By.xpath(SAVECHANGES)).click();
	}
}
