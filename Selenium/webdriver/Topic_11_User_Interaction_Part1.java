package webdriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;



public class Topic_11_User_Interaction_Part1 {
	WebDriver driver;
	Actions action;
	@BeforeClass
	public void beforeClass() {
		driver = new FirefoxDriver();
		action = new Actions(driver);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		}

	
	@Test
	public void TC_01_hover_mouse() {
		driver.get("https://tiki.vn/");
		
		//verify login button is undisplayed
		Assert.assertFalse(driver.findElement(By.xpath("//button[text()='Đăng nhập']")).isDisplayed());
		
		WebElement shortCutAccount = driver.findElement(By.xpath("//span[@class='Userstyle__ItemText-sc-6e6am-2 bKCghQ']"));
		 
		action.moveToElement(shortCutAccount).perform();
		sleepInSecond(4);
		
		//Verify login button is displayed
		Assert.assertTrue(driver.findElement(By.xpath("//button[text()='Đăng nhập']")).isDisplayed());
	}
	

	@Test
	public void TC_02_hover_mouse() {
		driver.get("https://jqueryui.com/resources/demos/tooltip/default.html");
		action.moveToElement(driver.findElement(By.id("age"))).perform();
		sleepInSecond(3);
		
		Assert.assertEquals(driver.findElement(By.xpath("//div[@class='ui-tooltip-content']")).getText(), "We ask for your age only for statistical purposes.");
		
	}

	@Test
	public void TC_03_hover_mouse() {
		driver.get("https://hn.telio.vn/");
		
		action.moveToElement(driver.findElement(By.xpath("//nav[@class='navigation cdz-fix-left']//span[text()='Đồ uống']"))).perform();
		
		action.click(driver.findElement(By.xpath("//nav[@class='navigation cdz-fix-left']//a[text()='Bia']"))).perform();
		
		//DOM
		Assert.assertTrue((driver.findElement(By.xpath("//h1[@id='page-title-heading']/span[text()='Bia']"))).isDisplayed());
		//UI
		//Assert.assertEquals(driver.findElement(By.xpath("//h1[@id='page-title-heading']/span]")).getText(), "BIA");
		
	}

	@Test
	public void TC_04_Click_And_hold() {
		driver.get("http://jqueryui.com/resources/demos/selectable/display-grid.html");
		
		//Tạo ra 1 list chứa hết tất cả 12 number
		List<WebElement> allNumber =  driver.findElements(By.xpath("//ol[@id='selectable']/li"));
		System.out.println("All number =" + allNumber.size());
		//0-11: index
		//1-12:  element value
		
		action.clickAndHold(allNumber.get(0)).moveToElement(allNumber.get(10)).release().perform();
		sleepInSecond(1);
		
		List<WebElement> allNumberSelected = driver.findElements(By.xpath("//ol[@id='selectable']/li[contains(@class,'ui-selected')]"));
		System.out.println("Number selected" + allNumberSelected.size());
		
		Assert.assertEquals(allNumberSelected.size(),9);
	}
	
	@Test
	public void TC_05_Click_And_hold_Random() {
		driver.get("http://jqueryui.com/resources/demos/selectable/display-grid.html");
		
		//Tạo ra 1 list chứa hết tất cả 12 number
		List<WebElement> allNumber =  driver.findElements(By.xpath("//ol[@id='selectable']/li"));
		System.out.println("All number =" + allNumber.size());
		
		//Nhấn phím Ctrl xuống
		action.keyDown(Keys.CONTROL).perform();
		
		//Click vào các số 1 3 6 12
		action.click(allNumber.get(0))
		.click(allNumber.get(2))
		.click(allNumber.get(5))
		.click(allNumber.get(11))
		.perform();
		sleepInSecond(3);
		
		//Nhả phím Ctrl ra
		action.keyUp(Keys.CONTROL).perform();
		sleepInSecond(3);
		
		List<WebElement> allNumberSelected = driver.findElements(By.xpath("//ol[@id='selectable']/li[contains(@class,'ui-selected')]"));
		System.out.println("Number selected" + allNumberSelected.size());
		
		Assert.assertEquals(allNumberSelected.size(), 4);
		
		
		
	}
	
	@Test
	public void TC_06_Double_Click() {
		driver.get("https://automationfc.github.io/basic-form/index.html") ;
	
		action.doubleClick(driver.findElement(By.xpath("//button[text()='Double click me']"))).perform();
		sleepInSecond(3);
		
		Assert.assertTrue(driver.findElement(By.xpath("//p[text()='Hello Automation Guys!']")).isDisplayed());
		
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}
	public void sleepInSecond(long timeInSecond) {
		try {
			Thread.sleep(timeInSecond*1000);
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
		}

}

