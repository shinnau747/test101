package TestCases;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import page.Testing101page;
import util.TestBase;

public class DuplicateCategory {
	
	Testing101page testing101Obj;
	WebDriver driver;
	
	@BeforeMethod
	public void setUp() {
		
		driver = TestBase.init();
		testing101Obj = PageFactory.initElements(driver, Testing101page.class);
		
	}
	
	@Test ()
	public void addCategoryData() throws Throwable {
		
try {
			
			Scanner sc = new Scanner(new File(".//input2.txt"));
			while (sc.hasNextLine()) {
				
				String categoryNameAdd = sc.nextLine();
				testing101Obj.addCategoryData(categoryNameAdd);
				testing101Obj.clickCategoryDataButton();
				
				testing101Obj.addCategoryData(categoryNameAdd);
				testing101Obj.clickCategoryDataButton();
	

				String expected = "The category you want to add already exists:";
				String actual = testing101Obj.assertduplicateCategory();
				Assert.assertEquals(actual, expected);

				Thread.sleep(2000);
			}
			

		} catch (IOException e) {
			e.printStackTrace();
		}

}
	


}
