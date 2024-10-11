package Ecomm_App_practice;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class BasicClass {
	
	public AppiumDriverLocalService server;
	public AndroidDriver driver;

	@BeforeClass
	public void ConfigureAppium() throws MalformedURLException {
		// 1. Code to start server
		server = new AppiumServiceBuilder()
				.withAppiumJS(new File(
						"C:\\Users\\arun.kumar\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"))
				.withIPAddress("192.168.4.130").usingPort(4723).build();
		server.start();

		// 2. Setting up the Device(Simulator) Name and Apps
		UiAutomator2Options options = new UiAutomator2Options();
		options.setDeviceName("ArunSimulator");
		options.setChromedriverExecutable("C:\\Users\\arun.kumar\\eclipse-workspace\\Appium\\chromedriver.exe");
		options.setApp("C:\\Users\\arun.kumar\\eclipse-workspace\\Appium\\General-Store.apk");

		// 3. Setting up the IP Address and Port
		driver = new AndroidDriver(new URL("http://192.168.4.130:4723"), options);
	}
	
	
	public void LongPressAction(WebElement element) {
		((JavascriptExecutor) driver).executeScript("mobile: longClickGesture",ImmutableMap.of(
				"elementId", ((RemoteWebElement) element).getId(),
				"duration", 4000));
	}
	
	public void Scroll_On_Exact_Point(String TEXT) {
		driver.findElement(AppiumBy
				.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"" + TEXT + "\"));"));

	}
	
	public void propertyy() {
		PropertyConfigurator.configure("C:\\Users\\arun.kumar\\eclipse-workspace\\Appium\\log4j.properties");

	}
	
	public void Waits(int value) throws InterruptedException {
		Thread.sleep(value);
	}
	
//	@AfterClass
//	public void TearDown() throws InterruptedException {
//		Thread.sleep(5000);
//		driver.quit();
//		server.stop();
//	}

}
