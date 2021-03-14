package webdriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_18_Wait_Part5 {
	WebDriver driver;
	WebDriverWait explicitWait;
	
	@BeforeClass
	public void beforeClass() {
		driver = new FirefoxDriver();
		explicitWait = new WebDriverWait(driver, 15);
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//Nếu như chưa thoả mãn điều kiện thì có cơ chế lặp lại để tìm /wait trong vòng mỗi nửa s
		//Nếu như thoả mãn điều kiện rồi thì không cần chờ hết timeout nữa
		
	}
	
	@Test
	public void TC_01_ClickAble_Invisible()  {
		driver.get("http://the-internet.herokuapp.com/dynamic_loading/2");
		
		//chờ cho start button được click hay chưa (button bị disable và nó sẽ được trigger 1 sự kiện nào đó
		explicitWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='start']/button")));
		
		//click to START button
		driver.findElement(By.xpath("//div[@id='start']/button")).click();
		
		//Wait for Loading icon Invisible
		explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("loading")));
		
		
		//Verify
		Assert.assertEquals(driver.findElement(By.xpath("//div[@id='finish']/h4")).getText(), "Hello World!");
	
	
	}
	@Test
	public void TC_02_ClickAble_Visible()  {
		driver.get("http://the-internet.herokuapp.com/dynamic_loading/2");
		
		//chờ cho start button được click hay chưa (button bị disable và nó sẽ được trigger 1 sự kiện nào đó
		explicitWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='start']/button")));
		
		//click to START button
		driver.findElement(By.xpath("//div[@id='start']/button")).click();
		
		//Wait for Hello world text Visible
		explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='finish']/h4")));
		
		//Verify
		Assert.assertEquals(driver.findElement(By.xpath("//div[@id='finish']/h4")).getText(), "Hello World!");
	
	
}
}
