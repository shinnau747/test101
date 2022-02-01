package TestCases;

import org.testng.Assert;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page.Testing101page;
import util.TestBase;

public class ToggleAllChecked {
	
	Testing101page testing101Obj;
	WebDriver driver;
	
	@BeforeMethod
	public void setUp() {
		
		driver = TestBase.init();
		testing101Obj = PageFactory.initElements(driver, Testing101page.class);
		
	}
	
	@Test(priority = 1)
	public void addList () throws Throwable {
		
		try {
			
			Scanner sc = new Scanner(new File(".//input.txt"));
			while (sc.hasNextLine()) {
				
				String listItem = sc.nextLine();
				testing101Obj.enterlistItem(listItem);
				testing101Obj.clickAddButton();
			    Thread.sleep(2000);
			}
			

			
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	@Test(priority = 2)
	public void testToggleAllButton() throws Throwable {
		
		boolean toggleAllSelected = testing101Obj.clickToggleAllButton().isSelected();
		//asserting toggle all button selected
		Assert.assertEquals(toggleAllSelected, true);
        Thread.sleep(2000);
        //asserting items have been selected as well
		
        Assert.assertEquals(testing101Obj.assertItems(), false);
		
		
	}
	
	//@AfterMethod
	//public void tearDown() {
	//	driver.close();
	//	driver.quit();
	//}

}
