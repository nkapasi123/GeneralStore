package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class FormPage {
	
	public FormPage(AndroidDriver driver)
	{
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);

	}
	@AndroidFindBy(className="android.widget.EditText")
	public WebElement fp1;
	
	@AndroidFindBy(xpath="//*[@text='Female']")
	public WebElement fp2;
	
	@AndroidFindBy(id="android:id/text1")
	private WebElement countrySelection;
	
	public WebElement GetCountry()
	{
		System.out.println("select country please");
		return countrySelection;
	}

}
