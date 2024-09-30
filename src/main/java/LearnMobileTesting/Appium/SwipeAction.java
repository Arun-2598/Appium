package LearnMobileTesting.Appium;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.awt.Dimension;
import java.awt.Rectangle;

import javax.swing.Scrollable;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;
import com.sun.tools.javac.util.Assert;

import io.appium.java_client.AppiumBy;

public class SwipeAction extends BasicClass {

	@Test
	public void Swipe_Demo() throws InterruptedException {

		driver.findElement(AppiumBy.accessibilityId("Views")).click();

		driver.findElement(AppiumBy.accessibilityId("Gallery")).click();

		driver.findElement(AppiumBy.accessibilityId("1. Photos")).click();
	//	WebElement Swiping = driver.findElement(By.xpath("//android.widget.ImageView[0]"));
		
		WebElement Swiping = driver.findElement(By.xpath("//android.widget.Gallery[@resource-id='io.appium.android.apis:id/gallery']/android.widget.ImageView[1]"));

		assertEquals(Swiping.getAttribute("focusable"), "true");

		// ((JavascriptExecutor) driver).executeScript("mobile: swipeGesture",
		// ImmutableMap.of(
		// "elementId", ((RemoteWebElement) Swiping).getId(),
		// "direction", "left",
		// "percent", 0.75
		// ));
		SwipeAction(Swiping, "left");

		assertEquals(Swiping.getAttribute("focusable"), "false");

	}
}
