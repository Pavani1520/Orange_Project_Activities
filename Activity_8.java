package batch.orangehrm;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;

public class Activity_8 {
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
  public void f() {
  driver.findElement(By.id("menu_dashboard_index")).click();
  driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div[2]/div[1]/div/div/div/fieldset/div/div/table/tbody/tr/td[4]/div/a/img")).click();
  Select leavetype= new Select(driver.findElement(By.id("applyleave_txtLeaveType")));
  leavetype.selectByVisibleText("Paid Leave");
  driver.findElement(By.id("applyleave_txtFromDate")).clear();
  WebElement fromdate = driver.findElement(By.id("applyleave_txtFromDate"));
  fromdate.sendKeys("2020-08-15");
  driver.findElement(By.id("applyleave_txtToDate")).clear();
  WebElement todate=driver.findElement(By.id("applyleave_txtToDate"));
  todate.sendKeys("2020-08-17");
  driver.findElement(By.id("applyBtn")).submit();
  Actions act = new Actions(driver);
  WebElement myleave = driver.findElement(By.id("menu_leave_viewMyLeaveList"));
  act.moveToElement(myleave).click().build().perform();
  System.out.println("Activity_8 is done");
  }
  @AfterMethod
  public void afterMethod() {
	  driver.close();
  }

}
