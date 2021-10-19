package Githubscripts;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import util.XLUtility;

public class github_DataDrivenTest {
	WebDriver driver;
@BeforeClass
	public void setup() {
		System.setProperty("webdriver.chrome.driver","D:\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}
@Test(dataProvider="LoginData")
	public void loginTest(String user,String pwd,String exp)  {
		driver.get("https://admin-demo.nopcommerce.com/login");
	//webelement for username	
		WebElement txtEmail=driver.findElement(By.id("Email"));
		txtEmail.clear();
		txtEmail.sendKeys(user);
	//webelement for password	
		WebElement txtPassword=driver.findElement(By.id("Password"));
		txtPassword.clear();
		txtPassword.sendKeys(pwd);
	//Login  button
		driver.findElement(By.xpath("/html/body/div[6]/div/div/div/div/div[2]/div[1]/div/form/div[3]/button")).click();
	//verification
		String exp_title="Dashboard / nopCommerce administration";
		String act_title=driver.getTitle();
		if(exp.equals("Valid")) {
			if(exp_title.equals(act_title)){
				driver.findElement(By.linkText("Logout")).click();
				Assert.assertTrue(true);
			}
			else{
				Assert.assertTrue(false);
			}
		}
		else if(exp.equals("Invalid"))  {
			if(exp_title.equals(act_title)) {
				driver.findElement(By.linkText("Logout")).click();
				Assert.assertTrue(false);
			}
			else  {
				Assert.assertTrue(true);
			}
		}
	}
@DataProvider(name="LoginData")
	public String [][] getData() throws IOException
	{
	/*String loginData[][]= {
								{"admin@yourstore.com","admin","Valid"},
								{"admin@yourstore.com","adm","Invalid"},
								{"adm@yourstore.com","admin","Invalid"},
								{"adm@yourstore.com","adm","Invalid"}
							};*/	
//get the data from excel
		String path=".\\Testdatafiles\\LoginData.xlsx";
		XLUtility xlutil=new XLUtility(path);
//row count column cell count		
		int totalrows=xlutil.getRowCount("Sheet1");
		int totalcols=xlutil.getCellCount("Sheet1",1);	
//two dimensional array	
		String loginData[][]=new String[totalrows][totalcols];			
		for(int i=1;i<=totalrows;i++) //1 
			{
			for(int j=0;j<totalcols;j++) //0
			{
				loginData[i-1][j]=xlutil.getCellData("Sheet1", i, j);
			}		
		}		
		return loginData;
	}
@AfterClass
	void tearDown() {
		driver.close();
	}	
}