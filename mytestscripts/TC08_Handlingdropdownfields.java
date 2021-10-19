package testscripts;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import io.github.bonigarcia.wdm.WebDriverManager;
public class TC08_Handlingdropdownfields {
	public static void main(String[] args) {
//browserdriver setup
	WebDriverManager.chromedriver().setup();
	WebDriver driver=new ChromeDriver();
	driver.get("https://www.opencart.com/index.php?route=account/register");
//country dropdown			
	WebElement dropdowncountry =driver.findElement(By.id("input-country"));	
	Select mydropdowncountry = new Select(dropdowncountry);		
	//mydropdowncountry.selectByIndex(20);
	//mydropdowncountry.selectByValue("30");
	//mydropdowncountry.selectByVisibleText("France");
//without methods using loop to select value from the drop down
	List <WebElement> alloptionsfromdropdown=mydropdowncountry.getOptions();
	for (WebElement options : alloptionsfromdropdown) {			
		if (options.getText().equals("India")) {
			options.click();
			break;
			}
	}	
	}
}
