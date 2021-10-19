package reusable_functions;

import org.openqa.selenium.WebDriver;

import commands.Commands_actiondriver;
import config.launchbrowser;
import objectrepository_OR.Elements_Fundtransfer;
import objectrepository_OR.Elements_Homepage;
import objectrepository_OR.Loginpage_Elements;

//Creating reusable business functions

public class BusinessFunctionsClass {
	WebDriver driver;
	Commands_actiondriver cadriver;
	
//creating constructor for the class
	public BusinessFunctionsClass() {	
		driver =launchbrowser.driver;
		cadriver=new Commands_actiondriver();	
	}
// login reusable function/method here login is the method
	
	public void login() throws Exception {
		launchbrowser.childTest=launchbrowser.parentTest.createNode("Login to application");
		cadriver.navigatetoapplication("http://www.demo.guru99.com/V4/");
		cadriver.type(Loginpage_Elements.txtusername,"mngr355941","UserName");
		cadriver.type(Loginpage_Elements.txtpassword,"UdymAgU","password");
		cadriver.click(Loginpage_Elements.btnlogin,"login button");	
	}
//logout function
	public void logout() throws Exception {
		launchbrowser.childTest=launchbrowser.parentTest.createNode("Logout from application");
	cadriver.click(Elements_Homepage.linklogout, "logout link");		
	}
//fund transfer function
	public void fundtransfer() throws Exception {		
		launchbrowser.childTest=launchbrowser.parentTest.createNode("Fund transfer");		
		cadriver.click(Elements_Fundtransfer.linkfundtransfer, "fundtransfer link");
		cadriver.type(Elements_Fundtransfer.text_payersaccountno, "12345", "payer account no");
		cadriver.type(Elements_Fundtransfer.text_payeeaccountno, "123456789", "payee account no");
		cadriver.type(Elements_Fundtransfer.text_Amount, "123456789", "amount to deposit");
		cadriver.type(Elements_Fundtransfer.text_Description, "fundtransfer test case", "desc fundtransfer");
		cadriver.click(Elements_Fundtransfer.Btn_Submit, "submit button");	
	}
}

