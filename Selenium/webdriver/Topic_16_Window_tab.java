package webdriver;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_16_Window_tab {
	WebDriver driver;

	@BeforeClass
	public void beforeClass() {
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}

	@Test
	public void TC_01_Only_2_Windows_Tabs() {
		driver.get("https://automationfc.github.io/basic-form/index.html");

		// Lấy ra cái ID của tab trước khi click
		String parentWindowID = driver.getWindowHandle();
		System.out.println(parentWindowID);
		// click Google
		driver.findElement(By.xpath("//a[text()='GOOGLE']")).click();
		sleepInSecond(3);

		// switch về parent window
		switchToWindowByID(parentWindowID);
		sleepInSecond(3);
		// verify hiển thị đúng google page
		Assert.assertTrue(driver.findElement(By.xpath("//img[@id='hplogo']")).isDisplayed());
		sleepInSecond(3);

		// Lấy ra ID của tab google
		String googleWindowID = driver.getWindowHandle();
		sleepInSecond(3);

		// switch về trang google
		switchToWindowByID(googleWindowID);
		sleepInSecond(2);

		// click Facebook

		driver.findElement(By.xpath("//a[text()='FACEBOOK']")).click();
	}

	@Test
	public void TC_02_Greater_Than_2_Windows_Tabs() {
		driver.get("https://automationfc.github.io/basic-form/index.html");
		
		// lấy ra cái Id của tab trước khi click
		String parentID = driver.getWindowHandle();

		driver.findElement(By.xpath("//a[text()='GOOGLE']")).click();
		sleepInSecond(2);

		switchToWindowByTitle("Google");
		sleepInSecond(2);
		Assert.assertTrue(driver.findElement(By.xpath("//img[@id='hplogo']")).isDisplayed());

		switchToWindowByTitle("SELENIUM WEBDRIVER FORM DEMO");
		sleepInSecond(2);

		driver.findElement(By.xpath("//a[text()='FACEBOOK']")).click();
		sleepInSecond(2);

		switchToWindowByTitle("Facebook - Đăng nhập hoặc đăng ký");
		sleepInSecond(2);
		Assert.assertTrue(driver.findElement(By.xpath("//button[@name='login']")).isDisplayed());

		switchToWindowByTitle("SELENIUM WEBDRIVER FORM DEMO");
		sleepInSecond(2);

		driver.findElement(By.xpath("//a[text()='LAZADA']")).click();
		sleepInSecond(2);

		switchToWindowByTitle("Shopping online - Buy online on Lazada.vn");
		sleepInSecond(2);

		Assert.assertTrue(driver.findElement(By.xpath("//input[@id='q']")).isDisplayed());

		// Chỉ giữ lại trang đầu tiên(parent) -close hết tất cả các tab /window còn lại
		closeAllWindowExceptParent(parentID);
	
	}
	@Test
	public void TC_03_Compare_Product() {
		driver.get("http://live.demoguru99.com/index.php/");
		
		driver.findElement(By.xpath("//a[text()='Mobile']")).click();
		String parentID = driver.getWindowHandle();
		
		driver.findElement(By.xpath("//a[text()='IPhone']/parent::h2/following-sibling::div[@class='actions']//a[text()='Add to Compare']")).click();
		Assert.assertEquals(driver.findElement(By.xpath("//li[@class='success-msg']//span")).getText(), "The product IPhone has been added to comparison list.");
		
		driver.findElement(By.xpath("//a[text()='Samsung Galaxy']/parent::h2/following-sibling::div[@class='actions']//a[text()='Add to Compare']")).click();
		Assert.assertEquals(driver.findElement(By.xpath("//li[@class='success-msg']//span")).getText(), "The product Samsung Galaxy has been added to comparison list.");
	
		driver.findElement(By.xpath("//button[@title='Compare']")).click();
		
		switchToWindowByTitle("Products Comparison List - Magento Commerce");
		 
		Assert.assertEquals(driver.findElement(By.xpath("//h2[@class='product-name']/a")).getSize(), 2);
		closeAllWindowExceptParent(parentID);
		sleepInSecond(2);
		
		driver.findElement(By.xpath("//input[@id='search']")).sendKeys("Sony Xperia");
		driver.findElement(By.xpath("//button[@title='Search']")).click();
		
	}
	
	// 2 window/tab
	public void switchToWindowByID(String parentID) {

		// lấy tất cả các ID của window /tab đang có
		Set<String> allWindowsID = driver.getWindowHandles();

		// Duyệt qua từng ID
		for (String windowID : allWindowsID) {

			// Nếu như ID nào mà khác với parent ID thì nhảy vào hàm If
			if (!windowID.equals(parentID)) {

				// switch vào 1 window/tab theo ID
				driver.switchTo().window(windowID);
				break;
			}

		}
	}

	// >= 2 window/tab
	public void switchToWindowByTitle(String exceptedWindowTitle) {
		// Lấy ra tất cả các Window/tab đang có
		Set<String> allWindowIDs = driver.getWindowHandles();
		System.out.println("Số lượng cửa sổ /tab đang có:" + allWindowIDs.size());

		// duyệt qua các giá trị trong set
		for (String windowID : allWindowIDs) {
			// switch vào từng window/tab trước
			driver.switchTo().window(windowID);
			// Get ra title của từng window/tab
			String actualWindowTitle = driver.getTitle();
			// kiểm tra nếu như cái nào mà bằng với title mong muốn
			if (actualWindowTitle.equals(exceptedWindowTitle)) {
				// thoát khỏi vòng lặp
				break;
			}

		}

	}

	public void closeAllWindowExceptParent(String parentID) {
		// lấy tất cả các ID của window /tab đang có
		Set<String> allWindowsID = driver.getWindowHandles();

		// Duyệt qua từng ID
		for (String windowID : allWindowsID) {
			if (!windowID.equals(parentID)) {
				driver.switchTo().window(windowID);
				// chỉ đóng tab/window đang active (driver)
				driver.close();
				sleepInSecond(1);

				if (driver.getWindowHandles().size() == 1) {
					driver.switchTo().window(parentID);
					break;
				}
			}
		}
	}

	@AfterClass
	public void afterClass() {
		driver.quit();

	}

	public void sleepInSecond(long timeInSecond) {
		try {
			Thread.sleep(timeInSecond * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
