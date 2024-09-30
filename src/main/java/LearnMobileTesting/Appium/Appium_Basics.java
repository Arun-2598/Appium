package LearnMobileTesting.Appium;

import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.sun.tools.javac.util.Assert;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

import static org.testng.Assert.assertEquals;

import java.io.File;
import java.net.MalformedURLException;

public class Appium_Basics extends BasicClass {

	@Test
	public void Wifi_Setting_name() throws MalformedURLException, InterruptedException {

		// Appium Code --> Appium Server --> Mobile

		// Xpath, id, AccessebilityId, classname, androidUIAutomator
		driver.findElement(AppiumBy.accessibilityId("Preference")).click();

		driver.findElement(By.xpath("//android.widget.TextView[@content-desc='3. Preference dependencies']")).click();

		Thread.sleep(1000);
		driver.findElement(By.id("android:id/checkbox")).click();

		driver.findElement(By.xpath("(//android.widget.RelativeLayout)[2]")).click();

		String get_Wifi_Setting_Name = driver.findElement(By.id("android:id/alertTitle")).getText();
		System.out.println(get_Wifi_Setting_Name);
		assertEquals(get_Wifi_Setting_Name, "WiFi settings");

		driver.findElement(By.id("android:id/edit")).sendKeys("Arun WiFi");

		driver.findElements(By.className("android.widget.Button)")).get(1).click();

	}
}
