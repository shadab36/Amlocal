package TestRunner;

import java.io.FileReader;
import java.util.Properties;
import java.util.logging.Logger;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import webApp.CommonData;
public class SetupClass {
	public static WebDriver driver;
	public static String AppURL;
	public static Properties property = new Properties(System.getProperties());
	public static String sauceURL;
	public static String browserName;
	public static Logger log;
	public static String Seleniumdriver;
	public static WebElement webelement;
	public static String localtestFF;
	public static String localFF;
	public static String local_IE11browser;
	public static String local_IE11;
	public static String Local_Edge;
	public static String Local_Edge_browser;
	public static String local_chromebrowser;
	public static String local_chrome;

	@BeforeClass
	public static void before_Class() throws Exception {
		log = Logger.getLogger(BeforeClass.class.getName());
	
		property.load(new FileReader("C:\\Users\\AL Moin Webtech\\AutoSlideTeam\\Amlocal\\src\\main\\resources\\configure.properties"));
		AppURL = property.getProperty("App_url");
		Local_Edge = property.getProperty("Local_Edge");
		Local_Edge_browser=property.getProperty("Local_Edge_browser");
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
			Thread.sleep(500);
			// if (browser.equalsIgnoreCase("firefox"))
		} else if ((localtestFF.equals("yes"))) {

			localFF = System.setProperty(CommonData.Firefox_Name, CommonData.Firefox_Path);
			FirefoxProfile profile = new FirefoxProfile();
			profile.setPreference("dom.webnotifications.enabled", false);
		   driver = new FirefoxDriver();
		   Thread.sleep(1000);
//		FirefoxProfile fp = new FirefoxProfile();
//		   fp.setPreference("webdriver.load.strategy", "unstable");
//		   WebDriver driver = new FirefoxDriver(fp);	

		}
		// on saucelabs

		else if ((local_IE11.equals("yes"))) {
			AppURL = property.getProperty("base_url");
			
			
			local_IE11browser = System.setProperty(CommonData.IE_Name, CommonData.IE_Path);
//			InternetExplorerOptions ieOptions = new InternetExplorerOptions();
//			ieOptions.setPageLoadStrategy(PageLoadStrategy.EAGER);
//			driver = new InternetExplorerDriver(ieOptions);
			
			DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
			//Tried without and without this capability, still same result.
			capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
			capabilities.setCapability(InternetExplorerDriver.IE_ENSURE_CLEAN_SESSION, true);
			driver = new InternetExplorerDriver();
			
	
		}
		else if ((Local_Edge.equals("yes"))) {
			AppURL = property.getProperty("base_url");
			
			
			local_IE11browser = System.setProperty(CommonData.Edge_Name, CommonData.Edge_Path);
			driver = new EdgeDriver();

		}
		else {
			AppURL = property.getProperty("base_url");
	
	System.out.println("platform does not provide");
		
			
			
		}
	
	}

	

	@AfterClass
	public static void after_Class() throws InterruptedException {
		driver.quit();
		Thread.sleep(2000);
	}


}

