package webdriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class Topic_03_Run_On_Chrome_FireFox {
	WebDriver driver;
	String project_location = System.getProperty("user.dir");//lấy ra đường dẫn của project
	@Test
	public void TC_01_Run_On_FireFox() {
		//Selenium 2.53.1
		//Firefox 47.0.2
		//No need geckodriver
		WebDriver driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("http://facebook.com");
		driver.quit();
	}
	
	@Test
	public void TC_02_Run_On_Chrome() {
		//Selenium 2.53.1
		//Chrome latest
		//Chromedriver latest
		//window
		//absolute path
	
		System.setProperty("WebDriver.chrome.driver", project_location + "\\BrowserDriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("http://facebook.com");
		driver.quit();
	}

	
}
