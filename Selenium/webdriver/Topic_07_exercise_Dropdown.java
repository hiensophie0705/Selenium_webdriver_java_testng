package webdriver;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;



public class Topic_07_exercise_Dropdown {
	WebDriver driver;
	private Select select;

	@BeforeClass
	public void beforeClass() {
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://automationfc.github.io/basic-form/index.html");

	}

	@Test
	public void TC_01_Xu_Ly_DropdownList_01() throws InterruptedException {
		Select select = new Select(driver.findElement(By.id("job1")));
		Assert.assertFalse(select.isMultiple());
		
		select.selectByVisibleText("Mobile Testing");
		Assert.assertEquals("Mobile Testing",select.getFirstSelectedOption().getText());
		Thread.sleep(3000);
	
		select.selectByValue("manual");
		Assert.assertEquals( "Manual Testing",select.getFirstSelectedOption().getText());
		Thread.sleep(3000);
		
		select.selectByIndex(9);
		Assert.assertEquals("Functional UI Testing",select.getFirstSelectedOption().getText());
		Assert.assertEquals(select.getOptions().size(), 10);
		Thread.sleep(3000);
	}
	@Test
		public void TC_02_Multiple() {
			select = new Select(driver.findElement(By.name("user_job2")));
			
			select.selectByVisibleText("Automation");
			select.selectByVisibleText("Mobile");
			select.selectByVisibleText("Desktop");
			
			List<WebElement> itemSelected = select.getAllSelectedOptions();
			
			List<String> itemSelectedText = new ArrayList<String>();
			
			Assert.assertEquals(itemSelected.size(), 3);
			
			for (WebElement item : itemSelected) {
				System.out.println(item.getText());
		}
		
	}
	

	@AfterClass
	public void afterClass() {
		driver.close();
	}

}
