package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	WebDriver driver;
	
	  public LoginPage(WebDriver driver) // constructor ..calling with reference of this
	  {
		this.driver = driver; 
		PageFactory.initElements(driver,this); // PageFactory class @findby annotation
	  }
	  
	  @FindBy(xpath="//input[@id='username']")
	  WebElement username_field;
	  
	  @FindBy(id="password")
	  WebElement password_field;
	  
	  @FindBy(xpath = "//button[@type='submit']")
	  WebElement login_button;
	  
	  @FindBy(xpath = "//span[@class='help-block']")
	  WebElement error_message;
	  
	  @FindBy(xpath = "//a[@class='btn btn-link']")
	  WebElement forgot_password;
	  
	  public void enterUserName(String username) 
	  {
		username_field.sendKeys(username);  
		  
	  }
	  
	  public void enterPassword(String password)
	  {
		  password_field.sendKeys(password);
	  }
	  
	  public HomePage clickOnLoginButton() 
	  {
		login_button.click();
		return new HomePage(driver);
		 
	  }
	  
	  public String getInvalidLoginUserText() 
	  {
	  String user = error_message.getText();
	  return user;
	  }
	  
	  public ResetPage forgotPasswordelement() 
	  {
		forgot_password.click();
		return new ResetPage(driver);
		  
	  }
	  
}
