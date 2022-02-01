package TestCases;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page.Testing101page;
import util.TestBase;

public class ToggleAllRemoveButton {
	
	Testing101page testing101Object;
	WebDriver driver;
	
	@BeforeMethod
	public void setUp() {
		
		driver = TestBase.init();
		testing101Object = PageFactory.initElements(driver, Testing101page.class);
		
	}
	
	@Test(priority = 1)
	public void addList () throws Throwable {
		try {
		
			Scanner sc = new Scanner(new File(".//input.txt"));
			while (sc.hasNextLine()) {
				
				String listItem = sc.nextLine();
				testing101Object.enterlistItem(listItem);
				testing101Object.clickAddButton();
			    Thread.sleep(2000);
			}
			

			
		} catch (IOException e) {
			e.printStackTrace();
		}


	}

	
	@Test(priority=2)
	public void removeAllToggleAll () throws Throwable {
		boolean toggleAllSelected = testing101Object.clickToggleAllButton().isSelected();
		//asserting toggle all button selected
		Assert.assertEquals(toggleAllSelected, true);
        Thread.sleep(2000);
        System.out.println("print out after asserting toggle all button has been clicked");

        testing101Object.clickRemoveButton();
        //asserting all items removed after toggle all button click
        Assert.assertEquals(testing101Object.assertItems(), false);
        

        System.out.println("Items have been Removed after toggle all button click");
    
	}

	//@AfterMethod
	//public void tearDown() {
	//	driver.close();
	//	driver.quit();
	//}

}
