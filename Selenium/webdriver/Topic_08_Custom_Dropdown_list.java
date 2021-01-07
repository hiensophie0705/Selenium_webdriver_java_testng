package webdriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.google.common.base.Predicate;

public class Topic_08_Custom_Dropdown_list {
	WebDriver driver;
	WebDriverWait explicitWait;

	// anotation chi dan
	@BeforeClass
	public void beforeClass() {
		driver = new FirefoxDriver();
		explicitWait = new WebDriverWait(driver, 30);

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	@Test
	public void TC_01() {
		driver.get("http://jqueryui.com/resources/demos/selectmenu/default.html");

		selectIteminCustomDropdown("//span[@id='number-button']", "//ul[@id='number-menu']//div");
	}

	@Test
	public void TC_02() {
		driver.get("http://jqueryui.com/resources/demos/selectmenu/default.html");

		selectIteminCustomDropdown();

	}

	@Test
	public void TC_03() {
		driver.get("http://jqueryui.com/resources/demos/selectmenu/default.html");

		selectIteminCustomDropdown("//span[@id='number-button']", "//ul[@id='number-menu']//div");

	}

	// 1 click vao 1 element bat ky cua dropdown de cho no xo het item ra
	// 2 Cho cho all cac item duoc load len
	// 3 Luu no lai vao 1 list chua nhung element
	// 4 Lay ra text cua tung element
	// 5 Kiem tra no co bang voi cai text can tim khong
	// 6 Neu nhu co thi click vao thoat khoi vong lap
	// 7 Neu nhu khong co thi tiep tuc duyet nhung item khac cho den khi het all
	// item

	// common
	public void selectIteminCustomDropdown(String parentXpath, String allItemXpath, String expectedValueItem) {
		//1 click vao 1 element bat ky cua dropdown de cho no xo het item ra
		driver.findElement(By.xpath(parentXpath)).click();
		
		//2 Cho cho all cac item duoc load len	
		explicitWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(allItemXpath)));
		
		// 3 Luu no lai vao 1 list chua nhung element
		List<WebElement> allItems =  driver.findElements(By.xpath(allItemXpath));
		int allItemsNumber = allItems.size();
		
		//luu tru du lieu(data structure)
		//array/List/Set/Queue> index
		//0 1 2 3
		//Duyet qua tung element va lay ra text
		for (int i = 0; i < allItemsNumber; i++) {
			String actualValueItem = allItems.get(i).getText();
			
		//5 kiem tra no co bang voi text can tim hay khong
			if(actualValueItem.equals(expectedValueItem)) {
				//6 neu nhu co thi click vao thoat khoi vong lap
				allItems.get(i).click();
				break;
			}
			//Neu nhu khong co thi lien tuc duyet nhung item khac cho den khi het all item
			
		}
			
		}
		
				
	}
