package pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class Pref {
	private WebDriver AppiumFeildDecorator;

	public Pref(AndroidDriver driver)
	{
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);

	}

	
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='3. Preference dependencies']")
	public WebElement ps1;
	
	@AndroidFindBy(id="android:id/checkbox")
	public WebElement ps2;
	
	@AndroidFindBy(xpath="(//android.widget.RelativeLayout)[2]")
	public WebElement ps3;
	
	@AndroidFindBy(className="android.widget.EditText")
	public WebElement ps4;
	
	@AndroidFindBy(className="android.widget.Button")
	public List<WebElement> ps5;
	

	
//		driver.findElementByXPath("(//android.widget.RelativeLayout)[2]").click();



}
