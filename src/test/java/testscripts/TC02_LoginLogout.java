package testscripts;

import org.testng.annotations.Test;

import config.launchbrowser;
import reusable_functions.BusinessFunctionsClass;

public class TC02_LoginLogout extends launchbrowser {
  @Test
 public void login_logout() throws Exception {
	  BusinessFunctionsClass Bfunctions= new BusinessFunctionsClass();
	  Bfunctions.login();  
	  //Bfunctions.logout();
  }
}


