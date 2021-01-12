package webdriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_10_Alert {
	WebDriver driver;
	Alert alert;
	WebDriverWait explicitWait;
	By resultText = By.xpath("//p[@id='result']");
	String username = "admin";
	String password = "admin";
	String project_location = System.getProperty("user.dir");
	String firefoxAuthenFile = project_location +"D:\\Automation testing\\02- Selenium API\\Selenium_webdriver_java_testng\r\n" ;
	
	@BeforeClass
	public void beforeClass() {
		driver = new FirefoxDriver();
		
		explicitWait = new WebDriverWait(driver, 30);// chờ trạng thái của Element, ví dụ chờ hiển thị hay không hiển thị, chờ đc click hay chưa
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);// chờ cho việc tìm Element
		 
	}
	
	@Test
	public void TC_01_Accept_Alert() {
		 driver.get("https://automationfc.github.io/basic-form/index.html");
		
		 driver.findElement(By.xpath("//button[text()='Click for JS Alert']")).click();
		 
		 //chờ cho alert được xuất hiện
		 explicitWait.until(ExpectedConditions.alertIsPresent());
		 
		 //Switch vào Alert
		 alert = driver.switchTo().alert();
		 sleepInSecond(3);
		 //Get text
		 Assert.assertEquals(alert.getText(), "I am a JS Alert");
		 alert.accept();
		 
		 sleepInSecond(3);
		 Assert.assertEquals(driver.findElement(resultText).getText(), "You clicked an alert successfully");
		 //Accept
		 //alert.accept();
		 
		 //Cancel
		 //alert.dismiss();
		 
		 //SendKey
		 //alert.sendKeys(arg0);
		 
		 }
	@Test
	public void TC_02_Confirm_Alert() {
		driver.get("https://automationfc.github.io/basic-form/index.html");
		
		driver.findElement(By.xpath("//button[text()='Click for JS Confirm']")).click();
		
		explicitWait.until(ExpectedConditions.alertIsPresent());
		
		alert = driver.switchTo().alert();
		sleepInSecond(3);
		Assert.assertEquals(alert.getText(), "I am a JS Confirm");
		alert.dismiss();
		sleepInSecond(3);
		Assert.assertEquals(driver.findElement(resultText).getText(), "You clicked: Cancel");
		
	}
	
	@Test		

	public void TC_03_Prompt_Alert() {
		String loginValue = "Automation Testing";
		
		driver.get("https://automationfc.github.io/basic-form/index.html");
		
		driver.findElement(By.xpath("//button[text()='Click for JS Prompt']")).click();
		
		explicitWait.until(ExpectedConditions.alertIsPresent());
		
		alert = driver.switchTo().alert();
		
		alert.sendKeys(loginValue);
		sleepInSecond(3);
		Assert.assertEquals(alert.getText(), "I am a JS prompt");
		alert.accept();
		sleepInSecond(3);
		
		Assert.assertEquals(driver.findElement(resultText).getText(), "You entered: " +loginValue);

	}
	
	@Test
	public void TC_04_Authentication_Alert() {
		driver.get("http://" + username + ":" + password +"@" +"http://the-internet.herokuapp.com/basic_auth");
		Assert.assertTrue(driver.findElement(By.xpath("//p[contains(text(), 'Congratulations! You must have the proper credentials.')]")).isDisplayed());
	}
	
	@Test
	public void TC_05_Authentication_Alert() {
		driver.get("http://the-internet.herokuapp.com/");
		String basicAuthenLink = driver.findElement(By.xpath("//a[text()='Basic Auth']")).getAttribute("href");
		System.out.println(basicAuthenLink);
		driver.get(getAuthenticationUrl(basicAuthenLink, username, password));
		Assert.assertTrue(driver.findElement(By.xpath("//p[contains(text(), 'Congratulations! You must have the proper credentials.')]")).isDisplayed());

		//input: http://the-internet.herokuapp.com/
		//Output: http://admin:admin@the-internet.herokuapp.com/basic_auth
	}
	
	public String getAuthenticationUrl(String oldUrl, String userName, String password) {
		String newUrl = null;
		
		String urlValue[] = oldUrl.split("//");
		//http:
		//the-internet.herokuapp.com/basic_auth
		
		newUrl = urlValue[0] + "//" + userName + ":" + password +"@" + urlValue[1];
		
		
		return newUrl;
		
	}
	
	@Test
	public void TC_06_Authentication_Alert() {
	
		driver.get("http://the-internet.herokuapp.com/basic_auth");
		explicitWait.until(ExpectedConditions.alertIsPresent());
	    Runtime.getRuntime().exec(new String[] { firefoxAuthen, username, password });
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