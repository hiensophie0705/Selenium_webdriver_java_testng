package webdriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_11_User_Interaction_Part1 {
	WebDriver driver;

	@BeforeClass
	public void beforeClass() {
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		}

	@Test
	public void TC_01_Hover_mouse() {
		driver.get("");
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
}
