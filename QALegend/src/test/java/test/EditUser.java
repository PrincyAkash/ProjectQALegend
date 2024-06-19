package test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import Pages.EditUserPage;
import Pages.HomePage;
import Pages.LoginPage;
import Pages.UsersPage;
import automationcore.Base;
import constants.Constants;

import utilities.ExcelUtility;

public class EditUser extends Base
{

	@Test
	public void editAnExistingUser() 
	{
		String username  = ExcelUtility.readStringData(0, 0, Constants.USERS_PAGE);
	    String password  = ExcelUtility.readIntegerData(0, 1, Constants.USERS_PAGE);
	    String search_value = ExcelUtility.readStringData(0, 2, Constants.USERS_PAGE);
	    
		LoginPage login  = new LoginPage(driver);
	    login.enterUserName(username);
	    login.enterPassword(password);
	    login.clickOnLoginButton();
	    HomePage homepage = new HomePage(driver);
	    homepage.applicationTourPopupBoxClose();
	    homepage.clickOnUserManagementbutton();
	    homepage.clickOnUsersbutton();
        UsersPage userpage = new UsersPage(driver);
        userpage.enterSearchValue(search_value);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//i[@class='glyphicon glyphicon-edit']")));
        userpage.clickEditButtoun();
        EditUserPage edituser = new EditUserPage(driver);
        edituser.updatesurnamefield();
        edituser.clickOnSubmitButton();
        Assert.assertEquals("User updated successfully","User updated successfully", "Update not successful");
        
        
	}
}
