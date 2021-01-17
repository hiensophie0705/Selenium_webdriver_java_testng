package webdriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_06_TextBox_TextArea {
	WebDriver driver;
	String email, userID, password, loginPageUrl;
	String gender, name, dobInput, dobOutput, address, city, state, pin, phone, mail;
	String editAddress, editCity, editState, editPin, editPhone, editEmail;
	String customerID;
	//Locator for new customer form
	By nameBy = By.name("name");
	By genderBy = By.name("rad1");
	By dobBy = By.name("dob");
	By addressBy = By.name("addr");
	By cityBy = By.name("city");
	By stateBy = By.name("state");
	By pinBy = By.name("pinno");
	By phoneBy = By.name("telephoneno");
	By emailBy = By.name("emailid");
	By passwordBy = By.name("password");
	
	@BeforeClass
	public void beforeClass() {
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("http://demo.guru99.com/v4");
		
		email = "dobaba1997@gmail.com";
		name = "dobaba";
		dobInput = "07/05/1997";
		dobOutput = "1997-07-05";
		address = "Hong Giang";
		city = "Thai Binh";
		state = "Viet Nam";
		pin = "123456";
		phone = "0123456789";
		mail = "dobaba1997@gmail.com";
		password = "123456";
		loginPageUrl = driver.getCurrentUrl();
		
		editAddress = "Hong Giang, Dong Hung, Thai Binh";
		editCity = "Thai Binh";
		editState = "Viet Nam";
		editPin = "123456";
		editPhone ="0123456789";
		editEmail = "hien123@gmail.com";
	}

	@Test
	public void TC_01_Register() {
		driver.findElement(By.xpath("//a[text()='here']")).click();

		driver.findElement(By.name("emailid")).sendKeys(email);
		driver.findElement(By.name("btnLogin")).click();
		
		// get thông tin user/Pass ra lưu vào biến
		userID = driver.findElement(By.xpath("//td[text()='User ID :']/following-sibling::td")).getText();
		password = driver.findElement(By.xpath("//td[text()='Password :']/following-sibling::td")).getText();
	}

	@Test
	public void TC_02_Login() {
		driver.get(loginPageUrl);

		// Set giá trị từ biến vào form đăng nhập
		driver.findElement(By.name("uid")).sendKeys(userID);
		driver.findElement(By.name("password")).sendKeys(password);
		driver.findElement(By.name("btnLogin")).click();
		Assert.assertTrue(driver.findElement(By.xpath("//td[text()='Manger Id : " + userID + "']")).isDisplayed());
		Assert.assertEquals(driver.findElement(By.xpath("//marquee[@class='heading3']")).getText(),
				"Welcome To Manager's Page of Guru99 Bank");
	}

	@Test
	public void TC_03_New_Customer() {
		driver.findElement(By.xpath("//a[text()='New Customer']")).click();
		
		// input
		driver.findElement(nameBy).sendKeys(name);
		driver.findElement(dobBy).sendKeys(dobInput);
		driver.findElement(addressBy).sendKeys(address);
		driver.findElement(cityBy).sendKeys(city);
		driver.findElement(stateBy).sendKeys(state);
		driver.findElement(pinBy).sendKeys(pin);
		driver.findElement(phoneBy).sendKeys(phone);
		driver.findElement(emailBy).sendKeys(mail);
		driver.findElement(passwordBy).sendKeys("123456");

		driver.findElement(By.name("sub")).click();
		
		// server process + response(output)//Verify
		Assert.assertEquals(driver.findElement(By.className("heading3")).getText(),
				"Customer Registered Successfully!!!");

		Assert.assertEquals(
				driver.findElement(By.xpath("//td[text()='Customer Name']/following-sibling::td")).getText(), name);
		Assert.assertEquals(driver.findElement(By.xpath("//td[text()='Birthdate']/following-sibling::td")).getText(), dobOutput);
		Assert.assertEquals(driver.findElement(By.xpath("//td[text()='Address']/following-sibling::td")).getText(), address);
		Assert.assertEquals(driver.findElement(By.xpath("//td[text()='City']/following-sibling::td")).getText(), city);
		Assert.assertEquals(driver.findElement(By.xpath("//td[text()='State']/following-sibling::td")).getText(), state);
		Assert.assertEquals(driver.findElement(By.xpath("//td[text()='Pin']/following-sibling::td")).getText(), pin);
		Assert.assertEquals(driver.findElement(By.xpath("//td[text()='Mobile No.']/following-sibling::td")).getText(), phone);
		Assert.assertEquals(driver.findElement(By.xpath("//td[text()='Email']/following-sibling::td")).getText(), mail);

		customerID = driver.findElement(By.xpath("//td[text()='Customer ID)']/following-sibling::td")).getText();
	}

	@Test
	public void TC_04_Edit_Customer() {
		
		
		driver.findElement(By.xpath("//a[text()='Edit Customer']")).click();

		driver.findElement(By.name("cusid")).sendKeys(customerID);
		driver.findElement(By.name("AccSubmit")).click();
		
		// Verify 3 fields are disabled
		Assert.assertFalse(isElementEnabled(nameBy));
		Assert.assertFalse(isElementEnabled(dobBy));
		Assert.assertFalse(isElementEnabled(genderBy));

		// Verify value at Edit customer page matching with value at New Customer

		Assert.assertEquals(driver.findElement(nameBy).getAttribute("value"), name);
		Assert.assertEquals(driver.findElement(dobBy).getAttribute("value"), dobOutput);
		Assert.assertEquals(driver.findElement(addressBy).getText(), address);
		Assert.assertEquals(driver.findElement(cityBy).getAttribute("value"), city);
		Assert.assertEquals(driver.findElement(stateBy).getAttribute("value"), state);
		Assert.assertEquals(driver.findElement(pinBy).getAttribute("value"), pin);
		Assert.assertEquals(driver.findElement(By.xpath("//td[text()='Mobile No.']/following-sibling::td")).getText(),
				"3123456788");
		Assert.assertEquals(driver.findElement(By.xpath("//td[text()='Email']/following-sibling::td")).getText(),
				"donald@gitbub.io");

		// Edit customer
		driver.findElement(addressBy).sendKeys(editAddress);
		driver.findElement(cityBy).sendKeys(editCity);
		driver.findElement(stateBy).sendKeys(editState);
		driver.findElement(pinBy).sendKeys(editPin);
		driver.findElement(phoneBy).sendKeys(editPhone);
		driver.findElement(emailBy).sendKeys(editEmail);
		driver.findElement(passwordBy).sendKeys("123456");

		driver.findElement(By.name("sub")).click();

		//Server process/Response (output)
		Assert.assertTrue(driver.findElement(By.xpath("//p[text()='Customer details updated successfully!!!']")).isDisplayed());
		Assert.assertEquals(driver.findElement(By.xpath("//td[text()='Customer Name']/following-sibling::td")).getText(), name);
	    Assert.assertEquals(driver.findElement(By.xpath("//td[text()='Birthdate']/following-sibling::td")).getText(), dobOutput);
	    
		Assert.assertEquals(driver.findElement(By.xpath("//td[text()='Address']/following-sibling::td")).getText(), editAddress );
		Assert.assertEquals(driver.findElement(By.xpath("//td[text()='City']/following-sibling::td")).getText(), editCity);
		Assert.assertEquals(driver.findElement(By.xpath("//td[text()='State']/following-sibling::td")).getText(), editState);
		Assert.assertEquals(driver.findElement(By.xpath("//td[text()='Pin']/following-sibling::td")).getText(), editPin);
		Assert.assertEquals(driver.findElement(By.xpath("//td[text()='Mobile No.']/following-sibling::td")).getText(), editPhone);
		Assert.assertEquals(driver.findElement(By.xpath("//td[text()='Email']/following-sibling::td")).getText(), editEmail );
		
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

	public boolean isElementEnabled(By by) {
		WebElement element = driver.findElement(by);
		if (element.isEnabled()) {
			
			return true;
		}else {
			return false;
		}

	}
}
