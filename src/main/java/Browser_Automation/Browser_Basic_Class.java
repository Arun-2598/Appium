package Browser_Automation;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.annotations.BeforeClass;

import com.google.j2objc.annotations.Property;

import Ecomm_App_practice.Ecomm_TC_2;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import net.bytebuddy.implementation.FieldAccessor.PropertyConfigurable;

public class Browser_Basic_Class {

	public AppiumDriverLocalService service ;
	public UiAutomator2Options options;
	public AndroidDriver driver;

	@BeforeClass
	public void BrowserBasics() throws MalformedURLException {

		
		// Starting the server
		 service = new AppiumServiceBuilder()
				.withAppiumJS(new File(
						"C:\\Users\\arun.kumar\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"))
				.withIPAddress("192.168.4.130").usingPort(4723).build();
		service.start();
		
		// 
		options = new UiAutomator2Options();
		options.setDeviceName("ArunSimulator");
		options.setChromedriverExecutable("C:\\Users\\arun.kumar\\eclipse-workspace\\Appium\\chromedriver.exe");
		options.setCapability("browserName", "Chrome");
		
		driver = new AndroidDriver(new URL("http://192.168.4.130:4723"), options);
		
	}
	@BeforeClass
	public void Property() {
		PropertyConfigurator.configure("C:\\Users\\arun.kumar\\eclipse-workspace\\Appium\\log4j.properties");

	}
	

	public void tearDown() {
		driver.quit();
		service.stop();
	}
}
