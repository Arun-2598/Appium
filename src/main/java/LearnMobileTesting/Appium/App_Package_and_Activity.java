package LearnMobileTesting.Appium;

import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.DeviceRotation;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;
import com.sun.tools.javac.util.Assert;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

import static org.testng.Assert.assertEquals;

import java.io.File;
import java.net.MalformedURLException;

public class App_Package_and_Activity extends BasicClass {

	@Test
	public void Miscellanous() throws MalformedURLException, InterruptedException {

//		driver.findElement(AppiumBy.accessibilityId("Preference")).click();
//
//		driver.findElement(By.xpath("//android.widget.TextView[@content-desc='3. Preference dependencies']")).click();

		Activity activity = new Activity("io.appium.android.apis", "io.appium.android.apis.preference.PreferenceDependencies");
		
	
		driver.executeScript("mobile: startActivity", ImmutableMap.of("intent", "io.appium.android.apis/io.appium.android.apis.preference.PreferenceDependencies"));
		Thread.sleep(1000);
		driver.findElement(By.id("android:id/checkbox")).click();

		// Rotate the screen into landscape Mode
//		DeviceRotation landscape = new DeviceRotation(0, 0, 90);
//		driver.rotate(landscape);

		driver.findElement(By.xpath("(//android.widget.RelativeLayout)[2]")).click();

		String get_Wifi_Setting_Name = driver.findElement(By.id("android:id/alertTitle")).getText();
		assertEquals(get_Wifi_Setting_Name, "WiFi settings");

		// ClipBoard Actions
		driver.setClipboardText("Arun WiFi");
		driver.findElement(By.id("android:id/edit")).sendKeys(driver.getClipboardText());

		// Key Events
		driver.pressKey(new KeyEvent(AndroidKey.ENTER));
//		driver.findElement(By.id("android:id/button1")).click();
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		driver.pressKey(new KeyEvent(AndroidKey.HOME));
		

	}
}
