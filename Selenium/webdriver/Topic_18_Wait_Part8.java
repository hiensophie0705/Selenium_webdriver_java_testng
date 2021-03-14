package webdriver;


import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.google.common.base.Predicate;

public class Topic_18_Wait_Part8 {
	WebDriver driver;
	FluentWait<WebDriver> fluentDriver;
	FluentWait<WebElement> fluentElement;
	
	String projectLocation = System.getProperty("user.dir");
	
	@BeforeClass
	public void beforeClass() {
		driver = new FirefoxDriver();
	}
	
	
	public void TC_01() {
		driver.get("https://automationfc.github.io/fluent-wait/");
		 
		WebElement countdownTime = driver.findElement(By.xpath("//div[@id='javascript_countdown_time']"));
		
		fluentElement = new FluentWait<WebElement>(countdownTime);
		
		fluentElement.withTimeout(15, TimeUnit.SECONDS)
		.pollingEvery(300, TimeUnit.MILLISECONDS)
		.ignoring(NoSuchElementException.class);
		
		fluentElement.until(new Function<WebElement,Boolean>(){
			@Override
			public Boolean apply(WebElement countdownTime) {
				String text = countdownTime.getText();
				System.out.println(text);
				return text.endsWith("00");
				
			}
		});
}
	@Test
	public void TC_02() {
		driver.get("http://the-internet.herokuapp.com/dynamic_loading/2");
		
		waitForELementAndClick(By.xpath("//div[@id='start']/button"));
		
		Assert.assertTrue(isElementDisplayed(By.xpath("//div[@id='finish']/h4")));
	
		Assert.assertEquals(getElement(By.xpath("//div[@id='finish']/h4")).getText(), "Hello World");
		
	
	}
	
	public WebElement getElement(By locator) {
		FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver)
				.withTimeout(timeoutInSecond, TimeUnit.SECONDS)
				.pollingEvery(intervalInMilisecond, TimeUnit.MILLISECONDS)
				.ignoring(NoSuchElementException.class);
		WebElement element = wait.until(new Function<WebDriver, WebElement>(){
			public WebElement apply(WebDriver driver) {
				return driver.findElement(locator);
			}
		});
		return element;
	}
	public void waitForELementAndClick(By locator) {
		WebElement element = getElement(locator);
		element.click();
	}
	public boolean isElementDisplayed(By locator) {
		WebElement element = getElement(locator);
		FluentWait<WebElement> wait = new FluentWait<WebElement>(element);
		
		boolean isDisplayed = wait.until(new Function<WebElement, Boolean>(){
			public Boolean apply(WebElement element) {
				boolean flag = element.isDisplayed();
				return flag;
			}
		});
		return isDisplayed;
	}
	
	
	@AfterClass
	public  void afterClass() {
		
	}
	
	 long timeoutInSecond = 15;
	 long intervalInMilisecond = 300;
}
