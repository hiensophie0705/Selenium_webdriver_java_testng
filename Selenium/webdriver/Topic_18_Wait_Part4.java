package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_18_Wait_Part4 {
	WebDriver driver;
	
	@BeforeClass
	public void beforeClass() {
		driver = new FirefoxDriver();
	}
	
	@Test
	public void TC_01_Equal() throws InterruptedException {
		driver.get("http://the-internet.herokuapp.com/dynamic_loading/2");
		
		//click to START button
		driver.findElement(By.xpath("//div[@id='start']/button")).click();
		 Thread.sleep(5200);
		 
		 //verify text
		 Assert.assertEquals(driver.findElement(By.xpath("//div[@id='finish']/h4")).getText(), "Hello World!");
		 
		 
	}
	
	@Test
	public void TC_02_Greater() throws InterruptedException {
		driver.get("http://the-internet.herokuapp.com/dynamic_loading/2");

		
		//click to START button
		driver.findElement(By.xpath("//div[@id='start']/button")).click();
		Thread.sleep(15000);

		//Verify text --> Passed
		Assert.assertEquals(driver.findElement(By.xpath("//div[@id='finish']/h4")).getText(), "Hello World!");
		
		}
	@Test
	public void TC_03_Less() throws InterruptedException{
		driver.get("http://the-internet.herokuapp.com/dynamic_loading/2");

		
		//click to START button
		driver.findElement(By.xpath("//div[@id='start']/button")).click();
		Thread.sleep(2000);

		//Verify text --> Failed
		Assert.assertEquals(driver.findElement(By.xpath("//div[@id='finish']/h4")).getText(), "Hello World!");
		
	}
	
	@AfterClass
	public  void afterClass() {
		driver.quit();
		
	}
	
	
}
