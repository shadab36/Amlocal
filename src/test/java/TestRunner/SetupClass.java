package TestRunner;

import java.io.FileReader;
import java.net.URL;
import java.util.Properties;
import java.util.logging.Logger;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import webApp.CommonData;

public class SetupClass {
	public static WebDriver driver;
	public static String AppURL;
	public static Properties property = new Properties(System.getProperties());
	public static String sauceURL;
	public static String browserName;
	public static String platformVersion;
	public static String platform;
	public static String browserVersion;
	public static String platformName;
	public static String deviceName;
	public static String deviceOrientation;
	public static Logger log;
	public static String Seleniumdriver;
	public static WebElement webelement;
	public static String localtestFF;
	public static String localFF;
	public static String onmobile;
	public static String chrom_mobile;
	public static String local_IE11browser;
	public static String local_IE11;
	public static String oncloud;
	public static String local_chromebrowser;
	public static String local_chrome;

	@BeforeClass
	public static void before_Class() throws Exception {
		log = Logger.getLogger(BeforeClass.class.getName());
		property.load(new FileReader("C:\\Users\\AL Moin Webtech\\AutoSlideTeam\\Amlocal\\src\\main\\resources\\configure.properties"));
		AppURL = property.getProperty("App_url");
		sauceURL = property.getProperty("sauce_url");
		deviceName = property.getProperty("device_name");
		platformVersion = property.getProperty("platform_version");
		platformName = property.getProperty("platform_name");
		platform = property.getProperty("platform");
		oncloud = property.getProperty("oncloud");
		onmobile = property.getProperty("onmobile");
		local_chromebrowser = property.getProperty("local_chrome_browser");
		local_chrome = property.getProperty("local_chrome");
		localtestFF = property.getProperty("localtestFF");
		localFF = property.getProperty("local_Fifefox_browser");
		local_IE11browser = property.getProperty("local_IE11_browser");
		local_IE11 = property.getProperty("local_IE11");

		// on source lab setup
		AppURL = property.getProperty("App_url");
		System.out.println("Bname=====" + AppURL);

		// if (browser.equalsIgnoreCase("chrome"))

		if ((local_chrome.equals("yes"))) {
			local_chromebrowser = System.setProperty(CommonData.Chrome_Name, CommonData.Chrome_Path);
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--disable-notifications");
			driver = new ChromeDriver(options);
			driver.manage().window().maximize();
			// if (browser.equalsIgnoreCase("firefox"))
		} else if ((localtestFF.equals("yes"))) {

			FirefoxProfile profile = new FirefoxProfile();
		profile.setPreference("dom.webnotifications.enabled", false);
	   driver = new FirefoxDriver();
	   Thread.sleep(1000);
			

		}
		// if (browser.equalsIgnoreCase("IE11"))

		else if ((local_IE11.equals("yes"))) {
			/*** To run desktop project on local */
			local_IE11browser = System.setProperty(CommonData.IE_Name, CommonData.IE_Path);
			driver = new InternetExplorerDriver();
	

			// if (browser.equalsIgnoreCase("mobile"))
		} else if ((onmobile.equals("yes")) && oncloud.equals("no")) {
			DesiredCapabilities cab = new DesiredCapabilities();
			cab.setCapability("deviceName", "ZW2223XXGX");
			cab.setCapability("platformName", "Android");
			cab.setCapability("platformVersion", "7.1.1");
			cab.setBrowserName("chrome");

//			driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"), cab);
//			Thread.sleep(2000);

		} else if ((oncloud.equals("yes"))) {
			AppURL = property.getProperty("base_url");
			System.out.println("Bname=====" + AppURL);
			DesiredCapabilities capability = new DesiredCapabilities();
			capability.setCapability("platform", platform);
			capability.setBrowserName(browserName);
			capability.setCapability("version", platformVersion);
			capability.setCapability("name", "Automation tests");
			driver = new RemoteWebDriver(new URL(sauceURL), capability);

		}

		else {
			
			System.out.println("test");
			browserName = System.getenv("SELENIUM_BROWSER");
			platform = System.getenv("SELENIUM_PLATFORM");
			platformVersion = System.getenv("SELENIUM_VERSION");
			System.out.println("after run");

		}

	}
	

	@AfterClass

	public static void after_Class() throws InterruptedException {

		driver.quit();
		Thread.sleep(2000);
	}
}
