package tests;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import objects.AddEmployee;
import objects.Login;

public class AddEmployeesThroughExcelPOI {
	
	
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
	
	@Test  //adding 5 employees from excel sheet
	public void addEmployees() throws Throwable  {
		
		    AddEmployee.openShiftTab(wd);
		    Thread.sleep(3000); 
		    
		    AddEmployee.addEmp(wd);
			Thread.sleep(2000);

		File f = new File("employees.xlsx");
		
		try {
			InputStream inp = new FileInputStream(f); 
			XSSFWorkbook wb = new XSSFWorkbook(inp); 
			Sheet sheet = wb.getSheetAt(0); 

			SoftAssert sa = new SoftAssert();
			
			for (int i = 0; i < 5 ; i++) { //go through excel sheet
				
				Row row = sheet.getRow(i);
				
				Cell c1 = row.getCell(0);
				Cell c2 = row.getCell(1);
				Cell c3 = row.getCell(2);
	
				//convert cell inside text to String
				String name = c1.toString();         
				String lastName = c2.toString();
				String position = c3.toString();
				
				//insert defined string inside the name, last name, and position brackets
				AddEmployee.inputName(wd, name);
				Thread.sleep(1000);
				AddEmployee.inputLastName(wd, lastName);
				Thread.sleep(1000);
				AddEmployee.jobPosition(wd, position);
				Thread.sleep(1000);
				AddEmployee.pressContinue(wd);
				Thread.sleep(2000);
				
				//get page source, and look inside it for name of added employee
				String et=wd.getPageSource();
				
				boolean contain=false;
				if(et.contains(name+" "+lastName)) 
					contain=true;
				Assert.assertTrue(contain);
				Thread.sleep(2000);
				AddEmployee.openShiftTab(wd);
				Thread.sleep(3000);
				AddEmployee.addEmp(wd);
			}
			sa.assertAll();
			
			wb.close();
			
		} catch (IOException e) {
			System.out.println("Nije pronadjen fajl!");
			e.printStackTrace();
		} 
	}
}
