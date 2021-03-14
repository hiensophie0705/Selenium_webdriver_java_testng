package Testng;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Topic_06_Parameter_MultiBrowser {
	WebDriver driver;
	By emailTextbox = By.xpath("//*[@id='email']");
	By passwordTextbox = By.xpath("//*[@id='pass']");
	By loginButton = By.xpath("//button[@id='send2']");
	
	
	@Parameters({"browser", "url"})
	@BeforeClass
	public void beforeClass(String  browserName, String urlValue) {
		if(browserName.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", ".\\browserDriver\\geckodriver.exe");
			driver = new FirefoxDriver();
		}else if(browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", ".\\browserDriver\\chromedriver.exe");
			driver = new ChromeDriver();
		}else {
			throw new RuntimeException("Please check the browser name again!");
		}
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.get(urlValue);
	}

	@Test(dataProvider = "register")
	public void TC_02_Register_To_System(String emailAddress, String password) {
	
		
		driver.findElement(By.xpath("//span[text()='Create an Account']")).click();
		driver.findElement(By.id("firstname")).sendKeys("hien");
		driver.findElement(By.id("lastname")).sendKeys("do");
		driver.findElement(By.id("email_address")).sendKeys(emailAddress);
		driver.findElement(By.id("password")).sendKeys(password);
		driver.findElement(By.id("confirmation")).sendKeys(password);
		driver.findElement(By.xpath("//button[@title='Register']")).click();
		
		driver.findElement(By.xpath("//header[@id='header']//span[text()='Account']")).click();
		driver.findElement(By.xpath("//a[text()='Log Out']")).click();
		
	}
	@DataProvider(name = "register")
	public String[][] Register_Data() {
		return new String[][] { { "autotest" + getRandomNumber() + "@gmail.com", "111111" },
				{ "autotest" + getRandomNumber() + "@gmail.com", "111111" },
				{ "autotest" + getRandomNumber() + "@gmail.com", "111111" } };

		}
	
	public int getRandomNumber() {
		Random rand = new Random();
		return rand.nextInt(9999);
	}
	
}



