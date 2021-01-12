package webdriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_05_Web_Element_Command {
	WebDriver driver;
	By emailTextboxBy = By.id("mail");
	By educationTextAreaBy = By.id("edu");
	By ageUnder18Radio = By.id("under_18");
	By jobRole01Dropdown = By.id("job1");

	By passwordTextboxBy = By.id("password");
	By disableRadioBy = By.id("radio-disable");
	By jobRole03Dropdown = By.id("job3");

	By javaLanguageCheckboxBy = By.id("java");
	
	@BeforeClass
	public void beforeClass() {
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	@Test
	public void TC_01_Check_Element_Displayed() throws InterruptedException {
		driver.get("https://automationfc.github.io/basic-form/index.html");

		if (driver.findElement(By.id("mail")).isDisplayed()) {
			System.out.println("Element is displayed");
			driver.findElement(By.id("mail")).sendKeys("Automation Testing");
		} else {
			System.out.println("Element is not displayed");
		}
		Thread.sleep(3000);

		if (driver.findElement(By.id("under_18")).isDisplayed()) {
			System.out.println("Element is displayed");
			driver.findElement(By.id("under_18")).click();
		} else {
			System.out.println("Element is not displayed");
		}

		Thread.sleep(3000);
		// not displayed (not in DOM)
		if (driver.findElement(By.xpath("//a[@title='testing']")).isDisplayed()) {
			System.out.println("Element is displayed");
			System.out.println(driver.findElement(By.xpath("//a[@title='testing']")).getText());
		} else {
			System.out.println("ELement is not displayed");
		}
		Thread.sleep(3000);
		// not displayed( in DOM)
		if (driver.findElement(By.xpath("//h5[text()= 'Name: User5']")).isDisplayed()) {
			System.out.println("Element is displayed");
			System.out.println(driver.findElement(By.xpath("//h5[text()= 'Name: User5']")).getText());
		} else {
			System.out.println("Element is not displayed");
		}
		Thread.sleep(3000);
	}
//all element: checkbox/radio/textbox/link/text/...
	@Test
	public void TC_02_Element_Displayed() {
		driver.navigate().refresh();

		if (isElementDisplayed(emailTextboxBy)) {
			driver.findElement(emailTextboxBy).sendKeys("Automation Testing");
		}
		if (isElementDisplayed(educationTextAreaBy)) {
			driver.findElement(educationTextAreaBy).sendKeys("Automation Testing");
		}
		if (isElementDisplayed(ageUnder18Radio)) {
			driver.findElement(ageUnder18Radio).click();
		}

	}

	@Test
	public void TC_03_Element_Enabled() {
		driver.get("https://automationfc.github.io/basic-form/index.html");
		driver.navigate().refresh();

		Assert.assertTrue(isElementEnabled(emailTextboxBy));
		Assert.assertTrue(isElementEnabled(educationTextAreaBy));
		Assert.assertTrue(isElementEnabled(ageUnder18Radio));
		Assert.assertTrue(isElementEnabled(jobRole01Dropdown));

		Assert.assertFalse(isElementEnabled(passwordTextboxBy));
		Assert.assertFalse(isElementEnabled(disableRadioBy));
		Assert.assertFalse(isElementEnabled(jobRole03Dropdown));
	}
	//checkbox/textbox/radio/button/image
	@Test
	public void TC_04_Element_Selected() throws InterruptedException {
		driver.get("https://automationfc.github.io/basic-form/index.html");
		driver.navigate().refresh();
		
		//verify age under 18/java checkbox de-selected
		Assert.assertFalse(isElementSelected(ageUnder18Radio));
		Assert.assertFalse(isElementSelected(javaLanguageCheckboxBy));
		
		driver.findElement(ageUnder18Radio).click();
		driver.findElement(javaLanguageCheckboxBy).click();
		Thread.sleep(3000);
		
		//verify age under 18/java checkbox selected
		Assert.assertTrue(isElementSelected(ageUnder18Radio));
		Assert.assertTrue(isElementSelected(javaLanguageCheckboxBy));
		
		driver.findElement(ageUnder18Radio).click();
		driver.findElement(javaLanguageCheckboxBy).click();
		Thread.sleep(3000);
		}
	//clickToElement(ageUnder1Radio): cach rut gon
	//clickToElement(javaLanguageCheckboxBy)
	
	@Test
	public void TC_5_Validate_Register_Form() throws InterruptedException {
		driver.get("https://login.mailchimp.com/signup/");
		
		driver.findElement(By.id("email")).sendKeys("automation@gmail.com");
		driver.findElement(By.id("new_username")).sendKeys("automationtest");
		
		//verify Signup button disabled
		Assert.assertFalse(isElementEnabled(By.id("create-account")));
		
		//Lower case
		driver.findElement(By.id("new_password")).sendKeys("auto");
		Thread.sleep(2000);
		Assert.assertFalse(isElementEnabled(By.id("create-account")));
		Assert.assertTrue(isElementDisplayed(By.xpath("//li[@class='lowercase-char completed' and text()='One lowercase character']")));
		
		
		//Special char
		driver.findElement(By.id("new_password")).clear();
		driver.findElement(By.id("new_password")).sendKeys("auto!@");
		Thread.sleep(2000);
		Assert.assertFalse(isElementEnabled(By.id("create-account")));
		Assert.assertTrue(isElementDisplayed(By.xpath("//li[@class='lowercase-char completed' and text()='One lowercase character']")));
		Assert.assertTrue(isElementEnabled(By.id("//li[@class='special-char completed' and text()='One special character']")));
		
		//upper Case
		driver.findElement(By.id("new_password")).clear();
		driver.findElement(By.id("new_password")).sendKeys("Auto@!#");
		Thread.sleep(2000);
		Assert.assertFalse(isElementEnabled(By.id("create-account")));
		Assert.assertTrue(isElementDisplayed(By.xpath("//li[@class='lowercase-char completed' and text()='One lowercase character']")));
		Assert.assertTrue(isElementEnabled(By.id("//li[@class='special-char completed' and text()='One special character']")));
		Assert.assertTrue(isElementDisplayed(By.xpath("//li[@class='uppercase-char completed' and text()='One uppercase character']")));		
	
		//8characters minimum
		driver.findElement(By.id("new_password")).clear();
		driver.findElement(By.id("new_password")).sendKeys("Auto@!#");
		Thread.sleep(2000);
		Assert.assertFalse(isElementEnabled(By.id("create-account")));
		Assert.assertTrue(isElementDisplayed(By.xpath("//li[@class='lowercase-char completed' and text()='One lowercase character']")));
		Assert.assertTrue(isElementEnabled(By.id("//li[@class='special-char completed' and text()='One special character']")));
		Assert.assertTrue(isElementDisplayed(By.xpath("//li[@class='uppercase-char completed' and text()='One uppercase character']")));		
		Assert.assertTrue(isElementDisplayed(By.xpath("//li[@class='8-char completed' and text()='8 characters minimum']")));
		
		//number
		driver.findElement(By.id("new_password")).clear();
		driver.findElement(By.id("new_password")).sendKeys("Autotion123");
		Thread.sleep(2000);
		Assert.assertFalse(isElementEnabled(By.id("create-account")));
		Assert.assertTrue(isElementDisplayed(By.xpath("//li[@class='lowercase-char completed' and text()='One lowercase character']")));
		Assert.assertTrue(isElementDisplayed(By.xpath("//li[@class='uppercase-char completed' and text()='One uppercase character']")));		
		Assert.assertTrue(isElementDisplayed(By.xpath("//li[@class='number-char complete' and text()='One number']")));
		
		//Full
		driver.findElement(By.id("new_password")).clear();
		driver.findElement(By.id("new_password")).sendKeys("Autotion123");
		Thread.sleep(2000);
		Assert.assertFalse(isElementEnabled(By.id("create-account")));
		Assert.assertTrue(isElementDisplayed(By.xpath("//h4[text()=\"Your password is secure and you're all set!\"]")));
		
		
		Assert.assertFalse(isElementDisplayed(By.xpath("//li[@class='lowercase-char completed' and text()='One lowercase character']")));
		Assert.assertFalse(isElementEnabled(By.id("//li[@class='special-char completed' and text()='One special character']")));
		Assert.assertFalse(isElementDisplayed(By.xpath("//li[@class='uppercase-char completed' and text()='One uppercase character']")));		
		Assert.assertFalse(isElementDisplayed(By.xpath("//li[@class='8-char completed' and text()='8 characters minimum']")));
		Assert.assertFalse(isElementDisplayed(By.xpath("//li[@class='uppercase-char completed' and text()='One uppercase character']")));		
		Assert.assertFalse(isElementDisplayed(By.xpath("//li[@class='number-char complete' and text()='One number']")));
		
	
	}
//checkbox/radio
	// common function (call function)

	public boolean isElementDisplayed(By by) {
		if (driver.findElement(by).isDisplayed()) {
			System.out.println("Element is displayed");
			return true;
		} else {
			System.out.println("Element is not displayed");
			return false;
		}
	}

	public boolean isElementEnabled(By by) {
		if (driver.findElement(by).isEnabled()) {
			System.out.println("Element is enabled");
			return true;
		} else {
			System.out.println("Element is disabled");
			return false;
		}
		}
	public boolean isElementSelected(By by) {
		if (driver.findElement(by).isSelected()) {
			System.out.println("Element is selected");
			return true;
		} else {
			System.out.println("Element is deselected");
			return false;
		}

	}
	
}
