package page;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;

public class Testing101page {
	
	WebDriver driver;
	public Testing101page(WebDriver driver) {
		this.driver = driver;
	}
	
	// Element Library
	@FindBy(how = How.NAME , using = "allbox")
	 WebElement ToggleAll;
	@FindBy(how = How.NAME , using = "data")
	WebElement AddListBar;
	@FindBy(how = How.XPATH, using = "//*[@value=\"Add\"]")
	WebElement SubmitButton;
	@FindBy(how = How.NAME, using = "todo[0]")
	WebElement ItemChecked;
	@FindBy(how = How.XPATH, using = "//*[@value=\"Remove\"]")
	WebElement RemoveButton;
	@FindBy(how = How.NAME, using = "categorydata")
	WebElement CategoryData;
	@FindBy(how = How.XPATH, using = "//*[@value=\"Add category\"]")
	WebElement ClickCategoryData;
	@FindBy(how = How.NAME, using = "category")
	WebElement Category;
	@FindBy(how = How.XPATH, using = "//*[@id=\"extra\"]/select[3]")
	WebElement Month;
	
	public boolean checkForAllMonthsInMonthDropDown() {
		
		 String[] arr = {"Month","Jan","Feb","Mar", "Apr","May","Jun","Jul","Aug","Sep","Oct","Nov","Dec"};
		 Select select = new Select(Month);
		 List<WebElement> options = select.getOptions();
         System.out.println("Displaying All the months in the Date drop down menu:" );

		 for(WebElement we : options){
		     for(int i = 1; i<arr.length; i++){
		         if(we.getText().equals(arr[i])){
		        	 String mnt=we.getText();
		             System.out.println(mnt );
		             break;
		         }
		         
		     }
		 }
		return true;
	
	}
	


	public boolean assertItems () {
	List<WebElement> listofItemsAdded = driver.findElements(By.name("todo"));
	if(listofItemsAdded.isEmpty()==true) {
		//boolean itemsremoved = true;
		return true;
	}
	else {
		
		for (WebElement element: listofItemsAdded ) {
			element.isSelected();
			System.out.println(element.getText());
		}
		return false;

	}
	

		
	}

	// Methods to interact with the elements
	public WebElement clickToggleAllButton() {
		ToggleAll.click();
		return ToggleAll;
		
	}
	
	public void enterlistItem(String listItems) {
		AddListBar.sendKeys(listItems);
	}

	public void clickAddButton() {
		SubmitButton.click();
	} 
	public void checkItem() {
		ItemChecked.click();
	
	}
	
	public WebElement clickRemoveButton() {
		RemoveButton.click();
		return RemoveButton;
	}
	
	public void addCategoryData(String addCategory) {
		CategoryData.sendKeys(addCategory);
	}
	
	public void clickCategoryDataButton() {
		ClickCategoryData.click();
	}
	
	public void selectCategory(String categoryAdded) {
		Select sel = new Select(Category);
		sel.selectByVisibleText(categoryAdded);
	}
	public String assertduplicateCategory() {
		WebElement element =driver.findElement(By.tagName("body"));
		String str= element.getText();
		return str;
	}
	public void clickOnMount() {
		//Select sel= new Select(Month);
		
		Month.click();
	}

}
