package webdriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_04_WebDriver_Command {
	WebDriver driver;
	
	@BeforeClass
	public void beforeClass() {
		driver = new FirefoxDriver();
	}
	@Test
	public void TC_01_Web_Browswe() {
		//browser
		//Apply cho tab/window
		driver.close();//**
		
		//Apply cho browser
		driver.quit();//**
		
		// mở ra 1 web app(url)
		driver.get("https://www.facebook.com/");//**
		
		//Cac ham tuong tac len trin duyet/element -> kieu tra ve cua ham la void
		// các hàm mà lấy dữ liệu thì sẽ có kiểu trả về chứa dữ liệu dó( string/int/boolean)
		
		//Lấy ra url của page hiện tại 
		String loginPageUrl = driver.getCurrentUrl();//**
		//loginPageUrl = https://www.facebook.com/
		Assert.assertEquals(loginPageUrl, "https://facebook.com/");
		Assert.assertEquals(driver.getCurrentUrl(), "facebook.com/");//neu chi dung 1 step
		
		//lấy HTML code của page hiện tại
		driver.getPageSource();
		
		//lấy ra title của page hiện tại
		driver.getTitle();//**
		Assert.assertEquals(driver.getTitle(), "Facebook - Đăng nhập hoặc đăng ký");
		//facebook- đăng nhập hoặc đăng kí
		
		//lấy ra GUID  của tab hiện tại
		driver.getWindowHandle();//**
		// lấy ra GUID của all tab đang có
		driver.getWindowHandles();//**
		//chờ cho element đc load thành công trong vòng 15s
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);//**
	   //chờ cho page được load thành công
		driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
		// JS Executor
		driver.manage().timeouts().setScriptTimeout(15, TimeUnit.SECONDS);
		
		//full screen
		driver.manage().window().fullscreen();
		
		driver.manage().window().maximize();//**
		//Responsive
	   //driver .manage().window().setSize(arg0);
		//Back lại page trước
		driver.navigate().back();
		//forward tới page trc đó
		driver.navigate().forward();
		
		
		//tải lại trang
		driver.navigate().refresh();
		
		driver.navigate().to("https://facebook.com/");
		
		//Alert/Iframe(frame)/Window(tab)
		driver.switchTo().alert();//**
		
		driver.switchTo().frame("");//**
		
		driver.switchTo().window("");//**
		
		//**12 hàm hay dùng tương tác với browser
		
		
		//
		
		
		
		//
	}
}
