package webdriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_18_Wait_Part2 {
	WebDriver driver;
	
	@BeforeClass
	public void beforeClass() {
		driver = new FirefoxDriver();
		
		//Timeout này được apply duy nhất cho việc tìm element (findElement/ findElements)
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	
		driver.get("https://demo.nopcommerce.com/login?returnUrl=%2F");
	}
	
	
	

	public void TC_01_Find_Element() {
		// Trả về(return) 1 element(WebElement)
		
		//Tìm element nhưng không thấy element nào hết -> 0 matching node
		//Mỗi nửa s sẽ tìm lại 1 lần cho đến khi hết timeout thì thôi
		//Nếu như hết timeout mà vẫn không thấy element thì:
		//+ Đánh fail TCs
		//+ Throw( ném ra) 1 exception:  NoSuch ElementException- Unable to locate element wuth...
		//Trong thời gian đang tìm nếu element xuất hiện thì pass được điều kiện(findElement)
		// và không phải chờ cho đến hết timeout
		//driver.findElement(By.xpath("//input[@id='FirstName']"));
		
		//Tìm element nhưng chỉ có duy nhất 1 cái -> 1 matching node
		//Tìm thấy element thấy ngay -> Return lại element đó->...
//		
//		//KHông cần chờ hết timeout còn lại
//		boolean status = driver.findElement(By.xpath("//input[@id='Email']")).isDisplayed();
//		System.out.println(status);
//		
//		if (status) {
//			System.out.println("Go to if");
//			}else {
//				System.out.println("Go to else");
//			}
		
		//Tìm element nhưng thấy nhiều hơn 1 cái -> n matching nodes
		//Tìm thấy element thấy ngay -> Return lại element đầu tiên
//		driver.findElement(By.xpath("//input[@type='email']")).sendKeys("testing@gmail.com");
		
		
		
	}
	@Test
	public void TC_02_Find_Elements() {
		// Trả về(return) >= 1 elements  (List<WebElement>)
		
		//Tìm element nhưng không thấy element nào hết -> 0 matching node
		//Mỗi nửa s sẽ tìm lạ 1 lần cho đến khi hết timeout thì thôi
		//Trong thời gian đang tìm nếu element xuất hiện thì pass được diều kiện(findElements)
		//và không cần phải chờ cho đến hết time out
		//Nếu như hết timeout mà vẫn không thấy element thì:
		//+ko fail TCs
		//+Trả về 1 list empty( ko chứa element nào hết)
		/*
		 * List <WebElement> radioButton =
		 * driver.findElements(By.xpath("//input[@type='radio']"));
		 * System.out.println("Size = " + radioButton.size());
		 * Assert.assertTrue(radioButton.isEmpty());
		 */
		//Tìm element nhưng chỉ có duy nhất 1 cái -> 1 matching node
		//Tìm thấy element ngay nhưng kết quả trả về là 1 list chứa element(1 element)
		/*
		 * List<WebElement> emailTextbox =
		 * driver.findElements(By.xpath("//input[@id='Email']"));
		 * System.out.println("Size = " + emailTextbox.size());
		 * Assert.assertFalse(emailTextbox.isEmpty());
		 * 
		 * emailTextbox.get(0).sendKeys("automation@gmail.com");
		 */
		//Tìm element nhưng thấy nhiều hơn 1 cái -> n matching nodes
		//Tìm thấy element ngay nhưng kết quả trả về là 1 list chứa  nhiều element)
		
		//Cần thao tác với nhiều field/elements
		List <WebElement> textboxes = driver.findElements(By.xpath("//input[@type='text']"));
		System.out.println("Size = " + textboxes.size());
		
		for (WebElement textbox : textboxes) {
			textbox.sendKeys("List WebElement");
		}
	}
	@AfterClass
	public void afterClass() {
		//driver.quit();
		
	}
	
}
