package TestCases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import page.Testing101page;
import util.TestBase;

public class MonthDropDown {
	
	Testing101page testing101Obj;
	WebDriver driver;
	
	@BeforeMethod
	public void setUp() {
		
		driver = TestBase.init();
		testing101Obj = PageFactory.initElements(driver, Testing101page.class);
		
	}
	
	@Test ()
	public void monthDisplay() throws Throwable {
		testing101Obj.clickOnMount();
		Thread.sleep(2000);
		
		boolean mnt = testing101Obj.checkForAllMonthsInMonthDropDown();
		Assert.assertEquals(mnt, true);
	
	}
}



