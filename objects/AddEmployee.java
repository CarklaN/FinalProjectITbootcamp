package objects;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AddEmployee {
	public static final String SHIFTTAB="//*[@id=\"sn_schedule\"]/span";
	public static final String ADDEMPL="//*[@id=\"e_empty\"]/button";
	public static final String INPUTNAME="//*[@id=\"fname_2\"]";
	public static final String INPUTLASTN="//*[@id=\"lname_2\"]";
	public static final String POSITION="//*[@id=\"positions_2-selectized\"]";
	public static final String CONTINUEBUTTON="//*[@id=\"add_employee_btn\"]";
	public static final String EMPLOYXPATH="//*[@id=\"e_6084360\"]/div/span";
	public static final String EDITDETAILS="//*[@id=\"_cd_staff\"]/div[2]/div[2]/div[1]/a[2]";
	public static final String SAVECHANGES="/html/body/table/tbody/tr/td/div[9]/div[5]/div[2]/div[2]/div[2]/table/tbody/tr/td[2]/form/table/tbody/tr[39]/td/input";
	public static final String STAFF_XPATH="//*[@id=\"sn_staff\"]/span";
	public static final String PICTUREUPLOAD="//*[@id=\"in-btn\"]";
	public static final String STAFFTAB_URL="https://agroit.humanity.com/app/staff/list/";

	public static void openShiftTab(WebDriver wd) {
		wd.findElement(By.xpath(SHIFTTAB)).click();
	}
	
	public static void addEmp(WebDriver wd) {
		wd.findElement(By.xpath(ADDEMPL)).click();
	}
	
	public static void inputName (WebDriver wd, String nameOfEmployee) {
		WebElement n=wd.findElement(By.xpath(INPUTNAME));
		n.click();
		n.sendKeys(nameOfEmployee);
	}
	
	public static void inputLastName (WebDriver wd, String lastNameOfEmployee) {
		WebElement n=wd.findElement(By.xpath(INPUTLASTN));
		n.click();
		n.sendKeys(lastNameOfEmployee);
	}
	
	public static void jobPosition(WebDriver wd, String jobPosition) {
		WebElement n=wd.findElement(By.xpath(POSITION));
		n.click();
		n.sendKeys(jobPosition);
		n.sendKeys(Keys.ENTER);
	}
	
	public static void pressContinue(WebDriver wd) {
		wd.findElement(By.xpath(CONTINUEBUTTON)).click();
	}
	
	public static void openStaff(WebDriver wd) {
		wd.findElement(By.xpath(STAFF_XPATH)).click();
	}
	
	public static void editDetails(WebDriver wd) {
		wd.findElement(By.xpath(EDITDETAILS)).click();;
	}
	
	public static void clickEmployee(WebDriver wd) {
		wd.findElement(By.xpath(EMPLOYXPATH)).click();
	}
	
	public static void changeName(WebDriver wd, String newName) {
		WebElement n=wd.findElement(By.id("first_name"));
		n.click();
		n.clear();
		n.sendKeys(newName);
	}
	
	public static void changeLastName(WebDriver wd, String newLastName) {
		WebElement n=wd.findElement(By.id("last_name"));
		n.click();
		n.clear();
		n.sendKeys(newLastName);
	}
	
	public static void saveChanges(WebDriver wd) {
		wd.findElement(By.xpath(SAVECHANGES)).click();
	}
	
	
	public static void pictureUpload(WebDriver wd) throws Throwable {
		WebElement upl=wd.findElement(By.xpath(PICTUREUPLOAD));
		upl.click();
		Thread.sleep(2000);
		
		Robot r = new Robot();
		//input path to the file and press enter to upload
		r.keyPress(KeyEvent.VK_BACK_SLASH);    
		r.keyRelease(KeyEvent.VK_BACK_SLASH);
		r.keyPress(KeyEvent.VK_F);    
		r.keyRelease(KeyEvent.VK_F);
		r.keyPress(KeyEvent.VK_A);    
		r.keyRelease(KeyEvent.VK_A);
		r.keyPress(KeyEvent.VK_J);    
		r.keyRelease(KeyEvent.VK_J);
		r.keyPress(KeyEvent.VK_L);    
		r.keyRelease(KeyEvent.VK_L);
		r.keyPress(KeyEvent.VK_PERIOD);    
		r.keyRelease(KeyEvent.VK_PERIOD);
		r.keyPress(KeyEvent.VK_P);    
		r.keyRelease(KeyEvent.VK_P);
		r.keyPress(KeyEvent.VK_N);   
		r.keyRelease(KeyEvent.VK_N);
		r.keyPress(KeyEvent.VK_G);  
		r.keyRelease(KeyEvent.VK_G);
		r.keyPress(KeyEvent.VK_ENTER);    
		r.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(3000);	
	}
	
}
