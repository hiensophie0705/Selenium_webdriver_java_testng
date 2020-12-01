package webdriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_02_Xpath_CSS_Part_2_findElement {
	WebDriver driver;
	@BeforeClass
	public void beforeClass() {
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://www.facebook.com/");
	}
	@Test
	public void TC_01_ValidateCurrentUrl() {
		//inpput vào Email textbox
		driver.findElement(By.tagName("input")).sendKeys("0389930640");
		
		//find Element:
		//Nếu như k tìm tháy element nào: đánh fail testcase- throw ra 1 exception: NosuchElement
		//Nếu như tìm thấy 1 element- thao tác vs element đó
		//Nếu như tìm tháy nhiều hon 1 element thì nó luon thao tác với element đầu tiên
	
		
	}
	@AfterClass
	public void afterClass() {
		driver.quit();
	}
		
}