package batch.orangehrm;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;

public class Activity_11 {
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
    driver.findElement(By.id("menu_recruitment_viewRecruitmentModule")).click();
    driver.findElement(By.id("menu_recruitment_viewCandidates")).click();
    driver.findElement(By.id("btnAdd")).click();
    driver.findElement(By.id("addCandidate_firstName")).sendKeys("Ruhani");
    driver.findElement(By.id("addCandidate_lastName")).sendKeys("Sharma");
    driver.findElement(By.id("addCandidate_email")).sendKeys("sruhani12@gmail.com");
   WebElement resume= driver.findElement(By.id("addCandidate_resume"));
   resume.sendKeys("C:\\Users\\EemaniPavani\\Desktop\\Orange resume.docx");
    driver.findElement(By.id("btnSave")).click();  
    driver.findElement(By.id("menu_recruitment_viewCandidates")).click();    
    Select hiringmanger = new Select(driver.findElement(By.id("candidateSearch_hiringManager")));
    hiringmanger.selectByIndex(1);
    driver.findElement(By.id("btnSrch")).click();
   }
  public void f() {
  System.out.println("Activity_11 is done");
  }
  

  @AfterMethod
  public void afterMethod() {
	  driver.close();
  }

}
