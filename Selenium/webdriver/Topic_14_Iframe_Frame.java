package webdriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static org.hamcrest.MatcherAssert.assertThat; 
import static org.hamcrest.Matchers.*;

public class Topic_14_Iframe_Frame {
	WebDriver driver;

	@BeforeClass
	public void beforeClass() {
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	@Test
	public void TC_01_Iframe() {
		driver.get("https://automationfc.com/");
		
		//switch vào iframe của Facebook
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[contains(@title,'Facebook Social Plugin')]")));
		
		Assert.assertEquals(driver.findElement(By.xpath("//a[@title='Automation FC']")).getText(), "Automation FC");
		
		String likeText = driver.findElement(By.xpath("//a[@title='Automation FC']/parent::div/following-sibling::div")).getText();
		int likeNumber = Integer.parseInt(likeText.split(" ")[0].replace(",", ""));
		System.out.println(likeNumber);
		
		 assertThat(likeNumber, greaterThan(2000));
	}

	@Test
	public void TC_02() {
	}

	@Test
	public void TC_03() {
	}

	@Test
	public void TC_04() {

	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}