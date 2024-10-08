package Real_Device;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.testng.annotations.BeforeClass;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class Basic_Class {
	

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
	//	options.setDeviceName("ArunSimulator");
		
		options.setDeviceName("Android Device"); // real device
		options.setApp("C:\\Users\\arun.kumar\\eclipse-workspace\\Appium\\General-Store.apk");

		// 3. Setting up the IP Address and Port
		driver = new AndroidDriver(new URL("http://192.168.4.130:4723"), options);
	}
	
//	@AfterClass
//	public void TearDown() throws InterruptedException {
//		Thread.sleep(5000);
//		driver.quit();
//		server.stop();
//	}

}
