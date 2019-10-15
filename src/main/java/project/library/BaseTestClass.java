package project.library;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import project.utils.Email_Send;

public class BaseTestClass  {

	public static Map<String, WebDriver> drivers = new HashMap<String, WebDriver>();

	public static ExtentTest logger;
	public static ExtentReports report = new ExtentReports(System.getProperty("user.dir")+ "\\Report\\ReportSummary.html");
	
	String excelpath = ".//src//main//resources//Test Cases ExcelSheet//DP Test Cases.xlsx";
				
	public static JavascriptExecutor jse;
	
	protected static WebDriver driver;	
	String browsername = "Chrome";
	
	@BeforeSuite() 
	public WebDriver getBrowser () {		
	
		try {
			switch (browsername) {
			case "Firefox":
				driver = drivers.get("Firefox");
				if (driver == null) {
					driver = new FirefoxDriver();
					drivers.put("Firefox", driver);
				}
				break;
			case "IE":
				driver = drivers.get("IE");
				if (driver == null) {

					DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
					capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,
							true);
					System.setProperty("webdriver.ie.driver", "N:\\QA\\R&DQA\\Selenium\\Drivers\\IEDriverServer.exe");
					driver = new InternetExplorerDriver(capabilities);
					drivers.put("IE", driver);

				}
				break;
			case "Chrome":
				driver = drivers.get("Chrome");
				if (driver == null) {
					System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\drivers\\chromedriver.exe");
					
					driver = new ChromeDriver();
					driver.manage().window().maximize();
					drivers.put("Chrome", driver);
					
				}
				break;

			case "ChromeOptions":
				driver = drivers.get("ChromeOptions");
				if (driver == null) {
					System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\drivers\\chromedriver.exe");							
					
					ChromeOptions cOptions = new ChromeOptions();
					cOptions.addExtensions(new File("MultiPass-for-HTTP-basic-authentication_v0.7.4.crx"));
					driver = new ChromeDriver(cOptions);
					driver.manage().window().maximize();
					drivers.put("ChromeOptions", driver);
				}
				break;
			}	
					
		}			

		catch (Exception ex) {
			ex.printStackTrace();
		}
		return driver; 
		
	}

	@AfterSuite(enabled = true)
	public void teardown() {
		
		driver.quit();		
		Email_Send sendreport = new Email_Send();
		sendreport.sendEmail(excelpath);
		
	}
	
	/*public static WebDriver getDriver() {
		return driver;
	}*/
}
