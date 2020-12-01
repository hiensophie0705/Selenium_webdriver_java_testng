package webdriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_02_Xpath_CSS_Part_2_findElement {
	WebDriver driver;
	@BeforeClass
	public void beforeClass() {
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("http://live.demoguru99.com/");
	}
	@Test
	public void TC_01_ValidateCurrentUrl() {
		//inpput vao Email textbox
		driver.findElement(By.tagName("input")).sendKeys("0389930640");
		//findElement -> 1 element<webElement>
		//1- Neu k tim thay element nao: danh fail testcase- throw ra 1 exception: nosuchElement
		//neu nhu no tim thay nhieu hon 1 element thi no luon thao tac voi element dau tien
	    // neu tim thay 1 element -> thao tac voi element do
		
		//findElements-> nhieu element list<WebElement>
		//1. Neu nhu k tim thay element nao: khong danh fail TCs -> tra ve list rong
		//2- neu tim thay 1 element-> tra ve 1 list chua 1 element nay
		//3- neu tim thay nhieu hon 1-> tra ve list nhieu element
		
	}
	@AfterClass
	public void afterClass() {
		//driver.quit();
	}
		
}