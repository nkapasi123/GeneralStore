package practice.AppiumFramework;
import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import pageObjects.HomePage;
import pageObjects.Pref;

public class APIDemo extends base {

	@Test(dataProvider="InputData")
	public void apiDemo(String input) throws IOException, InterruptedException
	{	
		//service=startServer();

		
		AndroidDriver<AndroidElement> driver = Capabilites("apiDemo");
		HomePage hp = new HomePage(driver);
		Pref ps = new Pref(driver);
		
		hp.Pref.click();
		ps.ps1.click();
		ps.ps2.click();
		ps.ps3.click();
		ps.ps4.sendKeys(input);
		ps.ps5.get(1).click();

		//ps.p5.sendKeys("nish");
		//ps.p6.get(1).click();
		
		//driver.findElementByXPath("//android.widget.TextView[@text='Preference']").click();
		//driver.findElementByXPath("//android.widget.TextView[@text='2. Launching preferences']").click();
		//driver.findElementById("android:id/checkbox").click();
		//driver.findElementByXPath("(//android.widget.RelativeLayout)[2]").click();
		//driver.findElementByClassName("android.widget.EditText").sendKeys("nish");
		//driver.findElementsByClassName("android.widget.Button").get(1).click();
		
		
		//android.widget.RelativeLayout[2]

		//service.stop();

		
		
		
	}
	
	
@DataProvider(name="InputData")
	
	public Object[][] getDataforEdit()
	{
		Object[][] obj = new Object[][]
				{
			{"hello"},{"&^*^"}
				};
		return obj;		
	}
	
	
}
