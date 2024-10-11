package Ecomm_App_practice;

import static org.testng.Assert.assertEquals;

import java.net.MalformedURLException;
import java.time.Duration;
import java.util.List;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;

public class Ecomm_TC_2 extends BasicClass {
	public String products;
	
	private static Logger logger=Logger.getLogger(Ecomm_TC_2.class);

	@Test
	public void General_Store_App() throws MalformedURLException, InterruptedException {

		Thread.sleep(3000);
		driver.findElement(By.id("com.androidsample.generalstore:id/spinnerCountry")).click();		
		Scroll_On_Exact_Point("India");
		driver.findElement(By.xpath("//android.widget.TextView[@text='India']")).click();
		Thread.sleep(1000);
		
		driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("India");
		driver.hideKeyboard();
		
		driver.findElement(By.xpath("//android.widget.RadioButton[@text='Female']")).click();
		
		driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
		Thread.sleep(1000);
		
		
//		List<WebElement> prices = driver.findElements(By.id("com.androidsample.generalstore:id/productName"));
//		int size_1 = prices.size();

		Scroll_On_Exact_Point("Air Jordan 9 Retro");
		int Product_Total = driver.findElements(By.id("com.androidsample.generalstore:id/productName")).size();

		Thread.sleep(2000);
		for (int i = 0; i < Product_Total; i++) {

			products = driver.findElements(By.id("com.androidsample.generalstore:id/productName")).get(i).getText();
			System.out.println(products);
						
//			products = Product_Total.get(i).getText();


			if (products.equals("Air Jordan 9 Retro")) {
				driver.findElements(By.id("com.androidsample.generalstore:id/productAddCart")).get(i).click();
				System.out.println(" Air Jordan");
				break;

			}

		}
		Thread.sleep(2000);

		driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
//		
//		WebDriverWait waits = new WebDriverWait(driver, Duration.ofSeconds(5));
//		waits.until(ExpectedConditions.attributeContains(driver.findElement(By.id("com.androidsample.generalstore:id/toolbar_tittle")), "text", "Cart"));
		
		String Shoe_Name = driver.findElement(By.xpath("//android.widget.TextView[@text='Air Jordan 9 Retro']")).getText();
		assertEquals(products, Shoe_Name);
		
		logger.info(Shoe_Name);

		driver.findElement(By.id("com.androidsample.generalstore:id/btnProceed")).click();
		
		
	}

}
