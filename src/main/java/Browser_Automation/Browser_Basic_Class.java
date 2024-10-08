package Browser_Automation;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.testng.annotations.BeforeClass;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

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
	public void tearDown() {
		driver.quit();
		service.stop();
	}
}
