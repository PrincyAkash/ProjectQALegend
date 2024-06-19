package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddUserPage 
 {
	WebDriver driver;
    public AddUserPage(WebDriver driver)
	 {
	  this.driver = driver;
	   PageFactory.initElements(driver,this);
	 }
    
    @FindBy(xpath ="//a[@class='btn btn-block btn-primary']//i[@class='fa fa-plus']")
    WebElement add_button;
    
    @FindBy (id="first_name")
    WebElement first_namefield;
     
    @FindBy(id="last_name")
    WebElement last_namefield ;
    
    @FindBy(id="email")
    WebElement email_id ;
    
    @FindBy(id="username")
    WebElement username_fieldnewuser;
    
    @FindBy(id="password")
    WebElement password1 ;
    
    @FindBy(id="confirm_password")
    WebElement confirm_password;
     
    @FindBy(id ="submit_user_button")
    WebElement save_button;
    
    @FindBy(className = "toast-success")
    WebElement success_message;
    
   
    
    public void clickOnAddUserButton() 
    {
    	add_button.click();
    }
   
    public void addFirstname(String firstname) 
    {
    	first_namefield.sendKeys(firstname);
    }
   
    public void addLastname(String lastname) 
    {
    	last_namefield.sendKeys(lastname);
    }
   
    public void addEmail(String email) 
    {
    	email_id.sendKeys(email);
    }

    public void addUserName(String username) 
    {
    	
        username_fieldnewuser.sendKeys(username);
    }
    
    public void addpassword(String password) 
    {
    	password1.sendKeys(password);
    }
    
    public void addConfirmpassword(String confirmpassword) 
    {
    	confirm_password.sendKeys(confirmpassword);
    }
    
    public void clickOnSubmitButton() 
    {
    	save_button.click();
    }
     
    
 }
