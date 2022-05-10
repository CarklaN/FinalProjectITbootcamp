package objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MenuElements {
	
	public static final String DASH_XPATH="//*[@id=\"sn_dashboard\"]/span/p";
	public static final String SHIFT_XPATH="//*[@id=\"sn_schedule\"]/span";
	public static final String TIME_XPATH="//*[@id=\"sn_timeclock\"]/span";
	public static final String LEAVE_XPATH="//*[@id=\"sn_requests\"]/span";
	public static final String TRAINING_XPATH="//*[@id=\"sn_training\"]/span";
	public static final String STAFF_XPATH="//*[@id=\"sn_staff\"]/span";
	public static final String AVAIL_XPATH="//*[@id=\"sn_availability\"]/span";
	public static final String PAY_XPATH="//*[@id=\"sn_payroll\"]/span";
	public static final String REPORTS_XPATH="//*[@id=\"sn_reports\"]/span";
	
	//Web page objects and methods for menu
	
	public static void dashboard(WebDriver wd) {
	    wd.findElement(By.xpath(DASH_XPATH)).click();;
	}
	
	public static void shiftPlanning(WebDriver wd) {
		wd.findElement(By.xpath(SHIFT_XPATH)).click();
	}
	
	public static void timeClock(WebDriver wd) {
		wd.findElement(By.xpath(TIME_XPATH)).click();
	}
	
	public static void leave(WebDriver wd) {
		wd.findElement(By.xpath(LEAVE_XPATH)).click();
	}
	
	public static void training(WebDriver wd) {
		wd.findElement(By.xpath(TRAINING_XPATH)).click();
	}
	
	public static void staff(WebDriver wd) {
		wd.findElement(By.xpath(STAFF_XPATH)).click();
	}
	
	public static void availability(WebDriver wd) {
		wd.findElement(By.xpath(AVAIL_XPATH)).click();
	}
	
	public static void payroll(WebDriver wd) {
		wd.findElement(By.xpath(PAY_XPATH)).click();
	}
	
	public static void reports(WebDriver wd) {
		wd.findElement(By.xpath(REPORTS_XPATH)).click();
	}
	
}
