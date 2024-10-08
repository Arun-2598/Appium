package Ecomm_App_practice;

import static org.testng.Assert.assertEquals;

import java.net.MalformedURLException;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;

public class Ecomm_TC_1 extends BasicClass {

	@Test
	public void General_Store_App() throws MalformedURLException, InterruptedException {

		Thread.sleep(3000);
		driver.findElement(By.id("com.androidsample.generalstore:id/spinnerCountry")).click();
		Scroll_On_Exact_Point("India");
		driver.findElement(By.xpath("//android.widget.TextView[@text='India']")).click();
		Thread.sleep(1000);
//		driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("India");
//		driver.hideKeyboard();
		driver.findElement(By.xpath("//android.widget.RadioButton[@text='Female']")).click();
		driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
		Thread.sleep(1000);
		
		// Validating toast message
		String get_toast_attribute = driver.findElement(By.xpath("(//android.widget.Toast)[1]")).getAttribute("name");
		System.out.println(get_toast_attribute);
		assertEquals(get_toast_attribute, "Please enter your name");
		
		
	}

}
