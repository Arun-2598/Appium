package Ecomm_App_practice;

import static org.testng.Assert.assertEquals;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class Ecomm_TC_4_Hybrid extends BasicClass {
	@Test
	public void Goodle_Page() throws InterruptedException {

		Thread.sleep(3000);
		driver.findElement(By.id("com.androidsample.generalstore:id/spinnerCountry")).click();
		Scroll_On_Exact_Point("Brazil");
		driver.findElement(By.xpath("//android.widget.TextView[@text='Brazil']")).click();
		Thread.sleep(1000);

		driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("India");
		driver.hideKeyboard();

		driver.findElement(By.xpath("//android.widget.RadioButton[@text='Female']")).click();

		driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
		Thread.sleep(1000);

		// Add to Cart
		driver.findElements(By.xpath("//android.widget.TextView[@text='ADD TO CART']")).get(0).click();
		Thread.sleep(1000);
		driver.findElements(By.xpath("//android.widget.TextView[@text='ADD TO CART']")).get(0).click();
		Thread.sleep(1000);
		driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
		Thread.sleep(1000);
		List<WebElement> Product_Prices = driver.findElements(By.id("com.androidsample.generalstore:id/productPrice"));

		int Product_list = Product_Prices.size();

		Thread.sleep(2000);
		double Price_Total = 0;

		for (int i = 0; i < Product_list; i++) {
			String Product_pricelist = driver.findElements(By.id("com.androidsample.generalstore:id/productPrice"))
					.get(i).getText();
			System.out.println("price list: " + Product_pricelist);
			double parseDouble = Double.parseDouble(Product_pricelist.substring(1));
			Price_Total = Price_Total + parseDouble;

		}
		System.out.println("price total: " + Price_Total);

		Thread.sleep(2000);
		String TotalAmount = driver.findElement(By.id("com.androidsample.generalstore:id/totalAmountLbl")).getText();

		double Total_Price_StringtoDouble = Double.parseDouble(TotalAmount.substring(1));
		System.out.println("Price: " + Total_Price_StringtoDouble);

		// Assert.assertEquals(Price_Total, Total_Price_StringtoDouble);

		WebElement TermsandConditions = driver.findElement(By.id("com.androidsample.generalstore:id/termsButton"));
		LongPressAction(TermsandConditions);

		Waits(2000);
		String Alert_TermsandConditions = driver.findElement(By.id("com.androidsample.generalstore:id/alertTitle"))
				.getText();
		assertEquals(Alert_TermsandConditions, "Terms Of Conditions");
		Thread.sleep(1000);
		Waits(1000);
		driver.findElement(By.xpath("//android.widget.Button[@text='CLOSE']")).click();
		Waits(2000);
		driver.findElement(By.className("android.widget.CheckBox")).click();
		driver.findElement(By.id("com.androidsample.generalstore:id/btnProceed")).click();
		Waits(6000);
		Set<String> context = driver.getContextHandles();

		for (String ContextHandle : context) {
			
			System.out.println(ContextHandle);

		}
		Waits(2000);
		driver.context("WEBVIEW_com.androidsample.generalstore");
		
		driver.findElement(By.name("q")).sendKeys("Rahul Shetty Academy");
		driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		driver.context("NATIVE_APP");
		
	}

}
