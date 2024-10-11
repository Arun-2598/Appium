package Browser_Automation;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

import Ecomm_App_practice.BasicClass;
import Ecomm_App_practice.Ecomm_TC_2;
import Real_Device.Basic_Class;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class Browser_Test extends Browser_Basic_Class {
	
	public static Logger logger = Logger.getLogger(Browser_Test.class);

	@Test
	public void Browser_Test() {
		
//		driver.get("http://google.com");
//		System.out.println(driver.getTitle());
//		driver.findElement(By.name("q")).sendKeys("https://rahulshettyacademy.com/angularAppdemo/");
//		driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
		
		driver.get("https://rahulshettyacademy.com/angularAppdemo/");
		driver.findElement(By.xpath("//span[@class='navbar-toggler-icon']")).click();
		
		driver.findElement(By.xpath("//a[contains(text(), 'Products ')]")).click();
		driver.executeScript("window.scrollBy(0,1000)", "");
		
		String devopstext = driver.findElement(By.xpath("//a[contains(text(), 'Devops')]")).getText();
		Assert.assertEquals(devopstext, "Devops");
		logger.info(devopstext);

		driver.findElement(By.xpath("//a[contains(text(), 'Devops')]")).click();
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		
		
	}
	

}
