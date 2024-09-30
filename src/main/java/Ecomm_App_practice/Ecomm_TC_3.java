package Ecomm_App_practice;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class Ecomm_TC_3 extends BasicClass{
	@Test
	public void FillForm() throws InterruptedException {
		
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
		
		// Add to Cart
		driver.findElements(By.xpath("//android.widget.TextView[@text='ADD TO CART']")).get(0).click();
			
		driver.findElement(By.xpath("(//android.widget.TextView[@text='ADD TO CART'][1]")).click();

		
	}

}
