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

public class ScrollAction extends BasicClass {

	@Test
	public void Scrolling() throws InterruptedException {

		driver.findElement(AppiumBy.accessibilityId("Views")).click();

		// driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new
		// UiSelector()).scrollIntoView(text(\"WebView\"));"));

		// Scroll on the specific point
		Scroll_On_Exact_Point("WebView");

		// Scroll to End Action
//		ScrollToEndAction();

	}
}
