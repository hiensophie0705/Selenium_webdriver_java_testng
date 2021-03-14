package webdriver;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;

public class Topic_20_Download_File {
	WebDriver driver;
	String projectLocation = System.getProperty("user.dir");
	private String downloadFilePath;
	
	
	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.gecko.driver", ".\\browserDrivers\\geckodriver.exe");
		FirefoxOptions options = new FirefoxOptions();
		options.addPreference("browser.download.folderList", 2);
		options.addPreference("browser.doưnload.dir", projectLocation + "\\downloadFiles");
		options.addPreference("browser.dowmload.useDownloadDir", true);
		options.addPreference("browser.helperApps.neverAsk.saveToDisk", "application/pdf");
		options.addPreference("pdfjs.disabled", true);
		driver = new FirefoxDriver(options);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	
	public void TC_01_uploadFile() {
		driver.get("https://unsplash.com/photos/JsjXnWlh8-g");
		
		driver.findElement(By.xpath("//span[text()='Download free']")).click();
		
		//verify có 1 file được tải về
		waitForDownloadFileContainsNameCompleted("unsplash.jpg");
		
		//Đếm số lượng file trong thư mục sau khi tải về
		int countFileBeforeDelete = countFilesInDirectory();
		
		// Verify số lượng file tải về bằng 1
		Assert.assertEquals(countFileBeforeDelete, 1);
		
	}
	
	public void deleteAllFileInFolder() {
		try {
			File file = new File(downloadFilePath);
			File[] listOfFiles = file.listFiles();
			System.out.println("File = " + listOfFiles.length);
			for (int i = 0; i < listOfFiles.length; i++) {
				if (listOfFiles[i].isFile()) {
					new File(listOfFiles[i].toString()).delete();
				}
			}
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}
	}

	public void waitForDownloadFileFullnameCompleted(String fileName) {
		int i = 0;
		while (i < 60) {
			boolean exist = isFileExists(fileName);
			if (exist == true) {
				i = 60;
				break;
			}
			sleepInSecond(1);
			i = i + 1;
		}
	}

	public void waitForDownloadFileContainsNameCompleted(String fileName) {
		int i = 0;
		while (i < 60) {
			boolean exist = isFileContain(fileName);
			if (exist == true) {
				i = 60;
				break;
			}
			sleepInSecond(1);
			i = i + 1;
		}
	}

	private void sleepInSecond(int i) {
		// TODO Auto-generated method stub
		
	}

	public boolean isFileContain(String fileName) {
		try {
			boolean flag = false;
			File dir = new File(downloadFilePath);
			File[] files = dir.listFiles();
			if (files == null || files.length == 0) {
				flag = false;
			}
			for (int i = 0; i < files.length; i++) {
				if (files[i].getName().endsWith(fileName)) {
					flag = true;
				}
			}
			return flag;
		} catch (Exception e) {
			System.out.print(e.getMessage());
			return false;
		}
	}

	public boolean isFileExists(String file) {
		try {
			File files = new File(downloadFilePath + file);
			boolean exists = files.exists();
			return exists;
		} catch (Exception e) {
			System.out.print(e.getMessage());
			return false;
		}
	}

	public int countFilesInDirectory() {
		File file = new File(downloadFilePath);
		int i = 0;
		for (File listOfFiles : file.listFiles()) {
			if (listOfFiles.isFile()) {
				i++;
			}
		}
		return i;
	}
	

	private void waitForDownloadFileContainsNameCompleted1(String string) {
		// TODO Auto-generated method stub
		
	}

	private int countFilesInDirectory1() {
		// TODO Auto-generated method stub
		return 0;
	}
		
		
	
}
