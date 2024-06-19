package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EditUserPage 
{
	
	WebDriver driver;
	public EditUserPage(WebDriver driver) 
	{
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath="//div[@class='form-group']//input[@id='email']")
	WebElement edituseremailid;
	 
	@FindBy(xpath = "//input[@id='surname']")
	WebElement surname_field;
	
	 
    @FindBy(xpath = "//button[@id='submit_user_button']")
    WebElement submit_button;
		
	
	public  String getTextofEmailIdEditUser() 
	{
		String text =  edituseremailid.getText();
		return text;
	}
	
	
	public  void updatesurnamefield() 
	{
		surname_field.sendKeys("Mr");
	}
	
	public  void clickOnSubmitButton() 
	{
		submit_button.click();
	}

}
