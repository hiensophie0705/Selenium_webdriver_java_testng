package webdriver;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_19_Upload_File {
	WebDriver driver;
	String project_location = System.getProperty("user.dir");
	
	
	String cute1FileName = "cute1.jpg";
	String cute2FileName = "cute2.jpg";
	String cute3FileName = "cute3.jpg";
	String cute1FileNamePath = project_location + "\\uploadFiles\\" + cute1FileName;
	String cute2FileNamePath = project_location + "\\uploadFiles\\" + cute2FileName;
	String cute3FileNamePath = project_location + "\\uploadFiles\\" + cute3FileName;
	String documentFilePath = project_location + "\\uploadFiles\\aoesync.txt";
	
	String firefoxAutoIT = project_location + "\\autoIT\\firefoxUploadOneTime.exe";
	String chromeAutoIT = project_location + "\\autoIT\\chromeUploadOneTime.exe";
	String chromeMultipleAutoIT = project_location + "\\autoIT\\chromeUploadMultiple.exe";
	
	
	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.chrome.driver",".\\BrowserDriver\\chromedriver.exe");
		driver = new ChromeDriver();
		
		//System.setProperty("webdriver.gecko.driver",".\\BrowserDriver\\geckodriver.exe");
		//driver = new FirefoxDriver();
		
		//System.setProperty("webdriver.edge.driver",".\\BrowserDriver\\msedgedriver.exe");
		//driver = new EdgeDriver();
		
		driver.manage().timeouts().implicitlyWait(35, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}
	
	
	public void TC_01_Sendkey_One_File_Per_Time() {
		driver.get("http://blueimp.github.com/jQuery-File-Upload/");
		
		//work với element (//input[@type='File'])
		driver.findElement(By.xpath("//input[@type='file']")).sendKeys(cute1FileNamePath);
		driver.findElement(By.xpath("//input[@type='file']")).sendKeys(cute2FileNamePath);
		driver.findElement(By.xpath("//input[@type='file']")).sendKeys(cute3FileNamePath);
	
		//Verify file loaded success
		Assert.assertTrue(driver.findElement(By.xpath("//p[text()= '" + cute1FileName + "']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//p[text()= '" + cute2FileName + "']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//p[text()= '" + cute3FileName + "']")).isDisplayed());
		
		
		//click start upload each file
		List<WebElement> startUpload = driver.findElements(By.cssSelector("table .start"));
		for (WebElement startButton : startUpload) {
			startButton.click();
			sleepInSecond(1);
		}
		
		//Verify file uploaded success
		Assert.assertTrue(driver.findElement(By.xpath("//a[text()= '" + cute1FileName + "']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//a[text()= '" + cute2FileName + "']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//a[text()= '" + cute3FileName + "']")).isDisplayed());
		
		
	}	
	//@Test
	public void TC_02_SendKey_Multi_File_Per_Time() {
		driver.get("http://blueimp.github.com/jQuery-File-Upload/");
		
	
		driver.findElement(By.xpath("//input[@type='file']")).sendKeys(cute1FileNamePath + "\n" + cute2FileNamePath + "\n" + cute3FileNamePath);
		
		//Verify file loaded success
		Assert.assertTrue(driver.findElement(By.xpath("//p[text()= '" + cute1FileName + "']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//p[text()= '" + cute2FileName + "']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//p[text()= '" + cute3FileName + "']")).isDisplayed());
		
		
		//click start upload each file
		List<WebElement> startUpload = driver.findElements(By.cssSelector("table .start"));
		for (WebElement startButton : startUpload) {
			startButton.click();
			sleepInSecond(1);
		}
		
		//Verify file uploaded success
		Assert.assertTrue(driver.findElement(By.xpath("//a[text()= '" + cute1FileName + "']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//a[text()= '" + cute2FileName + "']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//a[text()= '" + cute3FileName + "']")).isDisplayed());
		
		//Verify image not brolen
		Assert.assertTrue(isImageLoadedSuccess("//a[@title='" + cute1FileName + "']/img"));
		Assert.assertTrue(isImageLoadedSuccess("//a[@title='" + cute2FileName + "']/img"));
		Assert.assertTrue(isImageLoadedSuccess("//a[@title='" + cute3FileName + "']/img"));

		driver.get("https://automationfc.github.io/basic-form/");
		
		Assert.assertTrue(isImageLoadedSuccess("//img[@alt='broken_05']"));
		Assert.assertFalse(isImageLoadedSuccess("//img[@alt='broken_01']"));
		Assert.assertFalse(isImageLoadedSuccess("//img[@alt='broken_02']"));
		Assert.assertFalse(isImageLoadedSuccess("//img[@alt='broken_03']"));
		Assert.assertFalse(isImageLoadedSuccess("//img[@alt='broken_04']"));
	}
	//@Test
	public void TC_03_SendKey_Google_Translate() {
		driver.get("https://translate.google.com/?hl=vi&sl=auto&tl=vi&op=docs");
		
		driver.findElement(By.xpath("//input[@name='file']")).sendKeys(documentFilePath);
	}
	
	//@Test
	public void TC_04_AutoIT_OneFile_PerTime() throws IOException {
		driver.get("http://blueimp.github.com/jQuery-File-Upload/");
		
		driver.findElement(By.cssSelector(".fileinput-button")).click();
	
		
		if(driver.toString().contains("firefox")) {
			Runtime.getRuntime().exec(new String[] { firefoxAutoIT , cute1FileNamePath });
		}
		else if(driver.toString().contains("chrome")) {
			Runtime.getRuntime().exec(new String[] { chromeAutoIT , cute1FileNamePath });
		}else {
			new Exception("Please choose your browser!");
		}
		Assert.assertTrue(driver.findElement(By.xpath("//p[text()='" + cute1FileName + "']")).isDisplayed());

		
	}
	
	//@Test
	public void TC_05_AutoIT_MultiFile_PerTime() throws IOException {
		driver.get("http://blueimp.github.com/jQuery-File-Upload/");
		
		driver.findElement(By.cssSelector(".fileinput-button")).click();
		
		Runtime.getRuntime().exec(new String[] { chromeMultipleAutoIT, cute1FileNamePath, cute2FileNamePath, cute3FileNamePath });
	
		
			Assert.assertTrue(driver.findElement(By.xpath("//p[text()= '" + cute1FileName + "']")).isDisplayed());
			Assert.assertTrue(driver.findElement(By.xpath("//p[text()= '" + cute2FileName + "']")).isDisplayed());
			Assert.assertTrue(driver.findElement(By.xpath("//p[text()= '" + cute3FileName + "']")).isDisplayed());
}
	
	@Test
	public void TC_06_Java_Robot() throws AWTException {
		driver.get("http://blueimp.github.com/jQuery-File-Upload/");
		
		driver.findElement(By.cssSelector(".fileinput-button")).click();
		
		//Specify the file location with extension
		StringSelection select = new StringSelection(cute1FileNamePath);
		
		//Copy to clipboard
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(select, null);
		
		Robot robot = new Robot();
		sleepInSecond(1);
		
		//Nhấn phím Enter
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		
		//Nhấn xuống Ctrl V
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		
		//Nhả Ctrl V
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_V);
		sleepInSecond(1);
		
		//Nhấn Enter và chọn File
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		
		//Verify file loaded success
		Assert.assertTrue(driver.findElement(By.xpath("//p[text()='" + cute1FileName + "']")).isDisplayed());
	}
	public boolean isImageLoadedSuccess(String locator) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		WebElement element = driver.findElement(By.xpath(locator));
		return (boolean) jsExecutor.executeScript("return arguments[0].complete && typeof"
				+ "arguments[0].naturalWidth != 'undefined' && arguments[0].naturalWidth > 0", element);
		
		
		}
	public void sleepInSecond(long timeInSecond) {
		try {
			Thread.sleep(timeInSecond*1000);
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	@AfterClass
	public void afterClass() {
		//driver.quit();
		}
	
}
