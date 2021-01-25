package webdriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_13_Popup {
	WebDriver driver;
	WebDriverWait explicitWait;

	@BeforeClass
	public void beforeClass() {
		driver = new FirefoxDriver();
		explicitWait = new WebDriverWait(driver, 10);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);//chờ cho element được hiển thị, các hàm findelement bị ảnh hưởng
		driver.manage().window().maximize();
	}

	@Test
	public void TC_01_Fixed_Popup() {
		driver.get("https://www.zingpoll.com/");
		
		driver.findElement(By.xpath("//a[@id='Loginform']")).click();
		
		//Chờ cho 1 element được hiển thị
		explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//form[@id='loginForm']")));
		
		Assert.assertTrue(driver.findElement(By.xpath("//form[@id='loginForm']")).isDisplayed());
		sleepInSecond(3);
		driver.findElement(By.xpath("//div[@id='Login']//button[@class='close']")).click();
		
		
		//Chờ cho 1 element không còn hiển thị
		explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//form[@id='loginForm']")));
		Assert.assertFalse(driver.findElement(By.xpath("//form[@id='loginForm']")).isDisplayed());

	}
	@Test
	public void TC_02_Fixed_Popup() throws InterruptedException {
		driver.get("https://bni.vn/");
		
		//Chờ cho 1 element được hiển thị
		explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='sgpb-popup-dialog-main-div']")));
		driver.findElement(By.xpath("//input[@value='JOIN WITH US']")).click();
		driver.findElement(By.xpath("//img[@alt='Close']")).click();
		
		Thread.sleep(3000);
		
		//Chờ cho 1 element có thể click được hay không
		 explicitWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//img[@alt='Close']")));
		 driver.findElement(By.xpath("//img[@alt='Close']")).click();
		 
		//Chờ cho 1 element không còn hiển thị
		explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@id='sgpb-popup-dialog-main-div']")));
		Assert.assertFalse(driver.findElement(By.xpath("//div[@id='sgpb-popup-dialog-main-div']")).isDisplayed());

		
	}
	
	@Test
	public void TC_03_Random_Popup_In_DOM() {
		//step 1
		driver.get("https://blog.testproject.io/");
		sleepInSecond(7);
		
		//step 2
		//(Có xuất hiện - đóng popup đi)- chuyển qua step tiếp theo
		//(Không xuất hiện)- qua step tiếp theo
		if(driver.findElement(By.xpath("//div[@class='mailch-wrap rocket-lazyload']")).isDisplayed());{
		//Chờ cho 1 element có thể click được hay không
		 explicitWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//img[@alt='Close']")));
		 driver.findElement(By.xpath("//img[@alt='close-mailch']")).click();
		}
		
		//step 3

	   //Chờ cho 1 element được hiển thị
		explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//section//input[@class='search-field']")));
		driver.findElement(By.xpath("//section//input[@class='search-field']")).sendKeys("Selenium");
		
		explicitWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//section//span[@class='glass]")));

		driver.findElement(By.xpath("//section//span[@class='glass']")).click();
		
		sleepInSecond(5);
		
	}
	@Test
	public void TC_04_Random_Popup_Not_In_DOM() {
		//Step 1
		driver.get("https://shopee.vn");
		
		sleepInSecond(7);
		
		List<WebElement> popup = driver.findElements(By.xpath("img[@alt='home_popup_banner']"));
		
		if(popup.size() > 0 && popup.get(0).isDisplayed()) {
			System.out.println("Đóng popup");
			explicitWait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".shopee-popup_close-btn")));
			driver.findElement(By.cssSelector(".shopee-popup_close-btn")).click();
			}else {
				System.out.println("Popup không xuất hiện");
				
			}
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
