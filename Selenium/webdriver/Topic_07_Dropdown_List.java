package webdriver;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_07_Dropdown_List {
	WebDriver driver;
	Select select;
	String firstName, lastName, email, password, companyName, date, month, year;
	By genderMaleBy = By.id("gender-male");
	By firstNameBy = By.id("FirstName");
	By lastNameBy = By.id("LastName");
	By emailBy = By.id("Email");
	By companyBy = By.id("Company");
	By dateBy = By.name("DateOfBirthDay");
	By monthBy = By.name("DateOfBirthMonth");
	By yearBy = By.name("DateOfBirthYear");
	@BeforeClass
	public void beforeClass() {
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://demo.nopcommerce.com/");

		firstName = "Hien";
		lastName = "do";
		email = generateEmail();
		password = "123123";
		companyName = "gtvplus";
		date = "3";
		month = "March";
		year = "1997";
	}

	@Test
	public void TC_01_Register() {
		driver.findElement(By.xpath("//a[@class='ico-register']")).click();

		driver.findElement(genderMaleBy).click();
		driver.findElement(firstNameBy).sendKeys(firstName);
		driver.findElement(lastNameBy).sendKeys(lastName);

		select = new Select(driver.findElement(dateBy));
		Assert.assertFalse(select.isMultiple());
		select.selectByVisibleText(date);
		Assert.assertEquals(select.getFirstSelectedOption().getText(), date);
		Assert.assertEquals(select.getOptions().size(), 32);

		select = new Select(driver.findElement(monthBy));
		select.selectByVisibleText(month);
		Assert.assertEquals(select.getFirstSelectedOption().getText(), month);
		Assert.assertEquals(select.getOptions().size(), 13);

		select = new Select(driver.findElement(yearBy));
		select.selectByVisibleText(year);
		Assert.assertEquals(select.getFirstSelectedOption().getText(), year);
		Assert.assertEquals(select.getOptions().size(), 112);

		driver.findElement(emailBy).sendKeys(email);
		driver.findElement(companyBy).sendKeys(companyName);
		driver.findElement(By.id("Password")).sendKeys(password);
		driver.findElement(By.id("ConfirmPassword")).sendKeys(password);
		driver.findElement(By.id("register-button")).click();

		Assert.assertEquals(driver.findElement(By.xpath("//div[@class='result']")).getText(), "Your registration completed");
		
		//navigate to My Account link
		driver.findElement(By.className("ico-account")).click();
		Assert.assertTrue(driver.findElement(genderMaleBy).isSelected());
		
		Assert.assertEquals(driver.findElement(firstNameBy).getAttribute("value"), firstName);
		Assert.assertEquals(driver.findElement(lastNameBy).getAttribute("value"), lastName);
		Assert.assertEquals(driver.findElement(emailBy).getAttribute("value"), email);
		Assert.assertEquals(driver.findElement(companyBy).getAttribute("value"), companyName);
		
		select = new Select(driver.findElement(dateBy));
		Assert.assertEquals(select.getFirstSelectedOption().getText(), date);
		
		select = new Select(driver.findElement(monthBy));
		Assert.assertEquals(select.getFirstSelectedOption().getText(), month);
		
		select = new Select(driver.findElement(yearBy));
		Assert.assertEquals(select.getFirstSelectedOption().getText(), year);
		
		
	}
	
	@Test
	public void TC_02_Multiple() throws InterruptedException {
		driver.get("https://automationfc.github.io/basic-form/index.html");
		List<String> itemText = new ArrayList<String>();
		itemText.add("Manual");
		itemText.add("Mobile");
		itemText.add("Security");
		itemText.add("Functional UI");
		
		select = new Select(driver.findElement(By.name("user_job2")));
		
		select.selectByVisibleText("Manual");
		Thread.sleep(2000);
		select.selectByVisibleText("Mobile");
		Thread.sleep(2000);
		select.selectByVisibleText("Security");
		Thread.sleep(2000);
		select.selectByVisibleText("Functional UI");
		Thread.sleep(2000);
		
		List<WebElement>itemSelected = select.getAllSelectedOptions();
		//Java collection
		@SuppressWarnings("unused")
		List<String> itemSelectedText = new ArrayList<String>();
		
		
		//Verify 4 item selected
		Assert.assertEquals(itemSelected.size(), 4);
		
		for (WebElement item : itemSelected) {
			System.out.println(item.getText());
			
		}
		
	}
	@AfterClass
	public void afterClass() {
		driver.quit();
	}
	
	public String generateEmail() {
		Random rand = new Random();
		return "donald" + rand.nextInt(9999) + "@github.io";
}}
