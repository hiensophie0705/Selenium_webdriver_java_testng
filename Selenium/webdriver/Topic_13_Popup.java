package webdriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
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
	public void TC_02_Fixed_Popup() {
		driver.get("https://bni.vn/");
		
		//Chờ cho 1 element được hiển thị
		explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='sgpb-popup-dialog-main-div']")));
		driver.findElement(By.xpath("//input[@value='JOIN WITH US']")).click();
		driver.findElement(By.xpath("//img[@alt='Close']")).click();
		
		//Chờ cho 1 element không còn hiển thị
		explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@id='sgpb-popup-dialog-main-div']")));
		Assert.assertFalse(driver.findElement(By.xpath("//div[@id='sgpb-popup-dialog-main-div']")).isDisplayed());

		
	}
	
	@Test
	public void TC_03_Random_Popup_In_DOM() {
		
	}
	
	@Test
	public void TC_03_Random_Popup_Not_In_DOM() {
		
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