package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_09_Handle_Button {
		WebDriver webdriver;
		By loginButton = By.cssSelector(".fhs-btn-login");
		By loginPassword = By.cssSelector(".)
		public void beforeClass() {
			
		
		

		@Test
		public void TC_01_Button() {
			driver.get("https://www.fahasa.com/customer/account/create");
			
			
			driver.findElement(By.cssSelector(".popup-login-tab-login")).click();
			
			//Disdsable field
			Assert.assertFalse(isElementEnabled(loginButton));
			
			driver.findElement(loginUsername).sendKeys("dobaba@gmail.com");
			driver.findElement(loginPassword).sendKeys("123456");
			
			sleepInSecond(2);
			
			//Enable field
			Asser.assertTrue(isElementEnabled(loginButton));
			
			driver.navigate().refresh();
		}
		@Test
		public void TC_02(){
		}

		@Test
		public void TC_03(){
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
