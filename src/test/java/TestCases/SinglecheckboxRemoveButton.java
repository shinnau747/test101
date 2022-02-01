package TestCases;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page.Testing101page;
import util.TestBase;

public class SinglecheckboxRemoveButton {

	Testing101page testing101Object;
	WebDriver driver;

	
	@BeforeMethod
	public void setUp() {
		
		driver = TestBase.init();
		testing101Object = PageFactory.initElements(driver, Testing101page.class);
		
	}
	
	@Test (priority=1)
	public void addList () throws Throwable {
		
		try {
			
			Scanner sc = new Scanner(new File(".//input2.txt"));
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
	
	@Test(priority =2)
	public void removeSingleItemChecked () throws Throwable {
		testing101Object.checkItem();
		Thread.sleep(2000);
		boolean removebutton= testing101Object.clickRemoveButton().isSelected();
		
		//validating item got removed 
        Assert.assertEquals(removebutton, false);
		Thread.sleep(2000);

      }
	
	@AfterMethod
	public void tearDown() {
		driver.close();
		driver.quit();
	}
	

}
