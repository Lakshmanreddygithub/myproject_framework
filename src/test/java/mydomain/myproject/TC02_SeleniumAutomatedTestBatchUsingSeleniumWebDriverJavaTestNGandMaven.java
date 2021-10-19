package mydomain.myproject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TC02_SeleniumAutomatedTestBatchUsingSeleniumWebDriverJavaTestNGandMaven {
	
  public static WebDriver driver;
		
@BeforeMethod
		public void launchBrowser(){
		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
		driver =new ChromeDriver();
		driver.manage().window().maximize();
		}

@Test (priority=1)
		public void launchApplication(){
		driver.get("http://www.demo.guru99.com/V4/");
		Assert.assertEquals("Guru99 Bank Home Page", driver.getTitle());
		}

@Test (priority=2)
		public void verifyElements(){
		driver.get("http://www.demo.guru99.com/V4/");
		Assert.assertEquals(true, driver.findElement(By.name("btnLogin")).isDisplayed());
		//Assert.assertEquals(true, driver.findElement(By.linkText("create an account")).isDisplayed());
		}

		/*
		 * @Test(priority=3) public void customerRegistartion() throws
		 * InterruptedException{ driver.get("http://www.demo.guru99.com/V4/");
		 * driver.findElement(By.name("gender")).click();
		 * driver.findElement(By.name("firstname")).sendKeys("abcdef");
		 * driver.findElement(By.name("lastname")).sendKeys("xyza");
		 * driver.findElement(By.name("dob")).sendKeys("10/10/1990");
		 * driver.findElement(By.name("email_address")).sendKeys(
		 * "satyajamal123e@gmail.com");
		 * driver.findElement(By.name("street_address")).sendKeys("abc xyz");
		 * driver.findElement(By.name("postcode")).sendKeys("12345");
		 * driver.findElement(By.name("city")).sendKeys("Hyderabad");
		 * driver.findElement(By.name("state")).sendKeys("Telangana");
		 * 
		 * //dropdown field import select package Select dropdown=new
		 * Select(driver.findElement(By.name("country")));
		 * dropdown.selectByVisibleText("India");
		 * 
		 * driver.findElement(By.name("telephone")).sendKeys("9876545456");
		 * driver.findElement(By.name("password")).sendKeys("abcd4321");
		 * driver.findElement(By.name("confirmation")).sendKeys("abcd4321");
		 * driver.findElement(By.id("tdb4")).click(); Thread.sleep(5000);
		 * Assert.assertEquals("Your Account Has Been Created!",
		 * driver.findElement(By.tagName("h1")).getText()); }
		 */

@Test (priority=3)
		public void login() throws InterruptedException{
	//open website
	driver.get("http://www.demo.guru99.com/V4/");
	//provide credentials
	driver.findElement(By.name("uid")).sendKeys("mngr355941");
	driver.findElement(By.name("password")).sendKeys("UdymAgU");	
	//click login
	driver.findElement(By.name("btnLogin")).click();
			Thread.sleep(1000);	
		Assert.assertEquals(true, driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr[2]/td/marquee")).isDisplayed());
		}
@AfterMethod
		public void closeBrowser(){
		driver.close();
		
		}
  
}



	