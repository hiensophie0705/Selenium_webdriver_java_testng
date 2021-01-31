package webdriver;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_15_Window_tab {
	WebDriver driver;
	@BeforeClass
	public void beforeClass() {
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		}
	
	@Test
	public void TC_01_Only_2_Windows_Tabs() {
		driver.get("https://automationfc.github.io/basic-form/index.html");
		
		//Mỗi 1 tab/window sẽ có 1 ID đại diện
		
		//Lấy ra cái ID của tab/window hiện tại đàn active
		
		String currentWindowID = driver.getWindowHandle();
		System.out.println(currentWindowID);
		
		//lấy ra id lần 1 chạy qua
		Set<String> windowIDs = driver.getWindowHandles();
		System.out.println("lan 1");
		for(String id : windowIDs) {
			System.out.println(id);
		}
		
		//click google thành 1 tab mới
		driver.findElement(By.xpath("//a[text()='GOOGLE']")).click();
		// lấy ra id của tab trước và tab google
		windowIDs = driver.getWindowHandles();
		System.out.println("lan 2");
		for(String id : windowIDs) {
			System.out.println(id);
		}
		

	}
	}

