package batch.orangehrm;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;

public class Activity_7 {
	WebDriver driver;
	
  @BeforeMethod
  public void beforeMethod() {
	  driver= new FirefoxDriver();
		driver.get("http://alchemy.hguy.co/orangehrm");
		WebElement txtUsername = driver.findElement(By.id("txtUsername"));
		WebElement txtPassword = driver.findElement(By.id("txtPassword"));
      txtUsername.sendKeys("orange");
      txtPassword.sendKeys("orangepassword123");
      driver.findElement(By.id("btnLogin")).click();
  }
  @Test
   public void mainTest() {
	  WebElement myinfo=driver.findElement(By.xpath("//*[@id=\"menu_pim_viewMyDetails\"]"));
      myinfo.click();
      Actions action = new Actions(driver); 
      WebElement Qualifications=driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div[1]/ul/li[9]/a"));
      Qualifications.click();
     action.moveToElement(Qualifications).click().perform();  
      driver.findElement(By.id("addWorkExperience")).click();
      driver.findElement(By.id("experience_employer")).sendKeys("IBM");
      driver.findElement(By.id("experience_jobtitle")).sendKeys("Test Specialist");
      driver.findElement(By.id("btnWorkExpSave")).click();
      }
  @AfterMethod
  public void afterMethod() {
	  System.out.println("Activity_7 is completed");
  driver.close();
  }
  

}

