package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class Topic_02_Xpath_CSS {
	WebDriver driver;
	@Test 
	public void TC_01() {
		//1- Mở ra trình duyệt  FireFox
		driver = new FirefoxDriver();
		//2- Nhập vào app(facebook)
		driver.get("https://www.facebook.com/");
		//3- Nhập vào email textbox
		//action: nhập/chọ/hover/drag+drop/get text/
		// Tìm element: findElement
		//Tìm elements : findElements
		//ID
		driver.findElement(By.id("email")).sendKeys("0389930640");
		// Class
		driver.findElement(By.className("_featureLogin_formContainer")).isDisplayed();
		//Name
		driver.findElement(By.name("pass")).sendKeys("dohien@1997");
		//tagname
		int linkNumber = driver.findElements(By.tagName("a")).size();
		System.out.println("Link number = " + linkNumber);
		//linktext (link -a)
		driver.findElement(By.linkText("English (UK")).click();
		//partial linktext( link-a)
		driver.findElement(By.partialLinkText("Việt")).click();
		//CSS
		driver.findElement(By.cssSelector("#email")).sendKeys("dothihien070597@gmail.com");
		driver.findElement(By.cssSelector("input[id='email']")).clear();
		driver.findElement(By.cssSelector("input[name='email']")) .sendKeys("dobaba199@gmail.com");
		
		//Xpath
		driver.findElement(By.xpath("//input[@id='pass']")).sendKeys("123456");
		driver.findElement(By.xpath("//input[@name='pass']")).clear();
		//xpathtext
		driver.findElement(By.xpath("//a[text()='English(UK)']")).click();
		
	}
}
