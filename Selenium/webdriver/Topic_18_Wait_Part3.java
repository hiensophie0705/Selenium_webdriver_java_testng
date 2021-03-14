package webdriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;



public class Topic_18_Wait_Part3 {
	WebDriver driver;
	
	@BeforeClass
	public void beforeClass() {
		driver= new FirefoxDriver();
		
		//Không set luôn thi timeout  = 0s
		//Nếu như set thì nó sẽ lấy đơn vị timeout này apply cho việc time element( findelement/findelements)
		//Nếu như ní bị overide lại thì nó sẽ nhận giá trị  cuối cùng được set
		
		driver.manage().timeouts().implicitlyWait(13, TimeUnit.SECONDS);
		
		
	}

	@Test
	public void TC_01() {
		driver.get("http://the-internet.herokuapp.com/dynamic_loading/2");
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		//click to Start button
		driver.findElement(By.xpath("//div[@id='start']/button")).click();
		
		//Loading icon 5s
		
		//verify text
		Assert.assertEquals(driver.findElement(By.xpath("//div[@id='finish']/h4")).getText(), "Hello World!");
		
	}
	
	@Test
	public void TC_02() {
		driver.get("https://filebin.net/");
		driver.findElement(By.xpath("//input[@type='file']")).sendKeys("D:\\auto\\Selenium API\\Selenium_webdriver_java_testng\\uploadFiles\\download (1).jpg");
		//Đang upload...
		//làm sao để chờ cho nó upload thành công
		//Đây là hàm để wait cho upload file image thành công
		Assert.assertTrue(driver.findElement(By.xpath("//table[@class='sortable table']//following-sibling::a[text()='download__1_.jpg']")).isDisplayed());
		
	}
	@Test
	public void TC_03() {
		driver.get("https://filebin.net/");
		driver.manage().timeouts().implicitlyWait(13, TimeUnit.SECONDS);

		driver.findElement(By.xpath("//input[@type='file']")).sendKeys("D:\\auto\\Selenium API\\Selenium_webdriver_java_testng\\uploadFiles\\download (1).jpg");
	    //Đang upload...
		//làm sao để chờ cho nó upload thành công
		//Đây là hàm để wait cho upload file image thành công
		Assert.assertTrue(driver.findElement(By.xpath("//table[@class='sortable table']//following-sibling::a[text()='download__1_.jpg']")).isDisplayed());
		
	}
	@AfterClass
	public void afterClass() {
		driver.quit();
	}
	
	
}
