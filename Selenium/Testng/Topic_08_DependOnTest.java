package Testng;


import org.testng.Assert;
import org.testng.annotations.Test;

public class Topic_08_DependOnTest {
	@Test
	public void TC_01_Create_New_User() {
		Assert.assertTrue(false);
	}
	@Test(dependsOnMethods = "TC_01_Create_New_User")
	public void TC_02_View_User() {
		
	}
	@Test(dependsOnMethods = "TC_01_Create_New_User")
	public void TC_03_Edit() {
		
	}
	@Test(dependsOnMethods = "TC_01_Create_New_User")
	public void TC_04_Move_User() {
		
	}
	@Test(dependsOnMethods = "TC_01_Create_New_User")
	public void TC_05_Delete_User() {
		
	}
}
