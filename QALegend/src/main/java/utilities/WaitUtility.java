package utilities;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtility 
{
	public static final long IMPLICIT_WAIT = 10;
	public static final long  EXPLICIT_WAIT = 20;
	public static final long PAGELOAD_WAIT = 20;
	
    
	
  public static void waitUsingImplicitWait(WebDriver driver) 
  {
	 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(IMPLICIT_WAIT)) ;
  }
  
  public static void waitforElement(WebDriver driver,WebElement target) 
  {
	  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_WAIT));
	  wait.until(ExpectedConditions.visibilityOf(target));
  }
  
	
  public static void waitForElementToBeClickable(WebDriver driver, WebElement element)
  {
	  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_WAIT));
	  wait.until(ExpectedConditions.elementToBeClickable(element));
  }
  
  public static void waitforElementUsingFluentWait(WebDriver driver,WebElement element) 
  {
	  FluentWait <WebDriver> wait = new FluentWait<WebDriver> (driver).withTimeout(Duration.ofSeconds(PAGELOAD_WAIT)).pollingEvery(Duration.ofSeconds(PAGELOAD_WAIT)).ignoring(NoSuchElementException.class);
	  wait.until(ExpectedConditions.elementToBeClickable(element));
  }
  
  
  
  
  
  public static void waitforElementToBeInvisible(WebDriver driver, WebElement element) 
  {
	  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_WAIT));
	  wait.until(ExpectedConditions.invisibilityOf(element));
  }
  
	
}
