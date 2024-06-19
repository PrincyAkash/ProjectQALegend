package test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import Pages.HomePage;
import Pages.LoginPage;
import Pages.UsersPage;
import automationcore.Base;
import constants.Constants;
import utilities.ExcelUtility;



public class Users extends Base {
	
@Test
	
	public void verifySearchByField()
	{
	String username  = ExcelUtility.readStringData(0, 0, Constants.USERS_PAGE);
    String password  = ExcelUtility.readIntegerData(0, 1, Constants.USERS_PAGE);
    String expected_mailid = ExcelUtility.readStringData(0, 2,Constants.USERS_PAGE);
    String expected_name = ExcelUtility.readStringData(0, 3,Constants.USERS_PAGE);
    
    
	LoginPage login  = new LoginPage(driver);
    login.enterUserName(username);
    login.enterPassword(password);
    login.clickOnLoginButton();
    HomePage homepage = new HomePage(driver);
    homepage.applicationTourPopupBoxClose();
    homepage.clickOnUserManagementbutton();
    homepage.clickOnUsersbutton();
    UsersPage userpage = new UsersPage(driver);
    userpage.enterSearchValue(expected_name);
    String actual_name = userpage.getTextOfName();
    Assert.assertEquals(actual_name, expected_name,"Search field not fuctioning as Expected");
    }
}
