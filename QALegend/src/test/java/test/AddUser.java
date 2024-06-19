package test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import Pages.AddUserPage;
import Pages.HomePage;
import Pages.LoginPage;
import Pages.UsersPage;
import automationcore.Base;
import constants.Constants;
import listeners.RetryAnalyzer;

import utilities.ExcelUtility;
import utilities.RandomDataUtility;
import utilities.WaitUtility;

 public class AddUser extends Base
	{
	  //Random Data Generator 
		@Test(retryAnalyzer = RetryAnalyzer.class)
		
		public void verifyAddingUser() 
		{
			String username = ExcelUtility.readStringData(0, 0, Constants.ADD_USER );
			String password = ExcelUtility.readIntegerData(0, 1, Constants.ADD_USER);
			String first_name = RandomDataUtility.getFirstName();
			String last_name = RandomDataUtility.getLastName();
			String mailid = first_name+Constants.DOT+last_name+ Constants.MAILID_EXTENSION;
			String username_fieldnew = first_name;
			String password_new = first_name+Constants.DOT+last_name;
			String search_value = mailid;
			
			LoginPage login = new LoginPage(driver);
			login.enterUserName(username);
		    login.enterPassword(password);
		    login.clickOnLoginButton();
		    HomePage homepage = new HomePage(driver);
		    homepage.applicationTourPopupBoxClose();
		    homepage.clickOnUserManagementbutton();
		    homepage.clickOnUsersbutton();
		    AddUserPage adduser = new AddUserPage(driver);
		    adduser.clickOnAddUserButton();
		    adduser.addFirstname(first_name);
		    adduser.addLastname(last_name);
		    adduser.addEmail(mailid);
		    adduser.addUserName(username_fieldnew);
		    adduser.addpassword(password_new);
		    adduser.addConfirmpassword(password_new);
		    adduser.clickOnSubmitButton();
		    UsersPage userpage = new UsersPage(driver);
	        userpage.enterSearchValue(search_value);
	        Assert.assertEquals("User added successfully","User added successfully", "User  not successfully added");
	    }
		
		
	@Test(retryAnalyzer = RetryAnalyzer.class)
	public void verifyUserLoginWithNewAddedUser() 
		{
		    String username = ExcelUtility.readStringData(0, 0, Constants.ADD_USER);
		    String password = ExcelUtility.readIntegerData(0, 1, Constants.ADD_USER);
			String first_name = RandomDataUtility.getFirstName();
			String last_name = RandomDataUtility.getLastName();
			String mailid = first_name+Constants.DOT+last_name+Constants.MAILID_EXTENSION;
			String password_new = first_name+Constants.DOT+last_name;
			String username_fieldnew = first_name;
			String expected_result = Constants.Welcome_MSG+first_name+Constants.COMMA;
			
			LoginPage login = new LoginPage(driver);
			login.enterUserName(username);
		    login.enterPassword(password);
		    login.clickOnLoginButton();
		    HomePage homepage = new HomePage(driver);
		    homepage.applicationTourPopupBoxClose();
		    homepage.clickOnUserManagementbutton();
		    homepage.clickOnUsersbutton();
		    AddUserPage adduser = new AddUserPage(driver);
		    adduser.clickOnAddUserButton();
		    adduser.addFirstname(first_name);
		    adduser.addLastname(last_name);
		    adduser.addEmail(mailid);
		    adduser.addUserName(username_fieldnew);
		    adduser.addpassword(password_new);
		    adduser.addConfirmpassword(password_new);
		    adduser.clickOnSubmitButton();
		    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("toast-success")));
	      // WaitUtility.waitforElementToBeInvisible(driver, null);
		    homepage.clickOnSignoutDashBoad();
	        homepage.clickOnSignoutButton();
	        LoginPage loginpage = new LoginPage(driver);
	        loginpage.enterUserName(username_fieldnew);
	        loginpage.enterPassword(password_new);
		    loginpage.clickOnLoginButton();
		    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[starts-with(text(), 'Welcome')]")));
		    String actual_result = homepage.getTextofProfile();
		    Assert.assertEquals(actual_result, expected_result,Constants.NEWUSERLOGIN_ERROR);
		    
		}
	
	
	@Test(retryAnalyzer = RetryAnalyzer.class)
	public void verifyDeleteingNewlyAddedUser() 
		{
		    String username = ExcelUtility.readStringData(0, 0, Constants.ADD_USER);
		    String password = ExcelUtility.readIntegerData(0, 1, Constants.ADD_USER);
			String first_name = RandomDataUtility.getFirstName();
			String last_name = RandomDataUtility.getLastName();
			String mailid = first_name+Constants.DOT+last_name+Constants.MAILID_EXTENSION;
			String password_new = first_name+Constants.DOT+last_name;
			String username_fieldnew = first_name;
			String search_value = mailid;
			
			LoginPage login = new LoginPage(driver);
			login.enterUserName(username);
		    login.enterPassword(password);
		    login.clickOnLoginButton();
		    HomePage homepage = new HomePage(driver);
		    homepage.applicationTourPopupBoxClose();
		    homepage.clickOnUserManagementbutton();
		    homepage.clickOnUsersbutton();
		    AddUserPage adduser = new AddUserPage(driver);
		    adduser.clickOnAddUserButton();
		    adduser.addFirstname(first_name);
		    adduser.addLastname(last_name);
		    adduser.addEmail(mailid);
		    adduser.addUserName(username_fieldnew);
		    adduser.addpassword(password_new);
		    adduser.addConfirmpassword(password_new);
		    adduser.clickOnSubmitButton();
		    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("toast-success")));
		    UsersPage userpage = new UsersPage(driver);
		    userpage.enterSearchValue(search_value);
	        userpage.clickDeleteButtoun();
	        userpage.clickOkButtoun();
	        Assert.assertEquals("User deleted successfully","User deleted successfully", "Deletion not successful");
	}
	
}
