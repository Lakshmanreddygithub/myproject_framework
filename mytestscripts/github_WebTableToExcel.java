package Githubscripts;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import util.XLUtility;

public class github_WebTableToExcel {
	public static void main(String[] args) throws IOException {
//prerequisites for browser launch
		System.setProperty("webdriver.chrome.driver","D:\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();
//url
		driver.get("https://en.wikipedia.org/wiki/List_of_countries_and_dependencies_by_population");
//xlutility which has methods to read,write,get data from excel
		String path=".\\Testdatafiles\\GetiingWebtabledatafromapplication.xlsx";
		XLUtility xlutil=new XLUtility(path);
//Write headers in excel sheet
		xlutil.setCellData("Sheet1", 0,0, "Country");
		xlutil.setCellData("Sheet1", 0,1, "Region");
		xlutil.setCellData("Sheet1", 0,2, "Population");
		xlutil.setCellData("Sheet1", 0,3, "% of world");
		xlutil.setCellData("Sheet1", 0,4, "Date");
		xlutil.setCellData("Sheet1", 0,5, "Source");
		xlutil.setCellData("Sheet1", 0,6, "Notes");
//capture table rows
	//web element for web table
		WebElement samplewebtable =driver.findElement(By.xpath("//*[@id=\"mw-content-text\"]/div[1]/table/tbody"));
		int rows=samplewebtable.findElements(By.xpath("tr")).size(); // rows present in web table
		System.out.println("number of rows in webtable is:"+rows);	
//for loop to iterate through the web table rows
		for(int r=2;r<=rows;r++) {
//read data from web table
			String country=samplewebtable.findElement(By.xpath("tr["+r+"]/td[1]")).getText();
			String Region=samplewebtable.findElement(By.xpath("tr["+r+"]/td[2]")).getText();
			String population=samplewebtable.findElement(By.xpath("tr["+r+"]/td[3]")).getText();
			String perOfWorld=samplewebtable.findElement(By.xpath("tr["+r+"]/td[4]")).getText();
			String date=samplewebtable.findElement(By.xpath("tr["+r+"]/td[5]")).getText();
			String source=samplewebtable.findElement(By.xpath("tr["+r+"]/td[6]")).getText();
			//System.out.println(country+population+perOfWorld+date+source);			
	//writing the data in excel sheet
			xlutil.setCellData("Sheet1", r, 0, country);
			xlutil.setCellData("Sheet1", r, 1, Region);
			xlutil.setCellData("Sheet1", r, 2, population);
			xlutil.setCellData("Sheet1", r, 3, perOfWorld);
			xlutil.setCellData("Sheet1", r, 4, date);
			xlutil.setCellData("Sheet1", r, 5, source);
		}		
		System.out.println("Web scrapping is done succesfully.....");
		driver.close();		
	}
}

