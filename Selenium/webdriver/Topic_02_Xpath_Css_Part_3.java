package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class Topic_02_Xpath_Css_Part_3 {
	WebDriver driver;
	 
	public void beforeClass() {
		
	};
	@Test
	public void TC_01_ID() throws InterruptedException{
	
	}
    
	@Test
	public void TC_02_Class() throws InterruptedException{
	
	};

	@Test
	public void TC_03_Name() throws InterruptedException{
		driver.findElement(By.name("login[user.name]")).sendKeys("23234");
		Thread.sleep(3000);
	}
	public void TC_04_TagName() throws InterruptedException {
		System.out.println();
		System.out.println();
;;		System.out.println("Tá»•n sá»‘ lnk trÃªn trang hiá»‡n táº¡i =" + driver.findElement(By.tagName("a")));
	}
	public void TC_05_LinkText() throws InterruptedException{
		//text cá»§a link tuyá»‡t Ä‘á»‘i( toÃ n bá»™ chuá»—i)
		driver.findElement(By.linkText("Forgot Your PassWord?"));
		Thread.sleep(4000);
	}
	@Test
	public void TC_06_Partial_LinkText() throws InterruptedException{
		driver.get("https://login.ubuntu.com/");
		//Text của link tuyêt đối
		driver.findElement(By.partialLinkText("Read")).click();
	}
	public void TC_07_Css_Selector() throws InterruptedException{
		driver.get("https://login.ubuntu.com/");
		driver.findElement(By.cssSelector("input[id='id_email']")).sendKeys("automation@gmail.com");
		driver.findElement(By.cssSelector("input[id='id_email']")).clear();
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("input[placeholder='Your email address']")).sendKeys("testing@gmail.com");
		driver.findElement(By.cssSelector("input[placeholder='Your email address']")).clear();
		Thread.sleep(2000);
	}
	public void TC_08_Xpath() throws InterruptedException{	
		driver.get("https://login.ubuntu.com/");
		driver.findElement(By.xpath("//form[@id='login-form']")).sendKeys("test@gmail.com");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//form[@id='login-form']")).clear();
	}
	public void afterClass() {
	}
	