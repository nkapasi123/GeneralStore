package practice.AppiumFramework;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.ServerSocket;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.exec.CommandLine;
import org.apache.commons.exec.DefaultExecuteResultHandler;
import org.apache.commons.exec.DefaultExecutor;
import org.openqa.selenium.remote.CapabilityType;  
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import practice.AppiumFramework.base.AppiumServer;


public class base {
	public class AppiumServer {
		


		public void startServer() {

			CommandLine command = new CommandLine(
					"/Applications/Appium.app/Contents/Resources/node/bin/node");
			command.addArgument(
					"/Applications/Appium.app/Contents/Resources/node_modules/appium/bin/appium.js",
					false);
			command.addArgument("--address", false);
			command.addArgument("127.0.0.1");
			command.addArgument("--port", false);
			command.addArgument("4723");
			command.addArgument("--full-reset", false);
			DefaultExecuteResultHandler resultHandler = new DefaultExecuteResultHandler();
			DefaultExecutor executor = new DefaultExecutor();
			executor.setExitValue(1);
			try {
				executor.execute(command, resultHandler);
				Thread.sleep(5000);
				System.out.println("Appium server started.");
			} catch (IOException e) {
				e.printStackTrace();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		public void stopServer() {
			String[] command = { "/usr/bin/killall", "-KILL", "node" };
			try {
				Runtime.getRuntime().exec(command);
				System.out.println("Appium server stopped.");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void startEmulator() throws IOException, InterruptedException
	{
		Runtime.getRuntime().exec("/Users/nkapasi/AppiumFramework/src/main/java/Resouces/startEmulator.command");
		Thread.sleep(8000);
	}
	public static AndroidDriver<AndroidElement> Capabilites(String appName) throws IOException, InterruptedException  {
		


		FileInputStream fls = new FileInputStream("/Users/nkapasi/AppiumFramework/src/main/java/practice/AppiumFramework/global.properties");
		Properties prop = new Properties();
		prop.load(fls);
		prop.get(appName);
		
		File f = new File("src");
		File fs = new File(f, (String) prop.get(appName));
		
		
		//String device = (String)prop.getProperty("device");
		String device = System.getProperty("deviceName");
		if(device.contains("Samsung"))
		{
			startEmulator();
		}
		
		DesiredCapabilities cap = new DesiredCapabilities();

		/*if(device.equals("real"))
		{
			cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Device");

		}
		else if(device.equals("emulator"))
		{
			cap.setCapability(MobileCapabilityType.DEVICE_NAME, "SamsungGalaxyS7API24");

		}*/
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, device);
		//cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Device");
		cap.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT,14);
		cap.setCapability(MobileCapabilityType.AUTOMATION_NAME,"uiautomator2");

		cap.setCapability(MobileCapabilityType.APP, fs.getAbsolutePath());
		AndroidDriver<AndroidElement> driver = new AndroidDriver<>((new URL("http://127.0.0.1:4723/wd/hub")), cap);

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		
		return driver;

	
	}
	public static void getScreenshot() {
		// TODO Auto-generated method stub
		
	}

}
