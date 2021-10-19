package testscripts;

import org.testng.annotations.Test;

import config.launchbrowser;
import reusable_functions.BusinessFunctionsClass;

public class TC03_Fundtransferguru99 extends launchbrowser {
  @Test
  public void testcase_fundtransfer() throws Exception {
	  BusinessFunctionsClass Bfunctions=new BusinessFunctionsClass();
	  Bfunctions.login();
	  Bfunctions.fundtransfer();
	  Bfunctions.logout();  
  }
}

