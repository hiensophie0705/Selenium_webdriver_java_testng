package webdriver;

import java.util.Date;
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

public class Topic_18_Wait_Part7 {
	WebDriver driver;
	WebDriverWait explicitWait;
	String projectLoction = System.getProperty("user.dir");
	
	@BeforeClass
	public void beforeClass() {
		driver = new FirefoxDriver();
		
	}

	public void TC_01_Found_Element() {
		explicitWait = new WebDriverWait(driver, 15);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
		driver.get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
		System.out.println("START explicit wait: " + getDateTimeNow());
		explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='email']")));
		System.out.println("END explicit wait: " + getDateTimeNow());
		
		Assert.assertTrue(driver.findElement(By.xpath("//input[@id='email']")).isDisplayed());
		System.out.println("END implicit wait: " + getDateTimeNow());
	}
	
	
	public void TC_02_Not_Found_Element_Only_Implicit() {
		driver.get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
	
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		
		System.out.println("START explicit wait: " + getDateTimeNow());
		try {
			Assert.assertTrue(driver.findElement(By.xpath("//input[@id='emailAddress']")).isDisplayed());
		}catch (Exception e) {
		}

		System.out.println("END explicit wait: " + getDateTimeNow());
	}

	public void TC_03_Not_Found_Element_Implicit_Equals_Explicit() {
		driver.get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
		
		explicitWait = new WebDriverWait(driver, 4);
		driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
		
		System.out.println("START implicit wait: " + getDateTimeNow());
		try {
			Assert.assertTrue(driver.findElement(By.xpath("//input[@id='emailAddress']")).isDisplayed());
		}catch (Exception e) {
		}
		
		System.out.println("END implicit wait: " + getDateTimeNow());
		
		System.out.println("START explicit wait: " + getDateTimeNow());
		try {
			explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='emailAddress']")));
			
		}catch(Exception e) {
			
		}
		System.out.println("END explicit wait: " + getDateTimeNow());
		
	}
	
	public void TC_04_Not_Found_Element_Implicit_Greater_Explicit() {
		driver.get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
		
		explicitWait = new WebDriverWait(driver, 4);
		driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
		
		System.out.println("START implicit wait: " + getDateTimeNow());
		try {
			Assert.assertTrue(driver.findElement(By.xpath("//input[@id='emailAddress']")).isDisplayed());
		}catch (Exception e) {
		}
		
		System.out.println("END implicit wait: " + getDateTimeNow());
		System.out.println("START explicit wait: " + getDateTimeNow());
		try {
			explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='emailAddress']")));
			
		}catch(Exception e) {
		
	}
		System.out.println("END explicit wait: " + getDateTimeNow());

	}
	
	public void TC_05_Not_Found_Element_Implicit_less_Explicit() {
		driver.get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
		
		explicitWait = new WebDriverWait(driver, 5);
		driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
		
		System.out.println("START implicit wait: " + getDateTimeNow());
		try {
			Assert.assertTrue(driver.findElement(By.xpath("//input[@id='emailAddress']")).isDisplayed());
		}catch (Exception e) {
		}
		
		System.out.println("END implicit wait: " + getDateTimeNow());
		
		System.out.println("START explicit wait: " + getDateTimeNow());
		try {
			explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='emailAddress']")));
		}catch(Exception e) {
			
		}
		System.out.println("END explicit wait: " + getDateTimeNow());
	}
	

	public void TC_06_Not_Found_Element_Only_Explicit_Param_By() {
		driver.get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
		
		explicitWait = new WebDriverWait(driver, 4);
		
		
		System.out.println("START explicit wait: " + getDateTimeNow());
		try {
			explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='emailAddress']")));
		}catch(Exception e) {
			e.printStackTrace();
		}
		System.out.println("END explicit wait: " + getDateTimeNow());
	}
	
	@Test
	public void TC_07_Not_Found_Element_Only_Explicit_Param_Element() {
		driver.get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
		
		explicitWait = new WebDriverWait(driver, 3);
		
		System.out.println("START explicit wait: " + getDateTimeNow());
		try {
			//bi ảnh hưởng bởi implicit = 0
			explicitWait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//input[@id='emailAddress']"))));
			
			explicitWait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//input[@id='emailAddress']"))));
			
			explicitWait.until(ExpectedConditions.elementToBeSelected(driver.findElement(By.xpath("//input[@id='emailAddress']"))));
			
			explicitWait.until(ExpectedConditions.invisibilityOfAllElements(driver.findElements(By.xpath("//input[@id='emailAddress']"))));
		}catch(Exception e) {
				e.printStackTrace();
			}
		System.out.println("END explicit wait: " + getDateTimeNow());
	}
	
	
	
	
	
	@AfterClass
	public void afterClass() {
		driver.quit();
	}
	
	public String  getDateTimeNow() {
		Date date = new Date();
		return date.toString();
	}
}
