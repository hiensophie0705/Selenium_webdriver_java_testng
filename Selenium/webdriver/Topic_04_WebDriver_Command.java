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
		// cÃ¡c hÃ m mÃ  láº¥y dá»¯ liá»‡u thÃ¬ sáº½ cÃ³ kiá»ƒu tráº£ vá»� chá»©a dá»¯ liá»‡u dÃ³( string/int/boolean)
		
		//Láº¥y ra url cá»§a page hiá»‡n táº¡i 
		String loginPageUrl = driver.getCurrentUrl();//**
		//loginPageUrl = https://www.facebook.com/
		Assert.assertEquals(loginPageUrl, "https://facebook.com/");
		Assert.assertEquals(driver.getCurrentUrl(), "facebook.com/");//neu chi dung 1 step
		
		//láº¥y HTML code cá»§a page hiá»‡n táº¡i
		driver.getPageSource();
		
		//láº¥y ra title cá»§a page hiá»‡n táº¡i
		driver.getTitle();//**
		Assert.assertEquals(driver.getTitle(), "Facebook - Ä�Äƒng nháº­p hoáº·c Ä‘Äƒng kÃ½");
		//facebook- Ä‘Äƒng nháº­p hoáº·c Ä‘Äƒng kÃ­
		
		//láº¥y ra GUID  cá»§a tab hiá»‡n táº¡i
		driver.getWindowHandle();//**
		// láº¥y ra GUID cá»§a all tab Ä‘ang cÃ³
		driver.getWindowHandles();//**
		//chá»� cho element Ä‘c load thÃ nh cÃ´ng trong vÃ²ng 15s
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);//**
	   //chá»� cho page Ä‘Æ°á»£c load thÃ nh cÃ´ng
		driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
		// JS Executor
		driver.manage().timeouts().setScriptTimeout(15, TimeUnit.SECONDS);
		
		//full screen
		driver.manage().window().fullscreen();
		
		driver.manage().window().maximize();//**
		//Responsive
	   //driver .manage().window().setSize(arg0);
		//Back láº¡i page trÆ°á»›c
		driver.navigate().back();
		//forward tá»›i page trc Ä‘Ã³
		driver.navigate().forward();
		
		
		//táº£i láº¡i trang
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
