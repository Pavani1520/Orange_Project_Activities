package batch.orangehrm;

import org.testng.annotations.BeforeMethod;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;

public class Activity_6 {
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
	        driver.findElement(By.id("menu_directory_viewDirectory")).click();
	        String actualTxt = driver.findElement(By.xpath("//a[contains(@class,'toggle tiptip')]")).getText();
	        String expectedTxt= "Search Directory" ;
	        Assert.assertEquals(actualTxt, expectedTxt);
	        System.out.println("expectedTxt is :" +expectedTxt);
           }
  @AfterMethod
  public void afterMethod() {
	  driver.close();
  }

}
