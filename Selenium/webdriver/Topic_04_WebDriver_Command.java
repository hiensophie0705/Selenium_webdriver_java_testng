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
		
		// mo ra 1 web app(url)
		driver.get("https://www.facebook.com/");//**
		
		//Cac ham tuong tac len trin duyet/element -> kieu tra ve cua ham la void
		// các hàm mà lấy ra dữ liệu thì sẽ có kiểu trả về chứa dữ liệu đó(String/int/boolean)
		//Lấy ra cái URL của page hiện tại
		String loginPageUrl = driver.getCurrentUrl();//**
		//loginPageUrl = https://www.facebook.com/
		Assert.assertEquals(loginPageUrl, "https://facebook.com/");
		Assert.assertEquals(driver.getCurrentUrl(), "facebook.com/");//neu chi dung 1 step
		
		//lấy HTML code của page hiện tại
		driver.getPageSource();
		
		//Lấy ra title của page hiện tại
		driver.getTitle();//**
		Assert.assertEquals(driver.getTitle(), "Facebook - Ä�Äƒng nháº­p hoáº·c Ä‘Äƒng kÃ½");
		//facebook- Ä‘Äƒng nháº­p hoáº·c Ä‘Äƒng kÃ­
		
		//lấy ra GUID  của tab  hiện tại
		driver.getWindowHandle();//**
		// Lây rra cái GUID của all tab/window đang có
		driver.getWindowHandles();//**
		//chờ cho các element được loaad thành công trong vòng 15s
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
		//forward tới page trước
		driver.navigate().forward();
		
		
		//tải lại trang
		driver.navigate().refresh();
		
		driver.navigate().to("https://facebook.com/");
		
		//Alert/Iframe(frame)/Window(tab)
		driver.switchTo().alert();//**
		
		driver.switchTo().frame("");//**
		
		driver.switchTo().window("");//**
		
		//**12 hÃ m hay dÃ¹ng tÆ°Æ¡ng tÃ¡c vá»›i browser
		
		
		//
		
		
		
		//
	}
}
