package LearnMobileTesting.Appium;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;

public class DragandDrop extends BasicClass {

	@Test
	public void DargandDropTest() throws InterruptedException {

		driver.findElement(AppiumBy.accessibilityId("Views")).click();

		driver.findElement(AppiumBy.accessibilityId("Drag and Drop")).click();

		WebElement Source = driver.findElement(By.id("io.appium.android.apis:id/drag_dot_1"));

		driver.executeScript("mobile: dragGesture",ImmutableMap.of(
		"elementId", ((RemoteWebElement) Source).getId(), 
		"endX", 652,
		"endY", 574));

		Thread.sleep(3000);

		String result = driver.findElement(By.id("io.appium.android.apis:id/drag_result_text")).getText();
		assertEquals(result, "Dropped!");

	}
}
