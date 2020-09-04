package batch.orangehrm;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class Activity_10 {
 WebDriver driver;
	@Test
  public void f() {
  }
  @BeforeMethod
  public void beforeMethod() {
	  driver= new FirefoxDriver();
		driver.get("http://alchemy.hguy.co/orangehrm");
		WebElement txtUsername = driver.findElement(By.id("txtUsername"));
		WebElement txtPassword = driver.findElement(By.id("txtPassword"));
      txtUsername.sendKeys("orange");
      txtPassword.sendKeys("orangepassword123");
      driver.findElement(By.id("btnLogin")).click();
      driver.findElement(By.id("menu_recruitment_viewRecruitmentModule")).click();
  driver.findElement(By.id("menu_recruitment_viewJobVacancy")).click();
  driver.findElement(By.id("btnAdd")).click();
  Select jobtitle= new Select(driver.findElement(By.id("addJobVacancy_jobTitle")));
  jobtitle.selectByVisibleText("Automation Test Engineer");
  driver.findElement(By.id("addJobVacancy_name")).sendKeys("Test3");
  driver.findElement(By.id("addJobVacancy_hiringManager")).sendKeys("Ajay Singh");
  driver.findElement(By.id("btnSave")).click();
  driver.findElement(By.id("menu_recruitment_viewJobVacancy")).click();
  
 Select jobtitle1 = new Select(driver.findElement(By.id("vacancySearch_jobTitle")));
 jobtitle1.selectByIndex(2);
 String JobTitle=driver.getTitle();
 Assert.assertEquals("Automation Test Engineer" , JobTitle);
 System.out.println("Matched text is found");
  System.out.println("Activity_10 is done");
  }
  @AfterMethod
  public void afterMethod() {
	  driver.close();
	  
  }

}
