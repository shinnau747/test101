package TestCases;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import page.Testing101page;
import util.TestBase;

public class AddCategory {
	
	Testing101page testing101Obj;
	WebDriver driver;
	
	@BeforeMethod
	public void setUp() {
		
		driver = TestBase.init();
		testing101Obj = PageFactory.initElements(driver, Testing101page.class);
		
	}
	
	@Test (priority=1)
	public void addCategoryData() throws Throwable {
		
try {
			
			Scanner sc = new Scanner(new File(".//input2.txt"));
			while (sc.hasNextLine()) {
				
				String categoryNameAdd = sc.nextLine();
				testing101Obj.addCategoryData(categoryNameAdd);
				testing101Obj.clickCategoryDataButton();
				testing101Obj.selectCategory(categoryNameAdd);
				
				//Validating by taking screen shot
				TestBase.takeScreenshotAtEndOfTest(driver);

				Thread.sleep(2000);
			}
			

		} catch (IOException e) {
			e.printStackTrace();
		}

}
	
	//@Test(priority=2)
	//public void checkCategoryGotAdded() throws Throwable {
		
		//testing101Obj.selectCategory(categoryNameAdd);
        //Thread.sleep(3000);

	//}
	
	//@AfterMethod
	//public void tearDown() {
	//	driver.close();
	//	driver.quit();
	//}

}
