package Testng;

import org.testng.annotations.Test;

public class Topic_04_Priority_Enable_Disable {

	@Test
	public void TC_01_Create_New_User() {
		
	}
	@Test(enabled = true)
	public void TC_02_View_User() {
		
	}
	@Test(enabled = false)
	public void TC_03_Edit() {
		
	}
	@Test(description = "JIRA-0879/: Edit the user")
	public void TC_04_Move_User() {
		
	}
	@Test
	public void TC_05_Delete_User() {
		
	}
}
//order theo thứ tự sắp xếp theo Alphabet
//0-9/A-Z
//Tên chức năng -số thứ tự- Tên testcase