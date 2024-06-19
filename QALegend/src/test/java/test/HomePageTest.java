package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import Pages.HomePage;
import Pages.LoginPage;
import automationcore.Base;
import constants.Constants;
import constants.Messages;

import utilities.ExcelUtility;


  public class HomePageTest extends Base 
   {
	  @Test(groups = "Sanity")
	  public void getPageTitle() 
		{
		    String username = ExcelUtility.readStringData(0, 0,Constants.HOME_PAGE);
		    String password = ExcelUtility.readIntegerData(0, 1, Constants.HOME_PAGE);
		    String expected_title = ExcelUtility.readStringData(0, 2, Constants.HOME_PAGE);
		    
		    LoginPage login = new LoginPage(driver);
		    login.enterUserName(username);
		    login.enterPassword(password);
		    HomePage home =  login.clickOnLoginButton();
		    String actual_title = home.getActualTitle();
		    System.out.println("The title of the page is " +actual_title);
			Assert.assertEquals(actual_title, expected_title,Messages.TITLE_MISMATCH);
		}
	  
	  @Test(groups = "Regression" )
		
		public void verifyUserLoginDate() 
		{

		    String username = ExcelUtility.readStringData(0, 0, Constants.HOME_PAGE);
		    String password = ExcelUtility.readIntegerData(0, 1, Constants.HOME_PAGE);
		    
		    LoginPage login = new LoginPage(driver);
		    login.enterUserName(username);
		    login.enterPassword(password);
		    HomePage home =  login.clickOnLoginButton();
			String  date_fieldtext = home.getLoginDate();
			String system_date = home.getCurrentDate();
            Assert.assertEquals(date_fieldtext, system_date,Messages.DATE_MISMATCH);
		}
	  
	  @Test
	  
	  public void getCaluculatorResult() 
	  {
		    String username = ExcelUtility.readStringData(0, 0,Constants.HOME_PAGE );
		    String password = ExcelUtility.readIntegerData(0, 1,Constants.HOME_PAGE);
		    String expected_result = ExcelUtility.readIntegerData(0, 3,Constants.HOME_PAGE);
		    
		    LoginPage login = new LoginPage(driver);
		    login.enterUserName(username);
		    login.enterPassword(password);
		    login.clickOnLoginButton();
		    HomePage homepage = new HomePage(driver);
		    homepage.applicationTourPopupBoxClose();
		    homepage.getCalculatorfield();
		    String result_new = homepage.getSumofTwoNumbers();
		    System.out.println("The result is " +result_new);
		    Assert.assertEquals(result_new, expected_result, Messages.CALUCLTOR_ERROR);
		    
		}
   }
	  
	  
	  
	  
	 
	  
	  
	 
	  
	  