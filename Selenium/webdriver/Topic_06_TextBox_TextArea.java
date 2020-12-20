package webdriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_06_TextBox_TextArea {
	WebDriver driver;
	String email, userID, password, loginPageUrl;
	String name, dobInput, dobOutput, address, city, state, pin, phone, mail;
	@BeforeClass
	public void beforeClass() {
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("http://demo.guru99.com/v4/");
		
		email = "automation@gmail.com";
		name = "Donald Duck";
		dobInput = "04/05/1999";
		dobOutput = "1999-05-04";
		address = "912 Village Center";
		city = "Saint Louis";
		state = "Missouri";
		pin = "631433";
		phone = "3123456788";
		mail = "donald@gitbub.io";
		
		loginPageUrl = driver.getCurrentUrl();
	}
	
	@Test
	public void TC_01_Register() {
		driver.findElement(By.xpath("//a[text()='here']")).click();
		
		driver.findElement(By.name("emailid")).sendKeys(email);
		driver.findElement(By.name("btnLogin")).click();
		userID = driver.findElement(By.xpath("//td[text()='User ID :']/following-sibling::td")).getText();
		password = driver.findElement(By.xpath("//td[text()='Password :']/following-sibling::td")).getText();
	}
		
	
	@Test
	public void TC_02_Login() {
		driver.get(loginPageUrl);
		
		driver.findElement(By.name("uid")).sendKeys(userID);
		driver.findElement(By.name("password")).sendKeys(password);
		driver.findElement(By.name("btnLogin")).click();
		
		Assert.assertEquals(driver.findElement(By.xpath("//marquee[@class='heading3']")).getText(), "Welcome To Manager's Page of Guru99 Bank");
	}
	
	@Test
	public void TC_03_New_Customer() {
		driver.findElement(By.xpath("//a[text()='New Customer']")).click();
		//New
		driver.findElement(By.name("name")).sendKeys(name);
		driver.findElement(By.name("dob")).sendKeys(dobOutput);
		driver.findElement(By.name("addr")).sendKeys(address);
		driver.findElement(By.name("city")).sendKeys(city);
		driver.findElement(By.name("state")).sendKeys(state);
		driver.findElement(By.name("pinno")).sendKeys(pin);
		driver.findElement(By.name("telephoneno")).sendKeys(phone);
		driver.findElement(By.name("emailid")).sendKeys(mail);
		driver.findElement(By.name("password")).sendKeys("123456");
		
		driver.findElement(By.name("sub")).click();
		
		//Verify
		Assert.assertEquals(driver.findElement(By.className("heading3")).getText(), "Customer Registered Successfully!!!");
		
		Assert.assertEquals(driver.findElement(By.xpath("//td[text()='Customer Name']/following-sibling::td")).getText(), "Donald Duck");
		Assert.assertEquals(driver.findElement(By.xpath("//td[text()='Birthdate']/following-sibling::td")).getText(), "04/05/1999");
		Assert.assertEquals(driver.findElement(By.xpath("//td[text()='Address']/following-sibling::td")).getText(), "912 Village Center");
		Assert.assertEquals(driver.findElement(By.xpath("//td[text()='City']/following-sibling::td")).getText(), "Saint Louis");
		Assert.assertEquals(driver.findElement(By.xpath("//td[text()='State']/following-sibling::td")).getText(), "Missouri");
		Assert.assertEquals(driver.findElement(By.xpath("//td[text()='Pin']/following-sibling::td")).getText(), "631433");
		Assert.assertEquals(driver.findElement(By.xpath("//td[text()='Mobile No.']/following-sibling::td")).getText(), "3123456788");
		Assert.assertEquals(driver.findElement(By.xpath("//td[text()='Email']/following-sibling::td")).getText(), "donald@gitbub.io");
		
		
	}
	
	@Test
	public void TC_04_Edit_Customer() {
		
	}
	
	@AfterClass
	public void afterClass() {
		driver.quit();
	}
	}
	
	

