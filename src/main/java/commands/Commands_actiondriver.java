package commands;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import com.aventstack.extentreports.MediaEntityBuilder;
import config.launchbrowser;

public class Commands_actiondriver {
	WebDriver driver;	
//create constructor for the class	
	public Commands_actiondriver() {		
		driver = launchbrowser.driver;		
	}		
//Create commands code below for navigate and for click and for type 	
	//For url
	public void navigatetoapplication(String url) {		
		try {
			driver.get(url);
			launchbrowser.childTest.pass("Successfully navigated to application :"+url);			
		} catch (Exception e) {
			launchbrowser.childTest.fail("unable to navigate to application :"+url);
		}	
	}
	//for clicking
	public void click(By locator, String eleName) throws Exception {	
		try {
			driver.findElement(locator).click();
			launchbrowser.childTest.pass("click operation success :"+ eleName);	
		} catch (Exception e) {
			launchbrowser.childTest.fail("click operation failed :"+ eleName,
					MediaEntityBuilder.createScreenCaptureFromBase64String(screenShot()).build());
			launchbrowser.childTest.info(e);
			throw e;			
		}		
	}	
	//for typing
	public void type(By locator, String text, String eleName) throws Exception {			
		try {
			driver.findElement(locator).sendKeys(text);
			launchbrowser.childTest.pass("typed in  success :"+eleName+"With data :"+text);
		} catch (Exception e) {			
			launchbrowser.childTest.fail("unable to type :"+eleName+"With data :"+text,
					MediaEntityBuilder.createScreenCaptureFromBase64String(screenShot()).build());
			launchbrowser.childTest.info(e);
			throw e;
		}	
	}	
	public String screenShot() {
		return ((TakesScreenshot)driver).getScreenshotAs(OutputType.BASE64);		
	}
	
}

