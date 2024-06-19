package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import Pages.LoginPage;
import Pages.ResetPage;
import automationcore.Base;
import constants.Constants;
import constants.Messages;

import utilities.ExcelUtility;



	
  public class ResetPageTest extends Base
	{
       @Test
		public void verifyForgotpasswordWithInvalidEmailid() 
		{
		    String emailid = ExcelUtility.readStringData(0, 0,Constants.RESET_PAGE);
		    String expected_text = ExcelUtility.readStringData(0, 1, Constants.RESET_PAGE) ;
		    
		    LoginPage login = new LoginPage(driver);
		    login.forgotPasswordelement();
		    ResetPage reset = new ResetPage(driver);
		    reset.getEmailidField(emailid);
	        reset.clickpasswordreset_button();
	        String actual_text = reset.getTextmsgOfResetmailfail();
	        Assert.assertEquals(actual_text, expected_text,Messages.ERROR_MSGMISMATCH);
		 }
	
     @Test
	  public void verifyForgotpasswordWithValidEmailid() 
	   {
		   String valid_emailid = ExcelUtility.readStringData(0, 2,Constants.RESET_PAGE);
		   String expected_text = ExcelUtility.readStringData(0, 3,Constants.RESET_PAGE);
		   
		   LoginPage login = new LoginPage(driver);
		   login.forgotPasswordelement();
		   ResetPage reset = new ResetPage(driver);
		   reset.getEmailidField(valid_emailid);
	       reset.clickpasswordreset_button();
	       String actual_text = reset.getTextmsgOfResetmailsuccess();
	       Assert.assertEquals(actual_text, expected_text,Messages.SUCCESS_MSGMISMATCH);
	   }
	}