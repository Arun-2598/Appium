package LearnMobileTesting.Appium;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;
import com.sun.tools.javac.util.Assert;

import io.appium.java_client.AppiumBy;

public class LongPress extends BasicClass{
	
	@Test
	public void LongPressGestur() {
		driver.findElement(AppiumBy.accessibilityId("Views")).click();
		driver.findElement(By.xpath("//android.widget.TextView[@text='Expandable Lists']")).click();
		driver.findElement(AppiumBy.accessibilityId("1. Custom Adapter")).click();
		
		WebElement element = driver.findElement(By.xpath("//android.widget.TextView[@text='People Names']"));
		
		
		// To click Long Press
		LongPressAction(element);
		String Sample_Menu = driver.findElement(By.id("android:id/title")).getText();
		assertEquals(Sample_Menu, "Sample menu");
		assertTrue(driver.findElement(By.id("android:id/title")).isDisplayed());
		
		
		
		
		
	}

}
