package util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestBase {
	
public static WebDriver driver;
	
	
	public static WebDriver init() {
		
		System.setProperty("webdriver.chrome.driver", "driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		//driver.get("https://techfios.com/billing/?ng=login/");
		driver.get("https://techfios.com/test/101/index.php");
		return driver;
	}
	
	public static String fileRead() throws IOException{
		
	
			//File file = new File(".//input.txt");
			//FileReader fr = new FileReader(file);
			//BufferedReader br = new BufferedReader(fr);
			//String content ="";
		Scanner sc = new Scanner(new File(".//input.txt"));
			while (sc.hasNextLine()) {
				
				String content = sc.nextLine();
				return content;

			}
			return null;
			
	
		
		

	}
	public static void takeScreenshotAtEndOfTest(WebDriver driver) throws IOException {
		TakesScreenshot ts = ((TakesScreenshot) driver);
		File sourceFile = ts.getScreenshotAs(OutputType.FILE);
		String currentDir = System.getProperty("user.dir");
		SimpleDateFormat formatter = new SimpleDateFormat ("MMddyy_HHmmss");
		Date date = new Date(0);
		String label = formatter.format(date);
		FileUtils.copyFile(sourceFile, new File(currentDir + "/screenshot/" + label + ".png"));
		
		
	}

}
