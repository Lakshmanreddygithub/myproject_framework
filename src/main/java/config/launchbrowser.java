package config;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import io.github.bonigarcia.wdm.WebDriverManager;
import util.ConfiguratorSupport;

import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;

public class launchbrowser {
	
  	public static WebDriver driver;
	ExtentHtmlReporter htmlreporter;
	public static ExtentReports extent;
	public static ExtentTest parentTest;
	public static ExtentTest childTest;
	//ConfiguratorSupport cs=new ConfiguratorSupport("config.properties");
	
@BeforeTest

	public void report() {		
		htmlreporter = new ExtentHtmlReporter("Reports/MyResult.html");
		extent = new ExtentReports();
		extent.attachReporter(htmlreporter);}

@BeforeMethod

	public void method(Method method) {
		parentTest = extent.createTest(method.getName());	}

 @BeforeClass
 
  public void beforeClass() {		
		/*
		 * if (cs.getProperty("browser").equals("chrome")) {
		 * WebDriverManager.chromedriver().setup(); driver = new ChromeDriver();
		 * driver.manage().window().maximize();
		 * driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS)
		 * 
		 * } else if (cs.getProperty("browser").equals("firefox")) {
		 * WebDriverManager.firefoxdriver().arch64().setup(); driver = new
		 * FirefoxDriver(); driver.manage().window().maximize();
		 * driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS) } else {
		 * System.out.println("provide a valid browser"); }
		 */
//browser info 
	  WebDriverManager.chromedriver().setup();
	  driver = new ChromeDriver();
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);   
 }
 
  @AfterClass
  
  public void afterClass() {
	 driver.quit(); 
	 extent.flush();
}

}




