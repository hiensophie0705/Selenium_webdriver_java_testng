package webdriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_18_Wait_Part1 {
	WebDriver driver;
	WebDriverWait explicitWait;
	
	@BeforeClass
	public void beforeClass() {
		driver = new FirefoxDriver();
		explicitWait = new WebDriverWait(driver, 10);
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}
	
	@Test
	public void TC_01_Displayed_Visible() {
		driver.get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
		
		//Wait cho element hiển thị/visible
		//Có hiển thị trên UI (User Interface)
		//Có trong DOM(HTML)
		explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("email")));
	
		//Fail
		explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='create_account_error']")));

	}
	
	@Test
	public void TC_02_Undisplayed_Invisible_In_DOM() {
		//Wait cho element không hiển thị (undisplayed/invisible)
		//Không hiển thị trên UI- người dùng không nhìn thấy và thao tác được 
		//TH1: element vẫn có trong DOM
		//TÌm element đầu tiên: Tìm thấy ngay và apply điều kiện(invisibility) luôn
		//Pass điều kiện luôn không cần chờ hết timeout
		explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@id='create_account_error']")));

		//fail
		explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("email")));

	}
	
	@Test
	public void TC_03_Undisplayed_Invisible_Out_DOM() {
		//Wait cho element không hiển thị (undisplayed/invisible)
		//Không hiển thị trên UI- người dùng không nhìn thấy và thao tác được 
		//TH2: element không có trong DOM
		//Tìm element đầu tiên: Không tìm thấy element --> Tìm đi tìm lại nhiều lần cho đến khi hết timeout của implicitWait
		//Mới apply đkien của explicit vào(invisible) --> pass
		explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@id='edit_account_error']")));
	}
	@Test
	public void TC_04_Presence() {
		//Wait cho element có trong DOM
		//TH1: Element có trong DOM + hiển thị trên UI
		explicitWait.until(ExpectedConditions.presenceOfElementLocated(By.id("email")));

		//TH2: Element có trong DOM + không hiển thị trên UI
		explicitWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@id='create_account_error']")));

		//fail
		explicitWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@id='edit_account_error']")));

	}
	
	@Test
	public void TC_05_Clickable_Element_Enable() {
		//button/radio/checkbox/link/dropdown//=> stable trước khi thao tác
		driver.get("http://automationpractice.com/index.php?controller=authentication&back=my-account");

		explicitWait.until(ExpectedConditions.elementToBeClickable(By.id("SubmitLogin")));
		
		driver.get("https://login.mailchimp.com/signup/");
		
		//fail trong vòng 10s: disable
		explicitWait.until(ExpectedConditions.elementToBeClickable(By.id("create-account")));

	}
	
	@Test
	public void TC_06_Staleness() {
		driver.get("https://shopee.vn/");
		
		//wait cho 1 element staleness
		//không có/ còn ở trong DOM
		//Step 1- Thao tác với 1 element -> Error message xuất hiện element(*) - hiển thị
		explicitWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//img[@alt='home_popup_banner']")));
		WebElement popup = driver.findElement(By.xpath("//img[@alt='home_popup_banner']"));
		
		//Step 2- Thao tác...-> element (*) không còn xuất hiện
		driver.findElement(By.xpath("//div[@class='shopee-popup__close-btn']")).click();
		
		//Step 3- Cần chờ cho (*) không còn trong DOM nữa luôn
		explicitWait.until(ExpectedConditions.stalenessOf(popup));

	}
	@AfterClass
	public void afterClass() {
		
	}
	
}
