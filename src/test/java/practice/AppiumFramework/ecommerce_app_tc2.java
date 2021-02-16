package practice.AppiumFramework;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import pageObjects.CheckoutPage;
import pageObjects.FormPage;


public class ecommerce_app_tc2 extends base {


	@Test
	public void totalValidation() throws IOException, InterruptedException
	{

		

		
		AndroidDriver<AndroidElement> driver = Capabilites("GeneralStoreApp");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		FormPage fp = new FormPage(driver);
		CheckoutPage ck = new CheckoutPage(driver);
		Utilities ut = new Utilities(driver);

		fp.fp1.sendKeys("Nish");
		fp.fp2.click();
		
		//ck.productprice

		//driver.findElementByClassName("android.widget.EditText").sendKeys("Nish");
	//	driver.findElementByXPath("//*[@text='Female']").click();
		driver.hideKeyboard();
	//	driver.findElementById("android:id/text1").click();
		fp.GetCountry().click();
		ut.scrollText("Argentina");
		//driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Argentina\"));");
		driver.findElementByXPath("//*[@text='Argentina']").click();
		//driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Let's  Shop\"));");
		ut.scrollText("Let's  Shop");

		Thread.sleep(40);
		driver.findElementById("com.androidsample.generalstore:id/btnLetsShop").click();
		
		
		driver.findElements(By.xpath("//*[@text = 'ADD TO CART']")).get(0).click();
		driver.findElementsByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"ADD TO CART\"));").get(0).click();

		

		driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
		Thread.sleep(40);
		//driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textMatches(\"$160.97\").instance(0))"));   			
		int count = ck.productprice.size();
		double sum= 0;
		for (int i=0;i<count; i++)
			
		{
		//	driver.findElement(MobileBy.AndroidUIAutomator("scrollIntoView(new UiSelector().textMatches(\"$160.97\").instance(0))"));     
			String amount1= ck.productprice.get(i).getText();
																	

			double amount=getAmount(amount1);

			sum=sum+amount;//280.97+116.97
		}
		
		/*String amount1 = driver.findElements(By.id("com.androidsample.generalstore:id/productPrice")).get(0).getText();
		double amountvalue1 = getAmount(amount1);
		System.out.println(amount1);
		Thread.sleep(40);

		String amount2 = driver.findElements(By.id("com.androidsample.generalstore:id/productPrice")).get(1).getText();
		double amountvalue2 = getAmount(amount2);
		System.out.println(amountvalue2);


		
		double sumofproducts = amountvalue1 + amountvalue2; */
		
		System.out.println("Sum of items" + sum);
       String total = driver.findElement(By.id("com.androidsample.generalstore:id/totalAmountLbl")).getText();
       
       
		
       total = total.substring(1);
		double totalvalue = Double.parseDouble(total);
		
		System.out.println("Total Value" + totalvalue);
		
	}




	public static double getAmount(String value)
	{
		value = value.substring(1);
		double amountvalue = Double.parseDouble(value);
		return amountvalue;
	}


}
