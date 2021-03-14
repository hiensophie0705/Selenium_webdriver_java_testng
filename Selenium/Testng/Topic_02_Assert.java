package Testng;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Topic_02_Assert {
	@Test()
	public void TC_01() {
		String fullName = "Automation Testing";
		
		Assert.assertTrue(fullName.equals("Manual Testing"));
		Assert.assertTrue(fullName.equals("Manual Testing"), "Fullname is not matching");
		//isDisplayed/isEnabled/isSelected/ isMultiple -> Boolean
		
		Assert.assertEquals(fullName, "Manual Testing");
		
		String address = "Ha Noi";
		Assert.assertNull(address);
	
	}
}