package webdriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
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

public class Topic_18_Wait_Part6 {
	WebDriver driver;
	WebDriverWait explicitWait;
	
	@BeforeClass
	public void beforeClass() {
		driver = new FirefoxDriver();
		explicitWait = new WebDriverWait(driver, 22);
	
	}
	

	public void TC_01_Only_Implicit() {
		
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
		driver.get("https://demos.telerik.com/aspnet-ajax/ajaxloadingpanel/functionality/explicit-show-hide/defaultcs.aspx");
		
		driver.findElement(By.xpath("//a[text()='14']/parent::td")).click();
		
		Assert.assertTrue(driver.findElement(By.xpath("//span[@id='ctl00_ContentPlaceholder1_Label1' and text()='Sunday, February 14, 2021']")).isDisplayed());
			
		
	}
	

	public void TC_02_Only_Explicit() {
		driver.get("https://demos.telerik.com/aspnet-ajax/ajaxloadingpanel/functionality/explicit-show-hide/defaultcs.aspx");
		
		WebElement todayText = driver.findElement(By.id("ctl00_ContentPlaceholder1_Label1"));
		
		Assert.assertEquals(todayText.getText(), "No Selected Dates to display.");
		
		
		//chờ cho ngày 14 có thể được click
		explicitWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='14']/parent::td")));
		
		driver.findElement(By.xpath("//a[text()='14']/parent::td")).click();
		
		//Chờ cho ngày được chọn thành công
		explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='14']/parent::td[@class='rcSelected']")));
		
		//Chờ cho loading icon biến mất
		explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='raDiv']/parent :: div[not(@style='display:none;')]")));
		
		todayText = driver.findElement(By.id("ctl00_ContentPlaceholder1_Label1"));
		Assert.assertEquals(todayText.getText(), "Sunday, February 14, 2021");
	}
	
	@Test
	public void TC_03_Only_Explicit_for_Upload() {
		driver.get("https://filebin.net/");
		
		driver.findElement(By.xpath("//input[@type='file']")).sendKeys("D:\\auto\\Selenium API\\Selenium_webdriver_java_testng\\uploadFiles\\download (1).jpg");
		
		explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='progress']")));
		
		explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@class='sortable table']//following-sibling::a[text()='download__1_.jpg']")));
		
		driver.findElement(By.xpath("//table[@class='sortable table']//following-sibling::a[text()='download__1_.jpg']")).click();
	
	}
	
	@Test
	public void TC_04_Only_Explicit_for_Alert() {
		driver.get("http://demo.guru99.com/v4/");
		
		driver.findElement(By.name("btnLogin")).click();
		
		Alert alert = explicitWait.until(ExpectedConditions.alertIsPresent());
		
		Assert.assertEquals(alert.getText(), "User or Password is not valid");
	
		alert.accept();
	}
	@AfterClass
	public void afterClass() {
		//driver.quit();
	}
}
