package webdriver;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThan;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_14_Iframe_Frame {
	WebDriver driver;

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.chrome.driver",  ".\\BrowserDriver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	@Test
	public void TC_01_Iframe() {
		driver.get("https://automationfc.com/2020/02/18/training-online-automation-testing/");
		
		//switch vào iframe của Facebook
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[contains(@title,'Facebook Social Plugin')]")));
		
		Assert.assertEquals(driver.findElement(By.xpath("//a[@title='Automation FC']")).getText(), "Automation FC");
		
		String likeText = driver.findElement(By.xpath("//a[@title='Automation FC']/parent::div/following-sibling::div")).getText();
		int likeNumber = Integer.parseInt(likeText.split(" ")[0].replace(",", ""));
		System.out.println(likeNumber);
		
		 assertThat(likeNumber, greaterThan(2000));
		 
		 //Switch to Top Window
		 driver.switchTo().defaultContent();
		 
		 Assert.assertEquals(driver.findElement(By.className("//h1[@class='post-title']")).getText(), "[Training Online] – Fullstack Selenium WebDriver Framework in Java (Livestream)");
		 
		 //Switch to Google doc iframe
		 driver.switchTo().frame(driver.findElement(By.xpath("//iframe[contains(@src,'docs.google.com')]")));
		 
		 Assert.assertEquals(driver.findElement(By.cssSelector(".exportFormTitle")).getText(), "KHÓA HỌC SELENIUM AUTOMATION TESTING");
		 
	
	}

	@Test
	public void TC_02_Iframe() {
		driver.get("https://kyna.vn");
		
		//Switch Chat iframe
		driver.switchTo().frame("cs_chat_iframe");
		
		driver.findElement(By.xpath("//input[@ng.model='login.username']")).sendKeys("Đỗ Hiên");
		driver.findElement(By.xpath("//input[@ng.model='login.phone']")).sendKeys("0389996064");
		
		Select select = new Select(driver.findElement(By.id("serviceSelect")));
		Assert.assertFalse(select.isMultiple());
		
		select.selectByVisibleText("//select[@id='serviceSelect']/option[2]");
		Assert.assertEquals("HỖ TRỢ KỸ THUẬT",select.getFirstSelectedOption().getText());
		sleepInSecond(3);
		
		driver.findElement(By.xpath("//input[@ng.model='login.content']")).sendKeys("Automation testing");
		driver.findElement(By.xpath("//input[@value='Gửi tin nhắn']")).click();
		sleepInSecond(5);
		
		Assert.assertTrue(driver.findElement(By.xpath("//div[@class='form_container']")).isDisplayed());
		
		//Switch to Top Window(Home page)
		driver.switchTo().defaultContent();
		
		driver.findElement(By.id("live-search-bar")).sendKeys("Excel");
		driver.findElement(By.cssSelector(".search-button")).click();
		
		List<WebElement> courseNameHeader = driver.findElements(By.cssSelector("div.content h4"));
		List<String> courseNameText = new ArrayList<String>();
		
		for (WebElement course : courseNameHeader) {
			System.out.println(course.getText());
			courseNameText.add(course.getText());
		}
		
		for (String courseName : courseNameText) {
			Assert.assertTrue(courseName.contains("Excel"));
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