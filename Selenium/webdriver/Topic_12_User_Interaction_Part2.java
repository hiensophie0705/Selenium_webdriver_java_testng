package webdriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_12_User_Interaction_Part2 {
	WebDriver driver;
	Actions action;
	
	@BeforeClass
	public void beforeClass() {
		driver = new FirefoxDriver();
		action = new Actions(driver);
		
		driver.manage().window().setSize(new Dimension(1366,768));
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		}
	
	@Test
	public void TC_01_right_click() {
		driver.get("http://swisnl.github.io/jQuery-contextMenu/demo.html");
		
		action.contextClick(driver.findElement(By.xpath("//span[text()='right click me']"))).perform();
		
		//Verify Quit not contain( visible/hover status)
		Assert.assertTrue((driver.findElement(By.xpath("//li[contains(@class,'context-menu-icon-quit') and not (contains(@class,'context-menu-visible')"
				+ ")and not (contains(@class,'context-menu-hover'))]"))).isDisplayed());
		
		//Hover to Quit
		action.moveToElement(driver.findElement(By.xpath("//li[contains(@class,'context-menu-icon-quit') "
				+ "and not (contains(@class,'context-menu-visible'))and not (contains(@class,'context-menu-hover'))]"))).perform();
		sleepInSecond(3);
		
		//Verify Quit contain(visible/ hover status)
		Assert.assertTrue((driver.findElement(By.xpath("//li[contains(@class,'context-menu-icon-quit') and contains(@class,'context-menu-visible') and contains(@class,'context-menu-hover')]"))).isDisplayed());
		
		//Click to Quit
		driver.findElement(By.xpath("//li[contains(@class,'context-menu-icon-quit') and contains(@class,'context-menu-visible') and contains(@class,'context-menu-hover')]")).click();
		
		//Verify alert dislayed
		Assert.assertEquals(driver.switchTo().alert().getText(), "clicked: quit");
		driver.switchTo().alert().accept();
		
		//Verify Quit contain (visible, hover status)
	}
		@Test
		public void TC_02_drag_drop_HTML4() {
			driver.get("https://demos.telerik.com/kendo-ui/dragdrop/index");
			
			WebElement sourceCircle = driver.findElement(By.xpath("//div[@id='draggable']"));
			WebElement targetCircle = driver.findElement(By.xpath("//div[@id='droptarget']"));
			
			scrollToElement(driver.findElement(By.xpath("//div[@class='kd-example-runner tabstrip-container']")));
			sleepInSecond(5);
			
			action.dragAndDrop(sourceCircle,targetCircle).perform();
			sleepInSecond(5);
			
			Assert.assertEquals(targetCircle.getText(), "You did great!");
		}
		
		private void scrollToElement(WebElement findElement) {
			// TODO Auto-generated method stub
			
		}

		@Test
		public void TC_03_drag_drop_HTML5() {
			driver.get("https://automationfc.github.io/drag-drop-html5/");
		
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
