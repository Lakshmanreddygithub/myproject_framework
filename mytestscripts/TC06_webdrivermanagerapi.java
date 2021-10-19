package testscripts;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
public class TC06_webdrivermanagerapi {
	public static void main(String[] args) {
// firefox browser
		// WebDriverManager.firefoxdriver().setup();
		// WebDriver driver=new FirefoxDriver();
// edge browser
		// WebDriverManager.edgedriver().setup();
		// WebDriver driver=new EdgeDriver();
// chrome browser
				WebDriverManager.chromedriver().setup();
				WebDriver driver = new ChromeDriver();
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);		
	//url - maximize 
		driver.get("https://frontend.nopcommerce.com");		
		  driver.manage().window().maximize();
		  System.out.println("title is : "+driver.getTitle());
		  System.out.println("current url is : "+driver.getCurrentUrl());		
		// System.out.println("pagesource is : "+driver.getPageSource());
		 driver.get("https://www.sakshi.com");
		driver.get("https://www.amazon.com");
		driver.navigate().to("https://www.sakshi.com");
		 driver.navigate().back();
		 driver.navigate().forward();
		 driver.navigate().refresh();
// single webelement
		WebElement searchstore=driver.findElement(By.xpath("//*[@id=\"small-searchterms\"]"));
		searchstore.sendKeys("return single webelement");
		// return element
WebElement footerupperelements=driver.findElement(By.xpath("/html/body/div[6]/div[4]/div[1]//a"));
		System.out.println(footerupperelements.getText());
// find elements get links in the footer and print the names
		  driver.get("https://demo.nopcommerce.com"); List<WebElement>
		  multiplewebelementslinks=driver.findElements(By.xpath(
		  "//div[@class='footer-upper']//a"));
		  System.out.println("number of links :"+multiplewebelementslinks.size());		  
		  for(WebElement linksnames :multiplewebelementslinks ) {		  
		  System.out.println(linksnames.getText());		  		  
		  }	 
	}
}
