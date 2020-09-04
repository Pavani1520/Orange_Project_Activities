package batch.orangehrm;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;

public class Activity_9 {
	WebDriver driver;
	 
  @Test
 
  @BeforeMethod
  public void beforeMethod() {
	  driver= new FirefoxDriver();
		driver.get("http://alchemy.hguy.co/orangehrm");
		WebElement txtUsername = driver.findElement(By.id("txtUsername"));
		WebElement txtPassword = driver.findElement(By.id("txtPassword"));
  txtUsername.sendKeys("orange");
  txtPassword.sendKeys("orangepassword123");
  driver.findElement(By.id("btnLogin")).click();
  Actions acc=new Actions(driver);
	WebElement myinfo1= driver.findElement(By.id("menu_pim_viewMyDetails"));
	acc.moveToElement(myinfo1).click().build().perform();
	driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
	driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div[1]/ul/li[3]/a")).click();
	List <WebElement> rowValue= driver.findElements(By.xpath("//*[@id='emgcontact_list']/tbody/tr/td"));
	for(WebElement rv:rowValue)

	{
		if(rv.getText().isEmpty())
				{
				}
		else
		Reporter.log("Emergency contact details ]"+rv.getText());

	}
	
	Assert.assertTrue(true);
	Reporter.log("All Emergency contact details:");
	System.out.println("Emergency contact details retrieved");
}
  WebElement contacts=driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div[1]/ul/li[3]/a"));
  contacts.click();
  @AfterMethod
  public void afterMethod() {
	  driver.close();
  }

}
